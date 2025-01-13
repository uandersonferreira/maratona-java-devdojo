package estudo.uanderson.javadevdojo.javacore.Gassociacao.teste;

import estudo.uanderson.javadevdojo.javacore.Gassociacao.dominio.Jogador;

public class JogadorTest01 {
    public static void main(String[] args) {
      Jogador jogador1 = new Jogador("Davi Luis");
      Jogador jogador2 = new Jogador("Cristiano Ronaldo");
      Jogador jogador3 = new Jogador("Messi");

      Jogador[] jogadores = {jogador1,jogador2,jogador3};//new Jogador[]{jogador1,jogador2,jogador3};//new Jogador[3]

        for (Jogador jogador : jogadores) {
            jogador.imprime();
        }//fori


    }//main
}
