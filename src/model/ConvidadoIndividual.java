/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import control.Util;
import java.time.LocalDateTime;

/**
 *
 * @author CAUPT - ALUNOS
 */
public class ConvidadoIndividual {

    private long id;
    private Pessoas pessoa;
    private String Familia;
    private String parentesco;
    private String confirmacao;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;
    
    public ConvidadoIndividual() {
        this.confirmacao = "Não Confirmado";
        this.dataCriacao = LocalDateTime.now();
        this.dataModificacao = LocalDateTime.now();
    }

    @Override
    public String toString() {

        return "ID: " + id + " | Pessoa: " + pessoa + " | Família: " + Familia
                + " | Parentesco: " + parentesco + " | Confirmação: " + confirmacao + " | Data de Criação: " + getDataCriacao()
                + " | Última Modificação: " + getDataModificacao();
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
        final ConvidadoIndividual other = (ConvidadoIndividual) obj;
        return this.id == other.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public Pessoas getPessoa() {
        return pessoa;
    }

    public String getFamilia() {
        return Familia;
    }

    public void setPessoa(Pessoas pessoa) {
        this.pessoa = pessoa;
    }

    public void setFamilia(String familia) {
        this.Familia = familia;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getConfirmacao() {
        return confirmacao;
    }

    public void setConfirmacao(String confirmacao) {
        this.confirmacao = confirmacao;
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
