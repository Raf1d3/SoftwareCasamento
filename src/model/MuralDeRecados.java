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
public class MuralDeRecados implements InterfaceGenericDAO {

    private long id;
    private Pessoas pessoa;
    private String comentario;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    @Override
    public List<Object> getValoresAtributos() {
        List<Object> valores = new ArrayList();

        valores.add(this.pessoa.getId());
        valores.add(this.comentario);
        valores.add(this.dataCriacao);
        valores.add(this.dataModificacao);
        return valores;
    }
    
    
    public MuralDeRecados(Long id, Pessoas pessoa, String comentario, LocalDateTime dataCriacao, LocalDateTime dataModificacao) {
        this.id = id;
        this.pessoa = pessoa;
        this.comentario = comentario;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
    }
        
    
    public MuralDeRecados(Pessoas pessoa, String comentario) {
        this.pessoa = pessoa;
        this.comentario = comentario;
        this.dataCriacao = LocalDateTime.now();
        this.dataModificacao = LocalDateTime.now();
    }
    
    
    
    @Override
    public String toString() {

        return "ID: " + id 
                + " | Nome: " + pessoa.getNome()
                + " | Telefone: " + pessoa.getTelefone()
                + " | Comentário: " + this.comentario
                + " | Data de Criação: " + Util.formatarData(this.dataCriacao) 
                + " | Última Modificação: " + Util.formatarData(this.dataModificacao) + "\n";
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

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataModificacao() {
        return dataModificacao;
    }

    public void setPessoa(Pessoas pessoa) {
        this.pessoa = pessoa;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }


    public void setDataModificacao(LocalDateTime dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

}
