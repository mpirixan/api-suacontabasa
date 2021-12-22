package br.com.bancoamazonia.api.suacontabasa.domain.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idempresa")
    private Long idEmpresa;

    @Column(name="nomefantasia",nullable=false)
    private String nomeFantasia;

    @Size(min=14,max=14)
    @Column(name="idfiscal",unique = true, length=14)
    private Long idFiscal;

    @Column(name="datadecriação",nullable=false)
    private LocalDate dataDeCriacao;

    @Column(name="telefone",nullable=false)
    private Long telefone;

	@OneToOne(cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
	@JoinColumn(name = "conta", referencedColumnName= "idconta", nullable = true)
	private Conta conta;

	public Empresa() {
		
	}
	
	public Empresa(Long idEmpresa, String nomeFantasia, @Size(min = 14, max = 14) Long idFiscal,
			LocalDate dataDeCriacao, Long telefone) {
		super();
		this.idEmpresa = idEmpresa;
		this.nomeFantasia = nomeFantasia;
		this.idFiscal = idFiscal;
		this.dataDeCriacao = dataDeCriacao;
		this.telefone = telefone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(conta, dataDeCriacao, idEmpresa, idFiscal, nomeFantasia, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		return Objects.equals(conta, other.conta) && Objects.equals(dataDeCriacao, other.dataDeCriacao)
				&& Objects.equals(idEmpresa, other.idEmpresa) && Objects.equals(idFiscal, other.idFiscal)
				&& Objects.equals(nomeFantasia, other.nomeFantasia) && Objects.equals(telefone, other.telefone);
	}

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public Long getIdFiscal() {
		return idFiscal;
	}

	public void setIdFiscal(Long idFiscal) {
		this.idFiscal = idFiscal;
	}

	public LocalDate getDataDeCriacao() {
		return dataDeCriacao;
	}

	public void setDataDeCriacao(LocalDate dataDeCriacao) {
		this.dataDeCriacao = dataDeCriacao;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	
}

