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
import javax.persistence.Table;

@Entity
@Table(name="funcionario")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idFuncionario")
	private Long idFuncionario;
	
	@ManyToOne(cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
	@JoinColumn(name="agencia", referencedColumnName="idAgencia")
	private Agencia agencia;
	
	
	public Funcionario() {
		
	}

	
	
	public Funcionario(Long idFuncionario, Agencia agencia) {
		super();
		this.idFuncionario = idFuncionario;
		this.agencia = agencia;
	}



	@Override
	public int hashCode() {
		return Objects.hash(agencia, idFuncionario);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(agencia, other.agencia) && Objects.equals(idFuncionario, other.idFuncionario);
	}



	public Long getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	

	
	
}
