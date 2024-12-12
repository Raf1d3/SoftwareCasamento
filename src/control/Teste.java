/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import model.Cartorio;
import model.Cerimonial;
import model.ConvidadoFamilia;
import model.ConvidadoIndividual;
import model.Evento;
import model.Fornecedor;
import model.Igreja;
import model.MuralDeRecados;
import model.Pagamentos;
import model.Pessoas;
import model.Presentes;
import model.Usuario;

/**
 *
 * @author pse
 */
public class Teste {

    public Teste() {
        ConexaoBanco.setParametrosDeConexao("root", "admin", "BDSofwareDeCasamento");

        GenericDAO<Fornecedor> FornecedorDao = new GenericDAO(Fornecedor.class);
        GenericDAO<MuralDeRecados> MuralDeRecadosDao = new GenericDAO(MuralDeRecados.class);
        GenericDAO<Pagamentos> PagamentosDao = new GenericDAO(Pagamentos.class);
        GenericDAO<Presentes> PresentesDao = new GenericDAO(Presentes.class);
        GenericDAO<Pessoas> PessoasDao = new GenericDAO(Pessoas.class);
        UsuarioDAO UsuarioDao = new UsuarioDAO(Usuario.class);
        GenericDAO<Cerimonial> CerimonialDao = new GenericDAO(Cerimonial.class);
        GenericDAO<Igreja> IgrejaDao = new GenericDAO(Igreja.class);
        GenericDAO<Cartorio> CartorioDao = new GenericDAO(Cartorio.class);
        GenericDAO<Evento> EventoDao = new GenericDAO(Evento.class);
        ConvidadoFamiliaDAO ConvidadoFamiliaDao = new ConvidadoFamiliaDAO(ConvidadoFamilia.class);
        GenericDAO<ConvidadoIndividual> ConvidadoIndividualDao = new GenericDAO(ConvidadoIndividual.class);

        PessoasDao.adiciona(new Pessoas("Douglas Martins", Util.parseDataLocal("10/10/1995"), "123555488"));
        PessoasDao.adiciona(new Pessoas("Mariana Almeida", Util.parseDataLocal("15/04/2005"), "987654321"));
        PessoasDao.adiciona(new Pessoas("Beatriz Almeida", Util.parseDataLocal("02/06/2015"), "11987654321"));
        PessoasDao.adiciona(new Pessoas("Carlos Eduardo", Util.parseDataLocal("22/11/1985"), "2187654321"));
        PessoasDao.adiciona(new Pessoas("Miguel Rocha", Util.parseDataLocal("28/08/2014"), "21887654321"));
        PessoasDao.adiciona(new Pessoas("Lucas Martins", Util.parseDataLocal("13/03/1990"), "21998765432"));
        PessoasDao.adiciona(new Pessoas("Juliana Lima", Util.parseDataLocal("28/07/1994"), "11912345678"));
        PessoasDao.adiciona(new Pessoas("Ana Clara", Util.parseDataLocal("22/11/2012"), "11912345678"));
        PessoasDao.adiciona(new Pessoas("Fernanda Ribeiro", Util.parseDataLocal("18/01/1993"), "11987651234"));
        PessoasDao.adiciona(new Pessoas("Ricardo Souza", Util.parseDataLocal("05/05/1991"), "11887654321"));
        PessoasDao.adiciona(new Pessoas("Pedro Henrique", Util.parseDataLocal("27/05/2014"), "21876543212"));
        PessoasDao.adiciona(new Pessoas("Patricia Santos", Util.parseDataLocal("12/12/1988"), "2176543211"));
        PessoasDao.adiciona(new Pessoas("Bruno Oliveira", Util.parseDataLocal("23/09/1996"), "21987654322"));
        PessoasDao.adiciona(new Pessoas("João Pedro", Util.parseDataLocal("15/06/2010"), "11987654321"));

        UsuarioDao.adiciona(new Usuario(PessoasDao.buscar(1), "Administrador", "admin", "123"));

        CartorioDao.adiciona(new Cartorio("Cartorio do 1° Oficio de Notas", "Rua Castro Alves, Areão, N°200", "(34)3331-1303", Util.parseDataLocal("12/10/2024")));
        CerimonialDao.adiciona(new Cerimonial("xique cerimonias", "(34)3344-8500", "xiquecontato@cerimonialvip.com.br"));
        IgrejaDao.adiciona(new Igreja("igreja São Martins", "Rua Domingos Martins da Cruz, Curado, N°225", "(34)3315-8200"));

        EventoDao.adiciona(new Evento(Util.parseDataLocal("18/10/2024"), CerimonialDao.buscar(1), IgrejaDao.buscar(1), CartorioDao.buscar(1), PessoasDao.buscar(2), PessoasDao.buscar(1), "casamento"));

        ConvidadoIndividualDao.adiciona(new ConvidadoIndividual(PessoasDao.buscar(1), "almeida", "noivo"));
        ConvidadoIndividualDao.adiciona(new ConvidadoIndividual(PessoasDao.buscar(2), "almeida", "noiva"));
        ConvidadoIndividualDao.adiciona(new ConvidadoIndividual(PessoasDao.buscar(3), "almeida", "Filha"));

        ConvidadoFamiliaDao.adiciona(new ConvidadoFamilia("almeida"));

        FornecedorDao.adiciona(new Fornecedor("Serviço de buffet e montagem", "06.961.368/0001-00", "34957654322", 2000, PessoasDao.buscar(4), 4));

        PresentesDao.adiciona(new Presentes("Faqueiro (jogo de talheres)", "Cozinha | Geral", new BigDecimal("100.00"), null));
        PresentesDao.adiciona(new Presentes("Aparelho de jantar", "Cozinha | Geral", new BigDecimal("150.00"), null));
        PresentesDao.adiciona(new Presentes("Jogo de panelas", "Cozinha | Geral", new BigDecimal("200.00"), null));
        PresentesDao.adiciona(new Presentes("Jogo de formas e assadeiras", "Cozinha | Geral", new BigDecimal("80.00"), null));
        PresentesDao.adiciona(new Presentes("Chaleira", "Cozinha | Geral", new BigDecimal("50.00"), null));
        PresentesDao.adiciona(new Presentes("Jogo de copos", "Cozinha | Geral", new BigDecimal("30.00"), null));
        PresentesDao.adiciona(new Presentes("Bule e leiteira", "Cozinha | Geral", new BigDecimal("40.00"), null));
        PresentesDao.adiciona(new Presentes("Garrafa térmica", "Cozinha | Geral", new BigDecimal("35.00"), null));
        PresentesDao.adiciona(new Presentes("Balança para cozinha", "Cozinha | Geral", new BigDecimal("45.00"), null));
        PresentesDao.adiciona(new Presentes("Jogo de facas", "Cozinha | Geral", new BigDecimal("55.00"), null));
        PresentesDao.adiciona(new Presentes("Tábua para queijos e frios", "Cozinha | Geral", new BigDecimal("25.00"), null));

        PresentesDao.adiciona(new Presentes("Jogo de lençóis", "Decoração e cama, mesa e banho", new BigDecimal("120.00"), null));
        PresentesDao.adiciona(new Presentes("Edredom", "Decoração e cama, mesa e banho", new BigDecimal("200.00"), null));
        PresentesDao.adiciona(new Presentes("Manta", "Decoração e cama, mesa e banho", new BigDecimal("80.00"), null));
        PresentesDao.adiciona(new Presentes("Cobertor", "Decoração e cama, mesa e banho", new BigDecimal("100.00"), null));
        PresentesDao.adiciona(new Presentes("Jogo de toalhas de banho", "Decoração e cama, mesa e banho", new BigDecimal("70.00"), null));
        PresentesDao.adiciona(new Presentes("Toalhas de mesa", "Decoração e cama, mesa e banho", new BigDecimal("60.00"), null));
        PresentesDao.adiciona(new Presentes("Castiçais e velas", "Decoração e cama, mesa e banho", new BigDecimal("50.00"), null));

        PresentesDao.adiciona(new Presentes("Cama", "Móveis e Eletrônicos", new BigDecimal("800.00"), null));
        PresentesDao.adiciona(new Presentes("Colchão", "Móveis e Eletrônicos", new BigDecimal("600.00"), null));
        PresentesDao.adiciona(new Presentes("Sofá", "Móveis e Eletrônicos", new BigDecimal("1000.00"), null));
        PresentesDao.adiciona(new Presentes("TV", "Móveis e Eletrônicos", new BigDecimal("1200.00"), null));
        PresentesDao.adiciona(new Presentes("Mesa e cadeiras de jantar", "Móveis e Eletrônicos", new BigDecimal("700.00"), null));
        PresentesDao.adiciona(new Presentes("Rack", "Móveis e Eletrônicos", new BigDecimal("250.00"), null));

        MuralDeRecadosDao.adiciona(new MuralDeRecados(PessoasDao.buscar(1), "Bom dia, pessoal bem vindos ao software de casamento"));
        MuralDeRecadosDao.adiciona(new MuralDeRecados(PessoasDao.buscar(2), "Bom dia !!!"));
        MuralDeRecadosDao.adiciona(new MuralDeRecados(PessoasDao.buscar(4), "Dia, parabens pelo casamento"));
        MuralDeRecadosDao.adiciona(new MuralDeRecados(PessoasDao.buscar(7), "Pessoal não esqueçam de confirmar a pesença de voces em"));
        MuralDeRecadosDao.adiciona(new MuralDeRecados(PessoasDao.buscar(2), "É mesmo pessoal a confirmação é muito importante"));
        MuralDeRecadosDao.adiciona(new MuralDeRecados(PessoasDao.buscar(6), "Já confirmei a minha e da minha familia !!!"));
        MuralDeRecadosDao.adiciona(new MuralDeRecados(PessoasDao.buscar(9), "Eu tambem"));
        MuralDeRecadosDao.adiciona(new MuralDeRecados(PessoasDao.buscar(10), "Estou ansioso para o evento."));

//PresentesDao.adiciona(new Presentes("Jbl boom box 5", "Eletronico", BigDecimal.valueOf(1000.5), null));
        //System.out.println(PresentesDao.buscar(2));
        /*
        GeradorPdf.setCaminho("arquivosPdfs/");
        
        
        
        List<String> lista = new ArrayList();

        List<MuralDeRecados> listar = MuralDeRecadosDao.listar();
        
        for (MuralDeRecados a : listar) {
            lista.add(a.toString());
        }
        
        GeradorPdf.gerarPdf("Relatorio mural de recados", lista, "MuralDeRecadosRelatorio");
        
        
        ConvidadoIndividual ci = ConvidadoIndividualDao.buscar(1);
        
        List<String> lista2 = new ArrayList();
        
        lista2.add(ci.toString());
        
        
        //GeradorPdf.gerarPdf("Relatorio Convidado Individual", lista2, "ConvidadoIndividualRelatorio" + ci.getPessoa().getNome());
         */
    }

    public static void main(String[] args) {
        new Teste();

    }

}
