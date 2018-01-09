package pt.cms.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JTable;

import pt.cms.controler.Cms;
import pt.cms.controler.Workers;
import pt.cms.model.Sala;
import pt.cms.model.TipoObjecto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.ListModel;

public class ConfiguraçõesSalas extends JFrame {

	private JPanel contentPane;
	private JTextField txt_Salas;
	private JList list_Salas = new JList();
	private DefaultListModel<String> dlm= new DefaultListModel<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfiguraçõesSalas frame = new ConfiguraçõesSalas();
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
	
	public void refresh() {
		dlm.setSize(0);
		for (Sala s: Cms.salas) {        	
        	dlm.addElement(s.getSala());
        }
	}
	
	
	
	public ConfiguraçõesSalas() {
		refresh();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 699, 533);
		contentPane = new JPanel();
		contentPane.setToolTipText("B");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSalas = new JLabel("Salas");
		lblSalas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSalas.setBounds(39, 123, 46, 14);
		contentPane.add(lblSalas);
		
		JLabel lblSalas_1 = new JLabel("Salas");
		lblSalas_1.setBounds(296, 80, 46, 14);
		contentPane.add(lblSalas_1);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (Workers.isSala(txt_Salas.getText()) == false){
					Cms.adicionarSala(txt_Salas.getText());
					JOptionPane.showMessageDialog(null, "Adicionado!");
					refresh();
				}
				else if (Workers.isSala(txt_Salas.getText()) == true)
				{
					
					JOptionPane.showMessageDialog(null, "Sala Já Existente!");
									
				}
				
				try {
					Cms.saves();
				} catch (Exception  e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnAdicionar.setBounds(39, 263, 89, 23);
		contentPane.add(btnAdicionar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (Workers.isSala(txt_Salas.getText()) == true){
					Cms.removerSala(txt_Salas.getText());
					JOptionPane.showMessageDialog(null, "Removido!");
					refresh();
				}
				else if (Workers.isSala(txt_Salas.getText()) == false)
				{
					
					JOptionPane.showMessageDialog(null, "Sala Não Existente!");
									
				}
				
				try {
					Cms.saves();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnRemover.setBounds(165, 263, 89, 23);
		contentPane.add(btnRemover);
		
		txt_Salas = new JTextField();
		txt_Salas.setBounds(144, 123, 99, 20);
		contentPane.add(txt_Salas);
		txt_Salas.setColumns(10);
		
		
		
		
		list_Salas = new JList(dlm);
		list_Salas.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(list_Salas.getSelectedIndex()!=-1) {
					txt_Salas.setText(list_Salas.getSelectedValue().toString());
				}
				
			}
		});
		list_Salas.setBounds(422, 124, 209, 225);
		contentPane.add(list_Salas);
		
	
		
		
		
	}
}
