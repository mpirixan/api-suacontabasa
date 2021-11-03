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
		saqueSaldo(entity, obj);
		depositoSaldo(entity, obj);
		return repository.save(entity);
	}
	private void updateSaldo(Conta entity, Double obj) {
		entity.setSaldo(obj);

	}
	
	private void depositoSaldo(Conta entity, Double obj) {
		entity.setSaldo(entity.getSaldo() + obj);
	}
	
	private void saqueSaldo(Conta entity, Double obj) {
		Double saque = entity.getSaldo();
		Double result;
		result = saque - obj;
		entity.setSaldo(result);
		
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
