/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import control.GenericDAO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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

    GenericDAO<Evento> EventoDao = new GenericDAO<>();

    public GUI() {

    }

    // --------- INTERFACE GRAFICA DOS MENUS ----------
    //Menu inicial de boas vindas
    public int MenuLoginOpcoes() {
        StringBuilder menu = new StringBuilder("");
        menu.append("<html><body><br>");
        menu.append("<div width='300px' align='center'>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>Bem Vindo</p>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>Entre Tapas e beijos</p>");
        if (!EventoDao.mostrar(null).equals("")) {
            menu.append("<p style='font-size:12px;'>Casamendo de ");
            //menu.append(EventoDao.GetDataBase().get(0).getNoivo);
            menu.append(" e ");
            //menu.append(EventoDao.GetDataBase().get(0).getNoiva);
            menu.append("</p><br>");
            menu.append("<p style='font-size:12px;'>Data: ");
            //menu.append(EventoDao.GetDataBase().get(0).getData);
            menu.append("</p><br>");
            menu.append("<p style='font-size:12px;'>Cartorio: ");
            //menu.append(EventoDao.GetDataBase().get(0).getCartorio);
            menu.append("</p><br>");
            menu.append("<p style='font-size:12px;'>Igreja: ");
            //menu.append(EventoDao.GetDataBase().get(0).getIgreja);
            menu.append("</p><br>");
        }else{
            menu.append("<p style='font-size:12px;'><br>Evento em organização...");
            menu.append("</p><br>");
        }
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br></div></body></html>");

        Object[] options = {"Fazer login", "Entrar sem login"};

        int resposta = mostrarMensagemBots(menu.toString(), "Bem vindo", -1, options);

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
            "Gerenciar Convidados", "Modificar Evento", "Modificar Mural de recados",
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
        menu.append("<div width='410px' align='center'>");
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
    public int menuConfirmacaoFamiliaOpcoes() {
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
    public int menuUsuariosInserirEscolhaOpcoes() {
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

        Object[] options = {"Criar fornecedor", "Mostrar fornecedores", "Alterar dados de um fornecedor",
            "Deletar fornecedor", "Buscar fornecedor (id)", "Voltar"};

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
        menu.append("<div width='320px' align='center'>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br></div></body></html>");

        Object[] options = {"Modificar convidados", "Modificar família", "Voltar"};

        int resposta = mostrarMensagemBots(menu.toString(), "Menu convidado", -1, options);

        if (resposta != options.length - 1) {
            return resposta;
        } else {
            return 9;
        }
    }

    // menu Convidados Responsaveis admin
    public int menuFamiliaOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("<html><body><br>");
        menu.append("<div width='1100px' align='center'>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br></div></body></html>");

        Object[] options = {"Adicionar família", "Mostrar famílias", "Alterar dados da família",
            "Deletar família", "Buscar família (id)", "Confirmar presença das famílias",
            "Voltar"};

        int resposta = mostrarMensagemBots(menu.toString(), "Menu Família", -1, options);

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
        menu.append("<div width='930px' align='center'>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br></div></body></html>");

        Object[] options = {"Criar convidado", "Mostrar convidados", "Alterar dados do convidado",
            "Deletar convidado", "Buscar convidado (id)", "Confirmar presença",
            "Voltar"};

        int resposta = mostrarMensagemBots(menu.toString(), "Menu convidado", -1, options);

        if (resposta != options.length - 1) {
            return resposta;
        } else {
            return 9;
        }
    }
    
        // menu usuarios escolha Criar nova pessoa ou escolher um existente
    public int menuConvidadoInserirEscolhaOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("<html><body><br>");
        menu.append("<div width='730px' align='center'>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br><div></body></html>");

        Object[] options = {"Criar nova pessoa", "Escolher uma pessoa", "Voltar"};

        int resposta = mostrarMensagemBots(menu.toString(), "Menu convidado escolha", -1, options);
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
        menu.append("<div width='480px' align='center'>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br></div></body></html>");

        Object[] options = {"Criar Evento", "Mostrar Evento", "Alterar Evento", 
           "Deletar Evento", "Buscar Evento",  "Voltar"};

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

        Object[] options = {"Adicionar no mural", "Mostrar mural", "Alterar comentario",
            "Deletar do mural", "Buscar comentario (id)",  "Voltar"};

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
        menu.append("<div width='680px' align='center'>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br></div></body></html>");

        Object[] options = {"Adicionar pagamento", "Mostrar pagamentos", "Alterar pagamento",
            "Deletar pagamento", "Buscar pagamento (id)", "Voltar"};

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
        menu.append("<div width='610px' align='center'>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br></div></body></html>");

        Object[] options = {"Adicionar presente", "Mostrar presentes", "Alterar presente", 
             "Deletar presente", "Buscar presente (id)", "Voltar"};

        int resposta = mostrarMensagemBots(menu.toString(), "Menu presentes", -1, options);

        if (resposta != options.length - 1) {
            return resposta;
        } else {
            return 9;
        }
    }

    public Pessoas CriarPessoa() {
        String nome = mostrarMensagemInput("Nome:", "Nome", 3, "douglas");

        LocalDate nascimento = null;
        while (nascimento == null) {
            String input_nascimento = mostrarMensagemInput("Digite uma data de nascimento", "Nascimento", 3, "01/01/2001");
            if (input_nascimento != null) {
                nascimento = validarData(input_nascimento);
                if (nascimento == null) {
                    mostrarMensagemAviso("Data inválida. Tente novamente no formato dia/mes/ano.", "Aviso", 2);
                }
            } else {
                break;
            }
        }
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
        String nomefamilia = mostrarMensagemInput("Nome da família", "Nome da Família", 3, "Almeida");

        ConvidadoFamilia cf = new ConvidadoFamilia();

        cf.setNomeDaFamilia(nomefamilia);
        return cf;
    }

    public ConvidadoIndividual CriarConvidadoIndividual(Pessoas p) {
        String Parentesco = mostrarMensagemInput("Parentesco:", "Parentesco", 3, "");
        String familia = mostrarMensagemInput("Nome da família", "Nome da Família", 3, "Almeida");

        ConvidadoIndividual ci = new ConvidadoIndividual();
        ci.setPessoa(p);
        ci.setParentesco(Parentesco);
        ci.setFamilia(familia);
        
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

    private LocalDate validarData(String inputData) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            return LocalDate.parse(inputData, formato);
        } catch (DateTimeParseException e) {
            return null;
        }
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
