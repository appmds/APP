package com.mds.app.testesandroid;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import android.content.Context;
import android.test.AndroidTestCase;

import com.mds.app.util.StableArrayAdapter;

public class StableArrayAdapterTest extends AndroidTestCase {

	StableArrayAdapter saa;
	ArrayList<String> listStr;
	Context context;

	public StableArrayAdapterTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		super.setUp();
		listStr = new ArrayList<String>();
		listStr.add("teste");
		context = mContext;
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
		saa = null;
		listStr = null;
		context = null;
	}

	@Test
	public void testContextNulo() {
		try {
			saa = new StableArrayAdapter(null, 20, listStr);
		} catch (NullPointerException e) {
		}
		assertNull(saa);
	}

	@Test
	public void testGetItem() {
		saa = new StableArrayAdapter(context, 77, listStr);

		String str = saa.getItem(0);
		assertEquals("teste", str);
	}

	@Test
	public void testGetItemId() {
		saa = new StableArrayAdapter(context, 80, listStr);
		long esperado = 0;
		long retornado = saa.getItemId(0);
		assertEquals(esperado, retornado);
	}

	@Test
	public void testHasStableIds() {
		saa = new StableArrayAdapter(context, 80, listStr);
		assertTrue(saa.hasStableIds());
	}

}
