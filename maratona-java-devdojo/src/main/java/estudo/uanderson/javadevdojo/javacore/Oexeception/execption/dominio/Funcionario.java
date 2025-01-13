package estudo.uanderson.javadevdojo.javacore.Oexeception.execption.dominio;

public class Funcionario extends Pessoa {
    @Override
    public void salvar() {
        // Sobrescrevemos o método "salvar" da classe Pessoa.
        // Nesta implementação, escolhemos NÃO declarar exceções (nem checadas nem não checadas).
        System.out.println("Salvando Funcionário");
    }

    /*
      REGRAS PARA SOBRESCRITA DE MÉTODOS COM EXCEÇÕES EM JAVA:

      1. Exceções Não Precisam Ser Sobrescritas:
         - Não somos obrigados a declarar as mesmas exceções do método original ao sobrescrevê-lo.
         - Isso porque a implementação da subclasse pode ser completamente diferente e não requerer essas exceções.

      2. Podemos Lançar Parte ou Todas as Exceções do Método Original:
         - Ao sobrescrever um método, podemos optar por declarar algumas ou todas as exceções verificadas (checked exceptions) lançadas no método original.
         Exemplo:
         
         @Override
         public void salvar() throws LoginInvalidException {
             System.out.println("Salvando Funcionário");
         }
         

      3. Exceções Não Verificadas (Unchecked Exceptions):
         - Podemos declarar exceções do tipo `RuntimeException` ou suas subclasses (exceções não verificadas), mesmo que o método original não as declare.
         Exemplo:
         
         @Override
         public void salvar() throws IllegalArgumentException {
             System.out.println("Salvando Funcionário");
         }
         

      4. Restrições para Exceções Mais Genéricas:
         - Não podemos lançar exceções mais genéricas (como `Exception`) ao sobrescrever um método que declara exceções específicas.
         - Isso violaria o contrato do método original, pois o chamador não esperaria exceções mais amplas.
         Exemplo Inválido:
         
         @Override
         public void salvar() throws Exception {
             System.out.println("Salvando Funcionário");
         }
         

      5. Checked Exceptions na Sobrescrita:
         - Podemos declarar exceções verificadas (checked exceptions) na sobrescrita, desde que sejam subclasses diretas ou indiretas das exceções declaradas no método original.
         Exemplo Válido:
         
         @Override
         public void salvar() throws FileNotFoundException {
             System.out.println("Salvando Funcionário");
         }
         

      6. Conclusão:
         - A sobrescrita de métodos com exceções oferece flexibilidade, mas impõe restrições para garantir compatibilidade com o contrato do método original.
         - Exceções não verificadas podem ser adicionadas livremente, mas as verificadas devem ser compatíveis com as declaradas na superclasse.
     */
}



/*
EXPLICAÇÕES ADICIONAIS:

- Checked Exceptions (Exceções Verificadas):
  - São exceções que o compilador exige que sejam tratadas ou declaradas na assinatura do método (`throws`).
  - Exemplo: `FileNotFoundException`, `SQLException`.

- Unchecked Exceptions (Exceções Não Verificadas):
  - São exceções que NÃO precisam ser tratadas ou declaradas explicitamente.
  - Elas herdam de `RuntimeException` (exemplo: `IllegalArgumentException`, `NullPointerException`).

- Polimorfismo e Sobrescrita:
  - Quando um método é sobrescrito, o comportamento é determinado pela classe concreta (subclasse) em tempo de execução.
  - A assinatura do método sobrescrito deve ser compatível com a do método original, incluindo a declaração de exceções.
*/
