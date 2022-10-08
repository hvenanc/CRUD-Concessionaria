/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.model.repositories;

import br.edu.ifpe.recife.model.entities.Carro;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Henrique Venâncio
 */
public class CarroRepository {
    
    private static List <Carro> carros = new ArrayList <>();
    
    public static void insert(Carro c) {
        carros.add(c);
    }
    
    public static void update(Carro c) {
        
        for(Carro cAux: carros) {
            if(cAux.getCodigo().equals(c.getCodigo())) {
                cAux.setNome(c.getNome());
                cAux.setMarca(c.getMarca());
                cAux.setAnoFab(c.getAnoFab());
                cAux.setCor(c.getCor());
                
                return;
            }
        }
        
    }
    
    public static Carro read(String codigo) {
        
        for(Carro cAux: carros) {
            if(cAux.getCodigo().equals(codigo)) {
                return cAux;
            }
        }
        return null;
    }
    
    public static void delete(Carro c) {

       Carro cAux2 = null;
    
    for(Carro cAux: carros) {
            if(cAux.getCodigo().equals(c.getCodigo())) {
                cAux2 = cAux;
                break;
            }
        }
     carros.remove(cAux2);
}
    
    public static List<Carro> readAll(){
        return carros;
    }
}

    

