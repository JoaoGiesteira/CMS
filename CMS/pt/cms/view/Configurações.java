package pt.cms.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Configura��es extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Configura��es frame = new Configura��es();
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
	public Configura��es() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 541, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnConfiguraesUtilizadores = new JButton("Configura\u00E7\u00F5es Utilizadores");
		btnConfiguraesUtilizadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Configura��esUtilizadores configUtilizadores = new Configura��esUtilizadores();
				configUtilizadores.setVisible(true);
				
				dispose();
			}
		});
		btnConfiguraesUtilizadores.setBounds(179, 40, 194, 44);
		contentPane.add(btnConfiguraesUtilizadores);
		
		JButton btnConfiguraesObjectos = new JButton("Configura\u00E7\u00F5es Objectos");
		btnConfiguraesObjectos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Configura��esObjectos configObj = new Configura��esObjectos();
				configObj.setVisible(true);
				
				dispose();
				
			}
		});
		btnConfiguraesObjectos.setBounds(179, 116, 194, 44);
		contentPane.add(btnConfiguraesObjectos);
		
		JButton btnConfiguraesSalas = new JButton("Configura\u00E7\u00F5es Salas");
		btnConfiguraesSalas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Configura��esSalas configSalas = new Configura��esSalas();
				configSalas.setVisible(true);
				
				dispose();
				
				
			}
		});
		btnConfiguraesSalas.setBounds(179, 200, 194, 44);
		contentPane.add(btnConfiguraesSalas);
	}

}
