package br.com.bancoamazonia.api.suacontabasa.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.bancoamazonia.api.suacontabasa.domain.model.Conta;

@Transactional
@Repository
public interface ContaRepository extends CrudRepository<Conta, Long>{

	//public Conta findByIdPessoa(Long idPessoa);
	
	public Conta findByAgencia(Long agencia);

	public Conta getOne(Long id);
	
	
	
	@Modifying
	@Query("update Conta c set  c.saldo = c.saldo - ?1 where c.idConta = ?2")
	void setSaqueSaldo(Double saldo, Long idConta);

	public Conta findByIdConta(Long idConta);
	
	@Modifying
	@Query("update Conta c set  c.saldo = c.saldo + ?1 where c.idConta = ?2")
	void setDepositoSaldo(Double saldo, Long idConta);

}
