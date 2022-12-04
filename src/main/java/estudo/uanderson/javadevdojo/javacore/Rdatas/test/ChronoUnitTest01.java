package estudo.uanderson.javadevdojo.javacore.Rdatas.test;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class ChronoUnitTest01 {
    public static void main(String[] args) {
        LocalDateTime aniversario = LocalDateTime.of(2002, Month.AUGUST,13,4,0,0);
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime august13 = LocalDateTime.of(2022,Month.AUGUST,14,1,20,25);

        System.out.println(ChronoUnit.DAYS.between(aniversario, now));
        System.out.println(ChronoUnit.WEEKS.between(aniversario, now));
        System.out.println(ChronoUnit.MONTHS.between(aniversario, now));
        System.out.println(ChronoUnit.YEARS.between(aniversario, now));

        System.out.println("-------------------------------------");
        System.out.println(ChronoUnit.DAYS.between(aniversario, august13));
        System.out.println(ChronoUnit.WEEKS.between(aniversario, august13));
        System.out.println(ChronoUnit.MONTHS.between(aniversario, august13));
        System.out.println(ChronoUnit.YEARS.between(aniversario, august13));
    }
}

//aula127