package estudo.uanderson.javadevdojo.javacore.ZZIjdbc.test;

import estudo.uanderson.javadevdojo.javacore.ZZIjdbc.domain.Producer;
import estudo.uanderson.javadevdojo.javacore.ZZIjdbc.service.ProduceService;

import java.util.List;

public class ConnectionFactoryTest03 {
    public static void main(String[] args) {
        Producer producer1 = Producer.builder().name("Toeii Animation").build();
        Producer producer2 = Producer.builder().name("White fox").build();
        Producer producer3 = Producer.builder().name("Studio Ghibli").build();

        ProduceService.saveTransaction(List.of(producer1, producer2, producer3));
    }
}
