package br.com.bancoamazonia.api.suacontabasa.manager;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.com.amazoniafw.base.exceptions.displayable.BusinessException;
import br.com.bancoamazonia.api.suacontabasa.controller.dto.CadastroContaResponse;
import br.com.bancoamazonia.api.suacontabasa.domain.enums.StatusContaEnum;
import br.com.bancoamazonia.api.suacontabasa.domain.model.Conta;
import br.com.bancoamazonia.api.suacontabasa.domain.model.Pessoa;
import br.com.bancoamazonia.api.suacontabasa.repository.ContaRepository;

@Component
@Validated
public class ContaManager {
	

	@Autowired
	private ContaRepository repository;
	
	
	@Autowired
	private PessoaManager pessoaManager;
	
	@PersistenceContext
	private EntityManager entityManager;
	

	
	@Transactional
	public List<Conta> findAll(){
		return (List<Conta>) repository.findAll();
	}

	public Conta findByIdConta(Long idConta) {
		Conta conta = repository.findByIdConta(idConta);
		if(conta == null) {
			throw new BusinessException(String.format("Não foi possivel localizar a conta "+idConta));
		}
		return conta;
	}
	
	
	public Conta findById(Long pessoa) {
		Pessoa idPessoa = pessoaManager.findByIdPessoa(pessoa);
		Long idConta = repository.obterIdConta(idPessoa.getIdPessoa());
		Conta conta = repository.findByIdConta(idConta);

		return  conta;

	}

	@Transactional
	public Conta cadastro(Long idPessoa, CadastroContaResponse obj) {
		if (repository.obterIdConta(idPessoa) != null){
			throw new BusinessException(String.format("Pessoa com id %s  já possui conta cadastrada! ",idPessoa));
		}
		Date dataLocal = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dataLocal);
		c.add(Calendar.YEAR, 5);	
		Date dataVigencia = c.getTime();
		Pessoa pessoa = pessoaManager.findByIdPessoa(idPessoa);
		Conta conta = new Conta();
		conta.setAgencia(obj.getAgencia());
		conta.setSenha(obj.getSenha());
		conta.setDataVigencia(dataVigencia);
		conta.setTipoConta(obj.getTipoConta());
		conta.setSaldo(00.00);
		conta.setStatus(StatusContaEnum.ATIVA);
		conta.setPessoa(pessoa);
		return repository.save(conta);
	}

	public void depositoSaldo(Long idConta, Double obj) {
		Conta entity = repository.findByIdConta(idConta);
		if (entity.getStatus() != StatusContaEnum.ATIVA) {
			throw new BusinessException(("Conta " + idConta+ " não está Ativa! "));
		}
		else {
		repository.setDepositoSaldo(obj, idConta);
		}
	}
	
	public void saqueSaldo(Long idConta, Double obj) {
		Conta entity = repository.findByIdConta(idConta);
		if (obj >= entity.getSaldo()) {
			throw new BusinessException(("Saldo insuficiente! "));
		}		
		else {
		repository.setSaqueSaldo(obj, idConta);
		}
	}
	

	
	@Transactional
	public Conta delete(Long idConta) {
		Conta conta = repository.findByIdConta(idConta);
		if(conta == null) {
			throw new BusinessException(("Conta Inexistente! "));
		}
		if(conta.getStatus() != StatusContaEnum.ATIVA) {
			throw new BusinessException(("Conta Já se encontra Desativada! "));
		}
		if (conta.getSaldo() != 0) {
			throw new BusinessException(("Deixe o Saldo da Conta em R$00.00! "));
		}
		else {
			conta.setStatus(StatusContaEnum.DESATIVADO);	
		}
		return null;
	}
	
	public Double obterSaldoIdConta(Long idConta) {
		Conta conta = repository.findByIdConta(idConta);
		if (conta == null) {
			throw new BusinessException(("Conta Inexistente! "));
		}
		if (conta != null && conta.getStatus() != StatusContaEnum.ATIVA) {
			throw new BusinessException(("Conta Desativada! "));
		}
		else {
			return repository.obterSaldoIdConta(idConta);
		}
	}
	
	@Transactional
	public Double obterSaldoPorIdFiscal (Long idFiscal) {
		Pessoa idPessoa = pessoaManager.findByIdFiscal(idFiscal);
		Long idConta = repository.obterIdConta(idPessoa.getIdPessoa());
		Conta conta = repository.findByIdConta(idConta);
		if (conta == null) {
			throw new BusinessException(("Conta Inexistente! "));
		}
		if (conta != null && conta.getStatus() != StatusContaEnum.ATIVA) {
			throw new BusinessException(("Conta Desativada! "));
		}
		else {
			return  repository.obterSaldoIdConta(idConta);
		}
	}
	

}
