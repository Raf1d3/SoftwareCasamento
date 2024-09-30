/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntreTapasEBeijos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author CAUPT - ALUNOS
 */
public class GUI {
    

    public GUI() {

    }

    public int MenuLoginOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("GERENCIADOR DE CASAMENTOS\n");
        menu.append("       ENTRE TAPAS E BEIJOS\n\n");
        menu.append("       Oque deseja fazer hoje?\n");
        menu.append("\n0 - Fazer login");
        menu.append("\n1 - Entrar sem login");
        menu.append("\n9 - Sair do programa\n");
        menu.append("\nOpção: ");

        String resposta = JOptionPane.showInputDialog(null, menu.toString(), "Bem vindo", JOptionPane.INFORMATION_MESSAGE);
        if (resposta != null) {
            return Integer.parseInt(resposta);
        } else {
            return 9;
        }
    }
    

    public int menuAcessoAdministradorOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("GERENCIADOR DE CASAMENTOS\n");
        menu.append("       ENTRE TAPAS E BEIJOS\n\n");
        menu.append("       Oque deseja fazer hoje?\n");
        menu.append("\n0 - Modificar Pessoas");
        menu.append("\n1 - Modificar Usuarios");
        menu.append("\n2 - Modificar Fornecedores");
        menu.append("\n3 - Modificar Convidados");
        menu.append("\n4 - Modificar Evento");
        menu.append("\n5 - Modificar Mural de recados");
        menu.append("\n6 - Modificar Pagamentos");
        menu.append("\n7 - Modificar Presentes");
        menu.append("\n9 - Sair do programa\n");
        menu.append("\nOpção: ");

        String resposta = JOptionPane.showInputDialog(null, menu.toString(), "Menu administrador", JOptionPane.INFORMATION_MESSAGE);
        if (resposta != null) {
            return Integer.parseInt(resposta);
        } else {
            return 9;
        }

    }

    //Mostrar mensagem pop up com botão ok
    public void mostrarMensagemAviso(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Resposta", JOptionPane.INFORMATION_MESSAGE);
    }
    
    //Mostrar mensagem pop up com input botão ok e cancelar 
    public String mostrarMensagemInput(String mensagem, String titulo, int icone) {
        
        String resposta = JOptionPane.showInputDialog(null, mensagem, titulo, icone);
        return resposta;
    }

    public int menuPessoasOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("GERENCIADOR DE CASAMENTOS\n");
        menu.append("       ENTRE TAPAS E BEIJOS\n\n");
        menu.append("       Oque deseja fazer hoje?\n");
        menu.append("\n0 - Criar pessoa");
        menu.append("\n1 - Mostrar pessoas");
        menu.append("\n2 - Alterar dados da pessoa");
        menu.append("\n3 - Deletar pessoa");
        menu.append("\n4 - Buscar pessoa (id)");
        menu.append("\n9 - Sair do programa\n");
        menu.append("\nOpção: ");

        String resposta = JOptionPane.showInputDialog(null, menu.toString(), "Menu pessoas", JOptionPane.INFORMATION_MESSAGE);
        if (resposta != null) {
            return Integer.parseInt(resposta);
        } else {
            return 9;
        }

    }

    // menu usuarios
    public int menuUsuariosOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("GERENCIADOR DE CASAMENTOS\n");
        menu.append("       ENTRE TAPAS E BEIJOS\n\n");
        menu.append("       Oque deseja fazer hoje?\n");
        menu.append("\n0 - Criar usuario");
        menu.append("\n1 - Mostrar usuario");
        menu.append("\n2 - Deletar usuario");
        menu.append("\n3 - Buscar usuario (id)");
        menu.append("\n4 - Alterar dados do usuario");
        menu.append("\n9 - Sair do programa\n");
        menu.append("\nOpção: ");

        String resposta = JOptionPane.showInputDialog(null, menu.toString(), "Menu usuarios", JOptionPane.INFORMATION_MESSAGE);
        if (resposta != null) {
            return Integer.parseInt(resposta);
        } else {
            return 9;
        }
    }

    // menu Fornecedores
    public int menuFornecedoresOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("GERENCIADOR DE CASAMENTOS\n");
        menu.append("       ENTRE TAPAS E BEIJOS\n\n");
        menu.append("       Oque deseja fazer hoje?\n");
        menu.append("\n0 - Criar fornecedor");
        menu.append("\n1 - Mostrar fornecedores");
        menu.append("\n2 - Deletar fornecedor");
        menu.append("\n3 - Buscar fornecedor (id)");
        menu.append("\n4 - Alterar dados de um fornecedor");
        menu.append("\n9 - Sair do programa\n");
        menu.append("\nOpção: ");

        String resposta = JOptionPane.showInputDialog(null, menu.toString(), "Menu fornecedor", JOptionPane.INFORMATION_MESSAGE);
        if (resposta != null) {
            return Integer.parseInt(resposta);
        } else {
            return 9;
        }
    }

    // menu Convidados
    public int menuConvidadosOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("GERENCIADOR DE CASAMENTOS\n");
        menu.append("       ENTRE TAPAS E BEIJOS\n\n");
        menu.append("       Oque deseja fazer hoje?\n");
        menu.append("\n0 - Criar convidado");
        menu.append("\n1 - Mostrar convidados");
        menu.append("\n2 - Deletar convidado");
        menu.append("\n3 - Buscar convidado (id)");
        menu.append("\n4 - Alterar dados do convidado");
        menu.append("\n9 - Sair do programa\n");
        menu.append("\nOpção: ");

        String resposta = JOptionPane.showInputDialog(null, menu.toString(), "Menu convidado", JOptionPane.INFORMATION_MESSAGE);
        if (resposta != null) {
            return Integer.parseInt(resposta);
        } else {
            return 9;
        }
    }

    // menu Locais
    public int menuEventoOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("GERENCIADOR DE CASAMENTOS\n");
        menu.append("       ENTRE TAPAS E BEIJOS\n\n");
        menu.append("       Oque deseja fazer hoje?\n");
        menu.append("\n0 - Modificar Cartorio");
        menu.append("\n1 - Modificar Cerimonial");
        menu.append("\n2 - Modificar Evento");
        menu.append("\n3 - Modificar Igreja");
        menu.append("\n9 - Sair do programa\n");
        menu.append("\nOpção: ");

        String resposta = JOptionPane.showInputDialog(null, menu.toString(), "Menu evento", JOptionPane.INFORMATION_MESSAGE);
        if (resposta != null) {
            return Integer.parseInt(resposta);
        } else {
            return 9;
        }
    }

    // menu mural de recados
    public int menuMuralDeRecadosOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("GERENCIADOR DE CASAMENTOS\n");
        menu.append("       ENTRE TAPAS E BEIJOS\n\n");
        menu.append("       Oque deseja fazer hoje?\n");
        menu.append("\n0 - Adicionar no mural");
        menu.append("\n1 - Mostrar mural");
        menu.append("\n2 - Deletar do mural");
        menu.append("\n3 - Buscar comentario (id)");
        menu.append("\n4 - Alterar comentario");
        menu.append("\n9 - Sair do programa\n");
        menu.append("\nOpção: ");

        String resposta = JOptionPane.showInputDialog(null, menu.toString(), "Menu Mural de recados", JOptionPane.INFORMATION_MESSAGE);
        if (resposta != null) {
            return Integer.parseInt(resposta);
        } else {
            return 9;
        }
    }

    // menu pagamentos
    public int menuPagamentosOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("GERENCIADOR DE CASAMENTOS\n");
        menu.append("       ENTRE TAPAS E BEIJOS\n\n");
        menu.append("       Oque deseja fazer hoje?\n");
        menu.append("\n0 - Adicionar pagamento");
        menu.append("\n1 - Mostrar pagamentos");
        menu.append("\n2 - Deletar pagamento");
        menu.append("\n3 - Buscar pagamento (id)");
        menu.append("\n4 - Alterar pagamento");
        menu.append("\n9 - Sair do programa\n");
        menu.append("\nOpção: ");

        String resposta = JOptionPane.showInputDialog(null, menu.toString(), "Menu pagamentos", JOptionPane.INFORMATION_MESSAGE);
        if (resposta != null) {
            return Integer.parseInt(resposta);
        } else {
            return 9;
        }
    }

    // menu presentes
    public int menuPresentesOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("GERENCIADOR DE CASAMENTOS\n");
        menu.append("       ENTRE TAPAS E BEIJOS\n\n");
        menu.append("       Oque deseja fazer hoje?\n");
        menu.append("\n0 - Adicionar presente");
        menu.append("\n1 - Mostrar presentes");
        menu.append("\n2 - Buscar presente (id)");
        menu.append("\n3 - Alterar presente");
        menu.append("\n9 - Sair do programa\n");
        menu.append("\nOpção: ");

        String resposta = JOptionPane.showInputDialog(null, menu.toString(), "Menu pagamentos", JOptionPane.INFORMATION_MESSAGE);
        if (resposta != null) {
            return Integer.parseInt(resposta);
        } else {
            return 9;
        }
    }

    public Pessoas CriarPessoa() {
        String nome = JOptionPane.showInputDialog(null, "Digite um nome", "Nome", JOptionPane.INFORMATION_MESSAGE);
        LocalDate nascimento = FormatarData(JOptionPane.showInputDialog(null, "Digite uma data de nascimento", "Nascimento", JOptionPane.INFORMATION_MESSAGE));
        String telefone = JOptionPane.showInputDialog(null, "Digite um telefone", "Telefone", JOptionPane.INFORMATION_MESSAGE);

        Pessoas p = new Pessoas();
        p.setNome(nome);
        p.setNascimento(nascimento);
        p.setTelefone(telefone);
        return p;
    }
    
    

    public LocalDate FormatarData(String dataNascimento) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Formato de data esperado
        return LocalDate.parse(dataNascimento, formato); // Tenta converter a String para LocalDate
    }

}
