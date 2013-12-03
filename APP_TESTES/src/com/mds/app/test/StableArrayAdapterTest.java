package com.mds.app.test;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import android.content.Context;
import android.test.AndroidTestCase;

import com.mds.app.util.StableArrayAdapter;

public class StableArrayAdapterTest extends AndroidTestCase {

	StableArrayAdapter stableArrayAdapter;
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
		stableArrayAdapter = null;
		listStr = null;
		context = null;
	}

	@Test
	public void testContextNulo() {
		try {
			stableArrayAdapter = new StableArrayAdapter(null, 20, listStr);
		} catch (NullPointerException e) {
		}
		assertNull(stableArrayAdapter);
	}

	@Test
	public void testGetItem() {
		stableArrayAdapter = new StableArrayAdapter(context, 77, listStr);

		String str = stableArrayAdapter.getItem(0);
		assertEquals("teste", str);
	}

	@Test
	public void testGetItemId() {
		stableArrayAdapter = new StableArrayAdapter(context, 80, listStr);
		long esperado = 0;
		long retornado = stableArrayAdapter.getItemId(0);
		assertEquals(esperado, retornado);
	}

	@Test
	public void testHasStableIds() {
		stableArrayAdapter = new StableArrayAdapter(context, 80, listStr);
		assertTrue(stableArrayAdapter.hasStableIds());
	}

}
