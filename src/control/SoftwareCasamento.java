/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import view.GUI;
import EntreTapasEBeijos.PessoasDAO;
import model.Pessoas;
import model.Fornecedor;
import model.ConvidadoFamilia;
import model.ConvidadoIndividual;
import model.Evento;
import model.MuralDeRecados;
import model.Pagamentos;
import model.Presentes;

/**
 *
 * @author CAUPT - ALUNOS
 */
public class SoftwareCasamento {

    GUI Gui = new GUI();

    GenericDAO<Pessoas> pessoasDao = new GenericDAO<>();
    GenericDAO<Fornecedor> FornecedorDao = new GenericDAO<>();
    GenericDAO<ConvidadoIndividual> ConvidadoIndividualDao = new GenericDAO<>();
    GenericDAO<Evento> EventoDao = new GenericDAO<>();
    GenericDAO<MuralDeRecados> MuralDeRecadosDao = new GenericDAO<>();
    GenericDAO<Pagamentos> PagamentosDao = new GenericDAO<>();
    GenericDAO<Presentes> PresentesDao = new GenericDAO<>();
    ConvidadoFamiliaDAO ConvidadoFamiliaDao = new ConvidadoFamiliaDAO();
    UsuarioDAO UsuarioDao = new UsuarioDAO();

    public SoftwareCasamento() {
        System.out.println("Iniciando Logs do programa...");
        MenuLoginLoop(Gui.MenuLoginOpcoes());
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
                        MenuAcessoAdministradorLoop(Gui.menuAcessoAdministradorOpcoes());
                    } else if (ConvidadoFamiliaDao.autenticar(login, senha)) {
                        System.out.println("Acessando menu Responsavel Familiar...");
                        menuConfirmacaoConvidadoResponsavelLoop(Gui.menuConfirmacaoConvidadoResponsavelOpcoes());
                    } else {
                        Gui.mostrarMensagemAviso("Usuario invalido", "Aviso", 2);
                        System.out.println("Usuario invalido detectado...");
                        break;

                    }

                    break;
                case 1:
                    MenuLoginConvidadoLoop(Gui.menuLoginConvidadoOpcoes());
                    break;
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
    private void MenuLoginConvidadoLoop(int opcaoUsuario) {

        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    Gui.mostrarMensagemAviso("Adicionando recado", "Aviso", 1);
                    break;
                case 1:
                    Gui.mostrarMensagemAviso("Dando presente", "Aviso", 1);
                    break;
                case 9:
                    Gui.mostrarMensagemAviso("saindo", "Aviso", 1);
                    break;
                default:
                    Gui.mostrarMensagemAviso("Escola uma opcao valida !!", "Aviso", 2);
                    break;
            }

