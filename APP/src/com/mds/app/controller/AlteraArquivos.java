package com.mds.app.controller;

import com.mds.app.model.ProjetoModel;

public interface AlteraArquivos {

	public void adicionar(ProjetoModel projeto, String conteudo);

	public void remover(ProjetoModel projeto, String conteudo);

	public String projetosEmString();

	public void popularProjetos(String conteudoArquivo);

	public void popularListaComProjetos();

}
