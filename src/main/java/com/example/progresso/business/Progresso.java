package com.example.progresso.business;

public class Progresso {
	
	private Integer id; // random não importa
	
	private Status statusAtual = Status.BUFFER;
	
	private Integer hp = 100;  // só pra simular um certo tempo de execução
	

	public Progresso(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getHp() {
		return hp;
	}

	public void setHp(Integer hp) {
		this.hp = hp;
	}

	public Status getStatusAtual() {
		return statusAtual;
	}

	public void setStatusAtual(Status statusAtual) {
		this.statusAtual = statusAtual;
	}

	
}
