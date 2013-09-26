package com.mds.app.services;

import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import com.mds.app.controller.ProjetoController;
import com.mds.app.model.ProjetoModel;

public class XMLParser {

	private XMLReader initializeReader() throws ParserConfigurationException, SAXException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// create a parser
		SAXParser parser = factory.newSAXParser();
		// create the reader (scanner)
		XMLReader xmlreader = parser.getXMLReader();
		return xmlreader;
	}

	public ArrayList<ProjetoModel> parseProjeto(String xml) {

		try {

			XMLReader xmlreader = initializeReader();

			ProjetoController projeto = new ProjetoController();

			// assign our handler
			xmlreader.setContentHandler(projeto);
			// perform the synchronous parse
			xmlreader.parse(new InputSource(new StringReader(xml)));

			return projeto.getListaProjetos();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}