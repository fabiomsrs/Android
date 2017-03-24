package model;

import com.orm.SugarRecord;

import java.util.Calendar;

public class Doacao extends SugarRecord{
	private DestinoDoacao destinoDoacao;
	private Calendar data;
	private Bolsa bolsa;
	
	public Doacao(){
		data = Calendar.getInstance();
	}
	
	public Doacao(String nome){
		data = Calendar.getInstance();
		destinoDoacao = new DestinoDoacao(nome);
	}
	
	public void setBolsas(int qtdBolsa, String tipoSanguineo){
		bolsa = new Bolsa(qtdBolsa, tipoSanguineo);
	}
	
	public Calendar getData(){
		data = Calendar.getInstance();
		return data;
	}

	public String getDestinoDoacao() {
		return destinoDoacao.getDestino();
	}
	
	
}
