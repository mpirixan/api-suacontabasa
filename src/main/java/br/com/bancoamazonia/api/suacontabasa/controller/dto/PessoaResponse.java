package br.com.bancoamazonia.api.suacontabasa.controller.dto;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

import io.swagger.v3.oas.annotations.media.Schema;

public class PessoaResponse implements Serializable {

	private static final long serialVersionUID = 519368557356817204L;

	@Schema(description = "idPessoa - identificador único da Pessoa")
	private Long idPessoa;
	
	@Schema(description = "idFiscal - identificador fiscal da Pessoa")
	private Long idFiscal;
	
	@Schema(description = "nome - nome da Pessoa")
	private String nome;

	
	@Schema(description = "dataNascimento - Data de Nascimento da pessoa")
	private Calendar dataNascimento;
	
	
	@Override
	public int hashCode() {
		return Objects.hash(idFiscal, idPessoa, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaResponse other = (PessoaResponse) obj;
		return Objects.equals(idFiscal, other.idFiscal) && Objects.equals(idPessoa, other.idPessoa)
				&& Objects.equals(nome, other.nome);
	}

	public Long getIdPessoa() {
		return idPessoa;
	}


	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public Long getIdFiscal() {
		return idFiscal;
	}

	public void setIdFiscal(Long idFiscal) {
		this.idFiscal = idFiscal;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
