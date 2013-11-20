package com.mds.app.persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.Log;

public class Persistencia extends Activity {

	/*
	 * Pros parametros "fileName" dos metodos, passar ou:
	 * Persistencia.getFileFavoritos() para gravar no arquivo dos favoritos, ou
	 * Persistencia.getFileHistorico para gravar no arquivo do historico
	 */

	private static final String fileNameFavoritos = "favoritos";
	private static final String fileNameHistorico = "historico";

	private Context context;

	private FileOutputStream fileOutputStream;
	private FileInputStream fileInputStream;

	private File fileFavoritos;
	private File fileHistorico;

	public Persistencia(Context context) {
		this.context = context;
		fileFavoritos = new File(this.context.getFilesDir(), fileNameFavoritos);
		fileHistorico = new File(this.context.getFilesDir(), fileNameHistorico);
	}

	public void escreverNoArquivo(String fileName, String data) {
		final String TAG = "WRITE";
		
		try{
			verificarFileName(fileName);
		}catch(IllegalArgumentException e){
			Log.i(TAG, e.getMessage());
			e.printStackTrace();
		}
		
		int mode = 0;
		if (!(new File(fileName)).exists()) {
			mode = Context.MODE_APPEND;
		}
		else {
			mode = Context.MODE_PRIVATE;
		}

		try {
			fileOutputStream = (new ContextWrapper(context)).openFileOutput(fileName, mode);
		} catch (FileNotFoundException e) {
			Log.i(TAG, e.getMessage());
			e.printStackTrace();
		}
		try {
			fileOutputStream.write(data.getBytes());
		} catch (IOException e) {
			Log.i(TAG, e.getMessage());
			e.printStackTrace();
		}
		try {
			fileOutputStream.close();
		} catch (IOException e) {
			Log.i(TAG, e.getMessage());
			e.printStackTrace();
		}

	}

	public void reescreverArquivo(String fileName, String novoConteudo) {
		deletarArquivo(fileName);
		escreverNoArquivo(fileName, novoConteudo);
	}

	public String lerDoArquivo(String fileName) {
		final String TAG = "READ";
		
		try{
			verificarFileName(fileName);
		}catch(IllegalArgumentException e){
			Log.i(TAG, e.getMessage());
			e.printStackTrace();
			return "ARQUIVO NAO IDENTIFICADO";
		}
		
		String fileContent = "";

		try {
			fileInputStream = (new ContextWrapper(context)).openFileInput(fileName);
		} catch (FileNotFoundException e) {
			Log.i(TAG, e.getMessage());
			e.printStackTrace();
			return "ARQUIVO NAO EXISTE";
		}

		int data = 0;
		try {
			while ((data = fileInputStream.read()) != -1) {
				char ch = (char) data;
				String str = String.valueOf(ch);
				fileContent += str;
			}
			Log.i(TAG, fileContent);
		} catch (IOException e) {
			Log.i(TAG, e.getMessage());
			e.printStackTrace();
		} catch (NullPointerException e) {
			Log.i(TAG, e.getMessage());
			e.printStackTrace();
			return "ARQUIVO VAZIO";
		}

		try {
			fileInputStream.close();
		} catch (IOException e) {
			Log.i(TAG, e.getMessage());
			e.printStackTrace();
		}

		return fileContent;
	}

	private boolean deletarArquivo(String fileName) {
		final String strPath;
		if (fileName.equals(Persistencia.getFileNameFavoritos())) {
			strPath = fileFavoritos.getAbsolutePath();
		}
		else if (fileName.equals(Persistencia.getFileNameHistorico())) {
			strPath = fileHistorico.getAbsolutePath();
		}
		else{
			throw new IllegalArgumentException("Deve ser passado o arquivo dos favoritos ou do historico!");
		}

		File file = new File(strPath);
		boolean deleted = file.delete();
		String deletedStr = (deleted) ? "deleted" : "NOTdeleted";
		Log.i("DELETE", strPath + ": " + deletedStr);
		return deleted;
	}

	private void verificarFileName(String fileName){
		if(!fileName.equals(Persistencia.getFileNameFavoritos()) && !fileName.equals(Persistencia.getFileNameHistorico())){
			throw new IllegalArgumentException("Deve ser passado o arquivo dos favoritos ou do historico!");
		}
	}
	
	// ////////////////////////////////

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public FileOutputStream getFileOutputStream() {
		return fileOutputStream;
	}

	public void setFileOutputStream(FileOutputStream fileOutputStream) {
		this.fileOutputStream = fileOutputStream;
	}

	public FileInputStream getFileInputStream() {
		return fileInputStream;
	}

	public void setFileInputStream(FileInputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}

	public File getFileFavoritos() {
		return fileFavoritos;
	}

	public void setFileFavoritos(File fileFavoritos) {
		this.fileFavoritos = fileFavoritos;
	}

	public File getFileHistorico() {
		return fileHistorico;
	}

	public void setFileHistorico(File fileHistorico) {
		this.fileHistorico = fileHistorico;
	}

	public static String getFileNameFavoritos() {
		return fileNameFavoritos;
	}

	public static String getFileNameHistorico() {
		return fileNameHistorico;
	}

}
