package dio.br.com.uanderson.set.operacoesBasicas;

import java.util.Objects;

public class Convidado {

    private String nome;
    private int codigoConvite;

    public Convidado(String nome, int codigoConvite) {
        this.nome = nome;
        this.codigoConvite = codigoConvite;
    }

    public String getNome() {
        return this.nome;
    }

    public int getCodigoConvite() {
        return this.codigoConvite;
    }

    @Override
    public String toString() {
        return "Convidado {" +
                "nome= " + nome + '\'' +
                ", codigoConvite= " + codigoConvite +
                '}';
    }

    // Permite diferenciar os objetos do tipo Convidado (determina se são iguais ou não)
    // O que os torna iguais ou diferentes ? (atributos)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Convidado convidado)) return false;
        return getCodigoConvite() == convidado.getCodigoConvite();

    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigoConvite());
    }

}//class
