package estudo.uanderson.javadevdojo.javacore.Pwrapper.test;

public class WrapperTest01 {
    public static void main(String[] args) {
        byte byteP = 1;
        short shortP =1;
        int intP = 1;
        long longP =10L;
        float floatP =10F;
        double doubleP = 10.55;
        char charP = 'U';
        boolean booleanP = false;


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
primitivos e transforma-los em um Objeto(class).
 */
