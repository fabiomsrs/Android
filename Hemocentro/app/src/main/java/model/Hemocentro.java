package model;

public class Hemocentro {
	private String nome;	
	private Doador doador;
	private SaidaDeBolsas saidaDeBolsas;
	public Hemocentro(){		
		
	}
	
	public Hemocentro(String nome){
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void cadastroDoador(String nome,String sexo, String tipoSanguineo,String telefone){
		Doador doador = new Doador(nome,sexo,tipoSanguineo,telefone);
		doador.setDoacao(10);
		//doador.save();
	}
		
	/* virar objeto
	public void saidaDeBolsas(int bolsas){
		Bolsa.liberarBolsa(bolsas);
	}
	*/
			
	
}
