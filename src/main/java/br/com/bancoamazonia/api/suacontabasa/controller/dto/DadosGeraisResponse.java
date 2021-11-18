package br.com.bancoamazonia.api.suacontabasa.controller.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import io.swagger.v3.oas.annotations.media.Schema;

public class DadosGeraisResponse implements Serializable {

	private static final long serialVersionUID = -1054843750347734618L;

	@Schema(description = "idPessoa - identificador único da Pessoa")
	private Long idPessoa;
	
	@Schema(description = "idFiscal - identificador fiscal da Pessoa")
	private Long idFiscal;
	
	@Schema(description = "nome - nome da Pessoa")
	private String nome;

	@Schema(description = "dataNascimento - Data de Nascimento da pessoa")
	private Date dataNascimento;
	
	@Schema(description = "agencia - identificador agencia da Conta")
	private Long agencia;
	
	@Schema(description = "status - status da conta")
	private String status;

	@Schema(description = "Data vigencia")
	private Date dataVigencia;

	@Schema(description = "Tipo de Conta")
	private String tipoConta;

	public Long getIdPessoa() {
		return idPessoa;
	}

	public Long getIdFiscal() {
		return idFiscal;
	}

	public String getNome() {
		return nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public Long getAgencia() {
		return agencia;
	}

	public String getStatus() {
		return status;
	}

	public Date getDataVigencia() {
		return dataVigencia;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idFiscal, idPessoa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DadosGeraisResponse other = (DadosGeraisResponse) obj;
		return Objects.equals(idFiscal, other.idFiscal) && Objects.equals(idPessoa, other.idPessoa);
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public void setIdFiscal(Long idFiscal) {
		this.idFiscal = idFiscal;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setAgencia(Long agencia) {
		this.agencia = agencia;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setDataVigencia(Date dataVigencia) {
		this.dataVigencia = dataVigencia;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}
	
	
	
}
