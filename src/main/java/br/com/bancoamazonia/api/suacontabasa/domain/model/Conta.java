package br.com.bancoamazonia.api.suacontabasa.domain.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import br.com.amazoniafw.base.components.model.EntityModel;

@Entity
@Immutable
@Table(name="CONTA")
public class Conta implements EntityModel<Long>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID_CONTA")
	private Long idConta;
	
	@Column(name="AGENCIA")
	private Long agencia;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="SENHA")
	private String senha;
	
	@Column(name="SALDO")
	private Double saldo;

	@OneToOne
	@MapsId
	@JoinColumn(name = "ID_CONTA")
	private Pessoa idPessoa;
	

	public Conta() {
		
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(idConta);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return Objects.equals(idConta, other.idConta);
	}



	public Long getIdConta() {
		return idConta;
	}


	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Long getAgencia() {
		return agencia;
	}


	public void setAgencia(Long agencia) {
		this.agencia = agencia;
	}


	public Conta(Long idConta, Long agencia, String status, String senha, Double saldo) {
		super();
		this.idConta = idConta;
		this.agencia = agencia;
		this.status = status;
		this.senha = senha;
		this.saldo = saldo;
	}


	@Override
	public Long getId() {

		return getIdConta();
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public Double getSaldo() {
		return saldo;
	}


	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}




	}
	

