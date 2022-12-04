package estudo.uanderson.javadevdojo.javacore.Rdatas.test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DurationTest01 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nowAfterTwoYears = LocalDateTime.now().plusYears(2).plusMinutes(5);
        LocalTime timeNow = LocalTime.now();
        LocalTime timeMinus7Hours = LocalTime.now().minusHours(7);

        Duration d1 = Duration.between(now, nowAfterTwoYears);
        Duration d2 = Duration.between(timeNow, timeMinus7Hours);
        Duration d3 = Duration.between(Instant.now(), Instant.now().plusSeconds(1000));
        Duration d5 = Duration.ofDays(20);
        Duration d6 = Duration.ofMinutes(20);
        Duration d7 = Duration.of(20, ChronoUnit.DAYS);//têm que tomar cuidado pois não possuo suporte para algumas coisas o chronoUnit

        System.out.println("LocalDateTime: "+d1);
        System.out.println("LocalTime: "+d2);
        System.out.println("Instant: "+d3);
        System.out.println("ofDays: "+d5);
        System.out.println("ofMinutes: "+d6);
        System.out.println("of + ChronoUnit.DAYS: "+d7);

        //Duration d4 = Duration.between(LocalDate.now(), LocalDate.now().plusYears(2));
        //System.out.println("LocalDate: "+d4);

        /*
        Por mais que não gere erro de sintaxe, irá gerar uma exception durante a
        execução do programa, pois a classe LocalDate, não possui suporte para trabalhar com segundos.

        Exception lançada: UnsupportedTemporalTypeException: Unsupported unit: Seconds
         */

        System.out.println((d1.toDays()/365)+" Anos");
    }//main
}//class
/*
 As letras maiúsculas P , Y , M , W , D , T , H , M e S são designadores para cada um dos elementos de data e hora e não são substituídas.

    P é o designador de duração (para período ) colocado no início da representação de duração.
        Y é o designador do ano que segue o valor do número de anos.
        M é o designador do mês que segue o valor do número de meses.
        W é o designador da semana que segue o valor do número de semanas.
        D é o designador do dia que segue o valor do número de dias.

    T é o designador de tempo que precede os componentes de tempo da representação.
        H é o designador da hora que segue o valor do número de horas.
        M é o designador de minuto que segue o valor para o número de minutos.
        S é o segundo designador que segue o valor para o número de segundos.

Por exemplo, "P3Y6M4DT12H30M5S" representa uma duração de "três anos, seis meses, quatro dias, doze horas, trinta minutos e cinco segundos".

A class Duration não aceita LocalDate, porque a classe, não trabalha com segundos. E é gerado um erro em
tempo de execução do programa.
 */
