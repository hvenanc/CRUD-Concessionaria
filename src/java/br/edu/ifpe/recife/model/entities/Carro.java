/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.model.entities;

/**
 *
 * @author Henrique Venâncio
 */
public class Carro {
    
    private String codigo;
    private String nome;
    private String marca;
    private int anoFab;
    private String cor;

   
    public String getCodigo() {
        return codigo;
    }

    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    
    public String getNome() {
        return nome;
    }

    
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public String getMarca() {
        return marca;
    }

    
    
    public void setMarca(String marca) {
        this.marca = marca;
    }

    
    
    public int getAnoFab() {
        return anoFab;
    }

    
    
    public void setAnoFab(int anoFab) {
        this.anoFab = anoFab;
    }

    
    public String getCor() {
        return cor;
    }

    
    public void setCor(String cor) {
        this.cor = cor;
    }
    
}
