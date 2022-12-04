package estudo.uanderson.javadevdojo.javacore.Zgenerics.Service;

import estudo.uanderson.javadevdojo.javacore.Zgenerics.domain.Barco;

import java.util.ArrayList;
import java.util.List;

public class BarcoRentavelService {
    private List<Barco> barcosDisponiveis = new ArrayList<>(List.of(
            new Barco("Lancha"), new Barco("Iate")
    ));

    public Barco buscarBarcoDisponivel(){
        System.out.println("Buscando barco disponível....");
        Barco barco = barcosDisponiveis.remove(0);
        System.out.println("Alugando Barco: "+ barco);
        System.out.println("Barcos disponíveis para Alugar: ");
        System.out.println(barcosDisponiveis);
        return barco;
    }

    public void retornarBarcoAlugado(Barco barco){
        System.out.println("Devolvendo Barco: "+barco);
        barcosDisponiveis.add(barco);
        System.out.println("Barcos disponiveis para alugar: ");
        System.out.println(barcosDisponiveis);
    }

}//class
