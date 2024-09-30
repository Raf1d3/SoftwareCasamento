/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package EntreTapasEBeijos;

import EntreTapasEBeijos.PessoasDAO;
import EntreTapasEBeijos.GUI;
import javax.swing.JOptionPane;

/**
 *
 * @author CAUPT - ALUNOS
 */
public class SoftwareCasamento {

    GUI Gui = new GUI();
    PessoasDAO pessoasDao = new PessoasDAO();

    public SoftwareCasamento() {
        System.out.println("Rodou");
        MenuLoginLoop(Gui.MenuLoginOpcoes());
    }

    //menu de login e boas vindas
    private void MenuLoginLoop(int opcaoUsuario) {

        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:

                    String login = JOptionPane.showInputDialog(null, "Digite seu login:", "Login", JOptionPane.INFORMATION_MESSAGE);
                    String senha = JOptionPane.showInputDialog(null, "Digite sua senha:", "Senha", JOptionPane.INFORMATION_MESSAGE);
                    if (login.equals("admin") && senha.equals("")) {
                        MenuAcessoAdministradorLoop(Gui.menuAcessoAdministradorOpcoes());
                    } else {
                        JOptionPane.showOptionDialog(null, "Usuario invalido", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
                        break;

                    }

                    break;
                case 1:
                    Gui.mostrarMensagemAviso("<html><body><font color='red'>Entrando menu sem login</font></body></html>");
                    break;
                case 9:
                    Gui.mostrarMensagemAviso("saindo");
                    break;
                default:
                    Gui.mostrarMensagemAviso("escola uma opcao valida !!");
                    break;
            }

            opcaoUsuario = Gui.MenuLoginOpcoes();

        }
        System.out.println("Saí do menu");
    }

    //parte generica para testes
    private void menuTesteLoop(int opcaoUsuario) {

        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    Gui.mostrarMensagemAviso("Criando");
                    break;
                case 1:
                    Gui.mostrarMensagemAviso("Mostranado");
                    break;
                case 2:
                    Gui.mostrarMensagemAviso("Deletando");
                    break;
                case 3:
                    Gui.mostrarMensagemAviso("Alterarando");
                    break;
                case 4:
                    Gui.mostrarMensagemAviso("Buscando");
                case 9:
                    Gui.mostrarMensagemAviso("Saindo");
                    break;
                default:
                    Gui.mostrarMensagemAviso("Escolha uma opcao valida !!");
                    break;
            }

            opcaoUsuario = Gui.menuPessoasOpcoes();

        }
        System.out.println("Saí do menu");
    }

    // menu de acesso ao painel do administrador
    private void MenuAcessoAdministradorLoop(int opcaoUsuario) {

        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    menuPessoasLoop(Gui.menuPessoasOpcoes());
                    break;
                case 1:
                    menuTesteLoop(Gui.menuUsuariosOpcoes());
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
                    Gui.mostrarMensagemAviso("saindo");
                    break;
                default:
                    Gui.mostrarMensagemAviso("escola uma opcao valida !!");
                    break;
            }

            opcaoUsuario = Gui.menuAcessoAdministradorOpcoes();

        }
        System.out.println("Saí do menu");
    }

    // menu pessoas
    private void menuPessoasLoop(int opcaoUsuario) {

        while (opcaoUsuario != 9) {
            switch (opcaoUsuario) {
                case 0:
                    pessoasDao.inserir(Gui.CriarPessoa());
                    Gui.mostrarMensagemAviso("Pessoa Criado");
                    break;
                case 1:
                    Gui.mostrarMensagemAviso("Pessoas: \n" + pessoasDao.mostrar(null));
                    break;
                case 2:
                    int idAlteraPessoa = Integer.parseInt(Gui.mostrarMensagemInput("Digite o id do usuario a ser alterado", "Alterar Usuario", 1));
                    pessoasDao.alterar(Gui.CriarPessoa(), pessoasDao.buscar(idAlteraPessoa));
                    Gui.mostrarMensagemAviso("Pessoa Alterada");
                    break;
                case 3:
                    int idDeletePessoa = Integer.parseInt(Gui.mostrarMensagemInput("Digite o id do usuario a ser deletado", "Deletar Usuario", 1));
                    pessoasDao.deletar(pessoasDao.buscar(idDeletePessoa));
                    Gui.mostrarMensagemAviso("Pessoa Deletada");
                    break;
                case 4:
                    int idBuscarPessoa = Integer.parseInt(Gui.mostrarMensagemInput("Digite o id do usuario a ser buscado", "Buscar Usuario", 1));
                    Gui.mostrarMensagemAviso("<p>Pessoas</p> \n" + pessoasDao.mostrar(pessoasDao.buscar(idBuscarPessoa)));
                    break;
                case 9:
                    Gui.mostrarMensagemAviso("Saindo");
                    break;
                default:
                    Gui.mostrarMensagemAviso("Escolha uma opcao valida !!");
                    break;
            }

            opcaoUsuario = Gui.menuPessoasOpcoes();

        }
        System.out.println("Saí do menu");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new SoftwareCasamento();
    }

}
