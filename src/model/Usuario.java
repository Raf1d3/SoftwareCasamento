/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import control.Util;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CAUPT - ALUNOS
 */
public class Usuario implements InterfaceGenericDAO{

    private long id;
    private Pessoas pessoa;
    private String tipo;
    private String login;
    private String senha;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    
    @Override
    public List<Object> getValoresAtributos() {
        List<Object> valores = new ArrayList();
        
        valores.add(this.pessoa.getId());
        valores.add(this.tipo);
        valores.add(this.login);
        valores.add(this.senha);
        valores.add(this.dataCriacao);
        valores.add(this.dataModificacao);
        return valores;
    }
    
    public Usuario(Long id, Pessoas pessoa, String tipo, String login, String senha, LocalDateTime dataCriacao, LocalDateTime dataModificacao) {
        this.id = id;
        this.pessoa = pessoa;
        this.tipo = tipo;
        this.login = login;
        this.senha = senha;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
    }
    
    
    public Usuario(Pessoas pessoa, String tipo, String login, String senha) {
        this.tipo = tipo;
        this.login = login;
        this.senha = senha;
        this.pessoa = pessoa;
        this.dataCriacao = LocalDateTime.now();
        this.dataModificacao = LocalDateTime.now();
    }
    
    
    @Override
    public String toString() {

        String retorno = "ID: " + id;
        if (pessoa != null) {
            retorno += " | Nome: " + pessoa.getNome();
            retorno += " | Nascimento: " + Util.formatarDataLocal(pessoa.getNascimento());
            retorno += " | Telefone: " + pessoa.getTelefone();
        }
            retorno += " | Tipo: " + tipo
            + "\nData de Criação: " + Util.formatarData(dataCriacao)
            + " | Última Modificação: " + Util.formatarData(dataModificacao) + "\n";
        return retorno;
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

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDateTime dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    
}
