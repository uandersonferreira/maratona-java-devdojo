package estudo.uanderson.javadevdojo.javacore.ZZHpadroesdeprojeto.test;

import estudo.uanderson.javadevdojo.javacore.ZZHpadroesdeprojeto.dominio.AircraftSingletonEager;

public class AircraftTest01 {
    public static void main(String[] args) {
        bookSeat("1A");
        bookSeat("1A");

    }//main

     static void bookSeat(String seat){
         System.out.println(AircraftSingletonEager.getINSTANCE());
//        Aircraft aircraft = new Aircraft("787-900");
//        System.out.println(aircraft.bookSeat(seat));
    }

}//class
