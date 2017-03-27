package com.example.fabiano.hemocentro.model;

import com.orm.SugarRecord;

public class Bolsa extends SugarRecord {
	private int qtdBolsa = 0;
	private String tipoSanguineo;
	
	public Bolsa(){
		
	}
	public Bolsa(int bolsas, String tipoSanguineo){
		this.tipoSanguineo = tipoSanguineo;
		addBolsa(bolsas);
	}

	public String getTipoSanguineo(){
		return this.tipoSanguineo;
	}
	
	public int getQtdBolsa() {
		return qtdBolsa;
	}
	
	public void liberarBolsa(int bolsas){
		qtdBolsa -= bolsas;
	}
	
	public void addBolsa(int bolsas){
		qtdBolsa += bolsas;
	}
	
}
