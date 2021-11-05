package br.com.bancoamazonia.api.suacontabasa.controller.dto;

import java.io.Serializable;
import java.util.Objects;

import io.swagger.v3.oas.annotations.media.Schema;

public class ContaResponse implements Serializable {

	private static final long serialVersionUID = -2259094710454561830L;
	@Schema(description = "pessoa - pessoa relacionada a conta")
	private PessoaResponse idPessoa;
	
	@Schema(description = "pessoa - pessoa(fiscal) relacionada a conta")
	private PessoaResponse idFiscal;
	
	public PessoaResponse getIdPessoa() {
		return idPessoa;
	}

	public PessoaResponse getIdFiscal() {
		return idFiscal;
	}

	@Schema(description = "idConta - identificador único da Conta")
	private Long idConta;
	
	@Schema(description = "agencia - identificador agencia da Conta")
	private Long agencia;
	
	@Schema(description = "status - status da conta")
	private String status;
	
	@Schema(description = "senha - senha da conta")
	private String senha;

	@Schema(description = "saldo - Saldo da Conta")
	private Double saldo;
	
	@Override
	public int hashCode() {
		return Objects.hash(agencia, idConta);
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
		return Objects.equals(agencia, other.agencia) && Objects.equals(idConta, other.idConta);
	}

	public Long getIdConta() {
		return idConta;
	}

	public void setIdConta(Long idConta) {
		this.idConta = idConta;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
