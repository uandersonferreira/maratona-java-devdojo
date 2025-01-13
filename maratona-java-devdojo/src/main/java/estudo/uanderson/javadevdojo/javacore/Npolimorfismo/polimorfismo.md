#### **O que é Polimorfismo?**  

Primeiro, vamos entender o termo. Polimorfismo vem do grego e significa “muitas formas”. Em Java, ele permite que objetos de diferentes classes sejam tratados de forma uniforme, desde que compartilhem a mesma interface ou herdem de uma mesma classe.  

Imagine que você tem um controle remoto universal. Esse controle pode ser usado para ligar uma TV, mudar o volume de um rádio ou até ajustar o ar-condicionado. O que ele faz depende do aparelho com o qual está interagindo, mas a interface (o controle remoto) permanece a mesma.  

---

#### **Por que o Polimorfismo é Importante?**  

Pense no seguinte: você está em um projeto real com uma equipe de desenvolvedores e precisa criar um sistema para gerenciar diferentes tipos de veículos. Sem o polimorfismo, seria como tentar construir esse sistema criando métodos separados para cada tipo de veículo. Resultado? Um código cheio de duplicações, difícil de manter e com alta chance de erros.  

O polimorfismo resolve isso com elegância. Ele permite que você crie um código mais enxuto e flexível, facilitando manutenções e adaptações futuras.  

---

#### **Como Funciona na Prática?**  

Vamos para a parte que interessa: código! Aqui está um exemplo prático de como usar o polimorfismo em Java.  

**1. Criando a Superclasse e as Subclasses**  
```java
abstract class Veiculo {
    abstract void mover(); // Método abstrato
}

class Carro extends Veiculo {
    @Override
    void mover() {
        System.out.println("O carro está andando sobre quatro rodas.");
    }
}

class Bicicleta extends Veiculo {
    @Override
    void mover() {
        System.out.println("A bicicleta está pedalando sobre duas rodas.");
    }
}
```  

Aqui, temos uma classe abstrata `Veiculo` com um método abstrato `mover()`. Cada tipo de veículo (Carro e Bicicleta) implementa o método `mover()` de maneira específica.  

**2. Usando Polimorfismo**  
```java
public class TestePolimorfismo {
    public static void main(String[] args) {
        Veiculo meuCarro = new Carro();
        Veiculo minhaBicicleta = new Bicicleta();

        meuCarro.mover();  // "O carro está andando sobre quatro rodas."
        minhaBicicleta.mover();  // "A bicicleta está pedalando sobre duas rodas."
    }
}
```  

Veja como é simples! Embora `meuCarro` e `minhaBicicleta` sejam referenciados como `Veiculo`, o método correto (`mover()`) é chamado com base no tipo real do objeto.  

---

#### **Aplicação no Mundo Real**  

Imagine que você está desenvolvendo um sistema de pagamentos. Você pode ter diferentes classes para processar pagamentos com cartão de crédito, boleto ou Pix. Com o polimorfismo, sua lógica de pagamento pode ser genérica, enquanto os detalhes específicos ficam em cada classe.  

```java
interface Pagamento {
    void processarPagamento(double valor);
}

class CartaoCredito implements Pagamento {
    @Override
    public void processarPagamento(double valor) {
        System.out.println("Pagamento de R$" + valor + " realizado com cartão de crédito.");
    }
}

class Pix implements Pagamento {
    @Override
    public void processarPagamento(double valor) {
        System.out.println("Pagamento de R$" + valor + " realizado via Pix.");
    }
}

class Boleto implements Pagamento {
    @Override
    public void processarPagamento(double valor) {
        System.out.println("Pagamento de R$" + valor + " realizado via boleto.");
    }
}

public class SistemaPagamento {
    public static void main(String[] args) {
        Pagamento pagamento = new CartaoCredito();
        pagamento.processarPagamento(100.0);

        pagamento = new Pix();
        pagamento.processarPagamento(50.0);

        pagamento = new Boleto();
        pagamento.processarPagamento(200.0);
    }
}
```  

Com isso, você pode adicionar novos métodos de pagamento sem alterar o código principal do sistema, mantendo tudo organizado e flexível.  

---

#### **Dicas de Ouro para Polimorfismo**  

1. **Use Interfaces Sempre que Possível:** Elas garantem maior flexibilidade e independência de implementação.  
2. **Evite "Overengineering":** Não use polimorfismo apenas por usar. Ele deve resolver um problema real.  
3. **Teste Suas Implementações:** Sempre verifique se os métodos específicos estão sendo chamados corretamente.  

---
## Upcasting

Vou demonstrar o conceito de Upcasting usando as classes `Produto`, `Computador` e `Tomate` dos exemplos anteriores.

### Código com exemplo de Upcasting

