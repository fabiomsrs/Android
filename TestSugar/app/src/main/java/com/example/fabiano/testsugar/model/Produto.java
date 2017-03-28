package com.example.fabiano.testsugar.model;

import com.orm.SugarRecord;

/**
 * Created by fabiano on 25/03/17.
 */

public class Produto extends SugarRecord{
    String name;
    int valor;

    public Produto(){

    }
    public Produto(String name,int valor){
        this.name = name;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Nome: "+this.name + " Valor: "+this.valor;
    }
}
