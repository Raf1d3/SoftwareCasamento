/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import control.Util;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CAUPT - ALUNOS
 */
public class Cerimonial implements InterfaceGenericDAO{
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    
    
    @Override
    public List<Object> getValoresAtributos() {
        List<Object> valores = new ArrayList();
        valores.add(this.nome);
        valores.add(this.telefone);
        valores.add(this.email);
        valores.add(this.dataCriacao);
        valores.add(this.dataModificacao);
        return valores;
    }
    
    public Cerimonial(Long id, String nome, String telefone, String email, LocalDateTime dataCriacao, LocalDateTime dataModificacao) {
       this.id = id;
       this.nome = nome;
       this.telefone = telefone;
       this.email = email;
       this.dataCriacao = dataCriacao;
       this.dataModificacao = dataModificacao;
    }
        
    public Cerimonial(String nome, String telefone, String email) {
       this.nome = nome;
       this.telefone = telefone;
       this.email = email;
       this.dataCriacao = LocalDateTime.now();
       this.dataModificacao = LocalDateTime.now();
    }
    
    @Override
    public String toString() {
        return "ID: " + id 
        + " | Nome: " + nome 
        + " | Tel: " + telefone 
        + " | Email: " + email
        + " | Data de Criação: " + Util.formatarData(dataCriacao) 
        + " | Última Modificação: " + Util.formatarData(dataModificacao);
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
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
        final Cerimonial other = (Cerimonial) obj;
        return this.id == other.id;
    }
        
    public long getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
        public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
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