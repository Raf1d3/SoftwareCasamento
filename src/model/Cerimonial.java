/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import control.Util;
import java.time.LocalDateTime;

/**
 *
 * @author CAUPT - ALUNOS
 */
public class Cerimonial {
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public Cerimonial() {
       this.dataCriacao = LocalDateTime.now();
       this.dataModificacao = LocalDateTime.now();
    }
    
    @Override
    public String toString() {
        return "ID: " + id 
        + " | Nome: " + nome 
        + " | Tel: " + telefone 
        + " | Email: " + email
        + " | Data de Criação: " + getDataCriacao() 
        + " | Última Modificação: " + getDataModificacao() + "\n";
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
    
    public void setId(long id) {
        this.id = id;
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