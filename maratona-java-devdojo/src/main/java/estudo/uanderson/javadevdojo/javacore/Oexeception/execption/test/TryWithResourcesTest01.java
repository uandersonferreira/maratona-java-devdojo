package estudo.uanderson.javadevdojo.javacore.Oexeception.execption.test;

import estudo.uanderson.javadevdojo.javacore.Oexeception.execption.dominio.Leitor1;
import estudo.uanderson.javadevdojo.javacore.Oexeception.execption.dominio.Leitor2;

import java.io.*;

public class TryWithResourcesTest01 {
    public static void main(String[] args) {
        lerArquivo();
    }

    public static void lerArquivo() {
        try (Leitor1 leitor1 = new Leitor1(); // Leitor1 é instanciado e será automaticamente fechado
             Leitor2 leitor2 = new Leitor2()) { // Leitor2 também será fechado automaticamente

            // Aqui podemos realizar operações com leitor1 e leitor2
            System.out.println("Lendo recursos...");
        } catch (IOException e) {
            // Captura exceções lançadas durante o uso dos recursos
            throw new RuntimeException(e); // Encapsula e relança a exceção como RuntimeException
        }
    }

    /*
    EXPLICAÇÃO SOBRE O TRY-WITH-RESOURCES:
    1. **Fechamento Automático:**
       - O bloco `try-with-resources` garante que os objetos declarados dentro do `()` 
         serão fechados automaticamente, assim que o bloco `try` for concluído (com ou sem exceção).
       - Isso elimina a necessidade de explicitamente chamar `close()` em um bloco `finally`.

    2. **Requisitos para Recursos:**
       - Somente objetos que implementam a interface `Closeable` (como `Reader`) ou `AutoCloseable`
         podem ser usados no `try-with-resources`.
       - Graças ao polimorfismo, podemos confiar que o método `close()` será chamado corretamente.

    3. **Ordem de Fechamento:**
       - Os recursos são fechados na **ordem inversa** àquela em que foram declarados.
       - Neste caso, `leitor2` será fechado antes de `leitor1`.

    4. **Exceções Suprimidas:**
       - Se uma exceção é lançada no `try` e outra exceção ocorre durante o fechamento de um recurso,
         a exceção do `try` será a principal, e a exceção do fechamento será "suprimida".
       - Essas exceções suprimidas podem ser acessadas com `Throwable.getSuppressed()`.

    5. **Vantagem:**
       - Código mais limpo e menos propenso a erros, especialmente quando manipulamos vários recursos.

    */

    public static void lerArquivo2() {
        Reader reader = null;
        try {
            // Abrindo um recurso manualmente
            reader = new BufferedReader(new FileReader("testeWithResources2.txt"));

            // Operações com o leitor aqui
            System.out.println("Lendo o arquivo de maneira tradicional...");
        } catch (FileNotFoundException e) {
            // Captura de exceções relacionadas ao arquivo não encontrado
            e.printStackTrace();
        } finally {
            // Fechamento manual do recurso
            try {
                if (reader != null) {
                    reader.close(); // Deve ser chamado manualmente
                }
            } catch (IOException e) {
                // Captura exceções durante o fechamento do recurso
                e.printStackTrace();
            }
        }
    }
}

/*
COMPARAÇÃO ENTRE OS DOIS MÉTODOS:
1. **Com try-with-resources (lerArquivo):**
   - O fechamento dos recursos (`leitor1` e `leitor2`) é automático.
   - O código é mais limpo e legível.
   - Menos propenso a erros, como esquecer de fechar o recurso ou lidar com exceções de fechamento.

2. **Com gerenciamento manual (lerArquivo2):**
   - O fechamento dos recursos deve ser feito manualmente em um bloco `finally`.
   - É necessário verificar se o recurso não é `null` antes de chamar `close()`.
   - Mais verboso e propenso a erros.

CONCLUSÃO:
- Sempre que possível, use `try-with-resources` para lidar com recursos, como arquivos, conexões de banco de dados, etc.
- Ele melhora a legibilidade do código e reduz a chance de vazamentos de recursos.
*/
