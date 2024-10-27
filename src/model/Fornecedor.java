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
public class Fornecedor {

    private long id;
    private String nome;
    private String cnpj;
    private String telefone;
    private double valorAPagar;
    private double valorOriginalAPagar;
    private double valorPago;
    private int parcelas;
    private String estado;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;
    

    public Fornecedor() {
        this.dataCriacao = LocalDateTime.now();
        this.dataModificacao = LocalDateTime.now();
        this.valorOriginalAPagar = valorAPagar;
    }
    


    @Override
    public String toString() {
        return "ID: " + id
                + " | Nome: " + nome
                + " | CNPJ: " + cnpj
                + " | Tel: " + telefone
                + " | Valor combinado: " + valorOriginalAPagar
                + " | Valor a Pagar: " + valorAPagar
                + " | Valor pago: " + valorPago
                + " | Parcelas: " + parcelas
                + " | Estado: " + estado
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
        final Fornecedor other = (Fornecedor) obj;
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

    public void setValorAPagar(double valorAPagar) {
        this.valorAPagar = valorAPagar;
        
         if (this.valorOriginalAPagar == 0.0) {
            this.valorOriginalAPagar = valorAPagar;
        }
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

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public double getValorOriginalAPagar() {
        return valorOriginalAPagar;
    }
    
        public void setValorOriginalAPagar(double valorOriginalAPagar) {
        this.valorOriginalAPagar = valorOriginalAPagar;
    }
}
