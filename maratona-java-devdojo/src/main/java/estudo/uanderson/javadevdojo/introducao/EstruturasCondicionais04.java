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

    }
}
