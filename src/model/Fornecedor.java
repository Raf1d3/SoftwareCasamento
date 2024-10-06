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
public class Fornecedor {

    private long id;
    private String nome;
    private String cnpj;
    private String telefone;
    private double valorAPagar;
    private int parcelas;
    private String estado;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public Fornecedor() {
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
        final Fornecedor other = (Fornecedor) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Forncedores{" + "id=" + id + ", nome=" + nome + ", cnpj=" + cnpj + ", telefone=" + telefone
                + ", valor a pagar=" + valorAPagar + ", parcelas=" + parcelas + ", estado=" + estado
                + ", data de criação=" + getDataCriacao() + ", data de modificação=" + getDataModificacao() + '}' + "\n";
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public double getValorAPagar() {
        return valorAPagar;
    }

    public void setValorAPagar(int valorAPagar) {
        this.valorAPagar = valorAPagar;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDataCriacao() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return dataCriacao.format(formatter);
    }

    /*public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    } */
    public String getDataModificacao() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return dataModificacao.format(formatter);
    }

    /* public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }*/
}
