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
public class Cartorio implements InterfaceGenericDAO {

    private Long id;
    private String nome;
    private String endereco;
    private String telefone;
    private LocalDate data;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;
    
    @Override
    public List<Object> getValoresAtributos() {
        List<Object> valores = new ArrayList();
        valores.add(this.nome);
        valores.add(this.endereco);
        valores.add(this.telefone);
        valores.add(this.data);
        valores.add(this.dataCriacao);
        valores.add(this.dataModificacao);
        return valores;
    }
    
    public Cartorio(Long id, String nome, String endereco, String telefone, LocalDate data, LocalDateTime dataCriacao, LocalDateTime dataModificacao) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.data = data;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
    }

    public Cartorio(String nome, String endereco, String telefone, LocalDate data) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.data = data;
        this.dataCriacao = LocalDateTime.now();
        this.dataModificacao = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "ID: " + id
                + " | Nome: " + nome
                + " | Endereco: " + endereco
                + " | Tel: " + telefone
                + " | Data Marcada: " + Util.formatarDataLocal(data)
                + " | Data de Criação: " + Util.formatarData(dataCriacao)
                + " | Última Modificação: " + Util.formatarData(dataModificacao) + "\n";
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

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalDate getData() {
        return data;
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
