package com.example.fabiano.hemocentro.model;

import com.orm.SugarRecord;

public class Hospital extends SugarRecord{
	private String nome;
	
	public Hospital(){
		
	}
	
	public Hospital(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return this.nome;
	}
}
