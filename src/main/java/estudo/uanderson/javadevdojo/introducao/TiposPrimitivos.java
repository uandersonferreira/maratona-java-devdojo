package estudo.uanderson.javadevdojo.introducao;

public class TiposPrimitivos {
    public static void main(String[] args) {
        //int, double, float, char, byte, short, long, boolean

        int idade = 10;
        long numerosGrandes = 100000000L;
        byte idadeByte = 127;
        double salarioDouble = 1000.85;
        float salarioFloat = 100.50F;
        short idadeShort = 18;
        boolean verdadeiro = true;
        boolean falso = false;
        char caractere = 'M';
        String nome = "Uanderson Ferreira";
        // String não é primitivo é inicia sempre com letra Maiúscula
        // É uma classe

        System.out.println(nome);
        System.out.println(verdadeiro);

        /*
        int --> 4 Bytes
        double --> 8 Bytes
        float(F) --> 4 Bytes
        char --> 2 Bytes
        byte --> 8 bits
        short --> 2 Bytes
        long(L) --> 8 Bytes
        boolean --> 1 bit ( Verdadeiro ou falso)

        case é quando forçamos uma uma variável
        ex:
          long numeroGrande = (long) 1500.55;
           o resultado será somente 1500, pois está forcando um valor
           (1500."55")que não é aceito na variável "long".
         */





    }


}
