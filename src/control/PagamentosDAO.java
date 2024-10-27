/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import model.Pagamentos;

/**
 *
 * @author Emanuelle
 */
public class PagamentosDAO extends GenericDAO<Pagamentos> {
  public class PagamentosDao {
    private static Pagamentos[] arrayPagamentos;

    // Método para verificar se o fornecedor já possui um pagamento associado
    public static boolean existePagamentoParaFornecedor(long idFornecedor) {
        for (Pagamentos pagamento : arrayPagamentos) {
            if (pagamento != null && pagamento.getFornecedor() != null && pagamento.getFornecedor().getId() == idFornecedor) {
                return true;
            }
        }
        return false;
    }

    // Método para inserir novo pagamento, com verificação
    public static int inserir(Pagamentos novoPagamento) {
        if (!existePagamentoParaFornecedor(novoPagamento.getFornecedor().getId())) {
            // Lógica para inserir o pagamento em arrayPagamentos
            return 1; // Sucesso (valor de retorno exemplo)
        } else {
            System.out.println("Este fornecedor já possui um pagamento associado.");
            return -1; // Falha ao inserir
        }
    }
}

}
