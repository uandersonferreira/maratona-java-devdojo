# Pilhas [LIFO: Last In, First Out]

Olá! Eu sou o Uanderson, um desenvolvedor Backend Java em formação, e hoje vou ajudar você, desenvolvedor júnior, a entender um conceito fundamental nas coleções do Java: **Pilha** ou **LIFO (Last In, First Out)**.

A ideia é simples, mas poderosa! Já parou para pensar em como uma pilha de pratos funciona? O último prato que você coloca no topo é o primeiro que você tira, certo? Esse é o comportamento básico de uma pilha: o último a entrar é o primeiro a sair. No mundo da programação, chamamos isso de **LIFO (Last In, First Out)**.

### O que é uma Pilha no Java?

Na API de Coleções do Java, a **Stack** é uma classe que implementa o conceito de pilha. Ela herda da classe **Vector** (o que significa que ela tem todos os comportamentos de uma lista dinâmica), mas oferece métodos específicos para trabalhar com o conceito de "último a entrar, primeiro a sair".

Agora, vamos dar uma olhada em como trabalhar com uma pilha no Java e explorar seus métodos.




## Pilha de nó

n4 (topo) <- REFERÊNCIA AO NO TOPO GUARDADA/CRIADA

|
v (aponta para)

no3

|
v (aponta para)

no2

|
v (aponta para)

no1 (BASE, primeiro elemento inserido )    (aponta para)  -> NULL

### Método `Top`

Recebe a referência do primeiro nó o TOPO, mas não retira ele da pilha.

```java
No meuNo = pilha.top();

No meuNo = REFERENCIA DO TOPO;

int numero = meuNo.getInt();

int numero = int;

```

### Método `Pop`

Retirar de fato o primeiro nó da pilha, no caso o TOPO, é então a referência do TOPO muda para o de baixo.

```java
No meuNo = pilha.pop();

No meuNo = REFERÊNCIA DO TOPO;

int numero = meuNo.getInt();

int numero = int;

```

### Método `Push`

```java
No meuNo = new No();

meuNo.setInt(1);

meuNo -> Passa a ser o TOPO da pilha

- E a REFERÊNCIA DE TOPO que guardamos muda para esse novo No

meuNo (aponta para) ->  n4 (TOPO)   (aponta para) <- REFEREÊNCIA AO NO TOPO GUARDADA

                        |
                        v (aponta para)

                        no3

                        |
                        v (aponta para)

                        no2

                        |
                        v (aponta para)

                        no1 (Base, primeiro elemento inserido ) -> NULL
```

### Método `isEmpty`

- verifica se a referência para a entrada da pilha está Nula (NULL), se têm ou não elementos 
inseridos na pilha.


### Implementações e Métodos Básicos da Stack

A classe `Stack` no Java nos permite criar uma estrutura de pilha e vem com métodos super úteis para realizar operações básicas, como:

- **push(elemento)**: Empilha um elemento no topo da pilha. Imagine que você está colocando mais um prato no topo da pilha de pratos!
  
- **pop()**: Remove o elemento do topo da pilha e o retorna. Lembra dos pratos? O último prato colocado é o primeiro que você vai tirar.

- **peek()**: Apenas observa o elemento do topo da pilha sem removê-lo. Isso é como dar uma olhadinha no prato do topo da pilha, mas sem tocá-lo!

- **isEmpty()**: Verifica se a pilha está vazia. Útil quando você precisa saber se ainda há pratos na pilha antes de começar a tirar.

- **search(elemento)**: Procura por um elemento na pilha e retorna sua posição. Esse método é meio peculiar, pois a pilha é baseada na posição do topo — então o topo da pilha é 1, o próximo é 2, e assim por diante.

Agora, com esses métodos básicos, você já pode construir, manipular e interagir com uma pilha de dados no Java.

### CRUD em Pilhas

Quando falamos de CRUD, estamos nos referindo a quatro operações fundamentais em estruturas de dados: **Criar, Ler, Atualizar e Deletar**.

1. **Criar**: Para criar uma pilha, basta instanciá-la.
   ```java
   Stack<Integer> pilha = new Stack<>();
   ```

2. **Ler**: Você pode ler o elemento do topo com o método `peek()`, ou verificar o conteúdo da pilha inteira com `toString()`, por exemplo:
   ```java
   System.out.println(pilha.peek()); // Lê o elemento do topo.
   System.out.println(pilha); // Imprime toda a pilha.
   ```

3. **Atualizar**: O conceito de "atualizar" na pilha é um pouco diferente, já que não há uma maneira direta de substituir um elemento no meio. Normalmente, você removeria os elementos até chegar ao que deseja atualizar, e depois empilharia de novo.

4. **Deletar**: Isso é feito com o método `pop()`, que remove o elemento do topo.
   ```java
   pilha.pop(); // Remove o elemento do topo.
   ```

### Ordenação em Pilhas

Agora, talvez você esteja se perguntando: "Como faço para ordenar os elementos em uma pilha?" Bem, aqui vai uma verdade interessante: **pilhas não são naturalmente projetadas para ordenação**. Como elas seguem o comportamento LIFO, qualquer tipo de ordenação exige que você desempilhe os elementos, ordene-os externamente, e depois empilhe novamente.

Um jeito simples seria:
```java
Collections.sort(pilha);
```

Mas lembre-se: a ordenação em uma pilha pode não ser tão comum, pois, conceitualmente, a pilha serve para cenários onde o **LIFO** faz mais sentido.

### Pesquisa em Pilhas

Como mencionei antes, você pode usar o método `search()` para verificar se um elemento está na pilha e descobrir sua posição a partir do topo. Aqui está um exemplo:

```java
int posicao = pilha.search(3);
if (posicao != -1) {
    System.out.println("Elemento encontrado na posição: " + posicao);
} else {
    System.out.println("Elemento não encontrado.");
}
```

Lembre-se de que a pesquisa em pilhas não é a mais eficiente, já que elas não são indexadas como listas — o comportamento LIFO é a prioridade.

### Conclusão

Então, é isso! As **pilhas** são uma estrutura super útil quando você precisa de um comportamento onde o último a entrar é o primeiro a sair. No Java, a classe `Stack` oferece todas as ferramentas necessárias para você manipular essa estrutura com facilidade, seja para adicionar elementos, removê-los, ou apenas inspecionar o que está no topo.

### Métodos

.enqueue() - Enfileirar
   Novos No, são adicionados ao TOPO (Último adicionado elemento da fila) e a REFERÊNCIA DE ENTRADA DO NO passa a ser
   o novo `No` adicionado.

`3 -> 2 -> 1 -> 0 -> null` ao chama enqueue() adicionando um novo elemento/NO passa a ser `4 -> 3 -> 2 -> 1 -> 0 -> null`.

.dequeue() - dessenfileirar

Se a pilha tem  `3 -> 2 -> 1 -> 0 -> null` e você chama dequeue(), o elemento BASE (Primeiro adicionado da pilha) é removido, e a BASE passa a ser  `3 -> 2 -> 1 -> null`, e referência para `NULL`

- .isEmpty() - testar se estar vazio


