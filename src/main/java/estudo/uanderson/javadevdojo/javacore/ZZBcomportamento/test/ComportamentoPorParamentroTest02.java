package estudo.uanderson.javadevdojo.javacore.ZZBcomportamento.test;

import estudo.uanderson.javadevdojo.javacore.ZZBcomportamento.domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ComportamentoPorParamentroTest02 {
   private static List<Car> cars = List.of(
            new Car("Green",2011),
            new Car("Black",1998),
            new Car("Red",2018)
    );//List<Car>

    public static void main(String[] args) {

//        List<Car>  greenCars = filter(cars, new CarPredicate() {
//            @Override
//            public boolean test(Car car) {
//                return car.getColor().equalsIgnoreCase("Green");
//            }
//        });

        //-------SINTAXE DE LAMPADAS DO JAVA ------------------
        List<Car>  greenCars = filter(cars, car -> car.getColor().equalsIgnoreCase("green"));
        List<Car>  redCars = filter(cars, car -> car.getColor().equalsIgnoreCase("Red"));
        List<Car>  blackCars = filter(cars, car -> car.getColor().equalsIgnoreCase("Black"));
        List<Car>  yearBeforeCars = filter(cars, car -> car.getYear() < 2015);

        System.out.println("greenCars: "+greenCars);
        System.out.println("redCars: "+redCars);
        System.out.println("blackCars: "+blackCars);
        System.out.println("yearBeforeCars: "+yearBeforeCars);
    }//main

    private static List<Car> filter (List<Car> cars, Predicate<Car> carPredicate){//já existe uma interface "Predicate" pré
        // preparada para aceitar qualquer coisa, portanto podemos usar-la no lugar da interface carPredicate criada.
        List<Car> filterCar = new ArrayList<>();
        for (Car car : cars) {
            if (carPredicate.test(car)){
                filterCar.add(car);
            }
        }
        return filterCar;
    }//



}//class
/*

 */
