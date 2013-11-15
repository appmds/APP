package com.mds.app.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mds.app.controller.BuscaController;

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
	public void testNullsAtualizarDadosDaPesquisa() {
		boolean validacao = buscaController.atualizarDadosDaPesquisa("", "", "", "", "", "", "");
		assertFalse(validacao);
	}

	@Test
	public void testTransformaUfTodos(){
		String ufEsperada = "";
		String resultado = buscaController.transformaUF("Todos");
		assertEquals(ufEsperada, resultado);
	}
	
	@Test
	public void testTransformaUfAcre(){
		String ufEsperada = "AC";
		String resultado = buscaController.transformaUF("Acre");
		assertEquals(ufEsperada, resultado);
	}
	@Test
	public void testTransformaUfAlagoas(){
		String ufEsperada = "AL";
		String resultado = buscaController.transformaUF("Alagoas");
		assertEquals(ufEsperada, resultado);
	}
	@Test
	public void testTransformaUfAmapa(){
		String ufEsperada = "AP";
		String resultado = buscaController.transformaUF("Amapá");
		assertEquals(ufEsperada, resultado);
	}
	@Test
	public void testTransformaUfAmazonas(){
		String ufEsperada = "AM";
		String resultado = buscaController.transformaUF("Amazonas");
		assertEquals(ufEsperada, resultado);
	}
	@Test
	public void testTransformaUfBahia(){
		String ufEsperada = "BA";
		String resultado = buscaController.transformaUF("Bahia");
		assertEquals(ufEsperada, resultado);
	}
	@Test
	public void testTransformaUfCeara(){
		String ufEsperada = "CE";
		String resultado = buscaController.transformaUF("Ceará");
		assertEquals(ufEsperada, resultado);
	}
	@Test
	public void testTransformaUfDistritoFederal(){
		String ufEsperada = "DF";
		String resultado = buscaController.transformaUF("Distrito Federal");
		assertEquals(ufEsperada, resultado);
	}
	@Test
	public void testTransformaUfEspIritoSanto(){
		String ufEsperada = "ES";
		String resultado = buscaController.transformaUF("Espírito Santo");
		assertEquals(ufEsperada, resultado);
	}
	@Test
	public void testTransformaUfGoias(){
		String ufEsperada = "GO";
		String resultado = buscaController.transformaUF("Goiás");
		assertEquals(ufEsperada, resultado);
	}
	@Test
	public void testTransformaUfMaranhao(){
		String ufEsperada = "MA";
		String resultado = buscaController.transformaUF("Maranhão");
		assertEquals(ufEsperada, resultado);
	}
	@Test
	public void testTransformaUfMatoGrosso(){
		String ufEsperada = "MT";
		String resultado = buscaController.transformaUF("Mato Grosso");
		assertEquals(ufEsperada, resultado);
	}
	@Test
	public void testTransformaUfMatoGrossoDoSul(){
		String ufEsperada = "MS";
		String resultado = buscaController.transformaUF("Mato Grosso do Sul");
		assertEquals(ufEsperada, resultado);
	}
	@Test
	public void testTransformaUfMinasGerais(){
		String ufEsperada = "MG";
		String resultado = buscaController.transformaUF("Minas Gerais");
		assertEquals(ufEsperada, resultado);
	}
	@Test
	public void testTransformaUfPara(){
		String ufEsperada = "PA";
		String resultado = buscaController.transformaUF("Pará");
		assertEquals(ufEsperada, resultado);
	}
	@Test
	public void testTransformaUfParaiba(){
		String ufEsperada = "PB";
		String resultado = buscaController.transformaUF("Paraíba");
		assertEquals(ufEsperada, resultado);
	}
	@Test
	public void testTransformaUfParana(){
		String ufEsperada = "PR";
		String resultado = buscaController.transformaUF("Paraná");
		assertEquals(ufEsperada, resultado);
	}
	@Test
	public void testTransformaUfPernambuco(){
		String ufEsperada = "PE";
		String resultado = buscaController.transformaUF("Pernambuco");
		assertEquals(ufEsperada, resultado);
	}
	@Test
	public void testTransformaUfPiaui(){
		String ufEsperada = "PI";
		String resultado = buscaController.transformaUF("Piauí");
		assertEquals(ufEsperada, resultado);
	}
	@Test
	public void testTransformaUfRioDeJaneiro(){
		String ufEsperada = "RJ";
		String resultado = buscaController.transformaUF("Rio de Janeiro");
		assertEquals(ufEsperada, resultado);
	}
	@Test
	public void testTransformaUfRioGrandeDoNorte(){
		String ufEsperada = "RN";
		String resultado = buscaController.transformaUF("Rio Grande do Norte");
		assertEquals(ufEsperada, resultado);
	}
	@Test
	public void testTransformaUfRioGrandeDoSul(){
		String ufEsperada = "RS";
		String resultado = buscaController.transformaUF("Rio Grande do Sul");
		assertEquals(ufEsperada, resultado);
	}
	@Test
	public void testTransformaUfRondonia(){
		String ufEsperada = "RO";
		String resultado = buscaController.transformaUF("Rondônia");
		assertEquals(ufEsperada, resultado);
	}
	@Test
	public void testTransformaUfRoraima(){
		String ufEsperada = "RR";
		String resultado = buscaController.transformaUF("Roraima");
		assertEquals(ufEsperada, resultado);
	}
	@Test
	public void testTransformaUfSantaCatarina(){
		String ufEsperada = "SC";
		String resultado = buscaController.transformaUF("Santa Catarina");
		assertEquals(ufEsperada, resultado);
	}
	@Test
	public void testTransformaUfSaoPaulo(){
		String ufEsperada = "SP";
		String resultado = buscaController.transformaUF("São Paulo");
		assertEquals(ufEsperada, resultado);
	}
	@Test
	public void testTransformaUfSergipe(){
		String ufEsperada = "SE";
		String resultado = buscaController.transformaUF("Sergipe");
		assertEquals(ufEsperada, resultado);
	}
	@Test
	public void testTransformaUfTocantins(){
		String ufEsperada = "TO";
		String resultado = buscaController.transformaUF("Tocantins");
		assertEquals(ufEsperada, resultado);
	}
	
	

	@Test
	public void testFail() {
		fail("implementar testes");
	}

}
