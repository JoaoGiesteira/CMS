package pt.cms.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pt.cms.controler.Cms;
import pt.cms.controler.Workers;
import pt.cms.model.Sala;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class AcessoSalas extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumeroEstudante;
	private JRadioButton rdbtnDevolução;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcessoSalas frame = new AcessoSalas();
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
	public AcessoSalas() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 682, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtNumeroEstudante = new JTextField();
		txtNumeroEstudante.setBounds(111, 192, 167, 27);
		contentPane.add(txtNumeroEstudante);
		txtNumeroEstudante.setColumns(10);

		JLabel lblNEstudante = new JLabel("N\u00BA Estudante");
		lblNEstudante.setBounds(21, 198, 80, 14);
		contentPane.add(lblNEstudante);

		JComboBox<String> comboBox_Sala = new JComboBox<String>();
		for (Sala s : Cms.salas) {

			comboBox_Sala.addItem(s.getSala());
		}
		comboBox_Sala.setBounds(111, 250, 167, 20);
		contentPane.add(comboBox_Sala);

		JRadioButton rdbtnRegisto = new JRadioButton("Registo");
		rdbtnRegisto.setSelected(true);
		rdbtnRegisto.setBounds(24, 123, 109, 23);
		contentPane.add(rdbtnRegisto);

		rdbtnDevolução = new JRadioButton("Devolu\u00E7\u00E3o");
		rdbtnDevolução.setBounds(169, 123, 109, 23);
		contentPane.add(rdbtnDevolução);

		JLabel lblSala = new JLabel("Sala");
		lblSala.setBounds(21, 253, 46, 14);
		contentPane.add(lblSala);

		JButton btnRegistar = new JButton("Registar");
		btnRegistar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				if(Workers.isAluno((String) comboBox_Sala.getSelectedItem(), txtNumeroEstudante.getText())==true){
					
					if (rdbtnRegisto.isSelected()) {
						Sala s = new Sala((String) comboBox_Sala.getSelectedItem());
						Cms.acessoSalas(txtNumeroEstudante.getText(),
								Workers.obterData(), Workers.obterHora(), s,"SIM");
						JOptionPane.showMessageDialog(null, "Adicionado!");
					} else {
						try {
							Cms.devolveracesso(txtNumeroEstudante.getText(),
									Workers.obterData(), Workers.obterHora());
							JOptionPane.showMessageDialog(null, "Devolvido!");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}else if (Workers.isAluno((String) comboBox_Sala.getSelectedItem(), txtNumeroEstudante.getText())==false)
				{
					JOptionPane.showMessageDialog(null, "O Aluno Não Tem Acesso á Sala!");
				}
			

				
				
					
				try {
					Cms.saves();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnRegistar.setBounds(432, 194, 89, 23);
		contentPane.add(btnRegistar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNumeroEstudante.setText("");
			}
		});
		btnLimpar.setBounds(432, 275, 89, 23);
		contentPane.add(btnLimpar);

	}
}
