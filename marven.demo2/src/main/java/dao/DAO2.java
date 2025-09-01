package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.X;

public class DAO2 extends DAO {

    public DAO2() {
        super();
        conectar();
    }

    public void finalize() {
        close();
    }

    // Inserir
    public boolean insert(X x) {
        boolean status = false;
        try {
            Statement st = conexao.createStatement();
            String sql = "INSERT INTO x (nome, valor) VALUES ('" + x.getNome() + "', " + x.getValor() + ")";
            System.out.println(sql);
            st.executeUpdate(sql);
            st.close();
            status = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;
    }

    // Listar todos
    public List<X> getAll() {
        List<X> lista = new ArrayList<>();
        try {
            Statement st = conexao.createStatement();
            String sql = "SELECT * FROM x";
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                X x = new X(rs.getInt("id"), rs.getString("nome"), rs.getDouble("valor"));
                lista.add(x);
            }
            st.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return lista;
    }

    // Atualizar
    public boolean update(X x) {
        boolean status = false;
        try {
            Statement st = conexao.createStatement();
            String sql = "UPDATE x SET nome='" + x.getNome() + "', valor=" + x.getValor() + " WHERE id=" + x.getId();
            System.out.println(sql);
            st.executeUpdate(sql);
            st.close();
            status = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;
    }

    // Excluir
    public boolean delete(int id) {
        boolean status = false;
        try {
            Statement st = conexao.createStatement();
            String sql = "DELETE FROM x WHERE id=" + id;
            System.out.println(sql);
            st.executeUpdate(sql);
            st.close();
            status = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;
    }

    // Buscar por id
    public X get(int id) {
        X x = null;
        try {
            Statement st = conexao.createStatement();
            String sql = "SELECT * FROM x WHERE id=" + id;
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                x = new X(rs.getInt("id"), rs.getString("nome"), rs.getDouble("valor"));
            }
            st.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return x;
    }
}

