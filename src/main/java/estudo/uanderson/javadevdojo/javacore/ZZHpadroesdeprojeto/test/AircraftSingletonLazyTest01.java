package estudo.uanderson.javadevdojo.javacore.ZZHpadroesdeprojeto.test;

import estudo.uanderson.javadevdojo.javacore.ZZHpadroesdeprojeto.dominio.AircraftSingletonLazy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AircraftSingletonLazyTest01 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        bookSeat("1A");
        bookSeat("1A");
        System.out.println("Sem reflection: "+AircraftSingletonLazy.getINSTANCE());
        System.out.println("Sem reflection: "+AircraftSingletonLazy.getINSTANCE());

        Constructor<AircraftSingletonLazy> constructor = AircraftSingletonLazy.class.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        AircraftSingletonLazy aircraftSingletonLazy = constructor.newInstance("787-900");
        System.out.println("Com reflection: "+aircraftSingletonLazy);
    }//main

    private static void bookSeat(String seat){
        System.out.println(AircraftSingletonLazy.getINSTANCE());
        AircraftSingletonLazy aircraftSingletonLazy = AircraftSingletonLazy.getINSTANCE();
        System.out.println(aircraftSingletonLazy.bookSeat(seat));
    }

}//class
/*
Link: https://www.oodlestechnologies.com/blogs/how-to-save-singleton-pattern-from-reflection-serialization-and-cloning/


 */