package br.com.bancoamazonia.api.suacontabasa.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.com.amazoniafw.base.exceptions.displayable.BusinessException;
import br.com.bancoamazonia.api.suacontabasa.domain.enums.StatusContaEnum;
import br.com.bancoamazonia.api.suacontabasa.domain.model.Conta;
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
	
	public Pessoa findByNome(String nome) {
		Pessoa pessoa = repository.findByNome(nome);
		if(pessoa == null) {
			throw new BusinessException("Não foi possivel localizar a pessoa com nome "+nome);
		}
		return pessoa;
	}
	
	@Transactional
	public Pessoa insert(Pessoa obj) {
		Conta conta = new Conta();
		conta.setStatus(StatusContaEnum.DESATIVADO);
		obj.setConta(conta);
		return repository.save(obj);
	}

	@Transactional
	public Pessoa delete(Long idPessoa) {
		Pessoa entity = repository.findByIdPessoa(idPessoa);
		repository.delete(entity);
		return null;
	
}
	}
