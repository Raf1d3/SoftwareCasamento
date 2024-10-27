/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import control.Util;
/**
 *
 * @author CAUPT - ALUNOS
 */
public class ConvidadoFamilia {

    long id;
    String nomeDaFamilia;
    String acesso;
    String confirmacao;
    LocalDate dataCriacao;
    LocalDate dataModificacao;

    public ConvidadoFamilia() {
        
        String CaracteresAleatorios = Util.gerarStringAleatoria(4);
        this.confirmacao = "Não Confirmado";
        this.acesso = CaracteresAleatorios;
    }

    @Override
    public String toString() {

        return "ID: " + id + " | Nome da família: " + nomeDaFamilia + " | Acesso: " + acesso
                + " | Confirmacão: " + confirmacao + " | Data de Criação: " + dataCriacao
                + " | Última Modificação: " + dataModificacao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeDaFamilia() {
        return nomeDaFamilia;
    }

    public void setNomeDaFamilia(String nomeDaFamilia) {
        this.nomeDaFamilia = nomeDaFamilia;
    }

    public String getAcesso() {
        return acesso;
    }

    public String getConfirmacao() {
        return confirmacao;
    }

    public void setConfirmacao(String confirmacao) {
        this.confirmacao = confirmacao;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

}
