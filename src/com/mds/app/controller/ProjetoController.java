package com.mds.app.controller;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.mds.app.model.ParlamentarModel;
import com.mds.app.model.PartidoModel;
import com.mds.app.model.ProjetoModel;
import com.mds.app.persistencia.Persistencia;

public class ProjetoController extends DefaultHandler {

	private StringBuffer buffer = new StringBuffer();

	private ArrayList<ProjetoModel> listaProjetos;
	private ArrayList<PartidoModel> listaPartidos;
	private ArrayList<ParlamentarModel> listaParlamentares;
	private ProjetoModel projeto;
	private PartidoModel partido;
	private ParlamentarModel parlamentar;
	

	public ProjetoController() {

	}

	ArrayList<ProjetoModel> projetosInstanciados = Persistencia.instanciarProjetos();

	private int validacaoPartido;
	private int validacaoParlamentar;

	@Override
	public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {

		buffer.setLength(0);
		validacaoPartido = 1;
		validacaoParlamentar = 1;

		if (localName.equals("proposicoes")) {
			listaProjetos = new ArrayList<ProjetoModel>();
			listaPartidos = new ArrayList<PartidoModel>();
			listaParlamentares = new ArrayList<ParlamentarModel>();
		}
		else if (localName.equals("proposicao")) {
			projeto = new ProjetoModel();
		}
		else if (localName.equals("txtSiglaPartido")){
			partido = new PartidoModel();
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
			projeto.setNumero(buffer.toString());
		}
		else if (localName.equals("datApresentacao")) {
			projeto.setData(buffer.toString());
		}
		else if (localName.equals("txtEmenta")) {
			projeto.setExplicacao(buffer.toString());
		}
/*	TENTATIVA DE MELHORAR A LÓGICA VERIFICAR SE A IDEIA ESTÁ CERTA E CORRIGIR	
		else if (localName.equals("txtSiglaPartido")){
			for(int i=0;i<listaPartidos.size();i++){
				if(listaPartidos.get(i).getSiglaPartido() == buffer.toString())
					validacaoPartido = 0;
					partido = listaPartidos.get(i);
			}
			if (validacaoPartido == 1)
				partido.setSiglaPartido(buffer.toString());
		}
		else if (localName.equals("txtSiglaUF")){
			if (validacaoPartido == 1)
				partido.setUf(buffer.toString());
		}
		else if (localName.equals("txtNomeAutor")) {
			for(int i=0;i<listaParlamentares.size();i++){
				if(listaParlamentares.get(i).getNome() == buffer.toString())
					validacaoParlamentar = 0;
				    projeto.setParlamentar(listaParlamentares.get(i));
			}
			if (validacaoParlamentar==1){
				parlamentar = new ParlamentarModel();
				parlamentar.setNome(buffer.toString());
				parlamentar.setPartido(partido);
				listaParlamentares.add(parlamentar);
				projeto.setParlamentar(parlamentar);
			}
		}
		*/
		
		else {

		}
	}

	public ArrayList<ProjetoModel> getListaProjetos() {
		return listaProjetos;
	}

}
