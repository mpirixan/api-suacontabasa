package br.com.bancoamazonia.api.suacontabasa.manager;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import br.com.amazoniafw.base.exceptions.displayable.BusinessException;
import br.com.bancoamazonia.api.suacontabasa.domain.model.Pessoa;
import br.com.bancoamazonia.api.suacontabasa.repository.PessoaRepository;


@Component
@Validated
public class PessoaManager {

	@Autowired
	private PessoaRepository repository;
	
	public List<Pessoa> findAll(){
		return (List<Pessoa>) repository.findAll();
	}

	public Pessoa findByIdPessoa(@NotNull @Positive @Max(value = 999999999) @Valid Long idPessoa) {
		Pessoa conta = repository.findByIdPessoa(idPessoa);
		if(conta == null) {
			throw new BusinessException("Não foi possivel localizar a pessoa com matricula cadastral "+idPessoa);
		}
		return conta;
	}
	/*
	public Pessoa findByIdFiscal(@NotBlank @CpfCnpj @Valid Long idFiscal) {
		Pessoa conta = repository.findByIdFiscal(idFiscal);
		if(conta == null) {
			throw new BusinessException("Não foi possivel localizar a pessoa com Cpf/Cnpj "+idFiscal);
		}
		return conta;
	}
	*/
	public Pessoa findByIdFiscal(Long idFiscal) {
		Pessoa conta = repository.findByIdFiscal(idFiscal);
		if(conta == null) {
			throw new BusinessException("Não foi possivel localizar a pessoa com Cpf/Cnpj "+idFiscal);
		}
		return conta;
	}
	
	public Pessoa update(Long id, Pessoa obj) { 
		try {
		Pessoa entity = repository.getOne(id);
		updateDados(entity, obj);
		return repository.save(entity);
		}catch (EntityNotFoundException e) {
			throw new BusinessException(("Não foi possivel localizar a pessoa com identificação "+ id));
		}
	}
	
	private void updateDados(Pessoa entity, Pessoa obj) {
		entity.setNome(obj.getNome());
		entity.setNome(obj.getNome());
		
		
	}
	

	public Pessoa insert(Pessoa obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
	
}
