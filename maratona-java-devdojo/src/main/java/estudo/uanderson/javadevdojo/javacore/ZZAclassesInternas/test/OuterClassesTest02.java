package estudo.uanderson.javadevdojo.javacore.ZZAclassesInternas.test;

public class OuterClassesTest02 {
    private String name = "Midoriya";

    void print(){
        String lastName = "Izuku";
        //lastName = "";
        class LocalClass{
            public void printLocal(){
                System.out.println(name+ " "+lastName);
            }
        }//class

        LocalClass localClass = new LocalClass();
       // new LocalClass().printLocal(); Outra sintaxe válida
        localClass.printLocal();
    }//method print



    public static void main(String[] args) {
        OuterClassesTest02 outer = new OuterClassesTest02();
        outer.print();

    }

}//OuterClassesTest02

/*

Classes locais, e quanto temos uma classe dentro de um
bloco de inicialização statico ou dentro de um bloco de
inicializzação de um metodo.

Para utilizar as classe locais é necessário inicialas dentro do
bloco do metodo em que foi criada e realizar a chamada do(s) metodos
que foram criados que for necessário para a execução da aplicação.
Ex:
    void print(){
        class LocalClass{
            public void printLocal(){
                System.out.println(name);
            }
        }//class

  ->      LocalClass localClass = new LocalClass();
  ->      localClass.printLocal();
    }//method print

Modificadores de acesso válidos para as classes Locais ->
 - final e abstract

-> Os parametros passados ou atributos criados dentro de methods que possuem classe locaiis
os utilizados, necessinta ser Final ou efetivamente Final (Constante - não podem ser alterados)

       - String lastName = "Izuku"; -> Efetivamente final, pois não estamos declarando ela como final,
        mas por padrão o java a considera como sendo;

        - final String lastname = "Izuku"; -> Final


 */