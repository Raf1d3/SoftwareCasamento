/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import model.Usuario;

/**
 *
 * @author pse
 */
public class UsuarioDAO extends GenericDAO<Usuario> {

    public UsuarioDAO(Class<Usuario> classe) {
        super(classe);
    }

    public boolean autenticar(String login, String senha) {
        
        if (login != null && senha != null) {
            for (Usuario u : listar()) {
                if (u.getLogin().toLowerCase().equals(login.toLowerCase()) && u.getSenha().toLowerCase().equals(senha.toLowerCase())) {
                    return true;
                }
            }
        }
        return false;
    }

}
