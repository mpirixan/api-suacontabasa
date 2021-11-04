package br.com.bancoamazonia.api.suacontabasa.domain.enums;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoCadastroEnum implements IEnumObject<String, String>{
	
	BASICO("Basico"),
	COMPLETO("Completo");
	
	public String value;
	
	@Autowired
	public String getValue() {
		return this.value;
	}


	private TipoCadastroEnum(String value) {
		this.value = value;
	}

	@Override
	public String getKey() {
		return this.name();
	}
}
