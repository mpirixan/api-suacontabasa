package br.com.bancoamazonia.api.suacontabasa.domain.model;

import java.time.LocalDate;

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
import javax.validation.constraints.Size;

import br.com.bancoamazonia.api.suacontabasa.domain.enums.EstadoCivilEnum;


@Entity
@Table(name="pessoa")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idpessoa")
	private Long idPessoa;
	
	@Size(min=11,max = 11)
	@Column(name="idfiscal", unique=true,length=11)
	private Long idFiscal;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="datanascimento",columnDefinition = "DATE")
	private LocalDate dataNascimento;
	

	@Enumerated(EnumType.STRING)
	@Column(name="estadoCivil")
	private EstadoCivilEnum estadoCivil;

	@OneToOne(cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
	@JoinColumn(name = "conta", referencedColumnName= "idconta", nullable = true)
	private Conta conta;
	


	public LocalDate getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public Pessoa() {
		
	}
	
	public Pessoa(Long idPessoa, Long idFiscal, String nome,LocalDate dataNascimento) {
		super();
		this.idPessoa = idPessoa;
		this.idFiscal = idFiscal;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}
	
	public Long getId() {
		return idPessoa;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conta == null) ? 0 : conta.hashCode());
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((estadoCivil == null) ? 0 : estadoCivil.hashCode());
		result = prime * result + ((idFiscal == null) ? 0 : idFiscal.hashCode());
		result = prime * result + ((idPessoa == null) ? 0 : idPessoa.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (conta == null) {
			if (other.conta != null)
				return false;
		} else if (!conta.equals(other.conta))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (estadoCivil != other.estadoCivil)
			return false;
		if (idFiscal == null) {
			if (other.idFiscal != null)
				return false;
		} else if (!idFiscal.equals(other.idFiscal))
			return false;
		if (idPessoa == null) {
			if (other.idPessoa != null)
				return false;
		} else if (!idPessoa.equals(other.idPessoa))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
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


	public EstadoCivilEnum getEstadoCivil() {
		return estadoCivil;
	}


	public void setEstadoCivil(EstadoCivilEnum estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	}
	

