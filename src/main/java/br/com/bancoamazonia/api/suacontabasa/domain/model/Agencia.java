package br.com.bancoamazonia.api.suacontabasa.domain.model;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="agencia")
public class Agencia {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idagencia")
	private Long idAgencia;
	
	@Column(name="gestor")
	private Long gestor;
	
	
	@ManyToOne(cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
	@JoinColumn(name="conta", referencedColumnName="idConta")
	private Conta conta;


	@OneToMany(cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
	@JoinColumn(name="funcionario", referencedColumnName="idFuncionario")
	private Funcionario funcionario;
	
	public Agencia() {
		
	}
	
	
	public Agencia(Long idAgencia, Long gestor, Conta conta) {
		super();
		this.idAgencia = idAgencia;
		this.gestor = gestor;
		this.conta = conta;
	}


	@Override
	public int hashCode() {
		return Objects.hash(conta, gestor, idAgencia);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agencia other = (Agencia) obj;
		return Objects.equals(conta, other.conta) && Objects.equals(gestor, other.gestor)
				&& Objects.equals(idAgencia, other.idAgencia);
	}


	public Long getIdAgencia() {
		return idAgencia;
	}


	public void setIdAgencia(Long idAgencia) {
		this.idAgencia = idAgencia;
	}


	public Long getGestor() {
		return gestor;
	}


	public void setGestor(Long gestor) {
		this.gestor = gestor;
	}


	public Conta getConta() {
		return conta;
	}


	public void setConta(Conta conta) {
		this.conta = conta;
	}


	public Funcionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
	
}
