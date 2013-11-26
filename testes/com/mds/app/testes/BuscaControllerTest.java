package com.mds.app.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mds.app.controller.BuscaController;
import com.mds.app.controller.ProcuraParlamentarController;
import com.mds.app.controller.ProcuraPartidoController;
import com.mds.app.controller.ProcuraProjetoController;
import com.mds.app.model.ProjetoModel;
import com.mds.app.services.XMLParser;

public class BuscaControllerTest {

	public BuscaController buscaController;

	@Before
	public void setUp() throws Exception {
		buscaController = new BuscaController();
	}

	@After
	public void tearDown() throws Exception {
		buscaController = null;

	}

	@Test
	public void testInstance() {
		assertNotNull(buscaController);
	}

	@Test
	public void testXmlParserInstance() {
		assertNotNull(buscaController.getXmlParser());
	}

	@Test
	public void testIsTemConexao() {
		assertFalse(buscaController.isTemConexao());
	}

	@Test
	public void testGetTextoOffline() {
		assertNull(buscaController.getTextoOffline());
	}

	@Test
	public void testSetTextoOffline() {
		String esperada = "textoffline";
		buscaController.setTextoOffline(esperada);
		String retornada = buscaController.getTextoOffline();
		assertEquals(esperada, retornada);
	}

	@Test
	public void testSetXmlParser() {
		XMLParser novoXmlParser = new XMLParser();
		buscaController.setXmlParser(novoXmlParser);
		assertSame(novoXmlParser, buscaController.getXmlParser());
	}

	@Test
	public void testSetTemConexao() {
		buscaController.setTemConexao(true);
		assertTrue(buscaController.isTemConexao());
	}

	@Test
	public void testReceberXml() {
		String responseEsperada = "<?xml version=\"1.0\" encoding=\"utf-8\"?><proposicoes>  <proposicao>    <id>596039</id>    <nome>PL 6555/2013</nome>    <tipoProposicao>      <id>139</id>      <sigla>PL</sigla>      <nome>Projeto de Lei</nome>    </tipoProposicao>    <numero>6555</numero>    <ano>2013</ano>    <orgaoNumerador>      <id>180</id>      <sigla>PLEN      </sigla>      <nome>PLENÁRIO</nome>    </orgaoNumerador>    <datApresentacao>10/10/2013 11:04:32</datApresentacao>    <txtEmenta>Institui o Dia Nacional do Blogueiro.</txtEmenta>    <txtExplicacaoEmenta>    </txtExplicacaoEmenta>    <regime>      <codRegime>99</codRegime>      <txtRegime>.</txtRegime>    </regime>    <apreciacao>      <id>99</id>      <txtApreciacao>.</txtApreciacao>    </apreciacao>    <autor1>      <txtNomeAutor>Andre Moura</txtNomeAutor>      <idecadastro>160543</idecadastro>      <codPartido>126</codPartido>      <txtSiglaPartido>PSC       </txtSiglaPartido>      <txtSiglaUF>SE</txtSiglaUF>    </autor1>    <qtdAutores>1</qtdAutores>    <ultimoDespacho>      <datDespacho>29/10/2013 14:44:00</datDespacho>      <txtDespacho>Devolva-se a proposição, com base no art. 137, §1º, inciso I, do Regimento Interno da Câmara dos Deputados, por contrariar o disposto no art. 4º da Lei nº 12.345/2010. Oficie-se ao Autor e, após, publique-se. </txtDespacho>    </ultimoDespacho>    <situacao>      <id>918</id>      <descricao>.</descricao>      <orgao>        <codOrgaoEstado>4</codOrgaoEstado>        <siglaOrgaoEstado>Diversos  </siglaOrgaoEstado>      </orgao>      <principal>        <codProposicaoPrincipal>0</codProposicaoPrincipal>        <proposicaoPrincipal>        </proposicaoPrincipal>      </principal>    </situacao>    <indGenero>o</indGenero>    <qtdOrgaosComEstado>2</qtdOrgaosComEstado>  </proposicao></proposicoes>";

		ProcuraProjetoController.atualizarDadosPesquisaProjeto("2013", "PL", "6555", "");
		ProcuraPartidoController.atualizaDadosPesquisaPartido("SE", "");
		ProcuraParlamentarController.atualizarDadosPesquisaParlamentar("");
		buscaController.setTemConexao(true);
		String responseRetornada = buscaController.receberXml();

		/* as falhas deste teste estao atribuidas a coisas como ex: PLENÁRIO > PLENÃ�RIO */
		assertEquals(responseEsperada, responseRetornada);
	}

