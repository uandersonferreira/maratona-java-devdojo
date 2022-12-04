package estudo.uanderson.javadevdojo.javacore.Zgenerics.test;

import estudo.uanderson.javadevdojo.javacore.Zgenerics.Service.BarcoRentavelService;
import estudo.uanderson.javadevdojo.javacore.Zgenerics.domain.Barco;

public class ClasseGenericaTest02 {
    public static void main(String[] args) {
        BarcoRentavelService barcoRentavelService = new BarcoRentavelService();
        Barco barco = barcoRentavelService.buscarBarcoDisponivel();
        System.out.println("Usando barco por um mês....");
        barcoRentavelService.retornarBarcoAlugado(barco);

    }
}
// ctrl + C
// ctrl + F
// ctrl + R
// ctrl + Replace all