package pt.cms.controler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import javax.swing.JOptionPane;

import pt.cms.model.AcessoSala;
import pt.cms.model.Importação;
import pt.cms.model.Requisição;
import pt.cms.model.Sala;
import pt.cms.model.TipoObjecto;
import pt.cms.model.Utilizador;

public class Cms {

	// Variáveis globais

	public static File pastaFicheiroRequisições = new File("./requisiçãoObjectos");
	public static File pastaFicheirosAcessoSalas=new File("./acessoSalas");

	public static ArrayList<Utilizador> users = new ArrayList<Utilizador>();
	public static ArrayList<TipoObjecto> tipoObjectos = new ArrayList<TipoObjecto>();
	public static ArrayList<Sala> salas = new ArrayList<Sala>();
	public static ArrayList<Requisição> registoObjectos = new ArrayList<Requisição>();
	public static ArrayList<Importação> Importaçoes = new ArrayList<Importação>();
	public static ArrayList<AcessoSala> acessos = new ArrayList<AcessoSala>();
	public static ArrayList<Requisição> listagemRequisiçãoObjectos = new ArrayList<Requisição>();
	public static ArrayList<AcessoSala> listagemAcessosSalas = new ArrayList<AcessoSala>();

	public static File files[] = getFilesSortBy(pastaFicheiroRequisições);
	public static File acesso[]=getFilesSortBy(pastaFicheirosAcessoSalas);

	static File utlizadoresTxt = new File("Utilizadores.txt");
	static File salaTxt = new File("Salas.txt");
	static File objectosTxt = new File("Objectos.txt");
	static File registoObjectosTxt = new File("requisiçãoObjectos/R_"
			+ Workers.obterDataFicheiro() + ".txt");
	static File permissoesTxt = new File("permissoes.txt");
	public static File importarTxt = new File("");
	static File acessoSalasTxt = new File("./acessoSalas/A_" + Workers.obterDataFicheiro()
			+ ".txt");

	static Scanner inFile = new Scanner("");

	// Métodos mais importantes (load, save,...)
	public static void load() throws FileNotFoundException {
		// ler os utilizadores para um arraylist
		inFile = new Scanner(utlizadoresTxt);
		while (inFile.hasNextLine()) {
			String line = inFile.nextLine();
			String[] fields = line.split("#");
			Utilizador u = new Utilizador(fields[0], fields[1], fields[2]);
			users.add(u);
		}
		inFile.close();

		// ler as salas para um arraylist
		inFile = new Scanner(salaTxt);
		while (inFile.hasNextLine()) {
			String line = inFile.nextLine();
			Sala s = new Sala(line);
			salas.add(s);
		}
		inFile.close();

		// ler os objectos para um array list

		inFile = new Scanner(objectosTxt);
		while (inFile.hasNextLine()) {
			String line = inFile.nextLine();
			String[] fields = line.split("#");
			TipoObjecto tObjecto = new TipoObjecto(fields[0], fields[1]);
			tipoObjectos.add(tObjecto);
		}
		inFile.close();

		// ler os ficheiro de requisição de objectos do proprio dia para um
		// array
		if (registoObjectosTxt.exists()) {
			inFile = new Scanner(registoObjectosTxt);
			while (inFile.hasNextLine()) {
				String line = inFile.nextLine();
				String[] fields = line.split("#");
				int cod = Integer.parseInt(fields[0]);
				Sala s = new Sala(fields[4]);
				TipoObjecto to = new TipoObjecto(fields[5]);

				Requisição rObjecto = new Requisição(cod, fields[1], fields[2],
						fields[3], s, to, fields[6], fields[7]);
				registoObjectos.add(rObjecto);
			}
			inFile.close();
		} else {
			try {
				registoObjectosTxt.createNewFile();
			} catch (IOException e) {

				e.getMessage();
			}
		}

		// ler o ficheiro dos acessos às salas
		if (acessoSalasTxt.exists()) {
			inFile = new Scanner(acessoSalasTxt);
			while (inFile.hasNextLine()) {
				String line = inFile.nextLine();
				String[] fields = line.split("#");
				 int cod = Integer.parseInt(fields[0]);
				Sala s = new Sala(fields[4]);
				AcessoSala aSalas = new AcessoSala(cod, fields[1], fields[2],
						fields[3], s, fields[5], fields[6], fields[7]);

				acessos.add(aSalas);
			}
			inFile.close();
		} else {
			try {
				acessoSalasTxt.createNewFile();
			} catch (IOException e) {

				e.getMessage();
			}
		}

		// ler o ficheiro das permissões

		inFile = new Scanner(permissoesTxt);
		while (inFile.hasNextLine()) {
			String line = inFile.nextLine();
			String[] fields = line.split("#");
			Sala s = new Sala(fields[0]);
			Importação u = new Importação(s, fields[1], fields[2], fields[3],
					fields[4]);
			Importaçoes.add(u);
		}
		inFile.close();

	}

