package pt.cms.model;
import java.util.ArrayList;


public class Importação {
	
	private Sala s;
	private String id;
	private String nome;
	private String turma;
	private String ano;
	
	public Importação(Sala s, String id, String nome, String turma, String ano) {
		super();
		this.s = s;
		this.id = id;
		this.nome = nome;
		this.turma = turma;
		this.ano = ano;
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
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the turma
	 */
	public String getTurma() {
		return turma;
	}

	/**
	 * @param turma the turma to set
	 */
	public void setTurma(String turma) {
		this.turma = turma;
	}

	/**
	 * @return the ano
	 */
	public String getAno() {
		return ano;
	}

	/**
	 * @param ano the ano to set
	 */
	public void setAno(String ano) {
		this.ano = ano;
	}
	
	
	
	
	
	
}