            opcaoUsuario = Gui.menuLoginConvidadoOpcoes();

        }
        System.out.println("Menu Fechado");
    }

    // menu de acesso ao painel do administrador
    private void MenuAcessoAdministradorLoop(int opcaoUsuario) {

        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    menuPessoasLoop(Gui.menuPessoaOpcoes());
                    break;
                case 1:
                    menuUsuariosLoop(Gui.menuUsuarioOpcoes());
                    break;
                case 2:
                    menuFornecedorLoop(Gui.menuFornecedorOpcoes());
                    break;
                case 3:
                    menuEscolhaTipoConvidadoLoop(Gui.menuEscolhaTipoConvidadoOpcoes());
                    break;
                case 4:
                    menuEventoLoop(Gui.menuEventoOpcoes());
                    break;
                case 5:
                    menuMuralDeRecadosLoop(Gui.menuMuralDeRecadosOpcoes());
                    break;
                case 6:
                    menuPagamentoLoop(Gui.menuPagamentoOpcoes());
                    break;
                case 7:
                    menuPresenteLoop(Gui.menuPresenteOpcoes());
                    break;
                case 9:
                    Gui.mostrarMensagemAviso("saindo", "Aviso", 1);
                    break;
                default:
                    Gui.mostrarMensagemAviso("Escola uma opcao valida !!", "Aviso", 2);
                    break;
            }

            opcaoUsuario = Gui.menuAcessoAdministradorOpcoes();

        }
        System.out.println("Menu Fechado");
    }

    // menu pessoas
    private void menuPessoasLoop(int opcaoUsuario) {

        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    if (pessoasDao.inserir(Gui.CriarPessoa()) != -1) {
                        Gui.mostrarMensagemAviso("Pessoa Criada", "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Inserir Pessoa", "Aviso", 2);
                    }
                    break;
                case 1:
                    if (!pessoasDao.mostrar(null).equals("")) {
                        Gui.mostrarMensagemAviso("Pessoas: \n" + pessoasDao.mostrar(null), "Aviso", 1);
                    } else {
                        Gui.mostrarMensagemAviso("Nenhuma pessoa cadastrada", "Aviso", 2);
                    }
                    break;
                case 2:
                    int idAltera = Integer.parseInt(Gui.mostrarMensagemInput("Digite o id do usuario a ser alterado", "Alterar Usuario", 1, "0"));
                    if (pessoasDao.alterar(Gui.CriarPessoa(), idAltera) != false) {
                        Gui.mostrarMensagemAviso("Pessoa Alterada", "Aviso", 3);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Alterar Pessoa", "Aviso", 2);
                    }
                    break;
                case 3:
                    int idDelete = Integer.parseInt(Gui.mostrarMensagemInput("Digite o id do usuario a ser deletado", "Deletar Usuario", 1, "0"));
                    if (pessoasDao.deletar(idDelete)) {
                        Gui.mostrarMensagemAviso("Pessoa Deletada", "Aviso", 3);
                    } else {
                        Gui.mostrarMensagemAviso("Erro ao Deletar Pessoa", "Aviso", 2);
                    }
                    break;
                case 4:
                    int idBuscar = Integer.parseInt(Gui.mostrarMensagemInput("Digite o id do usuario a ser buscado", "Buscar Usuario", 1, "0"));
                    if (pessoasDao.buscar(idBuscar) != null) {
                        Gui.mostrarMensagemAviso("Pessoas : \n" + pessoasDao.mostrar(pessoasDao.buscar(idBuscar)), "Aviso", 3);

                    } else {
                        Gui.mostrarMensagemAviso("Pessoa não encontrada", "Aviso", 2);
                    }
                    break;
                case 9:
                    Gui.mostrarMensagemAviso("Saindo", "Aviso", 1);
                    break;
                default:
                    Gui.mostrarMensagemAviso("Escolha uma opcao valida !!", "Aviso", 2);
                    break;
            }

            opcaoUsuario = Gui.menuPessoaOpcoes();

        }
        System.out.println("Menu Fechado");
    }

    private void menuUsuariosLoop(int opcaoUsuario) {

        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:

                    //UsuarioDao.inserir(Gui.CriarUsuario());
                    Gui.mostrarMensagemAviso("Usuario Criado", "Aviso", 1);
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
                case 9:
                    Gui.mostrarMensagemAviso("Saindo", "Aviso", 1);
                    break;
                default:
                    Gui.mostrarMensagemAviso("Escolha uma opcao valida !!", "Aviso", 2);
                    break;
            }

            opcaoUsuario = Gui.menuUsuarioOpcoes();

        }
        System.out.println("Menu Fechado");
    }

    private void menuFornecedorLoop(int opcaoUsuario) {

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
                case 9:
                    Gui.mostrarMensagemAviso("Saindo", "Aviso", 1);
                    break;
                default:
                    Gui.mostrarMensagemAviso("Escolha uma opcao valida !!", "Aviso", 2);
                    break;
            }

            opcaoUsuario = Gui.menuFornecedorOpcoes();

        }
        System.out.println("Menu Fechado");
    }

    private void menuConfirmacaoConvidadoResponsavelLoop(int opcaoUsuario) {

        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    Gui.mostrarMensagemAviso("Entrando menu Convidado Responsavel", "Aviso", 1);
                    break;
                case 9:
                    Gui.mostrarMensagemAviso("Saindo", "Aviso", 1);
                    break;
                default:
                    Gui.mostrarMensagemAviso("Escolha uma opcao valida !!", "Aviso", 2);
                    break;
            }

            opcaoUsuario = Gui.menuConfirmacaoConvidadoResponsavelOpcoes();

        }
        System.out.println("Menu Fechado");
    }

    private void menuEscolhaTipoConvidadoLoop(int opcaoUsuario) {

        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    menuConvidadoLoop(Gui.menuConvidadoOpcoes());
                    break;
                case 1:
                    menuConvidadoResponsavelLoop(Gui.menuConvidadoResponsavelOpcoes());
                    break;
                case 9:
                    Gui.mostrarMensagemAviso("Saindo", "Aviso", 1);
                    break;
                default:
                    Gui.mostrarMensagemAviso("Escolha uma opcao valida !!", "Aviso", 2);
                    break;
            }

            opcaoUsuario = Gui.menuEscolhaTipoConvidadoOpcoes();

        }
        System.out.println("Menu Fechado");
    }

    private void menuConvidadoResponsavelLoop(int opcaoUsuario) {
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
                case 9:
                    Gui.mostrarMensagemAviso("Saindo", "Aviso", 1);
                    break;
                default:
                    Gui.mostrarMensagemAviso("Escolha uma opcao valida !!", "Aviso", 2);
                    break;
            }

            opcaoUsuario = Gui.menuConvidadoResponsavelOpcoes();

        }
        System.out.println("Menu Fechado");
    }

    private void menuConvidadoLoop(int opcaoUsuario) {
        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    ConvidadoIndividualDao.inserir(Gui.CriarConvidadoIndividual());
                    Gui.mostrarMensagemAviso("Convidado Criado", "Aviso", 1);
                    break;
                case 1:
                    Gui.mostrarMensagemAviso("Convidados : \n" + ConvidadoIndividualDao.mostrar(null), "Aviso", 1);
                    break;
                case 2:
                    int idAltera = Integer.parseInt(Gui.mostrarMensagemInput("Digite o id de um Convidado a ser alterado", "Alterar Convidado", 1, "0"));
                    ConvidadoIndividualDao.alterar(Gui.CriarConvidadoIndividual(), idAltera);
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
                case 9:
                    Gui.mostrarMensagemAviso("Saindo", "Aviso", 1);
                    break;
                default:
                    Gui.mostrarMensagemAviso("Escolha uma opcao valida !!", "Aviso", 2);
                    break;
            }

            opcaoUsuario = Gui.menuConvidadoOpcoes();

        }
        System.out.println("Menu Fechado");
    }

    private void menuEventoLoop(int opcaoUsuario) {
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
                case 9:
                    Gui.mostrarMensagemAviso("Saindo", "Aviso", 1);
                    break;
                default:
                    Gui.mostrarMensagemAviso("Escolha uma opcao valida !!", "Aviso", 2);
                    break;
            }

            opcaoUsuario = Gui.menuEventoOpcoes();

        }
        System.out.println("Menu Fechado");
    }

    private void menuMuralDeRecadosLoop(int opcaoUsuario) {
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
                case 9:
                    Gui.mostrarMensagemAviso("Saindo", "Aviso", 1);
                    break;
                default:
                    Gui.mostrarMensagemAviso("Escolha uma opcao valida !!", "Aviso", 2);
                    break;
            }

            opcaoUsuario = Gui.menuMuralDeRecadosOpcoes();

        }
        System.out.println("Menu Fechado");
    }

    private void menuPagamentoLoop(int opcaoUsuario) {
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
                case 9:
                    Gui.mostrarMensagemAviso("Saindo", "Aviso", 1);
                    break;
                default:
                    Gui.mostrarMensagemAviso("Escolha uma opcao valida !!", "Aviso", 2);
                    break;
            }

            opcaoUsuario = Gui.menuPagamentoOpcoes();

        }
        System.out.println("Menu Fechado");
    }

    private void menuPresenteLoop(int opcaoUsuario) {
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
                case 9:
                    Gui.mostrarMensagemAviso("Saindo", "Aviso", 1);
                    break;
                default:
                    Gui.mostrarMensagemAviso("Escolha uma opcao valida !!", "Aviso", 2);
                    break;
            }

            opcaoUsuario = Gui.menuPresenteOpcoes();

        }
        System.out.println("Menu Fechado");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new SoftwareCasamento();
    }

}
