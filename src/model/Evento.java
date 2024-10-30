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
public class Evento {
    private long id;
    private LocalDate dataEvento;
    private Cerimonial cerimonial;
    private Igreja igreja;
    private Cartorio cartorio;
    private Pessoas noiva;
    private Pessoas noivo;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;
    private String nome;

    public Evento() {
        this.dataCriacao = LocalDateTime.now();
        this.dataModificacao = LocalDateTime.now();
    }

   @Override
public String toString() {
    return "ID: " + id 
        + " | Nome do Evento: " + nome
        + " | Noiva: " + noiva.getNome()
        + " | Noivo: " + noivo.getNome()
        + " | Data do Evento: " + Util.formatarDataLocal(dataEvento) + "\n"
    
        + "Igreja: " + igreja.getNome() 
        + " | Endereço: " + igreja.getEndereco()
        + " |Telefone: " + igreja.getTelefone() + "\n"
        
        + "Cartório: " + "Nome: " + cartorio.getNome() 
        + " | Endereço: " + cartorio.getEndereco()
        + " | Telefone: " + cartorio.getTelefone() + "\n"
        
        + "Registro do Evento: " + " Data de Criação: " + getDataCriacao()
        + " Última Modificação: " + getDataModificacao() + "\n\n";
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

    public LocalDate getDataEvento() {
        return dataEvento;
    }
    
    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public Cerimonial getCerimonial() {
        return cerimonial;
    }

    public void setCerimonial(Cerimonial cerimonial) {
        this.cerimonial = cerimonial;
    }

    public Igreja getIgreja() {
        return igreja;
    }

    public void setIgreja(Igreja igreja) {
        this.igreja = igreja;
    }

    public Cartorio getCartorio() {
        return cartorio;
    }

    public void setCartorio(Cartorio cartorio) {
        this.cartorio = cartorio;
    }

    public Pessoas getNoiva() {
        return noiva;
    }

    public void setNoiva(Pessoas noiva) {
        this.noiva = noiva;
    }

    public Pessoas getNoivo() {
        return noivo;
    }

    public void setNoivo(Pessoas noivo) {
        this.noivo = noivo;
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
    
     public LocalDate getDataCriacaoSomenteData() {
        return dataCriacao.toLocalDate();
    }
}