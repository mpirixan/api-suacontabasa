package br.com.bancoamazonia.api.suacontabasa.manager;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import br.com.amazoniafw.base.components.validations.beanvalidation.document.CpfCnpj;
import br.com.amazoniafw.base.exceptions.displayable.BusinessException;
import br.com.bancoamazonia.api.suacontabasa.domain.model.Pessoa;
import br.com.bancoamazonia.api.suacontabasa.repository.PessoaRepository;

@Component
@Validated
public class PessoaManager {

	@Autowired
	private PessoaRepository repository;
	

	public Pessoa findByIdPessoa(@NotNull @Positive @Max(value = 999999999) @Valid Long idPessoa) {
		Pessoa pessoa = repository.findByIdPessoa(idPessoa);
		if(pessoa == null) {
			throw new BusinessException("Não foi possivel localizar a pessoa com matricula cadastral "+idPessoa);
		}
		return pessoa;
	}
	
	public Pessoa findByIdFiscal(@NotBlank @CpfCnpj @Valid String idFiscal) {
		Pessoa pessoa = repository.findByIdFiscal(idFiscal);
		if(pessoa == null) {
			throw new BusinessException("Não foi possivel localizar a pessoa com Cpf/Cnpj "+idFiscal);
		}
		return pessoa;
	}
}
