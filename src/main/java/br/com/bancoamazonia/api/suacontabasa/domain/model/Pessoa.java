package br.com.bancoamazonia.api.suacontabasa.domain.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.bancoamazonia.api.suacontabasa.domain.enums.TipoPessoaEnum;

@Entity
@Table(name="pessoa")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idpessoa")
	private Long idPessoa;
	
	@Column(name="idfiscal", unique=true)
	private Long idFiscal;
	
	@Column(name="nome")
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="datanascimento")
	private Date dataNascimento;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipopessoa")
	private TipoPessoaEnum tipoPessoa;

	
	public TipoPessoaEnum getTipoPessoa() {
		return tipoPessoa;
	}


	public void setTipoPessoa(TipoPessoaEnum tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}


	public Date getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public Pessoa() {
		
	}
	
	public Pessoa(Long idPessoa, Long idFiscal, String nome, TipoPessoaEnum tipoPessoa) {
		super();
		this.idPessoa = idPessoa;
		this.idFiscal = idFiscal;
		this.nome = nome;
		this.tipoPessoa = tipoPessoa;
	}
	
	public Long getId() {
		return idPessoa;
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


	}
	

