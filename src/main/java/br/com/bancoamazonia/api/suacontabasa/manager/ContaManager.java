package br.com.bancoamazonia.api.suacontabasa.manager;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import br.com.amazoniafw.base.exceptions.displayable.BusinessException;
import br.com.bancoamazonia.api.suacontabasa.domain.model.Conta;
import br.com.bancoamazonia.api.suacontabasa.repository.ContaRepository;


@Component
@Validated
public class ContaManager {

	@Autowired
	private ContaRepository repository;
	
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
	public Conta findByAgencia(Long agencia) {
		Conta conta = repository.findByAgencia(agencia);
		if(conta == null) {
			throw new BusinessException("Não foi possivel localizar a pessoa com Cpf/Cnpj "+agencia);
		}
		return conta;
	}
	
	public Conta update(Long id, Conta obj) { 
		try {
		Conta entity = repository.getOne(id);
		updateDados(entity, obj);
		updateSaldo(entity, obj);
		return repository.save(entity);
		}catch (EntityNotFoundException e) {
			throw new BusinessException(("Não foi possivel localizar a pessoa com identificação "+ id));
		}
	}
	
	private void updateDados(Conta entity, Conta obj) {
		entity.setAgencia(obj.getAgencia());
		entity.setStatus(obj.getStatus());
		
		
	}
	
	private void updateSaldo(Conta entity, Conta obj) {
		entity.setSaldo(obj.getSaldo());

	}

	public Conta insert(Conta obj) {
		return repository.save(obj);
	}

	public Conta delete(Long idConta, Conta conta) {
		Conta entity = repository.findByIdConta(idConta);
		repository.delete(entity);
		return null;
	}

	
}
