package com.example.progresso.business;

public class ReporteStatus {
	
	private Status status;

	private String nome;
	
	private Long qtd;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getQtd() {
		return qtd;
	}

	public void setQtd(Long qtd) {
		this.qtd = qtd;
	}

	public ReporteStatus(Status status, Long qtd) {
		super();
		this.status = status;
		this.nome = status.getNome();
		this.qtd = qtd;
	}


}
