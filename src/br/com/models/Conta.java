package br.com.models;

import javax.swing.JOptionPane;

public abstract class Conta {
	Integer idCliente;
	Double saldo;

	public Conta(Cliente cliente) {
		this.idCliente = cliente.getId();
		this.saldo = 0.0;
	}

	public void depositar(Double valorDepositado) {
		if (valorDepositado > 0) {
			this.saldo += valorDepositado;
			JOptionPane.showMessageDialog(null, "Depósito realizado");
		} else {
			JOptionPane.showMessageDialog(null, "Valor incoerente, depósito cancelado");
		}
	}

	public int sacar(double valorSacado) {
		if (valorSacado > 0) {
			this.saldo -= valorSacado;
			return 1;
		}
		JOptionPane.showMessageDialog(null, "Valor Incoerente, saque cancelado");
		return 0;
	}

	public Double consultarSaldo() {
		return this.saldo;
	}

}
