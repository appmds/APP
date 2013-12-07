package com.mds.app.test;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import android.test.AndroidTestCase;

import com.mds.app.controller.ProposicaoController;
import com.mds.app.model.ParlamentarModel;
import com.mds.app.model.PartidoModel;
import com.mds.app.model.ProjetoModel;

public class ProposicaoControllerTest extends AndroidTestCase {

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
	public void testCharacters() {
		String inputStr = "abcteste";
		char input[] = inputStr.toCharArray();
		proposicaoController.characters(input, 0, 8);
		String retornado = new String(proposicaoController.getBuffer());
		assertEquals(inputStr, retornado);
	}

	@Test
	public void testStartElementProposicaoParlamentar() {
		try {
			proposicaoController.startElement("a", "proposicao", "q", null);
		} catch (SAXException saxe) {

		}
		assertNotNull(proposicaoController.getParlamentar());
	}

	@Test
	public void testarNomeDaClasse() {
		ProposicaoController p = new ProposicaoController();
		Assert.assertEquals("ProposicaoController", p.getClass().getSimpleName());
	}

	@Test
	public void testStartElementProposicaoProjeto() {
		try {
			proposicaoController.startElement("a", "proposicao", "q", null);
		} catch (SAXException saxe) {

		}
		assertNotNull(proposicaoController.getProjeto());
	}

	@Test
	public void testStartElementProposicaoPartido() {
		try {
			proposicaoController.startElement("a", "proposicao", "q", null);
		} catch (SAXException saxe) {

		}
		assertNotNull(proposicaoController.getPartido());
	}

	@Test
	public void testStartElementProposicoes() {
		try {
			proposicaoController.startElement("a", "proposicoes", "q", null);
		} catch (SAXException saxe) {

		}
		assertNotNull(proposicaoController.getListaProjetos());
	}

	@Test
	public void testEndElementProposicaoProjeto() {
		try {
			proposicaoController.startElement("a", "proposicao", "q", null);
			proposicaoController.startElement("a", "proposicoes", "q", null);
			proposicaoController.endElement("a", "proposicao", "q");
		} catch (SAXException saxe) {

		}

		assertEquals(proposicaoController.getProjeto(), proposicaoController.getListaProjetos().get(0));
	}

	@Test
	public void testEndElementProposicaoParlamentar() {
		try {
			proposicaoController.startElement("a", "proposicao", "q", null);
			proposicaoController.startElement("a", "proposicoes", "q", null);
			proposicaoController.endElement("a", "proposicao", "q");
		} catch (SAXException saxe) {

		}

		assertEquals(proposicaoController.getParlamentar(), proposicaoController.getProjeto().getParlamentar());
	}

	@Test
	public void testEndElementProposicaoPartido() {
		try {
			proposicaoController.startElement("a", "proposicao", "q", null);
			proposicaoController.startElement("a", "proposicoes", "q", null);
			proposicaoController.endElement("a", "proposicao", "q");
		} catch (SAXException saxe) {

		}

		assertEquals(proposicaoController.getPartido(), proposicaoController.getParlamentar().getPartido());
	}

	@Test
	public void testEndElementProposicaoAno() {
		String esperado = "testeano";
		int esperadoLength = esperado.length();
		try {
			proposicaoController.startElement("a", "proposicao", "q", null);
			proposicaoController.characters(esperado.toCharArray(), 0, esperadoLength);
			proposicaoController.endElement("a", "ano", "q");
		} catch (SAXException saxe) {
		}
		String retornado = proposicaoController.getProjeto().getAno();
		assertEquals(esperado, retornado);
	}

	@Test
	public void testEndElementProposicaoId() {
		String esperado = "testeid";
		int esperadoLength = esperado.length();
		try {
			proposicaoController.startElement("a", "proposicao", "q", null);
			proposicaoController.characters(esperado.toCharArray(), 0, esperadoLength);
			proposicaoController.endElement("a", "id", "q");
		} catch (SAXException saxe) {
		}
		String retornado = proposicaoController.getProjeto().getId();
		assertEquals(esperado, retornado);
	}
	
	@Test
	public void testEndElementProposicaoStatus() {
		String esperado = "testestatus";
		int esperadoLength = esperado.length();
		try {
			proposicaoController.startElement("a", "proposicao", "q", null);
			proposicaoController.characters(esperado.toCharArray(), 0, esperadoLength);
			proposicaoController.endElement("a", "descricao", "q");
		} catch (SAXException saxe) {
		}
		String retornado = proposicaoController.getProjeto().getStatus();
		assertEquals(esperado, retornado);
	}

	@Test
	public void testEndElementProposicaoNome() {
		String esperado = "testenomeproj";
		int esperadoLength = esperado.length();
		try {
			proposicaoController.startElement("a", "proposicao", "q", null);
			proposicaoController.characters(esperado.toCharArray(), 0, esperadoLength);
			proposicaoController.endElement("a", "nome", "q");
		} catch (SAXException saxe) {
		}
		String retornado = proposicaoController.getProjeto().getNome();
		assertEquals(esperado, retornado);
	}

