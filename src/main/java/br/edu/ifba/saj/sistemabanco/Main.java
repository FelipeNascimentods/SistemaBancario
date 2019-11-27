package br.edu.ifba.saj.sistemabanco;
import br.edu.ifba.saj.sistemabanco.conta.Conta;
import br.edu.ifba.saj.sistemabanco.conta.ContaCorrente;
import br.edu.ifba.saj.sistemabanco.conta.ContaPoupanca;
import br.edu.ifba.saj.sistemabanco.operacao.Credito;
import br.edu.ifba.saj.sistemabanco.operacao.Debito;
import br.edu.ifba.saj.sistemabanco.cliente.Cliente;

public class Main {

	public static void main(String[] args) {
            Conta c = new ContaCorrente();
            Conta c2 = new ContaCorrente();
            
            c.depositar(100);
            c.exibirExtrato();
            c.transferir(c2, 10);
            
            c.exibirExtrato();
            c2.exibirExtrato();
            
            c.transferir(c2, 1000);
            c.exibirExtrato();
            
            c2.exibirExtrato();
	}
}
