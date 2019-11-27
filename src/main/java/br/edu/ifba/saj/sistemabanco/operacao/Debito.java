package br.edu.ifba.saj.sistemabanco.operacao;

import br.edu.ifba.saj.sistemabanco.conta.Conta;
import br.edu.ifba.saj.sistemabanco.exceptions.SaldoInsuficienteException;

public class Debito extends Operacao {

	public Debito(double valor) {
		super(valor);
	}
	
	public double operar() {
		return getValor()*-1;
	}

	public void valida(Conta conta) {
		if(conta.getSaldoTotal() >= getValor()) {
                    throw new SaldoInsuficienteException("Operação não realizada! Saldo insuficiente.");
		}
	}
}
