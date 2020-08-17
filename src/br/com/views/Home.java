package br.com.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.models.Cliente;
import br.com.models.Conta;
import br.com.models.ContaCorrente;
import br.com.models.ContaPoupanca;

public class Home extends JFrame {

	private JPanel contentPane;

	public Home(Cliente cliente, Conta conta) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 399);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnSaldo = new JButton("");
		btnSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,
						"Sobrenome: " + cliente.getSobreNome() + "\nSaldo: " + conta.consultarSaldo());
			}
		});
		btnSaldo.setIcon(new ImageIcon(Home.class.getResource("/icons/document.png")));
		btnSaldo.setBounds(37, 11, 134, 170);
		contentPane.add(btnSaldo);

		JLabel lblSaldo = new JLabel("Consultar Saldo");
		lblSaldo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSaldo.setForeground(new Color(255, 255, 255));
		lblSaldo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaldo.setBounds(37, 180, 134, 25);
		contentPane.add(lblSaldo);

		JLabel lblDepositar = new JLabel("Depositar");
		lblDepositar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDepositar.setHorizontalAlignment(SwingConstants.CENTER);
		lblDepositar.setForeground(new Color(255, 255, 255));
		lblDepositar.setBounds(258, 92, 157, 25);
		contentPane.add(lblDepositar);

		JLabel lblSacar = new JLabel("Sacar");
		lblSacar.setHorizontalAlignment(SwingConstants.CENTER);
		lblSacar.setForeground(Color.WHITE);
		lblSacar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSacar.setBounds(258, 205, 157, 25);
		contentPane.add(lblSacar);

		JButton btnSacar = new JButton("");
		btnSacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double num = 0;
				try {
					num = Double.parseDouble(JOptionPane.showInputDialog("Quantia que deseja sacar"));
					if(conta.sacar(num) == 1) {
						JOptionPane.showMessageDialog(null, "Saque realizado");
						System.out.println("debug");
					}
				} catch (NumberFormatException excecao) {
					JOptionPane.showMessageDialog(null, "Entre apenas numeros");
				}catch(NullPointerException nulo) {
					
				}
			}
		});
		btnSacar.setIcon(new ImageIcon(Home.class.getResource("/icons/money.png")));
		btnSacar.setBounds(258, 128, 157, 73);
		contentPane.add(btnSacar);

		JButton btnDepositar = new JButton("");
		btnDepositar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double num = 0;
				try {
					num = Double.parseDouble(JOptionPane.showInputDialog("Quantia que deseja depositar"));
					conta.depositar(num);
				} catch (NumberFormatException excecao) {
					JOptionPane.showMessageDialog(null, "Entre apenas numeros");
				}catch(NullPointerException nulo) {
					
				}
				
			}
		});
		btnDepositar.setIcon(new ImageIcon(Home.class.getResource("/icons/money (1).png")));
		btnDepositar.setBounds(258, 11, 157, 73);
		contentPane.add(btnDepositar);

		JButton btnJuros = new JButton("");
		btnJuros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (conta instanceof ContaCorrente) {
					JOptionPane.showMessageDialog(null, "Seu tipo de conta nao permite esse tipo de operação");
				}else {
					double num;
					num =  conta.recolherJurosMensais();
					JOptionPane.showMessageDialog(null, "Juros do mes: R$ "+num);
				}
			}
		});
		btnJuros.setIcon(new ImageIcon(Home.class.getResource("/icons/money (2).png")));
		btnJuros.setBounds(258, 232, 157, 73);
		contentPane.add(btnJuros);

		JLabel lblRecolherJuros = new JLabel("Recolher Juros");
		lblRecolherJuros.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecolherJuros.setForeground(Color.WHITE);
		lblRecolherJuros.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRecolherJuros.setBounds(258, 316, 157, 25);
		contentPane.add(lblRecolherJuros);

		JButton btnCheque = new JButton("");
		btnCheque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (conta instanceof ContaPoupanca) {
					JOptionPane.showMessageDialog(null, "Seu tipo de conta nao permite esse tipo de operação");
				} else {
					DepositoCheque deposito = new DepositoCheque(cliente,conta);
					dispose();
					deposito.setVisible(true);
					deposito.setLocationRelativeTo(null);
				}
			}
		});
		btnCheque.setIcon(new ImageIcon(Home.class.getResource("/icons/cheque.png")));
		btnCheque.setBounds(37, 232, 134, 73);
		contentPane.add(btnCheque);

		JLabel lblCheque = new JLabel("Depositar Cheque");
		lblCheque.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheque.setForeground(Color.WHITE);
		lblCheque.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCheque.setBounds(37, 313, 134, 25);
		contentPane.add(lblCheque);
	}

}
