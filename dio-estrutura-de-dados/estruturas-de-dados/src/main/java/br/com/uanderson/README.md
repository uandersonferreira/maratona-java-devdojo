# Estrutura de dados em Java

## Tipos de Memória

### Memória Primária

Não Mantêm os dados mesmo na ausência de energia (RAM)

chips da memoria RAM, possuem endereços de memória com diversos bits, regiões da memoria ram que S.O gerencia para as aplicações.

Os bits nos permitem guardar informações

bits assume os valores de 0 = quando não possuem energia (vazio) e 1 = quando possuem energia (Dado armazenado)

### Memória Secundária

Mantêm os dados mesmo na ausência de energia (HD)

## Atribuição e Referência

- As atribuições em Java são por cópia de valor sempre
- Com Tipo `PRIMITIVO`, copiamos o **valor** em `memória` (Apontam para referência diferentes)
- Com `OBJETOS` copiamos o valor da `referência em memória`, sem duplicar o objeto.
(Apontam para o mesmo endereço em memória)

int a = 1;
int b = 2;

a = b; //O valor em memória de 2 passa para a variavel `a`

a = 25; // Modificamos o valor em memória é não afeta o valor de b que continua valendo 2;

No fim:
a = 25
b = 2

---

br.com.uanderson.atribuicao_referencia.MeuObjeto objA = new br.com.uanderson.atribuicao_referencia.MeuObjeto(1);

br.com.uanderson.atribuicao_referencia.MeuObjeto objB = objA;

System.out.println("objA = " + objA + "  objB = " + objB);
  
objA.setNum(2);

System.out.println("objA = " + objA + "  objB = " + objB); //Será impresso 2 e 2 pois ambos apotam para o mesmo endereço em memória.

## Conceito de Nó e Encadeamento de nó

Um nó é um espaço em memória que armazena o dado em si ou a referência a um nó; 

- A Última referência de um Nó encadeado é setada com NULL.

### Resumindo:
- Um **nó** é um objeto que guarda dois elementos: um dado e uma referência para outro nó.
- O **encadeamento de nós** é a ligação de um nó ao próximo, criando uma cadeia.
- O último nó da cadeia tem a referência para o próximo nó definida como `null`, indicando o fim da sequência.

## Generics em Java

Contexto:

- Evitar casting excessivo
- Evitar códigos redundantes
- Encontrar erros em tempo de compilação
- Introduzido desde o Java SE 5.0

```java
Lista<String> minhaLista = new Lista<>();

public class Lista<T>{
    private T t;
}
```

### Wildcards (caracteres coringas)

- Unknown Wildcards `<?>` (Unbounded / Ilimitado o mais generico possível)

```java
public void imprimeLista(List<?> lista){
    for(Object obj : lista){
        System.out.println(obj);
    }
}
```

Aceitar qualquer objeto, já que `Object` é o pai de todos os objetos, o Ancião supremo no Java :)

- Bounded Wildcard (Upper Bounded / lower Bounded) Limita-se a um tipo de objeto

- Upper Bounded

```java
public void imprimeLista(List<? extends Pessoa> listaPessoas){
    for(Pessoa p : listaPessoas){
        System.out.println(p);
    }
}
```

Aqui o method só irá aceitar Objetos do tipo Pessoa ou filhos de pessoa, ou seja aqueles que passam 
no teste `é um` tipo Pessoa ?

- lower Bounded 

```java
public void imprimeLista(List<? super Pessoa> listaPessoas){
    for(Pessoa p : listaPessoas){
        System.out.println(p);
    }
}
```

Aqui só aceita objetos do Tipo Pessoa para cima, ou seja as suas sub-class/filhas que herdam de Pessoa
não são aceitas.

### Convenção

- `K` para "Key" (Chave), como em `Map<K, V>`.
- `V` para "Value" (Valor), também no caso do `Map<K, V>`.
- `E` para "Elemento", como em `List<E>`.
- `T` para "Tipo", como em várias Collections genéricas.
- `?` para um tipo qualquer de objeto, o que chamamos de "Curinga".