	@Test
	public void testReceberXmlSemConexao() {
		buscaController.setTemConexao(false);
		String textoOfflineEsperado = null;
		String textoOfflineRetornado = buscaController.receberXml();
		assertEquals(textoOfflineEsperado, textoOfflineRetornado);
	}

	@Test
	public void testProcurar() {
		XMLParser xmlParser = new XMLParser();
		String responseEsperada = "<?xml version=\"1.0\" encoding=\"utf-8\"?><proposicoes>  <proposicao>    <id>596039</id>    <nome>PL 6555/2013</nome>    <tipoProposicao>      <id>139</id>      <sigla>PL</sigla>      <nome>Projeto de Lei</nome>    </tipoProposicao>    <numero>6555</numero>    <ano>2013</ano>    <orgaoNumerador>      <id>180</id>      <sigla>PLEN      </sigla>      <nome>PLENÁRIO</nome>    </orgaoNumerador>    <datApresentacao>10/10/2013 11:04:32</datApresentacao>    <txtEmenta>Institui o Dia Nacional do Blogueiro.</txtEmenta>    <txtExplicacaoEmenta>    </txtExplicacaoEmenta>    <regime>      <codRegime>99</codRegime>      <txtRegime>.</txtRegime>    </regime>    <apreciacao>      <id>99</id>      <txtApreciacao>.</txtApreciacao>    </apreciacao>    <autor1>      <txtNomeAutor>Andre Moura</txtNomeAutor>      <idecadastro>160543</idecadastro>      <codPartido>126</codPartido>      <txtSiglaPartido>PSC       </txtSiglaPartido>      <txtSiglaUF>SE</txtSiglaUF>    </autor1>    <qtdAutores>1</qtdAutores>    <ultimoDespacho>      <datDespacho>29/10/2013 14:44:00</datDespacho>      <txtDespacho>Devolva-se a proposição, com base no art. 137, §1º, inciso I, do Regimento Interno da Câmara dos Deputados, por contrariar o disposto no art. 4º da Lei nº 12.345/2010. Oficie-se ao Autor e, após, publique-se. </txtDespacho>    </ultimoDespacho>    <situacao>      <id>918</id>      <descricao>.</descricao>      <orgao>        <codOrgaoEstado>4</codOrgaoEstado>        <siglaOrgaoEstado>Diversos  </siglaOrgaoEstado>      </orgao>      <principal>        <codProposicaoPrincipal>0</codProposicaoPrincipal>        <proposicaoPrincipal>        </proposicaoPrincipal>      </principal>    </situacao>    <indGenero>o</indGenero>    <qtdOrgaosComEstado>2</qtdOrgaosComEstado>  </proposicao></proposicoes>";
		ArrayList<ProjetoModel> listaEsperada = xmlParser.parseProjeto(responseEsperada);

		ProcuraProjetoController.atualizarDadosPesquisaProjeto("2013", "PL", "6555", "");
		ProcuraPartidoController.atualizaDadosPesquisaPartido("SE", "");
		ProcuraParlamentarController.atualizarDadosPesquisaParlamentar("");
		buscaController.setTemConexao(true);
		ArrayList<ProjetoModel> listaRetornada = buscaController.procurar();

		assertNotNull(listaRetornada); /* O teste nao consegue fazer o metodo procurar retornar a lista, mesmo tendo o link correto */
		assertEquals(listaEsperada, listaRetornada);
	}

	@Test
	public void testAtualizarDadosDaPesquisa() {
		boolean retornado = buscaController.atualizarDadosDaPesquisa("2013", "pl", "1234", "12/44/1234",
				"nomeautor", "pmds", "Distrito Federal");
		assertTrue(retornado);
	}

