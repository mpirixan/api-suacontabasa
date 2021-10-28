package br.com.bancoamazonia.api.suacontabasa.controller.dto;

import java.io.Serializable;
import java.util.Objects;

import io.swagger.v3.oas.annotations.media.Schema;

public class ContaResponse implements Serializable {

	private static final long serialVersionUID = -2259094710454561830L;

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

	public Long getIdPessoa() {
		return idConta;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idConta = idPessoa;
	}

	public Long getIdFiscal() {
		return agencia;
	}

	public void setIdFiscal(Long idFiscal) {
		this.agencia = idFiscal;
	}

	public String getNome() {
		return status;
	}

	public void setNome(String nome) {
		this.status = nome;
	}

	public String getUltimo_nome() {
		return senha;
	}

	public void setUltimo_nome(String ultimo_nome) {
		this.senha = ultimo_nome;
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
