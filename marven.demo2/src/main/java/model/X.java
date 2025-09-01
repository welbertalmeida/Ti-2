package model;

public class X {
    private int id;
    private String nome;
    private double valor;

    public X() {
        this.id = -1;
        this.nome = "";
        this.valor = 0.0;
    }

    public X(int id, String nome, double valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "X [id=" + id + ", nome=" + nome + ", valor=" + valor + "]";
    }
}

