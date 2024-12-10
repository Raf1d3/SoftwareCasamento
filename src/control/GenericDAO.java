/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.InterfaceGenericDAO;

/**
 *
 * @author pse
 */
public class GenericDAO<T> {

    private final Class<T> classe;

    public GenericDAO(Class<T> classe) {
        this.classe = classe;
    }

    private List<String> geraAtributosLista() {
        Field[] atributos = classe.getDeclaredFields();
        List<String> listaAtributos = new ArrayList();

        for (Field atributo : atributos) {

            listaAtributos.add(atributo.getName());
        }
        return listaAtributos;
    }

    private List<String> geraMetodosGeteSetsLista(int option) {
        List<String> atributos = geraAtributosLista();
        List<String> listaMetodosGets = new ArrayList();
        List<String> listaMetodosSets = new ArrayList();

        for (int i = 0; i < atributos.size(); i++) {
            //if(atributos.get(i) != "dataCriacao"){
            listaMetodosSets.add("set" + Character.toUpperCase(atributos.get(i).charAt(0)) + atributos.get(i).substring(1));
            //}
            listaMetodosGets.add("get" + Character.toUpperCase(atributos.get(i).charAt(0)) + atributos.get(i).substring(1));
        }

        if (option == 1) {
            return listaMetodosSets;
        }
        return listaMetodosGets;
    }

    private T instanciarObj(Object... parametros) {
        try {
            Constructor<?>[] constructors = classe.getConstructors();

            for (Constructor<?> constructor : constructors) {
                Class<?>[] parameterTypes = constructor.getParameterTypes();

                if (parameterTypes.length == parametros.length) {
                    boolean compativel = true;

                    for (int i = 0; i < parametros.length; i++) {
                        Object parametro = parametros[i];

                        if (parametro != null && !parameterTypes[i].isAssignableFrom(parametro.getClass())) {
                            compativel = false;
                            break;
                        }
                    }

                    if (compativel) {
                        return (T) constructor.newInstance(parametros);

                    }
                }
            }

            throw new RuntimeException("Nenhum construtor compatível encontrado.");
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Erro ao instanciar objeto com parâmetros", e);
        }
    }

    private String GeradorAtributosECampos(int option) {
        List<String> listaAtributos = geraAtributosLista();
        StringBuilder colunasInsert = new StringBuilder("");
        StringBuilder camposInsert = new StringBuilder("");
        StringBuilder camposColunasUpdate = new StringBuilder("");
        for (int i = 1; i < listaAtributos.size(); i++) {
            if (!listaAtributos.get(i).equals("id")) {
                colunasInsert.append(listaAtributos.get(i));
                camposInsert.append("?");

                if (!listaAtributos.get(i).equals("dataCriacao")) {
                    camposColunasUpdate.append(listaAtributos.get(i)).append(" = ?");
                }

                if (i != listaAtributos.size() - 1) {
                    colunasInsert.append(",");
                    camposInsert.append(",");

                    if (!listaAtributos.get(i).equals("dataCriacao")) {
                        camposColunasUpdate.append(",");
                    }
                }
            }
        }
        switch (option) {
            case 1:
                return colunasInsert.toString();
            case 2:
                return camposInsert.toString();
            default:
                return camposColunasUpdate.toString();
        }
    }

