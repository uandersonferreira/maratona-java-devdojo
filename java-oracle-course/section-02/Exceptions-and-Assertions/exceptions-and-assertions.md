# Exceções e Asserções

Objetivos:

- Esta lição aborda os seguintes tópicos:
  - Utilizar a sintaxe de manipulação de exceções para criar aplicativos confiáveis.
  - Utilizar as instruções `try` e `throw`.
  - Utilizar as instruções `catch`, multi-catch e `finally`.
  - Reconhecer classes e categorias de exceção comuns.
  - Criar exceções personalizadas e recursos auto-closeable.
  - Testar invariantes usando asserções.

## Exceções

- Exceções, ou erros de tempo de execução (erros que ocorrem durante a execução do código), devem ser manipulados pelo programador para garantir que o programa lide adequadamente com situações inesperadas.

- O tratamento de exceções envolve os seguintes recursos:
  - Instruções `try-catch`.
  - Instrução `throw`.

> **Nota:** É fácil detectar pequenos erros comuns, como erros matemáticos, falha em abrir arquivos e falha em calcular informações corretamente. A principal coisa a lembrar é que erros não são comportamentos esperados e devem ser tratados de forma apropriada para evitar que o programa falhe.

### Instruções Try-Catch

As instruções `try-catch` são usadas para manipular erros e exceções em Java e seguem estas etapas:

- O programa executa o bloco de código `try` primeiro.
- Se nenhuma exceção ocorrer, o programa continua executando o código subsequente sem entrar no bloco `catch`.
- Se uma exceção for lançada, o programa procurará uma instrução `catch` que capture a exceção específica.
- Se nenhuma instrução `catch` adequada for encontrada e a exceção não for tratada de outra forma, seu programa falhará durante o tempo de execução.

- A instrução `catch` é onde o erro é tratado.

> **Nota:** É importante entender que o código na instrução `try` será executado até que ocorra um erro. Se nenhum erro ocorrer, a instrução `catch` não será executada.

### Procurando a Instrução Catch

- Se nenhuma instrução `catch` adequada for encontrada e a exceção não for tratada de outra forma, seu programa falhará durante o tempo de execução.
- Você pode escolher como deseja lidar com o erro, fornecendo uma mensagem de erro apropriada ou fornecendo um valor padrão para uma variável, conforme o erro que foi tratado.

> **Nota:** Embora seu programa não trave com uma instrução `try-catch`, é importante lembrar que ocorreu um erro e seu programa não foi executado com êxito total.

### Usando Várias Declarações de Captura (Multiple Catch Statements)

- Existem diferentes tipos de exceções, e várias capturas podem ser usadas para tratar várias exceções.
- Isso é especialmente útil se diferentes exceções precisarem ser tratadas de forma diferente.
- Apenas uma exceção será capturada quando várias declarações de captura são usadas, e será capturada na ordem em que são tratadas.
- O uso de várias declarações de captura pode tornar as capturas mais específicas para a exceção que ocorre.

### Quando Várias Declarações de Captura são Eficazes?

- Várias declarações de captura podem ser usadas para uma instrução `try` a fim de capturar exceções mais específicas.

> **Nota:** A declaração `catch` para `Exception` deve vir por último, pois ela capturará todas as exceções não específicas.

### Exemplo de Manipulação de Exceções

```java
try {
    // código que pode lançar exceção
} catch (IOException e) {
    // trata IOException
} catch (NumberFormatException e) {
    // trata NumberFormatException
} catch (Exception e) {
    // trata outras exceções
} finally {
    // código que será executado independentemente de uma exceção ocorrer ou não
}
```

### Cláusula Finally

- As instruções `try-catch` podem opcionalmente incluir uma cláusula `finally` que será executada independentemente de uma exceção ter sido lançada ou não.
- As cláusulas `finally` são opcionais, mas se presentes, sempre serão executadas, não importa se uma exceção foi capturada ou não.
- Isso é útil para incluir código que deve ser executado sempre, independentemente da ocorrência de exceções, como liberar recursos, fechar arquivos ou conexões de rede.

> **Nota:** Tenha cuidado! Uma cláusula `finally` em um bloco `try-catch` não funciona como um padrão (default) em uma instrução `switch`. A cláusula `finally` sempre será executada, independentemente de um erro ter sido causado ou não.

**Exemplo:**

```java
try {
    // Código que pode lançar uma exceção
} catch (Exception e) {
    // Tratamento da exceção
} finally {
    // Código que sempre será executado
}
```

### Recursos Auto-Closeable (AutoCloseable Resources)

- Há uma instrução "try-with-resources" que fechará automaticamente os recursos quando o bloco `try` for concluído, seja por término normal ou por uma exceção.
- A instrução `try-with-resources` é uma instrução `try` que declara um ou mais recursos.
- Um recurso é um objeto que deve ser fechado após o programa terminar de usá-lo.
- A instrução `try-with-resources` garante que cada recurso seja fechado no final da instrução, evitando vazamentos de recursos.

