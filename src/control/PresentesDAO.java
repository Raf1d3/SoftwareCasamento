/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.math.BigDecimal;
import model.Presentes;

/**
 *
 * @author pse
 */
public class PresentesDAO  extends GenericDAO<Presentes> {

    public PresentesDAO() {
        // Cozinha | Geral
        inserir(new Presentes("Faqueiro (jogo de talheres)", "Cozinha | Geral", new BigDecimal("100.00")));
        inserir(new Presentes("Aparelho de jantar", "Cozinha | Geral", new BigDecimal("150.00")));
        inserir(new Presentes("Jogo de panelas", "Cozinha | Geral", new BigDecimal("200.00")));
        inserir(new Presentes("Jogo de formas e assadeiras", "Cozinha | Geral", new BigDecimal("80.00")));
        inserir(new Presentes("Chaleira", "Cozinha | Geral", new BigDecimal("50.00")));
        inserir(new Presentes("Jogo de copos", "Cozinha | Geral", new BigDecimal("30.00")));
        inserir(new Presentes("Jogo de taças", "Cozinha | Geral", new BigDecimal("60.00")));
        inserir(new Presentes("Bule e leiteira", "Cozinha | Geral", new BigDecimal("40.00")));
        inserir(new Presentes("Fruteira", "Cozinha | Geral", new BigDecimal("25.00")));
        inserir(new Presentes("Garrafa térmica", "Cozinha | Geral", new BigDecimal("35.00")));
        inserir(new Presentes("Balança para cozinha", "Cozinha | Geral", new BigDecimal("45.00")));
        inserir(new Presentes("Jogo de facas", "Cozinha | Geral", new BigDecimal("55.00")));
        inserir(new Presentes("Tábua para queijos e frios", "Cozinha | Geral", new BigDecimal("25.00")));
        /* 
        inserir(new Presentes("Tábua para carnes", "Cozinha | Geral", new BigDecimal("20.00")));
        inserir(new Presentes("Balde de gelo", "Cozinha | Geral", new BigDecimal("15.00")));
        inserir(new Presentes("Aparelho de café e chá", "Cozinha | Geral", new BigDecimal("120.00")));
        inserir(new Presentes("Bomboniere", "Cozinha | Geral", new BigDecimal("30.00")));
        inserir(new Presentes("Jogo de sobremesa", "Cozinha | Geral", new BigDecimal("40.00")));
        inserir(new Presentes("Conjunto para bolo (prato e espátula)", "Cozinha | Geral", new BigDecimal("35.00")));
        inserir(new Presentes("Jarra", "Cozinha | Geral", new BigDecimal("15.00")));
        inserir(new Presentes("Petisqueira", "Cozinha | Geral", new BigDecimal("20.00")));
        inserir(new Presentes("Porta-condimentos/temperos", "Cozinha | Geral", new BigDecimal("25.00")));
        inserir(new Presentes("Porta-guardanapo", "Cozinha | Geral", new BigDecimal("10.00")));
        inserir(new Presentes("Saladeira", "Cozinha | Geral", new BigDecimal("20.00")));
        inserir(new Presentes("Apoio para copos", "Cozinha | Geral", new BigDecimal("5.00")));
        inserir(new Presentes("Jogo de utensílios e espátulas", "Cozinha | Geral", new BigDecimal("35.00")));
        inserir(new Presentes("Jogo de lugar americano", "Cozinha | Geral", new BigDecimal("25.00")));
        */
        // Cozinha | Eletrodomésticos
        inserir(new Presentes("Fogão", "Cozinha | Eletrodomésticos", new BigDecimal("900.00")));
        inserir(new Presentes("Coifa", "Cozinha | Eletrodomésticos", new BigDecimal("500.00")));
        inserir(new Presentes("Geladeira", "Cozinha | Eletrodomésticos", new BigDecimal("1500.00")));
        inserir(new Presentes("Freezer", "Cozinha | Eletrodomésticos", new BigDecimal("1200.00")));
        inserir(new Presentes("Liquidificador", "Cozinha | Eletrodomésticos", new BigDecimal("150.00")));
        inserir(new Presentes("Torradeira/sanduicheira", "Cozinha | Eletrodomésticos", new BigDecimal("100.00")));
        inserir(new Presentes("Air fryer", "Cozinha | Eletrodomésticos", new BigDecimal("300.00")));
        /*
        inserir(new Presentes("Micro-ondas", "Cozinha | Eletrodomésticos", new BigDecimal("350.00")));
        inserir(new Presentes("Processador de alimentos", "Cozinha | Eletrodomésticos", new BigDecimal("250.00")));
        inserir(new Presentes("Batedeira", "Cozinha | Eletrodomésticos", new BigDecimal("200.00")));
        inserir(new Presentes("Espremedor de frutas", "Cozinha | Eletrodomésticos", new BigDecimal("80.00")));
        inserir(new Presentes("Aparelho de fondue e raclette", "Cozinha | Eletrodomésticos", new BigDecimal("150.00")));
        inserir(new Presentes("Cafeteira", "Cozinha | Eletrodomésticos", new BigDecimal("200.00")));
        inserir(new Presentes("Grill elétrico", "Cozinha | Eletrodomésticos", new BigDecimal("180.00")));
        inserir(new Presentes("Juicer", "Cozinha | Eletrodomésticos", new BigDecimal("250.00")));
        inserir(new Presentes("Máquina de pão", "Cozinha | Eletrodomésticos", new BigDecimal("300.00")));
        inserir(new Presentes("Panela elétrica", "Cozinha | Eletrodomésticos", new BigDecimal("150.00")));
        */
        // Decoração e cama, mesa e banho
        inserir(new Presentes("Jogo de lençóis", "Decoração e cama, mesa e banho", new BigDecimal("120.00")));
        inserir(new Presentes("Edredom", "Decoração e cama, mesa e banho", new BigDecimal("200.00")));
        inserir(new Presentes("Manta", "Decoração e cama, mesa e banho", new BigDecimal("80.00")));
        inserir(new Presentes("Cobertor", "Decoração e cama, mesa e banho", new BigDecimal("100.00")));
        inserir(new Presentes("Jogo de toalhas de banho", "Decoração e cama, mesa e banho", new BigDecimal("70.00")));
        inserir(new Presentes("Toalhas de mesa", "Decoração e cama, mesa e banho", new BigDecimal("60.00")));
        inserir(new Presentes("Castiçais e velas", "Decoração e cama, mesa e banho", new BigDecimal("50.00")));
        /*
        inserir(new Presentes("Objetos de decoração", "Decoração e cama, mesa e banho", new BigDecimal("150.00")));
        inserir(new Presentes("Tapetes", "Decoração e cama, mesa e banho", new BigDecimal("120.00")));
        inserir(new Presentes("Conjunto para pia/lavabo", "Decoração e cama, mesa e banho", new BigDecimal("30.00")));
        inserir(new Presentes("Aromatizador de ambiente", "Decoração e cama, mesa e banho", new BigDecimal("40.00")));
        inserir(new Presentes("Tábua de passar", "Decoração e cama, mesa e banho", new BigDecimal("60.00")));
        inserir(new Presentes("Capacho", "Decoração e cama, mesa e banho", new BigDecimal("20.00")));
        inserir(new Presentes("Relógio", "Decoração e cama, mesa e banho", new BigDecimal("80.00")));
        inserir(new Presentes("Vasos", "Decoração e cama, mesa e banho", new BigDecimal("50.00")));
        */
        // Móveis e eletrônicos
        inserir(new Presentes("Cama", "Móveis e Eletrônicos", new BigDecimal("800.00")));
        inserir(new Presentes("Colchão", "Móveis e Eletrônicos", new BigDecimal("600.00")));
        inserir(new Presentes("Sofá", "Móveis e Eletrônicos", new BigDecimal("1000.00")));
        inserir(new Presentes("TV", "Móveis e Eletrônicos", new BigDecimal("1200.00")));
        inserir(new Presentes("Mesa e cadeiras de jantar", "Móveis e Eletrônicos", new BigDecimal("700.00")));
        inserir(new Presentes("Rack", "Móveis e Eletrônicos", new BigDecimal("250.00")));
        /*
        inserir(new Presentes("Luminária", "Móveis e Eletrônicos", new BigDecimal("60.00")));
        inserir(new Presentes("Abajur", "Móveis e Eletrônicos", new BigDecimal("50.00")));
        inserir(new Presentes("Ferro de passar", "Móveis e Eletrônicos", new BigDecimal("80.00")));
        inserir(new Presentes("Lavadora de roupas/Lava e seca", "Móveis e Eletrônicos", new BigDecimal("1200.00")));
        inserir(new Presentes("Aspirador de pó", "Móveis e Eletrônicos", new BigDecimal("150.00")));
        inserir(new Presentes("Guarda-roupa", "Móveis e Eletrônicos", new BigDecimal("700.00")));
        inserir(new Presentes("Mesa de centro", "Móveis e Eletrônicos", new BigDecimal("150.00")));
        inserir(new Presentes("Poltronas", "Móveis e Eletrônicos", new BigDecimal("200.00")));
        */
        // Valor em dinheiro
        inserir(new Presentes("Valor em dinheiro", "Doação", null));
    }
}
