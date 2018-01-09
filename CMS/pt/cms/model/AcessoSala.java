package pt.cms.model;



public class AcessoSala {
	
	private int cod;
	private String u;
	private String dataEntrada;
	private String horaEntrada;
	private Sala s;
	private String chave;
	private String dataSaida;
	private String horaSaida;
	
	
	
	public AcessoSala(int cod, String u, String dataEntrada,
			String horaEntrada, Sala s, String chave, String dataSaida,
			String horaSaida) {
		super();
		this.cod = cod;
		this.u = u;
		this.dataEntrada = dataEntrada;
		this.horaEntrada = horaEntrada;
		this.s = s;
		this.chave = chave;
		this.dataSaida = dataSaida;
		this.horaSaida = horaSaida;
	}
	
	public String getU() {
		return u;
	}
	public void setU(String u) {
		this.u = u;
	}
	public String getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public String getHoraEntrada() {
		return horaEntrada;
	}
	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	public Sala getS() {
		return s;
	}
	public void setS(Sala s) {
		this.s = s;
	}
	public String getChave() {
		return chave;
	}
	public void setChave(String chave) {
		this.chave = chave;
	}
	public String getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(String dataSaida) {
		this.dataSaida = dataSaida;
	}
	public String getHoraSaida() {
		return horaSaida;
	}
	public void setHoraSaida(String horaSaida) {
		this.horaSaida = horaSaida;
	}
	/**
	 * @return the cod
	 */
	public int getCod() {
		return cod;
	}
	/**
	 * @param cod the cod to set
	 */
	public void setCod(int cod) {
		this.cod = cod;
	}
	
	
}
