package br.com.bancoamazonia.api.suacontabasa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.bancoamazonia.api.suacontabasa.domain.model.Conta;


@Repository
public interface ContaRepository extends CrudRepository<Conta, Long>{

	public Conta findByIdPessoa(Long idPessoa);
	
	public Conta findByIdFiscal(Long idFiscal);

	public Conta getOne(Long id);
}
