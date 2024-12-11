/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.Cartorio;
import model.Cerimonial;
import view.GUI;
import model.Pessoas;
import model.Fornecedor;
import model.ConvidadoFamilia;
import model.ConvidadoIndividual;
import model.Evento;
import model.Igreja;
import model.MuralDeRecados;
import model.Pagamentos;
import model.Presentes;
import model.Usuario;

/**
 *
 * @author CAUPT - ALUNOS
 */
public class SoftwareCasamento {

    GUI Gui = new GUI();
    GenericDAO<Fornecedor> FornecedorDao = new GenericDAO(Fornecedor.class);
    GenericDAO<MuralDeRecados> MuralDeRecadosDao = new GenericDAO(MuralDeRecados.class);
    GenericDAO<Pagamentos> PagamentosDao = new GenericDAO(Pagamentos.class);
    GenericDAO<Presentes> PresentesDao = new GenericDAO(Presentes.class);
    GenericDAO<Pessoas> PessoasDao = new GenericDAO(Pessoas.class);
    UsuarioDAO UsuarioDao = new UsuarioDAO(Usuario.class);
    GenericDAO<Evento> EventoDao = new GenericDAO(Evento.class);
    GenericDAO<Cerimonial> CerimonialDao = new GenericDAO(Cerimonial.class);
    GenericDAO<Igreja> IgrejaDao = new GenericDAO(Igreja.class);
    GenericDAO<Cartorio> CartorioDao = new GenericDAO(Cartorio.class);
    ConvidadoFamiliaDAO ConvidadoFamiliaDao = new ConvidadoFamiliaDAO(ConvidadoFamilia.class);
    GenericDAO<ConvidadoIndividual> ConvidadoIndividualDao = new GenericDAO(ConvidadoIndividual.class);

    public SoftwareCasamento() {
        System.out.println("Iniciando Logs do programa...");

        ConexaoBanco.setParametrosDeConexao("root", "admin", "BDSofwareDeCasamento");

        GeradorPdf.setCaminho("arquivosPdfs/");

        System.out.println(Util.ListToString(ConvidadoFamiliaDao.listar()));
        MenuLoginLoop(Gui.MenuLoginOpcoes(EventoDao.listar()));

        System.out.println("Programa finalizado...");
    }

    //menu de login e boas vindas
    private void MenuLoginLoop(int opcaoUsuario) {

        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    String login = Gui.mostrarMensagemInput("Digite seu login:", "Login", 3, "admin");
                    String senha = Gui.mostrarMensagemInput("Digite sua senha:", "Senha", 3, "123");
                    ConvidadoFamilia resultaoAutenticacao = ConvidadoFamiliaDao.autenticar(login, senha);
                    if (UsuarioDao.autenticar(login, senha)) {
                        System.out.println("Acessando menu Gerenciador...");
                        if (!MenuAcessoAdministradorLoop(Gui.menuAcessoAdministradorOpcoes())) {
                            return;
                        }
                    } else if (resultaoAutenticacao != null) {
                        System.out.println("Acessando menu do Responsavel Famíliar...");
                        if (!menuConfirmacaoFamiliaLoop(Gui.menuConfirmacaoFamiliaOpcoes(resultaoAutenticacao), resultaoAutenticacao)) {
                            return;
                        }
                    } else {
                        Gui.mostrarMensagemAviso("Usuario invalido", "Aviso", 2);
                        System.out.println("Usuario invalido detectado...");
                    }

                    break;
                case 1:
                    if (!MenuLoginConvidadoLoop(Gui.menuLoginConvidadoOpcoes())) {
                        return;
                    }
                    break;
                case -1:
                    return;
                default:
                    Gui.mostrarMensagemAviso("escola uma opcao valida !!", "Aviso", 2);
                    break;
            }

