package br.com.bancoamazonia.api.suacontabasa.controller.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import io.swagger.v3.oas.annotations.media.Schema;

public class ContaResponse implements Serializable {

	private static final long serialVersionUID = -2259094710454561830L;
	@Schema(description = "pessoa - pessoa relacionada a conta")
	private Long idPessoa;
	
	public Long getIdPessoa() {
		return idPessoa;
	}

	//@Schema(description = "idConta - identificador único da Conta")
	//private Long idConta;
	
	@Schema(description = "agencia - identificador agencia da Conta")
	private Long agencia;
	
	@Schema(description = "status - status da conta")
	private String status;
	
	@Schema(description = "senha - senha da conta")
	private String senha;

	@Schema(description = "saldo - Saldo da Conta")
	private Double saldo;

	@Schema(description = "Data vigencia")
	private Date dataVigencia;

	@Schema(description = "Tipo de Conta")
	private String tipoConta;
	
	public ContaResponse() {
		
	}
	
	public ContaResponse(Long idPessoa, Long agencia, String status, String senha, Double saldo,
			Date dataVigencia, String tipoConta) {
		super();
		this.idPessoa = idPessoa;
		this.agencia = agencia;
		this.status = status;
		this.senha = senha;
		this.saldo = saldo;
		this.dataVigencia = dataVigencia;
		this.tipoConta = tipoConta;
	}

	public Date getDataVigencia() {
		return dataVigencia;
	}

	public void setDataVigencia(Date dataVigencia) {
		this.dataVigencia = dataVigencia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPessoa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaResponse other = (ContaResponse) obj;
		return Objects.equals(idPessoa, other.idPessoa);
	}

	public Long getAgencia() {
		return agencia;
	}

	public void setAgencia(Long agencia) {
		this.agencia = agencia;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return status;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
