package main;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class peopleDAO extends DAO {
    public peopleDAO() {
        super();
        conectar();
    }
    
    @Override
    public void finalize() {
        close();
    }

    /**
     * O insert insere no banco de dados.
     * O que tem que passar de parâmetro é o tipo da classe que eu criei para o banco de dados.
     * Statement é o que a gente usa para lidar com instruções SQL.
     * Os gets obviamente são feitos de acordo com os campos que existem no banco de dados.
     * NÃO que ele esteja tirando de lá; ele não está.
     * Ele está puxando do meu objeto `People`.
     * No final, ele só manda a exceção se der erro e retorna se deu certo ou não a inserção.
     */
    public boolean insert(People people) {
        boolean status = false;
        try {
            Statement st = conexao.createStatement();
            String sql = "INSERT INTO people (codigo, trabalho, idade, nome) "
                       + "VALUES (" + people.getCodigo() + ", '" + people.getTrabalho() + "', '"  
                       + people.getIdade() + "', '" + people.getNome() + "');";
            System.out.println(sql);
            st.executeUpdate(sql);
            st.close();
            status = true;
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return status;
    }
    
    /**
     * Isso aqui é para puxar do banco SQL um elemento.
     * Primeiro ele prepara um objeto vazio.
     * Seleciona todos os objetos de "people" que tenham código correspondente ao que passei por parâmetro.
     * Depois ele puxa os dados desse "people" e coloca no objeto vazio.
     * Enquanto tiver um próximo ele segue puxando.
     * Se der errado, imprime erro.
     */
    public People get(int codigo) {
        People person = null;
        
        try {
            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM people WHERE codigo=" + codigo;
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);    
            if (rs.next()) {
                person = new People(rs.getInt("codigo"), rs.getString("trabalho"), rs.getInt("idade"), rs.getString("nome"));
            }
            st.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return person;
    }
    
    // Puxa todos de people e coloca numa lista
    public List<People> get() {
        return get("");
    }
    
    // Puxa tudo da coluna codigo de people e coloca numa lista
    public List<People> getOrderByCodigo() {
        return get("codigo");        
    }
    
    // Puxa tudo da coluna trabalho de people e coloca numa lista
    public List<People> getOrderByTrabalho() {
        return get("trabalho");        
    }
    
    // Puxa tudo da coluna idade de people e coloca numa lista
    public List<People> getOrderByIdade() {
        return get("idade");        
    }
    
    // Puxa tudo da coluna nome de people e coloca numa lista
    public List<People> getOrderByNome() {
        return get("nome");        
    }
    
    /**
     * Este é o método que puxa os dados; os outros métodos são de encapsulamento.
     * (Deus perdoe o uso de people; é para ficar fácil de lembrar.)
     * Cria a lista de objetos people.
     * Faz a chamada SQL de acordo com a string fornecida.
     * Enquanto houver mais registros, continua puxando os dados e adicionando cada objeto à lista.
     **/
    private List<People> get(String orderBy) {
        List<People> peopleList = new ArrayList<>();
        
        try {
            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM people" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                People person = new People(rs.getInt("codigo"), rs.getString("trabalho"), rs.getInt("idade"), rs.getString("nome"));
                peopleList.add(person);
            }
            st.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return peopleList;
    } 
    
    /** Atualizar um valor no banco de dados pelo nome
     * Aqui estou puxando os valores do objeto `people` passado e inserindo no banco de dados.
     * No lugar do trem no banco de dados, é o número código.
     */
    public boolean update(People people) {
        boolean status = false;
        try {
            Statement st = conexao.createStatement();
            String sql = "UPDATE people SET nome = '" + people.getNome() + "', trabalho = '"  
                       + people.getTrabalho() + "', idade = '" + people.getIdade() + "'"
                       + " WHERE codigo = " + people.getCodigo();
            System.out.println(sql);
            st.executeUpdate(sql);
            st.close();
            status = true;
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return status;
    }
    
    /** Exclui o valor do código passado do banco de dados
     */
    public boolean delete(int codigo) {
        boolean status = false;
        try {
            Statement st = conexao.createStatement();
            String sql = "DELETE FROM people WHERE codigo = " + codigo;
            System.out.println(sql);
            st.executeUpdate(sql);
            st.close();
            status = true;
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return status;
    }
}
