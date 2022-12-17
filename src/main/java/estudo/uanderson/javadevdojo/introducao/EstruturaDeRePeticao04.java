package estudo.uanderson.javadevdojo.introducao;

public class EstruturaDeRePeticao04 {
    //Dado o valor de um carro, descubra em quantas vezes ele pode ser parcelado
    //Condição valorParcela >= 1000
    public static void main(String[] args) {
       double valorTotal = 30000;

        for (int parcela = 1; parcela <= valorTotal ; parcela++) {
            double valorParcela = valorTotal / parcela;
                if (valorParcela < 1000){
                    break;//utilizado para sair de um laço de repetição
                }
                System.out.println("Parcela: ["+parcela+"] R$"+valorParcela);
        }

    }//main
}//class
/*
Continue -  manda tudo que está abaixo dele é voltar para
cima.


 */