	public static File[] getFilesSortBy(File folder) {

		if (!folder.isDirectory())
			return null;

		File files[] = folder.listFiles();

		Arrays.sort(files, new Comparator<Object>() {

			public int compare(final Object o1, final Object o2) {
				return new Long(((File) o1).lastModified()).compareTo(new Long(
						((File) o2).lastModified()));

			}
		});

		return files;
	}

	public static void abrirFicheiroRequisiçõesListagens () throws FileNotFoundException{
		
		listagemRequisiçãoObjectos.clear();
		for (File file : files) {
            String nomeFicheiroAbrir=file.getName() ;
            
            File listTxt = new File("requisiçãoObjectos/"+nomeFicheiroAbrir);
            
    		inFile = new Scanner(listTxt);
    		
    		while (inFile.hasNextLine()) {
    			String line = inFile.nextLine();
    			String[] fields = line.split("#");
    			int cod = Integer.parseInt(fields[0]);
    			Sala s = new Sala(fields[4]);
    			TipoObjecto to= new TipoObjecto(fields[5]);
    			
    			Requisição r = new Requisição(cod, fields[1], fields[2], fields[3], s, to, fields[6], fields[7]);
    			listagemRequisiçãoObjectos.add(r);
    		}
    		inFile.close();
            
            
            
        }
		
		
		
		
	}
	
public static void abrirFicheiroAcessoSalasListagens () throws FileNotFoundException{
		
		listagemAcessosSalas.clear();
		for (File file : acesso) {
            String nomeFicheiroAbrir=file.getName() ;
            
            File listTxt = new File("acessoSalas/"+nomeFicheiroAbrir);
            
    		inFile = new Scanner(listTxt);
    		
    		while (inFile.hasNextLine()) {
    			String line = inFile.nextLine();
    			String[] fields = line.split("#");
    			int cod = Integer.parseInt(fields[0]);
    			Sala s = new Sala(fields[4]);
    			
    			
    			AcessoSala r = new AcessoSala(cod, fields[1], fields[2], fields[3], s, fields[5], fields[6], fields[7]);
    			listagemAcessosSalas.add(r);
    		}
    		inFile.close();
            
            
            
        }
		
		
		
		
	}

public static void saves() throws IOException {

		PrintWriter out = new PrintWriter(utlizadoresTxt);

		for (Utilizador u : users) {

			out.println(u.getTipoUtilizador() + "#" + u.getId() + "#"
					+ u.getPassword());

		}
		out.close();

		PrintWriter out1 = new PrintWriter(salaTxt);

		for (Sala s : salas) {

			out1.println(s.getSala());

		}
		out1.close();

		PrintWriter out2 = new PrintWriter(objectosTxt);

		for (TipoObjecto tipo : tipoObjectos) {

			out2.println(tipo.getCodObjecto() + "#" + tipo.getTipoObjecto());

		}
		out2.close();

		// registar em ficheiro os registos efectuados

		PrintWriter out3 = new PrintWriter(registoObjectosTxt);

		for (int i = 0; i < registoObjectos.size(); i++) {

			Requisição objecto = registoObjectos.get(i);

			out3.println(objecto.getCod() + "#" + objecto.getId() + "#"
					+ objecto.getDataEntrada() + "#" + objecto.getHoraEntrada()
					+ "#" + objecto.getS() + "#" + objecto.getTo() + "#"
					+ objecto.getDataSaida() + "#" + objecto.getHoraSaida());
		}
		out3.close();

		// registar em ficheiro as permissoes importadas
		PrintWriter out4 = new PrintWriter(permissoesTxt);

		for (Importação u : Importaçoes) {

			out4.println(u.getS() + "#" + u.getId() + "#" + u.getNome() + "#"
					+ u.getTurma() + "#" + u.getAno());

		}
		out4.close();
		// registar em ficheiro os acessos efetuados

		PrintWriter out5 = new PrintWriter(acessoSalasTxt);
		for (int j = 0; j < acessos.size(); j++) {

			AcessoSala acesso = acessos.get(j);

			out5.println(acesso.getCod()+"#"+acesso.getU() + "#" + acesso.getDataEntrada() + "#"
					+ acesso.getHoraEntrada() + "#" + acesso.getS() + "#"
					+ acesso.getChave() + "#" + acesso.getDataSaida() + "#"
					+ acesso.getHoraSaida());

		}

		out5.close();

	}

