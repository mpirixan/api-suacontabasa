package br.com.bancoamazonia.api.suacontabasa.controller.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import io.swagger.v3.oas.annotations.media.Schema;


public class ContaResponse implements Serializable {

	private static final long serialVersionUID = -2259094710454561830L;
	
	private PessoaResponse pessoa;
	
	
	
	public PessoaResponse getPessoa() {
		return pessoa;
	}


	public void setPessoa(PessoaResponse pessoa) {
		this.pessoa = pessoa;
	}

	@Schema(description = "pessoa - pessoa relacionada a conta")
	private Long idPessoa;
	
	public Long getIdPessoa() {
		return idPessoa;
	}

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
	

	public Date getDataVigencia() {
		return dataVigencia;
	}

	public void setDataVigencia(Date dataVigencia) {
		this.dataVigencia = dataVigencia;
	}


	@Override
	public int hashCode() {
		return Objects.hash(agencia, dataVigencia, idPessoa, saldo, senha, status, tipoConta);
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
		return Objects.equals(agencia, other.agencia) && Objects.equals(dataVigencia, other.dataVigencia)
				&& Objects.equals(idPessoa, other.idPessoa) && Objects.equals(saldo, other.saldo)
				&& Objects.equals(senha, other.senha) && Objects.equals(status, other.status)
				&& Objects.equals(tipoConta, other.tipoConta);
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
