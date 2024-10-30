/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import model.Pagamentos;
import model.Usuario;

/**
 *
 * @author pse
 */
public class GenericDAO<T> {

    private List<T> database = new ArrayList<>();
    private List<Long> elementosDeletados = new ArrayList<>();

    public int inserir(T obj) {

        try {

            Method setId = obj.getClass().getMethod("setId", long.class);
            if (!elementosDeletados.isEmpty()) {
                elementosDeletados.sort((o1, o2) -> Long.compare(o1, o2));
                //System.out.println(elementosDeletados.toString());
                if (database.size() >= elementosDeletados.get(0)) {
                    long e = elementosDeletados.get(0);
                    setId.invoke(obj, e);
                    database.add(Math.toIntExact(e), obj);
                    elementosDeletados.remove(0);
                    return Math.toIntExact(e);
                }
            }

            setId.invoke(obj, Math.toIntExact(database.size()));
            database.add(obj);
            //System.out.println("elementos Inserir: " + database.toString());
            return database.size();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
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

    public boolean alterar(T objNovo, long id) {
        T objAntigo = buscar(id);
        int indice = database.indexOf(objAntigo);

        //caso o indexOf ache o elemento
        if (indice != -1) {
            try {
                Field[] campos = objNovo.getClass().getDeclaredFields();

                for (Field campo : campos) {
                    campo.setAccessible(true);

                    if (!campo.getName().equals("id") && !campo.getName().equals("dataCriacao")) {
                        Object novoValor = campo.get(objNovo);
                        campo.set(objAntigo, novoValor);
                    }
                        if (campo.getName().equals("dataModificacao")) {
                        campo.set(objAntigo, LocalDateTime.now());
                    }
                }
                return true;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean deletar(long id) {
        boolean removido = database.remove(buscar(id));
        if (removido != false) {
            elementosDeletados.add(id);
        }
        return removido;
    }

    public T buscar(long id) {
        try {

            for (T obj : database) {
                Method getId = obj.getClass().getMethod("getId");
                
                long objId = (long) getId.invoke(obj);
                
                if(objId == id){
                    return obj;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }

    public List<T> GetDataBase() {
        return database;
    }

    boolean pagamentoExistente(long idFornecedor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    boolean existePagamentoParaFornecedor(long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
