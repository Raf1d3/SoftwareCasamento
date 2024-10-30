/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import control.GenericDAO;
import model.Usuario;
import model.Pessoas;

/**
 *
 * @author pse
 */
public class UsuarioDAO extends GenericDAO<Usuario> {

    public UsuarioDAO(Pessoas p) {
        inserir(new Usuario("administrador", "admin", "123", p));
        
    }
    
    public boolean autenticar(String login, String senha) {
        if (login != null && senha != null) {
            for (Usuario u : GetDataBase()) {
                if (u.getLogin().toLowerCase().equals(login.toLowerCase()) && u.getSenha().toLowerCase().equals(senha.toLowerCase())) {
                    return true;
                }
            }
        }
        return false;
    }

}
