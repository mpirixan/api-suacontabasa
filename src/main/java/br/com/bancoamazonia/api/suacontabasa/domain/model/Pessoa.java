package br.com.bancoamazonia.api.suacontabasa.domain.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import br.com.amazoniafw.base.components.model.EntityModel;

@Entity
@Immutable
@Table(name="PESSOA")
public class Pessoa implements EntityModel<Long>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID_PESSOA")
	private Long idPessoa;
	
	@Column(name="NUM_CPF_CNPJ")
	private Long idFiscal;
	
	@Column(name="NOME")
	private String nome;
	
	
	
	public Pessoa() {
		
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(idPessoa);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(idPessoa, other.idPessoa);
	}



	public Long getIdPessoa() {
		return idPessoa;
	}


	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Long getIdFiscal() {
		return idFiscal;
	}


	public void setIdFiscal(Long idFiscal) {
		this.idFiscal = idFiscal;
	}


	public Pessoa(Long idPessoa, Long idFiscal, String nome) {
		super();
		this.idPessoa = idPessoa;
		this.idFiscal = idFiscal;
		this.nome = nome;
	}


	@Override
	public Long getId() {

		return getIdPessoa();
	}




	}
	

