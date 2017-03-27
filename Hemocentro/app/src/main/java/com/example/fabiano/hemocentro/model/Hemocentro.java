package com.example.fabiano.hemocentro.model;

public class Hemocentro {
	private static Hemocentro hemocentro = null;
	private String nome;	
	public Doador doador;
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
	
	public Doador cadastroDoador(String nome,String sexo, String tipoSanguineo,String telefone,int qtdBolsas,String destino){
		doador = new Doador(nome,sexo,tipoSanguineo,telefone);
		if(destino.equals(""))
			doador.setDoacao(qtdBolsas);
		else
			doador.setDoacao(qtdBolsas,destino);
		return doador;
	}

    public Doador getDoador() {
        return doador;
    }

	/* virar objeto
	public void saidaDeBolsas(int bolsas){
		Bolsa.liberarBolsa(bolsas);
	}
	*/
			
	
}
