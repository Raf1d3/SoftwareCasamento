/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;
import control.Util;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CAUPT - ALUNOS
 */
public class ConvidadoFamilia implements InterfaceGenericDAO{

    long id;
    String nomeDaFamilia;
    String acesso;
    String confirmacao;
    LocalDateTime dataCriacao;
    LocalDateTime dataModificacao;
    
    
    @Override
    public List<Object> getValoresAtributos() {
        List<Object> valores = new ArrayList();
        valores.add(this.nomeDaFamilia);
        valores.add(this.acesso);
        valores.add(this.confirmacao);
        valores.add(this.dataCriacao);
        valores.add(this.dataModificacao);
        return valores;
    }
    
    
    public ConvidadoFamilia(Long id, String nomeDaFamilia, String acesso, String confirmacao, LocalDateTime dataCriacao, LocalDateTime dataModificacao) {
        this.id = id;
        this.nomeDaFamilia = nomeDaFamilia;
        this.acesso = acesso;
        this.confirmacao = confirmacao;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
    }
    
    
    public ConvidadoFamilia(String nomeDaFamilia) {
        this.nomeDaFamilia = nomeDaFamilia;
        this.confirmacao = "Não Confirmado";
        this.acesso = Util.gerarStringAleatoria(4);
        this.dataCriacao = LocalDateTime.now();
        this.dataModificacao = LocalDateTime.now();
    }

    
    @Override
    public String toString() {

        return "ID: " + id 
                + " | Nome da família: " + nomeDaFamilia 
                + " | Acesso: " + acesso
                + " | Confirmacão: " + confirmacao 
                + " | Data de Criação: " + Util.formatarData(dataCriacao)
                + " | Última Modificação: " + Util.formatarData(dataModificacao) + "\n\n";
    }

    public long getId() {
        return id;
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
