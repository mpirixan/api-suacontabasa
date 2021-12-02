package br.com.bancoamazonia.api.suacontabasa.controller.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import br.com.bancoamazonia.api.suacontabasa.domain.enums.TipoContaEnum;
import io.swagger.v3.oas.annotations.media.Schema;

public class CadastroContaResponse implements Serializable{

	private static final long serialVersionUID = 1399392304940041785L;
	
	@Schema(description = "agencia - identificador agencia da Conta")
	private Long agencia;
	
	@Schema(description = "senha - senha da conta")
	private String senha;

	@Schema(description = "Data vigencia")
	private Date dataVigencia;
	
	@Schema(description = "Tipo de Conta")
	private TipoContaEnum tipoConta;

	@Override
	public int hashCode() {
		return Objects.hash(senha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CadastroContaResponse other = (CadastroContaResponse) obj;
		return Objects.equals(senha, other.senha);
	}

	public Long getAgencia() {
		return agencia;
	}

	public void setAgencia(Long agencia) {
		this.agencia = agencia;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDataVigencia() {
		return dataVigencia;
	}

	public void setDataVigencia(Date dataVigencia) {
		this.dataVigencia = dataVigencia;
	}

	public TipoContaEnum getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoContaEnum tipoConta) {
		this.tipoConta = tipoConta;
	}
	
	
}
