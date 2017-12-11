package com.example.progresso.business;

public enum Status {

	INICIO(""),

	BUFFER("Buffer"),
	COORDENADOR("Coordenador"),
	FILA("Fila"),
	EXECUTANDO("Executando"),
	FINALIZANDO("Finalizando"),
	
	MORRER("");  // só para facilitar remover
	
	private String nome;

	private Status(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	
	
}
