/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import model.MuralDeRecados;
import model.Pessoas;
import model.Usuario;

/**
 *
 * @author pse
 */
public class Teste{

    public Teste() {
        ConexaoBanco.setParametrosDeConexao("root", "admin", "BDSofwareDeCasamento");

        //GenericDAO<Pessoas> PessoasDao = new GenericDAO(Pessoas.class);
        //GenericDAO<Usuario> UsuarioDao = new GenericDAO(Usuario.class);
        //GenericDAO<MuralDeRecados> MuralDeRecadosDao = new GenericDAO(MuralDeRecados.class);
        
        
        System.out.println(Pessoas.class.getPackageName());
        
        
        
        
        
    }
    

    
    
    public static void main(String[] args) {
     new Teste();   
        
        
    }
    
    
    
    
}
