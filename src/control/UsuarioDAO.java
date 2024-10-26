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
    public UsuarioDAO() {
        inserir(new Usuario("administrador","admin","",null));
    }
    
    
    public boolean autenticar(String login, String senha) {
        for (Usuario u : GetDataBase()) {
            if (u.getLogin().equals(login) && u.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }

}
