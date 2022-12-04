package estudo.uanderson.javadevdojo.javacore.Rdatas.test;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;

public class LocalDateTest01 {
    public static void main(String[] args) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();

        System.out.println(date);
        System.out.println(calendar);

        LocalDate localDate = LocalDate.of(2022, Month.JANUARY,20);
        LocalDate dataAtual = LocalDate.now();

        System.out.println("Ano: "+localDate.getYear());
        System.out.println("Mês: "+localDate.getMonth());
        System.out.println("Valor Mês: "+localDate.getMonthValue());
        System.out.println("Dia da semana: "+localDate.getDayOfWeek());
        System.out.println("Dia do mês: "+localDate.getDayOfMonth());
        System.out.println("Total de dias do Mês: "+localDate.lengthOfMonth());
        System.out.println("Ano bissexto: "+localDate.isLeapYear());
        System.out.println("Utilizando Métodos da Interface TemporalField");
        System.out.println("Ano: "+localDate.get(ChronoField.YEAR));
        System.out.println("Dia do Mês: "+localDate.get(ChronoField.DAY_OF_MONTH));
        System.out.println(localDate);
        System.out.println("Data atual: "+dataAtual);

        dataAtual = dataAtual.plusDays(20);//add dias e altera o mês
        System.out.println("Data atual após o plus: "+dataAtual);
    }//main
}
