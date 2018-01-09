package pt.cms.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import pt.cms.controler.Cms;
import pt.cms.controler.ManagerUser;
import pt.cms.model.Utilizador;

import javax.swing.JList;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class ConfiguraçõesUtilizadores extends JFrame {

	private JPanel contentPane;
	private JTextField txt_Utilizador;
	private JPasswordField txt_password;
	private JPasswordField txt_ConfirmarPassword;
	private JTextField listaUtilizadores;
	private DefaultListModel<String> dlm = new DefaultListModel<String>();
	JList list_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfiguraçõesUtilizadores frame = new ConfiguraçõesUtilizadores();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void refresh() {
		dlm.setSize(0);
		for (Utilizador u : Cms.users) {
			dlm.addElement(u.getId());
		}
	}

	/**
	 * Create the frame.
	 */
	public ConfiguraçõesUtilizadores() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 828, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txt_Utilizador = new JTextField();
		txt_Utilizador.setBounds(123, 179, 86, 20);
		contentPane.add(txt_Utilizador);
		txt_Utilizador.setColumns(10);

		JLabel lblUtilizador = new JLabel("Utilizador");
		lblUtilizador.setBounds(21, 181, 81, 17);
		contentPane.add(lblUtilizador);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(21, 222, 46, 14);
		contentPane.add(lblPassword);

		JLabel lblConfirmarPassword = new JLabel("Confirmar Password");
		lblConfirmarPassword.setBounds(10, 247, 113, 14);
		contentPane.add(lblConfirmarPassword);

		txt_password = new JPasswordField();
		txt_password.setBounds(123, 210, 86, 20);
		contentPane.add(txt_password);

		txt_ConfirmarPassword = new JPasswordField();
		txt_ConfirmarPassword.setBounds(123, 245, 86, 17);
		contentPane.add(txt_ConfirmarPassword);

		JLabel lblUtilizadores = new JLabel("Utilizadores");
		lblUtilizadores.setBounds(412, 115, 89, 14);
		contentPane.add(lblUtilizadores);

		JRadioButton rdbtnSegurança = new JRadioButton("Seguran\u00E7a");
		rdbtnSegurança.setBounds(123, 111, 94, 23);
		contentPane.add(rdbtnSegurança);

		JRadioButton rdbtnAdministrador = new JRadioButton("Administrador");
		rdbtnAdministrador.setBounds(14, 111, 109, 23);
		contentPane.add(rdbtnAdministrador);

		JRadioButton rdbtnUtilizador = new JRadioButton("Utilizador");
		rdbtnUtilizador.setBounds(219, 111, 109, 23);
		contentPane.add(rdbtnUtilizador);

		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnSegurança);
		group.add(rdbtnAdministrador);
		group.add(rdbtnUtilizador);

		//
		refresh();
		list_1 = new JList(dlm);
		list_1.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (list_1.getSelectedIndex() != -1) {
					txt_Utilizador
							.setText(list_1.getSelectedValue().toString());
				}

			}
		});
		list_1.setBounds(402, 164, 163, 179);

		contentPane.add(list_1);
		//

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (ManagerUser.isUserExists(txt_Utilizador.getText()) == true) {

					JOptionPane.showMessageDialog(null,
							"Utilizador Já Existente");

				}

				else {

					if (ManagerUser.isUser(txt_Utilizador.getText(),
							String.valueOf(txt_password.getPassword())) == false
							&& String.valueOf(txt_password.getPassword())
									.equals(String
											.valueOf(txt_ConfirmarPassword
													.getPassword()))) {

						if (rdbtnAdministrador.isSelected()) {

							Cms.adicionarUtilizador("Admin",
									txt_Utilizador.getText(),
									String.valueOf(txt_password.getPassword()));
							JOptionPane.showMessageDialog(null, "Adicionado!");
							refresh();
						} else if (rdbtnSegurança.isSelected()) {

							Cms.adicionarUtilizador("Segurança",
									txt_Utilizador.getText(),
									String.valueOf(txt_password.getPassword()));
							JOptionPane.showMessageDialog(null, "Adicionado!");
							refresh();
						} else if (rdbtnUtilizador.isSelected()) {

							Cms.adicionarUtilizador("Utilizador",
									txt_Utilizador.getText(),
									String.valueOf(txt_password.getPassword()));
							JOptionPane.showMessageDialog(null, "Adicionado!");
							refresh();
						}

					} else if (String.valueOf(txt_password.getPassword()) != (String
							.valueOf(txt_ConfirmarPassword.getPassword()))) {
						JOptionPane.showMessageDialog(null,
								"As Passwords Não Coincidem!");
					}
					if ( !rdbtnAdministrador.isSelected() ||!rdbtnSegurança.isSelected()|| !rdbtnUtilizador.isSelected()  ){
						JOptionPane.showMessageDialog(null,
								"Tipo de Utilizador Não Selecionado!");
					}
				}
				try {
					Cms.saves();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAdicionar.setBounds(21, 345, 89, 23);
		contentPane.add(btnAdicionar);

		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (ManagerUser.isUserExists(txt_Utilizador.getText()) == true) {

					Cms.removerUtilizador(txt_Utilizador.getText());
					JOptionPane
							.showMessageDialog(null, "Removido com Sucesso!");
					refresh();

				} else if (ManagerUser.isUserExists(txt_Utilizador.getText()) == false) {
					JOptionPane.showMessageDialog(null,
							"Utilizador Não Existente!");
				}

				try {
					Cms.saves();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnRemover.setBounds(159, 345, 89, 23);
		contentPane.add(btnRemover);

	}
}
