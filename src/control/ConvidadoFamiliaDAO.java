/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import model.ConvidadoFamilia;

/**
 *
 * @author pse
 */
public class ConvidadoFamiliaDAO extends GenericDAO<ConvidadoFamilia> {

    public ConvidadoFamiliaDAO() {
        
        ConvidadoFamilia admin = new ConvidadoFamilia();
        admin.setNomeDaFamilia("portela");
        admin.setAcesso("");
        inserir(admin);
    }
    
    public boolean autenticar(String login, String senha) {
        for (ConvidadoFamilia u : GetDataBase()) {
            if (u.getNomeDaFamilia().equals(login) && u.getAcesso().equals(senha)) {
                return true;
            }
        }
        return false;
    }  
}
