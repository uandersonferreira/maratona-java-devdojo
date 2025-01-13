package estudo.uanderson.javadevdojo.introducao;

public class EstruturasCondicionais04 {
    public static void main(String[] args) {
        byte dia = 4;
        // char, int, byte, short, enum, String. São os tipos primitivos aceitos
        // ao se utilizar o switch.

        switch (dia) {
            case 1:
                System.out.println("Domingo");
                break;
            case 2:
                System.out.println("Segunda-feira");
                break;
            case 3:
                System.out.println("Terça-feira");
                break;
            case 4:
                System.out.println("Quarta-feira");
                break;
            case 5:
                System.out.println("Quinta-feira");
                break;
            case 6:
                System.out.println("Sexta-feira");
                break;
            case 7:
                System.out.println("Sabádo");
                break;
            default:
                System.out.println("Opção Inválida!");
                break;
        }

        char sexo = 'M';
       // String sexo = "M";
        switch (sexo) {
            case 'M':
                System.out.println("Homem");
                break;
            case ('F'): {
                //Blocos de código é valdios nos switch, mas não é muito usado
                System.out.println("Mulher");   
                break; 
            }
        
            default:
            System.out.println("Inválido");
                break;
        }

        /*
         Utilizando switch e dados os valores de 1a 7, imprima se é dia útil ou final de semana
         consoderando 1 como domingo
         */

         byte diaDaSemana = 1;
         switch (diaDaSemana) {
            case 1:
            case 7:
                System.out.println("FDS");
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                System.out.println("Dia útil");
                break;    
            default:
                 System.out.println("Opção, inválida!");
                break;
         }



    }//main
}//class
