package com.mds.app.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.mds.app.controller.BuscaController;
import com.mds.app.controller.ProposicaoController;
import com.mds.app.model.ParlamentarModel;
import com.mds.app.model.PartidoModel;
import com.mds.app.model.ProjetoModel;

public class ProposicaoControllerTest {

	private ProposicaoController proposicaoController;

	@Before
	public void setUp() throws Exception {
		proposicaoController = new ProposicaoController();
	}

	@After
	public void tearDown() throws Exception {
		proposicaoController = null;
	}

	@Test
	public void testInstance() {
		assertNotNull(proposicaoController);
	}
	
	@Test
	public void testStartElementProposicaoParlamentar(){
		try{
			proposicaoController.startElement("a", "proposicao", "q", null);
		}catch(SAXException saxe){
			
		}
		assertNotNull(proposicaoController.getParlamentar());
	}
	
	@Test
	public void testarNomeDaClasse(){
		ProposicaoController p = new ProposicaoController();
		Assert.assertEquals("ProposicaoController", p.getClass().getSimpleName());
	}
	
	@Test
	public void testStartElementProposicaoProjeto(){
		try{
			proposicaoController.startElement("a", "proposicao", "q", null);
		}catch(SAXException saxe){
			
		}
		assertNotNull(proposicaoController.getProjeto());
	}
	
	@Test
	public void testStartElementProposicaoPartido(){
		try{
			proposicaoController.startElement("a", "proposicao", "q", null);
		}catch(SAXException saxe){
			
		}
		assertNotNull(proposicaoController.getPartido());
	}
	
	@Test
	public void testStartElementProposicoes(){
		try{
			proposicaoController.startElement("a", "proposicoes", "q", null);
		}catch(SAXException saxe){
			
		}
		assertNotNull(proposicaoController.getListaProjetos());
	}
	
	@Test
	public void testEndElementProposicaoProjeto(){
		try{
			proposicaoController.startElement("a", "proposicao", "q", null);
			proposicaoController.startElement("a", "proposicoes", "q", null);
			proposicaoController.endElement("a", "proposicao", "q");
		}catch(SAXException saxe){
			
		}
		
		assertEquals(proposicaoController.getProjeto(), proposicaoController.getListaProjetos().get(0));
	}
	
	@Test
	public void testEndElementProposicaoParlamentar(){
		try{
			proposicaoController.startElement("a", "proposicao", "q", null);
			proposicaoController.startElement("a", "proposicoes", "q", null);
			proposicaoController.endElement("a", "proposicao", "q");
		}catch(SAXException saxe){
			
		}
		
		assertEquals(proposicaoController.getParlamentar(), proposicaoController.getProjeto().getParlamentar());
	}
	
	@Test
	public void testEndElementProposicaoPartido(){
		try{
			proposicaoController.startElement("a", "proposicao", "q", null);
			proposicaoController.startElement("a", "proposicoes", "q", null);
			proposicaoController.endElement("a", "proposicao", "q");
		}catch(SAXException saxe){
			
		}
		
		assertEquals(proposicaoController.getPartido(), proposicaoController.getParlamentar().getPartido());
	}
	

	@Test
	public void testEndElementProposicaoAno(){
		try{
			proposicaoController.startElement("a", "proposicao", "q", null);
			proposicaoController.endElement("a", "ano", "q");
		}catch(SAXException saxe){
		}
		fail("implementar");
	}
	
	@Test
	public void testEndElementProposicaoNome(){
		try{
			proposicaoController.startElement("a", "proposicao", "q", null);
			proposicaoController.endElement("a", "nome", "q");
		}catch(SAXException saxe){
		}
		fail("implementar");
	}
	
	@Test
	public void testEndElementProposicaoSigla(){
		try{
			proposicaoController.startElement("a", "proposicao", "q", null);
			proposicaoController.endElement("a", "sigla", "q");
		}catch(SAXException saxe){
		}
		fail("implementar");
	}
	
	@Test
	public void testEndElementProposicaoNumero(){
		try{
			proposicaoController.startElement("a", "proposicao", "q", null);
			proposicaoController.endElement("a", "numero", "q");
		}catch(SAXException saxe){
		}
		fail("implementar");
	}
	
	@Test
	public void testEndElementProposicaoDataApresentacao(){
		try{
			proposicaoController.startElement("a", "proposicao", "q", null);
			proposicaoController.endElement("a", "datApresentacao", "q");
		}catch(SAXException saxe){
		}
		fail("implementar");
	}
	
	@Test
	public void testEndElementProposicaoTextoEmenta(){
		try{
			proposicaoController.startElement("a", "proposicao", "q", null);
			proposicaoController.endElement("a", "txtEmenta", "q");
		}catch(SAXException saxe){
		}
		fail("implementar");
	}
	
	@Test
	public void testEndElementProposicaoTextoNomeAutor(){
		try{
			proposicaoController.startElement("a", "proposicao", "q", null);
			proposicaoController.endElement("a", "txtNomeAutor", "q");
		}catch(SAXException saxe){
		}
		fail("");
	}
	
	@Test
	public void testEndElementProposicaoTextoSiglaPartido(){
		try{
			proposicaoController.startElement("a", "proposicao", "q", null);
			proposicaoController.endElement("a", "txtSiglaPartido", "q");
		}catch(SAXException saxe){
		}
		fail("implementar");
	}
	
	@Test
	public void testEndElementProposicaoTextoSiglaUf(){
		try{
			proposicaoController.startElement("a", "proposicao", "q", null);
			proposicaoController.endElement("a", "txtSiglaUF", "q");
		}catch(SAXException saxe){
		}
		fail("implementar");
	}
	
	@Test
	public void testGetBuffer(){
		StringBuffer bufferTest = new StringBuffer();
		assertEquals(bufferTest.toString(), proposicaoController.getBuffer().toString());
	}
	
	@Test
	public void testSetBuffer(){
		StringBuffer bufferTest = new StringBuffer();
		proposicaoController.setBuffer(bufferTest);
		assertSame(bufferTest, proposicaoController.getBuffer());
	}
	
	@Test
	public void testSetProjeto(){
		ProjetoModel projeto = new ProjetoModel();
		proposicaoController.setProjeto(projeto);
		assertSame(projeto, proposicaoController.getProjeto());	
	}
	
	@Test
	public void testSetParlamentar(){
		ParlamentarModel parlamentar = new ParlamentarModel();
		proposicaoController.setParlamentar(parlamentar);
		assertSame(parlamentar, proposicaoController.getParlamentar());
	}
	
	@Test
	public void testSetParitdo(){
		PartidoModel partido = new PartidoModel();
		proposicaoController.setPartido(partido);
		assertSame(partido, proposicaoController.getPartido());	
	}
	
	@Test
	public void testSetListaProjetos(){
		ArrayList<ProjetoModel> lista = new ArrayList<ProjetoModel>();
		proposicaoController.setListaProjetos(lista);
		assertSame(lista, proposicaoController.getListaProjetos());
	}
	
	@Test
	public void testFail(){
		fail("Verificar se implementado todos os gets e sets aqui");
	}
	
}
