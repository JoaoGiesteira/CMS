package pt.cms.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import pt.cms.controler.Cms;
import pt.cms.controler.Workers;
import pt.cms.model.TipoObjecto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

public class ListagensObjectos extends JFrame {

	private JPanel contentPane;
	private JTextField txtDataInicio;
	private JTextField txtDataFim;
	private JTable table;
	DefaultTableModel dtm = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListagensObjectos frame = new ListagensObjectos();
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
	public ListagensObjectos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 732, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JComboBox comboBox_Objecto = new JComboBox();
		
		for (TipoObjecto to : Cms.tipoObjectos) {

			comboBox_Objecto.addItem(to.getTipoObjecto());
		}
		comboBox_Objecto.setBounds(143, 263, 89, 20);
		contentPane.add(comboBox_Objecto);
		
		JLabel label = new JLabel("Objecto");
		label.setBounds(34, 266, 66, 17);
		contentPane.add(label);
		
		txtDataInicio = new JTextField();
		txtDataInicio.setText(Workers.obterData());
		txtDataInicio.setColumns(10);
		txtDataInicio.setBounds(143, 191, 86, 20);
		contentPane.add(txtDataInicio);
		
		txtDataFim = new JTextField();
		txtDataFim.setText(Workers.obterData());
		txtDataFim.setColumns(10);
		txtDataFim.setBounds(143, 222, 86, 20);
		contentPane.add(txtDataFim);
		
		JLabel label_1 = new JLabel("Data Inicio");
		label_1.setBounds(34, 194, 78, 17);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Data Fim");
		label_2.setBounds(34, 225, 46, 14);
		contentPane.add(label_2);
		
		JButton button_Limpar = new JButton("Limpar");
		button_Limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtm.setRowCount(0);
				
				
			}
		});
		button_Limpar.setBounds(140, 340, 89, 23);
		contentPane.add(button_Limpar);
		
		
		
		JLabel label_3 = new JLabel("Informa\u00E7\u00E3o");
		label_3.setBounds(298, 111, 78, 14);
		contentPane.add(label_3);
		
		
		JButton button_Listar = new JButton("Listar");
		button_Listar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				Cms.getFilesSortBy(Cms.pastaFicheiroRequisições);
				try {
					Cms.abrirFicheiroRequisiçõesListagens();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					dtm.setRowCount(0);
					Workers.listarRequisiçõesObjecto(txtDataInicio.getText(), txtDataFim.getText(),(String)comboBox_Objecto.getSelectedItem(), dtm);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button_Listar.setBounds(34, 340, 89, 23);
		contentPane.add(button_Listar);
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(298, 129, 352, 270);
		contentPane.add(scrollPane);
		
		
		// Criar os cabeçalhos da tabela
		dtm.addColumn("Nº");
		dtm.addColumn("ID");
		dtm.addColumn("Sala");
		dtm.addColumn("Data Requisição");
		
		table = new JTable(dtm);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setPreferredScrollableViewportSize(new Dimension(500, 50));			
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		
	}
}
