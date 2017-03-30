package com.example.fabiano.hemocentro.model;

import com.orm.SugarRecord;
import com.orm.dsl.Ignore;

import java.util.List;

public class Doador extends SugarRecord{
	private String nome;
	private String sexo;
	private String tipoSanguineo;
	private String telefone;

	@Ignore
	private List<Doacao> doacao = getDoacao();

	public Doador(){
	}

	public Doador(String nome, String sexo, String tipoSanguineo, String telefone){
		this.nome = nome;
		this.sexo = sexo;
		this.telefone = telefone;
		this.tipoSanguineo = tipoSanguineo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTipoSanguineo() {
		return tipoSanguineo;
	}

	public void setTipoSanguineo(String tipoSanguino) {
		this.tipoSanguineo = tipoSanguino;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public List<Doacao> getDoacao(){
        return Doacao.find(Doacao.class,"doador = ?",String.valueOf(getId()));
	}


	@Override
	public String toString() {
		return "Nome: "+this.nome + "\nTipo: " + this.tipoSanguineo + "\nGenero: " + this.sexo;
	}
}
