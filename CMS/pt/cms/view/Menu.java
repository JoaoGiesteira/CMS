package pt.cms.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRequisição = new JButton("Requisi\u00E7\u00E3o de Objectos");
		btnRequisição.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				RequisiçãoObjectos rq = new RequisiçãoObjectos();
				rq.setVisible(true);
				
				
			}
		});
		btnRequisição.setBounds(10, 48, 145, 23);
		contentPane.add(btnRequisição);
		
		JButton btnAcessoSalas = new JButton("Acesso Salas");
		btnAcessoSalas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcessoSalas as = new AcessoSalas();
				as.setVisible(true);
				
			}
		});
		btnAcessoSalas.setBounds(153, 48, 111, 23);
		contentPane.add(btnAcessoSalas);
		
		JButton btnImportao = new JButton("Importa\u00E7\u00E3o");
		btnImportao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImportaçãoAbrir i = new ImportaçãoAbrir();
				i.setVisible(true);
				
			}
		});
		btnImportao.setBounds(274, 48, 89, 23);
		contentPane.add(btnImportao);
		
		JButton btnListagens = new JButton("Listagens");
		btnListagens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Listagens l = new Listagens();
				l.setVisible(true);
				
			}
		});
		btnListagens.setBounds(373, 48, 89, 23);
		contentPane.add(btnListagens);
		
		JButton btnAlertas = new JButton("Alertas");
		btnAlertas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Alertas al=new Alertas();
				al.setVisible(true);
			}
		});
		btnAlertas.setBounds(464, 48, 89, 23);
		contentPane.add(btnAlertas);
		
		JButton btnConfigurações = new JButton("Configura\u00E7\u00F5es");
		btnConfigurações.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Configurações config = new Configurações();
				config.setVisible(true);
				
			}
		});
		btnConfigurações.setBounds(552, 48, 111, 23);
		contentPane.add(btnConfigurações);
		
		JLabel lblVideo = new JLabel("VIDEO");
		lblVideo.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblVideo.setHorizontalAlignment(SwingConstants.CENTER);
		lblVideo.setBounds(10, 126, 327, 242);
		contentPane.add(lblVideo);
		
		JLabel lblBemvindo = new JLabel("Bem-Vindo !!!");
		lblBemvindo.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblBemvindo.setVerticalAlignment(SwingConstants.TOP);
		lblBemvindo.setBounds(416, 126, 234, 108);
		contentPane.add(lblBemvindo);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				Login log=new Login();
				log.setVisible(true);
				
				
			}
		});
		btnLogout.setBounds(497, 345, 125, 36);
		contentPane.add(btnLogout);
	}
}
