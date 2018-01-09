package pt.cms.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

import pt.cms.controler.Cms;
import pt.cms.controler.Workers;
import pt.cms.model.Sala;
import pt.cms.model.TipoObjecto;

public class RequisiçãoObjectos extends JFrame {

	private JPanel contentPaneSalas;
	private JTextField txtDocente;
	private JTextField txtData;
	private JTextField txt_Hora;
	private JLabel lblDocente;
	private JLabel lblData;
	private JLabel lblHora;
	private JLabel lblSala;
	private JLabel lblObjecto;
	private JComboBox comboBox_Objecto;
	private JButton btnRegistar;
	private JButton btnLimpar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RequisiçãoObjectos frame = new RequisiçãoObjectos();
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
	public RequisiçãoObjectos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 671, 459);
		contentPaneSalas = new JPanel();
		contentPaneSalas.setToolTipText("Sala\r\n");
		contentPaneSalas.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneSalas);
		contentPaneSalas.setLayout(null);

		JRadioButton rdbtnDevoluo = new JRadioButton("Devolu\u00E7\u00E3o");
		rdbtnDevoluo.setBounds(172, 150, 109, 23);
		contentPaneSalas.add(rdbtnDevoluo);

		JRadioButton rdbtnRegisto = new JRadioButton("Registo");
		rdbtnRegisto.setSelected(true);
		rdbtnRegisto.setBounds(47, 150, 109, 23);
		contentPaneSalas.add(rdbtnRegisto);

		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnRegisto);
		group.add(rdbtnDevoluo);

		txtDocente = new JTextField();
		txtDocente.setBounds(112, 200, 86, 20);
		contentPaneSalas.add(txtDocente);
		txtDocente.setColumns(10);

		txtData = new JTextField();
		txtData.setBounds(112, 243, 86, 20);
		contentPaneSalas.add(txtData);
		txtData.setColumns(10);

		txt_Hora = new JTextField();
		txt_Hora.setBounds(112, 274, 86, 20);
		contentPaneSalas.add(txt_Hora);
		txt_Hora.setColumns(10);

		lblDocente = new JLabel("Docente");
		lblDocente.setBounds(31, 203, 46, 14);
		contentPaneSalas.add(lblDocente);

		lblData = new JLabel("Data");
		lblData.setBounds(31, 246, 46, 14);
		contentPaneSalas.add(lblData);

		lblHora = new JLabel("Hora:");
		lblHora.setBounds(31, 277, 46, 14);
		contentPaneSalas.add(lblHora);

		lblSala = new JLabel("Sala");
		lblSala.setBounds(31, 308, 46, 14);
		contentPaneSalas.add(lblSala);

		lblObjecto = new JLabel("Objecto");
		lblObjecto.setBounds(31, 348, 46, 14);
		contentPaneSalas.add(lblObjecto);

		JComboBox comboBox_Sala = new JComboBox();
		for (Sala s : Cms.salas) {

			comboBox_Sala.addItem(s.getSala());
		}

		comboBox_Sala.setBounds(112, 305, 86, 20);
		contentPaneSalas.add(comboBox_Sala);

		JComboBox comboBox_Objecto = new JComboBox();
		for (TipoObjecto to : Cms.tipoObjectos) {

			comboBox_Objecto.addItem(to.getTipoObjecto());
		}
		comboBox_Objecto.setBounds(112, 345, 86, 20);
		contentPaneSalas.add(comboBox_Objecto);

		btnRegistar = new JButton("Registar");
		btnRegistar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (txtData.getText().equals("")
						&& txt_Hora.getText().equals("")) {
					txt_Hora.setText(Workers.obterHora());
					txtData.setText(Workers.obterData());
				}

				Sala s = new Sala((String) comboBox_Sala.getSelectedItem());
				TipoObjecto to = new TipoObjecto((String) comboBox_Objecto
						.getSelectedItem());

				if (rdbtnRegisto.isSelected()) {

					try {
						Cms.registarObjectos(txtDocente.getText(),
								txtData.getText(), txt_Hora.getText(), s, to);
						JOptionPane.showMessageDialog(null, "Requisitado");

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();

					}
				} else {
					try {
						if (Workers.requisiçoesObjectos(txtDocente.getText(),
								(String) comboBox_Sala.getSelectedItem(),
								(String) comboBox_Objecto.getSelectedItem()) == true) {

							Cms.devolverObjectos(txtDocente.getText(), (String) comboBox_Sala.getSelectedItem(), (String) comboBox_Objecto.getSelectedItem(),
									txtData.getText(), txt_Hora.getText());
							JOptionPane.showMessageDialog(null, "Devolvido!");
						} else {
							JOptionPane.showMessageDialog(null,
									"Não Existe o Registo!");
						}

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				try {
					Cms.saves();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				txt_Hora.setText("");
				txtData.setText("");

			}
		});
		btnRegistar.setBounds(373, 226, 89, 23);
		contentPaneSalas.add(btnRegistar);

		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txt_Hora.setText("");
				txtData.setText("");
				txtDocente.setText("");
			}
		});
		btnLimpar.setBounds(373, 277, 89, 23);
		contentPaneSalas.add(btnLimpar);
	}
}
