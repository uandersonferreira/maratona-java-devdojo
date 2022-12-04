package estudo.uanderson.javadevdojo.javacore.ZZHpadroesdeprojeto.dominio;

import java.util.HashSet;
import java.util.Set;

public class AircraftSingletonLazy {
    private static  AircraftSingletonLazy INSTANCE;
    private final Set<String> availableSeats = new HashSet<>();
    private final String name;

    private AircraftSingletonLazy(String name) {
        this.name = name;
    }

    {
        availableSeats.add("1A");
        availableSeats.add("1B");
    }

    public static AircraftSingletonLazy getINSTANCE() {//poderia só colocar o synchronized na assinatura do method, mas afetaria a performance
       /*
              --Double-Checked Locking with Singleton--
       Portando, faz-se uma preve verificação é aaplica o synchronized
       na classe ao invés do method é faz outra verificação da INSTANCE,
       pois caso seja nula é atribuida um objeto com um valor para ela.
        */
        if(INSTANCE == null){
            synchronized (AircraftSingletonLazy.class){
                if (INSTANCE == null){
                    INSTANCE = new AircraftSingletonLazy("787-900");
                }
            }
        }
        return INSTANCE;
    }//getINSTANCE


    public boolean bookSeat(String seat){
        return availableSeats.remove(seat);
    }

}//class
/*
link: https://www.baeldung.com/java-singleton-double-checked-locking

 */