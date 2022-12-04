package estudo.uanderson.javadevdojo.javacore.ZZBcomportamento.test;

import estudo.uanderson.javadevdojo.javacore.ZZBcomportamento.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class ComportamentoPorParamentroTest01 {
   private static List<Car> cars = List.of(
            new Car("Green",2011),
            new Car("Black",1998),
            new Car("Red",2018)
    );//List<Car>

    public static void main(String[] args) {

        System.out.println(filterGreencar(cars));
        System.out.println(filterRedcar(cars));
        System.out.println(filterByColor(cars, "black"));
        System.out.println("--------------------");
        System.out.println(filterByYearBefore(cars,2018));

    }//main


    private static List<Car> filterGreencar (List<Car> cars){
        List<Car> filterCar = new ArrayList<>();
        for (Car car : cars) {
            if (car.getColor().equalsIgnoreCase("Green")){
                filterCar.add(car);
            }
        }
        return filterCar;
    }//

    private static List<Car> filterRedcar (List<Car> cars){
        List<Car> filterCar = new ArrayList<>();
        for (Car car : cars) {
            if (car.getColor().equalsIgnoreCase("Red")){
                filterCar.add(car);
            }
        }
        return filterCar;
    }//

    private static List<Car> filterByColor (List<Car> cars, String corCarro){
        List<Car> filterCar = new ArrayList<>();
        for (Car car : cars) {
            if (car.getColor().equalsIgnoreCase(corCarro)){
                filterCar.add(car);
            }
        }
        return filterCar;
    }//

    private static List<Car> filterByYearBefore (List<Car> cars, int ano){
        List<Car> filterCar = new ArrayList<>();
        for (Car car : cars) {
            if (car.getYear() < ano){
                filterCar.add(car);
            }
        }
        return filterCar;
    }//

}//class
/*

 */
