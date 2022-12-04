package estudo.uanderson.javadevdojo.javacore.ZZBcomportamento.test;

import estudo.uanderson.javadevdojo.javacore.ZZBcomportamento.domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ComportamentoPorParamentroTest03 {
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
        System.out.println("------------------------------------");

        List<Integer> listNumerics = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        System.out.println("N° pares: "+filter(listNumerics, num -> num % 2 == 0 ));
        System.out.println("N° impares: "+filter(listNumerics, num -> num % 2 == 1 ));
    }//main


    //METODO GENERICO
    private static <T> List<T>  filter(List<T> list, Predicate<T> predicate){
        List<T> filterList = new ArrayList<>();
        for (T elemento : list) {
            if (predicate.test(elemento)){
                filterList.add(elemento);
            }
        }
        return filterList;
    }



}//class
/*
Lambdas -> Precisam que a interface que estamos trabalhando seja uma
interface funcional. para isso a notação utilizada é: @FunctionalInterface
Ex:
@FunctionalInterface
public interface CarPredicate {
    boolean test(Car car);
}

É uma INTERFACE FUNCIONAL -> é uma interface onde temos apenas um metodo
abstrato que define o seu comportamento/funcionalidade. Caso tente criar, mais
 de 1 irá gerar erro.
ex: boolean test(Car car);


 -> COMO MONTAR A LAMBDA:
 -(parametro -> <expressão>
 -(Car car) -> car.getColor().equals.("red);
 -(car) -> car.getColor().equals.("red); Pode-se omitir a declaração da Class
 -(car, valor) -> car.getColor().equals.("red);// caso tivessemos mais de um parametro esperado pelo metodo abstrado da
 Interface Funcional.

 - Caso não tenha paramentro usa-se um parentese vazio -> ()
 -São anonimas é são chamadas de funções, pois não estão ligadas a uma classe.E seu
 objetivo é ser mais conciso(objetivo).

 -> E qualquer interface funcional, pode utilizar lambdas



 */
