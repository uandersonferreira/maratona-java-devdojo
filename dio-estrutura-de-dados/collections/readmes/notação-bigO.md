### 1. List
**Características**:
- Mantém a ordem de inserção.
- Permite elementos duplicados.
- Permite acesso pelo índice.

**Quando usar**:
- Quando a ordem dos elementos é importante.
- Quando é necessário acessar elementos por índice.
- Quando você precisa de uma lista que permita duplicatas.

**Exemplos de uso**:
- Armazenar itens em um carrinho de compras de um e-commerce.
- Manter uma lista de tarefas ordenadas pela ordem de adição.
- Implementar uma fila de espera em que a ordem de chegada importa.

**Complexidade de Tempo (Big-O)**:
- Inserção (final): `O(1)` para `ArrayList`, `O(1)` para `LinkedList`.
- Inserção (meio): `O(n)` para `ArrayList`, `O(1)` para `LinkedList`.
- Acesso: `O(1)` para `ArrayList`, `O(n)` para `LinkedList`.
- Remoção (final): `O(1)` para `ArrayList`, `O(1)` para `LinkedList`.
- Remoção (meio): `O(n)` para `ArrayList`, `O(1)` para `LinkedList`.

```java
List<String> shoppingCart = new ArrayList<>();
shoppingCart.add("Laptop");
shoppingCart.add("Mouse");
shoppingCart.add("Keyboard");
```

### 2. Set
**Características**:
- Não permite elementos duplicados.
- Não garante a ordem de inserção (exceto `LinkedHashSet` e `TreeSet`).

**Quando usar**:
- Quando a unicidade dos elementos é importante.
- Quando não é necessária a ordenação dos elementos (ou quando se usa `TreeSet` para uma coleção ordenada).

**Exemplos de uso**:
- Armazenar os nomes de usuários em um sistema, garantindo que não haja duplicatas.
- Implementar uma lista de permissões sem repetição.

**Complexidade de Tempo (Big-O)**:
- Inserção: `O(1)` para `HashSet`, `O(log n)` para `TreeSet`.
- Acesso: `O(1)` para `HashSet`, `O(log n)` para `TreeSet`.
- Remoção: `O(1)` para `HashSet`, `O(log n)` para `TreeSet`.

```java
Set<String> userNames = new HashSet<>();
userNames.add("Alice");
userNames.add("Bob");
userNames.add("Charlie");
```

### 3. Map
**Características**:
- Armazena pares chave-valor.
- Não permite chaves duplicadas, mas valores duplicados são permitidos.
- As chaves não têm ordem específica (exceto `LinkedHashMap` e `TreeMap`).

**Quando usar**:
- Quando é necessário associar chaves a valores.
- Quando é necessário um acesso rápido a valores através de chaves.

**Exemplos de uso**:
- Armazenar informações de configuração, onde a chave é o nome da configuração e o valor é o valor correspondente.
- Implementar um cache, onde a chave é o ID do objeto e o valor é o objeto em si.

**Complexidade de Tempo (Big-O)**:
- Inserção: `O(1)` para `HashMap`, `O(log n)` para `TreeMap`.
- Acesso: `O(1)` para `HashMap`, `O(log n)` para `TreeMap`.
- Remoção: `O(1)` para `HashMap`, `O(log n)` para `TreeMap`.

```java
Map<String, String> config = new HashMap<>();
config.put("url", "http://example.com");
config.put("timeout", "5000");
```

### 4. Queue
**Características**:
- Representa uma coleção que opera em uma base de FIFO (First-In-First-Out).
- Ideal para situações onde o processamento deve ocorrer na ordem de inserção.

**Quando usar**:
- Quando você precisa de uma estrutura de dados que opere em FIFO.
- Para implementações de fila, como em sistemas de processamento de tarefas ou mensagens.

**Exemplos de uso**:
- Implementar uma fila de tarefas em um sistema de processamento de pedidos.
- Gerenciar filas de impressão em um sistema de gerenciamento de impressoras.

**Complexidade de Tempo (Big-O)**:
- Inserção: `O(1)` para `LinkedList`, `O(log n)` para `PriorityQueue`.
- Acesso (peek): `O(1)` para `LinkedList`, `O(log n)` para `PriorityQueue`.
- Remoção (poll): `O(1)` para `LinkedList`, `O(log n)` para `PriorityQueue`.

```java
Queue<String> tasks = new LinkedList<>();
tasks.add("task1");
tasks.add("task2");
tasks.add("task3");
```

### Tabela Comparativa

| Estrutura | Características | Inserção | Acesso | Remoção | Melhor Uso |
|-----------|----------------|----------|--------|---------|------------|
| **List**  | Ordenada, Duplicatas permitidas | O(1) / O(n) | O(1) / O(n) | O(1) / O(n) | Manter ordem e permitir duplicatas |
| **Set**   | Não ordenada (exceto `TreeSet`), Única | O(1) / O(log n) | O(1) / O(log n) | O(1) / O(log n) | Garantir unicidade de elementos |
| **Map**   | Pares chave-valor, Única chave | O(1) / O(log n) | O(1) / O(log n) | O(1) / O(log n) | Associação de chave-valor |
| **Queue** | FIFO | O(1) / O(log n) | O(1) / O(log n) | O(1) / O(log n) | Processamento em ordem |

**Notas**:
- `O(1)` e `O(n)` representam complexidades para `ArrayList` e `LinkedList`, respectivamente.
- A complexidade pode variar dependendo da implementação específica da coleção.

