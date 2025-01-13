package estudo.uanderson.javadevdojo.javacore.Zgenerics.test;

import estudo.uanderson.javadevdojo.javacore.Zgenerics.Service.RentalService;
import estudo.uanderson.javadevdojo.javacore.Zgenerics.domain.Barco;
import estudo.uanderson.javadevdojo.javacore.Zgenerics.domain.Carro;

import java.util.ArrayList;
import java.util.List;

public class ClasseGenericaTest03 {
    public static void main(String[] args) {
        List<Carro> carrosDisponiveis = new ArrayList<>(List.of(new Carro("BMW"), new Carro("Fusca")));
        List<Barco> barcosDisponiveis = new ArrayList<>(List.of(new Barco("Lancha"), new Barco("Iate")));

        RentalService<Carro> rentalServiceCarro = new RentalService<>(carrosDisponiveis);
        Carro carro = rentalServiceCarro.buscarObjetoDisponivel();
        System.out.println("Usando o carro por um mês...");
        rentalServiceCarro.retornarObjetoAlugado(carro);

        System.out.println("---------------------------");

        RentalService<Barco> rentalServiceBarco = new RentalService<>(barcosDisponiveis);
        Barco barco = rentalServiceBarco.buscarObjetoDisponivel();
        System.out.println("Usando o barco por um mês...");
        rentalServiceBarco.retornarObjetoAlugado(barco);

    }
}
// ctrl + C
// ctrl + F
// ctrl + R
// ctrl + Replace all