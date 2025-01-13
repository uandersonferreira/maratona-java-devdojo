package estudo.uanderson.javadevdojo.javacore.Rdatas.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class TemporalAjustersTest01 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate now2 = LocalDate.now();

        now = now.plusDays(10);//muda os dias é altera o mês
        now2 = now2.withDayOfMonth(10);//muda os dias mas não altera o mês

        System.out.println("Data Atual: "+LocalDate.now());
        System.out.println("\nplusDay: "+now);
        System.out.println(now.getDayOfWeek());
        System.out.println("withDayOfMonth: "+now2);
        System.out.println(now2.getDayOfWeek());
        System.out.println("-------------------");

        now = LocalDate.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY));
        System.out.println(now);
        System.out.println(now.getDayOfWeek()+"\n");

        now = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        System.out.println(now);
        System.out.println(now.getDayOfWeek()+"\n");

        now = LocalDate.now().with(TemporalAdjusters.previous(DayOfWeek.SATURDAY));
        System.out.println(now);
        System.out.println(now.getDayOfWeek()+"\n");

        now = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(now);
        System.out.println(now.getDayOfWeek()+"\n");

        now = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(now);
        System.out.println(now.getDayOfWeek()+"\n");

        now = LocalDate.now().with(TemporalAdjusters.firstDayOfNextYear());
        System.out.println(now);
        System.out.println(now.getDayOfWeek()+"\n");

        now = LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println(now);
        System.out.println(now.getDayOfWeek()+"\n");

        //aula 127
    }
}
