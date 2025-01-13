package estudo.uanderson.javadevdojo.javacore.Zgenerics.Service;

import estudo.uanderson.javadevdojo.javacore.Zgenerics.domain.Carro;

import java.util.ArrayList;
import java.util.List;

public class CarroRentavelService {
    private List<Carro> carrosDisponiveis = new ArrayList<>(List.of(
            new Carro("BMW"), new Carro("Fusca")
    ));

    public Carro buscarCarroDisponivel(){
        System.out.println("Buscando carro disponível....");
        Carro carro = carrosDisponiveis.remove(0);
        System.out.println("Alugando Carro: "+ carro);
        System.out.println("Carros disponíveis para Alugar: ");
        System.out.println(carrosDisponiveis);
        return carro;
    }

    public void retornarCarroAlugado(Carro carro){
        System.out.println("Devolvendo Carro: "+carro);
        carrosDisponiveis.add(carro);
        System.out.println("carros disponiveis para alugar: ");
        System.out.println(carrosDisponiveis);
    }

}//class
