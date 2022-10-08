/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.model.repositories;

import br.edu.ifpe.recife.model.entities.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hvs1
 */
public class ClienteRepository {
    
    private static List <Cliente> clientes = new ArrayList <>();
    
    public static void insert(Cliente c) {
        clientes.add(c);
    }
    
    public static void update(Cliente c) {
        
        for(Cliente cAux: clientes) {
            if(cAux.getCpf().equals(c.getCpf())) {
                cAux.setNome(c.getNome());
                cAux.setIdade(c.getIdade());
                cAux.setTelefone(c.getTelefone());
                cAux.setTelefone(c.getTelefone());
                
                return;
            }
        }
        
    }
    
    public static Cliente read(String cpf) {
        
        for(Cliente cAux: clientes) {
            if(cAux.getCpf().equals(cpf)) {
                return cAux;
            }
        }
        return null;
    }
    
    public static void delete(Cliente c) {

       Cliente cAux2 = null;
    
    for(Cliente cAux: clientes) {
            if(cAux.getCpf().equals(c.getCpf())) {
                cAux2 = cAux;
                break;
            }
        }
     clientes.remove(cAux2);
}
    
    public static List<Cliente> readAll(){
        return clientes;
    }
    
}
