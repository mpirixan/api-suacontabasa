package br.com.bancoamazonia.api.suacontabasa.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.bancoamazonia.api.suacontabasa.controller.dto.ContaResponse;
import br.com.bancoamazonia.api.suacontabasa.domain.model.Conta;

@Transactional
@Repository
public interface ContaRepository extends CrudRepository<Conta, Long>{

	
	public Conta findByAgencia(Long agencia);

	public Conta getOne(Long id);
	
	
	
	@Modifying
	@Query("update Conta c set  c.saldo = c.saldo - ?1 where c.idConta = ?2")
	void setSaqueSaldo(Double saldo, Long idConta);
	

	public Conta findByIdConta(Long idConta);
	
	@Modifying
	@Query("update Conta c set  c.saldo = c.saldo + ?1 where c.idConta = ?2")
	void setDepositoSaldo(Double saldo, Long idConta);

	public Conta save(ContaResponse conta);
	
	@Query(value = "select IdConta from Conta c where c.idPessoa = :idPessoa", nativeQuery=true)
	public Long obterIdConta(@Param("idPessoa")Long idPessoa);
	
	@Query("select c.idConta, c.agencia, c.status, c.dataVigencia, c.tipoConta FROM Conta c WHERE c.idConta = :idConta")
	public String obterPorIdConta(@Param("idConta")Long idConta);

	@Query(value = "SELECT CONTA.SALDO FROM CONTA LEFT JOIN PESSOA ON PESSOA.IDPESSOA = CONTA.IDPESSOA WHERE PESSOA.NUM_CPF_CNPJ = :idFiscal", nativeQuery=true)
	public Double obterSaldoIdPessoa(@Param("idFiscal")Long idFiscal);
	
	@Query("select saldo from Conta c where c.idConta = :idConta")
	public Double obterSaldoIdConta(@Param("idConta")Long idConta);
}
