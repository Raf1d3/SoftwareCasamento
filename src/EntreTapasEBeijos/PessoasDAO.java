/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntreTapasEBeijos;

/**
 *
 * @author pse
 */
public class PessoasDAO {

    private Pessoas[] pessoas = new Pessoas[100];

    public PessoasDAO() {
        // adicionar pessoas por padrão <-
    }

    public int inserir(Pessoas p) {
        int posicaoLivre = proximaPosicaoLivre();
        if (posicaoLivre == -1) {
            return -1;
        }
        pessoas[posicaoLivre] = p;
        return (int) p.getId();
    }

    public String mostrar(Pessoas pessoaEspecifica) {
        String mensagem = "";
        if(pessoaEspecifica != null){
            mensagem = pessoaEspecifica.toString();
            return mensagem;
        }
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null) {
                mensagem += pessoas[i];
            }
        }
        return mensagem;
    }

    public boolean alterar(Pessoas pNova, Pessoas pAntiga) {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null && pessoas[i].getId() == pAntiga.getId()) {
                if(pNova.getNascimento() != null){
                    pessoas[i].setNascimento(pNova.getNascimento());
                }
                if(pNova.getNome() != null){
                    pessoas[i].setNome(pNova.getNome());
                }
                if(pNova.getTelefone() != null){
                    pessoas[i].setTelefone(pNova.getTelefone());
                }
                //alterar pNova.getDataModificacao()
            }
        }
        return false;
    }

    public boolean deletar(Pessoas p) {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null && pessoas[i].getId() == p.getId()) {
                pessoas[i] = null;
                return true;
            }
        }
        return false;
    }

    public Pessoas buscar(long id) {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null && pessoas[i].getId() == id) {
                return pessoas[i];
            }
        }
        return null;
    }

    public int proximaPosicaoLivre() {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] == null) {
                return i;
            }
        }
        return -1;
    }

}
