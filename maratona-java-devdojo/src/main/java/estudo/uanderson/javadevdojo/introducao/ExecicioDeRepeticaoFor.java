package estudo.uanderson.javadevdojo.introducao;

public class ExecicioDeRepeticaoFor {
    public static void main(String[] args) {
        //Imprimir todos os números pares de 0 até 1000

        for (int i = 0; i <= 1000; i++) {
            if (i % 2 == 0) {
                System.out.println(i);

                /*
                for (int i = 0; i <= 1000; i += 2)
                for (definindo uma váriavel local;Condição; Incrementando um contador)

                O if foi adicionado para deixar o código mais flexível
                para alterações nas regras de negócios.
                ex: pedir os pares de 10 até 100, ao contrário de 0 até 1000.
                 */
            }
        }

    }
}
