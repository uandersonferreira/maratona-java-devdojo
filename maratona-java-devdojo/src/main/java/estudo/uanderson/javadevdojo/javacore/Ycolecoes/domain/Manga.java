package estudo.uanderson.javadevdojo.javacore.Ycolecoes.domain;

import java.util.Objects;

public class Manga implements Comparable<Manga> {
    private Long id;
    private String nomeManga;
    private double preco;
    private int quantidade;

    public Manga(Long id, String nomeManga, double preco) {
        Objects.requireNonNull(id, "ID não pode ser Nulo!");//garante que o id é o nomeManga não seja null.
        Objects.requireNonNull(nomeManga, "O nome do mangá não pode ser Nulo!");
        this.id = id;
        this.nomeManga = nomeManga;
        this.preco = preco;
    }

    public Manga(Long id, String nomeManga, double preco, int quantidade) {
        this(id,nomeManga,preco);
        this.quantidade = quantidade;
    }//construtor sobrecarregado

    @Override
    public String toString() {
        return "Manga{" +
                "id=" + id +
                ", nomeManga='" + nomeManga + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manga manga = (Manga) o;
        return Objects.equals(id, manga.id) && Objects.equals(nomeManga, manga.nomeManga);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeManga);
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeManga() {
        return nomeManga;
    }

    public void setNomeManga(String nomeManga) {
        this.nomeManga = nomeManga;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public int compareTo(Manga outroManga) {
        //negativo se o this < outroManga
        // return 0, se this == outroManga
        //positivo se this > outroManga
//        if (this.id < outroManga.id){
//            return -1;
//        }else if (this.id.equals(outroManga.getId())){
//            return 0;
//        }else {
//            return 1;
//        }
        return this.nomeManga.compareTo(outroManga.getNomeManga());//caso queira ordenar pelo nomeh
        //return Double.compare(preco, outroManga.getPreco());//caso queira que ordenem por um atributo do tipo primitivo
        //return Double.valueOf(preco).compareTo(outroManga.getPreco()); faz a mesma coisa qu eo de cima.
        //return this.id.compareTo(outroManga.getId());//so é possível por ser um wrapper

    }//method
}//class
