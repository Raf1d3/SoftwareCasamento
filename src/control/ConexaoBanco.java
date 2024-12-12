/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author pse
 */
public class ConexaoBanco {

    private static String usuario;
    private static String senha;
    private static String nomeBanco;

    
    static public void setParametrosDeConexao(String usuario, String senha, String nomeBanco) {
        ConexaoBanco.usuario = usuario;
        ConexaoBanco.senha = senha;
        ConexaoBanco.nomeBanco = nomeBanco;
    }

    
    public Connection getConexao() {
        try {
            Properties properties = new Properties();
            properties.setProperty("user", this.usuario);
            properties.setProperty("password", this.senha);
            properties.setProperty("useSSL", "false");
            properties.setProperty("useTimezone", "true");
            properties.setProperty("serverTimezone", "America/Sao_Paulo");
            properties.setProperty("allowPublicKeyRetrieval", "true");
            String conexao = "jdbc:mysql://localhost/" + this.nomeBanco;

            String con = conexao;
            //System.out.println("Conectado ao banco");
            return DriverManager.getConnection(con, properties);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