```java
// Superclasse
abstract class Produto {
    protected String nome;
    protected double valor;

    public Produto(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public abstract double calcularImposto();
}

// Subclasse 1
class Computador extends Produto {
    public Computador(String nome, double valor) {
        super(nome, valor);
    }

    @Override
    public double calcularImposto() {
        return this.valor * 0.2;
    }

    public void exibirDetalhes() {
        System.out.println("Computador " + this.nome + " com valor de R$ " + this.valor);
    }
}

// Subclasse 2
class Tomate extends Produto {
    public Tomate(String nome, double valor) {
        super(nome, valor);
    }

    @Override
    public double calcularImposto() {
        return this.valor * 0.1;
    }

    public void exibirDetalhes() {
        System.out.println("Tomate " + this.nome + " com valor de R$ " + this.valor);
    }
}

// Classe de Teste
public class ProdutoTest02 {
    public static void main(String[] args) {
        // Upcasting: Atribuindo objetos das subclasses a variáveis de referência da superclasse
        Produto produto1 = new Computador("Ryzen", 3000); // Upcasting
        Produto produto2 = new Tomate("Tomate Americano", 10); // Upcasting

        // Chamando métodos usando referências da superclasse
        System.out.println(produto1.getNome());
        System.out.println(produto1.getValor());
        System.out.println(produto1.calcularImposto());
        System.out.println("----------------------------");
        System.out.println(produto2.getNome());
        System.out.println(produto2.getValor());
        System.out.println(produto2.calcularImposto());

        /*
        // Como são métodos específicos das subclasses, não podemos chamá-los diretamente usando a referência da superclasse
        produto1.exibirDetalhes(); // Erro: método exibirDetalhes() não está definido na superclasse Produto
        produto2.exibirDetalhes(); // Erro: método exibirDetalhes() não está definido na superclasse Produto
        */
    }
}
```

### Explicação do código

1. **Superclasse `Produto`:** Define os atributos `nome` e `valor`, além do método abstrato `calcularImposto()`.
2. **Subclasse `Computador`:** Estende `Produto` e implementa o método `calcularImposto()`. Além disso, define um método específico `exibirDetalhes()`.
3. **Subclasse `Tomate`:** Estende `Produto` e implementa o método `calcularImposto()`. Define também um método específico `exibirDetalhes()`.

4. **Classe de Teste `ProdutoTest02`:** No método `main()`, são criadas variáveis de referência da superclasse `Produto` que apontam para objetos das subclasses `Computador` e `Tomate` (Upcasting).

### O que é Upcasting?

- **Upcasting** é quando atribuímos um objeto de uma subclasse a uma referência da superclasse.
- Nesse processo, a referência da superclasse perde acesso aos métodos e atributos específicos da subclasse.
- Apesar disso, a implementação real dos métodos sobrescritos é mantida e executada corretamente.

### Exemplo de Upcasting:

```java
Produto produto1 = new Computador("Ryzen", 3000); // Upcasting
Produto produto2 = new Tomate("Tomate Americano", 10); // Upcasting
```

### Vantagens do Upcasting

1. **Polimorfismo:** Permite tratar objetos de diferentes subclasses de forma uniforme, através de referências da superclasse.
2. **Flexibilidade:** Facilita a manutenção e expansão do código, pois você pode adicionar novas subclasses sem alterar o código que usa a superclasse.


---

## Downcasting

Para acessar os atributos e métodos específicos de `Computador` e `Tomate`, você precisa usar downcasting. Downcasting é o processo de converter uma referência de superclasse para uma referência de subclasse. No entanto, é importante garantir que o objeto seja realmente uma instância da subclasse para evitar `ClassCastException`.

Aqui está um exemplo de como você pode fazer isso:

```java
public class ProdutoTest02 {
    public static void main(String[] args) {
        Produto produto1 = new Computador("Ryzen", 3000); // Upcasting
        Produto produto2 = new Tomate("Tomate Americano", 10); // Upcasting

        // Verifica se produto1 é uma instância de Computador antes de fazer o downcasting
        if (produto1 instanceof Computador) {
            Computador computador = (Computador) produto1; // Downcasting
            // Agora você pode acessar métodos específicos de Computador
            System.out.println("Nome: " + computador.getNome());
            System.out.println("Valor: " + computador.getValor());
            System.out.println("Imposto: " + computador.calcularImposto());
            // Acesse atributos e métodos específicos de Computador aqui
        }

        // Verifica se produto2 é uma instância de Tomate antes de fazer o downcasting
        if (produto2 instanceof Tomate) {
            Tomate tomate = (Tomate) produto2; // Downcasting
            // Agora você pode acessar métodos específicos de Tomate
            System.out.println("Nome: " + tomate.getNome());
            System.out.println("Valor: " + tomate.getValor());
            System.out.println("Imposto: " + tomate.calcularImposto());
            // Acesse atributos e métodos específicos de Tomate aqui
        }
    }
}
```

### Explicações complementares:

- **Upcasting:** É quando você atribui um objeto de uma subclasse a uma referência de sua superclasse. Com isso, a referência perde acesso aos métodos e atributos que não estão definidos na classe mais genérica (a superclasse).

- **Downcasting:** É quando você converte uma referência de superclasse de volta para uma referência de subclasse. Isso permite acessar os métodos e atributos específicos da subclasse. No entanto, é necessário verificar se o objeto é realmente uma instância da subclasse usando o operador `instanceof`.

### Cuidados ao usar Downcasting:

1. **Verificação de tipo:** Sempre verifique se a referência é realmente uma instância da subclasse usando `instanceof` antes de fazer o downcasting.
2. **ClassCastException:** Se tentar fazer o downcasting sem a verificação de tipo e o objeto não for uma instância da subclasse, ocorrerá uma `ClassCastException`.

