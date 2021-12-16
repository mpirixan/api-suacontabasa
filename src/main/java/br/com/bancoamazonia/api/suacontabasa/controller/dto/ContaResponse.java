package br.com.bancoamazonia.api.suacontabasa.controller.dto;

import java.io.Serializable;
import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;


public class ContaResponse implements Serializable {

	private static final long serialVersionUID = -2259094710454561830L;
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	@Schema(description = "pessoa")
	private PessoaResponse pessoa;
	
	public PessoaResponse getPessoa() {
		return pessoa;
	}


	public void setPessoa(PessoaResponse pessoa) {
		this.pessoa = pessoa;
	}

	@Schema(description = "id - identificador único de linha conta")
	private Long id;
	
	@Schema(description = "idConta - identificador único de conta")
	private Long idConta;

	@Schema(description = "agencia - identificador agencia da Conta")
	private Long agencia;
	
	@Schema(description = "status - status da conta")
	private String status;
	
	@Schema(description = "saldo - Saldo da Conta")
	private Double saldo;

	@Schema(description = "Data vigencia")
	private LocalDate dataVigencia;
	
	@Schema(description = "DAtainicio de relacionamento")
	private LocalDate dataInicioRelacionamento;

	@Schema(description = "Tipo de Conta")
	private String tipoConta;
	
	public ContaResponse() {
		
	}
	

	public Long getIdConta() {
		return idConta;
	}


	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}


	public LocalDate getDataVigencia() {
		return dataVigencia;
	}

	public void setDataVigencia(LocalDate dataVigencia) {
		this.dataVigencia = dataVigencia;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agencia == null) ? 0 : agencia.hashCode());
		result = prime * result + ((dataInicioRelacionamento == null) ? 0 : dataInicioRelacionamento.hashCode());
		result = prime * result + ((dataVigencia == null) ? 0 : dataVigencia.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idConta == null) ? 0 : idConta.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + ((saldo == null) ? 0 : saldo.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		ContaResponse other = (ContaResponse) obj;
		if (agencia == null) {
			if (other.agencia != null)
				return false;
		} else if (!agencia.equals(other.agencia))
			return false;
		if (dataInicioRelacionamento == null) {
			if (other.dataInicioRelacionamento != null)
				return false;
		} else if (!dataInicioRelacionamento.equals(other.dataInicioRelacionamento))
			return false;
		if (dataVigencia == null) {
			if (other.dataVigencia != null)
				return false;
		} else if (!dataVigencia.equals(other.dataVigencia))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idConta == null) {
			if (other.idConta != null)
				return false;
		} else if (!idConta.equals(other.idConta))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (saldo == null) {
			if (other.saldo != null)
				return false;
		} else if (!saldo.equals(other.saldo))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tipoConta == null) {
			if (other.tipoConta != null)
				return false;
		} else if (!tipoConta.equals(other.tipoConta))
			return false;
		return true;
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


	public Double getSaldo() {
		return saldo;
	}


	public LocalDate getDataInicioRelacionamento() {
		return dataInicioRelacionamento;
	}


	public void setDataInicioRelacionamento(LocalDate dataInicioRelacionamento) {
		this.dataInicioRelacionamento = dataInicioRelacionamento;
	}

	
	
}
