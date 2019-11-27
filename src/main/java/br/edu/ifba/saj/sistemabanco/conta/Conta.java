package br.edu.ifba.saj.sistemabanco.conta;

import  br.edu.ifba.saj.sistemabanco.cliente.Cliente;
import br.edu.ifba.saj.sistemabanco.exceptions.SaldoInsuficienteException;
import br.edu.ifba.saj.sistemabanco.operacao.Credito;
import br.edu.ifba.saj.sistemabanco.operacao.Debito;
import br.edu.ifba.saj.sistemabanco.operacao.Operacao;
import br.edu.ifba.saj.sistemabanco.operacao.Transferencia;
import  br.edu.ifba.saj.sistemabanco.servico.Extrato;

public abstract class Conta {
	private static int qtdContas;
	private int numero;
	private Cliente cliente;
	private double saldo;	
	private Extrato extrato;

	public Conta() {
		qtdContas++;
		setNumero(qtdContas);
		extrato = new Extrato(50);
	}

	public Conta(int numero) {
		setNumero(numero);
		extrato = new Extrato(50);
	}

	public int getNumero() {
		return numero;
	}

	private void setNumero(int numero) {
		this.numero = numero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	protected Extrato getExtrato() {
		return extrato;
	}
	
	
	protected void executa(Operacao operacao) {
            try{
                double valorOperacao = operacao.operar();
                this.saldo+=valorOperacao;
                extrato.registrar(valorOperacao);
            }catch(SaldoInsuficienteException e){
                System.out.println(e);
            }
	}
        
        public void sacar(double valorSaque){
            Debito d = new Debito(valorSaque);
            this.executa(d);
        }
        
        public void depositar(double valorDeposito){
            Credito c = new Credito(valorDeposito);
            this.executa(c);
        }
        
	public void transferir(Conta destino, double valorTransferencia) {
            Transferencia t = new Transferencia(destino, valorTransferencia);
            this.executa(t);
	}
	
	public String exibirExtrato(){
		return extrato.exibirExtrato(5);
	}
	
	public String exibirExtrato(int quantidade){
		return extrato.exibirExtrato(quantidade);
	}

  public boolean equals(Object obj){
    Conta outraConta = (Conta)obj;
    return this.getNumero() == outraConta.getNumero();
  }

  public String toString() {
    return "Conta numero: "+getNumero() +"\n Saldo: "+getSaldo()+"\n Cliente: "+getCliente().getNome();
  }

  public abstract double getSaldoTotal(); 
  
}