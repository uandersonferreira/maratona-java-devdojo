package estudo.uanderson.javadevdojo.javacore.ZZBcomportamento.interfaces;

import estudo.uanderson.javadevdojo.javacore.ZZBcomportamento.domain.Car;

@FunctionalInterface
public interface CarPredicate {
    boolean test(Car car);
}
