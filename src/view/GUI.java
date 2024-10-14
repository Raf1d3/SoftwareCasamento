/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

import model.ConvidadoFamilia;
import model.ConvidadoIndividual;
import model.Evento;
import model.Fornecedor;
import model.Pessoas;
import model.Usuario;
import model.MuralDeRecados;
import model.Pagamentos;
import model.Presentes;

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
        Object[] options = {"Fazer login", "Entrar sem login"};

        int resposta = mostrarMensagemBots("Oque deseja fazer hoje?", "Bem vindo", 3, options);
        
        return resposta;

    }

    //Menu Administrados pós login
    public int menuAcessoAdministradorOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("<html><body><br>");
        menu.append("<div width='1200px' align='center'>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br></div></body></html>");
        
        Object[] options = {"Modificar Pessoas", "Modificar Usuarios", "Modificar Fornecedores",
            "Modificar Convidados", "Modificar Evento", "Modificar Mural de recados",
            "Modificar Pagamentos", "Modificar Presentes", "Voltar"};

        //int resposta = mostrarMensagemBotsPadrao(menu.toString(), "Menu administrador", 1, options);
        int resposta = mostrarMensagemBots(menu.toString(), "Menu administrador", -1, options);
        if (resposta != options.length - 1) {
            return resposta;
        } else {
            return 9;
        }

    }

    //Menu Convidado Sem login
    public int menuLoginConvidadoOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("<html><body><br>");
        menu.append("<div width='400px' align='center'>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br></div></body></html>");

        Object[] options = {"Modificar Mural de recados", "Dar Presente", "Voltar"};

        int resposta = mostrarMensagemBots(menu.toString(), "Menu Convidado", -1, options);
        if (resposta != options.length - 1) {
            return resposta;
        } else {
            return 9;
        }

    }

    //Menu logado Confirmação de presença familia
    public int menuConfirmacaoConvidadoResponsavelOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("<html><body'><br>");
        menu.append("<div width='300px' align='center'>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br></div></body></html>");

        Object[] options = {"Confirmar presença da familia", "Voltar"};

        int resposta = mostrarMensagemBots(menu.toString(), "Menu Confirmação de Presença", -1, options);
        if (resposta != options.length - 1) {
            return resposta;
        } else {
            return 9;
        }
    }

    public int menuPessoaOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("<html><body><br>");
        menu.append("<div width='730px' align='center'>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br></div></body></html>");

        Object[] options = {"Criar pessoa", "Mostrar pessoas", "Alterar dados da pessoa",
            "Deletar pessoa", "Buscar pessoa (id)", "Voltar"};

        int resposta = mostrarMensagemBots(menu.toString(), "Menu pessoas", -1, options);
        if (resposta != options.length - 1) {
            return resposta;
        } else {
            return 9;
        }

    }

    // menu usuarios
    public int menuUsuarioOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("<html><body><br>");
        menu.append("<div width='730px' align='center'>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br><div></body></html>");

        Object[] options = {"Criar usuario", "Mostrar usuarios", "Alterar dados do usuario",
            "Deletar usuario", "Buscar usuario (id)", "Voltar"};

        int resposta = mostrarMensagemBots(menu.toString(), "Menu usuarios", -1, options);
        if (resposta != options.length - 1) {
            return resposta;
        } else {
            return 9;
        }
    }
    
    // menu usuarios escolha Criar nova pessoa ou escolher um existente
    public int menuUsuariosInserirEscolhaOpcoes(){
        StringBuilder menu = new StringBuilder("");

        menu.append("<html><body><br>");
        menu.append("<div width='730px' align='center'>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br><div></body></html>");

        Object[] options = {"Criar nova pessoa", "Escolher uma pessoa", "Voltar"};

        int resposta = mostrarMensagemBots(menu.toString(), "Menu usuarios escolha", -1, options);
        if (resposta != options.length - 1) {
            return resposta;
        } else {
            return 9;
        }
    }
    
    

    // menu Fornecedor
    public int menuFornecedorOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("<html><body><br>");
        menu.append("<div width='920px' align='center'>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br><div></body></html>");

        Object[] options = {"Criar fornecedor", "Mostrar fornecedores", "Deletar fornecedor",
            "Buscar fornecedor (id)", "Alterar dados de um fornecedor", "Voltar"};
        
        int resposta = mostrarMensagemBots(menu.toString(), "Menu fornecedor", -1, options);
        if (resposta != options.length - 1) {
            return resposta;
        } else {
            return 9;
        }
    }

    // menu Convidados
    public int menuEscolhaTipoConvidadoOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("<html><body><br>");
        menu.append("<div width='430px' align='center'>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br></div></body></html>");

        Object[] options = {"Modificar convidados", "Modificar responsavel familia", "Voltar"};

        int resposta = mostrarMensagemBots(menu.toString(), "Menu Tipo convidado", -1, options);

        if (resposta != options.length - 1) {
            return resposta;
        } else {
            return 9;
        }
    }

    // menu Convidados Responsaveis admin
    public int menuConvidadoResponsavelOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("<html><body><br>");
        menu.append("<div width='1140px' align='center'>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br></div></body></html>");

        Object[] options = {"adicionar convidado responsavel", "Mostrar convidados responsaveis", "Deletar convidado responsavel",
            "Buscar convidado responsavel (id)", "Alterar dados do convidado responsavel", "Voltar"};

        int resposta = mostrarMensagemBots(menu.toString(), "Menu convidado responsaveis familia", -1, options);

        if (resposta != options.length - 1) {
            return resposta;
        } else {
            return 9;
        }
    }

    // menu Convidados admin
    public int menuConvidadoOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("<html><body><br>");
        menu.append("<div width='810px' align='center'>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br></div></body></html>");

        Object[] options = {"Criar convidado", "Mostrar convidados", "Deletar convidado",
            "Buscar convidado (id)", "Alterar dados do convidado", "Voltar"};

        int resposta = mostrarMensagemBots(menu.toString(), "Menu convidado", -1, options);

        if (resposta != options.length - 1) {
            return resposta;
        } else {
            return 9;
        }
    }

    // menu Locais
    public int menuEventoOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("<html><body><br>");
        menu.append("<div width='550px' align='center'>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br></div></body></html>");

        Object[] options = {"Criar Evento", "Mostrar Evento", "Deletar Evento",
            "Buscar Evento", "Alterar Evento", "Voltar"};

        int resposta = mostrarMensagemBots(menu.toString(), "Menu evento", -1, options);

        if (resposta != options.length - 1) {
            return resposta;
        } else {
            return 9;
        }
    }

    // menu mural de recados
    public int menuMuralDeRecadosOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("<html><body><br>");
        menu.append("<div width='690px' align='center'>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br></div></body></html>");

        Object[] options = {"Adicionar no mural", "Mostrar mural", "Deletar do mural",
            "Buscar comentario (id)", "Alterar comentario", "Voltar"};

        int resposta = mostrarMensagemBots(menu.toString(), "Menu Mural de recados", -1, options);

        if (resposta != options.length - 1) {
            return resposta;
        } else {
            return 9;
        }
    }

    // menu pagamentos
    public int menuPagamentoOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("<html><body><br>");
        menu.append("<div width='690px' align='center'>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br></div></body></html>");

        Object[] options = {"Adicionar pagamento", "Mostrar pagamentos", "Deletar pagamento",
            "Buscar pagamento (id)", "Alterar pagamento", "Voltar"};

        int resposta = mostrarMensagemBots(menu.toString(), "Menu pagamentos", -1, options);

        if (resposta != options.length - 1) {
            return resposta;
        } else {
            return 9;
        }
    }

    // menu presentes
    public int menuPresenteOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("<html><body><br>");
        menu.append("<div width='520px' align='center'>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br></div></body></html>");

        Object[] options = {"Adicionar presente", "Mostrar presentes", "Buscar presente (id)",
            "Alterar presente", "Deletar presente", "Voltar"};

        int resposta = mostrarMensagemBots(menu.toString(), "Menu presentes", -1, options);

        if (resposta != options.length - 1) {
            return resposta;
        } else {
            return 9;
        }
    }

    public Pessoas CriarPessoa() {
        String nome = mostrarMensagemInput("Nome:", "Nome", 3, "douglas");
        LocalDate nascimento = FormatarData(mostrarMensagemInput("Digite uma data de nascimento", "Nascimento", 3, "01/01/2001"));
        String telefone = mostrarMensagemInput("Digite um telefone", "Telefone", 3, "40028922");

        Pessoas p = new Pessoas();

        p.setNome(nome);
        p.setNascimento(nascimento);
        p.setTelefone(telefone);

        return p;
    }

    public Usuario CriarUsuario(Pessoas p) {
        String login = mostrarMensagemInput("login:", "Login", 3, "rodrigo");
        String senha = mostrarMensagemInput("senha:", "Senha", 3, "123");
        String tipo = mostrarMensagemInput("Tipo (noivo/noiva, administrador)", "Tipo", 3, "administrador");
        Usuario u = new Usuario();
        u.setLogin(login);
        u.setPessoa(p);
        u.setSenha(senha);
        u.setTipo(tipo);
        return u;
    }

    public Fornecedor CriarFornecedor() {
        Fornecedor f = new Fornecedor();
        return f;
    }

    public ConvidadoFamilia CriarConvidadoFamilia() {
        String confirmacao = mostrarMensagemInput("confirmacao:", "Confirmacao", 3, "");
        String nomefamilia = mostrarMensagemInput("nome da familia", "Nome da Familia", 3, "40028922");

        ConvidadoFamilia cf = new ConvidadoFamilia();
        cf.setConfirmacao(confirmacao);
        cf.setNomeDaFamilia(nomefamilia);
        return cf;
    }

    public ConvidadoIndividual CriarConvidadoIndividual() {
        ConvidadoIndividual ci = new ConvidadoIndividual();

        return ci;
    }

    public Evento CriarEvento() {
        Evento e = new Evento();

        return e;
    }

    public MuralDeRecados CriarRecado() {
        MuralDeRecados mr = new MuralDeRecados();

        return mr;
    }

    public Pagamentos CriarPagamento() {
        Pagamentos pg = new Pagamentos();

        return pg;
    }

    public Presentes CriarPresente() {
        Presentes ps = new Presentes();

        return ps;
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
