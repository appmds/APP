package com.mds.app.exception;

public class ValidaEntrada {

	public static boolean validaData(String data) {
		return data.matches("\\d{2}/\\d{2}/\\d{4}");
	}

	public static boolean validaAutor(String autor) {
		return autor.matches("[A-Z][a-z]*");
	}

	public static boolean validaId(String id) {
		return id.matches("\\d{4}");
	}

	public static boolean validaAno(String ano) {
		return ano.matches("\\d{4}");
	}

	public static boolean validaSigla(String sigla) {
		return sigla.matches("[a-zA-Z]*");
	}

	public static boolean validaUf(String uf) {
		return uf.matches("\\w{2}[a-zA-Z]");
	}

	public static boolean validandoEntradas(String ano, String sigla, String id, String dataIni, String autor,
			String partido, String uf) {
		if (!validaAno(ano)) {
			System.out.println("Ano invalido");
			return false;
		}
		else {
			if (!validaSigla(sigla)) {
				System.out.println("Sigla Invalida");
				return false;
			}
			else {
				if (!validaId(id)) {
					System.out.println("ID Invalida");
					return false;
				}
				else {
					if (!validaData(dataIni)) {
						System.out.println("Data Inicial Invalida");
						return false;
					}
					else {
						if (!validaAutor(autor)) {
							System.out.println("Autor Invalido");
							return false;
						}
						else {
							if (!validaSigla(partido)) {
								System.out.println("Partido Invalido");
								return false;
							}
							else {
								if (!validaUf(uf)) {
									System.out.println("Uf Invalido");
									return false;
								}
								else {
									return true;
								}
							}
						}
					}
				}
			}
		}
	}
}