package br.com.bancoamazonia.api.suacontabasa.manager;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.com.amazoniafw.base.exceptions.displayable.BusinessException;
import br.com.bancoamazonia.api.suacontabasa.domain.model.Conta;
import br.com.bancoamazonia.api.suacontabasa.repository.ContaRepository;

@Component
@Validated
public class ContaManager {

	@Autowired
	private ContaRepository repository;
	
	@Transactional
	public List<Conta> findAll(){
		return (List<Conta>) repository.findAll();
	}
	/*
	public Conta findByIdPessoa(@NotNull @Positive @Max(value = 999999999) @Valid Long idPessoa) {
		Conta conta = repository.findByIdPessoa(idPessoa);
		if(conta == null) {
			throw new BusinessException("Não foi possivel localizar a pessoa com matricula cadastral "+idPessoa);
		}
		return conta;
	}

	public Conta findByIdFiscal(@NotBlank @CpfCnpj @Valid Long idFiscal) {
		Conta conta = repository.findByIdFiscal(idFiscal);
		if(conta == null) {
			throw new BusinessException("Não foi possivel localizar a pessoa com Cpf/Cnpj "+idFiscal);
		}
		return conta;
	}
	*/
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
		updateSaldo(entity, obj);
		saqueSaldo(entity, obj);
		depositoSaldo(entity, obj);
		return repository.save(entity);
		}catch (EntityNotFoundException e) {
			throw new BusinessException(("Não foi possivel localizar a pessoa com identificação "+ idConta));
		}
	}
	
	private void updateDados(Conta entity, Conta obj) {
		entity.setAgencia(obj.getAgencia());
		entity.setStatus(obj.getStatus());
		
		
	}
	
	private void updateSaldo(Conta entity, Conta obj) {
		entity.setSaldo(obj.getSaldo());

	}
	
	private void depositoSaldo(Conta entity, Conta obj) {
		entity.setSaldo(entity.getSaldo() + obj.getSaldo());
	}
	
	private void saqueSaldo(Conta entity, Conta obj) {
		Double saque = obj.getSaldo();
		saque = (entity.getSaldo() - saque);
		entity.setSaldo(saque);
	}
	
	@Transactional
	public Conta insert(Conta obj) {
		return repository.save(obj);
	}

	@Transactional
	public Conta delete(Long idConta, Conta conta) {
		Conta entity = repository.findByIdConta(idConta);
		repository.delete(entity);
		return null;
	}

	
}
