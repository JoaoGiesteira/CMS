package pt.cms.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Listagens extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Listagens frame = new Listagens();
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
	public Listagens() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 660, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAcessosASalas = new JButton("Acessos a Salas");
		btnAcessosASalas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListangensAcessos frame = new ListangensAcessos();
				frame.setVisible(true);
				
			}
		});
		btnAcessosASalas.setBounds(218, 201, 190, 41);
		contentPane.add(btnAcessosASalas);
		
		JButton btnRequisiçoesObjectos = new JButton("Requisi\u00E7\u00F5es Objectos");
		btnRequisiçoesObjectos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListagensObjectos frame = new ListagensObjectos();
				frame.setVisible(true);
			}
		});
		btnRequisiçoesObjectos.setBounds(218, 265, 190, 41);
		contentPane.add(btnRequisiçoesObjectos);
	}

}
