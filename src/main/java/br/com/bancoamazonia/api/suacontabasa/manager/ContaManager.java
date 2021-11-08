package br.com.bancoamazonia.api.suacontabasa.manager;

import java.util.Date;
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
		repository.setDepositoSaldo(obj, idConta);
	}
	
	public void saqueSaldo(Long idConta, Double obj) {
		repository.setSaqueSaldo(obj, idConta);
		
	}
	
	@Transactional
	public void insert(Long idPessoa,Long agencia,Date dataVigencia,Double saldo,String senha, String status,String tipoConta ) {
		repository.insertConta(idPessoa,agencia,dataVigencia,saldo,senha,status,tipoConta);
	}

	@Transactional
	public Conta delete(Long idConta) {
		Conta entity = repository.findByIdConta(idConta);
		repository.delete(entity);
		return null;
	}

	
}
