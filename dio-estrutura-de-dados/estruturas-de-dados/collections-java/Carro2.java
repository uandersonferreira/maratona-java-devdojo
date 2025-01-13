package dio.estruturas-de-dados.equals-hash-code;

import java.util..*;

public class Carro2 implements Comparable<Carro2> {

   private  String marca;

public Carro2(String marca) {
    this.marca = marca;
}

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }


    @Override
    public int compareTo(Carro2 o) {
        if (this.marca.length() < o.marca.length()) {
            return -1;
        }else if (this.marca.length() > o.marca.length()) {
            return 1;
        }
        return 0;
        /* Set<Carro2> treeSetCarros = new TreeSet<>();
         * Para utilizar qualquer implementação de uma Árvore (Tree) é preciso ter o 
         * metódo de comparação(precisa garantir a comparação de objetos) para poder
         * saber qual é maior ou menos, devido a REGRA GERAL do balanceamento:
         * Menor - Para esquerda
         * Maiores - Para a direita
         * 
         */
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((marca == null) ? 0 : marca.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Carro2 other = (Carro2) obj;
        if (marca == null) {
            if (other.marca != null)
                return false;
        } else if (!marca.equals(other.marca))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Carro [marca=" + marca + "]";
    }

}
