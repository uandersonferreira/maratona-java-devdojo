package estudo.uanderson.javadevdojo.javacore.Rdatas.test;

import java.util.Date;

public class DateTest01 {
    public static void main(String[] args) {
        Date date = new Date(1652961619219L);//é um Long e trabalha com milisegundos desde 1° de janeiro de 1970
       date.setTime(date.getTime() + 3_600_000);//para adicionar uma hora
        System.out.println(date);

        //A classe Date já está despreciada, no entanto pode aparecer em sistemas legados/antigos
    }
}
