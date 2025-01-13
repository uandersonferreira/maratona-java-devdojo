package dio.br.com.uanderson.set.ordernacao;

import java.util.Objects;

public class Produto implements Comparable<Produto> {

    private String nome;
    private long codigo;
    private double preco;
    private int quantidade;

    public Produto(long codigo, String nome, double preco, int quantidade) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public long getCodigo() {
        return codigo;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }


    @Override
    public String toString() {
        return "{ " + nome + ", " + codigo + ", " + preco + ", " + quantidade + " }";
    }

    // Permite diferenciar os objetos do tipo Produto (determina se são iguais ou não)
    // O que os torna iguais ou diferentes ? (atributos)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto produto)) return false;
        return getCodigo() == produto.getCodigo();

    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigo());
    }

    @Override
    public int compareTo(Produto p) {
        return nome.compareToIgnoreCase(p.getNome());
    }

}//class
