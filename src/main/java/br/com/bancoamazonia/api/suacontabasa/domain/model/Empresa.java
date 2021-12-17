package br.com.bancoamazonia.api.suacontabasa.domain.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
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

    
}
