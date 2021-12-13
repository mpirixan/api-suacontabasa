package br.com.bancoamazonia.api.suacontabasa.repository;


import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.bancoamazonia.api.suacontabasa.domain.model.Pessoa;
import br.com.bancoamazonia.sbs.commons.components.springdatajpa.ExtendedJpaRepository;


@Repository
public interface PessoaRepository extends ExtendedJpaRepository<Pessoa, Long>{

	public Pessoa findByIdPessoa(Long idPessoa);
	
	public Pessoa findByIdFiscal(Long idFiscal);
	
	public List<Pessoa> findByNome(String nome);

	public Pessoa getOne(Long id);



}
