package br.com.bancoamazonia.api.suacontabasa.domain.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.bancoamazonia.api.suacontabasa.domain.enums.StatusContaEnum;
import br.com.bancoamazonia.api.suacontabasa.domain.enums.TipoContaEnum;

@Entity
@Table(name="conta")
public class Conta implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9190089336173218525L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idconta")
	private Long idConta;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	private StatusContaEnum status;
	
	@Column(name="saldo")
	private Double saldo;
	
	@Column(name="datavigencia", columnDefinition = "DATE")
	private LocalDate dataVigencia;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipoconta")
	private TipoContaEnum tipoConta;
	
	@Column(name="datainiciorelacionamento",columnDefinition = "DATE")
	private LocalDate dataInicioRelacionamento;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "agencia")
	private Agencia agencia;
	
	public LocalDate getDataVigencia() {
		return dataVigencia;
	}


	public void setDataVigencia(LocalDate dataVigencia) {
		this.dataVigencia = dataVigencia;
	}



	public Conta() {
		
	}

	public Conta(Long idConta, Agencia agencia, StatusContaEnum status, Double saldo,LocalDate dataVigencia, LocalDate dataInicioRelacionamento, TipoContaEnum tipoConta) {
		super();
		this.idConta = idConta;
		this.agencia = agencia;
		this.status = status;
		this.saldo = saldo;
		this.dataVigencia = dataVigencia;
		this.dataInicioRelacionamento = dataInicioRelacionamento;
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


	public Agencia getAgencia() {
		return agencia;
	}


	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}


	public Double getSaldo() {
		return saldo;
	}


	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}


	public LocalDate getDataInicioRelacionamento() {
		return dataInicioRelacionamento;
	}


	public void setDataInicioRelacionamento(LocalDate dataInicioRelacionamento) {
		this.dataInicioRelacionamento = dataInicioRelacionamento;
	}



	}
	

