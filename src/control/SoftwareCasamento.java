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
    PresentesDAO PresentesDao = new PresentesDAO();
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

            opcaoUsuario = Gui.MenuLoginOpcoes();

        }
        System.out.println("Menu Fechado");
    }

    // Respostas do painel de convidado (sem login)
    private boolean MenuLoginConvidadoLoop(int opcaoUsuario) {
        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    if (!PessoasDao.mostrar(null).equals("")) {
                        Gui.mostrarMensagemAviso("Digite a seguir seu nome e data de nascimento de acordo com o seu convite", "Aviso", 1);
                        String nome = Gui.mostrarMensagemInput("Digite seu nome:", "Nome", 3, "douglas");
                        String dataNasc = Gui.mostrarMensagemInput("Digite sua data de nascimento:", "Data de Nascimento", 3, "01/01/2001");
                        Pessoas pessoaEncontrada = null;
                        for (Pessoas pessoas : PessoasDao.GetDataBase()) {
                            if (pessoas.getNome().equals(nome) && pessoas.getNascimento().equals(Gui.validarData(dataNasc))) {
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
                    if (!PessoasDao.mostrar(null).equals("")) {
                        Gui.mostrarMensagemAviso("Digite a seguir seu nome e data de nascimento de acordo com o seu convite", "Aviso", 1);
                        String nome = Gui.mostrarMensagemInput("Digite seu nome:", "Nome", 3, "douglas");
                        String dataNasc = Gui.mostrarMensagemInput("Digite sua data de nascimento:", "Data de Nascimento", 3, "01/01/2001");
                        Pessoas pessoaEncontrada = null;
                        for (Pessoas pessoas : PessoasDao.GetDataBase()) {
                            if (pessoas.getNome().equals(nome) && pessoas.getNascimento().equals(Gui.validarData(dataNasc))) {
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
                    int idresposta = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID de um dos presentes abaixo que voce irá presentear\n" + PresentesDao.mostrar(null), "Alterar Presente", 1, ""));
                    if (PresentesDao.buscar(idresposta) != null) {
                        PresentesDao.buscar(idresposta).setPessoa(p);
                        Gui.mostrarMensagemAviso("Presente Confirmado.", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("ID invalido", "Aviso", 2);
                    }

                    break;
                case 1:
                    if (!PresentesDao.mostrar(null).equals("")) {
                        Gui.mostrarMensagemAviso("Presentes : \n" + PresentesDao.mostrar(null), "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Nenhum Presente cadastrado", "Aviso", 2);
                    }
                    break;
                case 2:
                    idresposta = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID de um dos presentes abaixo que voce irá cancelar\n" + PresentesDao.mostrar(null), "Alterar Presente", 1, ""));
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
                    if (MuralDeRecadosDao.inserir(Gui.CriarRecado(p)) != -1) {
                        Gui.mostrarMensagemAviso("Recado Criado", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Criar Recado", "Aviso", 2);
                    }
                    break;
                case 1:
                    if (!MuralDeRecadosDao.mostrar(null).equals("")) {
                        Gui.mostrarMensagemAviso("Recados : \n" + MuralDeRecadosDao.mostrar(null), "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Não há registro de recados", "Aviso", 2);
                    }
                    break;
                case 2:
                    int idAltera = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID de um Recado a ser alterado", "Alterar Recado", 1, "0"));
                    if (MuralDeRecadosDao.buscar(idAltera).getPessoa().equals(p)) {
                        if (MuralDeRecadosDao.alterar(Gui.CriarRecado(p), idAltera) != false) {
                            Gui.mostrarMensagemAviso("Recado Alterado", "Aviso", 1);
                        } else {
                            Gui.mostrarMensagemAviso("Erro ao Alterar Recado", "Aviso", 2);
                        }
                    } else {
                        Gui.mostrarMensagemAviso("Voce não tem permissão para alterar outros recados", "Atenção", 2);
                    }
                    break;
                case 3:
                    int idDelete = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID do Recado a ser deletado", "Deletar Recado", 1, "0"));
                    if (MuralDeRecadosDao.buscar(idDelete) != null
                            && MuralDeRecadosDao.buscar(idDelete).getPessoa().equals(p)) {

                        if (MuralDeRecadosDao.deletar(idDelete)) {
                            Gui.mostrarMensagemAviso("Recado Deletado", "Aviso", 1);
                        } else {
                            Gui.mostrarMensagemAviso("Erro ao Deletar Recado", "Aviso", 2);
                        }
                    } else {
                        Gui.mostrarMensagemAviso("Voce não tem permissão para deletar outros recados", "Atenção", 2);
                    }
                    break;
                case 4:
                    int idBuscar = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID do Recado a ser buscado", "Buscar Recado", 1, "0"));
                    if (MuralDeRecadosDao.buscar(idBuscar) != null) {
                        Gui.mostrarMensagemAviso("Recado : \n" + MuralDeRecadosDao.mostrar(MuralDeRecadosDao.buscar(idBuscar)), "Aviso", 1);
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
                    if (PessoasDao.inserir(Gui.CriarPessoa()) != -1) {
                        Gui.mostrarMensagemAviso("Pessoa Criada", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Criar Pessoa", "Aviso", 2);
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

                    int idAltera = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID do usuario a ser alterado", "Alterar Usuario", 1, "0"));
                    if (PessoasDao.alterar(Gui.CriarPessoa(), idAltera) != false) {
                        Gui.mostrarMensagemAviso("Pessoa Alterada", "Aviso", 3);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Alterar Pessoa", "Aviso", 2);
                    }
                    break;
                case 3:
                    int idDelete = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID do usuario a ser deletado", "Deletar Usuario", 1, "0"));
                    if (PessoasDao.deletar(idDelete)) {
                        Gui.mostrarMensagemAviso("Pessoa Deletada", "Aviso", 3);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Deletar Pessoa", "Aviso", 2);
                    }
                    break;
                case 4:
                    int idBuscar = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID do usuario a ser buscado", "Buscar Usuario", 1, "0"));
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
                    if (!UsuarioDao.mostrar(null).equals("")) {
                        Gui.mostrarMensagemAviso("Usuarios : \n" + UsuarioDao.mostrar(null), "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Nenhum Usuario cadastrado", "Aviso", 2);
                    }
                    break;
                case 2:
                    int idAltera = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID do usuario a ser alterado", "Alterar Usuario", 1, "0"));
                    if (UsuarioDao.buscar(idAltera) != null
                            && UsuarioDao.alterar(Gui.CriarUsuario(UsuarioDao.buscar(idAltera).getPessoa()), idAltera)) {
                        Gui.mostrarMensagemAviso("Usuario Alterada", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Alterar Usuario ", "Aviso", 2);
                    }
                    break;
                case 3:
                    int idDelete = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID do usuario a ser deletado", "Deletar Usuario", 1, "0"));
                    if (UsuarioDao.deletar(idDelete)) {
                        Gui.mostrarMensagemAviso("Usuario Deletada", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Deletar Usuario", "Aviso", 2);
                    }

                    break;
                case 4:
                    int idBuscar = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID do usuario a ser buscado", "Buscar Usuario", 1, "0"));
                    if (UsuarioDao.buscar(idBuscar) != null) {
                        Gui.mostrarMensagemAviso("Usuario : \n" + UsuarioDao.mostrar(UsuarioDao.buscar(idBuscar)), "Aviso", 1);
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
                            option = Gui.validarStringToInt(resp);
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
                    if (FornecedorDao.inserir(Gui.CriarFornecedor()) != -1) {
                        Gui.mostrarMensagemAviso("Fornecedor Criado", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Criar Fornecedor", "Aviso", 2);
                    }
                    break;
                case 1:
                    if (!FornecedorDao.mostrar(null).equals("")) {
                        Gui.mostrarMensagemAviso("Fornecedores : \n" + FornecedorDao.mostrar(null), "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Nenhum Fornecedor Cadastrado", "Aviso", 2);
                    }
                    break;
                case 2:
                    int idAltera = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID do fornecedor a ser alterado", "Alterar Fornecedor", 1, "0"));
                    if (FornecedorDao.alterar(Gui.CriarFornecedor(), idAltera)) {
                        Gui.mostrarMensagemAviso("Fornecedor Alterado", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Alterar Fornecedor", "Aviso", 2);
                    }
                    break;
                case 3:
                    int idDelete = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID do Fornecedor a ser deletado", "Deletar Fornecedor", 1, "0"));
                    if (FornecedorDao.deletar(idDelete)) {
                        Gui.mostrarMensagemAviso("Fornecedor Deletado", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Deletar Fornecedor", "Aviso", 2);
                    }
                    break;
                case 4:
                    int idBuscar = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID do Fornecedor a ser buscado", "Buscar Forncededor", 1, "0"));
                    if (FornecedorDao.buscar(idBuscar) != null) {
                        Gui.mostrarMensagemAviso("Fornecedor : \n" + FornecedorDao.mostrar(FornecedorDao.buscar(idBuscar)), "Aviso", 1);
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

    private boolean menuConfirmacaoFamiliaLoop(int opcaoUsuario, ConvidadoFamilia cf) {
        int tamVet = 1000;
        int j = 0;
        long[] idsConvidadosFamilia = new long[tamVet];
        for (int a = 0; a < idsConvidadosFamilia.length; a++) {
            idsConvidadosFamilia[a] = -1;
        }
        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    String StringConvidadosFamilia = "";

                    for (ConvidadoIndividual ci : ConvidadoIndividualDao.GetDataBase()) {
                        if (cf.getNomeDaFamilia().equals(ci.getFamilia()) && j <= tamVet) {
                            idsConvidadosFamilia[j] = ci.getId();
                            StringConvidadosFamilia += ConvidadoIndividualDao.mostrar(ci) + "\n";
                            j++;
                        }
                    }

                    if (idsConvidadosFamilia[0] != -1) {
                        int option;
                        boolean verificacao = false;
                        while (verificacao != true) {
                            String resp = Gui.mostrarMensagemInput("Qual convidado você gostaria de modificar a confirmação de presença? digite o ID: \n" + StringConvidadosFamilia, "escolha a pessoa", 3, "0");
                            if (resp == null) {
                                break;
                            } else {
                                option = Gui.validarStringToInt(resp);
                            }

                            for (Long convidados : idsConvidadosFamilia) {
                                if (convidados == option && option != -1) {
                                    verificacao = true;
                                }
                            }

                            if (verificacao == true) {
                                ConvidadoIndividual convidado = ConvidadoIndividualDao.buscar(option);
                                if (convidado.getConfirmacao() == "Não Confirmado") {
                                    convidado.setConfirmacao("Confirmado");

                                    Gui.mostrarMensagemAviso("Presença Confirmada", "Aviso", 1);
                                } else {
                                    convidado.setConfirmacao("Não Confirmado");
                                    Gui.mostrarMensagemAviso("Presença Cancelada", "Aviso", 1);
                                }

                                boolean familiaVai = false;
                                for (ConvidadoIndividual convidados : ConvidadoIndividualDao.GetDataBase()) {
                                    if (convidados.getConfirmacao() == "Confirmado") {
                                        familiaVai = true;
                                    }
                                }
                                if (!familiaVai) {
                                    cf.setConfirmacao("Não Confirmado");
                                } else {
                                    cf.setConfirmacao("Confirmado");
                                }

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
                    if (ConvidadoFamiliaDao.inserir(Gui.CriarConvidadoFamilia()) != -1) {
                        Gui.mostrarMensagemAviso("família Criado", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Criar família", "Aviso", 2);
                    }
                    break;
                case 1:
                    if (!ConvidadoFamiliaDao.mostrar(null).equals("")) {
                        Gui.mostrarMensagemAviso("famílias : \n" + ConvidadoFamiliaDao.mostrar(null), "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Nenhuma família cadastrada", "Aviso", 2);
                    }

                    break;
                case 2:
                    int idAltera = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID da família a ser alterada", "Alterar família", 1, "0"));
                    if (ConvidadoFamiliaDao.alterar(Gui.CriarConvidadoFamilia(), idAltera) != false) {
                        Gui.mostrarMensagemAviso("Família Alterada", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Alterar família", "Aviso", 2);
                    }
                    break;
                case 3:
                    int idDelete = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID da família a ser deletada", "Deletar família", 1, "0"));
                    if (ConvidadoFamiliaDao.deletar(idDelete)) {
                        Gui.mostrarMensagemAviso("família Deletada", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Deletar família", "Aviso", 2);
                    }
                    break;
                case 4:
                    int idBuscar = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID da família a ser buscada", "Buscar família", 1, "0"));
                    if (ConvidadoFamiliaDao.buscar(idBuscar) != null) {
                        Gui.mostrarMensagemAviso("família : \n" + ConvidadoFamiliaDao.mostrar(ConvidadoFamiliaDao.buscar(idBuscar)), "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("família não encontrada", "Aviso", 2);
                    }
                    break;
                case 5:
                    StringBuilder familias = new StringBuilder("");

                    familias.append("<html><body><p style='font-size:10px; font-weight:bold;'>");
                    for (ConvidadoFamilia cf : ConvidadoFamiliaDao.GetDataBase()) {
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
                        String resp = Gui.mostrarMensagemInput("Qual convidado você gostaria de modificar a confirmação de presença? digite o ID: \n" + familias, "escolha o convidado", 3, "0");

                        if (resp == null) {
                            break;
                        } else {
                            option = Gui.validarStringToInt(resp);
                        }

                        for (ConvidadoFamilia ConvidadoFamilia : ConvidadoFamiliaDao.GetDataBase()) {
                            if (ConvidadoFamilia.getId() == option && option != -1) {
                                verificacao = true;
                            }
                        }

                        if (verificacao == true) {
                            ConvidadoFamilia ConvidadoFamilia = ConvidadoFamiliaDao.buscar(option);
                            if (ConvidadoFamilia.getConfirmacao() == "Não Confirmado") {
                                ConvidadoFamilia.setConfirmacao("Confirmado");
                                Gui.mostrarMensagemAviso("Presença Confirmada", "Aviso", 1);
                            } else {
                                ConvidadoFamilia.setConfirmacao("Não Confirmado");
                                Gui.mostrarMensagemAviso("Presença Cancelada", "Aviso", 1);
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
                    if (!ConvidadoIndividualDao.mostrar(null).equals("")) {
                        Gui.mostrarMensagemAviso("Convidados : \n" + ConvidadoIndividualDao.mostrar(null), "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Nenhum convidado cadastrado", "Aviso", 2);
                    }
                    break;
                case 2:
                    int idAltera = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID de um Convidado a ser alterado", "Alterar Convidado", 1, "0"));
                    if (ConvidadoIndividualDao.buscar(idAltera) != null
                            && ConvidadoIndividualDao.alterar(Gui.CriarConvidadoIndividual(ConvidadoIndividualDao.buscar(idAltera).getPessoa()), idAltera) != false) {
                        Gui.mostrarMensagemAviso("Convidado Alterado", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Alterar Convidado", "Aviso", 2);
                    }
                    break;
                case 3:
                    int idDelete = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID do Convidado a ser deletado", "Deletar Convidado", 1, "0"));
                    if (ConvidadoIndividualDao.deletar(idDelete)) {
                        Gui.mostrarMensagemAviso("Convidado Deletado", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Deletar Convidado", "Aviso", 2);
                    }
                    break;
                case 4:
                    int idBuscar = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID do Convidado a ser buscado", "Buscar Convidado", 1, "0"));
                    if (ConvidadoIndividualDao.buscar(idBuscar) != null) {
                        Gui.mostrarMensagemAviso("Convidado : \n" + ConvidadoIndividualDao.mostrar(ConvidadoIndividualDao.buscar(idBuscar)), "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Convidado não encontrado", "Aviso", 2);
                    }
                    break;
                case 5:
                    if (ConvidadoIndividualDao.mostrar(null).equals("")) {
                        Gui.mostrarMensagemAviso("Nenhum convidado cadastrado", "Aviso", 2);
                    } else {

                        StringBuilder convidados = new StringBuilder("");

                        convidados.append("<html><body><p style='font-size:10px; font-weight:bold;'>");
                        for (Pessoas pessoa : PessoasDao.GetDataBase()) {
                            for (ConvidadoIndividual ci : ConvidadoIndividualDao.GetDataBase()) {
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
                            String resp = Gui.mostrarMensagemInput("Qual convidado você gostaria de modificar a confirmação de presença? digite o ID: \n" + convidados, "escolha o convidado", 3, "0");

                            if (resp == null) {
                                break;
                            } else {
                                option = Gui.validarStringToInt(resp);
                            }

                            for (ConvidadoIndividual convidadoIndividual : ConvidadoIndividualDao.GetDataBase()) {
                                if (convidadoIndividual.getId() == option && option != -1) {
                                    verificacao = true;
                                }
                            }

                            if (verificacao == true) {
                                ConvidadoIndividual convidado = ConvidadoIndividualDao.buscar(option);
                                if (convidado.getConfirmacao() == "Não Confirmado") {
                                    convidado.setConfirmacao("Confirmado");
                                    Gui.mostrarMensagemAviso("Presença Confirmada", "Aviso", 1);
                                } else {
                                    convidado.setConfirmacao("Não Confirmado");
                                    Gui.mostrarMensagemAviso("Presença Cancelada", "Aviso", 1);
                                }

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
                            option = Gui.validarStringToInt(resp);
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
                    if (EventoDao.inserir(Gui.CriarEvento()) != -1) {
                        Gui.mostrarMensagemAviso("Evento Criado", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Criar Evento", "Aviso", 2);
                    }

                    break;
                case 1:
                    if (!EventoDao.mostrar(null).equals("")) {
                        Gui.mostrarMensagemAviso("Eventos : \n" + EventoDao.mostrar(null), "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Nenhum evento cadastrado", "Aviso", 2);
                    }
                    break;
                case 2:
                    int idAltera = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID de um Evento a ser alterado", "Alterar Evento", 1, "0"));
                    if (EventoDao.alterar(Gui.CriarEvento(), idAltera) != false) {
                        Gui.mostrarMensagemAviso("Evento Alterado", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Alterar Evento", "Aviso", 2);
                    }
                    break;
                case 3:
                    int idDelete = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID do Evento a ser deletado", "Deletar Evento", 1, "0"));
                    if (EventoDao.deletar(idDelete)) {
                        Gui.mostrarMensagemAviso("Evento Deletado", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Deletar Evento", "Aviso", 2);
                    }
                    break;
                case 4:
                    int idBuscar = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID do Evento a ser buscado", "Buscar Evento", 1, "0"));
                    if (EventoDao.buscar(idBuscar) != null) {
                        Gui.mostrarMensagemAviso("Evento : \n" + EventoDao.mostrar(EventoDao.buscar(idBuscar)), "Aviso", 1);
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
                    if (!PessoasDao.mostrar(null).equals("")) {
                        if (!menuMuralDeRecadosEscolhaInserirLoop(Gui.menuMuralDeRecadosEscolhaInserirOpcoes())) {
                            return false;
                        }
                    } else {
                        Gui.mostrarMensagemAviso("Nenhuma pessoa cadastrada!! insira as informações da pessoa que deixará o recado", "Aviso", 1);
                        Pessoas p = Gui.CriarPessoa();
                        if (PessoasDao.inserir(p) != -1) {
                            Gui.mostrarMensagemAviso("Pessoa Criada", "Aviso", 1);

                            Gui.mostrarMensagemAviso("Agora insira seu recado", "Aviso", 1);
                            if (MuralDeRecadosDao.inserir(Gui.CriarRecado(p)) != -1) {
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
                    if (!MuralDeRecadosDao.mostrar(null).equals("")) {
                        Gui.mostrarMensagemAviso("Recados : \n" + MuralDeRecadosDao.mostrar(null), "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Não há registro de recados", "Aviso", 2);
                    }
                    break;
                case 2:
                    int idAltera = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID de um Recado a ser alterado", "Alterar Recado", 1, "0"));
                    if (MuralDeRecadosDao.buscar(idAltera) != null
                            && MuralDeRecadosDao.alterar(Gui.CriarRecado(MuralDeRecadosDao.buscar(idAltera).getPessoa()), idAltera) != false) {
                        Gui.mostrarMensagemAviso("Recado Alterado", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Alterar Recado", "Aviso", 2);
                    }
                    break;
                case 3:
                    int idDelete = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID do Recado a ser deletado", "Deletar Recado", 1, "0"));
                    if (MuralDeRecadosDao.deletar(idDelete)) {
                        Gui.mostrarMensagemAviso("Recado Deletado", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Deletar Recado", "Aviso", 2);
                    }
                    break;
                case 4:
                    int idBuscar = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID do Recado a ser buscado", "Buscar Recado", 1, "0"));
                    if (MuralDeRecadosDao.buscar(idBuscar) != null) {
                        Gui.mostrarMensagemAviso("Recado : \n" + MuralDeRecadosDao.mostrar(MuralDeRecadosDao.buscar(idBuscar)), "Aviso", 1);
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
                    if (PessoasDao.inserir(p) != -1) {
                        Gui.mostrarMensagemAviso("Pessoa Criada", "Aviso", 1);

                        Gui.mostrarMensagemAviso("Agora insira seu recado", "Aviso", 1);
                        if (MuralDeRecadosDao.inserir(Gui.CriarRecado(p)) != -1) {
                            Gui.mostrarMensagemAviso("Recado Criado", "Aviso", 1);
                        } else {
                            Gui.mostrarMensagemAviso("Erro ao Criar Recado", "Aviso", 2);
                        }
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Criar Pessoa", "Aviso", 2);
                    }

                    break;
                case 1:
                    String resp = Gui.mostrarMensagemInput("Qual pessoa vai ser o autor do recado?  digite o ID: \n" + PessoasDao.mostrar(null), "escolha a pessoa", 3, "0");
                    int option;
                    if (resp == null) {
                        return true;
                    } else {
                        option = Gui.validarStringToInt(resp);
                    }
                    p = PessoasDao.buscar(option);
                    if (p != null) {

                        Gui.mostrarMensagemAviso("Agora insira seu recado", "Aviso", 1);
                        if (MuralDeRecadosDao.inserir(Gui.CriarRecado(p)) != -1) {
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
                    if (FornecedorDao.mostrar(null).equals("")) {
                        Gui.mostrarMensagemAviso("Nenhum fornecedor disponivel encontrado insira informações de fornecedores referente a esse pagamento", "Aviso", 1);
                        Fornecedor f = Gui.CriarFornecedor();

                        if (FornecedorDao.inserir(f) != -1) {
                            Gui.mostrarMensagemAviso("Fornecedor Criado", "Aviso", 1);

                            if (!menuFornecedorInserirEscolhaLoop(Gui.menuPagamentoInserirEscolhaOpcoes())) {
                                return false;
                            }
                        } else {
                            Gui.mostrarMensagemAviso("Erro ao Criar Fornecedor", "Aviso", 2);
                        }
                    } else { // caso tenha vai para a escolha de criar um forneceodr ou escolher um existente
                        if (!menuFornecedorInserirEscolhaLoop(Gui.menuPagamentoInserirEscolhaOpcoes())) {
                            return false;
                        }
                    }

                    break;
                case 1:
                    if (!PagamentosDao.mostrar(null).equals("")) {
                        Gui.mostrarMensagemAviso("Pagamentos : \n" + PagamentosDao.mostrar(null), "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Nenhum pagamento cadastrado", "Aviso", 2);
                    }
                    break;
                case 2:
                    int idAltera = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID de um Pagamento a ser alterado", "Alterar Pagamento", 1, "0"));
                    if (PagamentosDao.alterar(Gui.CriarPagamento(PagamentosDao.buscar(idAltera).getFornecedor(), PagamentosDao.buscar(idAltera).getPessoa()), idAltera) != false) {
                        Gui.mostrarMensagemAviso("Pagamento Alterado", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Aterar o Pagamento", "Aviso", 2);
                    }
                    break;
                case 3:
                    int idDelete = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID do Pagamento a ser deletado", "Deletar Pagamento", 1, "0"));
                    if (PagamentosDao.deletar(idDelete)) {
                        Gui.mostrarMensagemAviso("Pagamento Deletado", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Deletar Pagamento", "Aviso", 2);
                    }
                    break;
                case 4:
                    int idBuscar = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID do Pagamento a ser buscado", "Buscar Pagamento", 1, "0"));
                    if (PagamentosDao.buscar(idBuscar) != null) {
                        Gui.mostrarMensagemAviso("Pagamento : \n" + PagamentosDao.mostrar(PagamentosDao.buscar(idBuscar)), "Aviso", 1);
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

    private boolean menuFornecedorInserirEscolhaLoop(int opcaoUsuario) {
        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    if (FornecedorDao.inserir(Gui.CriarFornecedor()) != -1) {
                        Gui.mostrarMensagemAviso("Fornecedor Criado", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Criar Fornecedor", "Aviso", 2);
                    }
                    break;

                case 1:
                    int tamVet = 1000;
                    long[] idsFornecedoresSemPagamento = new long[tamVet];
                    for (int i = 0; i < tamVet; i++) {
                        idsFornecedoresSemPagamento[i] = -1;
                    }

                    String stringFornecedoresComValorAPagar = "";
                    int j = 0;

                    for (Fornecedor f : FornecedorDao.GetDataBase()) {
                        if (f.getEstado().equals("A pagar")) {
                            stringFornecedoresComValorAPagar += FornecedorDao.mostrar(f);
                            idsFornecedoresSemPagamento[j] = f.getId();
                            j++;
                        }
                    }

                    if (!stringFornecedoresComValorAPagar.equals("")) {
                        boolean verificacao = false;
                        int option;
                        while (verificacao != true) {
                            String resp = Gui.mostrarMensagemInput("Qual Fornecedor Sera pago? Digite o ID:\n" + stringFornecedoresComValorAPagar, "Opções", 1, "0");

                            if (resp == null) {
                                return true;
                            } else {
                                option = Gui.validarStringToInt(resp);
                            }

                            for (Long fornecedores : idsFornecedoresSemPagamento) {
                                if (fornecedores == option && option != -1) {
                                    verificacao = true;
                                }
                            }

                            if (verificacao == true) {

                                Pessoas pessoa = null;
                                boolean verificacao1 = false;
                                option = 0;
                                if (!PessoasDao.mostrar(null).equals("")) {
                                    while (verificacao1 != true) {
                                        resp = Gui.mostrarMensagemInput("Qual pessoa será atrelada a fornecedor? Digite o ID:\n" + PessoasDao.mostrar(null), "Opções", 1, "0");

                                        if (resp == null) {
                                            return true;
                                        } else {
                                            option = Gui.validarStringToInt(resp);
                                        }

                                        for (Pessoas p : PessoasDao.GetDataBase()) {
                                            if (p.getId() == option && option != -1) {
                                                verificacao1 = true;
                                            }
                                        }
                                        if (verificacao1 == true) {
                                            pessoa = PessoasDao.buscar(option);
                                            break;
                                        } else {
                                            Gui.mostrarMensagemAviso("ID invalido", "Aviso", 1);
                                        }
                                    }
                                } else {
                                    Gui.mostrarMensagemAviso("Nenhuma pessoa cadastrada insira informações da pessoa referente a esse Fornecedor", "Aviso", 1);
                                    pessoa = Gui.CriarPessoa();
                                    if (PessoasDao.inserir(pessoa) != -1) {
                                        Gui.mostrarMensagemAviso("Pessoa Criada", "Aviso", 1);
                                        if (FornecedorDao.inserir(Gui.CriarFornecedor()) != -1) {
                                            Gui.mostrarMensagemAviso("Fornecedor Criado", "Aviso", 1);
                                        } else {
                                            Gui.mostrarMensagemAviso("Erro ao Criar Fornecedor", "Aviso", 2);
                                        }
                                    } else {
                                        Gui.mostrarMensagemAviso("Erro ao Criar Pessoa", "Aviso", 2);
                                    }
                                }

                                Fornecedor fornecedorSelecionado = FornecedorDao.buscar(option);
                                Pagamentos pagamentoDoFornecedor = Gui.CriarPagamento(fornecedorSelecionado, pessoa);
                                pagamentoDoFornecedor.setParcela(fornecedorSelecionado.getParcelas());
                                fornecedorSelecionado.setParcelas(0);

                                if (PagamentosDao.inserir(pagamentoDoFornecedor) != -1) {
                                    Gui.mostrarMensagemAviso("Pagamento Criado", "Aviso", 1);
                                } else {
                                    Gui.mostrarMensagemAviso("Erro ao Criar Pagamento", "Aviso", 2);
                                }

                                if (pagamentoDoFornecedor.getParcela() > 1) {
                                    if (!(fornecedorSelecionado.getParcelas() == pagamentoDoFornecedor.getParcela())) {
                                        System.out.println(fornecedorSelecionado.getValorAPagar() + "/" + pagamentoDoFornecedor.getParcela() + "-" + fornecedorSelecionado.getParcelas());

                                        pagamentoDoFornecedor.setValor(fornecedorSelecionado.getValorAPagar() / (pagamentoDoFornecedor.getParcela() - fornecedorSelecionado.getParcelas()));
                                        fornecedorSelecionado.setParcelas(+1);

                                    } else {
                                        fornecedorSelecionado.setEstado("Pago");
                                    }

                                    if (fornecedorSelecionado.getValorAPagar() != 0) {
                                        fornecedorSelecionado.setValorAPagar(fornecedorSelecionado.getValorAPagar() - pagamentoDoFornecedor.getValor());
                                        fornecedorSelecionado.setValorPago(fornecedorSelecionado.getValorOriginalAPagar() - fornecedorSelecionado.getValorAPagar());
                                    }

                                } else {
                                    fornecedorSelecionado.setEstado("Pago");
                                    pagamentoDoFornecedor.setValor(fornecedorSelecionado.getValorOriginalAPagar());
                                    pagamentoDoFornecedor.setParcela(0);
                                    fornecedorSelecionado.setValorPago(pagamentoDoFornecedor.getValor());
                                    fornecedorSelecionado.setValorAPagar(0);
                                    System.out.println("A Vista");
                                }

                            } else {
                                Gui.mostrarMensagemAviso("Nenhum fornecedor disponivel encontrado insira informações de fornecedores referente a esse pagamento", "Aviso", 1);

                            }

                        }
                    } else {
                        Gui.mostrarMensagemAviso("Nenhum fornecedor disponivel encontrado insira informações de fornecedores referente a esse pagamento", "Aviso", 1);
                        Fornecedor f = Gui.CriarFornecedor();
                        if (FornecedorDao.inserir(f) != -1) {
                            Gui.mostrarMensagemAviso("Fornecedor Criado", "Aviso", 1);
                        } else {
                            Gui.mostrarMensagemAviso("Erro ao Criar Fornecedor", "Aviso", 2);
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

    private boolean menuPresenteLoop(int opcaoUsuario) {
        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    int resposta = 1;
                    if (!PessoasDao.mostrar(null).equals("")) {
                        Object[] options = {"Sim", "Não"};
                        resposta = Gui.mostrarMensagemBots("Voce deseja atrelar uma pessoa a esse presente?", "Opção presente", -1, options);
                    }

                    if (resposta == 0) {
                        int idresposta = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID da pessoa que esta presenteando:\n" + PessoasDao.mostrar(null), "Pessoa Presente", 1, "0"));

                        if (PessoasDao.buscar(idresposta) != null) {
                            if (PresentesDao.inserir(Gui.CriarPresente(PessoasDao.buscar(idresposta))) != -1) {
                                Gui.mostrarMensagemAviso("Presente Criado", "Aviso", 1);
                            } else {
                                Gui.mostrarMensagemAviso("Erro ao Criar Presente", "Aviso", 2);
                            }
                        } else {
                            Gui.mostrarMensagemAviso("ID invalido", "Aviso", 2);
                        }
                    } else if (resposta == 1) {
                        if (PresentesDao.inserir(Gui.CriarPresente(null)) != -1) {
                            Gui.mostrarMensagemAviso("Presente Criado", "Aviso", 1);
                        } else {
                            Gui.mostrarMensagemAviso("Erro ao Criar Presente", "Aviso", 2);
                        }
                    }
                    break;
                case 1:
                    if (!PresentesDao.mostrar(null).equals("")) {
                        Gui.mostrarMensagemAviso("Presentes : \n" + PresentesDao.mostrar(null), "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Nenhum Presente cadastrado", "Aviso", 2);
                    }
                    break;
                case 2:
                    int idAltera = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID de um Presente a ser alterado", "Alterar Presente", 1, "0"));
                    int idresposta = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID da pessoa que esta presenteando: (deixe vazio caso não queira alterar)\n" + PessoasDao.mostrar(null), "Alterar Presente", 1, ""));

                    if (PessoasDao.buscar(idresposta) != null) {
                        if (PresentesDao.buscar(idAltera) != null
                                && PresentesDao.alterar(Gui.CriarPresente(PresentesDao.buscar(idresposta).getPessoa()), idAltera) != false) {
                            Gui.mostrarMensagemAviso("Presente Alterado", "Aviso", 1);
                        } else {
                            Gui.mostrarMensagemAviso("Erro ao Alterar Presente", "Aviso", 2);
                        }
                    } else {
                        if (PresentesDao.buscar(idAltera) != null
                                && PresentesDao.alterar(Gui.CriarPresente(PresentesDao.buscar(idAltera).getPessoa()), idAltera) != false) {
                            Gui.mostrarMensagemAviso("Presente Alterado", "Aviso", 1);
                        } else {
                            Gui.mostrarMensagemAviso("Erro ao Alterar Presente", "Aviso", 2);
                        }
                    }

                    break;
                case 3:
                    int idDelete = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID do Presente a ser deletado", "Deletar Presente", 1, "0"));
                    if (PresentesDao.deletar(idDelete)) {
                        Gui.mostrarMensagemAviso("Presente Deletado", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Deletar Presente", "Aviso", 2);
                    }

                    break;
                case 4:
                    int idBuscar = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID do Presente a ser buscado", "Recado Presente", 1, "0"));
                    if (PresentesDao.buscar(idBuscar) != null) {
                        Gui.mostrarMensagemAviso("Presente : \n" + PresentesDao.mostrar(PresentesDao.buscar(idBuscar)), "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Presente não encontrado", "Aviso", 2);
                    }

                    break;
                case 5:
                    if (!PessoasDao.mostrar(null).equals("")) {
                        idresposta = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID da pessoa que esta presenteando: \n" + PessoasDao.mostrar(null), "Presentear", 1, "0"));
                        int idPresente = Gui.validarStringToInt(Gui.mostrarMensagemInput("Digite o ID de um Presente a ser atrelado a pessoa \n" + PresentesDao.mostrar(null), "Presentear", 1, "0"));

                        if (PresentesDao.buscar(idPresente) != null && PessoasDao.buscar(idresposta) != null) {
                            PresentesDao.buscar(idPresente).setPessoa(PessoasDao.buscar(idresposta));
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
                    if (!MuralDeRecadosDao.mostrar(null).equals("")) {
                        int j = 0;
                        int tamVet = 1000;
                        String[] conteudoMr = new String[tamVet];

                        for (int i = 0; i < conteudoMr.length; i++) {
                            conteudoMr[i] = "";
                        }

                        for (MuralDeRecados mr : MuralDeRecadosDao.GetDataBase()) {
                            if (j <= tamVet) {
                                conteudoMr[j] += "ID: ";
                                conteudoMr[j] += mr.getId();
                                conteudoMr[j] += " | Nome: ";
                                conteudoMr[j] += mr.getPessoa().getNome();
                                conteudoMr[j] += " | Comentário: ";
                                conteudoMr[j] += mr.getComentario();
                                conteudoMr[j] += " | Data de Criação: ";
                                conteudoMr[j] += mr.getDataCriacao();
                                conteudoMr[j] += " | Última Modificação: ";
                                conteudoMr[j] += mr.getDataModificacao();

                                j++;
                            } else {
                                Gui.mostrarMensagemAviso("Quantidade maxima de relatorios atingida, se nescessario contrate uma expansão.", "Aviso", 2);
                            }
                        }

                        Gui.RelatorioRecados(conteudoMr);
                    } else {
                        Gui.mostrarMensagemAviso("Nenhum recado cadastrado", "Aviso", 2);
                    }
                    break;

                case 1:
                    if (!ConvidadoIndividualDao.mostrar(null).equals("")) {
                        boolean verificacao = false;
                        int option;
                        while (verificacao != true) {
                            String resp = Gui.mostrarMensagemInput("Qual convidado você gostaria de Gerar o convite? digite o ID: \n" + ConvidadoIndividualDao.mostrar(null), "Escolha um Convidado", 3, "0");

                            if (resp == null) {
                                return true;
                            } else {
                                option = Gui.validarStringToInt(resp);
                            }

                            for (ConvidadoIndividual ci : ConvidadoIndividualDao.GetDataBase()) {
                                if (ci.getId() == option && option != -1) {
                                    verificacao = true;
                                }
                            }

                            if (verificacao == true) {
                                Gui.mostrarConviteIndividual(ConvidadoIndividualDao.buscar(option));
                            } else {
                                Gui.mostrarMensagemAviso("ID invalido", "Aviso", 1);
                            }
                        }
                    } else {
                        Gui.mostrarMensagemAviso("Nenhum convidado cadastrado", "Aviso", 2);
                    }
                    break;

                case 2:
                    boolean verificacao = false;
                    int option;
                    while (verificacao != true) {
                        String resp = Gui.mostrarMensagemInput("Qual família você gostaria de Gerar o convite? digite o ID: \n" + ConvidadoFamiliaDao.mostrar(null), "Escolha uma Familia", 3, "0");

                        if (resp == null) {
                            return true;
                        } else {
                            option = Gui.validarStringToInt(resp);
                        }

                        for (ConvidadoFamilia cf : ConvidadoFamiliaDao.GetDataBase()) {
                            if (cf.getId() == option && option != -1) {
                                verificacao = true;
                            }
                        }

                        if (verificacao == true) {
                            Gui.mostrarConviteFamilia(ConvidadoFamiliaDao.buscar(option));
                        } else {
                            Gui.mostrarMensagemAviso("ID invalido", "Aviso", 1);
                        }
                    }
                    break;

                case 3:
                    if (!PagamentosDao.mostrar(null).equals("")) {
                        int j = 0;
                        int tamVet = 1000;
                        String[] conteudoP = new String[tamVet];

                        for (int i = 0; i < conteudoP.length; i++) {
                            conteudoP[i] = "";
                        }
                        double valorTotal = 0;
                        for (Pagamentos p : PagamentosDao.GetDataBase()) {
                            if (j <= tamVet) {
                                conteudoP[j] += "ID: ";
                                conteudoP[j] += p.getId();
                                conteudoP[j] += " | Nome: ";
                                conteudoP[j] += p.getPessoa().getNome();
                                conteudoP[j] += " | Descrição: ";
                                conteudoP[j] += p.getDescricao();
                                conteudoP[j] += " | Valor: ";
                                conteudoP[j] += p.getValor();
                                conteudoP[j] += " | Parcelas: ";
                                conteudoP[j] += p.getParcela();
                                j++;
                                valorTotal += p.getValor();
                            } else {
                                Gui.mostrarMensagemAviso("Quantidade maxima de relatorios atingida, se nescessario contrate uma expansão.", "Aviso", 2);
                            }
                        }

                        Gui.RelatorioPagamento(conteudoP, valorTotal);
                    } else {
                        Gui.mostrarMensagemAviso("Nenhum pagamento cadastrado", "Aviso", 2);
                    }

                    break;
                case 4:
                    if (!ConvidadoIndividualDao.mostrar(null).equals("")) {
                        int j = 0;
                        int tamVet = 1000;
                        String[] conteudoC = new String[tamVet];

                        for (int i = 0; i < conteudoC.length; i++) {
                            conteudoC[i] = "";
                        }

                        for (ConvidadoIndividual ci : ConvidadoIndividualDao.GetDataBase()) {
                            if (j <= tamVet) {
                                conteudoC[j] += "ID: ";
                                conteudoC[j] += ci.getId();
                                conteudoC[j] += " | Nome: ";
                                conteudoC[j] += ci.getPessoa().getNome();
                                conteudoC[j] += " | Data de Nascimento: ";
                                conteudoC[j] += ci.getPessoa().getNascimento();
                                conteudoC[j] += " | Confirmação: ";
                                conteudoC[j] += ci.getConfirmacao();
                                conteudoC[j] += " | Família: ";
                                conteudoC[j] += ci.getFamilia();
                                conteudoC[j] += " | Parentesco: ";
                                conteudoC[j] += ci.getParentesco();
                                conteudoC[j] += " | Data de Criação: ";
                                conteudoC[j] += ci.getDataCriacao();
                                conteudoC[j] += " | Última Modificação: ";
                                conteudoC[j] += ci.getDataModificacao();

                                j++;
                            } else {
                                Gui.mostrarMensagemAviso("Quantidade maxima de relatorios atingida, se nescessario contrate uma expansão.", "Aviso", 2);
                            }
                        }

                        Gui.RelatorioConvidados(conteudoC);
                    } else {
                        Gui.mostrarMensagemAviso("Nenhum convidado cadastrado", "Aviso", 2);
                    }
                    break;
                case 5:
                    boolean temConfirmado = false;
                    for (ConvidadoIndividual c : ConvidadoIndividualDao.GetDataBase()) {
                        if (c.getConfirmacao() == "Confirmado") {
                            temConfirmado = true;
                            break;
                        }
                    }
                    if (temConfirmado) {

                        int j = 0;
                        int tamVet = 1000;
                        String[] conteudoC = new String[tamVet];
                        double totalDePontos = 0;

                        for (int i = 0; i < conteudoC.length; i++) {
                            conteudoC[i] = "";
                        }

                        for (ConvidadoIndividual ci : ConvidadoIndividualDao.GetDataBase()) {
                            int idade = Util.calcularIdade(ci.getPessoa().getNascimento());
                            double ponto = 0;

                            if (idade >= 9 && idade <= 13) {
                                ponto = 0.5;
                            } else {
                                ponto = 1;
                            }

                            if (j <= tamVet) {
                                conteudoC[j] += "ID: ";
                                conteudoC[j] += ci.getId();
                                conteudoC[j] += " | Nome: ";
                                conteudoC[j] += ci.getPessoa().getNome();
                                conteudoC[j] += " | Data de Nascimento: ";
                                conteudoC[j] += ci.getPessoa().getNascimento();
                                conteudoC[j] += " | Confirmação: ";
                                conteudoC[j] += ci.getConfirmacao();
                                conteudoC[j] += " | Família: ";
                                conteudoC[j] += ci.getFamilia();
                                conteudoC[j] += " | Parentesco: ";
                                conteudoC[j] += ci.getParentesco();
                                conteudoC[j] += " | Ponto eq: ";
                                conteudoC[j] += ponto;
                                conteudoC[j] += " | Data de Criação: ";
                                conteudoC[j] += ci.getDataCriacao();
                                conteudoC[j] += " | Última Modificação: ";
                                conteudoC[j] += ci.getDataModificacao();

                                j++;

                            } else {
                                Gui.mostrarMensagemAviso("Quantidade maxima de relatorios atingida, se nescessario contrate uma expansão.", "Aviso", 2);
                            }
                            totalDePontos += ponto;
                        }

                        Gui.RelatorioConvidadosConfirmados(conteudoC, totalDePontos);

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
                                Gui.mostrarMensagemAviso("Calendario atualizado", "Aviso", 2);
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
                                Gui.mostrarMensagemAviso("Calendario atualizado", "Aviso", 2);
                            } else {
                                Gui.mostrarMensagemAviso("Quantidade de dias invalido", "Aviso", 2);
                            }
                        }
                    }
                    break;
                case 2:
                    boolean validacao = false;
                    while (validacao == false) {
                        String resp = Gui.mostrarMensagemInput("Digite a data desejada", "Definir Data", 3, "1");

                        if (resp == null) {
                            break;
                        } else {

                            if (Gui.validarData(resp) != null) {
                                validacao = true;
                                Util.setData(Gui.validarData(resp));
                                Gui.mostrarMensagemAviso("Calendario atualizado", "Aviso", 2);
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new SoftwareCasamento();
    }

}
