package estudo.uanderson.javadevdojo.javacore.Rdatas.test;

import java.time.Instant;
import java.time.LocalDateTime;

public class InstantTest01 {
    public static void main(String[] args) {
        Instant instant = Instant.now(); //imutavel (não se pode mudar, alterar), toda alteração gera um novo objeto
        System.out.println("Instant: "+instant);
        System.out.println("LocalDateTime: "+ LocalDateTime.now());

        System.out.println(instant.getEpochSecond());//representa os segundos
        System.out.println(instant.getNano());//999.999.999 representa os nanosegundos de 1 segundo
        System.out.println(Instant.ofEpochSecond(5,0));
        System.out.println(Instant.ofEpochSecond(5,1_000_000_000));
        System.out.println(Instant.ofEpochSecond(5,-1_000_000_000));
    }

    /*
Aula 124

2022-06-29T13:56:16.636347Z

O Z representa o zulu time/UTC um horário neutro visto por todos do mesmo jeito idependente de ser
estar no Brasil ou no Japão, pois é de acordo com a linha de Greenwich. Horário correto para ser salvar no banco de dados.
 Ex:
  quarta-feira 14:01, em Greenwich Mean Time. já no Horário de palmas-TO, Brasil são:
  quarta-feira 11:01, Palmas, TO (BRT), -3 horas de diferença.

A Instant trabalha com nano segundos

 */
}
