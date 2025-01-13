package estudo.uanderson.javadevdojo.javacore.ZZKjunit.domain;

import java.util.Objects;

public record Manga(String name, int episodes) {
    //Não aceita a criação de atributos primitivos de objeto, somente statics
    //Somente aceita blocos de inicialização staticos
    //Possui somente a função de pegar/get();
    private static String producer;

    static {

    }

    public Manga {
        Objects.requireNonNull(name);
    }
}
/*
public final class estudo.uanderson.javadevdojo.javacore.ZZKjunit.domain.Manga extends java.lang.Record {
  public estudo.uanderson.javadevdojo.javacore.ZZKjunit.domain.Manga(java.lang.String, int);
  public final java.lang.String toString();
  public final int hashCode();
  public final boolean equals(java.lang.Object);
  public java.lang.String name();
  public int episodes();
}

1° -


 */
