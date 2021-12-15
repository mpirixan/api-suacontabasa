package br.com.bancoamazonia.api.suacontabasa.domain.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	
	@Column(name="datanascimento",columnDefinition = "DATE")
	private LocalDate dataNascimento;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipopessoa")
	private TipoPessoaEnum tipoPessoa;

	@OneToOne(cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
	@JoinColumn(name = "conta", referencedColumnName= "idconta", nullable = true)
	private Conta conta;
	
	public TipoPessoaEnum getTipoPessoa() {
		return tipoPessoa;
	}


	public void setTipoPessoa(TipoPessoaEnum tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}


	public LocalDate getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public Pessoa() {
		
	}
	
	public Pessoa(Long idPessoa, Long idFiscal, String nome,LocalDate dataNascimento, TipoPessoaEnum tipoPessoa) {
		super();
		this.idPessoa = idPessoa;
		this.idFiscal = idFiscal;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.tipoPessoa = tipoPessoa;
	}
	
	public Long getId() {
		return idPessoa;
	}



	@Override
	public int hashCode() {
		return Objects.hash(conta, dataNascimento, idFiscal, idPessoa, nome, tipoPessoa);
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
		return Objects.equals(conta, other.conta) && Objects.equals(dataNascimento, other.dataNascimento)
				&& Objects.equals(idFiscal, other.idFiscal) && Objects.equals(idPessoa, other.idPessoa)
				&& Objects.equals(nome, other.nome) && tipoPessoa == other.tipoPessoa;
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
		this.nome = nome.toUpperCase();
	}


	public Long getIdFiscal() {
		return idFiscal;
	}


	public void setIdFiscal(Long idFiscal) {
		this.idFiscal = idFiscal;
	}


	public Conta getConta() {
		return conta;
	}


	public void setConta(Conta conta) {
		this.conta = conta;
	}

	}
	

