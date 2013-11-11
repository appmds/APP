package com.mds.app.testes.view;

import org.junit.Test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.ImageButton;

import com.mds.app.R;
import com.mds.app.view.Sobre;

public class SobreTest extends ActivityInstrumentationTestCase2<Sobre> {

	private Sobre mActivity;
	private ImageButton voltarTest;

	public SobreTest() {
		super(Sobre.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mActivity = this.getActivity();
		voltarTest = (ImageButton) mActivity.findViewById(R.id.voltar);
	}

	@Test
	public void test() {
		assertEquals(mActivity.getVoltar() ,voltarTest);
	}
	

}
