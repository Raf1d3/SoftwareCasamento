/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import model.ConvidadoIndividual;
import model.Pessoas;

/**
 *
 * @author pse
 */
public class ConvidadoIndividualDAO extends GenericDAO<ConvidadoIndividual>{

    public ConvidadoIndividualDAO(Pessoas p) {
        ConvidadoIndividual ci = new ConvidadoIndividual();
        ci.setPessoa(p);
        ci.setParentesco("Filho");
        ci.setFamilia("almeida");
        inserir(ci);
    }
    
    
    
    
    
    
    
    
    
    
}
