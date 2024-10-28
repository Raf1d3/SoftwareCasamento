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
public class ConvidadoFamilia {

    long id;
    String nomeDaFamilia;
    String acesso;
    String confirmacao;
    LocalDateTime dataCriacao;
    LocalDateTime dataModificacao;

    public ConvidadoFamilia() {
        
        String CaracteresAleatorios = Util.gerarStringAleatoria(4);
        this.confirmacao = "Não Confirmado";
        this.acesso = CaracteresAleatorios;
        this.dataCriacao = LocalDateTime.now();
        this.dataModificacao = LocalDateTime.now();
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
