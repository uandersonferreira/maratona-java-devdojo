package estudo.uanderson.javadevdojo.javacore.Zgenerics.test;

import estudo.uanderson.javadevdojo.javacore.Zgenerics.Service.CarroRentavelService;
import estudo.uanderson.javadevdojo.javacore.Zgenerics.domain.Carro;

public class ClasseGenericaTest01 {
    public static void main(String[] args) {
        CarroRentavelService carroRentavelService = new CarroRentavelService();
        Carro carro = carroRentavelService.buscarCarroDisponivel();
        System.out.println("usando carro por um mês....");
        carroRentavelService.retornarCarroAlugado(carro);

    }
}
