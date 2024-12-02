/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import control.Util;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CAUPT - ALUNOS
 */
public class Presentes implements InterfaceGenericDAO{

    long id;
    String nome;
    String tipo;
    BigDecimal valor;
    Pessoas pessoa;
    LocalDateTime dataCriacao;
    LocalDateTime dataModificacao;

    @Override
    public List<Object> getValoresAtributos() {
        List<Object> valores = new ArrayList();
        valores.add(this.nome);
        valores.add(this.tipo);
        valores.add(this.valor);
        valores.add(this.pessoa.getId());
        valores.add(this.dataCriacao);
        valores.add(this.dataModificacao);
        return valores;
    }

    public Presentes(Long id, String nome, String tipo, BigDecimal valor, LocalDateTime dataCriacao, LocalDateTime dataModificacao) {
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
    }
        
    public Presentes(String nome, String tipo, BigDecimal valor) {
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
        this.dataCriacao = LocalDateTime.now();
        this.dataModificacao = LocalDateTime.now();
    }

    @Override
    public String toString() {

        return "ID: " + id 
                + " | Nome: " + nome 
                + " | Tipo: " + tipo
                + " | Valor: " + valor 
                + " | Pessoa: " + pessoa
                + " | Data de Criação: " + Util.formatarData(dataCriacao) 
                + " | Última Modificação: " + Util.formatarData(dataModificacao);
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
