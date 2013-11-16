package com.mds.app.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mds.app.controller.ListaController;
import com.mds.app.model.ParlamentarModel;
import com.mds.app.model.PartidoModel;
import com.mds.app.model.ProjetoModel;

public class ListaControllerTest {

	public ListaController listaController;
	public ArrayList<String> stringLista;
	public ArrayList<ProjetoModel> projetos;
	public ProjetoModel projetoModel;
	public ParlamentarModel parlamentarModel;
	public PartidoModel partidoModel;
	
	@Before
	public void setUp() throws Exception {
		stringLista = new ArrayList<String>();
		projetos = new ArrayList<ProjetoModel>();
		partidoModel = new PartidoModel("PMDS", "AC");
		parlamentarModel = new ParlamentarModel("Ranger", partidoModel);
		projetoModel = new ProjetoModel("2013", "Zordon", "PL", "12/01/2013", "6663", "explicacao marota", parlamentarModel);
		projetos.add(projetoModel);
		
		listaController = new ListaController(projetos);
	}

	@After
	public void tearDown() throws Exception {
		listaController = null;
		stringLista = null;
	}
	
	@Test
	public void testInstance(){
		assertNotNull(listaController);
	}
	
	@Test
	public void testTransformarLista(){
		listaController.transformarLista();
		
		ArrayList<ProjetoModel> projetos2 = new ArrayList<ProjetoModel>();
		projetos2.add(projetoModel);		
		String stringEsperada = "Zordon - 6663 - Ranger";
		
		assertEquals(stringEsperada, listaController.getStringProjetos().get(0));
		
	}
	
	@Test
	public void testTransformarListaNull(){
		
	}
	
	@Test
	public void testTransformarListaCompleto(){
		listaController.transformarListaCompleto();
		String stringEsperada = "Zordon\nNumero: 6663\nAno:  2013\nSigla: PL\nData de Apresentação: 12/01/2013\nDescrição: explicacao marota\nParlamentar: Ranger\nPartido: PMDS\nEstado: AC";
		assertEquals(stringEsperada, listaController.getStringProjetosCompleto().get(0));
	}

}
