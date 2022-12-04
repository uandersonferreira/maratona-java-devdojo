package estudo.uanderson.javadevdojo.javacore.Rdatas.test;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest01 {
    public static void main(String[] args) {
        //A classe Calendar é do pacote java.util, e é uma classe abstrata,
        // portanto não é permitido criar um objeto com new(instânciar)
        Calendar calendar = Calendar.getInstance();


        if (calendar.getFirstDayOfWeek() == Calendar.SUNDAY){
            System.out.println("Domingo é o primeiro dia da semana!");
        }

        System.out.println("Dia da semana: "+calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println("Dia do Mês: "+calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("Dia do Ano: "+calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println("Dia da semana no mês: "+calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));

        calendar.add(Calendar.DAY_OF_MONTH, 0);
        //calendar.add(Calendar.HOUR, 17);// add -> Fri May 20 02:30:25 BRT 2022 altera o dia
        calendar.roll(Calendar.HOUR, 17);// roll -> Thu May 19 02:31:25 BRT 2022 não altera o dia somente as horas no mesmo dia

        Date date = calendar.getTime();//racking para poder visualizar a data vindo do Calendar melhor
        System.out.println("Data Formatada => "+date);
    }//main
    }//class
