/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import control.Util;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author CAUPT - ALUNOS
 */
public class Usuario {

    private long id;
    private Pessoas pessoa;
    private String tipo;
    private String login;
    private String senha;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public Usuario(String tipo, String login, String senha, Pessoas pessoa) {
        this.tipo = tipo;
        this.login = login;
        this.senha = senha;
        this.pessoa = pessoa;
        this.dataCriacao = LocalDateTime.now();
       this.dataModificacao = LocalDateTime.now();
    }
    
    @Override
    public String toString() {

        return "ID: " + id + " | Pessoa: " + pessoa + " | (Tipo: " + tipo
                + " | Data de Criação: " + getDataCriacao() + " | Última Modificação: " + getDataModificacao() + ")";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        return this.id == other.id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Pessoas getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoas pessoa) {
        this.pessoa = pessoa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDataCriacao() {
        return Util.formatarData(dataCriacao);
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getDataModificacao() {
        return Util.formatarData(dataModificacao);
    }

    public void setDataModificacao(LocalDateTime dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

}
