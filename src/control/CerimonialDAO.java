/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import model.Cerimonial;

/**
 *
 * @author pse
 */
public class CerimonialDAO extends GenericDAO<Cerimonial> {

    public CerimonialDAO() {
        Cerimonial cerimonial = new Cerimonial();
        cerimonial.setEmail("xiquecontato@cerimonialvip.com.br");
        cerimonial.setNome("xique cerimonias");
        cerimonial.setTelefone("(34)3344-8500");
        inserir(cerimonial);
    }
    
    
    
    
}
