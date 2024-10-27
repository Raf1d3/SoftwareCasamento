/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author CAUPT - ALUNOS
 */
public class Presentes {
    long id;
    String nome;
    String tipo;
    BigDecimal valor;
    Pessoas pessoa;
    LocalDate dataCriacao;
    LocalDate dataModificacao;

    public Presentes(String nome, String tipo, BigDecimal valor) {
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    

    @Override
    public String toString() {
        return "Presentes{" + "id=" + id + ", nome=" + nome + ", tipo=" + tipo + ", valor=" + valor + ", pessoa=" + pessoa + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Presentes other = (Presentes) obj;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Pessoas getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoas pessoa) {
        this.pessoa = pessoa;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }
    
    
    
    
    
    
}