	@Test
	public void testAtualizarDadosDaPesquisaErros() {
		boolean retornado = buscaController.atualizarDadosDaPesquisa("2013", "pl", "1234", "12/44/1234", "12345",
				"pmds", "Distrito Federal");
		assertFalse(retornado);
	}

	@Test
	public void testAtualizarDadosDaPesquisaVazios() {
		boolean validacao = buscaController.atualizarDadosDaPesquisa("", "", "", "", "", "", "Todos os Estados");
		assertTrue(validacao);
	}

	@Test
	public void testAtualizarDadosDaPesquisaVaziosESiglaTodos() {
		boolean validacao = buscaController.atualizarDadosDaPesquisa("", "", "", "", "", "Todos os Partidos",
				"Todos os Estados");
		assertTrue(validacao);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testTransformaUfCatchException() {
		String resultado = buscaController.transformaUF("uf invalida");
		fail("teste falhou");
	}

	@Test
	public void testTransformaUfTodos() {
		String ufEsperada = "";
		String resultado = buscaController.transformaUF("Todos os estados");
		assertEquals(ufEsperada, resultado);
	}

	@Test
	public void testTransformaUfAcre() {
		String ufEsperada = "AC";
		String resultado = buscaController.transformaUF("Acre");
		assertEquals(ufEsperada, resultado);
	}

	@Test
	public void testTransformaUfAlagoas() {
		String ufEsperada = "AL";
		String resultado = buscaController.transformaUF("Alagoas");
		assertEquals(ufEsperada, resultado);
	}

	@Test
	public void testTransformaUfAmapa() {
		String ufEsperada = "AP";
		String resultado = buscaController.transformaUF("Amapá");
		assertEquals(ufEsperada, resultado);
	}

	@Test
	public void testTransformaUfAmazonas() {
		String ufEsperada = "AM";
		String resultado = buscaController.transformaUF("Amazonas");
		assertEquals(ufEsperada, resultado);
	}

	@Test
	public void testTransformaUfBahia() {
		String ufEsperada = "BA";
		String resultado = buscaController.transformaUF("Bahia");
		assertEquals(ufEsperada, resultado);
	}

	@Test
	public void testTransformaUfCeara() {
		String ufEsperada = "CE";
		String resultado = buscaController.transformaUF("Ceará");
		assertEquals(ufEsperada, resultado);
	}

	@Test
	public void testTransformaUfDistritoFederal() {
		String ufEsperada = "DF";
		String resultado = buscaController.transformaUF("Distrito Federal");
		assertEquals(ufEsperada, resultado);
	}

	@Test
	public void testTransformaUfEspIritoSanto() {
		String ufEsperada = "ES";
		String resultado = buscaController.transformaUF("Espírito Santo");
		assertEquals(ufEsperada, resultado);
	}

	@Test
	public void testTransformaUfGoias() {
		String ufEsperada = "GO";
		String resultado = buscaController.transformaUF("Goiás");
		assertEquals(ufEsperada, resultado);
	}

	@Test
	public void testTransformaUfMaranhao() {
		String ufEsperada = "MA";
		String resultado = buscaController.transformaUF("Maranhão");
		assertEquals(ufEsperada, resultado);
	}

	@Test
	public void testTransformaUfMatoGrosso() {
		String ufEsperada = "MT";
		String resultado = buscaController.transformaUF("Mato Grosso");
		assertEquals(ufEsperada, resultado);
	}

	@Test
	public void testTransformaUfMatoGrossoDoSul() {
		String ufEsperada = "MS";
		String resultado = buscaController.transformaUF("Mato Grosso do Sul");
		assertEquals(ufEsperada, resultado);
	}

	@Test
	public void testTransformaUfMinasGerais() {
		String ufEsperada = "MG";
		String resultado = buscaController.transformaUF("Minas Gerais");
		assertEquals(ufEsperada, resultado);
	}

	@Test
	public void testTransformaUfPara() {
		String ufEsperada = "PA";
		String resultado = buscaController.transformaUF("Pará");
		assertEquals(ufEsperada, resultado);
	}

	@Test
	public void testTransformaUfParaiba() {
		String ufEsperada = "PB";
		String resultado = buscaController.transformaUF("Paraíba");
		assertEquals(ufEsperada, resultado);
	}

	@Test
	public void testTransformaUfParana() {
		String ufEsperada = "PR";
		String resultado = buscaController.transformaUF("Paraná");
		assertEquals(ufEsperada, resultado);
	}

	@Test
	public void testTransformaUfPernambuco() {
		String ufEsperada = "PE";
		String resultado = buscaController.transformaUF("Pernambuco");
		assertEquals(ufEsperada, resultado);
	}

	@Test
	public void testTransformaUfPiaui() {
		String ufEsperada = "PI";
		String resultado = buscaController.transformaUF("Piauí");
		assertEquals(ufEsperada, resultado);
	}

	@Test
	public void testTransformaUfRioDeJaneiro() {
		String ufEsperada = "RJ";
		String resultado = buscaController.transformaUF("Rio de Janeiro");
		assertEquals(ufEsperada, resultado);
	}

	@Test
	public void testTransformaUfRioGrandeDoNorte() {
		String ufEsperada = "RN";
		String resultado = buscaController.transformaUF("Rio Grande do Norte");
		assertEquals(ufEsperada, resultado);
	}

	@Test
	public void testTransformaUfRioGrandeDoSul() {
		String ufEsperada = "RS";
		String resultado = buscaController.transformaUF("Rio Grande do Sul");
		assertEquals(ufEsperada, resultado);
	}

	@Test
	public void testTransformaUfRondonia() {
		String ufEsperada = "RO";
		String resultado = buscaController.transformaUF("Rondônia");
		assertEquals(ufEsperada, resultado);
	}

	@Test
	public void testTransformaUfRoraima() {
		String ufEsperada = "RR";
		String resultado = buscaController.transformaUF("Roraima");
		assertEquals(ufEsperada, resultado);
	}

	@Test
	public void testTransformaUfSantaCatarina() {
		String ufEsperada = "SC";
		String resultado = buscaController.transformaUF("Santa Catarina");
		assertEquals(ufEsperada, resultado);
	}

	@Test
	public void testTransformaUfSaoPaulo() {
		String ufEsperada = "SP";
		String resultado = buscaController.transformaUF("São Paulo");
		assertEquals(ufEsperada, resultado);
	}

	@Test
	public void testTransformaUfSergipe() {
		String ufEsperada = "SE";
		String resultado = buscaController.transformaUF("Sergipe");
		assertEquals(ufEsperada, resultado);
	}

	@Test
	public void testTransformaUfTocantins() {
		String ufEsperada = "TO";
		String resultado = buscaController.transformaUF("Tocantins");
		assertEquals(ufEsperada, resultado);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testTransformaSiglaCatchException() {
		String retornado = buscaController.transformaSigla("sigla invalida");
		fail("teste falhou");
	}

	@Test
	public void testTransformaSiglaPL() {
		String siglaEsperada = "PL";
		String retornado = buscaController.transformaSigla("Projeto de Lei");
		assertEquals(siglaEsperada, retornado);
	}

	@Test
	public void testTransformaSiglaPEC() {
		String siglaEsperada = "PEC";
		String retornado = buscaController.transformaSigla("Propostas de Emenda à Constituição");
		assertEquals(siglaEsperada, retornado);
	}

	@Test
	public void testTransformaSiglaPLP() {
		String siglaEsperada = "PLP";
		String retornado = buscaController.transformaSigla("Projetos de Lei Complementar");
		assertEquals(siglaEsperada, retornado);
	}

	@Test
	public void testTransformaSiglaPDC() {
		String siglaEsperada = "PDC";
		String retornado = buscaController.transformaSigla("Projetos de Decreto Legislativo ");
		assertEquals(siglaEsperada, retornado);
	}

	@Test
	public void testTransformaSiglaPRC() {
		String siglaEsperada = "PRC";
		String retornado = buscaController.transformaSigla("Projetos de Resolução");
		assertEquals(siglaEsperada, retornado);
	}

	@Test
	public void testarNomeDaClasse() {
		assertEquals("BuscaController", buscaController.getClass().getSimpleName());
	}

}
