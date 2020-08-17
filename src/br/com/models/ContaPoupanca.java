package br.com.models;

import javax.swing.JOptionPane;

public class ContaPoupanca extends Conta {
	Float taxaDeJuros = 0.0012f;

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}

	public int sacar(double valorSacado) {
		if (valorSacado > 0) {
			if (valorSacado > super.saldo) {
				JOptionPane.showMessageDialog(null, "Saldo insuficiente");
			}
			return 0;
		} else {
			super.sacar(valorSacado);
			return 1;
		}
	}

	public double recolherJurosMensais() {
		return taxaDeJuros * super.saldo;
	}

	@Override
	public void depositarCheque(double valor, String bancoEmissor, String dataPagamento) {
	}

}
