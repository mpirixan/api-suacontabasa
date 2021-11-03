package br.com.bancoamazonia.api.suacontabasa.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.bancoamazonia.api.suacontabasa.domain.model.Conta;


@Repository
public interface ContaRepository extends CrudRepository<Conta, Long>{

	//public Conta findByIdPessoa(Long idPessoa);
	
	public Conta findByAgencia(Long agencia);

	public Conta getOne(Long id);
	
	public Conta findByIdConta(Long idConta);
	
	@Modifying
	@Query(value = "UPDATE CONTA c SET  c.saldo = c.saldo - ?1 WHERE c.idConta = ?2", nativeQuery = true)
	void setFixedSaldo(Double saldo, Long idConta);

}
