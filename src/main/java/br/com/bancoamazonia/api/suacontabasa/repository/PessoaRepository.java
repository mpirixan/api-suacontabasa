package br.com.bancoamazonia.api.suacontabasa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.bancoamazonia.api.suacontabasa.domain.model.Pessoa;


@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Long>{

	public Pessoa findByIdPessoa(Long idPessoa);
	
	public Pessoa findByIdFiscal(Long idFiscal);

	public Pessoa getOne(Long id);

	
	// insert in json
	/* {
	  "idFiscal": 12345678,
	  "nome": "André Matos",
	  "dataNascimento": "1984-08-14T13:42:56.151Z",
	  "tipoPessoa": "FISICA"
	} 
	*/
}
