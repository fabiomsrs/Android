package com.example.fabiano.hemocentro.model;

import com.orm.SugarRecord;

public class DestinoDoacao extends SugarRecord {
	private Hospital hospital;
	
	public DestinoDoacao(){		
	}
	
	public DestinoDoacao(String nome){
		this.hospital = new Hospital(nome);
	}
	
	public String getDestino(){
		if(hospital != null)
			return hospital.getNome();
		return "Doacao livre";
	}
	
}
