# Oracle Academy - Programação Java

## Design de Classe Java - Interfaces

### Visão geral

- Esta lição cobre os seguintes tópicos:
  - Modelar problemas de negócios usando classes Java
  - Torne as classes imutáveis
  - Usar interfaces

### Classes

- Uma classe Java é um modelo que define os recursos de um objeto
- Uma classe pode ser pensada como uma categoria usada para definir grupos de coisas
- Nas Classes:
  - Declaramos campos/variáveis
  - Definimos e implementamos métodos
  - Implementar métodos a partir de interfaces implementadas

```java
classe pública Cachorro {
    // declarações de campo de instância
    nome da string privada;
    raça String privada;
    private String latidoNoise = "Woof";
    peso duplo privado;
} // fim da classe Cachorro
```

### Objetos

- Um objeto é uma instância de uma classe
- Um programa pode ter muitos objetos
- Um objeto armazena dados nos campos para fornecer estado
- Este estado irá diferenciá-lo de outros objetos da mesma classe

```java
public Dog(Nome da string, Raça da string, Ruído da string, peso duplo, Cor da string) {
    super(raça, cor);
    este.nome = nome;
    latidoNoise = ruído;
    este.peso = peso;
} // fim do método construtor
```

### O que as classes podem e não podem fazer

- As classes podem ser instanciadas por:
  - Um construtor público ou protegido
  - Um método estático público ou protegido ou classe aninhada
- As aulas não podem:
  - Substituir métodos herdados quando o método for final

### Objetos Imutáveis

- Objetos imutáveis ​​têm uma série de vantagens em determinadas circunstâncias:
  - Por serem imutáveis, seu estado não pode ser alterado, garantindo consistência
  - Tornar uma classe final não a torna imutável por si só, mas impede que ela seja subclassificada e seus métodos sejam substituídos
  - Eliminar quaisquer métodos que alterem variáveis ​​de instância seria necessário para tornar um objeto verdadeiramente imutável

### Quando as classes podem ser subclassificadas ou tornadas imutáveis

- Uma classe pode ser subclassificada quando:
  - A classe não é declarada final
  - Os métodos são públicos ou protegidos
- Estratégia para tornar uma classe imutável:
  - Faça-a final
  - Limite a instanciação aos construtores de classe
  - Elimine quaisquer métodos que alterem campos de instância
  - Torne todos os campos finais e privados

### Imutável usando Final

- Declarar uma classe como final significa que ela não pode ser estendida
- Exemplo: você pode ter uma classe que possui um método para permitir que os usuários façam login usando alguma chamada segura
  - Você não gostaria que alguém a estendesse posteriormente e removesse a segurança

```java
public final class ImmutableClass {
    public static boolean logOn(String username, String password) {
        // chama o método booleano privado
        return someSecureAuthentication(username, password);
    } // fim do método logOn
} // fim da classe ImmutableClass
```

### Imutável limitando a instanciação ao construtor de classe

- Ao remover qualquer método que altere os campos de instância e limitar sua configuração ao construtor, os campos da classe se tornarão automaticamente imutáveis
- Exemplo: Quando uma instância do ImmutableClass é criada, o campo immutableInt não pode ser alterado

```java
public final class ImmutableClass {
    private final int immutableInt;

    public ImmutableClass(int mutableIntIn) {
        immutableInt = mutableIntIn;
    } // fim do método construtor

    private int getImmutableInt() {
        return immutableInt;
    } // fim do método getImmutableInt
} // fim da classe ImmutableClass
```

### Interface

- Uma interface é uma construção Java que ajuda a definir as funções que um objeto deve assumir.
- Você cria uma interface usando a palavra-chave `interface` em vez da palavra-chave `class`.
- Uma interface se parece com uma classe com métodos abstratos (sem código de implementação para o método), mas não é possível criar uma instância dela.
- Uma interface não tem um método construtor.

- É implementada por uma classe (usando a palavra-chave `implements`) ou estendida por outra interface.
- Interfaces definem coleções de métodos relacionados sem providenciar a implementação.
- Todos os métodos em uma interface Java são implicitamente abstratos e públicos.

- Classes implementam Interfaces.
- Interfaces herdam Interfaces.

> Nota: `Implements` é uma palavra-chave em Java que é usada quando uma classe implementa uma interface.

### Por que usar interfaces

- Ao implementar uma classe a partir de uma interface, forçamos a classe a implementar todos os métodos abstratos definidos na interface.
- A interface força a separação do que uma classe pode fazer de como ela realmente faz isso.
- Um programador pode mudar a forma como algo é feito em qualquer ponto, sem alterar a função da classe.
- Isso facilita o polimorfismo, pois os métodos descritos na interface serão implementados por todas as classes que implementam a interface.

> Nota: A partir do Java 8, você pode adicionar métodos padrão (`default methods`) que não precisam ser implementados por classes que implementam a interface.

### O que uma interface pode fazer

Uma interface:

- Pode declarar constantes públicas (todas as variáveis em uma interface são implicitamente `public`, `static` e `final`).
- Pode definir métodos sem implementação.
- Pode apenas se referir às suas constantes e métodos definidos.
- Pode ser usada com o operador `instanceof`.

