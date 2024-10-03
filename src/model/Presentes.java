/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author CAUPT - ALUNOS
 */
public class Presentes {
    long id;
    String nome;
    String tipo;
    BigDecimal valor;
    Pessoas pessoa;
    LocalDate dataCriacao;
    LocalDate dataModificacao;
}
