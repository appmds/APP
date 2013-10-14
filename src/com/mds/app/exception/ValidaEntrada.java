package com.mds.app.exception;

public abstract class ValidaEntrada {

	public static boolean validaData(String data) {
		if(data==null)
			return true;
		
		return data.matches("\\d{2}/\\d{2}/\\d{4}");
	}

	public static boolean validaAutor(String autor) {
		if(autor==null)
			return true;
		
		return autor.matches("[A-Z][a-z]*");
	}

	public static boolean validaNumero(String numero) {
		if(numero==null)
			return true;
		
		return numero.matches("\\d{4}");
	}

	public static boolean validaAno(String ano) {
		return ano.matches("\\d{4}");
	}

	public static boolean validaSigla(String sigla) {
		return sigla.matches("[a-zA-Z]*");
	}

	public static boolean validaUf(String uf) {
		if(uf==null)
			return true;
		
		return uf.matches("\\w{2}[a-zA-Z]*");
	}

	public static boolean[] validandoEntradas(String ano, String sigla,
			String numero, String dataIni, String autor, String partido, String uf) {
		boolean entradas[] = { false, false, false, false, false, false, false };
		
		if (!validaAno(ano)) {
			entradas[0] = true;
		}
		if (!validaSigla(sigla)) {
			entradas[1] = true;
		}
		if (!validaNumero(numero)) {
			entradas[2] = true;
		}
		if (!validaData(dataIni)) {
			entradas[3] = true;
		}
		if (!validaAutor(autor)) {
			entradas[4] = true;
		}
		if (!validaSigla(partido)) {
			entradas[5] = true;
		}
		if (!validaUf(uf)) {
			entradas[6] = true;
		}
		return entradas;
	}

	public static String identificarErros(String ano, String sigla, String numero, String dataIni, 
			String autor, String partido, String uf){
		boolean recebeValidacao[];

		recebeValidacao = validandoEntradas(ano, sigla, numero, dataIni, autor,
				partido, uf);
		String erros = "";

		if (recebeValidacao[0] == true)
			erros += " Ano invalido ";
		if (recebeValidacao[1] == true)
			erros += " Sigla Invalida ";
		if (recebeValidacao[2] == true)
			erros += " Id invalido ";
		if (recebeValidacao[3] == true)
			erros += " Data inicial invalida ";
		if (recebeValidacao[4] == true)
			erros += " Autor invalido ";
		if (recebeValidacao[5] == true)
			erros += " Partido invalido ";
		if (recebeValidacao[6] == true)
			erros += " UF invalida ";

		return erros;
	}
}