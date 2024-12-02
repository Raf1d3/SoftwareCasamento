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
public class Fornecedor implements InterfaceGenericDAO{

    private long id;
    private String nomeServico;
    private String cnpj;
    private String telefone;
    private double valorAPagar;
    private double valorOriginalAPagar;
    private double valorPago;
    private Pessoas pessoa;
    private int parcelas;
    private String estado;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    
    @Override
    public List<Object> getValoresAtributos() {
        List<Object> valores = new ArrayList();
        valores.add(this.nomeServico);
        valores.add(this.cnpj);
        valores.add(this.telefone);
        valores.add(this.valorAPagar);
        valores.add(this.valorOriginalAPagar);
        valores.add(this.valorPago);
        valores.add(this.pessoa.getId());
        valores.add(this.parcelas);
        valores.add(this.estado);
        valores.add(this.dataCriacao);
        valores.add(this.dataModificacao);
        return valores;
    }
    
    public Fornecedor(Long id, String nomeServico, String cnpj, String telefone, double valorAPagar, double valorOriginalAPagar, 
    double valorPago, Pessoas pessoa, int parcelas, String estado, LocalDateTime dataCriacao, LocalDateTime dataModificacao) {
        this.id = id;
        this.nomeServico = nomeServico;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.valorAPagar = valorAPagar;
        this.valorOriginalAPagar = valorOriginalAPagar;
        this.valorPago = valorPago;
        this.pessoa = pessoa;
        this.parcelas = parcelas;
        this.estado = estado;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
    }
    
    public Fornecedor(String nomeServico, String cnpj, String telefone, double valorAPagar, Pessoas pessoa, int parcelas) {
        this.nomeServico = nomeServico;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.valorAPagar = valorAPagar;
        this.valorOriginalAPagar = valorAPagar;
        this.valorPago = 0;
        this.pessoa = pessoa;
        this.parcelas = parcelas;
        this.estado = "A pagar";
        this.dataCriacao = LocalDateTime.now();
        this.dataModificacao = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "ID: " + id
                + " | Nome do serviço: " + nomeServico
                + " | Nome do fornecedor: " + pessoa.getNome()
                + " | Tel pessoal: " + pessoa.getTelefone()
                + " | CNPJ: " + cnpj
                + " | Tel profissional: " + telefone
                + "\nValor combinado: " + valorOriginalAPagar
                + " | Valor a Pagar: " + valorAPagar
                + " | Valor pago: " + valorPago
                + " | Parcela atual: " + parcelas
                + " | Estado: " + estado
                + " | Data de Criação: " + Util.formatarData(dataCriacao)
                + " | Última Modificação: " + Util.formatarData(dataModificacao);
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

    public Pessoas getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoas pessoa) {
        this.pessoa = pessoa;
    }

    public long getId() {
        return id;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nome) {
        this.nomeServico = nome;
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

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataModificacao() {
        return dataModificacao;
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
