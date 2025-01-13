package estudo.uanderson.javadevdojo.javacore.Gassociacao.teste;

import estudo.uanderson.javadevdojo.javacore.Gassociacao.dominio.Jogador;
import estudo.uanderson.javadevdojo.javacore.Gassociacao.dominio.Time;

public class JogadorTest02 {
    public static void main(String[] args) {
        Jogador jogador01 = new Jogador("Pelé");

        Time time = new Time("Seleção Brasileira");

        jogador01.setTime(time);//está associando o time ao jogador.
        jogador01.imprime();//está imprimindo o que foi associado
    }
}
