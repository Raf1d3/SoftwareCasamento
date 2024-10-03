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
public class Pagamentos {
    long id;
    Pessoas pessoa;
    String descricao;
    Fornecedor fornecedor;
    BigDecimal valor;
    int parcela;
    LocalDate dataCriacao;
    LocalDate dataModificacao;
}
