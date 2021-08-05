package br.com.deivity.jupiter.model;

import java.util.UUID;

public abstract class PessoaModel {

	private String documento;

	private UUID id;
	
	public PessoaModel(String documento) {
		this.id = UUID.randomUUID();
		this.documento=documento;
	}
	
	public abstract Boolean isDocumentoValido();
	public abstract String getNovoDocumento();
	public abstract String getDocumentoFormatado();
	public UUID getId;

	
	public String getDocumento() {
		return documento;
	}

}


