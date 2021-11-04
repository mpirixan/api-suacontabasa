package br.com.bancoamazonia.api.suacontabasa.domain.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.amazoniafw.base.components.model.EntityModel;
import br.com.bancoamazonia.api.suacontabasa.domain.enums.StatusContaEnum;
import br.com.bancoamazonia.api.suacontabasa.domain.enums.TipoContaEnum;

@Entity
@Table(name="CONTA")
public class Conta implements EntityModel<Long>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConta;
	
	@Column(name="AGENCIA")
	private Long agencia;
	
	@Enumerated(EnumType.STRING)
	@Column(name="STATUS")
	private StatusContaEnum status;
	
	@Column(name="SENHA")
	private String senha;
	
	@Column(name="SALDO")
	private Double saldo;

	@Column(name="DATA_VIGENCIA")
	private Date dataVigencia;
	
	@Enumerated(EnumType.STRING)
	@Column(name="TIPO_CONTA")
	private TipoContaEnum tipoConta; ;
	
	public Date getDataVigencia() {
		return dataVigencia;
	}


	public void setDataVigencia(Date dataVigencia) {
		this.dataVigencia = dataVigencia;
	}

	@OneToOne(fetch = FetchType.LAZY, optional = false, cascade =  CascadeType.ALL)
	@JoinColumn(name = "IDCONTA", nullable = false)
	private Pessoa pessoa;
	

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


	public Conta(Long idConta, Long agencia, StatusContaEnum status, Double saldo) {
		super();
		this.idConta = idConta;
		this.agencia = agencia;
		this.status = status;
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

	public void subSaldo(Double saque) {
		Double result = (saldo - saque);
		this.saldo = result;
	
}


	}
	

