package pt.cms.model;



public class Utilizador {
	
	
	private String tipoUtilizador;
	private String id;
	private String password;
	
	private TipoUtilizador tu;
	
	
	
	public Utilizador(String tipoUtilizador, String id, String password) {
		super();
		this.tipoUtilizador = tipoUtilizador;
		this.id = id;
		this.password = password;
		
	}
	public Utilizador(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	/**
	 * @return the tipoUtilizador
	 */
	public String getTipoUtilizador() {
		return tipoUtilizador;
	}
	/**
	 * @param tipoUtilizador the tipoUtilizador to set
	 */
	public void setTipoUtilizador(String tipoUtilizador) {
		this.tipoUtilizador = tipoUtilizador;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
	
	
	
	
	

}
