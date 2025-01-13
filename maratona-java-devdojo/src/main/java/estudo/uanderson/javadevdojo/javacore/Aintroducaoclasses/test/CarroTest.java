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

        carro1 = carro2; 
        
        /*
        * Orientação a Objetos - Referência de objetos
        * 
        * Ao fazer a atribuição `carro1 = carro2`, a variável `carro1` passa a referenciar
        * o mesmo objeto em memória que `carro2`. Ou seja, ambas as variáveis apontam para
        * o mesmo endereço na heap, onde o objeto do tipo `Carro` está armazenado.
        * 
        * Como a referência original de `carro1` foi sobrescrita, o objeto anteriormente
        * apontado por `carro1` fica inacessível. Isso significa que ele não possui mais
        * nenhuma referência válida e, eventualmente, será elegível para coleta pelo
        * garbage collector do Java.
        * 
        * Essa lógica funciona porque tanto `carro1` quanto `carro2` são do mesmo tipo (`Carro`),
        * permitindo que compartilhem a referência a um mesmo objeto.
        * 
        * Resultado: qualquer alteração feita no objeto referenciado por `carro1` ou `carro2`
        * será refletida em ambas as variáveis, pois ambas apontam para o mesmo objeto.
        */



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

