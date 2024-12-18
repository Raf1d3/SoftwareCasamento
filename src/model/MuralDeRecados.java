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
public class MuralDeRecados {

    long id;
    Pessoas pessoa;
    String comentario;
    LocalDateTime dataCriacao;
    LocalDateTime dataModificacao;

    public MuralDeRecados() {
        this.dataCriacao = LocalDateTime.now();
        this.dataModificacao = LocalDateTime.now();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final MuralDeRecados other = (MuralDeRecados) obj;
        return this.id == other.id;
    }

    public long getId() {
        return id;
    }

    public Pessoas getPessoa() {
        return pessoa;
    }

    public String getComentario() {
        return comentario;
    }

    public String getDataCriacao() {
        return Util.formatarData(dataCriacao);
    }

    public String getDataModificacao() {
        return Util.formatarData(dataModificacao);
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPessoa(Pessoas pessoa) {
        this.pessoa = pessoa;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataModificacao(LocalDateTime dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    @Override
    public String toString() {

        return "ID: " + id + " | Pessoa: " + pessoa + " | Comentário: " + comentario
                + " | Data de Criação: " + getDataCriacao() + " | Última Modificação: " + getDataModificacao();
    }
}
