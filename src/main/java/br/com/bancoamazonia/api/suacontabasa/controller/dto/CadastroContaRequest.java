package br.com.bancoamazonia.api.suacontabasa.controller.dto;

import java.io.Serializable;

import br.com.bancoamazonia.api.suacontabasa.domain.enums.TipoContaEnum;
import io.swagger.v3.oas.annotations.media.Schema;

public class CadastroContaRequest implements Serializable{

	private static final long serialVersionUID = 1399392304940041785L;
	
	@Schema(description = "agencia - identificador agencia da Conta")
	private Long agencia;
	
	@Schema(description = "Tipo de Conta")
	private TipoContaEnum tipoConta;



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agencia == null) ? 0 : agencia.hashCode());
		result = prime * result + ((tipoConta == null) ? 0 : tipoConta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CadastroContaRequest other = (CadastroContaRequest) obj;
		if (agencia == null) {
			if (other.agencia != null)
				return false;
		} else if (!agencia.equals(other.agencia))
			return false;
		if (tipoConta != other.tipoConta)
			return false;
		return true;
	}

	public Long getAgencia() {
		return agencia;
	}

	public void setAgencia(Long agencia) {
		this.agencia = agencia;
	}


	public TipoContaEnum getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoContaEnum tipoConta) {
		this.tipoConta = tipoConta;
	}
	
	
}
