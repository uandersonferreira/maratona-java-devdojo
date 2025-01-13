package estudo.uanderson.javadevdojo.javacore.Pwrapper.test;

public class WrapperTest01 {
    public static void main(String[] args) {
        
        // Tipos primitivos
        byte byteP = 1;
        short shortP =1;
        int intP = 1;
        long longP =10L;
        float floatP =10F;
        double doubleP = 10.55;
        char charP = 'U';
        boolean booleanP = false;


        // Wrappers
        Byte byteW = 1;
        Short shortW =1;
        Integer intW = 1;//autoboxing - primitivo para Wrapper
        Long longW =10L; 
        Float floatW =10F;
        Double doubleW = 10.55;
        Character charW = 'U';
        Boolean booleanW = false;

        int i = intW;//unboxing - wrapper para primitivo
        Integer intw2 = Integer.parseInt("20");

    }//main
}//class

/*
Wrappers são classe que basicamente, encapsula os tipos
primitivos e transformam em um Objeto(class).

Autoboxing e Unboxing:

Autoboxing: Converte automaticamente um tipo primitivo para o tipo Wrapper correspondente.
Exemplo: Integer intW = 1; // int (primitivo) para Integer (Wrapper).

Unboxing: Converte automaticamente um objeto Wrapper para o tipo primitivo correspondente.
Exemplo: int i = intW; // Integer (Wrapper) para int (primitivo).

Ao se trabalhar com o wrappers a regra do polimorfismo se aplica também, pois 
não estamos mais trabalhando com os valores primitivos(bits), mas sim com os 
Objetos, logo um Objeto Long e diferente de um objeto Integer. Já nos primitivos não é a mesma coisa
já que um long pode aceitar um int.

ex:  Long longW = 10; //dar erro pois o '10' é um Integer, que é diferente de um Objeto Long 

ex2: long longP = 10; // Aceita, pois '10' é um int que é menor que um long, logo cabe dentro do long. 
                      e, é convertido implicitamente para long


1° - TIPOS PRIMITIVOS: REGRA DA QUANTIDADE BITS, O TAMANHO DO ESPAÇO EM MEMÓRIA QUE ESTAMOS ALOCANDO.
2° - TIPOS WRAPPER: É APLICADO A REGRA DO POLIMORFISMO



 */
