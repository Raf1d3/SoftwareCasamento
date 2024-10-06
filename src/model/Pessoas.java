/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author CAUPT - ALUNOS
 */
public class Pessoas {

    private long id;
    private static long serial;
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

    @Override
    public String toString() {
        return "Pessoas{" + "id=" + id + ", nome=" + nome + ", nascimento=" + nascimento + ", telefone=" + telefone + ", dataCriacao=" + getDataCriacao() + ", dataModificacao=" + getDataModificacao() + '}' + "\n";
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
