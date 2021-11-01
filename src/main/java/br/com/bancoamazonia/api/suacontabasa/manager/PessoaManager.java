package br.com.bancoamazonia.api.suacontabasa.manager;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.com.amazoniafw.base.exceptions.displayable.BusinessException;
import br.com.bancoamazonia.api.suacontabasa.domain.model.Pessoa;
import br.com.bancoamazonia.api.suacontabasa.repository.ContaRepository;
import br.com.bancoamazonia.api.suacontabasa.repository.PessoaRepository;

@Service
@Validated
public class PessoaManager {

	@Autowired
	private PessoaRepository repository;
	
	private ContaRepository contaRepository;
	
	public List<Pessoa> findAll(){
		return (List<Pessoa>) repository.findAll();
	}

	public Pessoa findByIdPessoa(Long idPessoa) {
		Pessoa pessoa = repository.findByIdPessoa(idPessoa);
		if(pessoa == null) {
			throw new BusinessException("Não foi possivel localizar a pessoa com matricula cadastral "+idPessoa);
		}
		return pessoa;
	}
	
	public Pessoa findByIdFiscal(Long idFiscal) {
		Pessoa pessoa = repository.findByIdFiscal(idFiscal);
		if(pessoa == null) {
			throw new BusinessException("Não foi possivel localizar a pessoa com Cpf/Cnpj "+idFiscal);
		}
		return pessoa;
	}
	
	@Transactional
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
		
	}

	@Transactional
	public Pessoa insert(Pessoa obj) {
		return repository.save(obj);
	}

	@Transactional
	public Pessoa delete(Long idPessoa, Pessoa pessoa) {
		Pessoa entity = repository.findByIdPessoa(idPessoa);
		repository.delete(entity);
		return null;
	
}
	}
