package estudo.uanderson.javadevdojo.javacore.Zgenerics.test;

abstract class Animal{
    public abstract void consulta();
}

class Cachorro extends Animal{

    @Override
    public void consulta() {
        System.out.println("Consultando doguinho!");
    }
}//class cachorro

class Gato extends Animal{

    @Override
    public void consulta() {
        System.out.println("Consultando Gatinho!");
    }
}

public class WildcardTest01 {
    public static void main(String[] args) {
       Cachorro cachorro[] = {new Cachorro(), new Cachorro()};
       Gato gato[] = {new Gato(), new Gato()};

       printConsulta(cachorro);
       printConsulta(gato);

       Animal animals[] = {new Gato(), new Cachorro()};
       printConsulta(animals);


    }//main

    private static void printConsulta(Animal[] animals){
        for (Animal animal : animals) {
            animal.consulta();
        }

      //  animals[0] = new Gato();
    }


}//class
