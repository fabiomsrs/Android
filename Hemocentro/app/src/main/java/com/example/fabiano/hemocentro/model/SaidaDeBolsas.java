package com.example.fabiano.hemocentro.model;

import com.example.fabiano.hemocentro.model.Bolsa;
import com.orm.SugarRecord;

import java.util.Calendar;
import java.util.List;

public class SaidaDeBolsas extends SugarRecord {
	private int qtdSaida;
	private String tipoSanguinero;
	private Calendar data;

	public SaidaDeBolsas(){
		// TODO Auto-generated constructor stub
		data.getInstance();
	}


	public String getTipoSanguineo() {
		return tipoSanguinero;
	}

	public void setTipoSanguinero(String tipoSanguinero) {
		this.tipoSanguinero = tipoSanguinero;
	}

	public int getQtdSaida() {
		return qtdSaida;
	}

	public void setQtdSaida(int qtdSaida) {
		this.qtdSaida = qtdSaida;
	}
}
