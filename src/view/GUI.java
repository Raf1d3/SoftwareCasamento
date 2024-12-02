/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import control.GenericDAO;
import control.Util;
import java.math.BigDecimal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.JOptionPane;
import model.Calendario;
import model.Cartorio;
import model.Cerimonial;

import model.ConvidadoFamilia;
import model.ConvidadoIndividual;
import model.Evento;
import model.Fornecedor;
import model.Igreja;
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
    public int MenuLoginOpcoes(List<Evento> arrayEvento) {
        StringBuilder menu = new StringBuilder("");
        menu.append("<html><body><br>");
        menu.append("<div width='300px' align='center'>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>Bem Vindo</p>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>Entre Tapas e beijos</p>");

        if (!arrayEvento.isEmpty()) {
            menu.append("<br><p style='font-size:12px;'>Casamendo de ");
            menu.append(arrayEvento.get(0).getNoivo().getNome());
            menu.append(" e ");
            menu.append(arrayEvento.get(0).getNoiva().getNome());
            menu.append("</p><br>");
            menu.append("<p style='font-size:12px;'>Data: ");
            menu.append(Util.formatarDataLocal(arrayEvento.get(0).getDataEvento()));
            menu.append("</p><br>");
            menu.append("<p style='font-size:12px;'>Cerimonial: ");
            menu.append(arrayEvento.get(0).getCerimonial().getNome());
            menu.append("</p><br>");
            menu.append("<p style='font-size:12px;'>Cartorio: ");
            menu.append(arrayEvento.get(0).getCartorio().getNome());
            menu.append("</p><br>");
            menu.append("<p style='font-size:12px;'>Igreja: ");
            menu.append(arrayEvento.get(0).getIgreja().getNome());
            menu.append("</p><br>");

        } else {
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
        menu.append("<div width='1000px' align='center'>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Oque deseja gerenciar hoje?</p><br></div></body></html>");

        Object[] options = {"Pessoas", "Usuarios", "Fornecedores",
            "Convidados", "Evento", "Mural de recados",
            "Pagamentos", "Presentes", "Relatorios",
            "Calendario", "Sair"};

        //int resposta = mostrarMensagemBotsPadrao(menu.toString(), "Menu administrador", 1, options);
        int resposta = mostrarMensagemBots(menu.toString(), "Menu administrador", -1, options);
        if (resposta != options.length - 1) {
            return resposta;
        } else {
            return 15;
        }

    }

    //Menu Convidado Sem login
    public int menuLoginConvidadoOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("<html><body><br>");
        menu.append("<div width='410px' align='center'>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br></div></body></html>");

        Object[] options = {"Acessar Mural de recados", "Acessar Meus Presentes", "Voltar"};

        int resposta = mostrarMensagemBots(menu.toString(), "Menu Convidado", -1, options);
        if (resposta != options.length - 1) {
            return resposta;
        } else {
            return 9;
        }

    }

    //Menu logado Confirmação de presença familia
    public int menuConfirmacaoFamiliaOpcoes(ConvidadoFamilia cf) {
        StringBuilder menu = new StringBuilder("");

        menu.append("<html><body'><br>");
        menu.append("<div width='300px' align='center'>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:14px;'>");
        menu.append("Bem vindo familia ");
        menu.append(cf.getNomeDaFamilia());
        menu.append(".</p>");
        menu.append("<p style='font-size:12px;'>");
        menu.append("confirmação da familia: ");
        menu.append(cf.getConfirmacao());
        menu.append(".</p><br>");
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br></div></body></html>");

        Object[] options = {"Confirmar presença da familia", "Voltar"};

        int resposta = mostrarMensagemBots(menu.toString(), "Menu Confirmação de Presença", -1, options);
        if (resposta != options.length - 1) {
            return resposta;
        } else {
            return 9;
        }
    }

    //Menu opções presentes convidado (sem login)
    public int menuPresentesConvidadoOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("<html><body><br>");
        menu.append("<div width='355px' align='center'>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br></div></body></html>");

        Object[] options = {"Presentear", "Ver presentes", "Calcelar presente", "Voltar"};

        int resposta = mostrarMensagemBots(menu.toString(), "Menu Presentes", -1, options);

        if (resposta != options.length - 1) {
            return resposta;
        } else {
            return 9;
        }
    }

    //Menu opções mural de recados convidado (sem login)
    public int menuMuralDeRecadosConvidadoOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("<html><body><br>");
        menu.append("<div width='790px' align='center'>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br></div></body></html>");

        Object[] options = {"Adicionar no mural", "Mostrar mural", "Alterar meus comentarios",
            "Deletar meus comentarios", "Buscar comentario (id)", "Voltar"};

        int resposta = mostrarMensagemBots(menu.toString(), "Menu Mural de recados", -1, options);

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
        menu.append("<div width='330px' align='center'>");
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

    // menu Convidado escolha Criar nova pessoa ou escolher um existente
    public int menuFornecedorInserirEscolhaOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("<html><body><br>");
        menu.append("<div width='330px' align='center'>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br><div></body></html>");

        Object[] options = {"Criar nova pessoa", "Escolher uma pessoa", "Voltar"};

        int resposta = mostrarMensagemBots(menu.toString(), "Menu fornecedor escolha", -1, options);
        if (resposta != options.length - 1) {
            return resposta;
        } else {
            return 9;
        }
    }

    public int menuPagamentoInserirEscolhaOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("<html><body><br>");
        menu.append("<div width='330px' align='center'>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br><div></body></html>");

        Object[] options = {"Pagar um Fornecedor", "Criar novo fornecedor", "Voltar"};

        int resposta = mostrarMensagemBots(menu.toString(), "Menu usuarios escolha", -1, options);
        if (resposta != options.length - 1) {
            return resposta;
        } else {
            return 9;
        }
    }

    // menu Convidados escolha
    public int menuEscolhaTipoConvidadoOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("<html><body><br>");
        menu.append("<div width='320px' align='center'>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br></div></body></html>");

        Object[] options = {"Modificar convidados", "Modificar família", "Voltar"};

        int resposta = mostrarMensagemBots(menu.toString(), "Menu tipo convidados", -1, options);

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
        menu.append("<div width='830px' align='center'>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br></div></body></html>");

        Object[] options = {"Adicionar família", "Mostrar famílias", "Alterar dados da família",
            "Deletar família", "Buscar família (id)", "Confirmar presenças",
            "Voltar"};

        int resposta = mostrarMensagemBots(menu.toString(), "Menu Família", -1, options);

        if (resposta != options.length - 1) {
            return resposta;
        } else {
            return 9;
        }
    }

    // menu Convidados
    public int menuConvidadoOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("<html><body><br>");
        menu.append("<div width='930px' align='center'>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br></div></body></html>");

        Object[] options = {"Criar convidado", "Mostrar convidados", "Alterar dados do convidado",
            "Deletar convidado", "Buscar convidado (id)", "alterar presenças",
            "Voltar"};

        int resposta = mostrarMensagemBots(menu.toString(), "Menu convidados", -1, options);

        if (resposta != options.length - 1) {
            return resposta;
        } else {
            return 9;
        }
    }

    // menu Convidado escolha Criar nova pessoa ou escolher um existente
    public int menuConvidadoInserirEscolhaOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("<html><body><br>");
        menu.append("<div width='330px' align='center'>");
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
            "Deletar Evento", "Buscar Evento", "Voltar"};

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
            "Deletar do mural", "Buscar comentario (id)", "Voltar"};

        int resposta = mostrarMensagemBots(menu.toString(), "Menu Mural de recados", -1, options);

        if (resposta != options.length - 1) {
            return resposta;
        } else {
            return 9;
        }
    }

    // menu Recados escolha Criar nova pessoa ou escolher um existente
    public int menuMuralDeRecadosEscolhaInserirOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("<html><body><br>");
        menu.append("<div width='330px' align='center'>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br><div></body></html>");

        Object[] options = {"Criar nova pessoa", "Escolher uma pessoa", "Voltar"};

        int resposta = mostrarMensagemBots(menu.toString(), "Menu Recados escolha", -1, options);
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

        Object[] options = {"Realizar um pagamento", "Mostrar pagamentos", "Alterar pagamento",
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
        menu.append("<div width='810px' align='center'>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Oque deseja fazer hoje?</p><br></div></body></html>");

        Object[] options = {"Adicionar presente", "Mostrar presentes", "Alterar presente",
            "Deletar presente", "Buscar presente (id)", "presentear casamento", "Voltar"};

        int resposta = mostrarMensagemBots(menu.toString(), "Menu presentes", -1, options);

        if (resposta != options.length - 1) {
            return resposta;
        } else {
            return 9;
        }
    }

    //Menu Relatorios
    public int menuRelatoriosOpcoes() {
        StringBuilder menu = new StringBuilder("");

        menu.append("<html><body><br>");
        menu.append("<div width='1220px' align='center'>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Escolha abaixo uma opção de geração de relatorio.</p><br></div></body></html>");

        Object[] options = {"relatorio de recados", "Imprimir convite Individual", "Imprimir Convite familiar",
            "relatorio de pagamento", "relatorio de convidados", "relatorio de convidados confirmados",
            "Voltar"};

        int resposta = mostrarMensagemBots(menu.toString(), "Menu Relatorios", -1, options);
        if (resposta != options.length - 1) {
            return resposta;
        } else {
            return 9;
        }

    }

    //Menu Relatorios
    public int menuCalendarioOpcoes(LocalDate dataAtual) {
        StringBuilder menu = new StringBuilder("");

        menu.append("<html><body><br>");
        menu.append("<div width='340px' align='center'>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:12px;'>Hoje é ");
        menu.append(Util.formatarDataLocal(dataAtual));
        menu.append("</p><br></div></body></html>");
        menu.append("<p style='font-size:12px;'>Escolha abaixo uma das opções abaixo do calendario.</p><br></div></body></html>");

        Object[] options = {"Avançar dias", "Retroceder dias", "Definir data",
            "Voltar"};

        int resposta = mostrarMensagemBots(menu.toString(), "Menu Calendario", -1, options);
        if (resposta != options.length - 1) {
            return resposta;
        } else {
            return 9;
        }

    }

    //Tela do Relatorio de recados
    public void RelatorioRecados(String vetmural[]) {
        StringBuilder menu = new StringBuilder();

        menu.append("<html><body><br>");
        menu.append("<div width='1010px' align='center'>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:14px;'>Relatorio De Recados</p><br>");
        for (Object recado : vetmural) {
            if (recado != "") {
                menu.append("<p style='font-size:12px; font-weight:bold;'>" + recado + "</p>");
            }
        }
        menu.append("<br></div></body></html>");

        mostrarMensagemAviso(menu.toString(), "Relatorio de Recados", -1);

    }

    //Tela do Convite individual
    public void mostrarConviteIndividual(ConvidadoIndividual ci) {
        StringBuilder menu = new StringBuilder();

        menu.append("<html><body><br>");
        menu.append("<div width='1010px' align='start'>");
        menu.append("<p style='font-size:15px; align='center''>Caro(a) ");
        menu.append(ci.getPessoa().getNome());
        menu.append(",</p><br>");
        menu.append("<p style='font-size:14px;'>É com grande alegria que convidamos você para compartilhar um momento único e inesquecível. Confira os detalhes de sua participação:</p><br>");
        menu.append("<p style='font-size:12px;'>• Nome: ");
        menu.append(ci.getPessoa().getNome());
        menu.append("</p><br>");
        menu.append("<p style='font-size:12px;'>• Data de Nascimento: ");
        menu.append(Util.formatarDataLocal(ci.getPessoa().getNascimento()));
        menu.append("</p><br>");
        menu.append("<p style='font-size:12px;'>• Família: ");
        menu.append(ci.getFamilia());
        menu.append("</p><br>");
        menu.append("<p style='font-size:12px;'>• Parentesco: ");
        menu.append(ci.getParentesco());
        menu.append("</p><br>");
        menu.append("<p style='font-size:12px;'>• ID do Convidado: ");
        menu.append(ci.getId());
        menu.append("</p><br>");
        menu.append("<p style='font-size:14px;'>Contamos com sua presença para celebrar juntos esta ocasião especial!</b><br>");

        menu.append("<p style='font-size:10px;'>Atenção: Guarde este convite com cuidado, pois ele será necessário para acessar o sistema do casamento e no dia do evento.</p><br>");
        menu.append("<p style='font-size:8px;'>Convite gerado pelo sistema de gerenciamento de casamentos: Entre Tapas e beijos.<br>");
        menu.append("<br></div></body></html>");

        mostrarMensagemAviso(menu.toString(), "Convite Individual", -1);

    }

    //Tela do Convite Familiar
    public void mostrarConviteFamilia(ConvidadoFamilia cf) {
        StringBuilder menu = new StringBuilder();

        menu.append("<html><body><br>");
        menu.append("<div width='1010px' align='start'>");
        menu.append("<p style='font-size:15px; align='center''>Prezada Família ");
        menu.append(cf.getNomeDaFamilia());
        menu.append(",</p><br>");
        menu.append("<p style='font-size:14px;'>É com grande alegria que convidamos vocês para celebrar um momento especial conosco. Este convite concede acesso exclusivo ao nosso evento e sistema, e pedimos que o guardem com carinho</p><br>");
        menu.append("<p style='font-size:12px;'>• Nome da Família: ");
        menu.append(cf.getNomeDaFamilia());
        menu.append("</p><br>");
        menu.append("<p style='font-size:12px;'>• Senha do Sistema: ");
        menu.append(cf.getAcesso());
        menu.append("</p><br>");
        menu.append("<p style='font-size:12px;'>• ID da Familia: ");
        menu.append(cf.getId());
        menu.append("</p><br>");
        menu.append("<p style='font-size:14px;'>Estamos ansiosos para compartilhar este dia memorável com todos vocês!</b><br>");

        menu.append("<p style='font-size:12px;'>Atenção: para acessar o sistema e confirmar os convites dos convidados da familia entre com o nome da familia e senha fornecidos no convite.</p><br>");
        menu.append("<p style='font-size:8px;'>Convite gerado pelo sistema de gerenciamento de casamentos: Entre Tapas e beijos.<br>");
        menu.append("<br></div></body></html>");

        mostrarMensagemAviso(menu.toString(), "Convite Familiar", -1);
    }

    //Tela do Relatorio de convidados
    public void RelatorioConvidados(String vetmural[]) {
        StringBuilder menu = new StringBuilder();

        menu.append("<html><body><br>");
        menu.append("<div width='1010px' align='center'>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:14px;'>Relatorio De Convidados</p><br>");
        for (Object recado : vetmural) {
            if (recado != "") {
                menu.append("<p style='font-size:12px; font-weight:bold;'>" + recado + "</p>");
            }
        }
        menu.append("<br></div></body></html>");

        mostrarMensagemAviso(menu.toString(), "Relatorio de Convidados", -1);

    }

    //Tela do Relatorio de convidados
    public void RelatorioPagamento(String vetmural[], double ValorTotal) {
        StringBuilder menu = new StringBuilder();

        menu.append("<html><body><br>");
        menu.append("<div width='1010px' align='center'>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:14px;'>Relatorio De Pagamento</p><br>");
        for (Object recado : vetmural) {
            if (recado != "") {
                menu.append("<p style='font-size:12px; font-weight:bold;'>" + recado + "</p>");
            }
        }
        menu.append("<p style='font-size:12px; font-weight:bold;'>Valor Total: " + ValorTotal + "</p>");
        menu.append("<br></div></body></html>");

        mostrarMensagemAviso(menu.toString(), "Relatorio de Pagamento", -1);

    }

    //Tela do Relatorio de convidados Confirmados
    public void RelatorioConvidadosConfirmados(String[] vetmural, double totalPTS) {
        StringBuilder menu = new StringBuilder();

        menu.append("<html><body><br>");
        menu.append("<div width='1010px' align='center'>");
        menu.append("<p style='font-size:18px; font-weight:bold;'>GERENCIADOR DE CASAMENTOS</p>");
        menu.append("<p style='font-size:14px;'>Relatorio De Convidados Confirmados</p><br>");
        for (Object recado : vetmural) {
            if (recado != "") {
                menu.append("<p style='font-size:12px; font-weight:bold;'>" + recado + "</p>");
            }
        }
        menu.append("<p style='font-size:12px; font-weight:bold;'>Total de pontos: " + totalPTS + "</p>");
        menu.append("<br></div></body></html>");

        mostrarMensagemAviso(menu.toString(), "Relatorio de Convidados Confirmados", -1);

    }

    public Pessoas CriarPessoa() {
        String nome = mostrarMensagemInput("Nome:", "Nome", 3, "douglas");

        LocalDate nascimento = null;
        while (nascimento == null) {
            String input_nascimento = mostrarMensagemInput("Digite sua data de nascimento", "Nascimento", 3, "01/01/2001");
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

        Pessoas p = new Pessoas(nome, nascimento, telefone);

        return p;
    }

    public Usuario CriarUsuario(Pessoas p) {
        String login = mostrarMensagemInput("login:", "Login", 3, "rodrigo");
        String senha = mostrarMensagemInput("senha:", "Senha", 3, "123");
        String tipo = mostrarMensagemInput("Tipo (noivo/noiva, administrador)", "Tipo", 3, "administrador");

        if (login != null) {
            login = login.toLowerCase();
        }

        Usuario u = new Usuario(p, tipo, login, senha);
        return u;
    }

    public Fornecedor CriarFornecedor(Pessoas p) {
        String nomeServico = mostrarMensagemInput("Nome do serviço:", "Nome do Serviço", 3, "Venda de carnes");
        String cnpj = mostrarMensagemInput("Cnpj:", "Cnpj", 3, "2.345.678/0001-99");
        String telefone = mostrarMensagemInput("Telefone:", "telefone", 3, "(11) 91234-5678");

        double valorAPagar = 0.0;
        boolean verificacao = false;
        while (verificacao != true) {
            String valorStr = mostrarMensagemInput("valor a pagar:", "valor a pagar", 3, "100");
            if (valorStr != null) {
                if (validarStringToDouble(valorStr) != -1) {
                    valorAPagar = validarStringToDouble(valorStr);
                    verificacao = true;
                } else {
                    mostrarMensagemAviso("Valor invalido", "Aviso", 2);
                }
            } else {
                break;
            }
        }

        int parcelas = 0;
        verificacao = false;
        while (verificacao != true) {
            String parcelasStr = mostrarMensagemInput("Parcelas:", "Parcelas", 3, "2");
            if (parcelasStr != null) {
                if (validarStringToInt(parcelasStr) != -1) {
                    parcelas = validarStringToInt(parcelasStr);
                    verificacao = true;
                } else {
                    mostrarMensagemAviso("Valor invalido", "Aviso", 2);
                }
            } else {
                break;
            }
        }

        Fornecedor f = new Fornecedor(nomeServico, cnpj, telefone, valorAPagar, p, parcelas);
        return f;
    }

    public ConvidadoFamilia CriarConvidadoFamilia() {
        String nomefamilia = mostrarMensagemInput("Nome da família", "Nome da Família", 3, "Almeida");

        if (nomefamilia != null) {
            nomefamilia = nomefamilia.toLowerCase();
        }

        ConvidadoFamilia cf = new ConvidadoFamilia(nomefamilia);

        return cf;
    }

    public ConvidadoIndividual CriarConvidadoIndividual(Pessoas p) {
        String parentesco = mostrarMensagemInput("Parentesco:", "Parentesco", 3, "");
        String familia = mostrarMensagemInput("Nome da família", "Nome da Família", 3, "Almeida");

        if (familia != null) {
            familia = familia.toLowerCase();
        }
        
        ConvidadoIndividual ci = new ConvidadoIndividual(p, familia, parentesco);
        return ci;
    }

    public Cerimonial criarCerimonial() {
        String nome = mostrarMensagemInput("Nome do Cerimonial:", "Nome", 3, "Cerimonial");
        String telefone = mostrarMensagemInput("Telefone:", "Telefone", 3, "(11) 98765-4321");
        String email = mostrarMensagemInput("Email:", "email", 3, "cerimonial@email.com");

        Cerimonial cerimonial = new Cerimonial(nome, email, telefone);
        return cerimonial;
    }

    public Igreja criarIgreja() {
        String nome = mostrarMensagemInput("Nome da Igreja:", "Nome", 3, "Igreja Central");
        String endereco = mostrarMensagemInput("Endereço:", "Endereço", 3, "Rua Principal, 123");
        String telefone = mostrarMensagemInput("Telefone:", "Telefone", 3, "(11) 98765-4321");

        Igreja igreja = new Igreja(nome, endereco, telefone);
        return igreja;
    }

    public Cartorio criarCartorio() {
        String nome = mostrarMensagemInput("Nome do Cartório:", "Nome", 3, "Cartório Municipal");
        String endereco = mostrarMensagemInput("Endereço:", "Endereço", 3, "Av. Central, 456");
        String telefone = mostrarMensagemInput("Telefone:", "Telefone Cartorio", 3, "33714482");
       

        LocalDate data = null;
        while (data == null) {
             String input_data = mostrarMensagemInput("Digite a data do evento no cartorio:", "Data", 3, "15/10/2024");
            if (input_data != null) {
                data = validarData(input_data);
                if (data == null) {
                    mostrarMensagemAviso("Data inválida. Tente novamente no formato dia/mes/ano.", "Aviso", 2);
                }
            } else {
                break;
            }
        }

        Cartorio cartorio = new Cartorio(nome, endereco, telefone, data);
        return cartorio;
    }

    public Evento CriarEvento(Pessoas noivo, Pessoas noiva) {
        LocalDate data = null;
        String nome = mostrarMensagemInput("Nome do evento:", "Nome", 3, "Casorio");
        String dataEvento = mostrarMensagemInput("Data do Evento:", "Data", 3, "13/01/2000");
        data = validarData(dataEvento);

        Cerimonial cerimonial = criarCerimonial();
        Igreja igreja = criarIgreja();
        Cartorio cartorio = criarCartorio();

        Evento e = new Evento(data, cerimonial, igreja, cartorio, noiva, noivo, nome);

        return e;
    }

    public MuralDeRecados CriarRecado(Pessoas p) {
        
        String comentario = mostrarMensagemInput("Comentario:", "Comentario", 3, "Bom dia");
        
        MuralDeRecados mr = new MuralDeRecados(p, comentario);

        return mr;
    }

    public Pagamentos CriarPagamento(Fornecedor fornecedor, Pessoas pessoa) {
        String descricao = mostrarMensagemInput("Descrição:", "Descrição", 3, "Pagamento de serviço");

        boolean agendado = false;

        Object[] options = {"Regular", "Agendado"};
        int tipoPagamento = mostrarMensagemBots("Qual tipo de pagamento voce gosria de realizar?", "Tipo de Pagamento", -1, options);

        if (tipoPagamento == 1) {
            agendado = true;
        }

        LocalDate data = null;
        if (agendado == true) {
            while (data == null) {
                String input_dias = mostrarMensagemInput("Digite daqui quantos dias voce deseja realizar o pagamento:", "Pagamento agendado", 3, "30");
                if (input_dias != null) {
                    int dias = validarStringToInt(input_dias);
                    if (dias > 0) {
                        data = Util.getDataAtual().plusDays(dias);
                    } else {
                        mostrarMensagemAviso("Valor Invalido", "Aviso", 2);
                    }
                } else {
                    break;
                }
            }
        }

        Pagamentos pagamento = new Pagamentos(data, pessoa, descricao, fornecedor, agendado);

        return pagamento;
    }

    public Presentes CriarPresente(Pessoas p) {
        String nome = mostrarMensagemInput("Nome:", "Nome", 3, "Jogo de pratos");
        String tipo = mostrarMensagemInput("Tipo:", "Tipo", 3, "Cozinha");
        BigDecimal valor = validarStringToBigDecimal(mostrarMensagemInput("Valor", "Valor", 3, "79.90"));

        Presentes ps = new Presentes(nome, tipo, valor);
        ps.setPessoa(p);
        return ps;
    }

    public LocalDate validarData(String inputData) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            return LocalDate.parse(inputData, formato);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    public int validarStringToInt(String inputString) {
        try {
            return Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public double validarStringToDouble(String inputString) {
        if (inputString == "") {
            return -1;
        }
        try {
            return Double.parseDouble(inputString);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private BigDecimal validarStringToBigDecimal(String inputString) {
        if (inputString == null) {
            return null;
        }
        try {
            return new BigDecimal(inputString);
        } catch (NumberFormatException e) {
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

    public Fornecedor selecionarFornecedor(List<Fornecedor> GetDataBase) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
