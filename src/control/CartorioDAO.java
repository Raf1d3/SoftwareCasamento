/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import model.Cartorio;

/**
 *
 * @author pse
 */
public class CartorioDAO extends GenericDAO<Cartorio> {

    public CartorioDAO() {
        
        Cartorio cartorio = new Cartorio();
        cartorio.setData(Util.parseDataLocal("12/10/2024"));
        cartorio.setEndereco("Rua Castro Alves, Areão, N°200");
        cartorio.setNome("Cartorio do 1° Oficio de Notas");
        cartorio.setTelefone("(34)3331-1303");
        
        inserir(cartorio);
    }
    
    
    
    
    
    
    
}
