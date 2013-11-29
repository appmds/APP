package com.mds.app.controller;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.mds.app.model.ParlamentarModel;
import com.mds.app.model.PartidoModel;
import com.mds.app.model.ProjetoModel;

public class ProposicaoController extends DefaultHandler {

	private StringBuffer buffer;

	private ArrayList<ProjetoModel> listaProjetos;
	private ProjetoModel projeto;
	private ParlamentarModel parlamentar;
	private PartidoModel partido;

	public ProposicaoController() {
		buffer = new StringBuffer();
	}

	@Override
	public void startElement(String namespaceURI, String localName, String qName, Attributes atts)
			throws SAXException {

		buffer.setLength(0);

		if (localName.equals("proposicoes")) {
			listaProjetos = new ArrayList<ProjetoModel>();
		}
		else if (localName.equals("proposicao")) {
			projeto = new ProjetoModel();
			parlamentar = new ParlamentarModel();
			partido = new PartidoModel();
		}
		else {
			// throw new IllegalArgumentException("localName "+ localName +" invalida");
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		if (localName.equals("proposicao")) {
			listaProjetos.add(projeto);
			projeto.setParlamentar(parlamentar);
			parlamentar.setPartido(partido);
		}
		else if (localName.equals("ano")) {
			projeto.setAno(buffer.toString());
		}
		else if (localName.equals("nome")) {
			projeto.setNome(buffer.toString());
		}
		else if (localName.equals("sigla")) {
			projeto.setSigla(buffer.toString());
		}
		else if (localName.equals("numero")) {
			projeto.setNumero(buffer.toString());
		}
		else if (localName.equals("datApresentacao")) {
			projeto.setData(buffer.toString());
		}
		else if (localName.equals("txtEmenta")) {
			projeto.setExplicacao(buffer.toString());
		}
		else if (localName.equals("txtNomeAutor")) {
			parlamentar.setNome(buffer.toString());
		}
		else if (localName.equals("txtSiglaPartido")) {
			partido.setSiglaPartido(buffer.toString());
		}
		else if (localName.equals("txtSiglaUF")) {
			partido.setUf(buffer.toString());
		}
		else {
			// throw new IllegalArgumentException("localName "+ localName +" invalida!");
		}

	}

	@Override
	public void characters(char[] ch, int start, int length) {
		buffer.append(ch, start, length);
	}

	public ArrayList<ProjetoModel> getListaProjetos() {
		return listaProjetos;
	}

	public StringBuffer getBuffer() {
		return buffer;
	}

	public void setBuffer(StringBuffer buffer) {
		this.buffer = buffer;
	}

	public ProjetoModel getProjeto() {
		return projeto;
	}

	public void setProjeto(ProjetoModel projeto) {
		this.projeto = projeto;
	}

	public ParlamentarModel getParlamentar() {
		return parlamentar;
	}

	public void setParlamentar(ParlamentarModel parlamentar) {
		this.parlamentar = parlamentar;
	}

	public PartidoModel getPartido() {
		return partido;
	}

	public void setPartido(PartidoModel partido) {
		this.partido = partido;
	}

	public void setListaProjetos(ArrayList<ProjetoModel> listaProjetos) {
		this.listaProjetos = listaProjetos;
	}

}