/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import model.Usuario;
import control.GenericDAO;

/**
 *
 * @author pse
 */
public class UsuarioDAO extends GenericDAO<Usuario> {

    public UsuarioDAO() {
        Usuario admin = new Usuario();
        admin.setLogin("admin");
        admin.setSenha("");
        admin.setTipo("administrador");
        inserir(admin);
    }
    
    
    public boolean autenticar(String login, String senha) {
        for (Usuario u : GetDataBase()) {
            if (u.getLogin().equals(login) && u.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }
    
    
    
    
    /*
    private Usuario[] usuario = new Usuario[100];
    
    public UsuarioDAO() {
        Usuario administrador = new Usuario();
        administrador.setLogin("admin");
        administrador.setSenha("");
        administrador.setTipo("administrador");
        inserir(administrador);
    }
    

    public boolean alterar(Usuario uNovo, Usuario uAntigo) {
        if (uAntigo != null){
        for (int i = 0; i < usuario.length; i++) {
            if (usuario[i] != null && usuario[i].getId() == uAntigo.getId()) {
                if (uNovo.getLogin() != null) {
                    usuario[i].setLogin(uNovo.getLogin());
                }
                if (uNovo.getSenha() != null) {
                    usuario[i].setSenha(uNovo.getSenha());
                }
                if (uNovo.getPessoa() != null) {
                    usuario[i].setPessoa(uNovo.getPessoa());
                }
                if (uNovo.getTipo() != null) {
                    usuario[i].setTipo(uNovo.getTipo());
                }
                //alterar pNova.getDataModificacao()
            }
        }
        return true;
        }
        return false;
    }

    */
    



}
