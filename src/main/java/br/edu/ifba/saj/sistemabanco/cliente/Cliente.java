package br.edu.ifba.saj.sistemabanco.cliente;

public class Cliente {
	private String nomeCompleto;
	private String CPF;
	private int score;
	
	public Cliente(String nomeCompleto, String CPF) {
		this.nomeCompleto = nomeCompleto;
		this.CPF = CPF;
	}

  public String getNome(){
    return nomeCompleto;
  }
  public String getCPF(){
    return CPF;
  }
	

}