	public static void removerUtilizador(String utilizador) {

		for (int i = 0; i < Cms.users.size(); i++) {

			Utilizador u = Cms.users.get(i);

			if (u.getId().equals(utilizador)) {
				Cms.users.remove(i);

			}
		}

	}

	public static void adicionarUtilizador(String tipoUtilizador, String id,
			String password) {

		Utilizador u = new Utilizador(tipoUtilizador, id, password);

		users.add(u);

	}

	public static void adicionarSala(String sala) {

		Sala s = new Sala(sala);
		salas.add(s);

	}

	public static void removerSala(String sala) {

		for (int i = 0; i < Cms.salas.size(); i++) {

			Sala s = Cms.salas.get(i);

			if (s.getSala().equals(sala)) {

				Cms.salas.remove(i);
			}

		}

	}

	public static void adicionarObjecto(String codObj, String obj) {

		TipoObjecto tipo = new TipoObjecto(codObj, obj);
		tipoObjectos.add(tipo);

	}

	public static void removerObjectos(String obj) {

		for (int i = 0; i < Cms.tipoObjectos.size(); i++) {

			TipoObjecto tipo = Cms.tipoObjectos.get(i);

			if (tipo.getTipoObjecto().equals(obj)) {

				Cms.tipoObjectos.remove(i);
			}

		}

	}

	// metodo para registar os objectos
	public static void registarObjectos(String Docente, String Data,
			String hora, Sala s, TipoObjecto obj) throws IOException {
		
			TipoObjecto obj1=new TipoObjecto(Workers.devolverCodigoObjecto(obj.getTipoObjecto()));
			

		Requisição req = new Requisição(getLastCode(registoObjectos), Docente, Data, hora, s,
				obj1, " ", " ");

		registoObjectos.add(req);

	}

	// metodo para devolver os objectos
	public static void devolverObjectos(String id, String s, String to,
			String Data, String hora) throws IOException {

		
		
		
		for (int i = 0; i < registoObjectos.size(); i++) {

			if (registoObjectos.get(i).getId().equals(id)
					&& registoObjectos.get(i).getS().toString().equals(s)
					&& registoObjectos.get(i).getTo().getTipoObjecto().equals(Workers.devolverCodigoObjecto(to))) {
				registoObjectos.get(i).setDataSaida(Data);
				registoObjectos.get(i).setHoraSaida(hora);
			}

		}

		Cms.saves();

	}

	// metodo para a importação vai iterar sobre o array permissoes e verificar
	// se os alunos já têm permissoes

	public static void importação(String sala) throws FileNotFoundException {

		inFile = new Scanner(importarTxt);
		while (inFile.hasNextLine()) {
			String line = inFile.nextLine();
			String[] fields = line.split(";");

			String numero = fields[0];

			boolean res = false;
			for (Importação imp : Cms.Importaçoes) {
				if (imp.getS().getSala().equals(sala)
						&& imp.getId().equals(numero)) {
					res = true;
				}
			}

			if (!res) {
				// Obter objeto Sala
				for (Sala s : Cms.salas) {
					if (s.getSala().equals(sala)) {
						Importação u = new Importação(s, fields[0], fields[1],
								fields[2], fields[3]);
						Importaçoes.add(u);

					}

				}

			}
		}
		inFile.close();
	}

	// metodo para gerar codigos das linhas dos ficheiros

	public static int getLastCode(ArrayList array) {

		int codigo = array.size() + 1;

		return codigo;
	}

	// metodo para acesso de salas
	public static void acessoSalas(String u, String dataEntrada,
			String horaEntrada, Sala s, String chave) {

		AcessoSala ace = new AcessoSala(getLastCode(acessos), u, dataEntrada, horaEntrada, s, chave,
				" ", " ");
		acessos.add(ace);

	}

	// metodo para devolver acessos

	public static void devolveracesso(String u, String dataSaida,
			String horaSaida) throws IOException {

		for (int i = 0; i < acessos.size(); i++) {

			if (acessos.get(i).getU().equals(u)) {
				acessos.get(i).setDataSaida(dataSaida);
				acessos.get(i).setHoraSaida(horaSaida);
			}

		}
	}
	

	
}


