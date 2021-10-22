package br.com.bancoamazonia.api.suacontabasa.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import br.com.amazoniafw.base.components.model.EntityModel;

@Entity
@Immutable
@Table(name="CONTA")
public class Conta implements EntityModel<Long>{

	@Id
	@Column(name="NUM_CONTA")
	private Long numConta;

	@Column(name="TIP_CONTA")
	private String tipoConta;
	
	
	public Conta() {}


	public Conta(Long numConta) {
		this.numConta = numConta;
	}

	@Override
	public Long getId() {

		return this.numConta;
	}
}