            opcaoUsuario = Gui.MenuLoginOpcoes(EventoDao.listar());

        }
        System.out.println("Menu Fechado");
    }

    // Respostas do painel de convidado (sem login)
    private boolean MenuLoginConvidadoLoop(int opcaoUsuario) {
        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    if (!PessoasDao.listar().isEmpty()) {
                        Gui.mostrarMensagemAviso("Digite a seguir seu nome e data de nascimento de acordo com o seu convite", "Aviso", 1);
                        String nome = Gui.mostrarMensagemInput("Digite seu nome:", "Nome", 3, "Beatriz Almeida");
                        String dataNasc = Gui.mostrarMensagemInput("Digite sua data de nascimento:", "Data de Nascimento", 3, "22/11/2012");
                        Pessoas pessoaEncontrada = null;
                        for (Pessoas pessoas : PessoasDao.listar()) {
                            if ((nome != null && dataNasc != null) && (pessoas.getNome().equals(nome) && pessoas.getNascimento().equals(Gui.validarData(dataNasc)))) {
                                pessoaEncontrada = pessoas;
                                break;
                            }
                        }

                        if (pessoaEncontrada != null) {
                            if (!menuMuralDeRecadosConvidadoLoop(Gui.menuMuralDeRecadosConvidadoOpcoes(), pessoaEncontrada)) {
                                return false;
                            }
                        } else {
                            Gui.mostrarMensagemAviso("Voce não foi encontrado se o problema persistir contacte o responsavel do sistema", "Aviso", 1);
                        }

                    } else {
                        Gui.mostrarMensagemAviso("Nenhuma Pessoa cadastrado tente novamente mais tarde", "Aviso", 1);
                    }
                    break;
                case 1:
                    if (!PessoasDao.listar().isEmpty()) {
                        Gui.mostrarMensagemAviso("Digite a seguir seu nome e data de nascimento de acordo com o seu convite", "Aviso", 1);
                        String nome = Gui.mostrarMensagemInput("Digite seu nome:", "Nome", 3, "Juliana Lima");
                        String dataNasc = Gui.mostrarMensagemInput("Digite sua data de nascimento:", "Data de Nascimento", 3, "28/07/1994");
                        Pessoas pessoaEncontrada = null;
                        for (Pessoas pessoas : PessoasDao.listar()) {
                            if ((nome != null && dataNasc != null) && (pessoas.getNome().equals(nome) && pessoas.getNascimento().equals(Gui.validarData(dataNasc)))) {
                                pessoaEncontrada = pessoas;
                                break;
                            }
                        }

                        if (pessoaEncontrada != null) {
                            if (!menuPresentesConvidadoLoop(Gui.menuPresentesConvidadoOpcoes(), pessoaEncontrada)) {
                                return false;
                            }
                        } else {
                            Gui.mostrarMensagemAviso("Voce não foi encontrado se o problema persistir contacte o responsavel do sistema", "Aviso", 1);
                        }

                    } else {
                        Gui.mostrarMensagemAviso("Nenhuma Pessoa cadastrado tente novamente mais tarde", "Aviso", 1);
                    }
                    break;
                case -1:
                    return false;
                default:
                    Gui.mostrarMensagemAviso("Escola uma opcao valida !!", "Aviso", 2);
                    break;
            }

            opcaoUsuario = Gui.menuLoginConvidadoOpcoes();

        }
        System.out.println("Menu Fechado");
        return true;
    }

    // menu de acesso ao painel do administrador
    private boolean MenuAcessoAdministradorLoop(int opcaoUsuario) {

        while (opcaoUsuario != 15) {
            switch (opcaoUsuario) {
                case 0:
                    if (!menuPessoasLoop(Gui.menuPessoaOpcoes())) {
                        return false;
                    }
                    break;
                case 1:
                    if (!menuUsuariosLoop(Gui.menuUsuarioOpcoes())) {
                        return false;
                    }
                    break;
                case 2:
                    if (!menuFornecedorLoop(Gui.menuFornecedorOpcoes())) {
                        return false;
                    }
                    break;
                case 3:
                    if (!menuEscolhaTipoConvidadoLoop(Gui.menuEscolhaTipoConvidadoOpcoes())) {
                        return false;
                    }
                    break;
                case 4:
                    if (!menuEventoLoop(Gui.menuEventoOpcoes())) {
                        return false;
                    }
                    break;
                case 5:
                    if (!menuMuralDeRecadosLoop(Gui.menuMuralDeRecadosOpcoes())) {
                        return false;
                    }
                    break;
                case 6:
                    if (!menuPagamentoLoop(Gui.menuPagamentoOpcoes())) {
                        return false;
                    }
                    break;
                case 7:
                    if (!menuPresenteLoop(Gui.menuPresenteOpcoes())) {
                        return false;
                    }
                    break;
                case 8:
                    if (!menuRelatoriosLoop(Gui.menuRelatoriosOpcoes())) {
                        return false;
                    }
                    break;
                case 9:
                    if (!menuCalendarioLoop(Gui.menuCalendarioOpcoes(Util.getDataAtual()))) {
                        return false;
                    }
                    break;
                case -1:
                    return false;
                default:
                    Gui.mostrarMensagemAviso("Escola uma opcao valida !!", "Aviso", 2);
                    break;
            }

            opcaoUsuario = Gui.menuAcessoAdministradorOpcoes();

        }
        System.out.println("Menu Fechado");
        return true;
    }

    // Menu Mural de recados para convidados (sem login)
    private boolean menuPresentesConvidadoLoop(int opcaoUsuario, Pessoas p) {

        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    List<Presentes> listaPresentes = PresentesDao.listar();
                    if (!listaPresentes.isEmpty()) {
                        int idresposta = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID de um dos presentes abaixo que voce irá presentear\n" + Util.ListToString(listaPresentes), "Alterar Presente", 1, "1"));
                        if (PresentesDao.buscar(idresposta) != null) {
                            PresentesDao.buscar(idresposta).setPessoa(p);
                            Gui.mostrarMensagemAviso("Presente Confirmado.", "Aviso", 1);
                        } else {
                            Gui.mostrarMensagemAviso("ID invalido", "Aviso", 2);
                        }
                    } else {
                        Gui.mostrarMensagemAviso("Nenhum Presente cadastrado", "Aviso", 2);
                    }

                    break;
                case 1:
                    listaPresentes = PresentesDao.listar();
                    if (!listaPresentes.isEmpty()) {
                        Gui.mostrarMensagemAviso("Presentes : \n" + Util.ListToString(listaPresentes), "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Nenhum Presente cadastrado", "Aviso", 2);
                    }
                    break;
                case 2:
                    listaPresentes = PresentesDao.listar();
                    int idresposta = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID de um dos presentes abaixo que voce irá cancelar\n" + Util.ListToString(listaPresentes), "Alterar Presente", 1, "1"));
                    if (PresentesDao.buscar(idresposta) != null) {
                        if (PresentesDao.buscar(idresposta).getPessoa() != null
                                && PresentesDao.buscar(idresposta).getPessoa().equals(p)) {
                            PresentesDao.buscar(idresposta).setPessoa(null);
                            Gui.mostrarMensagemAviso("Presente cancelado.", "Aviso", 1);
                        } else {
                            Gui.mostrarMensagemAviso("Voce não tem permissão para cancelar esse presente", "Aviso", 2);
                        }
                    } else {
                        Gui.mostrarMensagemAviso("ID invalido", "Aviso", 2);
                    }
                    break;
                case -1:
                    return false;
                default:
                    Gui.mostrarMensagemAviso("Escola uma opcao valida !!", "Aviso", 2);
                    break;
            }

            opcaoUsuario = Gui.menuPresentesConvidadoOpcoes();

        }
        System.out.println("Menu Fechado");
        return true;

    }

    // Menu Mural de recados para convidados (sem login)
    private boolean menuMuralDeRecadosConvidadoLoop(int opcaoUsuario, Pessoas p) {

        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    if (MuralDeRecadosDao.adiciona(Gui.CriarRecado(p)) != -1) {
                        Gui.mostrarMensagemAviso("Recado Criado", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Criar Recado", "Aviso", 2);
                    }
                    break;
                case 1:
                    List<MuralDeRecados> listaMuralDeRecados = MuralDeRecadosDao.listar();
                    if (!listaMuralDeRecados.isEmpty()) {
                        Gui.mostrarMensagemAviso("Recados : \n" + Util.ListToString(listaMuralDeRecados), "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Não há registro de recados", "Aviso", 2);
                    }
                    break;
                case 2:
                    int idAltera = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID de um Recado a ser alterado", "Alterar Recado", 1, "1"));
                    if (MuralDeRecadosDao.buscar(idAltera).getPessoa().equals(p)) {
                        if (MuralDeRecadosDao.alterar(idAltera, Gui.CriarRecado(p)) != false) {
                            Gui.mostrarMensagemAviso("Recado Alterado", "Aviso", 1);
                        } else {
                            Gui.mostrarMensagemAviso("Erro ao Alterar Recado", "Aviso", 2);
                        }
                    } else {
                        Gui.mostrarMensagemAviso("Voce não tem permissão para alterar outros recados", "Atenção", 2);
                    }
                    break;
                case 3:
                    int idDelete = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID do Recado a ser deletado", "Deletar Recado", 1, "1"));
                    if (MuralDeRecadosDao.buscar(idDelete) != null
                            && MuralDeRecadosDao.buscar(idDelete).getPessoa().equals(p)) {

                        if (MuralDeRecadosDao.deletar(idDelete) != null) {
                            Gui.mostrarMensagemAviso("Recado Deletado", "Aviso", 1);
                        } else {
                            Gui.mostrarMensagemAviso("Erro ao Deletar Recado", "Aviso", 2);
                        }
                    } else {
                        Gui.mostrarMensagemAviso("Voce não tem permissão para deletar outros recados", "Atenção", 2);
                    }
                    break;
                case 4:
                    int idBuscar = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID do Recado a ser buscado", "Buscar Recado", 1, "1"));
                    if (MuralDeRecadosDao.buscar(idBuscar) != null) {
                        Gui.mostrarMensagemAviso("Recado : \n" + MuralDeRecadosDao.buscar(idBuscar).toString(), "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Recado não encontrado", "Aviso", 2);
                    }
                    break;
                case -1:
                    return false;
                default:
                    Gui.mostrarMensagemAviso("Escola uma opcao valida !!", "Aviso", 2);
                    break;
            }

            opcaoUsuario = Gui.menuMuralDeRecadosConvidadoOpcoes();

        }
        System.out.println("Menu Fechado");
        return true;

    }

    // menu pessoas
    private boolean menuPessoasLoop(int opcaoUsuario) {

        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    if (PessoasDao.adiciona(Gui.CriarPessoa()) != -1) {
                        Gui.mostrarMensagemAviso("Pessoa Criada", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Criar Pessoa", "Aviso", 2);
                    }
                    break;
                case 1:
                    List<Pessoas> listaPessoas = PessoasDao.listar();
                    if (!listaPessoas.isEmpty()) {
                        Gui.mostrarMensagemAviso("Pessoas: \n" + Util.ListToString(PessoasDao.listar()), "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Nenhuma pessoa cadastrada", "Aviso", 2);
                    }

                    break;
                case 2:

                    int idAltera = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID da pessoa a ser alterada", "Alterar Pessoa", 1, "1"));
                    if (PessoasDao.alterar(idAltera, Gui.CriarPessoa()) != false) {
                        Gui.mostrarMensagemAviso("Pessoa Alterada", "Aviso", 3);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Alterar Pessoa", "Aviso", 2);
                    }
                    break;
                case 3:
                    int idDelete = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID do pessoa a ser deletado", "Deletar Pessoa", 1, "1"));
                    if (PessoasDao.deletar(idDelete) != null) {
                        Gui.mostrarMensagemAviso("Pessoa Deletada", "Aviso", 3);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Deletar Pessoa", "Aviso", 2);
                    }
                    break;
                case 4:
                    int idBuscar = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID do pessoa a ser buscado", "Buscar Pessoa", 1, "1"));
                    if (PessoasDao.buscar(idBuscar) != null) {
                        Gui.mostrarMensagemAviso("Pessoas : \n" + PessoasDao.buscar(idBuscar).toString(), "Aviso", 3);

                    } else {
                        Gui.mostrarMensagemAviso("Pessoa não encontrada", "Aviso", 2);
                    }
                    break;
                case -1:
                    return false;
                default:
                    Gui.mostrarMensagemAviso("Escolha uma opcao valida !!", "Aviso", 2);
                    break;
            }

            opcaoUsuario = Gui.menuPessoaOpcoes();

        }
        System.out.println("Menu Fechado");
        return true;
    }

    private boolean menuUsuariosLoop(int opcaoUsuario) {

        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    // verifica nos vetores de usuario e pessoa se eles estão associados
                    boolean PessoaTemUsuario = false;

                    for (Pessoas pessoa : PessoasDao.listar()) {
                        boolean estaAssociada = false;

                        for (Usuario usuario : UsuarioDao.listar()) {
                            if (usuario.getPessoa() != null && usuario.getPessoa().getId() == pessoa.getId()) {
                                estaAssociada = true;
                                break;
                            }
                        }
                        if (!estaAssociada) {
                            PessoaTemUsuario = true;
                        }
                    }

                    // caso não tenha nenhuma pessoa cadastrada ou nenhuma pessoa que não esteja atrelada a um usuario 
                    if (!PessoaTemUsuario || PessoasDao.listar().isEmpty()) {
                        Gui.mostrarMensagemAviso("Nenhuma pessoa disponivel encontrada insira informações da pessoa referente a esse usuario", "Aviso", 1);
                        Pessoas p = Gui.CriarPessoa();
                        Long idPessoaADD = PessoasDao.adiciona(p);

                        if (idPessoaADD != -1) {
                            Gui.mostrarMensagemAviso("Pessoa Criada", "Aviso", 1);

                            Gui.mostrarMensagemAviso("Agora insira as informações do usuario", "Aviso", 1);
                            if (UsuarioDao.adiciona(Gui.CriarUsuario(PessoasDao.buscar(idPessoaADD))) != -1) {
                                Gui.mostrarMensagemAviso("Usuario Criado", "Aviso", 1);
                            } else {
                                Gui.mostrarMensagemAviso("Erro ao Criar Usuario ", "Aviso", 2);
                            }
                        } else {
                            Gui.mostrarMensagemAviso("Erro ao Criar Pessoa", "Aviso", 2);
                        }
                    } else { // caso tenha vai para a escolha de criar uma pessoa ou escolher uma existente
                        if (!menuUsuariosInserirEscolhaLoop(Gui.menuUsuariosInserirEscolhaOpcoes())) {
                            return false;
                        }
                    }

                    break;
                case 1:
                    List<Usuario> listaUsuario = UsuarioDao.listar();
                    if (!listaUsuario.isEmpty()) {
                        Gui.mostrarMensagemAviso("Usuarios : \n" + Util.ListToString(listaUsuario), "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Nenhum Usuario cadastrado", "Aviso", 2);
                    }
                    break;
                case 2:
                    int idAltera = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID do usuario a ser alterado", "Alterar Usuario", 1, "1"));
                    Usuario usuario = UsuarioDao.buscar(idAltera);
                    if (usuario != null && UsuarioDao.alterar(idAltera, Gui.CriarUsuario(usuario.getPessoa()))) {
                        Gui.mostrarMensagemAviso("Usuario Alterada", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Alterar Usuario ", "Aviso", 2);
                    }
                    break;

                case 3:
                    int idDelete = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID do usuario a ser deletado", "Deletar Usuario", 1, "1"));
                    if (UsuarioDao.deletar(idDelete) != null) {
                        Gui.mostrarMensagemAviso("Usuario Deletada", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Deletar Usuario", "Aviso", 2);
                    }

                    break;
                case 4:
                    int idBuscar = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID do usuario a ser buscado", "Buscar Usuario", 1, "1"));
                    if (UsuarioDao.buscar(idBuscar) != null) {
                        Gui.mostrarMensagemAviso("Usuario : \n" + UsuarioDao.buscar(idBuscar).toString(), "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Usuario não encontrada", "Aviso", 2);
                    }
                    break;
                case -1:
                    return false;
                default:
                    Gui.mostrarMensagemAviso("Escolha uma opcao valida !!", "Aviso", 2);
                    break;
            }

            opcaoUsuario = Gui.menuUsuarioOpcoes();

        }
        System.out.println("Menu Fechado");
        return true;
    }

    private boolean menuUsuariosInserirEscolhaLoop(int opcaoUsuario) {

        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    Pessoas p = Gui.CriarPessoa();
                    Long idPessoaADD = PessoasDao.adiciona(p);
                    if (idPessoaADD != -1) {
                        Gui.mostrarMensagemAviso("Pessoa Criada", "Aviso", 1);
                        if (UsuarioDao.adiciona(Gui.CriarUsuario(PessoasDao.buscar(idPessoaADD))) != -1) {
                            Gui.mostrarMensagemAviso("Usuario Criado", "Aviso", 1);
                        } else {
                            Gui.mostrarMensagemAviso("Erro ao Criar Usuario ", "Aviso", 2);
                        }
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Criar Pessoa", "Aviso", 2);
                    }
                    break;
                case 1:

                    List<Long> idsPessoaSemUsuario = new ArrayList();

                    String StringPessoasSemUsuario = "";

                    for (Pessoas pessoa : PessoasDao.listar()) {
                        boolean PessoatemUsuario = false;
                        for (Usuario usuario : UsuarioDao.listar()) {
                            if (usuario.getPessoa() != null && usuario.getPessoa().getId() == pessoa.getId()) {
                                PessoatemUsuario = true;
                            }
                        }

                        if (!PessoatemUsuario) {
                            idsPessoaSemUsuario.add(pessoa.getId());
                            StringPessoasSemUsuario += PessoasDao.buscar(pessoa.getId()).toString();
                        }
                    }

                    boolean verificacao = false;
                    int option;
                    while (verificacao != true) {
                        String resp = Gui.mostrarMensagemInput("Qual Pessoa vai ser atrelado ao usuario? digite o ID: \n" + StringPessoasSemUsuario, "Opções", 1, "1");
                        if (resp == null) {
                            return true;
                        } else {
                            option = Gui.validarStringToInt(resp);
                        }

                        for (long pessoa : idsPessoaSemUsuario) {
                            if (pessoa == option && option != 0) {
                                verificacao = true;
                            }
                        }

                        if (verificacao == true) {
                            Pessoas p2 = PessoasDao.buscar(option);

                            if (UsuarioDao.adiciona(Gui.CriarUsuario(p2)) != -1) {
                                Gui.mostrarMensagemAviso("Usuario Criado", "Aviso", 1);
                            } else {
                                Gui.mostrarMensagemAviso("Erro ao Criar Usuario ", "Aviso", 2);
                            }

                        } else {
                            Gui.mostrarMensagemAviso("ID invalido", "Aviso", 1);
                        }

                    }
                    break;

                case -1:
                    return false;

            }
            return true;
        }

        System.out.println(
                "Menu Fechado");

        return true;
    }

    private boolean menuFornecedorLoop(int opcaoUsuario) {

        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:

                    if (PessoasDao.listar().isEmpty()) {
                        Gui.mostrarMensagemAviso("Nenhuma pessoa disponivel encontrada insira informações da pessoa referente a esse Fornecedor", "Aviso", 1);
                        Pessoas p = Gui.CriarPessoa();
                        Long idPessoaADD = PessoasDao.adiciona(p);
                        if (idPessoaADD != -1) {
                            if (FornecedorDao.adiciona(Gui.CriarFornecedor(PessoasDao.buscar(idPessoaADD))) != -1) {
                                Gui.mostrarMensagemAviso("Fornecedor Criado", "Aviso", 1);
                            } else {
                                Gui.mostrarMensagemAviso("Erro ao Criar Fornecedor", "Aviso", 2);
                            }
                        } else {
                            Gui.mostrarMensagemAviso("Erro ao Criar Pessoa", "Aviso", 2);
                        }
                    } else {
                        if (!menuFornecedorInserirEscolhaLoop(Gui.menuFornecedorInserirEscolhaOpcoes())) {
                            return false;
                        }
                    }
                    break;
                case 1:
                    List<Fornecedor> listaFornecedores = FornecedorDao.listar();
                    if (!listaFornecedores.isEmpty()) {
                        Gui.mostrarMensagemAviso("Fornecedores : \n" + Util.ListToString(listaFornecedores), "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Nenhum Fornecedor Cadastrado", "Aviso", 2);
                    }
                    break;
                case 2:
                    int idAltera = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID do fornecedor a ser alterado", "Alterar Fornecedor", 1, "1"));
                    Fornecedor fornecedor = FornecedorDao.buscar(idAltera);
                    if (fornecedor != null && FornecedorDao.alterar(idAltera, Gui.CriarFornecedor(fornecedor.getPessoa()))) {
                        Gui.mostrarMensagemAviso("Fornecedor Alterado", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Alterar Fornecedor", "Aviso", 2);
                    }
                    break;

                case 3:
                    int idDelete = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID do Fornecedor a ser deletado", "Deletar Fornecedor", 1, "1"));
                    if (FornecedorDao.deletar(idDelete) != null) {
                        Gui.mostrarMensagemAviso("Fornecedor Deletado", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Deletar Fornecedor", "Aviso", 2);
                    }
                    break;
                case 4:
                    int idBuscar = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID do Fornecedor a ser buscado", "Buscar Forncededor", 1, "1"));
                    if (FornecedorDao.buscar(idBuscar) != null) {
                        Gui.mostrarMensagemAviso("Fornecedor : \n" + FornecedorDao.buscar(idBuscar).toString(), "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Fornecedor não encontrado", "Aviso", 2);
                    }
                    break;
                case -1:
                    return false;
                default:
                    Gui.mostrarMensagemAviso("Escolha uma opcao valida !!", "Aviso", 2);
                    break;
            }

            opcaoUsuario = Gui.menuFornecedorOpcoes();

        }
        System.out.println("Menu Fechado");
        return true;
    }

    private boolean menuFornecedorInserirEscolhaLoop(int opcaoUsuario) {

        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    Pessoas p = Gui.CriarPessoa();
                    Long idPessoaADD = PessoasDao.adiciona(p);
                    if (idPessoaADD != -1) {
                        Gui.mostrarMensagemAviso("Pessoa Criada", "Aviso", 1);
                        if (FornecedorDao.adiciona(Gui.CriarFornecedor(PessoasDao.buscar(idPessoaADD))) != -1) {
                            Gui.mostrarMensagemAviso("Fornecedor Criado", "Aviso", 1);
                        } else {
                            Gui.mostrarMensagemAviso("Erro ao Criar Fornecedor", "Aviso", 2);
                        }
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Criar Pessoa", "Aviso", 2);
                    }

                    break;
                case 1:

                    boolean verificacao = false;
                    int option;
                    while (verificacao != true) {
                        String resp = Gui.mostrarMensagemInput("Qual Pessoa vai ser atrelado a esse fornecedor? digite o ID: \n" + Util.ListToString(PessoasDao.listar()), "escolha a pessoa", 3, "1");

                        if (resp == null) {
                            return true;
                        } else {
                            option = Gui.validarStringToInt(resp);
                        }

                        for (Pessoas pessoa : PessoasDao.listar()) {
                            if (pessoa.getId() == option && option != -1) {
                                verificacao = true;
                            }
                        }

                        if (verificacao == true) {
                            Pessoas p2 = PessoasDao.buscar(option);

                            if (FornecedorDao.adiciona(Gui.CriarFornecedor(p2)) != -1) {
                                Gui.mostrarMensagemAviso("Fornecedor Criado", "Aviso", 1);
                            } else {
                                Gui.mostrarMensagemAviso("Erro ao Criar Fornecedor ", "Aviso", 2);
                            }

                        } else {
                            Gui.mostrarMensagemAviso("ID invalido", "Aviso", 2);
                        }

                    }
                    break;
                case -1:
                    return false;
                default:
                    Gui.mostrarMensagemAviso("Escolha uma opcao valida !!", "Aviso", 2);
                    break;
            }
            return true;
        }
        System.out.println("Menu Fechado");
        return true;
    }

    private boolean menuConfirmacaoFamiliaLoop(int opcaoUsuario, ConvidadoFamilia cf) {
        List<Long> idsConvidadosFamilia = new ArrayList();

        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    String StringConvidadosFamilia = "";

                    for (ConvidadoIndividual ci : ConvidadoIndividualDao.listar()) {
                        if (cf.getNomeDaFamilia().equals(ci.getFamilia())) {
                            idsConvidadosFamilia.add(ci.getId());
                            StringConvidadosFamilia += ConvidadoIndividualDao.buscar(ci.getId());

                        }
                    }

                    if (!idsConvidadosFamilia.isEmpty()) {
                        int option;
                        boolean verificacao = false;
                        while (verificacao != true) {
                            String resp = Gui.mostrarMensagemInput("Qual convidado você gostaria de modificar a confirmação de presença? digite o ID: \n" + StringConvidadosFamilia, "escolha a pessoa", 3, "1");
                            if (resp == null) {
                                break;
                            } else {
                                option = Gui.validarStringToInt(resp);
                            }

                            for (Long convidados : idsConvidadosFamilia) {
                                if (convidados == option && option != 0) {
                                    verificacao = true;
                                }
                            }

                            if (verificacao == true) {
                                ConvidadoIndividual convidado = ConvidadoIndividualDao.buscar(option);
                                if (convidado.getConfirmacao().equals("Não Confirmado")) {
                                    convidado.setConfirmacao("Confirmado");
                                    Gui.mostrarMensagemAviso("Presença Confirmada", "Aviso", 1);
                                } else {
                                    convidado.setConfirmacao("Não Confirmado");
                                    Gui.mostrarMensagemAviso("Presença Cancelada", "Aviso", 1);
                                }
                                ConvidadoIndividualDao.alterar(convidado.getId(), convidado);

                                boolean familiaVai = false;
                                for (ConvidadoIndividual convidados : ConvidadoIndividualDao.listar()) {
                                    if (cf.getNomeDaFamilia().equals(convidados.getFamilia())
                                            && convidados.getConfirmacao().equals("Confirmado")) {
                                        familiaVai = true;
                                    }
                                }
                                if (!familiaVai) {
                                    cf.setConfirmacao("Não Confirmado");
                                } else {
                                    cf.setConfirmacao("Confirmado");
                                }
                                ConvidadoFamiliaDao.alterar(cf.getId(), cf);

                            } else {
                                Gui.mostrarMensagemAviso("ID invalido", "Aviso", 1);
                            }
                        }
                    } else {
                        Gui.mostrarMensagemAviso("Nenhum convidado cadastrado nessa família, tente novamente mais tarde.", "Aviso", 1);
                    }
                    break;
                case -1:
                    return false;
                default:
                    Gui.mostrarMensagemAviso("Escolha uma opcao valida !!", "Aviso", 2);
                    break;
            }
            opcaoUsuario = Gui.menuConfirmacaoFamiliaOpcoes(cf);
        }
        System.out.println("Menu Fechado");
        return true;
    }

    private boolean menuEscolhaTipoConvidadoLoop(int opcaoUsuario) {

        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    if (!menuConvidadoLoop(Gui.menuConvidadoOpcoes())) {
                        return false;
                    }
                    break;
                case 1:
                    if (!menuFamiliaLoop(Gui.menuFamiliaOpcoes())) {
                        return false;
                    }
                    break;
                case -1:
                    return false;
                default:
                    Gui.mostrarMensagemAviso("Escolha uma opcao valida !!", "Aviso", 2);
                    break;
            }

            opcaoUsuario = Gui.menuEscolhaTipoConvidadoOpcoes();

        }
        System.out.println("Menu Fechado");
        return true;
    }

    private boolean menuFamiliaLoop(int opcaoUsuario) {
        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    if (ConvidadoFamiliaDao.adiciona(Gui.CriarConvidadoFamilia()) != -1) {
                        Gui.mostrarMensagemAviso("família Criado", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Criar família", "Aviso", 2);
                    }
                    break;
                case 1:
                    List<ConvidadoFamilia> listaConvidadoFamilia = ConvidadoFamiliaDao.listar();
                    if (!listaConvidadoFamilia.isEmpty()) {
                        System.out.println("famílias:" + Util.ListToString(listaConvidadoFamilia));
                        Gui.mostrarMensagemAviso("famílias : \n" + Util.ListToString(listaConvidadoFamilia), "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Nenhuma família cadastrada", "Aviso", 2);
                    }

                    break;
                case 2:
                    int idAltera = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID da família a ser alterada", "Alterar família", 1, "1"));
                    if (ConvidadoFamiliaDao.alterar(idAltera, Gui.CriarConvidadoFamilia()) != false) {
                        Gui.mostrarMensagemAviso("Família Alterada", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Alterar família", "Aviso", 2);
                    }
                    break;
                case 3:
                    int idDelete = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID da família a ser deletada", "Deletar família", 1, "1"));
                    if (ConvidadoFamiliaDao.deletar(idDelete) != null) {
                        Gui.mostrarMensagemAviso("família Deletada", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Deletar família", "Aviso", 2);
                    }
                    break;
                case 4:
                    int idBuscar = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID da família a ser buscada", "Buscar família", 1, "1"));
                    if (ConvidadoFamiliaDao.buscar(idBuscar) != null) {
                        Gui.mostrarMensagemAviso("família : \n" + ConvidadoFamiliaDao.buscar(idBuscar).toString(), "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("família não encontrada", "Aviso", 2);
                    }
                    break;
                case 5:
                    listaConvidadoFamilia = ConvidadoFamiliaDao.listar();
                    StringBuilder familias = new StringBuilder("");

                    familias.append("<html><body><p style='font-size:10px; font-weight:bold;'>");
                    for (ConvidadoFamilia cf : listaConvidadoFamilia) {
                        familias.append("ID: ");
                        familias.append(cf.getId());
                        familias.append("&nbsp;&nbsp;Nome da família: ");
                        familias.append(cf.getNomeDaFamilia());
                        familias.append("&nbsp;&nbsp;Confirmação: ");
                        familias.append(cf.getConfirmacao());
                        familias.append("<br>");
                    }
                    familias.append("</p></body></html>");

                    boolean verificacao = false;
                    int option;
                    while (verificacao != true) {
                        String resp = Gui.mostrarMensagemInput("Qual convidado você gostaria de modificar a confirmação de presença? digite o ID: \n" + familias, "escolha o convidado", 3, "1");

                        if (resp == null) {
                            break;
                        } else {
                            option = Gui.validarStringToInt(resp);
                        }

                        for (ConvidadoFamilia ConvidadoFamilia : listaConvidadoFamilia) {
                            if (ConvidadoFamilia.getId() == option && option != -1) {
                                verificacao = true;
                            }
                        }

                        if (verificacao == true) {
                            ConvidadoFamilia ConvidadoFamilia = ConvidadoFamiliaDao.buscar(option);
                            if (ConvidadoFamilia.getConfirmacao().equals("Não Confirmado")) {
                                ConvidadoFamilia.setConfirmacao("Confirmado");
                                Gui.mostrarMensagemAviso("Presença Confirmada", "Aviso", 1);
                            } else {
                                ConvidadoFamilia.setConfirmacao("Não Confirmado");
                                Gui.mostrarMensagemAviso("Presença Cancelada", "Aviso", 1);
                            }
                            ConvidadoFamiliaDao.alterar(option, ConvidadoFamilia);
                        } else {
                            Gui.mostrarMensagemAviso("ID invalido", "Aviso", 2);
                        }
                    }
                    break;

                case -1:
                    return false;
                default:
                    Gui.mostrarMensagemAviso("Escolha uma opcao valida !!", "Aviso", 2);
                    break;
            }

            opcaoUsuario = Gui.menuFamiliaOpcoes();

        }

        System.out.println(
                "Menu Fechado");

        return true;
    }

    private boolean menuConvidadoLoop(int opcaoUsuario) {
        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    // verifica nos vetores de convidado e pessoa se eles estão associados
                    boolean PessoaEhconvidado = false;

                    for (Pessoas pessoa : PessoasDao.listar()) {
                        boolean estaAssociada = false;

                        for (ConvidadoIndividual ci : ConvidadoIndividualDao.listar()) {
                            if (ci.getPessoa() != null && ci.getPessoa().getId() == pessoa.getId()) {
                                estaAssociada = true;
                                break;
                            }
                        }
                        if (!estaAssociada) {
                            PessoaEhconvidado = true;
                        }
                    }
                    // caso não tenha nenhuma pessoa cadastrada ou nenhuma pessoa que não esteja atrelada a um convidado 
                    if (!PessoaEhconvidado || PessoasDao.listar().isEmpty()) {
                        Gui.mostrarMensagemAviso("Nenhuma pessoa disponivel encontrada insira informações da pessoa referente a esse Convidado", "Aviso", 1);
                        Pessoas p = Gui.CriarPessoa();
                        Long idPessoaADD = PessoasDao.adiciona(p);

                        if (idPessoaADD != -1) {
                            Gui.mostrarMensagemAviso("Pessoa Criada", "Aviso", 1);

                            Gui.mostrarMensagemAviso("Agora insira as informações do Convidado", "Aviso", 1);
                            if (ConvidadoIndividualDao.adiciona(Gui.CriarConvidadoIndividual(PessoasDao.buscar(idPessoaADD))) != -1) {
                                Gui.mostrarMensagemAviso("Convidado Criado", "Aviso", 1);
                            } else {
                                Gui.mostrarMensagemAviso("Erro ao Criar Convidado ", "Aviso", 2);
                            }
                        } else {
                            Gui.mostrarMensagemAviso("Erro ao Criar Pessoa", "Aviso", 2);
                        }
                    } else {// caso tenha vai para a escolha de criar uma pessoa ou escolher uma existente
                        if (!menuConvidadoInserirEscolhaLoop(Gui.menuConvidadoInserirEscolhaOpcoes())) {
                            return false;
                        }
                    }

                    break;
                case 1:
                    List<ConvidadoIndividual> listaConvidadoIndividual = ConvidadoIndividualDao.listar();
                    if (!listaConvidadoIndividual.isEmpty()) {
                        Gui.mostrarMensagemAviso("Convidados : \n" + Util.ListToString(listaConvidadoIndividual), "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Nenhum convidado cadastrado", "Aviso", 2);
                    }
                    break;
                case 2:
                    int idAltera = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID de um Convidado a ser alterado", "Alterar Convidado", 1, "1"));
                    ConvidadoIndividual ConvidadoI = ConvidadoIndividualDao.buscar(idAltera);
                    if (ConvidadoI != null && ConvidadoIndividualDao.alterar(idAltera, Gui.CriarConvidadoIndividual(ConvidadoI.getPessoa())) != false) {
                        Gui.mostrarMensagemAviso("Convidado Alterado", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Alterar Convidado", "Aviso", 2);
                    }
                    break;

                case 3:
                    int idDelete = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID do Convidado a ser deletado", "Deletar Convidado", 1, "1"));
                    if (ConvidadoIndividualDao.deletar(idDelete) != null) {
                        Gui.mostrarMensagemAviso("Convidado Deletado", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Deletar Convidado", "Aviso", 2);
                    }
                    break;
                case 4:
                    int idBuscar = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID do Convidado a ser buscado", "Buscar Convidado", 1, "1"));
                    if (ConvidadoIndividualDao.buscar(idBuscar) != null) {
                        Gui.mostrarMensagemAviso("Convidado : \n" + ConvidadoIndividualDao.buscar(idBuscar).toString(), "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Convidado não encontrado", "Aviso", 2);
                    }
                    break;
                case 5:
                    listaConvidadoIndividual = ConvidadoIndividualDao.listar();
                    if (listaConvidadoIndividual.isEmpty()) {
                        Gui.mostrarMensagemAviso("Nenhum convidado cadastrado", "Aviso", 2);
                    } else {

                        StringBuilder convidados = new StringBuilder("");

                        convidados.append("<html><body><p style='font-size:10px; font-weight:bold;'>");
                        for (Pessoas pessoa : PessoasDao.listar()) {
                            for (ConvidadoIndividual ci : ConvidadoIndividualDao.listar()) {
                                if (ci.getPessoa() != null && ci.getPessoa().getId() == pessoa.getId()) {
                                    convidados.append("ID: ");
                                    convidados.append(ci.getId());
                                    convidados.append("&nbsp;&nbsp;Nome: ");
                                    convidados.append(pessoa.getNome());
                                    convidados.append("&nbsp;&nbsp;Confirmação: ");
                                    convidados.append(ci.getConfirmacao());
                                    convidados.append("<br>");
                                }
                            }
                        }
                        convidados.append("</p></body></html>");

                        boolean verificacao = false;
                        int option;
                        while (verificacao != true) {
                            String resp = Gui.mostrarMensagemInput("Qual convidado você gostaria de modificar a confirmação de presença? digite o ID: \n" + convidados, "escolha o convidado", 3, "1");

                            if (resp == null) {
                                break;
                            } else {
                                option = Gui.validarStringToInt(resp);
                            }

                            for (ConvidadoIndividual convidadoIndividual : ConvidadoIndividualDao.listar()) {
                                if (convidadoIndividual.getId() == option && option != -1) {
                                    verificacao = true;
                                }
                            }

                            if (verificacao == true) {
                                ConvidadoIndividual convidado = ConvidadoIndividualDao.buscar(option);
                                System.out.println(convidado.getConfirmacao());
                                if (convidado.getConfirmacao().equals("Não Confirmado")) {
                                    convidado.setConfirmacao("Confirmado");
                                    Gui.mostrarMensagemAviso("Presença Confirmada", "Aviso", 1);
                                } else {
                                    convidado.setConfirmacao("Não Confirmado");
                                    Gui.mostrarMensagemAviso("Presença Cancelada", "Aviso", 1);
                                }
                                ConvidadoIndividualDao.alterar(option, convidado);
                            } else {
                                Gui.mostrarMensagemAviso("ID invalido", "Aviso", 2);
                            }
                        }

                    }
                    break;
                case -1:
                    return false;
                default:
                    Gui.mostrarMensagemAviso("Escolha uma opcao valida !!", "Aviso", 2);
                    break;
            }

            opcaoUsuario = Gui.menuConvidadoOpcoes();

        }
        System.out.println("Menu Fechado");
        return true;
    }

    private boolean menuConvidadoInserirEscolhaLoop(int opcaoUsuario) {
        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    Pessoas p = Gui.CriarPessoa();
                    Long idPessoaADD = PessoasDao.adiciona(p);

                    if (idPessoaADD != -1) {
                        Gui.mostrarMensagemAviso("Pessoa Criada", "Aviso", 1);

                        Gui.mostrarMensagemAviso("Agora insira as informações do Convidado", "Aviso", 1);
                        if (ConvidadoIndividualDao.adiciona(Gui.CriarConvidadoIndividual(PessoasDao.buscar(idPessoaADD))) != -1) {
                            Gui.mostrarMensagemAviso("Convidado Criado", "Aviso", 1);
                        } else {
                            Gui.mostrarMensagemAviso("Erro ao Criar Convidado ", "Aviso", 2);
                        }
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Criar Pessoa", "Aviso", 2);
                    }
                    break;

                case 1:

                    List<Long> idsPessoasSemConvite = new ArrayList();

                    String StringPessoasSemConvite = "";
                    int j = 0;
                    for (Pessoas pessoa : PessoasDao.listar()) {

                        boolean PessoaEhconvidado = false;

                        for (ConvidadoIndividual ci : ConvidadoIndividualDao.listar()) {
                            if (ci.getPessoa() != null && ci.getPessoa().getId() == pessoa.getId()) {
                                PessoaEhconvidado = true;
                            }
                        }
                        if (!PessoaEhconvidado) {
                            idsPessoasSemConvite.add(pessoa.getId());
                            StringPessoasSemConvite += PessoasDao.buscar(pessoa.getId()).toString();
                            j++;
                        }
                    }

                    boolean verificacao = false;
                    int option;
                    while (verificacao != true) {
                        String resp = Gui.mostrarMensagemInput("Qual Pessoa vai ser atrelado ao Convidado? digite o ID: \n" + StringPessoasSemConvite, "escolha a pessoa", 3, "1");

                        if (resp == null) {
                            return true;
                        } else {
                            option = Gui.validarStringToInt(resp);
                        }

                        for (Long pessoa : idsPessoasSemConvite) {
                            if (pessoa == option && option != 0) {
                                verificacao = true;
                            }
                        }

                        if (verificacao == true) {
                            Pessoas p2 = PessoasDao.buscar(option);

                            if (ConvidadoIndividualDao.adiciona(Gui.CriarConvidadoIndividual(p2)) != -1) {
                                Gui.mostrarMensagemAviso("Convidado Criado", "Aviso", 1);
                            } else {
                                Gui.mostrarMensagemAviso("Erro ao Criar Convidado ", "Aviso", 2);
                            }

                        } else {
                            Gui.mostrarMensagemAviso("ID invalido", "Aviso", 2);
                        }

                    }

                    break;
                case -1:
                    return false;
                default:
                    Gui.mostrarMensagemAviso("Escolha uma opcao valida !!", "Aviso", 2);
                    break;
            }
            return true;
        }
        System.out.println("Menu Fechado");
        return true;
    }

    private boolean menuEventoLoop(int opcaoUsuario) {
        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    boolean criarNovasPessoas = false;

                    //se vetor tem 2 pessoas pelo menos
                    if (PessoasDao.listar().size() > 1) {

                        Object[] options = {"Criar Pessoas", "Escolher pessoas"};
                        int resposta = Gui.mostrarMensagemBots("Voce precisa criar pessoas referente a noivo e noiva oque voce prefere?", "Menu Calendario", -1, options);
                        if (resposta == 0) {
                            criarNovasPessoas = true;
                            break;
                        } else {
                            boolean verificacao = false;
                            int optionNoivo;
                            int optionNoiva;
                            while (verificacao != true) {
                                String respNoivo = Gui.mostrarMensagemInput("Qual Pessoa vai ser atrelado ao Noivo? digite o ID: \n" + Util.ListToString(PessoasDao.listar()), "escolha a pessoa", 3, "1");
                                String respNoiva = Gui.mostrarMensagemInput("Qual Pessoa vai ser atrelado a Noiva? digite o ID: \n" + Util.ListToString(PessoasDao.listar()), "escolha a pessoa", 3, "2");

                                if (respNoivo == null || respNoiva == null) {
                                    return true;
                                } else {
                                    optionNoivo = Gui.validarStringToInt(respNoivo);
                                    optionNoiva = Gui.validarStringToInt(respNoiva);
                                }

                                for (Pessoas pessoa : PessoasDao.listar()) {
                                    if (pessoa.getId() == optionNoivo && optionNoivo != -1) {
                                        verificacao = true;
                                    }
                                    if (pessoa.getId() == optionNoiva && optionNoiva != -1) {
                                        verificacao = true;
                                    }
                                    if (optionNoiva == optionNoivo) {
                                        verificacao = false;
                                    }
                                }

                                if (verificacao == true) {
                                    Pessoas pNoivo = PessoasDao.buscar(optionNoivo);
                                    Pessoas pNoiva = PessoasDao.buscar(optionNoiva);

                                    boolean erro = false;
                                    long IDCerimonial = CerimonialDao.adiciona(Gui.criarCerimonial());
                                    if (IDCerimonial != -1) {
                                        Gui.mostrarMensagemAviso("Cerimonial Criado", "Aviso", 1);
                                    } else {
                                        erro = true;
                                        Gui.mostrarMensagemAviso("Erro ao Criar Cerimonial", "Aviso", 2);
                                    }
                                    long IDIgreja = IgrejaDao.adiciona(Gui.criarIgreja());
                                    if (IDIgreja != -1) {
                                        Gui.mostrarMensagemAviso("Igreja Criado", "Aviso", 1);
                                    } else {
                                        erro = true;
                                        Gui.mostrarMensagemAviso("Erro ao Criar Igreja", "Aviso", 2);
                                    }
                                    long IDCartorio = CartorioDao.adiciona(Gui.criarCartorio());
                                    if (IDCartorio != -1) {
                                        Gui.mostrarMensagemAviso("Cartorio Cartorio", "Aviso", 1);
                                    } else {
                                        erro = true;
                                        Gui.mostrarMensagemAviso("Erro ao Criar Cartorio", "Aviso", 2);
                                    }

                                    if (erro == true) {
                                        Gui.mostrarMensagemAviso("Erro ao Criar Evento", "Aviso", 2);
                                        break;
                                    }

                                    Evento evento = Gui.CriarEvento(pNoivo, pNoiva, CerimonialDao.buscar(IDCerimonial),
                                            IgrejaDao.buscar(IDIgreja), CartorioDao.buscar(IDCartorio));
                                    if (EventoDao.adiciona(evento) != -1) {
                                        Gui.mostrarMensagemAviso("Evento Criado", "Aviso", 1);
                                    } else {
                                        Gui.mostrarMensagemAviso("Erro ao Criar Evento", "Aviso", 2);
                                    }

                                } else {
                                    Gui.mostrarMensagemAviso("Algum dos IDs está invalido", "Aviso", 2);
                                }

                            }
                        }

                    } else {
                        criarNovasPessoas = true;
                    }
                    if (criarNovasPessoas == true) {

                        Gui.mostrarMensagemAviso("Poucas ou Nenhuma pessoa cadastradas preencha os dados das pessoas referentes ao noivo e noiva", "Aviso", 2);
                        Gui.mostrarMensagemAviso("Primeiro insira a pessoa referente ao noivo", "Aviso", 1);
                        Pessoas pNoivo = Gui.CriarPessoa();
                        Long idPessoaNoivoADD = PessoasDao.adiciona(pNoivo);
                        if (idPessoaNoivoADD != -1) {
                            Gui.mostrarMensagemAviso("Pessoa referente ao noivo Criado", "Aviso", 1);
                            Gui.mostrarMensagemAviso("Agora insira a pessoa refente a noiva", "Aviso", 1);
                            Pessoas pNoiva = Gui.CriarPessoa();
                            Long idPessoaNoivaADD = PessoasDao.adiciona(pNoiva);
                            if (idPessoaNoivaADD != -1) {
                                Gui.mostrarMensagemAviso("Pessoa referente ao noiva Criada", "Aviso", 1);

                                boolean erro = false;
                                long IDCerimonial = CerimonialDao.adiciona(Gui.criarCerimonial());
                                if (IDCerimonial != -1) {
                                    Gui.mostrarMensagemAviso("Cerimonial Criado", "Aviso", 1);
                                } else {
                                    erro = true;
                                    Gui.mostrarMensagemAviso("Erro ao Criar Cerimonial", "Aviso", 2);
                                }
                                long IDIgreja = IgrejaDao.adiciona(Gui.criarIgreja());
                                if (IDIgreja != -1) {
                                    Gui.mostrarMensagemAviso("Igreja Criado", "Aviso", 1);
                                } else {
                                    erro = true;
                                    Gui.mostrarMensagemAviso("Erro ao Criar Igreja", "Aviso", 2);
                                }
                                long IDCartorio = CartorioDao.adiciona(Gui.criarCartorio());
                                if (IDCartorio != -1) {
                                    Gui.mostrarMensagemAviso("Cartorio Criado", "Aviso", 1);
                                } else {
                                    erro = true;
                                    Gui.mostrarMensagemAviso("Erro ao Criar Cartorio", "Aviso", 2);
                                }

                                if (erro == true) {
                                    Gui.mostrarMensagemAviso("Erro ao Criar Evento", "Aviso", 2);
                                    break;
                                }

                                Evento evento = Gui.CriarEvento(PessoasDao.buscar(idPessoaNoivoADD), PessoasDao.buscar(idPessoaNoivaADD), CerimonialDao.buscar(IDCerimonial),
                                        IgrejaDao.buscar(IDIgreja), CartorioDao.buscar(IDCartorio));
                                if (EventoDao.adiciona(evento) != -1) {
                                    Gui.mostrarMensagemAviso("Evento Criado", "Aviso", 1);
                                } else {
                                    Gui.mostrarMensagemAviso("Erro ao Criar Evento", "Aviso", 2);
                                }

                            }
                        } else {
                            Gui.mostrarMensagemAviso("Erro ao Criar Pessoa", "Aviso", 2);
                        }
                    }
                    break;

                case 1:
                    List<Evento> listaEventos = EventoDao.listar();
                    if (!listaEventos.isEmpty()) {
                        Gui.mostrarMensagemAviso("Eventos : \n" + Util.ListToString(listaEventos), "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Nenhum evento cadastrado", "Aviso", 2);
                    }
                    break;
                case 2:
                    int idAltera = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID de um Evento a ser alterado", "Alterar Evento", 1, "1"));
                    Evento Evento = EventoDao.buscar(idAltera);
                    if (Evento != null && EventoDao.alterar(idAltera, Gui.CriarEvento(Evento.getNoivo(), Evento.getNoiva(),
                            Evento.getCerimonial(), Evento.getIgreja(), Evento.getCartorio())) != false) {
                        Gui.mostrarMensagemAviso("Evento Alterado", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Alterar Evento", "Aviso", 2);
                    }
                    break;

                case 3:
                    int idDelete = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID do Evento a ser deletado", "Deletar Evento", 1, "1"));
                    if (EventoDao.deletar(idDelete) != null) {
                        Gui.mostrarMensagemAviso("Evento Deletado", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Deletar Evento", "Aviso", 2);
                    }
                    break;
                case 4:
                    int idBuscar = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID do Evento a ser buscado", "Buscar Evento", 1, "1"));
                    if (EventoDao.buscar(idBuscar) != null) {
                        Gui.mostrarMensagemAviso("Evento : \n" + EventoDao.buscar(idBuscar).toString(), "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Evento não encontrado", "Aviso", 2);
                    }
                    break;
                case -1:
                    return false;
                default:
                    Gui.mostrarMensagemAviso("Escolha uma opcao valida !!", "Aviso", 2);
                    break;
            }

            opcaoUsuario = Gui.menuEventoOpcoes();

        }
        System.out.println("Menu Fechado");
        return true;
    }

    private boolean menuMuralDeRecadosLoop(int opcaoUsuario) {
        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    if (!PessoasDao.listar().isEmpty()) {
                        if (!menuMuralDeRecadosEscolhaInserirLoop(Gui.menuMuralDeRecadosEscolhaInserirOpcoes())) {
                            return false;
                        }
                    } else {
                        Gui.mostrarMensagemAviso("Nenhuma pessoa cadastrada!! insira as informações da pessoa que deixará o recado", "Aviso", 1);
                        Pessoas p = Gui.CriarPessoa();
                        Long idPessoaADD = PessoasDao.adiciona(p);
                        if (idPessoaADD != -1) {
                            Gui.mostrarMensagemAviso("Pessoa Criada", "Aviso", 1);

                            Gui.mostrarMensagemAviso("Agora insira seu recado", "Aviso", 1);
                            if (MuralDeRecadosDao.adiciona(Gui.CriarRecado(PessoasDao.buscar(idPessoaADD))) != -1) {
                                Gui.mostrarMensagemAviso("Recado Criado", "Aviso", 1);
                            } else {
                                Gui.mostrarMensagemAviso("Erro ao Criar Recado", "Aviso", 2);
                            }
                        } else {
                            Gui.mostrarMensagemAviso("Erro ao Criar Pessoa", "Aviso", 2);
                        }
                    }

                    break;
                case 1:
                    List<MuralDeRecados> listaMuralDeRecados = MuralDeRecadosDao.listar();

                    if (!listaMuralDeRecados.isEmpty()) {
                        Gui.mostrarMensagemAviso("Recados : \n" + Util.ListToString(listaMuralDeRecados), "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Não há registro de recados", "Aviso", 2);
                    }
                    break;
                case 2:
                    int idAltera = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID de um Recado a ser alterado", "Alterar Recado", 1, "1"));
                    MuralDeRecados MuralDR = MuralDeRecadosDao.buscar(idAltera);
                    if (MuralDR != null && MuralDeRecadosDao.alterar(idAltera, Gui.CriarRecado(MuralDR.getPessoa())) != false) {
                        Gui.mostrarMensagemAviso("Recado Alterado", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Alterar Recado", "Aviso", 2);
                    }
                    break;

                case 3:
                    int idDelete = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID do Recado a ser deletado", "Deletar Recado", 1, "1"));
                    if (MuralDeRecadosDao.deletar(idDelete) != null) {
                        Gui.mostrarMensagemAviso("Recado Deletado", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Deletar Recado", "Aviso", 2);
                    }
                    break;
                case 4:
                    int idBuscar = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID do Recado a ser buscado", "Buscar Recado", 1, "1"));
                    if (MuralDeRecadosDao.buscar(idBuscar) != null) {
                        Gui.mostrarMensagemAviso("Recado : \n" + MuralDeRecadosDao.buscar(idBuscar).toString(), "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Recado não encontrado", "Aviso", 2);
                    }
                    break;
                case -1:
                    return false;
                default:
                    Gui.mostrarMensagemAviso("Escolha uma opcao valida !!", "Aviso", 2);
                    break;
            }

            opcaoUsuario = Gui.menuMuralDeRecadosOpcoes();

        }
        System.out.println("Menu Fechado");
        return true;
    }

    private boolean menuMuralDeRecadosEscolhaInserirLoop(int opcaoUsuario) {
        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    Pessoas p = Gui.CriarPessoa();
                    Long idPessoaADD = PessoasDao.adiciona(p);
                    if (idPessoaADD != -1) {
                        Gui.mostrarMensagemAviso("Pessoa Criada", "Aviso", 1);

                        Gui.mostrarMensagemAviso("Agora insira seu recado", "Aviso", 1);
                        if (MuralDeRecadosDao.adiciona(Gui.CriarRecado(PessoasDao.buscar(idPessoaADD))) != -1) {
                            Gui.mostrarMensagemAviso("Recado Criado", "Aviso", 1);
                        } else {
                            Gui.mostrarMensagemAviso("Erro ao Criar Recado", "Aviso", 2);
                        }
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Criar Pessoa", "Aviso", 2);
                    }

                    break;
                case 1:
                    String resp = Gui.mostrarMensagemInput("Qual pessoa vai ser o autor do recado?  digite o ID: \n" + Util.ListToString(PessoasDao.listar()), "escolha a pessoa", 3, "1");
                    int option;
                    if (resp == null) {
                        return true;
                    } else {
                        option = Gui.validarStringToInt(resp);
                    }
                    p = PessoasDao.buscar(option);
                    if (p != null) {

                        Gui.mostrarMensagemAviso("Agora insira seu recado", "Aviso", 1);
                        if (MuralDeRecadosDao.adiciona(Gui.CriarRecado(p)) != -1) {
                            Gui.mostrarMensagemAviso("Recado Criado", "Aviso", 1);
                        } else {
                            Gui.mostrarMensagemAviso("Erro ao Criar Recado", "Aviso", 2);
                        }

                    } else {
                        Gui.mostrarMensagemAviso("ID invalido", "Aviso", 2);
                    }

                    break;
                case -1:
                    return false;
                default:
                    Gui.mostrarMensagemAviso("Escolha uma opcao valida !!", "Aviso", 2);
                    break;
            }

            return true;

        }
        System.out.println("Menu Fechado");
        return true;
    }

    private boolean menuPagamentoLoop(int opcaoUsuario) {
        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:

                    // caso não tenha nenhum fornecedor cadastrado
                    if (FornecedorDao.listar().isEmpty()) {

                        if (PessoasDao.listar().isEmpty()) {
                            Gui.mostrarMensagemAviso("Nenhum fornecedor cadastrado insira as informações do Fornecedor incluindo a pessoa atrelada a esse fornecedor referente a esse Pagamento", "Aviso", 1);
                            if (!menuFornecedorInserirEscolhaLoop(0)) {
                                return false;
                            }
                        } else {
                            Gui.mostrarMensagemAviso("Nenhum fornecedor cadastrado insira as informações do Fornecedor referente a esse Pagamento", "Aviso", 1);
                            if (!menuFornecedorInserirEscolhaLoop(1)) {
                                return false;
                            }
                        }

                        if (!menuPagamentoInserirEscolhaLoop(Gui.menuPagamentoInserirEscolhaOpcoes())) {
                            return false;
                        }

                    } else { // caso tenha vai para a escolha de criar um forneceodr ou escolher um existente
                        if (!menuPagamentoInserirEscolhaLoop(Gui.menuPagamentoInserirEscolhaOpcoes())) {
                            return false;
                        }
                    }

                    break;
                case 1:
                    List<Pagamentos> listaPagamentos = PagamentosDao.listar();

                    if (!listaPagamentos.isEmpty()) {
                        Gui.mostrarMensagemAviso("Pagamentos : \n" + Util.ListToString(listaPagamentos), "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Nenhum pagamento cadastrado", "Aviso", 2);
                    }
                    break;
                case 2:
                    int idAltera = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID de um Pagamento a ser alterado", "Alterar Pagamento", 1, "1"));
                    Pagamentos Pagamentos = PagamentosDao.buscar(idAltera);
                    if (Pagamentos != null && PagamentosDao.alterar(idAltera, Gui.CriarPagamento(Pagamentos.getFornecedor(), Pagamentos.getPessoa())) != false) {
                        Gui.mostrarMensagemAviso("Pagamento Alterado", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Aterar o Pagamento", "Aviso", 2);
                    }
                    break;

                case 3:
                    int idDelete = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID do Pagamento a ser deletado", "Deletar Pagamento", 1, "1"));
                    if (PagamentosDao.deletar(idDelete) != null) {
                        Gui.mostrarMensagemAviso("Pagamento Deletado", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Deletar Pagamento", "Aviso", 2);
                    }
                    break;
                case 4:
                    int idBuscar = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID do Pagamento a ser buscado", "Buscar Pagamento", 1, "1"));
                    if (PagamentosDao.buscar(idBuscar) != null) {
                        Gui.mostrarMensagemAviso("Pagamento : \n" + PagamentosDao.buscar(idBuscar).toString(), "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Pagamento não encontrado", "Aviso", 2);
                    }

                    break;
                case -1:
                    return false;
                default:
                    Gui.mostrarMensagemAviso("Escolha uma opcao valida !!", "Aviso", 2);
                    break;
            }

            opcaoUsuario = Gui.menuPagamentoOpcoes();

        }
        System.out.println("Menu Fechado");
        return true;
    }

    private boolean menuPagamentoInserirEscolhaLoop(int opcaoUsuario) {
        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    List<Long> idsFornecedoresSemPagamento = new ArrayList();

                    String stringFornecedoresComValorAPagar = "";
                    int j = 0;

                    for (Fornecedor f : FornecedorDao.listar()) {
                        if (f.getEstado().equals("A pagar")) {
                            stringFornecedoresComValorAPagar += FornecedorDao.buscar(f.getId());
                            idsFornecedoresSemPagamento.add(f.getId());
                            j++;
                        }
                    }

                    if (!stringFornecedoresComValorAPagar.equals("")) {
                        boolean verificacao = false;
                        int optionFornecedor;
                        while (verificacao != true) {
                            String resp = Gui.mostrarMensagemInput("Qual Fornecedor Sera pago? Digite o ID:\n" + stringFornecedoresComValorAPagar, "Opções", 1, "1");

                            if (resp == null) {
                                return true;
                            } else {
                                optionFornecedor = Gui.validarStringToInt(resp);
                            }

                            for (Long fornecedores : idsFornecedoresSemPagamento) {
                                if (fornecedores == optionFornecedor && optionFornecedor != 0) {
                                    verificacao = true;
                                }
                            }

                            if (verificacao == true) {

                                Pessoas pessoa = null;
                                boolean verificacao1 = false;
                                int optionPessoa = 0;
                                if (!PessoasDao.listar().isEmpty()) {
                                    while (verificacao1 != true) {
                                        resp = Gui.mostrarMensagemInput("Qual pessoa será atrelada ao pagamento ? Digite o ID:\n" + Util.ListToString(PessoasDao.listar()), "Opções", 1, "1");

                                        if (resp == null) {
                                            return true;
                                        } else {
                                            optionPessoa = Gui.validarStringToInt(resp);
                                        }

                                        for (Pessoas p : PessoasDao.listar()) {
                                            if (p.getId() == optionPessoa && optionPessoa != -1) {
                                                verificacao1 = true;
                                            }
                                        }
                                        if (verificacao1 == true) {
                                            pessoa = PessoasDao.buscar(optionPessoa);
                                            break;
                                        } else {
                                            Gui.mostrarMensagemAviso("ID invalido", "Aviso", 1);
                                        }
                                    }
                                } else {
                                    Gui.mostrarMensagemAviso("Nenhuma pessoa cadastrada insira as informações da pessoa referente a esse Pagamento", "Aviso", 1);
                                    pessoa = Gui.CriarPessoa();
                                    Long idPessoaADD = PessoasDao.adiciona(pessoa);
                                    if (idPessoaADD != -1) {
                                        Gui.mostrarMensagemAviso("Pessoa Criada", "Aviso", 1);
                                        pessoa = PessoasDao.buscar(idPessoaADD);
                                    } else {
                                        Gui.mostrarMensagemAviso("Erro ao Criar Pessoa", "Aviso", 2);
                                    }
                                }

                                Fornecedor fornecedorSelecionado = FornecedorDao.buscar(optionFornecedor);
                                Pagamentos pagamentoDoFornecedor = Gui.CriarPagamento(fornecedorSelecionado, pessoa);

                                if (pagamentoDoFornecedor.getAgendado() == false) {
                                    pagar(pagamentoDoFornecedor, fornecedorSelecionado);
                                } else {
                                    //programa monitora no calendario os pagamentos com estado "Vai pagar" e aciona a função pagar na data prevista
                                    fornecedorSelecionado.setEstado("Vai pagar");
                                }

                                FornecedorDao.alterar(fornecedorSelecionado.getId(), fornecedorSelecionado);

                                if (PagamentosDao.adiciona(pagamentoDoFornecedor) != -1) {
                                    Gui.mostrarMensagemAviso("Pagamento Criado", "Aviso", 1);
                                } else {
                                    Gui.mostrarMensagemAviso("Erro ao Criar Pagamento", "Aviso", 2);
                                }

                            } else {
                                Gui.mostrarMensagemAviso("Id invalido", "Aviso", 1);

                            }

                        }
                    } else {
                        Gui.mostrarMensagemAviso("Todos os fornecedores já foram pagos !!", "Aviso", 1);
                    }
                    break;
                case 1:

                    if (PessoasDao.listar().isEmpty()) {
                        Gui.mostrarMensagemAviso("Nenhum fornecedor cadastrado insira as informações do Fornecedor incluindo a pessoa atrelada a esse fornecedor referente a esse Pagamento", "Aviso", 1);
                        if (!menuFornecedorInserirEscolhaLoop(0)) {
                            return false;
                        }
                    } else {
                        Gui.mostrarMensagemAviso("Nenhum fornecedor cadastrado insira as informações do Fornecedor referente a esse Pagamento", "Aviso", 1);
                        if (!menuFornecedorInserirEscolhaLoop(1)) {
                            return false;
                        }
                    }

                    break;

                case -1:
                    return false;
            }
            return true;
        }
        System.out.println("Menu Fechado");
        return true;
    }

    private void pagar(Pagamentos pagamentoDoFornecedor, Fornecedor fornecedorSelecionado) {
        System.out.println(fornecedorSelecionado.getParcelas());
        System.out.println(fornecedorSelecionado.getParcelaAtual());

        // 100 / 4 = 25 
        pagamentoDoFornecedor.setValor(fornecedorSelecionado.getValorOriginalAPagar() / fornecedorSelecionado.getParcelas());

        if (fornecedorSelecionado.getParcelaAtual() + 1 < fornecedorSelecionado.getParcelas()) {

            //ex: pagamento de 100 com 4 parcelas
            // 1, 2, 3
            fornecedorSelecionado.setParcelaAtual(fornecedorSelecionado.getParcelaAtual() + 1);
            // 100 - 25 * 1 = 75,     100 - 25 * 2 = 50,      100 - 25 * 3 = 25
            fornecedorSelecionado.setValorAPagar(fornecedorSelecionado.getValorOriginalAPagar() - (pagamentoDoFornecedor.getValor() * fornecedorSelecionado.getParcelaAtual()));
            // 25 * 1 = 25,     25 * 2 = 50,    25 * 3 = 75
            fornecedorSelecionado.setValorPago(pagamentoDoFornecedor.getValor() * fornecedorSelecionado.getParcelaAtual());

            pagamentoDoFornecedor.setParcela(fornecedorSelecionado.getParcelaAtual());
        } else {
            fornecedorSelecionado.setEstado("Pago");
            pagamentoDoFornecedor.setParcela(fornecedorSelecionado.getParcelas());
            fornecedorSelecionado.setParcelaAtual(fornecedorSelecionado.getParcelas());
            fornecedorSelecionado.setValorPago(fornecedorSelecionado.getValorOriginalAPagar());
            fornecedorSelecionado.setValorAPagar(0);

        }

    }

    private boolean menuPresenteLoop(int opcaoUsuario) {
        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    int resposta = 1;
                    if (!PessoasDao.listar().isEmpty()) {
                        Object[] options = {"Sim", "Não"};
                        resposta = Gui.mostrarMensagemBots("Voce deseja atrelar uma pessoa a esse presente?", "Opção presente", -1, options);
                    }

                    if (resposta == 0) {
                        int idresposta = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID da pessoa que esta presenteando:\n" + Util.ListToString(PessoasDao.listar()), "Pessoa Presente", 1, "1"));
                        Pessoas PessoaBusca = PessoasDao.buscar(idresposta);
                        if (PessoaBusca != null) {
                            if (PresentesDao.adiciona(Gui.CriarPresente(PessoaBusca)) != -1) {
                                Gui.mostrarMensagemAviso("Presente Criado", "Aviso", 1);
                            } else {
                                Gui.mostrarMensagemAviso("Erro ao Criar Presente", "Aviso", 2);
                            }
                        } else {
                            Gui.mostrarMensagemAviso("ID invalido", "Aviso", 2);
                        }
                    } else if (resposta == 1) {
                        if (PresentesDao.adiciona(Gui.CriarPresente(null)) != -1) {
                            Gui.mostrarMensagemAviso("Presente Criado", "Aviso", 1);
                        } else {
                            Gui.mostrarMensagemAviso("Erro ao Criar Presente", "Aviso", 2);
                        }
                    }
                    break;
                case 1:
                    List<Presentes> listaPresentes = PresentesDao.listar();
                    if (!listaPresentes.isEmpty()) {
                        Gui.mostrarMensagemAviso("Presentes : \n" + Util.ListToString(listaPresentes), "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Nenhum Presente cadastrado", "Aviso", 2);
                    }
                    break;
                case 2:
                    int idAltera = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID de um Presente a ser alterado", "Alterar Presente", 1, "1"));
                    int idresposta = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID da pessoa que esta presenteando: (deixe vazio caso não queira alterar)\n" + PessoasDao.listar().toString(), "Alterar Presente", 1, ""));
                    Pessoas pessoa = PessoasDao.buscar(idresposta);
                    Presentes presente = PresentesDao.buscar(idAltera);
                    if (pessoa != null) {
                        if (PresentesDao.alterar(idAltera, Gui.CriarPresente(pessoa)) != false) {
                            Gui.mostrarMensagemAviso("Presente Alterado", "Aviso", 1);
                        } else {
                            Gui.mostrarMensagemAviso("Erro ao Alterar Presente", "Aviso", 2);
                        }
                    } else {
                        if (presente != null
                                && PresentesDao.alterar(idAltera, Gui.CriarPresente(presente.getPessoa())) != false) {
                            Gui.mostrarMensagemAviso("Presente Alterado", "Aviso", 1);
                        } else {
                            Gui.mostrarMensagemAviso("Erro ao Alterar Presente", "Aviso", 2);
                        }
                    }

                    break;

                case 3:
                    int idDelete = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID do Presente a ser deletado", "Deletar Presente", 1, "1"));
                    if (PresentesDao.deletar(idDelete) != null) {
                        Gui.mostrarMensagemAviso("Presente Deletado", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Deletar Presente", "Aviso", 2);
                    }

                    break;
                case 4:
                    int idBuscar = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID do Presente a ser buscado", "Recado Presente", 1, "1"));
                    if (PresentesDao.buscar(idBuscar) != null) {
                        Gui.mostrarMensagemAviso("Presente : \n" + PresentesDao.buscar(idBuscar).toString(), "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Presente não encontrado", "Aviso", 2);
                    }

                    break;
                case 5:
                    if (!PessoasDao.listar().isEmpty()) {
                        idresposta = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID da pessoa que esta presenteando: \n" + Util.ListToString(PessoasDao.listar()), "Escolha a pessoa", 1, "1"));
                        int idPresente = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID de um Presente a ser atrelado a pessoa \n" + Util.ListToString(PresentesDao.listar()), "Presentear", 1, "1"));

                        Presentes p = PresentesDao.buscar(idPresente);
                        Pessoas pessoa2 = PessoasDao.buscar(idresposta);
                        if (p != null && pessoa2 != null) {
                            p.setPessoa(pessoa2);
                            PresentesDao.alterar(idPresente, p);
                            Gui.mostrarMensagemAviso("Presenteado com sucesso.", "Aviso", 1);
                        } else {
                            Gui.mostrarMensagemAviso("ID invalido", "Aviso", 2);
                        }

                    } else {
                        Gui.mostrarMensagemAviso("Nenhuma pessoa disponivel para presentar", "Aviso", 2);
                    }
                    break;
                case -1:
                    return false;
                default:
                    Gui.mostrarMensagemAviso("Escolha uma opcao valida !!", "Aviso", 2);
                    break;
            }

            opcaoUsuario = Gui.menuPresenteOpcoes();

        }
        System.out.println("Menu Fechado");
        return true;
    }

    private boolean menuRelatoriosLoop(int opcaoUsuario) {

        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    List<MuralDeRecados> listar = MuralDeRecadosDao.listar();
                    if (!listar.isEmpty()) {

                        String ConjuntoDados = "";
                        List<String> conteudoMr = new ArrayList();

                        for (MuralDeRecados mr : listar) {

                            ConjuntoDados += "ID: ";
                            ConjuntoDados += mr.getId();
                            ConjuntoDados += " | Nome: ";
                            ConjuntoDados += mr.getPessoa().getNome();
                            ConjuntoDados += " | Comentário: ";
                            ConjuntoDados += mr.getComentario();
                            ConjuntoDados += " | Data de Criação: ";
                            ConjuntoDados += Util.formatarData(mr.getDataCriacao());
                            ConjuntoDados += " | Última Modificação: ";
                            ConjuntoDados += Util.formatarData(mr.getDataModificacao());

                            conteudoMr.add(ConjuntoDados);
                            ConjuntoDados = "";
                        }

                        if (Gui.RelatorioRecados(conteudoMr) == 1) {
                            String resposta = GeradorPdf.GerarPdf((List) listar, "MuralDeRecados");
                            if (!resposta.isBlank()) {
                                Gui.mostrarMensagemAviso("Pdf gerado com sucesso \nem: " + resposta, "Aviso", 2);
                            } else {
                                Gui.mostrarMensagemAviso("Erro ao gerar pdf", "Aviso", 2);
                            }
                        }

                    } else {
                        Gui.mostrarMensagemAviso("Nenhum recado cadastrado", "Aviso", 2);
                    }
                    break;

                case 1:
                    List<ConvidadoIndividual> listaConvidadoIndividual = ConvidadoIndividualDao.listar();
                    if (!listaConvidadoIndividual.isEmpty()) {
                        boolean verificacao = false;
                        int option;
                        while (!verificacao) {
                            String resp = Gui.mostrarMensagemInput(
                                    "Qual convidado você gostaria de gerar o convite? Digite o ID: \n"
                                    + Util.ListToString(listaConvidadoIndividual),
                                    "Escolha um Convidado",
                                    3,
                                    "1"
                            );

                            if (resp == null) {
                                return true;
                            } else {
                                option = Gui.validarStringToInt(resp);
                            }

                            ConvidadoIndividual convidado = ConvidadoIndividualDao.buscar(option);
                            if (convidado != null) {
                                verificacao = true;

                                if (Gui.mostrarConviteIndividual(ConvidadoIndividualDao.buscar(option)) == 1) {

                                    List<String> conteudo = new ArrayList<>();

                                    conteudo.add("-------------------------------------------");
                                    conteudo.add("Convite para: " + convidado.getPessoa().getNome());
                                    conteudo.add("Telefone: " + convidado.getPessoa().getTelefone());
                                    conteudo.add("Nascimento: " + Util.formatarDataLocal(convidado.getPessoa().getNascimento()));
                                    conteudo.add("Família: " + convidado.getFamilia());
                                    conteudo.add("Parentesco: " + convidado.getParentesco());
                                    conteudo.add("Confirmação de presença: " + convidado.getConfirmacao());
                                    conteudo.add("Data de Criação: " + Util.formatarData(convidado.getDataCriacao()));
                                    conteudo.add("Última Modificação: " + Util.formatarData(convidado.getDataModificacao()));

                                    GeradorPdf.gerarPdf("Convite Convidado Individual", conteudo, "ConviteIndividual" + convidado.getPessoa().getNome() + ".pdf");
                                    System.out.println("Convite PDF gerado para o convidado " + convidado.getPessoa().getNome());
                                }
                            } else {
                                Gui.mostrarMensagemAviso("ID inválido", "Aviso", 1);
                            }
                        }
                    } else {
                        Gui.mostrarMensagemAviso("Nenhum convidado cadastrado", "Aviso", 2);
                    }
                    break;

                case 2:
                    List<ConvidadoFamilia> listaConvidadoFamilia = ConvidadoFamiliaDao.listar();
                    boolean verificacao = false;
                    int option;
                    while (verificacao != true) {
                        String resp = Gui.mostrarMensagemInput("Qual família você gostaria de Gerar o convite? digite o ID: \n" + Util.ListToString(listaConvidadoFamilia), "Escolha uma Familia", 3, "1");

                        if (resp == null) {
                            return true;
                        } else {
                            option = Gui.validarStringToInt(resp);
                        }

                        for (ConvidadoFamilia cf : listaConvidadoFamilia) {
                            if (cf.getId() == option && option != -1) {
                                verificacao = true;
                            }
                        }

                        if (verificacao == true && Gui.mostrarConviteFamilia(ConvidadoFamiliaDao.buscar(option)) == 1) {
                            List<String> conteudoFamilia = new ArrayList<>();
                            ConvidadoFamilia familia = ConvidadoFamiliaDao.buscar(option);

                            conteudoFamilia.add("Família: " + familia.getNomeDaFamilia());
                            conteudoFamilia.add("Descrição: " + familia.toString());

                            GeradorPdf.gerarPdf("Convite Família", conteudoFamilia, "ConviteFamilia" + familia.getNomeDaFamilia());

                            System.out.println("Função gerar pdf Convidado Familia");
                        } else {
                            Gui.mostrarMensagemAviso("ID invalido", "Aviso", 1);
                        }
                    }
                    break;

                case 3:
                    List<Pagamentos> listaPagamentos = PagamentosDao.listar();
                    if (!listaPagamentos.isEmpty()) {

                        String ConjuntoDados = "";
                        List<String> conteudoP = new ArrayList();

                        double valorTotal = 0;
                        for (Pagamentos p : listaPagamentos) {

                            ConjuntoDados += "ID: ";
                            ConjuntoDados += p.getId();
                            ConjuntoDados += " | Nome: ";
                            ConjuntoDados += p.getPessoa().getNome();
                            ConjuntoDados += " | Descrição: ";
                            ConjuntoDados += p.getDescricao();
                            ConjuntoDados += " | Valor: ";
                            ConjuntoDados += p.getValor();
                            ConjuntoDados += " | Parcelas: ";
                            ConjuntoDados += p.getParcela();

                            conteudoP.add(ConjuntoDados);
                            ConjuntoDados = "";
                            valorTotal += p.getValor();
                        }

                        if (Gui.RelatorioPagamento(conteudoP, valorTotal) == 1) {
                            System.out.println("Função gerar pdf Pagamento");
                        }
                    } else {
                        Gui.mostrarMensagemAviso("Nenhum pagamento cadastrado", "Aviso", 2);
                    }

                    break;
                case 4:
                    listaConvidadoIndividual = ConvidadoIndividualDao.listar();
                    if (!listaConvidadoIndividual.isEmpty()) {

                        String ConjuntoDados = "";
                        List<String> conteudoC = new ArrayList();

                        for (ConvidadoIndividual ci : listaConvidadoIndividual) {

                            ConjuntoDados += "ID: ";
                            ConjuntoDados += ci.getId();
                            ConjuntoDados += " | Nome: ";
                            ConjuntoDados += ci.getPessoa().getNome();
                            ConjuntoDados += " | Data de Nascimento: ";
                            ConjuntoDados += Util.formatarDataLocal(ci.getPessoa().getNascimento());
                            ConjuntoDados += " | Confirmação: ";
                            ConjuntoDados += ci.getConfirmacao();
                            ConjuntoDados += " | Família: ";
                            ConjuntoDados += ci.getFamilia();
                            ConjuntoDados += " | Parentesco: ";
                            ConjuntoDados += ci.getParentesco();
                            ConjuntoDados += "<br>Data de Criação: ";
                            ConjuntoDados += Util.formatarData(ci.getDataCriacao());
                            ConjuntoDados += " | Última Modificação: ";
                            ConjuntoDados += Util.formatarData(ci.getDataModificacao());

                            conteudoC.add(ConjuntoDados);
                            ConjuntoDados = "";
                        }

                        if (Gui.RelatorioConvidados(conteudoC) == 1) {
                            System.out.println("Função gerar pdf Convidado Individual");
                        }
                    } else {
                        Gui.mostrarMensagemAviso("Nenhum convidado cadastrado", "Aviso", 2);
                    }
                    break;
                case 5:
                    boolean temConfirmado = false;
                    for (ConvidadoIndividual c : ConvidadoIndividualDao.listar()) {
                        if (c.getConfirmacao().equals("Confirmado")) {
                            temConfirmado = true;
                            break;
                        }
                    }
                    if (temConfirmado) {

                        String ConjuntoDados = "";
                        List<String> conteudoC = new ArrayList();

                        double totalDePontos = 0;

                        for (ConvidadoIndividual ci : ConvidadoIndividualDao.listar()) {
                            int idade = Util.calcularIdade(ci.getPessoa().getNascimento());
                            boolean fornecedorEncontrado = false;
                            for (Fornecedor f : FornecedorDao.listar()) {
                                if (f.getPessoa().equals(ci.getPessoa())) {
                                    fornecedorEncontrado = true;
                                }
                            }
                            if (ci.getConfirmacao().equals("Confirmado")) {
                                double ponto = 0;

                                if (idade >= 9 && idade <= 13 || fornecedorEncontrado == true) {
                                    ponto = 0.5;
                                } else {
                                    ponto = 1;
                                }

                                ConjuntoDados += "ID: ";
                                ConjuntoDados += ci.getId();
                                ConjuntoDados += " | Nome: ";
                                ConjuntoDados += ci.getPessoa().getNome();
                                ConjuntoDados += " | Data de Nascimento: ";
                                ConjuntoDados += Util.formatarDataLocal(ci.getPessoa().getNascimento());
                                ConjuntoDados += " | Confirmação: ";
                                ConjuntoDados += ci.getConfirmacao();
                                ConjuntoDados += " | Família: ";
                                ConjuntoDados += ci.getFamilia();
                                ConjuntoDados += " | Parentesco: ";
                                ConjuntoDados += ci.getParentesco();
                                ConjuntoDados += " | Ponto eq: ";
                                ConjuntoDados += ponto;
                                ConjuntoDados += "<br>Data de Criação: ";
                                ConjuntoDados += Util.formatarData(ci.getDataCriacao());
                                ConjuntoDados += " | Última Modificação: ";
                                ConjuntoDados += Util.formatarData(ci.getDataModificacao());

                                totalDePontos += ponto;

                                conteudoC.add(ConjuntoDados);
                                ConjuntoDados = "";
                            }
                        }

                        if (Gui.RelatorioConvidadosConfirmados(conteudoC, totalDePontos) == 1) {
                            System.out.println("Função gerar pdf Convidado Individual com pontos");
                        }

                    } else {
                        Gui.mostrarMensagemAviso("Nenhum convidado confirmado cadastrado", "Aviso", 2);
                    }

                    break;
                case -1:
                    return false;
                default:
                    Gui.mostrarMensagemAviso("Escolha uma opcao valida !!", "Aviso", 2);
                    break;
            }

            opcaoUsuario = Gui.menuRelatoriosOpcoes();

        }

        System.out.println("Menu Fechado");

        return true;
    }

    private boolean menuCalendarioLoop(int opcaoUsuario) {
        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    int option = -1;
                    while (option == -1) {
                        String resp = Gui.mostrarMensagemInput("Quantos dias voce gostaria de avançar?", "Avançar dias", 3, "1");

                        if (resp == null) {
                            break;
                        } else {

                            if (Gui.validarStringToInt(resp) != -1) {
                                option = Gui.validarStringToInt(resp);
                                Util.avancarDias(option);
                                verificaPagamentosPrazo();
                                Gui.mostrarMensagemAviso("Calendario atualizado", "Aviso", 3);
                            } else {
                                Gui.mostrarMensagemAviso("Quantidade de dias invalido", "Aviso", 2);
                            }
                        }
                    }
                    break;
                case 1:
                    option = -1;
                    while (option == -1) {
                        String resp = Gui.mostrarMensagemInput("Quantos dias voce gostaria de retroceder?", "Retroceder dias", 3, "1");

                        if (resp == null) {
                            break;
                        } else {

                            if (Gui.validarStringToInt(resp) != -1) {
                                option = Gui.validarStringToInt(resp);
                                Util.retrocederDias(opcaoUsuario);
                                Gui.mostrarMensagemAviso("Calendario atualizado", "Aviso", 3);
                            } else {
                                Gui.mostrarMensagemAviso("Quantidade de dias invalido", "Aviso", 2);
                            }
                        }
                    }
                    break;
                case 2:
                    boolean validacao = false;
                    while (validacao == false) {
                        String resp = Gui.mostrarMensagemInput("Digite a data desejada", "Definir Data", 3, "10/10/2024");

                        if (resp == null) {
                            break;
                        } else {

                            if (Gui.validarData(resp) != null) {
                                validacao = true;
                                Util.setData(Gui.validarData(resp));
                                verificaPagamentosPrazo();
                                Gui.mostrarMensagemAviso("Calendario atualizado", "Aviso", 3);
                            } else {
                                Gui.mostrarMensagemAviso("Data invalida! digite nesse modelo: (dia/mes/ano)", "Aviso", 2);
                            }
                        }
                    }
                    break;
                case -1:
                    return false;
                default:
                    Gui.mostrarMensagemAviso("Escolha uma opcao valida !!", "Aviso", 2);
                    break;
            }

            opcaoUsuario = Gui.menuCalendarioOpcoes(Util.getDataAtual());

        }

        System.out.println("Menu Fechado");

        return true;
    }

    //Verifica se existe um pagamento a prazo toda vez que a data do programa é alterada
    private void verificaPagamentosPrazo() {
        List<Pagamentos> listaPagamentos = PagamentosDao.listar();
        if (!listaPagamentos.isEmpty()) {
            for (Pagamentos pagamento : listaPagamentos) {

                if (pagamento.getFornecedor().getEstado().equals("Vai pagar") && pagamento.getAgendado() == true
                        && (Util.getDataAtual().isAfter(pagamento.getData()) || Util.getDataAtual().isEqual(pagamento.getData()))) {
                    pagamento.setAgendado(false);
                    pagamento.getFornecedor().setEstado("A pagar");
                    pagar(pagamento, pagamento.getFornecedor());

                    FornecedorDao.alterar(pagamento.getFornecedor().getId(), pagamento.getFornecedor());
                    PagamentosDao.alterar(pagamento.getId(), pagamento);
                }
            }

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new SoftwareCasamento();
    }

}
