package estudo.uanderson.javadevdojo.javacore.Oexeception.runtime.test;

import java.io.FileNotFoundException;
import java.sql.SQLException;


public class RunTimeExceptionTest04 {
    public static void main(String[] args) {

        try {
            throw new RuntimeException();
        } catch (ArrayIndexOutOfBoundsException e) { 
            // Este bloco NÃO será executado porque a exceção lançada é RuntimeException,
            // que não é uma instância de ArrayIndexOutOfBoundsException.
            System.out.println("dentro do ArrayIndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) { 
            // Este bloco também NÃO será executado porque a exceção lançada
            // não é uma instância de IndexOutOfBoundsException.
            System.out.println("dentro do IndexOutOfBoundsException");
        } catch (IllegalArgumentException e) { 
            // Este bloco NÃO será executado porque a exceção lançada
            // não é uma instância de IllegalArgumentException.
            System.out.println("dentro do IllegalArgumentException");
        } catch (RuntimeException e) { 
            // Este bloco SERÁ executado, pois a exceção lançada é do tipo RuntimeException.
            // Como é mais genérica e aparece por último, captura as exceções que não foram tratadas antes.
            System.out.println("dentro do RuntimeException");
        }

        try {
            talvezlanceException(); // Método que pode lançar SQLException ou FileNotFoundException.
        } catch (SQLException | FileNotFoundException e) {
            // Tratamento usando multi-catch para exceções NÃO relacionadas hierarquicamente.
            // Aqui, "e" é efetivamente final, então você não pode reatribuir um novo valor a ela.
            // Isso evita confusões sobre qual exceção está sendo tratada.
            // Por exemplo, `e = new RuntimeException();` não é permitido.
            e.printStackTrace();
            // Exceções listadas no multi-catch devem ser disjuntas (não podem ter relação de herança).
        } catch (Exception e) {
            // Exceções genéricas ou de alto nível devem vir DEPOIS das específicas,
            // caso contrário, as específicas serão "ofuscadas".
            // Aqui, é permitido reatribuir `e` porque não estamos em um bloco multi-catch.
            e = new RuntimeException();
            e.printStackTrace();
        }
    }

    private static void talvezlanceException() throws SQLException, FileNotFoundException {
        // Este método é declarado com duas exceções verificadas (checked exceptions),
        // exigindo que quem o chama trate ou propague essas exceções.
    }
}

/*
REGRAS IMPORTANTES SOBRE TRATAMENTO DE EXCEÇÕES:

1. ORDEM DOS BLOCO CATCH:
   - Sempre coloque os blocos `catch` com exceções mais específicas ANTES dos blocos com exceções mais genéricas.
   - Caso contrário, o compilador emitirá um erro porque as exceções mais genéricas capturariam as mais específicas,
     tornando-as inacessíveis.

2. MULTI-CATCH:
   - Exceções relacionadas hierarquicamente (por exemplo, `IOException` e `FileNotFoundException`)
     não podem ser combinadas em um bloco `catch` único com o operador `|`.
   - Exceções não relacionadas podem ser combinadas (como `SQLException | FileNotFoundException`).
   - A variável de exceção `e` em um multi-catch é efetivamente final, ou seja, não pode ser reatribuída.

3. REATRIBUIÇÃO DE EXCEÇÃO:
   - Fora de um multi-catch, é possível reatribuir a variável de exceção `e`,
     mas isso raramente é necessário ou recomendado.

4. PROPAGAÇÃO DE EXCEÇÕES:
   - O método `talvezlanceException` usa `throws` para declarar que pode lançar exceções verificadas.
   - O chamador deve tratar ou propagar essas exceções.
*/
