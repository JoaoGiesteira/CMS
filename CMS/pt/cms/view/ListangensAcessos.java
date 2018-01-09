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
import pt.cms.model.Sala;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

public class ListangensAcessos extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDataInicio;
	private JTextField textFieldDataFim;
	private JTable table;
	DefaultTableModel dtm = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListangensAcessos frame = new ListangensAcessos();
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
	public ListangensAcessos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 662, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JComboBox comboBoxSala = new JComboBox();
		for (Sala s : Cms.salas) {

			comboBoxSala.addItem(s.getSala());
		}
		comboBoxSala.setBounds(129, 235, 89, 20);
		contentPane.add(comboBoxSala);
		
		JLabel lblSala = new JLabel("Sala");
		lblSala.setBounds(20, 238, 66, 17);
		contentPane.add(lblSala);
		
		textFieldDataInicio = new JTextField();
		textFieldDataInicio.setBounds(129, 163, 86, 20);
		contentPane.add(textFieldDataInicio);
		textFieldDataInicio.setColumns(10);
		
		textFieldDataFim = new JTextField();
		textFieldDataFim.setBounds(129, 194, 86, 20);
		contentPane.add(textFieldDataFim);
		textFieldDataFim.setColumns(10);
		
		JLabel lblDataInicio = new JLabel("Data Inicio");
		lblDataInicio.setBounds(20, 166, 78, 17);
		contentPane.add(lblDataInicio);
		
		JLabel lblDataFim = new JLabel("Data Fim");
		lblDataFim.setBounds(20, 197, 46, 14);
		contentPane.add(lblDataFim);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(126, 312, 89, 23);
		contentPane.add(btnLimpar);
		
		
		
		JLabel lblInformao = new JLabel("Informa\u00E7\u00E3o");
		lblInformao.setBounds(284, 83, 78, 14);
		contentPane.add(lblInformao);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Cms.getFilesSortBy(Cms.pastaFicheirosAcessoSalas);
				try {
					Cms.abrirFicheiroAcessoSalasListagens();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					dtm.setRowCount(0);
					Workers.listarAcessoSalas(textFieldDataInicio.getText(), textFieldDataFim.getText(), (String)comboBoxSala.getSelectedItem(), dtm);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		btnListar.setBounds(20, 312, 89, 23);
		contentPane.add(btnListar);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(284, 101, 352, 270);
		contentPane.add(scrollPane);
		dtm.addColumn("Nº");
		dtm.addColumn("ID");
		dtm.addColumn("Sala");
		dtm.addColumn("Data");
			
		
		table = new JTable(dtm);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setPreferredScrollableViewportSize(new Dimension(500, 50));
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		
	}

}