Os pontos acima são essenciais para ajudar você a entender o que uma interface pode oferecer. O operador `instanceof` compara um objeto a um tipo específico.

### Ajustes adicionais

- **Métodos Estáticos em Interfaces**: Desde o Java 8, as interfaces também podem definir métodos estáticos. Esses métodos não são herdados pelas classes que implementam a interface.
- **Métodos Privados em Interfaces**: A partir do Java 9, interfaces podem ter métodos privados para ajudar a compartilhar código entre métodos padrão e métodos estáticos dentro da interface.

O que uma interface pode fazer

- Embora uma classe só possa herdar de uma única superclasse

```java
public class ClassName extends Superclass {
//class implementation
}//end class ClassName
```

- Uma classe pode implementar de uma interface

```java
public class ClassName implements InterfaceName {
//class implementation
}//end class ClassName
```

- Uma classe pode implementar de mais de uma interface

```java
public class ClassName implements InterfaceName, InterfaceName2 {
//class implementation
}//end class ClassName
```

### Método de interface

Um método de interface:

- Cada método é público mesmo quando você esquece de declará-lo como público

```java
void getName();
//is equivalent to 

public void getName();
//in an interface.
```

- É implicitamente abstrato, mas você também pode usar a palavra-chave abstract

### Por que usar interfaces? Um exemplo de banco

- **Esclarecendo responsabilidades de classe**: Você pode se perguntar por que criaria uma classe sem implementação. No exemplo do banco, uma interface como `InterfaceBankAccount` garante que todas as classes de implementação tenham métodos para deposit, withdraw, getBalance e getBankName.
- **Herança múltipla por meio de interfaces**: As classes podem ter apenas uma superclasse, mas podem implementar várias interfaces, oferecendo flexibilidade no design.
- **Consistência entre hierarquias de classe**: Se uma superclasse implementa uma interface, todas as suas subclasses terão que implementar os métodos definidos na interface, garantindo consistência em todos os níveis da hierarquia.

### Um exemplo de loja

- **Criando uma estrutura consistente**: O dono de uma loja quer criar um site exibindo todos os itens da loja. Cada item tem um nome, preço e departamento. Ao criar uma interface `Item`, o dono da loja garante que todos os itens terão essas propriedades, agindo como modelos para todos os itens da loja.

### Adicionando um novo item à loja

- **Exemplo de adição de um cookie**: Suponha que o dono da loja adicione um novo item, um cookie, que custa entre 1 e 3 dólares americanos e é encontrado no departamento de padaria. Cada cookie é identificado por um tipo. O dono pode criar uma classe `Cookie` que implementa a interface `Item`, garantindo que ela tenha as propriedades e métodos necessários ao adicionar detalhes específicos do cookie.

### Interface do item

- **Definindo a interface do item**: Ao definir uma interface `Item`, garantimos que qualquer classe ou interface que implemente `Item` deve implementar seus métodos.

```java
public interface Item {
String getItemName();
double getPrice();
void setPrice(double price);
String getDepartment();
}
```

> **Observação**: a palavra-chave `public` pode ser omitida para métodos de interface, pois eles são implicitamente públicos.

### Criando a Classe Cookie

- **Implementando a Interface Item**: O dono da loja pode criar uma classe `Cookie` que implementa a interface `Item`, adicionando métodos e campos específicos para cookies.

```java
public class Cookie implements Item {
public String cookieType;
private double price;

public Cookie(String type, double price) {
cookieType = type;
this.price = price;
}

@Override
public String getItemName() {
return "Cookie";
}

@Override
public double getPrice() {
return price;
}

@Override
public void setPrice(double price) {
this.price = price;
}

@Override
public String getDepartment() {
return "Bakery";
}

public String getType() {
return cookieType;
}
}
```

### Cookie Shop Example Task

a) Create a bakery project
b) Create the Item interface as shown in the slide
c) Create the Cookie class that implements the Item
interface as shown in the slide. Add the getType()
method as well as the methods defined in the
interface
d) Create a driver class called BakeryDriver that will
create multiple Cookie objects and test the Cookie
methods by displaying values to the console

```java
public class BakeryDriver {
  public static void main(String[] args) {
    Cookie cookie = new Cookie("Choc Chip", 1);
    System.out.println(cookie.getDepartment());
    System.out.println(cookie.getItemName());
    System.out.println(cookie.getType());
    System.out.println(cookie.getPrice());
    cookie.setPrice(1.5);
    System.out.println(cookie.getPrice());  
  }//end method main
}//end class BakeryDriver
```

### Resumo

Usar interfaces garante que certos métodos e propriedades sejam consistentemente implementados em diferentes classes. No exemplo do banco, ele padroniza as operações de várias contas bancárias. No exemplo da loja, ele padroniza propriedades de itens como nome, preço e departamento, garantindo consistência e flexibilidade em como os itens são manipulados e exibidos.

## Terminology

• Key terms used in this lesson included:
−Class
−Object
−Immutable
−Interface
−implements

### Summary

•In this lesson, you should have learned how to:
−Model business problems using Java classes
−Make classes immutable
−Use Interfaces
