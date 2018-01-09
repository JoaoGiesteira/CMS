package pt.cms.controler;

import pt.cms.model.Utilizador;
;

public class ManagerUser {
	
	public static boolean isUser(String username, String password) {
		boolean res = false;
		
		for (Utilizador u : Cms.users) {
			if (u.getId().equals(username) && u.getPassword().equals(password)) {
				res = true;
			}
		}		
		return res;
	}
	
	public static boolean isUserExists(String username)  {
		boolean res = false;
		
		for (Utilizador u : Cms.users) {
			if (u.getId().equals(username)) {
				res = true;
			}
		}		
		return res;
	}
	
	
	

}
