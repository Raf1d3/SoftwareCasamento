/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import model.ConvidadoFamilia;
import model.ConvidadoIndividual;
import model.Evento;
import model.Fornecedor;
import model.MuralDeRecados;
import model.Pagamentos;
import model.Pessoas;
import model.Presentes;
import model.Usuario;

/**
 *
 * @author pse
 */
public class Teste{

    public Teste() {
        ConexaoBanco.setParametrosDeConexao("root", "admin", "BDSofwareDeCasamento");

        //GenericDAO<Pessoas> PessoasDao = new GenericDAO(Pessoas.class);
        //GenericDAO<Usuario> UsuarioDao = new GenericDAO(Usuario.class);
        //GenericDAO<MuralDeRecados> MuralDeRecadosDao = new GenericDAO(MuralDeRecados.class);
        GenericDAO<Fornecedor> FornecedorDao = new GenericDAO(Fornecedor.class);
        GenericDAO<MuralDeRecados> MuralDeRecadosDao = new GenericDAO(MuralDeRecados.class);
        GenericDAO<Pagamentos> PagamentosDao = new GenericDAO(Pagamentos.class);
        GenericDAO<Presentes> PresentesDao = new GenericDAO(Presentes.class);
        GenericDAO<Pessoas> PessoasDao = new GenericDAO(Pessoas.class);
        UsuarioDAO UsuarioDao = new UsuarioDAO(Usuario.class);
        GenericDAO<Evento> EventoDao = new GenericDAO(Evento.class);
        ConvidadoFamiliaDAO ConvidadoFamiliaDao = new ConvidadoFamiliaDAO(ConvidadoFamilia.class);
        GenericDAO<ConvidadoIndividual> ConvidadoIndividualDao = new GenericDAO(ConvidadoIndividual.class);
        
        //PessoasDao.adiciona(new Pessoas("Algusto", Util.getDataAtual(), "40028922"));
        //UsuarioDao.adiciona(new Usuario(PessoasDao.buscar(1), "Administrador", "admin", "123"));
        
        //PresentesDao.adiciona(new Presentes("Jbl boom box 5", "Eletronico", BigDecimal.valueOf(1000.5), null));
        System.out.println(PresentesDao.buscar(2));
        
        
        
        
        /*
        List<Fornecedor> lista = FornecedorDao.listar();
        for (Fornecedor fornecedor : lista) {
        System.out.println(fornecedor.toString());
        }
         */
        
       
        
        
        
        
        
    }
    

    
    
    public static void main(String[] args) {
     new Teste();   
        
        
    }
    
    
    
    
}