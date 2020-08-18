package br.com.models;

public class ContaCorrente extends Conta {

	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}
	public void depositarCheque(double valor,String bancoEmissor,String dataPagamento) {
		super.saldo +=valor;
	}

}
