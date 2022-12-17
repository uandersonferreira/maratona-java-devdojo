package estudo.uanderson.javadevdojo.javacore.Rdatas.test;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

//ctrl + f/ ctrl + r para mudar o nome de algo
public class PeriodTest01 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate nowAfterTwoYears = LocalDate.now().plusYears(2).plusDays(10);

        Period p1 = Period.between(now,nowAfterTwoYears);
        Period p2 = Period.ofDays(10);
        Period p3 = Period.ofWeeks(28);
        Period p4 = Period.ofMonths(5);
        Period p5 = Period.ofYears(3);

        System.out.println("Class Period: "+p1);
        System.out.println("ofDays: "+p2);
        System.out.println("ofWeeks: "+p3);
        System.out.println("ofMonths: "+p4);
        System.out.println("ofYears:"+p5);

        System.out.println("OfWeeks -> p3.getMonths: "+p3.getMonths());

        System.out.println(Period.between(now, now.plusDays(p3.getDays())).getMonths());
        System.out.println(now.until(now.plusDays(p3.getDays()), ChronoUnit.MONTHS));
        System.out.println("P1: "+p1);

    }
}
