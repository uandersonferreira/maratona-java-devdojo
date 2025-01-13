# Enumerações em Java

## Conceitos Básicos

- **Enumerações** são tipos especiais de classe usados para representar um conjunto fixo de constantes. 
- Cada constante dentro de uma enum é uma instância da própria enumeração.
- **Exemplo de uso:** dias da semana, meses do ano, tipos de cliente, formas de pagamento, etc.

```java
public enum TipoCliente {
    PESSOA_FISICA,
    PESSOA_JURIDICA
}
```

## Características e Boas Práticas

1. **Definição de Constantes**:
   - As constantes criadas em uma enum são, por padrão, `static` e `final`.
   - O tipo de uma constante será sempre o tipo da enumeração:
     ```java
     TipoCliente.PESSOA_FISICA; // Constante do tipo TipoCliente
     ```

2. **Modificação com Parâmetros**:
   - As constantes podem ser associadas a valores através de construtores.
   - O construtor da enum é privado e só pode ser usado dentro da própria enum.

   ```java
   public enum TipoCliente {
       PESSOA_FISICA(1, "Pessoa Física"),
       PESSOA_JURIDICA(2, "Pessoa Jurídica");

       private final int valor;
       private final String nomeRelatorio;

       TipoCliente(int valor, String nomeRelatorio) {
           this.valor = valor;
           this.nomeRelatorio = nomeRelatorio;
       }

       public int getValor() {
           return valor;
       }

       public String getNomeRelatorio() {
           return nomeRelatorio;
       }
   }
   ```

3. **Métodos e Sobrescrita em Enumerações**:
   - Podemos criar métodos dentro de enums para adicionar comportamentos específicos.
   - Métodos abstratos podem ser sobrescritos em constantes individuais.

   ```java
   public enum TipoPagamento {
       DEBITO {
           @Override
           public double calcularDesconto(double valor) {
               return valor * 0.1;
           }
       },
       CREDITO {
           @Override
           public double calcularDesconto(double valor) {
               return valor * 0.05;
           }
       };

       public abstract double calcularDesconto(double valor);
   }
   ```

4. **Busca de Constantes**:
   - O método `valueOf` permite buscar uma constante pelo nome.
   - Para buscas baseadas em valores personalizados, é necessário implementar métodos específicos.

   ```java
   TipoCliente tipo = TipoCliente.valueOf("PESSOA_FISICA");
   System.out.println(tipo.getNomeRelatorio());

   TipoCliente tipoPorNome = TipoCliente.tipoClientePorNomeRelatorio("Pessoa Física");
   System.out.println(tipoPorNome);
   ```

## Vantagens do Uso de Enumerações

- Evitam inconsistências de dados ao limitar os valores possíveis para um conjunto predefinido.
- Facilitam a manutenção do código, centralizando valores em um único local.
- Suportam comportamentos e métodos personalizados, aumentando a flexibilidade.

## Casos de Uso

- Dias da semana, meses do ano, estados de um sistema.
- Tipos de clientes (pessoa física, pessoa jurídica).
- Formas de pagamento (crédito, débito).

## Exemplo Completo

```java
public class Cliente {
    private String nome;
    private TipoCliente tipoCliente;
    private TipoPagamento tipoPagamento;

    public Cliente(String nome, TipoCliente tipoCliente, TipoPagamento tipoPagamento) {
        this.nome = nome;
        this.tipoCliente = tipoCliente;
        this.tipoPagamento = tipoPagamento;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", tipoCliente=" + tipoCliente.getNomeRelatorio() +
                ", tipoPagamento=" + tipoPagamento +
                '}';
    }
}

public enum TipoCliente {
    PESSOA_FISICA(1, "Pessoa Física"),
    PESSOA_JURIDICA(2, "Pessoa Jurídica");

    private final int valor;
    private final String nomeRelatorio;

    TipoCliente(int valor, String nomeRelatorio) {
        this.valor = valor;
        this.nomeRelatorio = nomeRelatorio;
    }

    public int getValor() {
        return valor;
    }

    public String getNomeRelatorio() {
        return nomeRelatorio;
    }

    public static TipoCliente tipoClientePorNomeRelatorio(String nomeRelatorio) {
        for (TipoCliente tipo : values()) {
            if (tipo.getNomeRelatorio().equals(nomeRelatorio)) {
                return tipo;
            }
        }
        return null;
    }
}

public enum TipoPagamento {
    DEBITO {
        @Override
        public double calcularDesconto(double valor) {
            return valor * 0.1;
        }
    },
    CREDITO {
        @Override
        public double calcularDesconto(double valor) {
            return valor * 0.05;
        }
    };

    public abstract double calcularDesconto(double valor);
}

public class ClienteTest01 {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Uanderson", TipoCliente.PESSOA_FISICA, TipoPagamento.DEBITO);
        Cliente cliente2 = new Cliente("Oliver", TipoCliente.PESSOA_JURIDICA, TipoPagamento.CREDITO);

        System.out.println(cliente1);
        System.out.println(cliente2);

        System.out.println(TipoPagamento.DEBITO.calcularDesconto(100));
        System.out.println(TipoPagamento.CREDITO.calcularDesconto(100));

        TipoCliente tipo = TipoCliente.valueOf("PESSOA_FISICA");
        System.out.println(tipo.getNomeRelatorio());

        TipoCliente tipoPorNome = TipoCliente.tipoClientePorNomeRelatorio("Pessoa Física");
        System.out.println(tipoPorNome);
    }
}
```

---

