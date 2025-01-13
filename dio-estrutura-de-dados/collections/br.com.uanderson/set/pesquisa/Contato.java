package dio.br.com.uanderson.set.pesquisa;

import java.util.Objects;

public class Contato {

    private String nome;
    private int numero;

    public Contato(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "{ " + nome + ", " + numero + " }";
    }

    // Permite diferenciar os objetos do tipo Contato (determina se são iguais ou não)
    // O que os torna iguais ou diferentes ? (atributos)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contato contato)) return false;
        return getNome() == contato.getNome();

    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome());
    }

}//class
