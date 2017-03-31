package com.example.fabiano.hemocentro.model;

import com.orm.SugarRecord;

/**
 * Created by fabiano on 30/03/17.
 */

public class Campanha extends SugarRecord {
    private String tipoSanguineo;
    private String nome;

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
