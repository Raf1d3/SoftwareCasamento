/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author CAUPT - ALUNOS
 */
public class Usuario {

    private long id;
    private static long serial;
    private Pessoas pessoa;
    private String tipo;
    private String login;
    private String senha;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public Usuario() {
        this.dataCriacao = LocalDateTime.now();
        this.dataModificacao = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", pessoa=" + pessoa + ", tipo=" + tipo + ", dataCriacao=" + getDataCriacao() + ", dataModificacao=" + getDataModificacao() + '}';
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return dataCriacao.format(formatter);
    }

    /*public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }*/
    public String getDataModificacao() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return dataModificacao.format(formatter);
    }

    /*public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }*/
}
