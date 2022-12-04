package estudo.uanderson.javadevdojo.javacore.Npolimorfismo.dominio;

public abstract class Produto implements Taxavel {//class template
    protected String nome;
    protected double valor;

    public Produto(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }
}//class
