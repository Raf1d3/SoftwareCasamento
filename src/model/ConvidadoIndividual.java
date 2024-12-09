/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import control.Util;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CAUPT - ALUNOS
 */
public class ConvidadoIndividual implements InterfaceGenericDAO {

    private long id;
    private Pessoas pessoa;
    private String familia;
    private String parentesco;
    private String confirmacao;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    
    
    @Override
    public List<Object> getValoresAtributos() {
        List<Object> valores = new ArrayList();
        valores.add(this.pessoa.getId());
        valores.add(this.familia);
        valores.add(this.parentesco);
        valores.add(this.confirmacao);
        valores.add(this.dataCriacao);
        valores.add(this.dataModificacao);
        return valores;
    }

    public ConvidadoIndividual(Long id, Pessoas pessoa, String Familia, String parentesco, String confirmacao, LocalDateTime dataCriacao, LocalDateTime dataModificacao) {
        this.id = id;
        this.pessoa = pessoa;
        this.familia = Familia;
        this.parentesco = parentesco;
        this.confirmacao = confirmacao;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
    }

    public ConvidadoIndividual(Pessoas pessoa, String Familia, String parentesco) {
        this.pessoa = pessoa;
        this.familia = Familia;
        this.parentesco = parentesco;
        this.confirmacao = "Não Confirmado";
        this.dataCriacao = LocalDateTime.now();
        this.dataModificacao = LocalDateTime.now();
    }

    @Override
    public String toString() {

        return "ID: " + id + " | Pessoa: " + pessoa
                + " | Família: " + familia
                + " | Parentesco: " + parentesco
                + "\nConfirmação: " + confirmacao
                + " | Data de Criação: " + Util.formatarData(dataCriacao)
                + " | Última Modificação: " + Util.formatarData(dataModificacao);
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

    public long getId() {
        return id;
    }

    public Pessoas getPessoa() {
        return pessoa;
    }

    public String getFamilia() {
        return familia;
    }

    public void setPessoa(Pessoas pessoa) {
        this.pessoa = pessoa;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
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
