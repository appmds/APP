/*package com.mds.app.testes;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mds.app.model.ParlamentarModel;
import com.mds.app.model.PartidoModel;

public class PartidoModelTest extends TestCase {

	private ParlamentarModel parlamentarModel;
	private PartidoModel partidoModel;
	private ArrayList<ParlamentarModel> parlamentares;
	private ArrayList<ParlamentarModel> outrosParlamentares;

	@Before
	public void setUp() throws Exception {
		System.out.println("Comecando o teste...");

		// Criando o partido de teste
		parlamentares = new ArrayList<ParlamentarModel>();
		partidoModel = new PartidoModel(parlamentares, "PMDS", "DF");
		
		outrosParlamentares = new ArrayList<ParlamentarModel>();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Terminando...");
	}

	@Test
	public void testGetParlamentares() {
		assertSame(parlamentares, partidoModel.getParlamentares());
	}
	
	@Test
	public void testGetSiglaPartido(){
		assertEquals("PMDS", partidoModel.getSiglaPartido());
	}
	
	@Test
	public void testGetUf(){
		assertEquals("DF", partidoModel.getUf());
	}
	
	@Test
	public void testSetParlamentares() {
		partidoModel.setParlamentares(outrosParlamentares);
		assertSame(outrosParlamentares, partidoModel.getParlamentares());
	}
	
	@Test
	public void testSetSiglaPartido(){
		partidoModel.setSiglaPartido("PGPP");
		assertEquals("PGPP", partidoModel.getSiglaPartido());
	}
	
	@Test
	public void testSetUf(){
		partidoModel.setUf("MG");
		assertEquals("MG", partidoModel.getUf());
	}
	
	@Test
	public void testAddParlamentar(){
		parlamentarModel = new ParlamentarModel();
		outrosParlamentares.add(parlamentarModel);
		partidoModel.addParlamentar(parlamentarModel);
		assertEquals(outrosParlamentares, partidoModel.getParlamentares());
		
	}

}
*/