    public long adiciona(InterfaceGenericDAO elemento) {
        String nomeTabela = classe.getSimpleName();
        String colunas = GeradorAtributosECampos(1);
        String campos = GeradorAtributosECampos(2);
        String sql = "insert into " + nomeTabela + " (" + colunas + ") values (" + campos + ")";
        long retornoID = -1;

        try (Connection conexao = new ConexaoBanco().getConexao(); PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            int indiceDoParametro = 1;
            for (Object valores : elemento.getValoresAtributos()) {

                if (valores == null) {
                    stmt.setNull(indiceDoParametro, java.sql.Types.NULL);

                } else if (valores instanceof String) {
                    stmt.setString(indiceDoParametro, (String) valores);

                } else if (valores instanceof Integer) {
                    stmt.setInt(indiceDoParametro, (Integer) valores);

                } else if (valores instanceof Long) {
                    stmt.setLong(indiceDoParametro, (Long) valores);

                } else if (valores instanceof java.util.Date) {
                    stmt.setDate(indiceDoParametro, new java.sql.Date(((java.util.Date) valores).getTime()));

                } else if (valores instanceof java.time.LocalDate) {
                    stmt.setDate(indiceDoParametro, java.sql.Date.valueOf((java.time.LocalDate) valores));

                } else if (valores instanceof java.time.LocalDateTime) {
                    stmt.setTimestamp(indiceDoParametro, java.sql.Timestamp.valueOf((java.time.LocalDateTime) valores));

                } else if (valores instanceof java.lang.Double) {
                    stmt.setDouble(indiceDoParametro, (Double) valores);

                } else if (valores instanceof java.lang.Boolean) {
                    stmt.setBoolean(indiceDoParametro, (java.lang.Boolean) valores);

                } else if (valores instanceof java.math.BigDecimal) {
                    stmt.setBigDecimal(indiceDoParametro, (java.math.BigDecimal) valores);

                } else {
                    throw new IllegalArgumentException("Tipo não suportado: " + valores.getClass().getName());
                }
                indiceDoParametro++;
            }

            stmt.execute();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                retornoID = rs.getInt(1);
            }

            System.out.println("Elemento inserido com sucesso.");
            return retornoID;

        } catch (SQLException e) {
            System.err.println("Erro de SQL: " + e.getMessage());
            return retornoID;
        }

    }

    public List<T> listar() {
        String nomeTabela = classe.getSimpleName();

        String sql = "select * from " + nomeTabela;

        List<T> lista = new ArrayList();

        try (Connection conexao = new ConexaoBanco().getConexao(); PreparedStatement stmt = conexao.prepareStatement(sql); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                List<String> ListaAtributos = geraAtributosLista();
                List<Object> parametros = new ArrayList<>();

                for (int i = 0; i < ListaAtributos.size(); i++) {

                    String nomeColuna = ListaAtributos.get(i);
                    Class<?> TipoAtributo = classe.getDeclaredFields()[i].getType();
                    Object valor = null;

                    if (TipoAtributo.equals(String.class)) {
                        valor = rs.getString(nomeColuna);

                    } else if (TipoAtributo.equals(Long.class) || TipoAtributo.equals(long.class)) {
                        valor = rs.getLong(nomeColuna);

                    } else if (TipoAtributo.equals(Integer.class) || TipoAtributo.equals(int.class)) {
                        valor = rs.getInt(nomeColuna);

                    } else if (TipoAtributo.equals(java.time.LocalDate.class)) {
                        valor = rs.getDate(nomeColuna).toLocalDate();

                    } else if (TipoAtributo.equals(java.time.LocalDateTime.class)) {
                        valor = rs.getTimestamp(nomeColuna).toLocalDateTime();

                    } else if (TipoAtributo.equals(Double.class) || TipoAtributo.equals(double.class)) {
                        valor = rs.getDouble(nomeColuna);

                    } else if (TipoAtributo.equals(java.math.BigDecimal.class)) {
                        valor = rs.getBigDecimal(nomeColuna);

                    } else if (TipoAtributo.equals(Boolean.class) || TipoAtributo.equals(boolean.class)) {
                        valor = rs.getBoolean(nomeColuna);

                    } else if (TipoAtributo.getPackageName().equals(classe.getPackageName())) {
                        Long idRelacionado = rs.getLong(nomeColuna);
                        if (idRelacionado != 0) {
                            try {

                                GenericDAO<?> daoRelacionado = new GenericDAO<>(TipoAtributo);

                                valor = daoRelacionado.buscar(idRelacionado);
                            } catch (Exception e) {
                                throw new RuntimeException("Erro ao buscar objeto relacionado: " + TipoAtributo.getName(), e);
                            }
                        }

                    } else {
                        throw new IllegalArgumentException("Tipo não suportado: " + TipoAtributo.getClass().getName());
                    }

                    parametros.add(valor);
                }

                T obj = instanciarObj(parametros.toArray());

                lista.add(obj);
            }

        } catch (SQLException e) {
            System.err.println("Erro de SQL: " + e.getMessage());
            return null;
        }

        return lista;
    }

    public T buscar(long id) {
        String nomeTabela = classe.getSimpleName();
        String sql = "select * from " + nomeTabela + " where id = ?";
        T obj = null;

        try (Connection conexao = new ConexaoBanco().getConexao(); PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    List<String> ListaAtributos = geraAtributosLista();
                    List<Object> parametros = new ArrayList<>();

                    for (int i = 0; i < ListaAtributos.size(); i++) {

                        String nomeColuna = ListaAtributos.get(i);
                        Class<?> TipoAtributo = classe.getDeclaredFields()[i].getType();
                        Object valor = null;

                        if (TipoAtributo.equals(String.class)) {
                            valor = rs.getString(nomeColuna);

                        } else if (TipoAtributo.equals(Long.class) || TipoAtributo.equals(long.class)) {
                            valor = rs.getLong(nomeColuna);

                        } else if (TipoAtributo.equals(Integer.class) || TipoAtributo.equals(int.class)) {
                            valor = rs.getInt(nomeColuna);

                        } else if (TipoAtributo.equals(java.time.LocalDate.class)) {
                            valor = rs.getDate(nomeColuna).toLocalDate();

                        } else if (TipoAtributo.equals(java.time.LocalDateTime.class)) {
                            valor = rs.getTimestamp(nomeColuna).toLocalDateTime();

                        } else if (TipoAtributo.equals(Double.class) || TipoAtributo.equals(double.class)) {
                            valor = rs.getDouble(nomeColuna);

                        } else if (TipoAtributo.equals(java.math.BigDecimal.class)) {
                            valor = rs.getBigDecimal(nomeColuna);

                        } else if (TipoAtributo.equals(Boolean.class) || TipoAtributo.equals(boolean.class)) {
                            valor = rs.getBoolean(nomeColuna);

                        } else if (TipoAtributo.getPackageName().equals(classe.getPackageName())) {
                            Long idRelacionado = rs.getLong(nomeColuna);

                            if (idRelacionado != 0) {
                                try {

                                    GenericDAO<?> daoRelacionado = new GenericDAO<>(TipoAtributo);

                                    valor = daoRelacionado.buscar(idRelacionado);
                                } catch (Exception e) {
                                    throw new RuntimeException("Erro ao buscar objeto relacionado: " + TipoAtributo.getName(), e);
                                }
                            } else {
                                // valor = null;
                            }

                        } else {
                            throw new IllegalArgumentException("Tipo não suportado: " + TipoAtributo.getClass().getName());
                        }

                        parametros.add(valor);
                    }
                    obj = instanciarObj(parametros.toArray());
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } catch (SQLException e) {
            System.err.println("Erro de SQL: " + e.getMessage());
        }
        return obj;
    }

    public T deletar(long id) {
        String nomeTabela = classe.getSimpleName();

        String sql = "delete from " + nomeTabela + " where id = ?";
        T obj = buscar(id);
        if (obj == null) {
            System.out.println("Elemento não encontrado");
            return null;
        }

        try (Connection conexao = new ConexaoBanco().getConexao(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setLong(1, id);

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Elemento excluído com sucesso.");
            } else {
                System.out.println("Falha ao excluir o elemento");
                obj = null;
            }
        } catch (SQLException e) {
            System.err.println("Erro de SQL: " + e.getMessage());
            obj = null;
        }

        return obj;
    }

    public boolean alterar(long id, InterfaceGenericDAO novoElemento) {
        String nomeTabela = classe.getSimpleName().toLowerCase();

        String CamposEcolunas = GeradorAtributosECampos(3);

        String sql = "update " + nomeTabela + " set " + CamposEcolunas + " where id = ?";

        List<String> ListaAtributos = geraAtributosLista();

        int indiceDoParametro = 1;
        try (Connection conexao = new ConexaoBanco().getConexao(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            for (Object valores : novoElemento.getValoresAtributos()) {

                if (ListaAtributos.get(indiceDoParametro - 1).equals("dataCriacao")) {
                    continue;
                }

                if (valores == null) {
                    stmt.setNull(indiceDoParametro, java.sql.Types.NULL);
                } else if (valores instanceof String) {
                    stmt.setString(indiceDoParametro, (String) valores);

                } else if (valores instanceof Integer) {
                    stmt.setInt(indiceDoParametro, (Integer) valores);

                } else if (valores instanceof Long) {
                    stmt.setLong(indiceDoParametro, (Long) valores);

                } else if (valores instanceof java.util.Date) {
                    stmt.setDate(indiceDoParametro, new java.sql.Date(((java.util.Date) valores).getTime()));

                } else if (valores instanceof java.time.LocalDate) {
                    stmt.setDate(indiceDoParametro, java.sql.Date.valueOf((java.time.LocalDate) valores));

                } else if (valores instanceof java.time.LocalDateTime) {
                    stmt.setTimestamp(indiceDoParametro, java.sql.Timestamp.valueOf((java.time.LocalDateTime) valores));

                } else if (valores instanceof java.lang.Double) {
                    stmt.setDouble(indiceDoParametro, (Double) valores);

                } else if (valores instanceof java.lang.Boolean) {
                    stmt.setBoolean(indiceDoParametro, (java.lang.Boolean) valores);

                } else if (valores instanceof java.math.BigDecimal) {
                    stmt.setBigDecimal(indiceDoParametro, (java.math.BigDecimal) valores);
                } else {
                    throw new IllegalArgumentException("Tipo não suportado: " + valores.getClass().getName());
                }
                indiceDoParametro++;
            }
            stmt.setLong(indiceDoParametro, id);
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Elemento atualizado com sucesso.");

            } else {
                System.out.println("Elemento não encontrado.");
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Erro de SQL: " + e.getMessage());
            return false;
        }
        return true;
    }

}
