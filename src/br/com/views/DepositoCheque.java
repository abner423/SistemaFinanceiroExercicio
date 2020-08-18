package br.com.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.models.Cliente;
import br.com.models.Conta;
import br.com.models.ContaCorrente;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DepositoCheque extends JFrame {

	private JPanel contentPane;
	private JTextField inputValor;
	private JTextField inputBancoEmissor;
	private JTextField inputDataPagamento;
	private JLabel lblBancoEmissor;
	private JLabel lblDataDePagamento;
	private JButton btnDepositar;

	public DepositoCheque(Cliente cliente, Conta conta) {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				Home home = new Home(cliente, conta);
				dispose();
				home.setVisible(true);
				home.setLocationRelativeTo(null);
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("");
		label.setForeground(new Color(0, 0, 0));
		label.setBackground(new Color(64, 224, 208));
		label.setIcon(new ImageIcon(DepositoCheque.class.getResource("/icons/cheque.png")));
		label.setBounds(42, 58, 113, 109);
		contentPane.add(label);

		inputValor = new JTextField();
		inputValor.setToolTipText("");
		inputValor.setBounds(133, 58, 174, 35);
		contentPane.add(inputValor);
		inputValor.setColumns(10);

		JLabel lblNewLabel = new JLabel("Valor");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(317, 58, 117, 35);
		contentPane.add(lblNewLabel);

		inputBancoEmissor = new JTextField();
		inputBancoEmissor.setBounds(133, 104, 174, 35);
		contentPane.add(inputBancoEmissor);
		inputBancoEmissor.setColumns(10);

		inputDataPagamento = new JTextField();
		inputDataPagamento.setColumns(10);
		inputDataPagamento.setBounds(133, 150, 174, 35);
		contentPane.add(inputDataPagamento);

		lblBancoEmissor = new JLabel("Banco Emissor");
		lblBancoEmissor.setHorizontalAlignment(SwingConstants.CENTER);
		lblBancoEmissor.setForeground(Color.WHITE);
		lblBancoEmissor.setBounds(317, 104, 117, 35);
		contentPane.add(lblBancoEmissor);

		lblDataDePagamento = new JLabel("Data de pagamento");
		lblDataDePagamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataDePagamento.setForeground(Color.WHITE);
		lblDataDePagamento.setBounds(317, 150, 117, 35);
		contentPane.add(lblDataDePagamento);

		btnDepositar = new JButton("Depositar");
		btnDepositar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double valor;
				String banco;
				String data;
				try {
					valor = Double.parseDouble(inputValor.getText());
					banco = inputBancoEmissor.getText();
					data = inputDataPagamento.getText();
					inputValor.setText("");
					inputBancoEmissor.setText("");
					inputDataPagamento.setText("");
					
					JOptionPane.showMessageDialog(null, "Depósito do cheque realizado");
					((ContaCorrente)conta).depositarCheque(valor, banco, data);
					Home home = new Home(cliente,conta);
					dispose();
					home.setVisible(true);
					home.setLocationRelativeTo(null);
				} catch (NumberFormatException number) {
					JOptionPane.showMessageDialog(null, "Valor incoerente");
					inputValor.setText("");
				}
			}
		});
		btnDepositar.setBounds(178, 217, 89, 23);
		contentPane.add(btnDepositar);
	}
}
