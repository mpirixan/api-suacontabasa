package br.com.bancoamazonia.api.suacontabasa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.bancoamazonia.api.suacontabasa.domain.model.Pessoa;


@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Long>{

	public Pessoa findByIdPessoa(Long idPessoa);
	
	public Pessoa findByIdFiscal(Long idFiscal);

	public Pessoa getOne(Long id);


	@Query(value = "select * from PESSOA p where p.num_cpf_cnpj = :idFiscal", nativeQuery=true)
	public Pessoa consultarPessoaCPF(@Param("idFiscal")Long idFiscal);
	
	@Query(value = "select * from PESSOA c where c.NOME = :nome", nativeQuery=true)
	public Pessoa consultarPessoaNome(@Param("nome")String nome);
}
