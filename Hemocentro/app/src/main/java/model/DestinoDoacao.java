package model;

public class DestinoDoacao {	
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
