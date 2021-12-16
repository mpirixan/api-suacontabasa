package br.com.bancoamazonia.api.suacontabasa.domain.enums;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum EstadoCivilEnum implements IEnumObject<String, String> {

	SOLTERO("Solteiro(a)"),
	CASADO("Casado(a)"),
	UNIAOESTAVEL("União Estável"),
	VIUVO("Viúvo(a)"),
	DIVORCIADO("Divorciado(a)");

	private String value;

	@Autowired
	public String getValue() {
		return this.value;
	}


	private EstadoCivilEnum(String value) {
		this.value = value;
	}

	@Override
	public String getKey() {
		return this.name();
	}
	
	
	
}
