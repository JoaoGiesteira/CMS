package pt.cms.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import pt.cms.controler.Cms;


import pt.cms.controler.ManagerUser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUtilizador;
	private JPasswordField pwdPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*if (ManagerUser.isUser(txtUtilizador.getText(), pwdPassword.getText()) == true) {
					JOptionPane.showMessageDialog(null, "Ola!");*/
					
					dispose();
					Menu frameMenu=new Menu();
					frameMenu.setVisible(true);
			/*	} 
				else {
				JOptionPane.showMessageDialog(null, "user not found!");
				}
*/
				
			}
		});
		btnConfirmar.setBounds(370, 165, 101, 30);
		contentPane.add(btnConfirmar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(370, 241, 101, 32);
		contentPane.add(btnLimpar);
		
		txtUtilizador = new JTextField();
		txtUtilizador.setText("Utilizador");
		txtUtilizador.setBounds(65, 164, 145, 32);
		contentPane.add(txtUtilizador);
		txtUtilizador.setColumns(10);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setText("Password");
		pwdPassword.setBounds(65, 243, 145, 28);
		contentPane.add(pwdPassword);
	}
}
