package pt.cms.controler;

import java.io.FileNotFoundException;

import pt.cms.view.Login;


public class Init {

	
	public static void main(String[] args) {
		
		// 1. Chamar o load
		try {
			Cms.load();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		// 2. Chamar a primeira JFrame
		Login f = new Login();
		f.setVisible(true);
		
		
		
		
		
		
		}
	
	
	
	
}
