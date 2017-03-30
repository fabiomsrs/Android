package com.example.fabiano.hemocentro.model;

import com.orm.SugarRecord;

public class Bolsa extends SugarRecord {
	private Doacao doacao;

	
	public Bolsa(){
		
	}

	public String getTipoSanguineo(){
		return this.doacao.getDoador().getTipoSanguineo();
	}

	public void setDoacao(Doacao doacao){
		this.doacao = doacao;
	}

	public Doacao getDoacao() {
		return doacao;
	}
}
