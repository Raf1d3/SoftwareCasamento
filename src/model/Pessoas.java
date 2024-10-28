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
public class Pessoas {

    private long id;
    private String nome;
    private LocalDate nascimento;
    private String telefone;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;
    
    public Pessoas() {
       this.dataCriacao = LocalDateTime.now();
       this.dataModificacao = LocalDateTime.now();
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
        final Pessoas other = (Pessoas) obj;
        return this.id == other.id;
    }

    /*
    @Override
    public String toString() {
        return "[ID: " + id + "] | [Nome: " + nome + "] | [Nascimento: " + nascimento
                + "] | [Telefone: " + telefone + "] | [Criado em: " + dataCriacao
                + "] | [Modificado em: " + dataModificacao + "]";
    }
    
    @Override
    public String toString() {
        return String.format(
                "| %-5s | %-35s | %-12s | %-15s | %-12s | %-15s |",
                "ID: " + id,
                "Nome: " + nome,
                "Nascimento: " + nascimento,
                "Telefone: " + telefone,
                "Criado em: " + dataCriacao,
                "Modificado em: " + dataModificacao
        );
    }
     */
    @Override
    public String toString() {

        return "ID: " + id + " | Nome: " + nome + " | Nascimento: " + getNascimento()
                + " | Telefone: " + telefone + " | Data de Criação: " + getDataCriacao() 
                + " | Última Modificação: " + getDataModificacao();
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

    public String getNascimento() {
        return Util.formatarDataLocal(nascimento);
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
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
