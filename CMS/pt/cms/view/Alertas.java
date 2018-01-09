package pt.cms.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.naming.ldap.Rdn;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import pt.cms.controler.Cms;
import pt.cms.controler.Workers;
import pt.cms.model.Requisição;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.table.TableModel;

import java.awt.Component;

import javax.swing.JRadioButton;

public class Alertas extends JFrame {

	private JPanel contentPane;

	DefaultTableModel dtm = new DefaultTableModel();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Alertas frame = new Alertas();
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
	public Alertas() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 660, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JRadioButton rdbtnAcessoSalas = new JRadioButton("Acesso Salas");
		rdbtnAcessoSalas.setBounds(17, 84, 109, 23);
		contentPane.add(rdbtnAcessoSalas);

		JRadioButton rdbtnRequisioObjectos = new JRadioButton(
				"Requisi\u00E7\u00E3o Objectos");
		rdbtnRequisioObjectos.setSelected(true);
		rdbtnRequisioObjectos.setBounds(17, 58, 123, 23);
		contentPane.add(rdbtnRequisioObjectos);

		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnAcessoSalas);
		group.add(rdbtnRequisioObjectos);

		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				

				if (rdbtnRequisioObjectos.isSelected()) {
					dtm.setRowCount(0);
					
					// Cria os cabeçalhos da tabela
					/*	dtm.addColumn("ID");
						dtm.addColumn("Sala");
						dtm.addColumn("Tipo Objecto");*/
					dtm.setColumnCount(0);
					dtm.addColumn("ID");
					dtm.addColumn("Sala");
					dtm.addColumn("Tipo Objecto");
					Workers.alertasRequisições(dtm);
				} else {
					dtm.setRowCount(0);
					dtm.setColumnCount(0);
					
					dtm.addColumn("ID");
					dtm.addColumn("Sala");
					Workers.alertasAcessos(dtm);

				}

			}
		});
		btnActualizar.setBounds(10, 209, 89, 23);
		contentPane.add(btnActualizar);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(178, 11, 393, 309);
		contentPane.add(scrollPane);

	

		table = new JTable(dtm);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setPreferredScrollableViewportSize(new Dimension(500, 50));
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);

	}
}
