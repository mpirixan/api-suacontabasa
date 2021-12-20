package br.com.bancoamazonia.api.suacontabasa.manager;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.com.bancoamazonia.api.suacontabasa.manager.exceptions.GlobalDefaultExceptionHandler;
import br.com.bancoamazonia.api.suacontabasa.controller.dto.CadastroContaRequest;
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
			throw new GlobalDefaultExceptionHandler();
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
	public Conta cadastro(Long idFiscal, CadastroContaRequest obj) {
		if (repository.obterIdConta(idFiscal) != null){
			throw new GlobalDefaultExceptionHandler();
		}
		LocalDate dataAtual = LocalDate.now();
		Conta conta = new Conta();
		conta.setAgencia(obj.getAgencia());
		conta.setDataVigencia(dataAtual.plusYears(5));
		conta.setDataInicioRelacionamento(dataAtual);
		conta.setTipoConta(obj.getTipoConta());
		conta.setSaldo(00.00);
		conta.setStatus(StatusContaEnum.ATIVA);
		Pessoa pessoa = pessoaManager.findByIdFiscal(idFiscal);
		pessoa.setConta(conta);
		return repository.save(conta);
	}

	public void depositoSaldo(Long idConta, Double obj) {
		Conta entity = repository.findByIdConta(idConta);
		if (entity.getStatus() != StatusContaEnum.ATIVA) {
			throw new GlobalDefaultExceptionHandler();
		}
		else {
		repository.setDepositoSaldo(obj, idConta);
		}
	}
	
	public void saqueSaldo(Long idConta, Double obj) {
		Conta entity = repository.findByIdConta(idConta);
		if (obj >= entity.getSaldo()) {
			throw new GlobalDefaultExceptionHandler();
		}		
		else {
		repository.setSaqueSaldo(obj, idConta);
		}
	}
	

	
	@Transactional
	public Conta delete(Long idConta) {
		Conta conta = repository.findByIdConta(idConta);
		if(conta == null) {
			throw new GlobalDefaultExceptionHandler();
		}
		if(conta.getStatus() != StatusContaEnum.ATIVA) {
			throw new GlobalDefaultExceptionHandler();
		}
		if (conta.getSaldo() != 0) {
			throw new GlobalDefaultExceptionHandler();
		}
		else {
			conta.setStatus(StatusContaEnum.DESATIVADO);	
		}
		return null;
	}
	
	public Double obterSaldoIdConta(Long idConta) {
		Conta conta = repository.findByIdConta(idConta);
		if (conta == null) {
			throw new GlobalDefaultExceptionHandler();
		}
		if (conta != null && conta.getStatus() != StatusContaEnum.ATIVA) {
			throw new GlobalDefaultExceptionHandler();
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
			throw new GlobalDefaultExceptionHandler();
		}
		if (conta != null && conta.getStatus() != StatusContaEnum.ATIVA) {
			throw new GlobalDefaultExceptionHandler();
		}
		else {
			return  repository.obterSaldoIdConta(idConta);
		}
	}
	

}
