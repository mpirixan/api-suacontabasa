package br.com.bancoamazonia.api.suacontabasa.domain.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum StatusContaEnum implements IEnumObject<String, String> {

	 ATIVA("Ativa"),
	 DESATIVADO("Desativado");

	private String value;

	@Override
	public String getValue() {
		return this.value;
	}


	private StatusContaEnum(String value) {
		this.value = value;
	}

	@Override
	public String getKey() {
		return this.name();
	}
	
	
	
}
