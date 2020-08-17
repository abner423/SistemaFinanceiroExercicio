package br.com.views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.models.Cliente;
import br.com.models.Conta;
import br.com.models.ContaCorrente;
import br.com.models.ContaPoupanca;

public class CadastroCliente extends JFrame {

	private JPanel contentPane;
	private JTextField inputSobrenome;
	private JTextField inputRg;
	private JTextField inputCpf;

	public CadastroCliente() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 391);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(CadastroCliente.class.getResource("/icons/cliente128.png")));
		label.setBounds(0, 11, 444, 140);
		contentPane.add(label);

		inputSobrenome = new JTextField();
		inputSobrenome.setBounds(132, 162, 202, 28);
		contentPane.add(inputSobrenome);
		inputSobrenome.setColumns(10);

		inputRg = new JTextField();
		inputRg.setBounds(132, 201, 86, 20);
		contentPane.add(inputRg);
		inputRg.setColumns(10);

		JLabel lblSobrenome = new JLabel("Sobrenome");
		lblSobrenome.setForeground(Color.WHITE);
		lblSobrenome.setHorizontalAlignment(SwingConstants.CENTER);
		lblSobrenome.setBounds(43, 162, 79, 28);
		contentPane.add(lblSobrenome);

		JLabel lblRg = new JLabel("Rg");
		lblRg.setForeground(Color.WHITE);
		lblRg.setBounds(76, 204, 46, 14);
		contentPane.add(lblRg);

		inputCpf = new JTextField();
		inputCpf.setColumns(10);
		inputCpf.setBounds(132, 232, 86, 20);
		contentPane.add(inputCpf);

		JLabel lblCpf = new JLabel("Cpf");
		lblCpf.setForeground(Color.WHITE);
		lblCpf.setBounds(76, 235, 46, 14);
		contentPane.add(lblCpf);

		JRadioButton rdbContaCorrente = new JRadioButton("Corrente");
		rdbContaCorrente.setForeground(new Color(255, 255, 255));
		rdbContaCorrente.setBackground(new Color(0, 128, 0));
		rdbContaCorrente.setSelected(true);
		rdbContaCorrente.setBounds(109, 288, 109, 23);
		contentPane.add(rdbContaCorrente);

		JRadioButton rdbContaPoupanca = new JRadioButton("Poupan\u00E7a");
		rdbContaPoupanca.setForeground(new Color(255, 255, 255));
		rdbContaPoupanca.setBackground(new Color(0, 128, 0));
		rdbContaPoupanca.setBounds(254, 288, 109, 23);
		contentPane.add(rdbContaPoupanca);
		ButtonGroup radioButtons = new ButtonGroup();
		radioButtons.add(rdbContaCorrente);
		radioButtons.add(rdbContaPoupanca);

		JLabel lblTipoDeConta = new JLabel("Tipo de conta");
		lblTipoDeConta.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoDeConta.setForeground(new Color(255, 255, 255));
		lblTipoDeConta.setBounds(119, 263, 188, 28);
		contentPane.add(lblTipoDeConta);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente cliente = new Cliente(inputSobrenome.getText(), inputRg.getText(), inputCpf.getText());
				Conta conta;
				if(rdbContaPoupanca.isSelected()) {
					conta = new ContaPoupanca(cliente);
				}else {
					conta = new ContaCorrente(cliente);
				}
				Home home = new Home(cliente,conta);
				dispose();
				home.setVisible(true);
				home.setLocationRelativeTo(null);
			}
		});
		btnCadastrar.setBounds(154, 328, 109, 23);
		contentPane.add(btnCadastrar);
	}
}
