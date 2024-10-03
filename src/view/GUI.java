/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import model.Pessoas;
import model.Usuario;

/**
 *
 * @author CAUPT - ALUNOS
 */
public class GUI {

    public GUI() {

    }

    // --------- INTERFACE GRAFICA DOS MENUS ----------
    //Menu inicial de boas vindas
    public int MenuLoginOpcoes() {
        Object[] options = {"Fazer login", "Entrar sem login", "Sair do programa"};

        int resposta = mostrarMensagemBots("Oque deseja fazer hoje?", "Bem vindo", 3, options);
        if (resposta != -1 && resposta != options.length - 1) {
            return resposta;
        } else {
            return 9;
        }
    }

    //Menu Administrados pós login
    public int menuAcessoAdministradorOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("<html><body style='text-align:center; margin-left:450px;'><br>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br></body></html>");
        Object[] options = {"Modificar Pessoas", "Modificar Usuarios", "Modificar Fornecedores",
            "Modificar Convidados", "Modificar Evento", "Modificar Mural de recados",
            "Modificar Pagamentos", "Modificar Presentes", "Sair do programa"};

        //int resposta = mostrarMensagemBotsPadrao(menu.toString(), "Menu administrador", 1, options);
        int resposta = mostrarMensagemBots(menu.toString(), "Menu administrador", -1, options);
        if (resposta != -1 && resposta != options.length - 1) {
            return resposta;
        } else {
            return 9;
        }

    }

    //Menu Convidado Sem login
    public int menuConvidadoOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("<html><body style='text-align:center; margin-left:135px;'><br>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br></body></html>");

        Object[] options = {"Confirmar Pesença (acesso)", "Modificar Mural de recados", "Dar Presente",
            "Sair do programa"};

        int resposta = mostrarMensagemBots(menu.toString(), "Menu Convidado", -1, options);
        if (resposta != -1 && resposta != options.length - 1) {
            return resposta;
        } else {
            return 9;
        }

    }

    public int menuPessoasOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("<html><body style='text-align:center; margin-left:220px;'><br>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br></body></html>");

        Object[] options = {"Criar pessoa", "Mostrar pessoas", "Alterar dados da pessoa",
            "Deletar pessoa", "Buscar pessoa (id)", "Sair do programa"};

        int resposta = mostrarMensagemBots(menu.toString(), "Menu pessoas", -1, options);
        if (resposta != -1 && resposta != options.length - 1) {
            return resposta;
        } else {
            return 9;
        }

    }

    // menu usuarios
    public int menuUsuariosOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("<html><body style='text-align:center; margin-left:220px;'><br>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br></body></html>");

        Object[] options = {"Criar usuario", "Mostrar usuarios", "Alterar dados do usuario",
            "Deletar usuario", "Buscar usuario (id)", "Sair do programa"};

        int resposta = mostrarMensagemBots(menu.toString(), "Menu usuarios", -1, options);
        if (resposta != -1 && resposta != options.length - 1) {
            return resposta;
        } else {
            return 9;
        }
    }

    // menu Fornecedores
    public int menuFornecedoresOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("<html><body style='text-align:center; margin-left:320px;'><br>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br></body></html>");

        Object[] options = {"Criar fornecedor", "Mostrar fornecedores", "Deletar fornecedor",
            "Buscar fornecedor (id)", "Alterar dados de um fornecedor", "Sair do programa"};
        int resposta = mostrarMensagemBots(menu.toString(), "Menu fornecedor", -1, options);
        if (resposta != -1 && resposta != options.length - 1) {
            return resposta;
        } else {
            return 9;
        }
    }

    // menu Convidados
    public int menuConvidadosOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("<html><body style='text-align:center; margin-left:260px;'><br>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br></body></html>");

        Object[] options = {"Criar convidado", "Mostrar convidados", "Deletar convidado",
            "Buscar convidado (id)", "Alterar dados do convidado", "Sair do programa"};

        int resposta = mostrarMensagemBots(menu.toString(), "Menu convidado", -1, options);

        if (resposta != -1 && resposta != options.length - 1) {
            return resposta;
        } else {
            return 9;
        }
    }

    // menu Locais
    public int menuEventoOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("<html><body style='text-align:center; margin-left:115px;'><br>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br></body></html>");

        Object[] options = {"Modificar Cartorio", "Modificar Cerimonial", "Modificar Evento",
            "Modificar Igreja", "Sair do programa"};

        int resposta = mostrarMensagemBots(menu.toString(), "Menu evento", -1, options);

        if (resposta != -1 && resposta != options.length - 1) {
            return resposta;
        } else {
            return 9;
        }
    }

    // menu mural de recados
    public int menuMuralDeRecadosOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("<html><body style='text-align:center; margin-left:200px;'><br>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br></body></html>");

        Object[] options = {"Adicionar no mural", "Mostrar mural", "Deletar do mural",
            "Buscar comentario (id)", "Alterar comentario", "Sair do programa"};

        int resposta = mostrarMensagemBots(menu.toString(), "Menu Mural de recados", -1, options);

        if (resposta != -1 && resposta != options.length - 1) {
            return resposta;
        } else {
            return 9;
        }
    }

    // menu pagamentos
    public int menuPagamentosOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("<html><body style='text-align:center; margin-left:200px;'><br>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br></body></html>");

        Object[] options = {"Adicionar pagamento", "Mostrar pagamentos", "Deletar pagamento",
            "Buscar pagamento (id)", "Alterar pagamento", "Sair do programa"};

        int resposta = mostrarMensagemBots(menu.toString(), "Menu pagamentos", -1, options);

        if (resposta != -1 && resposta != options.length - 1) {
            return resposta;
        } else {
            return 9;
        }
    }

    // menu presentes
    public int menuPresentesOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("<html><body style='text-align:center; margin-left:115px;'><br>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br></body></html>");

        Object[] options = {"Adicionar presente", "Mostrar presentes", "Buscar presente (id)",
            "Alterar presente", "Sair do programa"};

        int resposta = mostrarMensagemBots(menu.toString(), "Menu presentes", -1, options);

        if (resposta != -1 && resposta != options.length - 1) {
            return resposta;
        } else {
            return 9;
        }
    }

    public Pessoas CriarPessoa() {
        String nome = mostrarMensagemInput("Digite um nome", "Nome", 3, "douglas");
        LocalDate nascimento = FormatarData(mostrarMensagemInput("Digite uma data de nascimento", "Nascimento", 3, "01/01/2001"));
        String telefone = mostrarMensagemInput("Digite um telefone", "Telefone", 3, "40028922");

        Pessoas p = new Pessoas();
        p.setNome(nome);
        p.setNascimento(nascimento);
        p.setTelefone(telefone);
        return p;
    }

    public Usuario CriarUsuario() {
        Usuario u = new Usuario();

        return u;
    }

    public LocalDate FormatarData(String dataNascimento) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dataNascimento, formato);
    }

    // --------- POP UPS JOPTIONPANE ----------
    //Mostrar pop up com mensagem e botão ok
    public void mostrarMensagemAviso(String mensagem, String titulo, int icone) {
        JOptionPane.showMessageDialog(null, mensagem, titulo, icone);
    }

    //Mostrar pop up com mensagem, input e botão ok e cancelar 
    public String mostrarMensagemInput(String mensagem, String titulo, int icone, String mensagemPadrao) {

        String resposta = (String) JOptionPane.showInputDialog(null, mensagem, titulo, icone, null, null, mensagemPadrao);
        return resposta;
    }

    //Mostrar pop up com mensagem e quantidade configuravel botões
    public int mostrarMensagemBots(String mensagem, String titulo, int icone, Object[] options) {
        return JOptionPane.showOptionDialog(null, mensagem, titulo, JOptionPane.DEFAULT_OPTION, icone, null, options, options[0]);
    }

}
