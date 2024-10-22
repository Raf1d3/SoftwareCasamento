/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import view.GUI;
import model.Pessoas;
import model.Fornecedor;
import model.ConvidadoFamilia;
import model.ConvidadoIndividual;
import model.Evento;
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

    GenericDAO<Fornecedor> FornecedorDao = new GenericDAO<>();
    GenericDAO<ConvidadoIndividual> ConvidadoIndividualDao = new GenericDAO<>();
    GenericDAO<Evento> EventoDao = new GenericDAO<>();
    GenericDAO<MuralDeRecados> MuralDeRecadosDao = new GenericDAO<>();
    GenericDAO<Pagamentos> PagamentosDao = new GenericDAO<>();
    GenericDAO<Presentes> PresentesDao = new GenericDAO<>();
    ConvidadoFamiliaDAO ConvidadoFamiliaDao = new ConvidadoFamiliaDAO();
    PessoasDAO PessoasDao = new PessoasDAO();
    UsuarioDAO UsuarioDao = new UsuarioDAO();

    public SoftwareCasamento() {
        System.out.println("Iniciando Logs do programa...");
        MenuLoginLoop(Gui.MenuLoginOpcoes());
        System.out.println("Programa finalizado...");
    }

    //menu de login e boas vindas
    private void MenuLoginLoop(int opcaoUsuario) {

        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:

                    String login = Gui.mostrarMensagemInput("Digite seu login:", "Login", 3, "admin");
                    String senha = Gui.mostrarMensagemInput("Digite sua senha:", "Senha", 3, "");
                    if (UsuarioDao.autenticar(login, senha)) {
                        System.out.println("Acessando menu Gerenciador...");
                        if (!MenuAcessoAdministradorLoop(Gui.menuAcessoAdministradorOpcoes())) {
                            return;
                        }
                    } else if (ConvidadoFamiliaDao.autenticar(login, senha)) {
                        System.out.println("Acessando menu Responsavel Familiar...");
                        if (!menuConfirmacaoFamiliaLoop(Gui.menuConfirmacaoFamiliaOpcoes())) {
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

            opcaoUsuario = Gui.MenuLoginOpcoes();

        }
        System.out.println("Menu Fechado");
    }

    /*
    //parte generica para testes
    private void menuTesteLoop(int opcaoUsuario) {

        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    Gui.mostrarMensagemAviso("Criando", "Aviso", 1);
                    break;
                case 1:
                    Gui.mostrarMensagemAviso("Mostranado", "Aviso", 1);
                    break;
                case 2:
                    Gui.mostrarMensagemAviso("Deletando", "Aviso", 1);
                    break;
                case 3:
                    Gui.mostrarMensagemAviso("Alterarando", "Aviso", 1);
                    break;
                case 4:
                    Gui.mostrarMensagemAviso("Buscando", "Aviso", 1);
                case 9:
                    Gui.mostrarMensagemAviso("Saindo", "Aviso", 1);
                    break;
                default:
                    Gui.mostrarMensagemAviso("Escolha uma opcao valida !!", "Aviso", 1);
                    break;
            }

            opcaoUsuario = Gui.menuPessoaOpcoes();

        }
        System.out.println("Menu Fechado");
    }
     */
    // Respstas do painel de convidado (sem login)
    private boolean MenuLoginConvidadoLoop(int opcaoUsuario) {

        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    Gui.mostrarMensagemAviso("Adicionando recado", "Aviso", 1);
                    break;
                case 1:
                    Gui.mostrarMensagemAviso("Dando presente", "Aviso", 1);
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

        while (opcaoUsuario != 9) {
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

    // menu pessoas
    private boolean menuPessoasLoop(int opcaoUsuario) {

        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    if (PessoasDao.inserir(Gui.CriarPessoa()) != -1) {
                        Gui.mostrarMensagemAviso("Pessoa Criada", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Inserir Pessoa", "Aviso", 2);
                    }
                    break;
                case 1:
                    if (!PessoasDao.mostrar(null).equals("")) {
                        Gui.mostrarMensagemAviso("Pessoas: \n" + PessoasDao.mostrar(null), "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Nenhuma pessoa cadastrada", "Aviso", 2);
                    }
                    break;
                case 2:
                    int idAltera = Integer.parseInt(Gui.mostrarMensagemInput("Digite o id do usuario a ser alterado", "Alterar Usuario", 1, "0"));
                    if (PessoasDao.alterar(Gui.CriarPessoa(), idAltera) != false) {
                        Gui.mostrarMensagemAviso("Pessoa Alterada", "Aviso", 3);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Alterar Pessoa", "Aviso", 2);
                    }
                    break;
                case 3:
                    int idDelete = Integer.parseInt(Gui.mostrarMensagemInput("Digite o id do usuario a ser deletado", "Deletar Usuario", 1, "0"));
                    if (PessoasDao.deletar(idDelete)) {
                        Gui.mostrarMensagemAviso("Pessoa Deletada", "Aviso", 3);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Deletar Pessoa", "Aviso", 2);
                    }
                    break;
                case 4:
                    int idBuscar = Integer.parseInt(Gui.mostrarMensagemInput("Digite o id do usuario a ser buscado", "Buscar Usuario", 1, "0"));
                    if (PessoasDao.buscar(idBuscar) != null) {
                        Gui.mostrarMensagemAviso("Pessoas : \n" + PessoasDao.mostrar(PessoasDao.buscar(idBuscar)), "Aviso", 3);

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

                    for (Pessoas pessoa : PessoasDao.GetDataBase()) {
                        boolean estaAssociada = false;

                        for (Usuario usuario : UsuarioDao.GetDataBase()) {
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
                    if (!PessoaTemUsuario || PessoasDao.mostrar(null).equals("")) {
                        Gui.mostrarMensagemAviso("Nenhuma pessoa disponivel encontrada insira informações da pessoa referente a esse usuario", "Aviso", 1);
                        Pessoas p = Gui.CriarPessoa();

                        if (PessoasDao.inserir(p) != -1) {
                            Gui.mostrarMensagemAviso("Pessoa Criada", "Aviso", 1);

                            Gui.mostrarMensagemAviso("Agora insira as informações do usuario", "Aviso", 1);
                            if (UsuarioDao.inserir(Gui.CriarUsuario(p)) != -1) {
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
                    Gui.mostrarMensagemAviso("Usuarios : \n" + UsuarioDao.mostrar(null), "Aviso", 1);
                    break;
                case 2:
                    int idAltera = Integer.parseInt(Gui.mostrarMensagemInput("Digite o id do usuario a ser alterado", "Alterar Usuario", 1, "0"));
                    UsuarioDao.alterar(Gui.CriarUsuario(null), idAltera);
                    Gui.mostrarMensagemAviso("Usuario Alterada", "Aviso", 1);
                    break;
                case 3:
                    int idDelete = Integer.parseInt(Gui.mostrarMensagemInput("Digite o id do usuario a ser deletado", "Deletar Usuario", 1, "0"));
                    if (UsuarioDao.deletar(idDelete)) {
                        Gui.mostrarMensagemAviso("Usuario Deletada", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Deletar Usuario", "Aviso", 2);
                    }

                    break;
                case 4:
                    int idBuscar = Integer.parseInt(Gui.mostrarMensagemInput("Digite o id do usuario a ser buscado", "Buscar Usuario", 1, "0"));
                    Gui.mostrarMensagemAviso("Usuario : \n" + UsuarioDao.mostrar(UsuarioDao.buscar(idBuscar)), "Aviso", 1);
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
                    if (PessoasDao.inserir(p) != -1) {
                        Gui.mostrarMensagemAviso("Pessoa Criada", "Aviso", 1);
                        if (UsuarioDao.inserir(Gui.CriarUsuario(p)) != -1) {
                            Gui.mostrarMensagemAviso("Usuario Criado", "Aviso", 1);
                        } else {
                            Gui.mostrarMensagemAviso("Erro ao Criar Usuario ", "Aviso", 2);
                        }
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Criar Pessoa", "Aviso", 2);
                    }
                    break;
                case 1:
                    int tamVet = 1000;
                    long[] idsPessoaSemUsuario = new long[tamVet];
                    for (int a = 0; a < idsPessoaSemUsuario.length; a++) {
                        idsPessoaSemUsuario[a] = -1;
                    }

                    String StringPessoasSemUsuario = "";

                    int j = 0;
                    for (Pessoas pessoa : PessoasDao.GetDataBase()) {
                        boolean PessoatemUsuario = false;
                        for (Usuario usuario : UsuarioDao.GetDataBase()) {
                            if (usuario.getPessoa() != null && usuario.getPessoa().getId() == pessoa.getId()) {
                                PessoatemUsuario = true;
                            }
                        }

                        if (!PessoatemUsuario && j <= tamVet) {
                            idsPessoaSemUsuario[j] = pessoa.getId();
                            StringPessoasSemUsuario += PessoasDao.mostrar(pessoa);
                            j++;
                        }
                    }

                    boolean verificacao = false;
                    int option;
                    while (verificacao != true) {
                        String resp = Gui.mostrarMensagemInput("Qual Pessoa vai ser atrelado ao usuario? digite o ID: \n" + StringPessoasSemUsuario, "Opções", 1, "0");
                        if (resp == null) {
                            return true;
                        } else {
                            option = Integer.parseInt(resp);
                        }

                        for (long pessoa : idsPessoaSemUsuario) {
                            if (pessoa == option && option != -1) {
                                verificacao = true;
                            }
                        }

                        if (verificacao == true) {
                            Pessoas p2 = PessoasDao.buscar(option);

                            if (UsuarioDao.inserir(Gui.CriarUsuario(p2)) != -1) {
                                Gui.mostrarMensagemAviso("Usuario Criado", "Aviso", 1);
                            } else {
                                Gui.mostrarMensagemAviso("Erro ao Criar Usuario ", "Aviso", 2);
                            }

                        } else {
                            Gui.mostrarMensagemAviso("Id invalido", "Aviso", 1);
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
                    FornecedorDao.inserir(Gui.CriarFornecedor());
                    Gui.mostrarMensagemAviso("Fornecedor Criado", "Aviso", 1);
                    break;
                case 1:
                    Gui.mostrarMensagemAviso("Fornecedores : \n" + UsuarioDao.mostrar(null), "Aviso", 1);
                    break;
                case 2:
                    int idAltera = Integer.parseInt(Gui.mostrarMensagemInput("Digite o id do fornecedor a ser alterado", "Alterar Fornecedor", 1, "0"));
                    FornecedorDao.alterar(Gui.CriarFornecedor(), idAltera);
                    Gui.mostrarMensagemAviso("Fornecedor Alterado", "Aviso", 1);
                    break;
                case 3:
                    int idDelete = Integer.parseInt(Gui.mostrarMensagemInput("Digite o id do Fornecedor a ser deletado", "Deletar Fornecedor", 1, "0"));
                    FornecedorDao.deletar(idDelete);
                    Gui.mostrarMensagemAviso("Fornecedor Deletado", "Aviso", 1);
                    break;
                case 4:
                    int idBuscar = Integer.parseInt(Gui.mostrarMensagemInput("Digite o id do Fornecedor a ser buscado", "Buscar Forncededor", 1, "0"));
                    Gui.mostrarMensagemAviso("Fornecedor : \n" + FornecedorDao.mostrar(FornecedorDao.buscar(idBuscar)), "Aviso", 1);
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

    private boolean menuConfirmacaoFamiliaLoop(int opcaoUsuario) {

        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    Gui.mostrarMensagemAviso("Entrando menu Convidado Responsavel", "Aviso", 1);
                    break;
                case -1:
                    return false;
                default:
                    Gui.mostrarMensagemAviso("Escolha uma opcao valida !!", "Aviso", 2);
                    break;
            }

            opcaoUsuario = Gui.menuConfirmacaoFamiliaOpcoes();

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
                    ConvidadoFamiliaDao.inserir(Gui.CriarConvidadoFamilia());
                    Gui.mostrarMensagemAviso("Responsavel familiar Criado", "Aviso", 1);
                    break;
                case 1:
                    Gui.mostrarMensagemAviso("Responsaveis familiar : \n" + UsuarioDao.mostrar(null), "Aviso", 1);
                    break;
                case 2:
                    int idAltera = Integer.parseInt(Gui.mostrarMensagemInput("Digite o id do Responsavel familiar a ser alterado", "Alterar Responsavel familiar", 1, "0"));
                    ConvidadoFamiliaDao.alterar(Gui.CriarConvidadoFamilia(), idAltera);
                    Gui.mostrarMensagemAviso("Responsavel familiar Alterado", "Aviso", 1);
                    break;
                case 3:
                    int idDelete = Integer.parseInt(Gui.mostrarMensagemInput("Digite o id do Responsavel familiar a ser deletado", "Deletar Responsavel familiar", 1, "0"));
                    ConvidadoFamiliaDao.deletar(idDelete);
                    Gui.mostrarMensagemAviso("Responsavel familiar Deletado", "Aviso", 1);
                    break;
                case 4:
                    int idBuscar = Integer.parseInt(Gui.mostrarMensagemInput("Digite o id do Responsavel familiar a ser buscado", "Buscar Responsavel familiar", 1, "0"));
                    Gui.mostrarMensagemAviso("Responsavel familiar : \n" + ConvidadoFamiliaDao.mostrar(ConvidadoFamiliaDao.buscar(idBuscar)), "Aviso", 1);
                    break;
                case -1:
                    return false;
                default:
                    Gui.mostrarMensagemAviso("Escolha uma opcao valida !!", "Aviso", 2);
                    break;
            }

            opcaoUsuario = Gui.menuFamiliaOpcoes();

        }
        System.out.println("Menu Fechado");
        return true;
    }

    private boolean menuConvidadoLoop(int opcaoUsuario) {
        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    // verifica nos vetores de convidado e pessoa se eles estão associados
                    boolean PessoaEhconvidado = false;

                    for (Pessoas pessoa : PessoasDao.GetDataBase()) {
                        boolean estaAssociada = false;

                        for (ConvidadoIndividual ci : ConvidadoIndividualDao.GetDataBase()) {
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
                    if (!PessoaEhconvidado || PessoasDao.mostrar(null).equals("")) {
                        Gui.mostrarMensagemAviso("Nenhuma pessoa disponivel encontrada insira informações da pessoa referente a esse Convidado", "Aviso", 1);
                        Pessoas p = Gui.CriarPessoa();

                        if (PessoasDao.inserir(p) != -1) {
                            Gui.mostrarMensagemAviso("Pessoa Criada", "Aviso", 1);

                            Gui.mostrarMensagemAviso("Agora insira as informações do Convidado", "Aviso", 1);
                            if (ConvidadoIndividualDao.inserir(Gui.CriarConvidadoIndividual(p)) != -1) {
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
                    Gui.mostrarMensagemAviso("Convidados : \n" + ConvidadoIndividualDao.mostrar(null), "Aviso", 1);
                    break;
                case 2:
                    int idAltera = Integer.parseInt(Gui.mostrarMensagemInput("Digite o id de um Convidado a ser alterado", "Alterar Convidado", 1, "0"));
                    ConvidadoIndividualDao.alterar(Gui.CriarConvidadoIndividual(null), idAltera);
                    Gui.mostrarMensagemAviso("Convidado Alterado", "Aviso", 1);
                    break;
                case 3:
                    int idDelete = Integer.parseInt(Gui.mostrarMensagemInput("Digite o id do Convidado a ser deletado", "Deletar Convidado", 1, "0"));
                    ConvidadoIndividualDao.deletar(idDelete);
                    Gui.mostrarMensagemAviso("Convidado Deletado", "Aviso", 1);
                    break;
                case 4:
                    int idBuscar = Integer.parseInt(Gui.mostrarMensagemInput("Digite o id do Convidado a ser buscado", "Buscar Convidado", 1, "0"));
                    Gui.mostrarMensagemAviso("Convidado : \n" + ConvidadoIndividualDao.mostrar(ConvidadoIndividualDao.buscar(idBuscar)), "Aviso", 1);
                    break;
                case 5:
                    Gui.mostrarMensagemAviso("Confirmando presença", "Aviso", 2);
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
                    if (PessoasDao.inserir(p) != -1) {
                        Gui.mostrarMensagemAviso("Pessoa Criada", "Aviso", 1);

                        Gui.mostrarMensagemAviso("Agora insira as informações do Convidado", "Aviso", 1);
                        if (ConvidadoIndividualDao.inserir(Gui.CriarConvidadoIndividual(p)) != -1) {
                            Gui.mostrarMensagemAviso("Convidado Criado", "Aviso", 1);
                        } else {
                            Gui.mostrarMensagemAviso("Erro ao Criar Convidado ", "Aviso", 2);
                        }
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Criar Pessoa", "Aviso", 2);
                    }
                    break;

                case 1:

                    int tamVet = 1000;
                    long[] idsPessoasSemConvite = new long[tamVet];
                    for (int a = 0; a < idsPessoasSemConvite.length; a++) {
                        idsPessoasSemConvite[a] = -1;
                    }

                    String StringPessoasSemConvite = "";
                    int j = 0;
                    for (Pessoas pessoa : PessoasDao.GetDataBase()) {

                        boolean PessoaEhconvidado = false;

                        for (ConvidadoIndividual ci : ConvidadoIndividualDao.GetDataBase()) {
                            if (ci.getPessoa() != null && ci.getPessoa().getId() == pessoa.getId()) {
                                PessoaEhconvidado = true;
                            }
                        }
                        if (!PessoaEhconvidado && j <= tamVet) {
                            idsPessoasSemConvite[j] = pessoa.getId();
                            StringPessoasSemConvite += PessoasDao.mostrar(pessoa);
                            j++;
                        }
                    }

                    boolean verificacao = false;
                    int option;
                    while (verificacao != true) {
                        String resp = Gui.mostrarMensagemInput("Qual Pessoa vai ser atrelado ao Convidado? digite o ID: \n" + StringPessoasSemConvite, "escolha a pessoa", 3, "0");

                        if (resp == null) {
                            return true;
                        } else {
                            option = Integer.parseInt(resp);
                        }

                        for (Long pessoa : idsPessoasSemConvite) {
                            if (pessoa == option && option != -1) {
                                verificacao = true;
                            }
                        }

                        if (verificacao == true) {
                            Pessoas p2 = PessoasDao.buscar(option);

                            if (ConvidadoIndividualDao.inserir(Gui.CriarConvidadoIndividual(p2)) != -1) {
                                Gui.mostrarMensagemAviso("Convidado Criado", "Aviso", 1);
                            } else {
                                Gui.mostrarMensagemAviso("Erro ao Criar Convidado ", "Aviso", 2);
                            }

                        } else {
                            Gui.mostrarMensagemAviso("Id invalido", "Aviso", 1);
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
                    EventoDao.inserir(Gui.CriarEvento());
                    Gui.mostrarMensagemAviso("Evento Criado", "Aviso", 1);
                    break;
                case 1:
                    Gui.mostrarMensagemAviso("Eventos : \n" + EventoDao.mostrar(null), "Aviso", 1);
                    break;
                case 2:
                    int idAltera = Integer.parseInt(Gui.mostrarMensagemInput("Digite o id de um Evento a ser alterado", "Alterar Evento", 1, "0"));
                    EventoDao.alterar(Gui.CriarEvento(), idAltera);
                    Gui.mostrarMensagemAviso("Evento Alterado", "Aviso", 1);
                    break;
                case 3:
                    int idDelete = Integer.parseInt(Gui.mostrarMensagemInput("Digite o id do Evento a ser deletado", "Deletar Evento", 1, "0"));
                    EventoDao.deletar(idDelete);
                    Gui.mostrarMensagemAviso("Evento Deletado", "Aviso", 1);
                    break;
                case 4:
                    int idBuscar = Integer.parseInt(Gui.mostrarMensagemInput("Digite o id do Evento a ser buscado", "Buscar Evento", 1, "0"));
                    Gui.mostrarMensagemAviso("Evento : \n" + EventoDao.mostrar(EventoDao.buscar(idBuscar)), "Aviso", 1);
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
                    MuralDeRecadosDao.inserir(Gui.CriarRecado());
                    Gui.mostrarMensagemAviso("Recado Criado", "Aviso", 1);
                    break;
                case 1:
                    Gui.mostrarMensagemAviso("Recados : \n" + MuralDeRecadosDao.mostrar(null), "Aviso", 1);
                    break;
                case 2:
                    int idAltera = Integer.parseInt(Gui.mostrarMensagemInput("Digite o id de um Recado a ser alterado", "Alterar Recado", 1, "0"));
                    MuralDeRecadosDao.alterar(Gui.CriarRecado(), idAltera);
                    Gui.mostrarMensagemAviso("Recado Alterado", "Aviso", 1);
                    break;
                case 3:
                    int idDelete = Integer.parseInt(Gui.mostrarMensagemInput("Digite o id do Recado a ser deletado", "Deletar Recado", 1, "0"));
                    MuralDeRecadosDao.deletar(idDelete);
                    Gui.mostrarMensagemAviso("Recado Deletado", "Aviso", 1);
                    break;
                case 4:
                    int idBuscar = Integer.parseInt(Gui.mostrarMensagemInput("Digite o id do Recado a ser buscado", "Buscar Recado", 1, "0"));
                    Gui.mostrarMensagemAviso("Recado : \n" + MuralDeRecadosDao.mostrar(MuralDeRecadosDao.buscar(idBuscar)), "Aviso", 1);
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

    private boolean menuPagamentoLoop(int opcaoUsuario) {
        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    PagamentosDao.inserir(Gui.CriarPagamento());
                    Gui.mostrarMensagemAviso("Pagamento Criado", "Aviso", 1);
                    break;
                case 1:
                    Gui.mostrarMensagemAviso("Pagamentos : \n" + PagamentosDao.mostrar(null), "Aviso", 1);
                    break;
                case 2:
                    int idAltera = Integer.parseInt(Gui.mostrarMensagemInput("Digite o id de um Pagamento a ser alterado", "Alterar Pagamento", 1, "0"));
                    PagamentosDao.alterar(Gui.CriarPagamento(), idAltera);
                    Gui.mostrarMensagemAviso("Pagamento Alterado", "Aviso", 1);
                    break;
                case 3:
                    int idDelete = Integer.parseInt(Gui.mostrarMensagemInput("Digite o id do Pagamento a ser deletado", "Deletar Pagamento", 1, "0"));
                    PagamentosDao.deletar(idDelete);
                    Gui.mostrarMensagemAviso("Pagamento Deletado", "Aviso", 1);
                    break;
                case 4:
                    int idBuscar = Integer.parseInt(Gui.mostrarMensagemInput("Digite o id do Pagamento a ser buscado", "Buscar Pagamento", 1, "0"));
                    Gui.mostrarMensagemAviso("Pagamento : \n" + PagamentosDao.mostrar(PagamentosDao.buscar(idBuscar)), "Aviso", 1);
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

    private boolean menuPresenteLoop(int opcaoUsuario) {
        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    PresentesDao.inserir(Gui.CriarPresente());
                    Gui.mostrarMensagemAviso("Presente Criado", "Aviso", 1);
                    break;
                case 1:
                    Gui.mostrarMensagemAviso("Presentes : \n" + PresentesDao.mostrar(null), "Aviso", 1);
                    break;
                case 2:
                    int idAltera = Integer.parseInt(Gui.mostrarMensagemInput("Digite o id de um Presente a ser alterado", "Alterar Presente", 1, "0"));
                    PresentesDao.alterar(Gui.CriarPresente(), idAltera);
                    Gui.mostrarMensagemAviso("Presente Alterado", "Aviso", 1);
                    break;
                case 3:
                    int idDelete = Integer.parseInt(Gui.mostrarMensagemInput("Digite o id do Presente a ser deletado", "Deletar Presente", 1, "0"));
                    PresentesDao.deletar(idDelete);
                    Gui.mostrarMensagemAviso("Presente Deletado", "Aviso", 1);
                    break;
                case 4:
                    int idBuscar = Integer.parseInt(Gui.mostrarMensagemInput("Digite o id do Presente a ser buscado", "Recado Presente", 1, "0"));
                    Gui.mostrarMensagemAviso("Presente : \n" + PresentesDao.mostrar(PresentesDao.buscar(idBuscar)), "Aviso", 1);
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new SoftwareCasamento();
    }

}
