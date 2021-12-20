package br.com.bancoamazonia.api.suacontabasa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.bancoamazonia.api.suacontabasa.controller.dto.ContaResponse;
import br.com.bancoamazonia.api.suacontabasa.domain.model.Conta;

@Transactional
@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>{

	
	public Conta findByIdConta(Long idConta);
	
	public Conta save(ContaResponse conta);
	
	
	// SQL - Queries

	@Modifying
	@Query("update Conta c set  c.saldo = c.saldo - ?1 where c.idConta = ?2")
	void setSaqueSaldo(Double saldo, Long idConta);
	
	@Modifying
	@Query("update Conta c set  c.saldo = c.saldo + ?1 where c.idConta = ?2")
	void setDepositoSaldo(Double saldo, Long idConta);
	
	@Query(value = "select conta from Pessoa p where p.idPessoa = :idPessoa", nativeQuery=true)
	public Long obterIdConta(@Param("idPessoa")Long idPessoa);
	
	@Query(value = "SELECT CONTA.SALDO FROM CONTA LEFT JOIN PESSOA ON PESSOA.IDPESSOA = CONTA.IDPESSOA WHERE PESSOA.NUM_CPF_CNPJ = :idFiscal", nativeQuery=true)
	public Double obterSaldoIdPessoa(@Param("idFiscal")Long idFiscal);
	
	@Query("select saldo from Conta c where c.idConta = :idConta")
	public Double obterSaldoIdConta(@Param("idConta")Long idConta);

}
