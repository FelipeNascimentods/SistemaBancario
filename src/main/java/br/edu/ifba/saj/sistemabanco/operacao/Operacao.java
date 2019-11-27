package br.edu.ifba.saj.sistemabanco.operacao;

public abstract class Operacao {
	protected double valor;

	public Operacao(double valor) {		
		this.valor = valor;
	}
	
	protected double getValor() {
		return valor;
	}
	
	public abstract double operar();
	
}
