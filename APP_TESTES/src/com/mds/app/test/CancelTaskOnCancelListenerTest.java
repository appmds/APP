package com.mds.app.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import android.test.AndroidTestCase;

import com.mds.app.util.CancelTaskOnCancelListener;

public class CancelTaskOnCancelListenerTest extends AndroidTestCase {

	CancelTaskOnCancelListener cancelTaskListener;

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
		cancelTaskListener = null;
	}

	@Test
	public void testTaskNula() {
		cancelTaskListener = new CancelTaskOnCancelListener(null);
		assertNull(cancelTaskListener.getTask());
	}

	@Test
	public void testInstance() {
		cancelTaskListener = new CancelTaskOnCancelListener();
		assertNotNull(cancelTaskListener);
	}

}