> **Nota:** Qualquer objeto que implemente `java.lang.AutoCloseable`, que inclui todos os objetos que implementam `java.io.Closeable`, pode ser usado como um recurso.

**Exemplo:**

```java
try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
    // Leitura do arquivo
} catch (IOException e) {
    e.printStackTrace();
}
// O recurso BufferedReader será fechado automaticamente ao final do bloco try
```

### Declaração Multi-Catch

- Existe uma declaração multi-catch que permite capturar vários tipos de exceção na mesma cláusula `catch`.
- Cada tipo de exceção deve ser separado por uma barra vertical (or) (`|`).

**Exemplo:**

```java
try {
    // Código que pode lançar diferentes exceções
} catch (IOException | SQLException e) {
    // Tratamento comum para IOException e SQLException
    e.printStackTrace();
}
```

> **Nota:** Na declaração multi-catch, a variável de exceção (`e` no exemplo acima) é final, o que significa que não pode ser modificada dentro do bloco `catch`.

### Declarando Exceções

- Outra maneira de lidar com uma exceção é declarar que um método pode lançar uma exceção.
- Os métodos podem ser declarados para lançar exceções se contiverem instruções `try` que não possam garantir que sejam sempre executadas corretamente.
  - A instrução `try` irá dentro do corpo do método.
  - Se ocorrer uma falha na execução, o método lançará a exceção declarada.

**Exemplo:**

```java
public void meuMetodo() throws IOException {
    try {
        // código que pode lançar uma IOException
    } catch (IOException e) {
        // opcionalmente, tratar a exceção aqui ou simplesmente lançar
        throw e; // relança a exceção para ser tratada pelo chamador
    }
}

//----------------------- OU ----------

public static int readByteFromFile() throws IOException {
    try (InputStream in = new FileInputStream("a.txt")) {
        System.out.println("File open");
        return in.read();
    }//endtry
}//end method readByteFromFile

```

### Manipulando Exceções Declaradas

- As exceções declaradas pelo método ainda devem ser manipuladas, seja dentro da declaração do método ou no local onde o método foi chamado.
- Se a exceção não for tratada dentro do método, ela deve ser tratada pelo chamador do método.

**Exemplo de Manipulação de Exceção pelo Chamador:**

```java
public void outroMetodo() {
    try {
        meuMetodo(); // chama o método que pode lançar IOException
    } catch (IOException e) {
        // tratamento da exceção
        e.printStackTrace();
    }
}
```

### Criando Exceções Personalizadas

- Se você achar que nenhuma exceção existente descreve adequadamente a situação de erro, você pode criar sua própria exceção personalizada.
- Exceções personalizadas são criadas estendendo a classe `Exception` ou uma de suas subclasses.

### Chamando exceções personalizadas

- Uma exceção personalizada é chamada de dentro de um bloco catch de instruções Exception existente.

- Para trabalhar com sua própria exceção personalizada, você deve criar um novo objeto dessa classe de exceção como parte de uma instrução throw.

- Uma instrução throw passa o erro de volta para a instrução calling.

- Uma instrução throws deve ser adicionada ao final da assinatura do método identificando o tipo de Exception que será retornado.

**Exemplo de Exceção Personalizada:**

```java
public class MinhaExcecaoPersonalizada extends Exception {
    public MinhaExcecaoPersonalizada(String mensagem) {
        super(mensagem);
    }
}

// Usando a exceção personalizada
public void metodoComExcecaoPersonalizada() throws MinhaExcecaoPersonalizada {
    // lógica do método
    if (algumaCondicao) {
        throw new MinhaExcecaoPersonalizada("Mensagem de erro personalizada");
    }
}
```

**Exemplo de Manipulação da Exceção Personalizada:**

```java
public void chamarMetodoComExcecaoPersonalizada() {
    try {
        metodoComExcecaoPersonalizada(); // chama o método que lança a exceção personalizada
    } catch (MinhaExcecaoPersonalizada e) {
        // tratamento da exceção personalizada
        e.printStackTrace();
    }
}
```

### Assertions

- Asserções são uma forma de teste que permite verificar se há suposições corretas em todo o seu código.
  - Por exemplo, se você assumir que seu método não calculará um valor negativo, poderá usar uma asserção para verificar essa suposição.
- Uma instrução `assert` é usada para declarar uma condição booleana esperada em um programa.
- Se o programa estiver sendo executado com asserções habilitadas, a condição é verificada em tempo de execução.

> **Nota:** As asserções permitem que os desenvolvedores testem a funcionalidade de seu código. Elas podem ser muito úteis na depuração.

