package pt.cms.model;
import java.util.ArrayList;




public class Requisição {
	
	private int cod;
	private String id;
	private String dataEntrada;
	private String horaEntrada;
	private Sala s;
	private TipoObjecto to;
	private String dataSaida;
	private String horaSaida;
	
	
	
	
	public Requisição(int cod, String id, String dataEntrada, String horaEntrada,
			Sala s, TipoObjecto to, String dataSaida, String horaSaida) {
		super();
		this.cod=cod;
		this.id = id;
		this.dataEntrada = dataEntrada;
		this.horaEntrada = horaEntrada;
		this.s = s;
		this.to = to;
		this.dataSaida = dataSaida;
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
	 * @return the dataEntrada
	 */
	public String getDataEntrada() {
		return dataEntrada;
	}




	/**
	 * @param dataEntrada the dataEntrada to set
	 */
	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}




	/**
	 * @return the horaEntrada
	 */
	public String getHoraEntrada() {
		return horaEntrada;
	}




	/**
	 * @param horaEntrada the horaEntrada to set
	 */
	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}




	/**
	 * @return the s
	 */
	public Sala getS() {
		return s;
	}




	/**
	 * @param s the s to set
	 */
	public void setS(Sala s) {
		this.s = s;
	}




	/**
	 * @return the to
	 */
	public TipoObjecto getTo() {
		return to;
	}




	/**
	 * @param to the to to set
	 */
	public void setTo(TipoObjecto to) {
		this.to = to;
	}




	/**
	 * @return the dataSaida
	 */
	public String getDataSaida() {
		return dataSaida;
	}




	/**
	 * @param dataSaida the dataSaida to set
	 */
	public void setDataSaida(String dataSaida) {
		this.dataSaida = dataSaida;
	}




	/**
	 * @return the horaSaida
	 */
	public String getHoraSaida() {
		return horaSaida;
	}




	/**
	 * @param horaSaida the horaSaida to set
	 */
	public void setHoraSaida(String horaSaida) {
		this.horaSaida = horaSaida;
	}
	
	
	
	
	
}
	
	
	