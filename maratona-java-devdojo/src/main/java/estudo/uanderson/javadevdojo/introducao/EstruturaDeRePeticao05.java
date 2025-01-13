package estudo.uanderson.javadevdojo.introducao;

public class EstruturaDeRePeticao05 {

    public static void main(String[] args) {
       double valorTotal = 30000;

        for (int parcela = (int)valorTotal; parcela >= 1 ; parcela--) {
            double valorParcela = valorTotal / parcela;
            if (valorParcela < 1000){
                continue;
            }
            System.out.println("Parcela: ["+parcela+"] R$"+valorParcela);
        }

    }//main
}//class
/*
Continue -  Ignorar tudo que está abaixo dele é voltar para
cima.


 */