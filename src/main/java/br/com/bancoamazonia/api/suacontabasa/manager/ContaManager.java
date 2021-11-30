package br.com.bancoamazonia.api.suacontabasa.manager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.com.amazoniafw.base.exceptions.displayable.BusinessException;
import br.com.bancoamazonia.api.suacontabasa.domain.enums.StatusContaEnum;
import br.com.bancoamazonia.api.suacontabasa.domain.model.Conta;
import br.com.bancoamazonia.api.suacontabasa.domain.model.Pessoa;
import br.com.bancoamazonia.api.suacontabasa.repository.ContaRepository;
import br.com.bancoamazonia.api.suacontabasa.repository.PessoaRepository;

@Component
@Validated
public class ContaManager {

	@Autowired
	private ContaRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	

	
	@Transactional
	public List<Conta> findAll(){
		return (List<Conta>) repository.findAll();
	}

	public Conta findByIdConta(Long idConta) {
		Conta conta = repository.findByIdConta(idConta);
		if(conta == null) {
			throw new BusinessException("Não foi possivel localizar a conta "+idConta);
		}
		return conta;
	}
	
	
	public Conta findById(Long pessoa) {
		Pessoa idPessoa = pessoaRepository.findByIdPessoa(pessoa);
		Long idConta = repository.obterIdConta(idPessoa.getIdPessoa());
		Conta conta = repository.findByIdConta(idConta);
		if(conta == null) {
			throw new BusinessException("Não foi possivel localizar a pessoa com idPessoa "+pessoa);
		}
		else {
		return  conta;
	}

	}


	/* // Inserção com Corpo JSON
	@Transactional
	public void cadastro(ContaResponse conta) {
		entityManager.createNativeQuery("insert into CONTA (PESSOA_IDPESSOA ,AGENCIA, DATAVIGENCIA, SALDO, SENHA, STATUS, TIPOCONTA) values (?,?,?,?,?,?,?)")
		.setParameter(1, conta.getIdPessoa())
		.setParameter(2, conta.getAgencia())
		.setParameter(3, conta.getDataVigencia())
		.setParameter(4, conta.getSaldo())
		.setParameter(5, conta.getSenha())
		.setParameter(6, conta.getStatus())
		.setParameter(7, conta.getTipoConta())
		.executeUpdate();
	}
	*/

	@Transactional
	public Conta cadastro(Conta obj) {
		return repository.save(obj);
		   
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
		Pessoa idPessoa = pessoaRepository.findByIdFiscal(idFiscal);
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