- As asserções podem ser usadas para verificar a lógica interna de um único método:
  - **Invariantes internas:**
    - Permitem que você verifique se seu código lida com valores corretamente.
  - **Invariantes de fluxo de controle:**
    - Permitem que você verifique se algo em seu código que deveria ter sido executado realmente foi.
  - **Invariantes de classe:**
    - Especificam relações entre vários atributos e devem ser verdadeiras antes e depois de qualquer método ser concluído.

### Desabilitando Asserções em Tempo de Execução

- As asserções podem ser facilmente desabilitadas em tempo de execução, permitindo que você desative todos os recursos de teste ao executar o código em produção.
- Portanto:
  - Não use asserções para verificar parâmetros de métodos públicos.
  - Não use métodos que possam causar efeitos colaterais em uma verificação de asserção.

> **Nota:** As asserções geralmente não são usadas no código de produção pelos motivos mencionados acima. Elas também podem desacelerar o programa em tempo de execução. A maioria dos IDEs tem asserções desabilitadas por padrão.

### Sintaxe de Asserção

- Há duas formas de declarações de asserção:
  - Se a `<boolean_expression>` avalia como falsa, então um `AssertionError` é lançado.
  - Um segundo argumento é opcional, mas pode ser declarado e será convertido em uma cadeia de caracteres para servir como uma descrição para a mensagem `AssertionError` exibida.

```java
assert <boolean_expression>;
assert <boolean_expression> : <detail_expression>;
```

### Exemplo de Uso de Asserção

```java
public void metodoExemplo(int x) {
    assert x > 0 : "x deve ser positivo"; // Verifica se x é positivo
    // resto do código
}
```

### Invariantes Internos

- **Invariantes internos** estão testando valores e avaliações em seus métodos.
- Devem testar valores de variáveis depois de terem sido atualizados ou avaliados.
- São usados para verificar se valores internos estão definidos ou atualizados corretamente.

**Exemplo:**

```java
public void exemploInvariantesInternos(int x) {
    if (x > 0) {
        // fazer algo
    } else {
        assert x == 0 : "x deve ser zero"; // Verifica se x é zero
        // e se x for negativo?
    }
}
```

---

## Exemplo de Invariantes Internas

- **Você sempre pode escrever código adicional para alertar se o número for muito grande para a conversão.**
- **Você pode usar uma série de instruções de saída para exibir todos os valores no console.**
- **Essas soluções devem ser removidas antes de empacotar seu aplicativo.**
- **Qualquer código de teste esquecido levará a uma saída incorreta para o usuário quando o software for lançado.**
- **Asserções são mais fáceis de usar!**

---

## Invariantes de Fluxo de Controle

- Invariantes de fluxo de controle são afirmações que podem ser feitas dentro de instruções de controle de fluxo.
- Eles permitem verificar se o código que deveria ter sido executado foi realmente executado.
- Também permitem avaliar o que acontece se valores inesperados forem processados pelo seu código.

### Exemplo de Invariantes de Fluxo de Controle

```java
public class CardGame {
    public static void main(String[] args) {
        String suit = "Card";  // Suponha que "Card" seja um valor não esperado
        switch (suit) {
            case "Clubs":
                System.out.println("Clubs");
                break;
            case "Diamonds":
                System.out.println("Diamonds");
                break;
            case "Hearts":
                System.out.println("Hearts");
                break;
            case "Spades":
                System.out.println("Spades");
                break;
            default:
                assert false : "Naipe desconhecido";  // Afirmação para casos inesperados
                break;
        }
    }
}
```

**Explicação:**

- Este código espera que o valor de `suit` seja um dos quatro naipes de cartas ("Clubs", "Diamonds", "Hearts", "Spades").
- Caso contrário, uma asserção falhará com a mensagem "Naipe desconhecido".
- Asserções são usadas aqui para garantir que apenas valores válidos sejam processados. Se o valor for inválido, o programa irá parar em ambientes de desenvolvimento, ajudando a identificar problemas antes do lançamento.

---

## Terminologia

- Termos-chave usados nesta lição incluem:
  - **Assertions**: Afirmações que verificam condições durante a execução do programa.
  - **Auto-closeable statements**: Declarações que podem ser fechadas automaticamente, como `try-with-resources`.
  - **Class/Internal Invariant**: Condições que devem sempre ser verdadeiras dentro de uma classe.
  - **Control Flow Invariant**: Afirmações feitas dentro de instruções de controle de fluxo.
  - **Exceptions**: Mecanismo para lidar com erros.
    - **Try-catch statement**: Bloco usado para capturar e tratar exceções.
    - **Multi-Catch**: Captura de várias exceções no mesmo bloco `catch`.
    - **Finally clause**: Bloco que sempre é executado após `try-catch`, independentemente de uma exceção ter sido lançada ou não.

---

> **LEITURA RECOMENDADA SOBRE ASSERTIONS:** <https://pt.stackoverflow.com/questions/166719/qual-%c3%a9-a-finalidade-da-fun%c3%a7%c3%a3o-assert-e-quando-devemos-utiliz%c3%a1-la>
