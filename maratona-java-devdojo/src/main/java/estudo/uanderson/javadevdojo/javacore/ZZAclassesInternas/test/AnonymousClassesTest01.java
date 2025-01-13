package estudo.uanderson.javadevdojo.javacore.ZZAclassesInternas.test;

class Animal {
    public void walk(){
        System.out.println("Aniaml walking");
    }
}//Class Animal



public class AnonymousClassesTest01 {
    public static void main(String[] args) {
      Animal animal = new Animal(){
          @Override
          public void walk() {
              System.out.println("Walking inthe shadows");
          }
      };
      animal.walk();

    }
}//AnonymousClassesTest01
/*
Estamos criando uma sub-classe anonima(que não tê nome)
que está sobreescrendo o metodo walk(mudando o comportamento do metodo)

 */
