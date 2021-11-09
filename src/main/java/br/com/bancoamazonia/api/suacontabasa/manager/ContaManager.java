package br.com.bancoamazonia.api.suacontabasa.manager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.com.amazoniafw.base.exceptions.displayable.BusinessException;
import br.com.bancoamazonia.api.suacontabasa.controller.dto.ContaResponse;
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
		if(idConta == null) {
			throw new BusinessException("Não foi possivel localizar a pessoa com Cpf/Cnpj "+idConta);
		}
		return conta;
	}
	
	public Conta findByAgencia(Long agencia) {
		Conta conta = repository.findByAgencia(agencia);
		if(conta == null) {
			throw new BusinessException("Não foi possivel localizar a pessoa com Cpf/Cnpj "+agencia);
		}
		return conta;
	}
	
	@Transactional
	public Conta update(Long idConta, Conta obj) { 
		try {
		Conta entity = repository.findByIdConta(idConta);
		updateDados(entity, obj);

		return repository.save(entity);
		}catch (EntityNotFoundException e) {
			throw new BusinessException(("Não foi possivel localizar a pessoa com identificação "+ idConta));
		}
	}
	private void updateDados(Conta entity, Conta obj) {
		entity.setAgencia(obj.getAgencia());
		entity.setStatus(obj.getStatus());
		
		
	}

	@Transactional
	public Conta services (Long idConta, Double obj) {
		Conta entity = repository.findByIdConta(idConta);
		updateSaldo(entity, obj);
		return repository.save(entity);
	}
	private void updateSaldo(Conta entity, Double obj) {
		//entity.setSaldo(obj);

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
	
	// Inserção com Corpo JSON
	@Transactional
	public void cadastro(ContaResponse conta) {
		entityManager.createNativeQuery("insert into CONTA (IDPESSOA ,AGENCIA, DATA_VIGENCIA, SALDO, SENHA, STATUS, TIPO_CONTA) values (?,?,?,?,?,?,?)")
		.setParameter(1, conta.getIdPessoa())
		.setParameter(2, conta.getAgencia())
		.setParameter(3, conta.getDataVigencia())
		.setParameter(4, conta.getSaldo())
		.setParameter(5, conta.getSenha())
		.setParameter(6, conta.getStatus())
		.setParameter(7, conta.getTipoConta())
		.executeUpdate();
	}
	
	
	@Transactional
	public Conta delete(Long idConta) {
		Conta entity = repository.findByIdConta(idConta);
		repository.delete(entity);
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
	
	
	/*
	@Transactional
	public Double obterSaldoPorIdFiscal (Long idFiscal) {
		Pessoa pessoa = pessoaRepository.findByIdFiscal(idFiscal);
		Conta conta = repository.findByIdPessoa(pessoa.getIdPessoa());
		if (conta == null) {
			throw new BusinessException(("Conta Inexistente! "));
		}
		if (conta != null && conta.getStatus() != StatusContaEnum.ATIVA) {
			throw new BusinessException(("Conta Desativada! "));
		}
		else {
			return  conta.getSaldo();
		}
	}
	
	public Double  obterSaldoPorIdConta(Long idConta) {
		Conta conta = repository.findByIdConta(idConta);
		if (conta == null) {
			throw new BusinessException(("Conta Inexistente! "));
		}
		if (conta != null && conta.getStatus() != StatusContaEnum.ATIVA) {
			throw new BusinessException(("Conta Desativada! "));
		}
		else {
			return conta.getSaldo();
		}
	}
	*/
}
