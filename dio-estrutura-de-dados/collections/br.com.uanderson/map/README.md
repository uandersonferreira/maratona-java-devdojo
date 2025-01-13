### Tutorial: Collection Map API — Conceito, Implementações e Operações

**Autor**: Uanderson, desenvolvedor Backend Java em formação  
**Público-alvo**: Estudantes de programação

---

Olá! Eu sou Uanderson, e hoje vou explicar de maneira detalhada o conceito da Collection `Map` e suas implementações, além de abordar as operações básicas de CRUD (Create, Read, Update, Delete), ordenação com `Comparable` e `Comparator`, e pesquisa.

Se você já teve que gerenciar pares de chave e valor em uma estrutura de dados, está no lugar certo. O `Map` é perfeito para isso e muito mais. Vamos entender o motivo e como usá-lo!

---

## O que é um `Map`?

O `Map` é uma **interface** na API de Collections do Java que mapeia **chaves a valores**. Isso significa que ele armazena dados em pares, onde uma chave única aponta para um valor específico. A ideia aqui é garantir que cada chave no `Map` seja única, mas os valores podem se repetir.

### Representação Matemática

Pense no `Map` como uma função matemática:  
\[ f: X \to Y \]  
Onde `X` é o conjunto de chaves, e `Y` é o conjunto de valores. Cada elemento de `X` está associado a um único valor em `Y`. Um exemplo simples seria um dicionário, onde as palavras são as chaves e as definições são os valores.

---

## Implementações do `Map`

No Java, existem várias implementações da interface `Map`. As principais são:

1. **`HashMap`**: Usa uma tabela de hash para armazenar as entradas. É não-ordenado e permite uma inserção e pesquisa rápida, mas sem garantias de ordem.

2. **`LinkedHashMap`**: Mantém a ordem de inserção das entradas, permitindo iterações em uma ordem previsível.

3. **`TreeMap`**: Armazena as entradas em ordem crescente das chaves (ou conforme definido por um `Comparator`), implementando a interface `SortedMap`.

---

Aqui estão os métodos das operações básicas de um `Map<K, V>`:

### 1. **Inserção (Create)**

- `put(K key, V value)` — Adiciona um par chave-valor ao mapa. Se a chave já existir, o valor é atualizado.
- `putAll(Map<? extends K, ? extends V> m)` — Adiciona todas as entradas de outro mapa ao mapa atual.

### 2. **Leitura (Read)**

- `get(Object key)` — Retorna o valor associado à chave especificada ou `null` se a chave não existir.
- `containsKey(Object key)` — Verifica se o mapa contém a chave especificada.
- `containsValue(Object value)` — Verifica se o mapa contém o valor especificado.
- `entrySet()` — Retorna um conjunto (`Set`) com todas as entradas (pares chave-valor) do mapa.
- `keySet()` — Retorna um conjunto (`Set`) com todas as chaves do mapa.
- `values()` — Retorna uma coleção (`Collection`) com todos os valores do mapa.

### 3. **Atualização (Update)**

- `put(K key, V value)` — Além de adicionar, esse método também atualiza o valor se a chave já existir.

### 4. **Remoção (Delete)**

- `remove(Object key)` — Remove o par chave-valor associado à chave especificada.
- `clear()` — Remove todos os pares chave-valor do mapa.

### 5. **Tamanho e Verificação**

- `size()` — Retorna o número de pares chave-valor no mapa.
- `isEmpty()` — Verifica se o mapa está vazio (`true` se estiver vazio, caso contrário `false`).

## Operações Básicas de CRUD

Agora que já conhecemos as implementações, vamos entender as operações básicas. No `Map`, você pode **criar**, **ler**, **atualizar** e **deletar** entradas — exatamente como em um banco de dados.

### 1. **Create (Adicionar pares chave-valor)**

```java
Map<String, Integer> idadePessoas = new HashMap<>();
idadePessoas.put("João", 30);   // Chave: "João", Valor: 30
idadePessoas.put("Maria", 25);
```

Aqui estamos criando um `Map` chamado `idadePessoas`, onde associamos os nomes das pessoas a suas respectivas idades.

### 2. **Read (Ler valores associados às chaves)**

```java
int idadeJoao = idadePessoas.get("João");
System.out.println("Idade do João: " + idadeJoao);
```

Você pode acessar o valor associado a uma chave com o método `get`.

### 3. **Update (Atualizar valores existentes)**

```java
idadePessoas.put("João", 31);  // Atualiza a idade de João para 31
```

A operação `put` serve tanto para adicionar quanto para atualizar.

### 4. **Delete (Remover pares chave-valor)**

```java
idadePessoas.remove("Maria");  // Remove a entrada da chave "Maria"
```

Para remover um par chave-valor, basta usar o método `remove`.

---

## Ordenação com `Comparable` e `Comparator`

Ao trabalhar com o `TreeMap`, você pode garantir que as chaves sejam mantidas em uma ordem específica. Para isso, usamos as interfaces `Comparable` e `Comparator`.

### 1. **Comparable (Ordem Natural)**

Se as chaves de seu `TreeMap` implementam `Comparable`, elas serão ordenadas automaticamente de acordo com sua ordem natural, como números inteiros sendo classificados do menor para o maior.

```java
TreeMap<Integer, String> numeros = new TreeMap<>();
numeros.put(2, "Dois");
numeros.put(1, "Um");
numeros.put(3, "Três");

System.out.println(numeros);  // Saída: {1=Um, 2=Dois, 3=Três}
```

### 2. **Comparator (Ordem Personalizada)**

Com o `Comparator`, você pode definir sua própria regra de ordenação.

```java
TreeMap<String, Integer> treeMap = new TreeMap<>(Comparator.reverseOrder());
treeMap.put("Zebra", 10);
treeMap.put("Elefante", 20);
treeMap.put("Gato", 5);

System.out.println(treeMap);  // Saída: {Zebra=10, Gato=5, Elefante=20}
```

Aqui, usamos `Comparator.reverseOrder()` para inverter a ordem das chaves.

---

## Pesquisa em um `Map`

No `Map`, a pesquisa é eficiente, especialmente em implementações como o `HashMap`, que utiliza hashing para otimizar o acesso às chaves.

- **Verificar se uma chave existe:**

```java
if (idadePessoas.containsKey("João")) {
    System.out.println("João está no mapa.");
}
```

- **Verificar se um valor existe:**

```java
if (idadePessoas.containsValue(25)) {
    System.out.println("Alguém tem 25 anos.");
}
```

---

## Conclusão

O `Map` é uma ferramenta essencial no arsenal de qualquer desenvolvedor Java. Ele não só resolve o problema de armazenar e acessar pares de chave-valor de forma eficiente, mas também oferece poderosas ferramentas de ordenação e pesquisa. Com as diversas implementações, como `HashMap`, `TreeMap` e `LinkedHashMap`, você pode escolher a melhor para suas necessidades.

Então, lembre-se: se você precisa de um relacionamento entre uma chave e um valor, o `Map` é a estrutura certa!

---
