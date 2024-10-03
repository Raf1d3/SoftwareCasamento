/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author CAUPT - ALUNOS
 */
public class Fornecedor {
    long id;
    String nome;
    String cnpj;
    String telefone;
    int valorAPagar;
    int parcelas;
    String estado;
    LocalDate dataCriacao;
    LocalDate dataModificacao;
}
