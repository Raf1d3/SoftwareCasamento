/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import model.Igreja;

/**
 *
 * @author pse
 */
public class IgrejaDAO extends GenericDAO<Igreja> {

    public IgrejaDAO() {
        Igreja igreja = new Igreja();
        igreja.setEndereco("Rua Domingos Martins da Cruz, Curado, N°225");
        igreja.setNome("igreja São Martins");
        igreja.setTelefone("(34)3315-8200");
        inserir(igreja);
    }
        
    
    
    
    
    
    
    
}
