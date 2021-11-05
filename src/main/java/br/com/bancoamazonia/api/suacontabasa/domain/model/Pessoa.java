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

import br.com.amazoniafw.base.components.model.EntityModel;
import br.com.bancoamazonia.api.suacontabasa.domain.enums.TipoPessoaEnum;

@Entity
@Table(name="PESSOA")
public class Pessoa implements EntityModel<Long>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPessoa;
	
	@Column(name="NUM_CPF_CNPJ", unique=true)
	private Long idFiscal;
	
	@Column(name="NOME")
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATA_NASC")
	private Date dataNascimento;
	
	public TipoPessoaEnum getTipoPessoa() {
		return tipoPessoa;
	}


	public void setTipoPessoa(TipoPessoaEnum tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	@Enumerated(EnumType.STRING)
	@Column(name="TIPO_PESSOA")
	private TipoPessoaEnum tipoPessoa;
	
	public Date getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

/*
	@JsonProperty
    @OneToOne(mappedBy = "pessoa")
    private Conta conta;	
	
	
	@OneToOne(fetch = FetchType.LAZY, optional = false, cascade =  CascadeType.ALL)
	@JoinColumn(name = "IDCONTA")
	private Conta conta;
	*/
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
	

