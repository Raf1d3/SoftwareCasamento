/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import model.Cartorio;
import model.Cerimonial;
import model.Evento;
import model.Igreja;
import model.Pessoas;

/**
 *
 * @author pse
 */
public class EventoDAO extends GenericDAO<Evento> {

    public EventoDAO(Cartorio cartorio, Cerimonial cerimonial, Igreja igreja, Pessoas noiva, Pessoas noivo) {
        Evento evento = new Evento();
        evento.setCartorio(cartorio);
        evento.setCerimonial(cerimonial);
        evento.setIgreja(igreja);
        evento.setDataEvento(Util.parseDataLocal("18/10/2024"));
        evento.setNoiva(noiva);
        evento.setNoivo(noivo);
        evento.setNome("casamento");
        inserir(evento);
    }
    
}
