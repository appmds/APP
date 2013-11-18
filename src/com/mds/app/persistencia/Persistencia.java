package com.mds.app.persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.os.Environment;

public abstract class Persistencia extends Activity {

	/*
	 * Pros parametros "fileName" dos metodos, passar ou:
	 * Persistencia.getFileFavoritos(), ou
	 * Persistencia.getFileHistorico
	 */

	private static final String fileFavoritos = "favoritos.txt";
	private static final String fileHistorico = "historico.txt";
	private static final String testDir = "/ArquivosAPP";

	private static final File sdCard = Environment.getExternalStorageDirectory();
	private static final File directory = new File(sdCard.getAbsolutePath() + getTestDir());

	public Persistencia() {

	}

	public static void writeToFile(String fileName, String data) {
		// This will get the SD Card directory and create a folder named MyFiles in it.

		directory.mkdirs();

		// Now create the file in the above directory and write the contents into it
		File file = new File(directory, fileName);
		FileOutputStream fOut;
		try {
			fOut = new FileOutputStream(file);
			OutputStreamWriter osw = new OutputStreamWriter(fOut);
			osw.write(data);
			osw.flush();
			osw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void rewriteFile(String fileName, String conteudo) {
		File file = new File(directory, fileName);
		boolean deletado = file.delete();
		if (deletado) {
			writeToFile(fileName, conteudo);
		}
		else {
			for (int i = 0; i < 30; i++) {
				System.out.println("IH RAPAZ");
			}
		}
	}

	public static String getFileFavoritos() {
		return fileFavoritos;
	}

	public static String getFileHistorico() {
		return fileHistorico;
	}

	public static String getTestDir() {
		return testDir;
	}

	public static String readFromFile(String fileName) {

		directory.mkdirs();

		// Now create the file in the above directory and write the contents into it
		File file = new File(directory, fileName);
		FileInputStream fis = null;

		String readString = "";
		try {
			fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis);
			// READ STRING OF UNKNOWN LENGTH
			StringBuilder sb = new StringBuilder();
			char[] inputBuffer = new char[2048];
			int l;
			// FILL BUFFER WITH DATA
			while ((l = isr.read(inputBuffer)) != -1) {
				sb.append(inputBuffer, 0, l);
			}
			// CONVERT BYTES TO STRING
			readString = sb.toString();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return readString;
	}
}