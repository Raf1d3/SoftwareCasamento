/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import control.GenericDAO;
import model.Pessoas;
import control.UsuarioDAO;

/**
 *
 * @author pse
 */
public class PessoasDAO extends GenericDAO<Pessoas> {

    public PessoasDAO() {
        inserir(new Pessoas("Douglas Martins", Util.parseDataLocal("10/10/1995"), "123555488"));
        inserir(new Pessoas("Mariana Almeida", Util.parseDataLocal("15/04/2005"), "987654321"));
        inserir(new Pessoas("Ana Clara", Util.parseDataLocal("02/06/2015"), "11987654321"));
        inserir(new Pessoas("Carlos Eduardo", Util.parseDataLocal("22/11/1985"), "2187654321"));
        inserir(new Pessoas("Miguel Rocha", Util.parseDataLocal("28/08/2014"), "21887654321"));
        inserir(new Pessoas("Lucas Martins", Util.parseDataLocal("13/03/1990"), "21998765432"));
        inserir(new Pessoas("Juliana Lima", Util.parseDataLocal("28/07/1994"), "11912345678"));
        inserir(new Pessoas("Beatriz Almeida", Util.parseDataLocal("22/11/2012"), "11912345678"));
        inserir(new Pessoas("Fernanda Ribeiro", Util.parseDataLocal("18/01/1993"), "11987651234"));
        inserir(new Pessoas("Ricardo Souza", Util.parseDataLocal("05/05/1991"), "11887654321"));
        inserir(new Pessoas("Pedro Henrique", Util.parseDataLocal("27/05/2014"), "21876543212"));
        inserir(new Pessoas("Patricia Santos", Util.parseDataLocal("12/12/1988"), "2176543211"));
        inserir(new Pessoas("Bruno Oliveira", Util.parseDataLocal("23/09/1996"), "21987654322"));
        inserir(new Pessoas("João Pedro", Util.parseDataLocal("15/06/2010"), "11987654321"));
    }

}
