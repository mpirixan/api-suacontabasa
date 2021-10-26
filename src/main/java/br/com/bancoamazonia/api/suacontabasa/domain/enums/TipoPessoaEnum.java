package br.com.bancoamazonia.api.suacontabasa.domain.enums;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoPessoaEnum implements IEnumObject<String, String> {

	 FISICA("Física"),
	 JURIDICA("Jurídica");

	private String value;

	@Autowired
	public String getValue() {
		return this.value;
	}


	private TipoPessoaEnum(String value) {
		this.value = value;
	}

	@Override
	public String getKey() {
		return this.name();
	}
	
	
	
}