	@Test
	public void testEndElementProposicaoSigla() {
		String esperado = "testesigla";
		int esperadoLength = esperado.length();
		try {
			proposicaoController.startElement("a", "proposicao", "q", null);
			proposicaoController.characters(esperado.toCharArray(), 0, esperadoLength);
			proposicaoController.endElement("a", "sigla", "q");
		} catch (SAXException saxe) {
		}
		String retornado = proposicaoController.getProjeto().getSigla();
		assertEquals(esperado, retornado);
	}

	@Test
	public void testEndElementProposicaoNumero() {
		String esperado = "testenumero";
		int esperadoLength = esperado.length();
		try {
			proposicaoController.startElement("a", "proposicao", "q", null);
			proposicaoController.characters(esperado.toCharArray(), 0, esperadoLength);
			proposicaoController.endElement("a", "numero", "q");
		} catch (SAXException saxe) {
		}
		String retornado = proposicaoController.getProjeto().getNumero();
		assertEquals(esperado, retornado);
	}

	@Test
	public void testEndElementProposicaoDataApresentacao() {
		String esperado = "testedataapresentacao";
		int esperadoLength = esperado.length();
		try {
			proposicaoController.startElement("a", "proposicao", "q", null);
			proposicaoController.characters(esperado.toCharArray(), 0, esperadoLength);
			proposicaoController.endElement("a", "datApresentacao", "q");
		} catch (SAXException saxe) {
		}
		String retornado = proposicaoController.getProjeto().getData();
		assertEquals(esperado, retornado);
	}

	@Test
	public void testEndElementProposicaoTextoEmenta() {
		String esperado = "testeementa";
		int esperadoLength = esperado.length();
		try {
			proposicaoController.startElement("a", "proposicao", "q", null);
			proposicaoController.characters(esperado.toCharArray(), 0, esperadoLength);
			proposicaoController.endElement("a", "txtEmenta", "q");
		} catch (SAXException saxe) {
		}
		String retornado = proposicaoController.getProjeto().getExplicacao();
		assertEquals(esperado, retornado);
	}

	@Test
	public void testEndElementProposicaoTextoNomeAutor() {
		String esperado = "testenomeautor";
		int esperadoLength = esperado.length();
		try {
			proposicaoController.startElement("a", "proposicao", "q", null);
			proposicaoController.characters(esperado.toCharArray(), 0, esperadoLength);
			proposicaoController.endElement("a", "txtNomeAutor", "q");
		} catch (SAXException saxe) {
		}
		String retornado = proposicaoController.getParlamentar().getNome();
		assertEquals(esperado, retornado);
	}
	
	@Test
	public void testEndElementProposicaoDiferente() {
		try {
			proposicaoController.startElement("a", "localnamediferente1", "q", null);
			proposicaoController.endElement("a", "localnamediferente2", "q");
		} catch (SAXException saxe) {
		}
		/* Testando os ramo elses, que nao fazem nada */
		assertTrue(true);
	}

	@Test
	public void testEndElementProposicaoTextoSiglaPartido() {
		String esperado = "testesiglapartido";
		int esperadoLength = esperado.length();
		try {
			proposicaoController.startElement("a", "proposicao", "q", null);
			proposicaoController.characters(esperado.toCharArray(), 0, esperadoLength);
			proposicaoController.endElement("a", "txtSiglaPartido", "q");
		} catch (SAXException saxe) {
		}
		String retornado = proposicaoController.getPartido().getSiglaPartido();
		assertEquals(esperado, retornado);
	}

	@Test
	public void testEndElementProposicaoTextoSiglaUf() {
		String esperado = "testeUF";
		int esperadoLength = esperado.length();
		try {
			proposicaoController.startElement("a", "proposicao", "q", null);
			proposicaoController.characters(esperado.toCharArray(), 0, esperadoLength);
			proposicaoController.endElement("a", "txtSiglaUF", "q");
		} catch (SAXException saxe) {
		}
		String retornado = proposicaoController.getPartido().getUf();
		assertEquals(esperado, retornado);
	}

	/* ====================GETS E SETS=================== */

	@Test
	public void testGetBuffer() {
		StringBuffer bufferTest = new StringBuffer();
		assertEquals(bufferTest.toString(), proposicaoController.getBuffer().toString());
	}

	@Test
	public void testSetBuffer() {
		StringBuffer bufferTest = new StringBuffer();
		proposicaoController.setBuffer(bufferTest);
		assertSame(bufferTest, proposicaoController.getBuffer());
	}

	@Test
	public void testSetThenGetProjeto() {
		ProjetoModel projeto = new ProjetoModel();
		proposicaoController.setProjeto(projeto);
		assertSame(projeto, proposicaoController.getProjeto());
	}

	@Test
	public void testSetThenGetParlamentar() {
		ParlamentarModel parlamentar = new ParlamentarModel();
		proposicaoController.setParlamentar(parlamentar);
		assertSame(parlamentar, proposicaoController.getParlamentar());
	}

	@Test
	public void testSetThenGetParitdo() {
		PartidoModel partido = new PartidoModel();
		proposicaoController.setPartido(partido);
		assertSame(partido, proposicaoController.getPartido());
	}

	@Test
	public void testSetThenGetListaProjetos() {
		ArrayList<ProjetoModel> lista = new ArrayList<ProjetoModel>();
		proposicaoController.setListaProjetos(lista);
		assertSame(lista, proposicaoController.getListaProjetos());
	}


}
