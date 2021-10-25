package br.com.bancoamazonia.api.suacontabasa.manager.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1l;
	
	public ResourceNotFoundException(Object idFiscal) {
		super("Resource not found. Id " + idFiscal);
	}
}


