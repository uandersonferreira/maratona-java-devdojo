# Listas Encadeadas

### **O Que é uma Lista Encadeada?**

Imagine uma lista de compras. Em vez de anotar tudo em um bloco contínuo de papel (como você faria com um array), você decide escrever cada item em um post-it separado e colar esses post-its em sequência na geladeira. Cada post-it tem o nome de um item, mas também um "link" para o próximo post-it (como uma seta desenhada apontando para o próximo). Esse é o princípio básico de uma **lista encadeada**.

No Java, temos a implementação de uma lista encadeada através da classe `LinkedList`. A diferença de uma lista encadeada para um array é que, em vez de os elementos estarem em blocos de memória contínuos, cada elemento da lista (nó) mantém uma referência para o próximo.

Veja uma ilustração de uma **lista encadeada simples**:

```bash
minhaListaEncadeada:
[ REFERENCIA DE ENTRADA ] --> [nó1 | ref.nó2] --> [nó2 | ref.nó3] --> [nó3 | null]


                                BASE                      TOPO
                                 ↓                         ↓
[REFERENCIA DE ENTRADA] -->   nó[0] -> nó[1] -> nó[2] -> nó[3] -> null

```

Cada "nó" da lista contém dois componentes:

1. O **valor** que queremos armazenar.
2. A **referência** para o próximo nó (ou seja, o endereço de onde está o próximo valor).

Se você pensar em termos práticos, uma lista encadeada funciona como uma corrente, onde cada elo (nó) se liga ao próximo até o fim da lista.

---

Estrutura da Lista Encadeada

```bash
                                     0             1             2              
REFERENCIA DE ENTRADA(ref.nó) -->  n1|ref.nó --> n2|ref.nó --> n3|ref.nó --> null 
```

Métodos:  .add(), .remove(), isEmpty(), get(indice);

Vamos tornar o exemplo mais claro, usando **valores inteiros** e marcando os índices dos nós. Assim, fica mais fácil visualizar a posição dos elementos e o que está acontecendo em cada operação. Vamos usar a estrutura de lista encadeada como referência:

```
REFERENCIA DE ENTRADA(ref.nó) --> n1|ref.nó --> n2|ref.nó --> n3|ref.nó --> null
```

Aqui, "n1", "n2" e "n3" são nós, e a "REFERENCIA DE ENTRADA" aponta para o primeiro nó. Cada nó contém um valor e uma referência para o próximo nó na lista.

### **Valores Inteiros para os Nós:**

Vamos trabalhar com valores inteiros em vez de strings. A lista vai armazenar números como 10, 20, 30, e assim por diante.

---

### **1. Adicionar Elementos (`.add()`)**

O método `.add()` insere um novo nó no final da lista. O novo nó será anexado após o último nó.

#### Exemplo

```java
minhaLista.add(40);
```

### **Visualização (Com Índices):**

Antes de adicionar:

```bash
ÍNDICES:                 0         1         2
REFERENCIA DE ENTRADA --> 10|ref --> 20|ref --> 30|ref --> null
```

Depois de adicionar `40`:

```bash
ÍNDICES:                 0         1         2         3
REFERENCIA DE ENTRADA --> 10|ref --> 20|ref --> 30|ref --> 40|ref --> null

```

**Explicação:** O novo valor `40` é adicionado como o último elemento, após o valor `30` (índice 2). A referência de `30` (índice 2) que antes apontava para `null` agora aponta para `40`, e o nó `40` aponta para `null`, indicando o final da lista.

---

### **2. Remover Elementos (`.remove()`)**

O método `.remove()` remove um nó da lista. Pode ser o primeiro, o último, ou qualquer nó em uma posição específica.

#### Exemplo

```java
minhaLista.remove(20);  // Remove o valor 20
```

### **Visualização (Com Índices):**

Antes de remover `20`:

```bash
ÍNDICES:                 0         1         2         3
REFERENCIA DE ENTRADA --> 10|ref --> 20|ref --> 30|ref --> 40|ref --> null
```

Depois de remover `20`:

```bash
ÍNDICES:                 0         1         2
REFERENCIA DE ENTRADA --> 10|ref --> 30|ref --> 40|ref --> null
```

**Explicação:** Ao remover o nó que contém o valor `20` (índice 1), a referência do nó `10` (índice 0) que antes apontava para `20` é atualizada para pular esse nó e apontar para o nó `30` (índice 1, após a remoção). O nó `20` é desconectado da lista, e seu valor é removido.

---

### **3. Verificar se a Lista está Vazia (`isEmpty()`)**

O método `isEmpty()` verifica se a lista está vazia.

#### Exemplo

```java
if (minhaLista.isEmpty()) {
    System.out.println("A lista está vazia.");
} else {
    System.out.println("A lista contém elementos.");
}
```

### **Visualização (Com Índices):**

- **Lista vazia**:

```
REFERENCIA DE ENTRADA --> null
```

- **Lista não vazia** (com elementos):

```
ÍNDICES:                 0         1         2
REFERENCIA DE ENTRADA --> 10|ref --> 30|ref --> 40|ref --> null
```

**Explicação:** Se a lista estiver vazia, a **REFERENCIA DE ENTRADA** estará apontando diretamente para `null`. Se houver elementos, ela apontará para o primeiro nó (como o valor `10` no índice 0), e `isEmpty()` retornará `false`.

---

### **4. Obter um Elemento por Índice (`get(indice)`)**

O método `get(indice)` retorna o valor armazenado no nó na posição fornecida.

#### Exemplo

```java
int valor = minhaLista.get(1);  // Obtém o valor no índice 1
```

### **Visualização (Com Índices):**

```
ÍNDICES:                 0         1         2
REFERENCIA DE ENTRADA --> 10|ref --> 30|ref --> 40|ref --> null
```

No exemplo acima, `minhaLista.get(1)` vai percorrer a lista e retornar o valor `30`, que está no índice 1.

**Explicação:** O método `get()` começa no índice 0 e segue as referências de cada nó até encontrar o índice solicitado. No caso de `get(1)`, ele vai até o segundo nó (índice 1) e retorna o valor `30`.

---

### **Resumo Final (Com Índices e Inteiros):**

1. **Adicionar (`.add()`)**: Adiciona um valor ao final da lista. Exemplo: Adicionamos `40` no índice 3.
2. **Remover (`.remove()`)**: Remove um valor da lista. Exemplo: Removemos `20`, e o índice de `30` mudou de 2 para 1.
3. **Verificar se está vazia (`isEmpty()`)**: Verifica se a lista tem ou não elementos. Se a lista estiver vazia, não haverá nós.
4. **Obter por índice (`get(indice)`)**: Retorna o valor de um nó com base no índice. Exemplo: `get(1)` retornou o valor `30`.

### **Ilustração da Lista Encadeada:**

```
ÍNDICES:                 0         1         2
REFERENCIA DE ENTRADA --> 10|ref --> 30|ref --> 40|ref --> null
```

Esse é o comportamento básico de uma **lista encadeada**. A lista é como uma corrente de nós, onde cada nó tem um valor e aponta para o próximo nó.
