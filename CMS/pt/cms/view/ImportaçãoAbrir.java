package pt.cms.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pt.cms.controler.Cms;
import pt.cms.controler.Workers;

public class ImportaçãoAbrir extends JFrame {
	public static JTextField dir = new JTextField();

  private JButton btnAbrir = new JButton("Abrir"), btnImportar = new JButton("Importar");
  public static JTextField filename;

  public ImportaçãoAbrir() {
    Container cp = getContentPane();
    setBounds(100, 100, 671, 459);
    getContentPane().setLayout(null);
    btnAbrir.setBounds(44, 143, 86, 23);
    getContentPane().add(btnAbrir);
    btnImportar.setBounds(44, 247, 96, 23);
    getContentPane().add(btnImportar);
    dir.setBounds(152, 143, 261, 23);
    getContentPane().add(dir);
    
    filename = new JTextField();
    filename.setBounds(152, 177, 261, 20);
    getContentPane().add(filename);
    filename.setColumns(10);
    btnImportar.addActionListener(new SaveL());
    btnAbrir.addActionListener(new OpenL());
  }

  class OpenL implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      JFileChooser c
      = new JFileChooser();
      // Demonstrate "Open" dialog:
      int rVal = c.showOpenDialog(ImportaçãoAbrir.this);
      if (rVal == JFileChooser.APPROVE_OPTION) {
        filename.setText(c.getSelectedFile().getName());
        dir.setText(c.getCurrentDirectory().toString());
        
      }
      if (rVal == JFileChooser.CANCEL_OPTION) {
        filename.setText("You pressed cancel");
        dir.setText("");
      }
    }
  }

  
  
  class SaveL implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      
    	String nomeFicheiro=filename.getText().substring(0, 4);
    	Cms.importarTxt= new File(Workers.obterNomeFicheiroImportar(dir.getText(),filename.getText()));
    	
    	try {
    		   		
    		
			Cms.importação(nomeFicheiro);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	try {
			Cms.saves();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    }
  }

  public static void main(String[] args) {
    run(new ImportaçãoAbrir(), 250, 110);
  }

  public static void run(JFrame frame, int width, int height) {
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(width, height);
    frame.setVisible(true);
  }
} 

