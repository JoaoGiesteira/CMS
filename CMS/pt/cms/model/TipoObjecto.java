package pt.cms.model;

public class TipoObjecto {
	
	private String codObjecto;
	private String tipoObjecto;
	
	
	
	
	public TipoObjecto(String tipoObjecto) {
		super();
		this.tipoObjecto = tipoObjecto;
	}

	public TipoObjecto(String objecto, String tipoObjecto) {
		super();
		this.codObjecto = objecto;
		this.tipoObjecto = tipoObjecto;
	}

	/**
	 * @return the objecto
	 */
	public String getCodObjecto() {
		return codObjecto;
	}

	/**
	 * @param objecto the objecto to set
	 */
	public void setCodObjecto(String objecto) {
		this.codObjecto = objecto;
	}

	/**
	 * @return the tipoObjecto
	 */
	public String getTipoObjecto() {
		return tipoObjecto;
	}

	/**
	 * @param tipoObjecto the tipoObjecto to set
	 */
	public void setTipoObjecto(String tipoObjecto) {
		this.tipoObjecto = tipoObjecto;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return tipoObjecto;
	}

	

}
