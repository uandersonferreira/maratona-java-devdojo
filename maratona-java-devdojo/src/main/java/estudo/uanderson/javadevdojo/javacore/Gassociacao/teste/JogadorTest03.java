package estudo.uanderson.javadevdojo.javacore.Gassociacao.teste;

import estudo.uanderson.javadevdojo.javacore.Gassociacao.dominio.Jogador;
import estudo.uanderson.javadevdojo.javacore.Gassociacao.dominio.Time;

public class JogadorTest03 {
    public static void main(String[] args) {
        Jogador jogador1 = new Jogador("Uanderson");
        Jogador jogador2 = new Jogador("Pelé");

        Time time1 = new Time("Seleção Brasileira");

        Jogador[] jogadores = {jogador1,jogador2};
/*
Obs: sempre que se adiciona uma novo objeto de Jogador a um time, necessariamente e preciso associar-ló
ao time através do setTime();. Para que seja reconhecimento como parte do time.
 */
        jogador1.setTime(time1);
        jogador2.setTime(time1);

        time1.setJogadores(jogadores);

        System.out.println("----JOGADORES-----");
        jogador1.imprime();
        jogador2.imprime();

        System.out.println("----TIME------");
        time1.imprime();

    }//main
}//class
