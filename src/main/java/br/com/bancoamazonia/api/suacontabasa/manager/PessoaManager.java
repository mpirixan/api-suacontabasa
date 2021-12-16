package br.com.bancoamazonia.api.suacontabasa.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.com.amazoniafw.base.exceptions.displayable.BusinessException;
import br.com.bancoamazonia.api.suacontabasa.controller.dto.CadastroPessoaRequest;
import br.com.bancoamazonia.api.suacontabasa.domain.model.Pessoa;
import br.com.bancoamazonia.api.suacontabasa.repository.PessoaRepository;

@Service
@Validated
public class PessoaManager {

	@Autowired
	private PessoaRepository repository;
	
	
	
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
	/*
	public Pessoa findByNome(String nome) {
		Pessoa pessoa = repository.findByNome(nome);
		if(pessoa == null) {
			throw new BusinessException("Não foi possivel localizar a pessoa com nome "+nome);
		}
		return pessoa;
	}
*/
	public List<Pessoa> findByNome (String nome){
		List<Pessoa> pessoa = repository.findByNome(nome);
		if(pessoa.isEmpty() == true) {
			throw new BusinessException("Não foi possivel localizar a pessoa com nome "+nome);
		}
		return repository.findByNome(nome);
	}
	
	@Transactional
	public Pessoa insert(CadastroPessoaRequest obj) {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(obj.getNome());
		pessoa.setIdFiscal(obj.getIdFiscal());
		pessoa.setDataNascimento(obj.getDataNascimento());
		pessoa.setTipoPessoa(obj.getTipoPessoa());
		pessoa.setEstadoCivil(obj.getEstadoCivil());
		pessoa.setConta(null);
		return repository.save(pessoa);
	}
	@Transactional
	public Pessoa delete(Long idPessoa) {
		Pessoa entity = repository.findByIdPessoa(idPessoa);
		repository.delete(entity);
		return null;
	
}
	}
