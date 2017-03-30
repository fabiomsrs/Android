package com.example.fabiano.hemocentro.model;

import com.orm.SugarRecord;
import com.orm.dsl.Ignore;

import java.util.Calendar;
import java.util.List;

public class Doacao extends SugarRecord{
	private Doador doador;
	private Calendar data;
	@Ignore
	private DestinoDoacao destinoDoacao;


	public Doacao(){
		data = Calendar.getInstance();
	}
	
	public Doacao(String nome){
		data = Calendar.getInstance();
		destinoDoacao = new DestinoDoacao(nome);
	}

	public void setDoador(Doador doador){
        this.doador = doador;
	}

	public Doador getDoador() {
		return doador;
	}


	public List<Bolsa> getBolsa(){

		return Bolsa.find(Bolsa.class,"doacao = ?",String.valueOf(getId()));
	}

	public Calendar getData(){
		data = Calendar.getInstance();
		return data;
	}

	public String getDestinoDoacao() {
		return destinoDoacao.getDestino();
	}
	
	
}
