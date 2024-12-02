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

    public ConvidadoFamiliaDAO(Class<ConvidadoFamilia> classe) {
        super(classe);
    }

    public ConvidadoFamilia autenticar(String login, String senha) {
        for (ConvidadoFamilia u : listar()) {
            if (login != null && senha != null) {
                if (u.getNomeDaFamilia().toLowerCase().equals(login.toLowerCase()) && u.getAcesso().toLowerCase().equals(senha.toLowerCase())) {
                    return u;
                }
            }
        }
        return null;
    }

}
