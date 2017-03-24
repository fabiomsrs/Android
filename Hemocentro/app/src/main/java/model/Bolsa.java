package model;

public class Bolsa {
	private static int qtdBolsa = 0;
	private String tipoSanguineo;
	
	public Bolsa(){
		
	}
	public Bolsa(int bolsas, String tipoSanguineo){
		this.tipoSanguineo = tipoSanguineo;
		addBolsa(bolsas);
	}
	
	public static int getQtdBolsa() {
		return qtdBolsa;
	}
	
	public static void liberarBolsa(int bolsas){
		qtdBolsa -= bolsas;
	}
	
	public static void addBolsa(int bolsas){
		qtdBolsa += bolsas;
	}
	
}
