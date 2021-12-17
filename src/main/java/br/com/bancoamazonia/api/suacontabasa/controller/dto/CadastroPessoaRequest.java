package br.com.bancoamazonia.api.suacontabasa.controller.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import br.com.bancoamazonia.api.suacontabasa.domain.enums.EstadoCivilEnum;
import io.swagger.v3.oas.annotations.media.Schema;

public class CadastroPessoaRequest implements Serializable {

	private static final long serialVersionUID = 5126712833721927079L;
	
	@Schema(description = "idFiscal - identificador fiscal da Pessoa")
	private Long idFiscal;
	
	@Schema(description = "nome - nome da Pessoa")
	private String nome;

	@Schema(description = "dataNascimento - Data de Nascimento da pessoa")
	private LocalDate dataNascimento;
	

	@Schema(description = "Estado Civil")
	private EstadoCivilEnum estadoCivil;

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
		CadastroPessoaRequest other = (CadastroPessoaRequest) obj;
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public EstadoCivilEnum getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivilEnum estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	
}
