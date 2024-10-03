/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;
import model.Usuario;

/**
 *
 * @author pse
 */

public class GenericDAO<T> {

    private List<T> database = new ArrayList<>();
    

    public int inserir(T obj) {
        database.add(obj);
        return database.size() - 1;
    }

    public String mostrar(T objEspecifico) {
        StringBuilder mensagem = new StringBuilder();
        if (objEspecifico != null) {
            mensagem.append(objEspecifico.toString());
            return mensagem.toString();
        }
        for (int i = 0; i < database.size(); i++) {
            if (database.get(i) != null) {
                mensagem.append(database.get(i).toString()).append("\n");
            }
        }
        return mensagem.toString();
    }

    public boolean alterar(T objNovo, T objAntigo) {
        int indice = database.indexOf(objAntigo);

        //caso o idexOf ache o elemento
        if (indice != -1) {
            try {
                Field[] campos = objNovo.getClass().getDeclaredFields();

                for (Field campo : campos) {
                    campo.setAccessible(true);

                    if (!campo.getName().equals("id") && !campo.getName().equals("dataCriacao")) {
                        Object novoValor = campo.get(objNovo);
                        campo.set(objAntigo, novoValor);

                    }

                }
                return true;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public boolean deletar(T obj, long id) {
        boolean removido = database.remove(obj);
        return removido;
    }

    public T buscar(long id) {
        if (id >= 0 && id < database.size()) {
            return database.get(Math.toIntExact(id));
        }
        return null;
    }

    public List<T> GetDataBase() {
        return database;
    }

}
