package br.com.bancoamazonia.api.suacontabasa.controller.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import br.com.bancoamazonia.api.suacontabasa.domain.enums.TipoPessoaEnum;
import io.swagger.v3.oas.annotations.media.Schema;

public class CadastroPessoaResponse implements Serializable {

	private static final long serialVersionUID = 5126712833721927079L;
	
	@Schema(description = "idFiscal - identificador fiscal da Pessoa")
	private Long idFiscal;
	
	@Schema(description = "nome - nome da Pessoa")
	private String nome;

	@Schema(description = "dataNascimento - Data de Nascimento da pessoa")
	private Date dataNascimento;
	
	@Schema(description = "Tipo de Pessoa")
	private TipoPessoaEnum tipoPessoa;

	@Override
	public int hashCode() {
		return Objects.hash(idFiscal, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CadastroPessoaResponse other = (CadastroPessoaResponse) obj;
		return Objects.equals(idFiscal, other.idFiscal) && Objects.equals(nome, other.nome);
	}

	public Long getIdFiscal() {
		return idFiscal;
	}

	public void setIdFiscal(Long idFiscal) {
		this.idFiscal = idFiscal;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public TipoPessoaEnum getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoaEnum tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
	
}
