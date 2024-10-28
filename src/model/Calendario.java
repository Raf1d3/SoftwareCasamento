/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author Emanuelle
 */
public class Calendario {

    private LocalDate dataAtual;

    public Calendario(LocalDate dataInicial) {
        this.dataAtual = dataInicial;
    }

    public LocalDate getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(LocalDate novaData) {
        this.dataAtual = novaData;
    }

    public void avancarDia() {
        this.dataAtual = dataAtual.plusDays(1);
    }

    public void retrocederDia() {
        this.dataAtual = dataAtual.minusDays(1);
    }
}
