package estudo.uanderson.javadevdojo.javacore.Rdatas.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class LocalDateTimeTest01 {
    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate date = LocalDate.of(2022, Month.AUGUST,13);
        LocalTime time = LocalTime.of(10,30,20);
        //A data e a hora pode ser passadas como strings por meio do Parse.
        LocalDate date2 = LocalDate.parse("2022-08-13");
        LocalTime time2 = LocalTime.parse("10:30:20");

        System.out.println(localDateTime);
        System.out.println(date);
        System.out.println(time);
        System.out.println("Data e hora como strings através do parse");
        System.out.println(date2);
        System.out.println(time2);

        //acessando uma data apartir de um determinado tempo.
        LocalDateTime ldt1 = date.atTime(time);//
        LocalDateTime ldt2 = time.atDate(date);//
        //LocalDateTime ldt1 = date.atTime(12,15,25);// outra forma de ser fazer
        System.out.println("Data apartir de um determinado tempo: "+ldt1);
        System.out.println("Horas apartir de uma determinada data: "+ldt2);
    }

}

/*
LocalDateTime é a Junção da LocaDdate e LocalTime.

 */
