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
public class Pagamentos implements InterfaceGenericDAO{

    private long id;
    private LocalDate data;
    private Pessoas pessoa;
    private String descricao;
    private Fornecedor fornecedor;
    private double valor;
    private int parcela;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;
    private boolean agendado;

    @Override
    public List<Object> getValoresAtributos() {
        List<Object> valores = new ArrayList();
        valores.add(this.data);
        valores.add(this.pessoa.getId());
        valores.add(this.descricao);
        valores.add(this.fornecedor.getId());
        valores.add(this.valor);
        valores.add(this.parcela);
        valores.add(this.dataCriacao);
        valores.add(this.dataModificacao);
        valores.add(this.agendado);
        return valores;
    }
    
    
    public Pagamentos(Long id, LocalDate data, Pessoas pessoa, String descricao, Fornecedor fornecedor, double valor, int parcela, 
            LocalDateTime dataCriacao, LocalDateTime dataModificacao, boolean agendado) {
        this.id = id;
        this.data = data;
        this.pessoa = pessoa;
        this.descricao = descricao;
        this.fornecedor = fornecedor;
        this.valor = valor;
        this.parcela = parcela;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
        this.agendado = agendado;

    }

    public Pagamentos(LocalDate data, Pessoas pessoa, String descricao, Fornecedor fornecedor, boolean agendado) {
        this.descricao = descricao;
        if(agendado == true && data != null){
            this.data = data;
        }else{
            this.data = Util.getDataAtual();
        }
        this.parcela = 0;
        this.pessoa = pessoa;
        this.fornecedor = fornecedor;
        this.agendado = agendado;
        this.dataCriacao = LocalDateTime.now();
        this.dataModificacao = LocalDateTime.now();
    }

    @Override
    public String toString() {
        String tipoPagamento;
        if (agendado) {
            tipoPagamento = "Agendado";
        } else {
            tipoPagamento = "Regular";
        }
        return "ID: " + id
                + " | nome: " + pessoa.getNome()
                + " | telefone: " + pessoa.getTelefone()
                + " | Data de pagamento: " + Util.formatarDataLocal(data)
                + " | Descrição: " + descricao
                + "\nValor Pago: " + valor
                + " | Valor a Pagar: " + fornecedor.getValorAPagar()
                + " | Valor Total: " + fornecedor.getValorOriginalAPagar()
                + " | Total de parcelas: " + parcela
                + " | Parcela atual: " + fornecedor.getParcelas()
                + "\nEstado do pagamento: " + fornecedor.getEstado()
                + " | Tipo de Pagamento: " + tipoPagamento
                + "\nNome fornecedor: " + fornecedor.getPessoa().getNome()
                + " | Nome serviço : " + fornecedor.getNomeServico()
                + " | Telefone: " + fornecedor.getTelefone()
                + " | Cnpj: " + fornecedor.getCnpj()
                + "\nData de Criação: " + Util.formatarData(dataCriacao)
                + " | Última Modificação: " + Util.formatarData(dataModificacao) + "\n";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Pagamentos other = (Pagamentos) obj;
        return this.id == other.id;
    }

    public long getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Pessoas getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoas pessoa) {
        this.pessoa = pessoa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getParcela() {
        return parcela;
    }

    public void setParcela(int parcela) {
        this.parcela = parcela;
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

    public boolean getAgendado() {
        return agendado;
    }

    public void setAgendado(boolean agendado) {
        this.agendado = agendado;
    }

    public long getFornecedorId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
