/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package control;

import view.GUI;
import EntreTapasEBeijos.PessoasDAO;
import model.Pessoas;
import model.Usuario;
/**
 *
 * @author CAUPT - ALUNOS
 */
public class SoftwareCasamento {

    GUI Gui = new GUI();
    
    GenericDAO<Pessoas> pessoasDao = new GenericDAO<>();
    //GenericDAO<Usuario> UsuarioDao = new GenericDAO<>();
    UsuarioDAO UsuarioDao = new UsuarioDAO();
    
    //PessoasDAO pessoasDao = new PessoasDAO();
    //UsuarioDAO UsuarioDao = new UsuarioDAO();
    public SoftwareCasamento() {
        System.out.println("Log programa");
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
                    } else {
                        Gui.mostrarMensagemAviso("Usuario invalido", "Aviso", 2);
                        break;

                    }

                    break;
                case 1:
                        MenuConvidadoLoop(Gui.menuConvidadoOpcoes());
                    break;
                default:
                    Gui.mostrarMensagemAviso("escola uma opcao valida !!", "Aviso", 2);
                    break;
            }

            opcaoUsuario = Gui.MenuLoginOpcoes();

        }
        System.out.println("Menu Fechado");
    }

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

            opcaoUsuario = Gui.menuPessoasOpcoes();

        }
        System.out.println("Menu Fechado");
    }
    // menu de acesso ao painel de convidado
    private void MenuConvidadoLoop(int opcaoUsuario) {

        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    Gui.mostrarMensagemAviso("Confirmando", "Aviso", 1);
                    break;
                case 1:
                    Gui.mostrarMensagemAviso("Adicionando recado", "Aviso", 1);
                    break;
                case 2:
                    Gui.mostrarMensagemAviso("Dando presente", "Aviso", 1);
                    break;
                case 9:
                    Gui.mostrarMensagemAviso("saindo","Aviso", 1);
                    break;
                default:
                    Gui.mostrarMensagemAviso("Escola uma opcao valida !!", "Aviso", 2);
                    break;
            }

            opcaoUsuario = Gui.menuConvidadoOpcoes();

        }
        System.out.println("Menu Fechado");
    }
    
    

    // menu de acesso ao painel do administrador
    private void MenuAcessoAdministradorLoop(int opcaoUsuario) {

        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    menuPessoasLoop(Gui.menuPessoasOpcoes());
                    break;
                case 1:
                    menuUsuariosLoop(Gui.menuUsuariosOpcoes());
                    break;
                case 2:
                    menuTesteLoop(Gui.menuFornecedoresOpcoes());
                    break;
                case 3:
                    menuTesteLoop(Gui.menuConvidadosOpcoes());
                    break;
                case 4:
                    menuTesteLoop(Gui.menuEventoOpcoes());
                    break;
                case 5:
                    menuTesteLoop(Gui.menuMuralDeRecadosOpcoes());
                    break;
                case 6:
                    menuTesteLoop(Gui.menuPagamentosOpcoes());
                    break;
                case 7:
                    menuTesteLoop(Gui.menuPresentesOpcoes());
                    break;
                case 9:
                    Gui.mostrarMensagemAviso("saindo","Aviso", 1);
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
                    pessoasDao.inserir(Gui.CriarPessoa());
                    Gui.mostrarMensagemAviso("Pessoa Criada", "Aviso", 1);
                    break;
                case 1:
                    Gui.mostrarMensagemAviso("Pessoas: \n" + pessoasDao.mostrar(null), "Aviso", 1);
                    break;
                case 2:
                    int idAlteraPessoa = Integer.parseInt(Gui.mostrarMensagemInput("Digite o id do usuario a ser alterado", "Alterar Usuario", 1,"0"));
                    pessoasDao.alterar(Gui.CriarPessoa(), pessoasDao.buscar(idAlteraPessoa));
                    Gui.mostrarMensagemAviso("Pessoa Alterada", "Aviso", 3);
                    break;
                case 3:
                    int idDeletePessoa = Integer.parseInt(Gui.mostrarMensagemInput("Digite o id do usuario a ser deletado", "Deletar Usuario", 1,"0"));
                    pessoasDao.deletar(pessoasDao.buscar(idDeletePessoa), idDeletePessoa);
                    Gui.mostrarMensagemAviso("Pessoa Deletada", "Aviso", 3);
                    break;
                case 4:
                    int idBuscarPessoa = Integer.parseInt(Gui.mostrarMensagemInput("Digite o id do usuario a ser buscado", "Buscar Usuario", 1,"0"));
                    Gui.mostrarMensagemAviso("Pessoas \n" + pessoasDao.mostrar(pessoasDao.buscar(idBuscarPessoa)), "Aviso", 3);
                    break;
                case 9:
                    Gui.mostrarMensagemAviso("Saindo", "Aviso", 1);
                    break;
                default:
                    Gui.mostrarMensagemAviso("Escolha uma opcao valida !!", "Aviso", 2);
                    break;
            }

            opcaoUsuario = Gui.menuPessoasOpcoes();

        }
        System.out.println("Menu Fechado");
    }
    

    private void menuUsuariosLoop(int opcaoUsuario) {

        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    UsuarioDao.inserir(Gui.CriarUsuario());
                    Gui.mostrarMensagemAviso("Usuario Criado", "Aviso", 1);
                    break;
                case 1:
                    Gui.mostrarMensagemAviso("Usuarios : \n" + UsuarioDao.mostrar(null), "Aviso", 1);
                    break;
                case 2:
                    int idAlteraUsuario = Integer.parseInt(Gui.mostrarMensagemInput("Digite o id do usuario a ser alterado", "Alterar Usuario", 1, "0"));
                    UsuarioDao.alterar(Gui.CriarUsuario(), UsuarioDao.buscar(idAlteraUsuario));
                    Gui.mostrarMensagemAviso("Usuario Alterada", "Aviso", 1);
                    break;
                case 3:
                    int idDeleteUsuario = Integer.parseInt(Gui.mostrarMensagemInput("Digite o id do usuario a ser deletado", "Deletar Usuario", 1, "0"));
                    UsuarioDao.deletar(UsuarioDao.buscar(idDeleteUsuario), idDeleteUsuario);
                    Gui.mostrarMensagemAviso("Usuario Deletada", "Aviso", 1);
                    break;
                case 4:
                    int idBuscarUsuario = Integer.parseInt(Gui.mostrarMensagemInput("Digite o id do usuario a ser buscado", "Buscar Usuario", 1, "0"));
                    Gui.mostrarMensagemAviso("Usuario \n" + UsuarioDao.mostrar(UsuarioDao.buscar(idBuscarUsuario)), "Aviso", 1);
                    break;
                case 9:
                    Gui.mostrarMensagemAviso("Saindo", "Aviso", 1);
                    break;
                default:
                    Gui.mostrarMensagemAviso("Escolha uma opcao valida !!", "Aviso", 2);
                    break;
            }

            opcaoUsuario = Gui.menuPessoasOpcoes();

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
