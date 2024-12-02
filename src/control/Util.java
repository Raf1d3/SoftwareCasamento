/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

/**
 *
 * @author pse
 */
public class Util {

    private static LocalDate dataAtual = LocalDate.of(2024, 10, 1);

    public static LocalDate getDataAtual() {
        return dataAtual;
    }

    public static void setData(LocalDate novaData) {
        dataAtual = novaData;
    }

    public static void avancarDias(int dias) {
        dataAtual = dataAtual.plusDays(dias);
    }

    public static void retrocederDias(int dias) {
        dataAtual = dataAtual.minusDays(dias);
    }

    public static String ListToString(List lista) {
        String toStringLista = "";
        if (!lista.isEmpty()) {
            for (int i = 0; i < lista.size(); i++) {
                toStringLista += lista.get(i).toString() + "\n";
            }
        }
        return toStringLista;
    }

    // Formata LocalDateTime para String
    public static String formatarData(LocalDateTime data) {
        if (data == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return data.format(formatter);
    }

    // Converte de String para LocalDateTime
    public static LocalDateTime parseData(String dataString) {
        if (dataString == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return LocalDateTime.parse(dataString, formatter);
    }

    // Formata LocalDate para String 
    public static String formatarDataLocal(LocalDate data) {
        if (data == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter);
    }

    // Converte de String para LocalDate
    public static LocalDate parseDataLocal(String dataString) {
        if (dataString == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dataString, formatter);
    }

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

    public static int calcularIdade(LocalDate dataNascimento) {
        return Period.between(dataNascimento, getDataAtual()).getYears();
    }

}
