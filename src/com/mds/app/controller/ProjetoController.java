package com.mds.app.controller;

import com.mds.app.model.ProcuraProjetoModel;
import com.mds.app.model.ProjetoModel;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ProjetoController extends DefaultHandler {

	private StringBuffer buffer = new StringBuffer();

	private ArrayList<ProjetoModel> listaProjetos;
	private ProjetoModel projeto;

	public ProjetoController() {

	}

	@Override
	public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {

		buffer.setLength(0);

		if (localName.equals("proposicoes")) {
			listaProjetos = new ArrayList<ProjetoModel>();
		}
		else if (localName.equals("proposicao")) {
			projeto = new ProjetoModel();
		}
		else {
			//
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		if (localName.equals("proposicao")) {
			listaProjetos.add(projeto);
		}
		else if (localName.equals("nome")) {
			projeto.setNome(buffer.toString());
		}
		else if (localName.equals("sigla")) {
			projeto.setSigla(buffer.toString());
		}
		else if (localName.equals("numero")) {
			projeto.setNumero(Integer.parseInt(buffer.toString()));
		}
		else if (localName.equals("datApresentacao")) {
			projeto.setData(buffer.toString());
		}
		else if (localName.equals("txtEmenta")) {
			projeto.setExplicacao(buffer.toString());
		}
		else {
			//
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) {
		buffer.append(ch, start, length);
	}

	public ArrayList<ProjetoModel> getListaProjetos() {
		return listaProjetos;
	}

	public void atualizarDadosDaPesquisa(String ano, String sigla) {
		int anoI = Integer.parseInt(ano);
		ProcuraProjetoModel.setAno(anoI);
		ProcuraProjetoModel.setSigla(sigla);
		System.out.println(anoI + sigla);
	}

}