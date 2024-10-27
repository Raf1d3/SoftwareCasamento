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
public class Cartorio {
    private Long id;
    private String nome;
    private String endereco;
    private String telefone;
    private LocalDate data;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public Cartorio() {
       this.dataCriacao = LocalDateTime.now();
       this.dataModificacao = LocalDateTime.now();
    }
    
    @Override
    public String toString() {
        return "ID: " + id 
        + " | Nome: " + nome 
        + " | Endereco: " + endereco 
        + " | Tel: " + telefone 
        + " | Data: " + data
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
        final Cartorio other = (Cartorio) obj;
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
    
    public String getEndereco() {
        return endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
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