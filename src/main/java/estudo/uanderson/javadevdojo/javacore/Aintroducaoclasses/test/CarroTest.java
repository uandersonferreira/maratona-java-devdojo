package estudo.uanderson.javadevdojo.javacore.Aintroducaoclasses.test;

import estudo.uanderson.javadevdojo.javacore.Aintroducaoclasses.dominio.Carro;

public class CarroTest {
    public static void main(String[] args) {
        Carro carro1 = new Carro();
        Carro carro2 = new Carro();

        carro1.nome = "Mustang";
        carro1.modelo= "GT 500";
        carro1.ano= 1969;

        carro2.nome = "Fusca Bala";
        carro2.modelo = "Sport";
        carro2.ano = 1968;

        System.out.println("Carro 1: ");
        System.out.println(carro1.nome);
        System.out.println(carro1.modelo);
        System.out.println(carro1.ano);

        System.out.println("\nCarro 2: ");
        System.out.println(carro2.nome);
        System.out.println(carro2.modelo);
        System.out.println(carro2.ano);

    }
}
