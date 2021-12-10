package br.com.bancoamazonia.api.suacontabasa.domain.model;

import java.time.LocalDate;
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

import br.com.bancoamazonia.api.suacontabasa.domain.enums.StatusContaEnum;
import br.com.bancoamazonia.api.suacontabasa.domain.enums.TipoContaEnum;

@Entity
@Table(name="conta")
public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idconta")
	private Long idConta;
	
	@Column(name="agencia")
	private Long agencia;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	private StatusContaEnum status;
	
	@Column(name="senha")
	private String senha;
	
	@Column(name="saldo")
	private Double saldo;

	@Column(name="datavigencia", insertable=false ,updatable=false,columnDefinition = "DATE")
	private LocalDate dataVigencia;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipoconta")
	private TipoContaEnum tipoConta;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="datavigencia")
	private Date dataInicioRelacionamento;
	
	public LocalDate getDataVigencia() {
		return dataVigencia;
	}


	public void setDataVigencia(LocalDate dataVigencia) {
		this.dataVigencia = dataVigencia;
	}



	public Conta() {
		
	}

	public Conta(Long idConta, Long agencia, StatusContaEnum status, Double saldo,LocalDate dataVigencia, TipoContaEnum tipoConta) {
		super();
		this.idConta = idConta;
		this.agencia = agencia;
		this.status = status;
		this.saldo = saldo;
		this.dataVigencia = dataVigencia;
		this.tipoConta = tipoConta;
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



	public TipoContaEnum getTipoConta() {
		return tipoConta;
	}


	public void setTipoConta(TipoContaEnum tipoConta) {
		this.tipoConta = tipoConta;
	}


	public Long getIdConta() {
		return idConta;
	}


	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}


	public StatusContaEnum getStatus() {
		return status;
	}


	public void setStatus(StatusContaEnum status) {
		this.status = status;
	}


	public Long getAgencia() {
		return agencia;
	}


	public void setAgencia(Long agencia) {
		this.agencia = agencia;
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
	

