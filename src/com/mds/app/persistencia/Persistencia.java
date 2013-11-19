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
import android.util.Log;

public abstract class Persistencia extends Activity {

	/*
	 * Pros parametros "fileName" dos metodos, passar ou:
	 * Persistencia.getFileFavoritos() para gravar no arquivo dos favoritos, ou
	 * Persistencia.getFileHistorico para gravar no arquivo do historico
	 */

	private static final String fileFavoritos = "favoritos.txt";
	private static final String fileHistorico = "historico.txt";
	private static final String directoryName = "/ArquivosAPP";

	private static final File sdCard = Environment.getExternalStorageDirectory();
	private static final File directory = new File(sdCard.getAbsolutePath() + getDirectoryName());

	private static final File favoritos = new File(directory, fileFavoritos);
	private static final File historico = new File(directory, fileFavoritos);

	public static void writeToFile(String fileName, String data) {
		// This will get the SD Card directory and create a folder named MyFiles in it.

		directory.mkdirs();

		// Now create the file in the above directory and write the contents into it
		File file;
		if(fileName.equals(fileFavoritos)){
			file = favoritos;
		}
		else{
			file = historico;
		}
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
			Log.e("LOGGER", "Arquivo NAO deletado com sucesso!");
		}
	}

	public static String getFileFavoritos() {
		return fileFavoritos;
	}

	public static String getFileHistorico() {
		return fileHistorico;
	}

	public static String getDirectoryName() {
		return directoryName;
	}

	public static String readFromFile(String fileName) {

		directory.mkdirs();

		// Now create the file in the above directory and write the contents into it
		File file;
		if(fileName.equals(fileFavoritos)){
			file = favoritos;
		}
		else{
			file = historico;
		}
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