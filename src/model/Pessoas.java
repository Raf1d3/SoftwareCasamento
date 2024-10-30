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

    public Pessoas(String nome, LocalDate nascimento, String telefone) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.telefone = telefone;
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

    @Override
    public String toString() {

        return "ID: " + id 
                + " | Nome: " + nome 
                + " | Nascimento: " + Util.formatarDataLocal(nascimento)
                + " | Telefone: " + telefone 
                + "\nData de Criação: " + Util.formatarData(dataCriacao)
                + " | Última Modificação: " + Util.formatarData(dataCriacao);
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

    public LocalDate getNascimento() {
        return nascimento;
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

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDateTime dataModificacao) {
        this.dataModificacao = dataModificacao;
    }
}
