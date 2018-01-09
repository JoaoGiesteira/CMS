package pt.cms.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;

import pt.cms.controler.Cms;
import pt.cms.controler.Workers;
import pt.cms.model.TipoObjecto;
import pt.cms.model.Utilizador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

import javax.swing.JList;

public class ConfiguraçõesObjectos extends JFrame {

	private JPanel contentPane;
	private JTextField txt_Objecto;
	private JButton btnAdicionar;
	private JButton btnRemover;
	private JTable table;
	private JLabel lblObjectos;
	private JList list_Salas = new JList();
	private DefaultListModel<String> dlm= new DefaultListModel<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfiguraçõesObjectos frame = new ConfiguraçõesObjectos();
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
		for (TipoObjecto u: Cms.tipoObjectos) {        	
        	dlm.addElement(u.getTipoObjecto());
        }
	}
	
	
	public ConfiguraçõesObjectos() {
		refresh();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 855, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt_Objecto = new JTextField();
		txt_Objecto.setBounds(154, 155, 86, 20);
		contentPane.add(txt_Objecto);
		txt_Objecto.setColumns(10);
		
		JLabel lblObjecto = new JLabel("Objecto");
		lblObjecto.setBounds(50, 158, 46, 14);
		contentPane.add(lblObjecto);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (Workers.isobjecto(txt_Objecto.getText())==false){
					int a = Cms.getLastCode(Cms.tipoObjectos);
					String b=Integer.toString(a);
					
					Cms.adicionarObjecto(b, txt_Objecto.getText());
					JOptionPane.showMessageDialog(null, "Objecto Adicionado!");
					refresh();
				}
				else {
					JOptionPane.showMessageDialog(null, "Objecto Já Existente!");
				}
				
				try {
					Cms.saves();
				} catch (Exception  e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAdicionar.setBounds(28, 347, 89, 23);
		contentPane.add(btnAdicionar);
		
		btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (Workers.isobjectoRemover(txt_Objecto.getText())==true){
					
					Cms.removerObjectos(txt_Objecto.getText());
					JOptionPane.showMessageDialog(null, "Objecto Removido!");
					refresh();
				}
				else {
					JOptionPane.showMessageDialog(null, "Não Existe!");
				}
				
				try {
					Cms.saves();
				} catch (Exception  e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnRemover.setBounds(141, 347, 89, 23);
		contentPane.add(btnRemover);
		
		
		
		
		list_Salas = new JList(dlm);
		list_Salas.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(list_Salas.getSelectedIndex()!=-1) {
					txt_Objecto.setText(list_Salas.getSelectedValue().toString());
				}
				
			}
		});
		list_Salas.setBounds(422, 124, 209, 225);
		contentPane.add(list_Salas);
		
		
	}
}
