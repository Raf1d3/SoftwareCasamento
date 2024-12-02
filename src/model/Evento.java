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
public class Evento implements InterfaceGenericDAO {

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

    @Override
    public List<Object> getValoresAtributos() {
        List<Object> valores = new ArrayList();
        valores.add(this.dataEvento);
        valores.add(this.cerimonial);
        valores.add(this.igreja.getId());
        valores.add(this.cartorio.getId());
        valores.add(this.noiva.getId());
        valores.add(this.noivo.getId());
        valores.add(this.dataCriacao);
        valores.add(this.dataModificacao);
        valores.add(nome);
        return valores;
    }

    public Evento(Long id, LocalDate dataEvento, Cerimonial cerimonial, Igreja igreja, Cartorio cartorio, Pessoas noiva, Pessoas noivo,
            LocalDateTime dataCriacao, LocalDateTime dataModificacao, String nome) {
        this.id = id;
        this.dataEvento = dataEvento;
        this.cerimonial = cerimonial;
        this.igreja = igreja;
        this.cartorio = cartorio;
        this.noiva = noiva;
        this.noivo = noivo;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
        this.nome = nome;
    }

    public Evento(LocalDate dataEvento, Cerimonial cerimonial, Igreja igreja, Cartorio cartorio, Pessoas noiva, Pessoas noivo, String nome) {
        this.dataEvento = dataEvento;
        this.cerimonial = cerimonial;
        this.igreja = igreja;
        this.cartorio = cartorio;
        this.noiva = noiva;
        this.noivo = noivo;
        this.dataCriacao = LocalDateTime.now();
        this.dataModificacao = LocalDateTime.now();
        this.nome = nome;
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
                + "Registro do Evento: " + " Data de Criação: " + Util.formatarData(dataCriacao)
                + " Última Modificação: " + Util.formatarData(dataModificacao);
    }

    public long getId() {
        return id;
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
