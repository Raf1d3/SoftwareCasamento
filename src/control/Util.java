/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.Random;

/**
 *
 * @author pse
 */
public class Util {

    public static String gerarStringAleatoria(int tamanho) {
        String caracteres = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder stringAleatoria = new StringBuilder(tamanho);
        Random random = new Random();

        for (int i = 0; i < tamanho; i++) {
            int index = random.nextInt(caracteres.length());
            stringAleatoria.append(caracteres.charAt(index));
        }

        return stringAleatoria.toString();
    }

}
