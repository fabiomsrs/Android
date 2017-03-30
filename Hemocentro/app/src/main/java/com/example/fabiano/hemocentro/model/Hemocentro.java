package com.example.fabiano.hemocentro.model;

public class Hemocentro {
	private static Hemocentro hemocentro = null;
	private String nome;	
	private Doacao doacao;
	private SaidaDeBolsas saidaDeBolsas;

	public static Hemocentro getInstance(){
		if(hemocentro == null){
			hemocentro = new Hemocentro();
		}
		return hemocentro;
	}

	public Hemocentro(){		
		
	}
	
	public Hemocentro(String nome){
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}




	/*
	public void setSaidaDeBolsas(int bolsas,String tipoSanguineo){
		saidaDeBolsas = new SaidaDeBolsas(bolsas);
	}*/

			
	
}
