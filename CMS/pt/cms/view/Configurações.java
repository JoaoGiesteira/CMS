package pt.cms.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Configurações extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Configurações frame = new Configurações();
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
	public Configurações() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 541, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnConfiguraesUtilizadores = new JButton("Configura\u00E7\u00F5es Utilizadores");
		btnConfiguraesUtilizadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ConfiguraçõesUtilizadores configUtilizadores = new ConfiguraçõesUtilizadores();
				configUtilizadores.setVisible(true);
				
				dispose();
			}
		});
		btnConfiguraesUtilizadores.setBounds(179, 40, 194, 44);
		contentPane.add(btnConfiguraesUtilizadores);
		
		JButton btnConfiguraesObjectos = new JButton("Configura\u00E7\u00F5es Objectos");
		btnConfiguraesObjectos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ConfiguraçõesObjectos configObj = new ConfiguraçõesObjectos();
				configObj.setVisible(true);
				
				dispose();
				
			}
		});
		btnConfiguraesObjectos.setBounds(179, 116, 194, 44);
		contentPane.add(btnConfiguraesObjectos);
		
		JButton btnConfiguraesSalas = new JButton("Configura\u00E7\u00F5es Salas");
		btnConfiguraesSalas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ConfiguraçõesSalas configSalas = new ConfiguraçõesSalas();
				configSalas.setVisible(true);
				
				dispose();
				
				
			}
		});
		btnConfiguraesSalas.setBounds(179, 200, 194, 44);
		contentPane.add(btnConfiguraesSalas);
	}

}
