package pt.cms.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Importação extends JFrame {

	private JPanel contentPane;
	private JTextField textField_abrir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Importação frame = new Importação();
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
	public Importação() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 671, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIndiqueALocalizao = new JLabel("Indique a Localiza\u00E7\u00E3o do Ficheiro");
		lblIndiqueALocalizao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIndiqueALocalizao.setBounds(28, 148, 243, 19);
		contentPane.add(lblIndiqueALocalizao);
		
		textField_abrir = new JTextField();
		textField_abrir.setBounds(127, 178, 258, 20);
		contentPane.add(textField_abrir);
		textField_abrir.setColumns(10);
		
		JButton btnAbrir = new JButton("Abrir");
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAbrir.setBounds(28, 177, 89, 23);
		contentPane.add(btnAbrir);
		
		JButton btnImportar = new JButton("Importar");
		btnImportar.setBounds(28, 260, 89, 23);
		contentPane.add(btnImportar);
	}
}
