package pt.cms.controler;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.table.DefaultTableModel;

import pt.cms.model.AcessoSala;
import pt.cms.model.Importação;
import pt.cms.model.Requisição;
import pt.cms.model.Sala;
import pt.cms.model.TipoObjecto;
import pt.cms.model.Utilizador;

public class Workers {

	// metodo para verificar se o registo das requisiçoes de objectos existe

	public static boolean requisiçoesObjectos(String id, String sala, String obj) {
		boolean res = false;
		for (Requisição req : Cms.registoObjectos) {

			if (req.getId().equals(id)
					&& req.getS().toString().equals(sala)
					&& req.getTo().toString()
							.equals(Workers.devolverCodigoObjecto(obj))) {
				res = true;
			}

		}

		return res;
	}

	// verificar se a sala existe

	public static boolean isSala(String sala) {
		boolean res = false;

		for (Sala s : Cms.salas) {
			if (s.getSala().equals(sala)) {
				res = true;
			}
		}
		return res;
	}

	// verificar se o objecto existe

	public static boolean isobjecto(String objecto) {
		boolean res = false;

		for (TipoObjecto tipo : Cms.tipoObjectos) {
			if (tipo.getTipoObjecto().equals(objecto)) {
				res = true;
			}
		}
		return res;
	}

	// verificar e remover objectos

	public static boolean isobjectoRemover(String objecto) {
		boolean res = false;

		for (TipoObjecto tipo : Cms.tipoObjectos) {
			if (tipo.getTipoObjecto().equals(objecto)) {
				res = true;
			}
		}
		return res;
	}

	// metodo para obter data

	public static String obterData() {

		String data = "dd/MM/yyyy";
		String data1;
		java.util.Date agora = new java.util.Date();
		SimpleDateFormat formata = new SimpleDateFormat(data);
		data1 = formata.format(agora);

		return data1;

	}

	public static String obterDataFicheiro() {

		String data = "ddMMyyyy";
		String data1 = obterData();
		java.util.Date agora = new java.util.Date();
		SimpleDateFormat formata = new SimpleDateFormat(data);
		data1 = formata.format(agora);

		return data1;

	}

	// metodo para obter hora
	public static String obterHora() {
		String hora = "HH:mm";
		String hora1;
		java.util.Date agora = new java.util.Date();
		SimpleDateFormat formata = new SimpleDateFormat(hora);
		hora1 = formata.format(agora);

		return hora1;

	}

	// metodo para obter nome do ficheiro a importar

	public static String obterNomeFicheiroImportar(String diretorio, String nome) {

		String nome1 = nome.substring(0, 4);

		return diretorio + "\\" + nome1 + ".txt";
	}

	public static boolean isAluno(String sala, String id) {
		boolean res = false;

		for (int i = 0; i < Cms.Importaçoes.size(); i++) {

			Importação imp = Cms.Importaçoes.get(i);

			if (imp.getId().equals(id) && imp.getS().toString().equals(sala)) {
				res = true;
			}

		}
		return res;
	}

	// metodo para escrever os alertas das requisiçoes numa jlist
	public static void alertasRequisições(DefaultTableModel dtm) {
		for (int i = 0; i < Cms.registoObjectos.size(); i++) {
			Requisição c = Cms.registoObjectos.get(i);
			if (c.getDataSaida().equals(" ") && c.getHoraSaida().equals(" ")) {
				dtm.addRow(new Object[] { c.getId(), c.getS().getSala(), c.getTo().getTipoObjecto() });
			}
		}
	}

	// metodo para escrever os alertas dos acessos as salas numa jlist
	public static void alertasAcessos(DefaultTableModel dtm) {
		for (int i = 0; i < Cms.acessos.size(); i++) {
			AcessoSala c = Cms.acessos.get(i);
			if (c.getDataSaida().equals(" ") && c.getHoraSaida().equals(" ")) {
				dtm.addRow(new Object[] { c.getU(), c.getS(), c.getChave() });
			}
		}
	}

	public static void listarRequisiçõesObjecto(String dataInicio,
			String dataFim, String objecto, DefaultTableModel dtm)
			throws Exception {

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date dateInicio = df.parse(dataInicio);
		Date dateFim = df.parse(dataFim);
		int cont = 1;
		for (int i = 0; i < Cms.listagemRequisiçãoObjectos.size(); i++) {

			Requisição req = Cms.listagemRequisiçãoObjectos.get(i);
			
			TipoObjecto obj1=new TipoObjecto(Workers.devolverCodigoObjecto(objecto));
			
			Date dE = df.parse(req.getDataEntrada());

			if ((dateInicio.compareTo(dE) == 0) || (dateFim.compareTo(dE) == 0)
					|| dE.after(dateInicio) && dE.before(dateFim)) {

				if (obj1.getTipoObjecto().equals(req.getTo().getTipoObjecto())) {
					dtm.addRow(new Object[] { cont++, req.getId(),
							req.getS().getSala(), req.getDataEntrada() });
				}

			}

		}

		// converter datas, para poder comparar
		// abrir o arraylistlist e obter a informação necessária para inserir na
		// jtable

		// arraylist- Cms.listagem

		// if (dataInicio.

	}

	public static void listarAcessoSalas(String dataInicio, String dataFim,
			String sala, DefaultTableModel dtm) throws Exception {

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date dateInicio = df.parse(dataInicio);
		Date dateFim = df.parse(dataFim);
		int cont = 1;
		for (int i = 0; i < Cms.listagemAcessosSalas.size(); i++) {

			AcessoSala acesso = Cms.listagemAcessosSalas.get(i);

			Date dE = df.parse(acesso.getDataEntrada());

			if ((dateInicio.compareTo(dE) == 0) || (dateFim.compareTo(dE) == 0)
					|| dE.after(dateInicio) && dE.before(dateFim)) {

				dtm.addRow(new Object[] { cont++, acesso.getU(),
						acesso.getS().getSala(), acesso.getDataEntrada() });

			}

		}

	}

	public static String devolverCodigoObjecto(String tipoObjecto) {

		for (int i = 0; i < Cms.tipoObjectos.size(); i++) {

			TipoObjecto to = Cms.tipoObjectos.get(i);

			if (tipoObjecto.equals(to.getTipoObjecto())) {

				return to.getCodObjecto();
			}

		}

		return "****";

	}

	public static String devolverNomeObjecto(String codObjecto) {

		for (int i = 0; i < Cms.tipoObjectos.size(); i++) {

			TipoObjecto to = Cms.tipoObjectos.get(i);

			if (codObjecto.equals(to.getCodObjecto())) {

				return to.getTipoObjecto();
			}

		}

		return "******";
	}
}
