package model;

public class Hospital {
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
