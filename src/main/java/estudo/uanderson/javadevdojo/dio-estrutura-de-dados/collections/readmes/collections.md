
### O que é uma Collection?

Imagine que você está organizando suas playlists de músicas. Cada playlist pode conter várias músicas, algumas repetidas, outras não. Agora pense em como você quer acessar, adicionar ou remover essas músicas. Dependendo de como você organiza as playlists (por exemplo, em ordem alfabética, por data de adição, ou mesmo eliminando duplicatas), você estará usando uma **collection** diferente.

Uma **Collection (Coleção)** é uma estrutura que armazena dados/elementos de forma organizada, para que você possa trabalhar com eles mais facilmente, estes dados/elementos precisão ser Objetos (Wrappers ou Objetos de class).
O **Java Collection Framework** oferece uma série de estruturas de dados prontas para você escolher a que melhor se adapta ao seu problema.

Uma Collection pode ter coleções homogêneas(Um Objeto) e heterogêneas(mais de um Objeto), normalmente utilizamos coleções homogêneas de um tipo especifico.

Agora, vamos entender essa hierarquia e suas implementações, com foco em três grandes grupos de collections: **List**, **Set**, **Queue**, além da interface **Map**.

![ Hierarquia do Collection Framework API Java](img/collection_framework_java.png)

### Hierarquia do Collection Framework

No centro de tudo temos a interface **Collection**, que define os métodos comuns a todas as collections. Em torno dela, temos interfaces mais específicas, que dão origem às implementações que usamos no dia a dia.

Aqui está um esquema básico de como essas interfaces se organizam:

- **Collection**
  - **List**
    - **ArrayList**, **LinkedList**
  - **Set**
    - **HashSet**, **TreeSet**
  - **Queue**
    - **PriorityQueue**
- **Map**
  - **HashMap**, **TreeMap**



### Estruturas de Dados e Suas Implementações

#### 1. List
A **List** é ideal quando você precisa de uma sequência ordenada de elementos, que pode conter duplicatas. As duas principais implementações são:

- **ArrayList**
  - **Estrutura**: Um array dinâmico.
  - **Vantagens**: Acesso rápido por índice (O(1)).
  - **Desvantagens**: Inserir ou remover elementos do meio da lista é custoso (O(n)).
  - **Exemplo de uso**: Você tem uma lista de produtos onde precisa acessar rapidamente o terceiro item, mas raramente precisa adicionar ou remover elementos no meio da lista.

- **LinkedList**
  - **Estrutura**: Lista duplamente encadeada.
  - **Vantagens**: Inserção e remoção rápidas nas extremidades (O(1)).
  - **Desvantagens**: Acesso por índice é lento (O(n)).
  - **Exemplo de uso**: Ideal quando você precisa adicionar ou remover elementos do início ou fim de uma fila, como numa fila de processamento de pedidos.

#### 2. Set
Um **Set** é uma collection que não permite duplicatas, sendo útil para quando você quer garantir que todos os elementos sejam únicos.

- **HashSet**
  - **Estrutura**: Tabela hash.
  - **Vantagens**: Operações de inserção, busca e remoção muito rápidas (O(1)).
  - **Desvantagens**: Não mantém a ordem dos elementos.
  - **Exemplo de uso**: Quando você está criando um sistema para rastrear as categorias de produtos, onde não pode haver duplicatas e você não se importa com a ordem.

- **TreeSet**
  - **Estrutura**: Árvore de busca binária (Red-Black Tree).
  - **Vantagens**: Mantém os elementos em ordem (O(log n) para inserção e busca).
  - **Desvantagens**: Mais lento que o **HashSet**.
  - **Exemplo de uso**: Quando você precisa garantir que os elementos estejam sempre ordenados, como em um sistema de pontuação onde os maiores valores devem aparecer no topo.

#### 3. Queue
Uma **Queue** é usada quando você quer processar elementos em uma ordem específica, como **FIFO** (First In, First Out).

- **PriorityQueue**
  - **Estrutura**: Heap binário.
  - **Vantagens**: Sempre mantém o elemento de maior prioridade na frente (O(log n) para inserção e remoção).
  - **Desvantagens**: A operação de busca de elementos é custosa (O(n)).
  - **Exemplo de uso**: Sistemas de agendamento de tarefas, onde você quer sempre processar a tarefa mais importante primeiro.

#### 4. Map
O **Map** é uma estrutura que associa **chaves** a **valores**. Se você já precisou fazer um dicionário onde as palavras são as chaves e as definições são os valores, você já usou o conceito de um Map.

- **HashMap**
  - **Estrutura**: Tabela hash.
  - **Vantagens**: Inserção, busca e remoção rápidas (O(1)).
  - **Desvantagens**: Não garante a ordem das chaves.
  - **Exemplo de uso**: Ideal para sistemas onde você precisa armazenar pares chave-valor de forma eficiente, como um catálogo de produtos onde o ID do produto é a chave e os detalhes do produto são o valor.

- **TreeMap**
  - **Estrutura**: Árvore de busca binária balanceada.
  - **Vantagens**: Mantém as chaves em ordem crescente (O(log n)).
  - **Desvantagens**: Mais lento que o **HashMap**.
  - **Exemplo de uso**: Quando você precisa garantir que os itens estejam sempre ordenados, como num sistema de relatórios de vendas onde as vendas devem ser listadas em ordem cronológica.

### Resumo dos Métodos de Manipulação de Collections

1. **`boolean add(E e)`**
   - **Descrição**: Adiciona o elemento especificado à collection, se permitido. Este método retorna `true` se a adição foi bem-sucedida.
   - **Exemplo**:  
     ```java
     List<String> lista = new ArrayList<>();
     lista.add("Java");  // Adiciona "Java" à lista
     ```

2. **`boolean addAll(Collection<? extends E> c)`**
   - **Descrição**: Adiciona todos os elementos da collection especificada à collection atual. Retorna `true` se pelo menos um elemento foi adicionado com sucesso.
   - **Exemplo**:  
     ```java
     List<String> lista = new ArrayList<>();
     lista.addAll(Arrays.asList("Java", "Python", "C++"));
     ```

3. **`void clear()`**
   - **Descrição**: Remove todos os elementos da collection. Após a execução, a collection fica vazia.
   - **Exemplo**:  
     ```java
     lista.clear();  // Remove todos os elementos da lista
     ```

4. **`boolean contains(Object o)`**
   - **Descrição**: Retorna `true` se a collection contiver o elemento especificado.
   - **Exemplo**:  
     ```java
     lista.contains("Java");  // Verifica se "Java" está na lista
     ```

5. **`boolean containsAll(Collection<?> c)`**
   - **Descrição**: Retorna `true` se a collection atual contiver todos os elementos da collection especificada.
   - **Exemplo**:  
     ```java
     lista.containsAll(Arrays.asList("Java", "Python"));  // Verifica se ambos estão na lista
     ```

6. **`boolean equals(Object o)`**
   - **Descrição**: Compara a collection atual com o objeto especificado para verificar se ambos são iguais, ou seja, se contêm os mesmos elementos na mesma ordem.
   - **Exemplo**:  
     ```java
     lista.equals(outraLista);  // Verifica se ambas as listas são iguais
     ```

7. **`int hashCode()`**
   - **Descrição**: Retorna o valor do hash code para a collection. Esse valor é baseado nos elementos contidos nela.
   - **Exemplo**:  
     ```java
     int hashCode = lista.hashCode();
     ```

8. **`boolean isEmpty()`**
   - **Descrição**: Retorna `true` se a collection estiver vazia (sem elementos).
   - **Exemplo**:  
     ```java
     lista.isEmpty();  // Verifica se a lista está vazia
     ```

9. **`Iterator<E> iterator()`**
   - **Descrição**: Retorna um iterador para percorrer os elementos da collection.
   - **Exemplo**:  
     ```java
     Iterator<String> it = lista.iterator();
     while (it.hasNext()) {
         System.out.println(it.next());
     }
     ```

10. **`default Stream<E> parallelStream()`**
    - **Descrição**: Retorna um **Stream** paralelo para processamento em múltiplos threads.
    - **Exemplo**:  
      ```java
      lista.parallelStream().forEach(System.out::println);
      ```

11. **`boolean remove(Object o)`**
    - **Descrição**: Remove uma única instância do elemento especificado da collection, se ele estiver presente. Retorna `true` se o elemento foi removido.
    - **Exemplo**:  
      ```java
      lista.remove("Java");  // Remove "Java" da lista, se estiver presente
      ```

12. **`boolean removeAll(Collection<?> c)`**
    - **Descrição**: Remove todos os elementos da collection atual que também estão presentes na collection especificada. Retorna `true` se algum elemento foi removido.
    - **Exemplo**:  
      ```java
      lista.removeAll(Arrays.asList("Python", "C++"));  // Remove os elementos comuns
      ```

13. **`default boolean removeIf(Predicate<? super E> filter)`**
    - **Descrição**: Remove todos os elementos que atendem ao critério definido pelo predicado (filtro).
    - **Exemplo**:  
      ```java
      lista.removeIf(s -> s.startsWith("J"));  // Remove elementos que começam com "J"
      ```

14. **`boolean retainAll(Collection<?> c)`**
    - **Descrição**: Retém apenas os elementos da collection atual que também estão na collection especificada. Todos os outros elementos são removidos.
    - **Exemplo**:  
      ```java
      lista.retainAll(Arrays.asList("Java", "Python"));  // Mantém apenas "Java" e "Python"
      ```

15. **`int size()`**
    - **Descrição**: Retorna o número de elementos na collection.
    - **Exemplo**:  
      ```java
      int tamanho = lista.size();  // Retorna o número de elementos na lista
      ```

16. **`default Spliterator<E> spliterator()`**
    - **Descrição**: Cria um **Spliterator** para dividir os elementos da collection, usado para processamento paralelo eficiente.
    - **Exemplo**:  
      ```java
      Spliterator<String> spliterator = lista.spliterator();
      ```

17. **`default Stream<E> stream()`**
    - **Descrição**: Retorna um **Stream** sequencial para processamento dos elementos.
    - **Exemplo**:  
      ```java
      lista.stream().forEach(System.out::println);  // Processa os elementos em sequência
      ```

18. **`Object[] toArray()`**
    - **Descrição**: Converte a collection em um array de objetos.
    - **Exemplo**:  
      ```java
      Object[] array = lista.toArray();  // Converte a lista em um array
      ```

19. **`<T> T[] toArray(T[] a)`**
    - **Descrição**: Converte a collection em um array do tipo especificado.
    - **Exemplo**:  
      ```java
      String[] array = lista.toArray(new String[0]);  // Converte a lista em um array de strings
      ```

---

 O `Map` em Java não faz parte da interface `Collection`, pois ele segue um modelo de chave-valor. Diferentemente das collections que lidam apenas com elementos, o `Map` armazena pares de **chaves** e **valores**, o que o torna bastante útil para cenários onde precisamos de mapeamento entre dados (como uma tabela de consulta, por exemplo).

Abaixo estão os métodos mais importantes disponíveis para manipular o `Map`:

### Resumo dos Métodos de Manipulação de `Map`

1. **`void clear()`**
   - **Descrição**: Remove todos os pares de chave-valor do mapa, esvaziando-o.
   - **Exemplo**:  
     ```java
     map.clear();  // Remove todos os pares chave-valor
     ```

2. **`boolean containsKey(Object key)`**
   - **Descrição**: Verifica se o mapa contém uma associação para a chave especificada.
   - **Exemplo**:  
     ```java
     map.containsKey("nome");  // Verifica se a chave "nome" existe no mapa
     ```

3. **`boolean containsValue(Object value)`**
   - **Descrição**: Verifica se o mapa contém pelo menos uma associação para o valor especificado.
   - **Exemplo**:  
     ```java
     map.containsValue("Java");  // Verifica se algum valor é "Java"
     ```

4. **`Set<Map.Entry<K, V>> entrySet()`**
   - **Descrição**: Retorna uma **view** (`Set`) de todos os pares de chave-valor no mapa. Útil para iterar sobre o mapa.
   - **Exemplo**:  
     ```java
     for (Map.Entry<String, String> entry : map.entrySet()) {
         System.out.println(entry.getKey() + ": " + entry.getValue());
     }
     ```

5. **`V get(Object key)`**
   - **Descrição**: Retorna o valor associado à chave especificada ou `null` se a chave não estiver presente no mapa.
   - **Exemplo**:  
     ```java
     String valor = map.get("nome");  // Obtém o valor associado à chave "nome"
     ```

6. **`boolean isEmpty()`**
   - **Descrição**: Retorna `true` se o mapa não contiver nenhum par de chave-valor.
   - **Exemplo**:  
     ```java
     map.isEmpty();  // Verifica se o mapa está vazio
     ```

7. **`Set<K> keySet()`**
   - **Descrição**: Retorna um **Set** contendo todas as chaves presentes no mapa.
   - **Exemplo**:  
     ```java
     for (String chave : map.keySet()) {
         System.out.println(chave);
     }
     ```

8. **`V put(K key, V value)`**
   - **Descrição**: Associa o valor especificado à chave especificada no mapa. Se a chave já estiver associada a outro valor, o valor anterior será substituído.
   - **Exemplo**:  
     ```java
     map.put("nome", "Java");  // Adiciona ou atualiza o valor para a chave "nome"
     ```

9. **`void putAll(Map<? extends K, ? extends V> m)`**
   - **Descrição**: Copia todos os pares de chave-valor do mapa especificado para o mapa atual.
   - **Exemplo**:  
     ```java
     outroMap.putAll(map);  // Copia todos os pares de "map" para "outroMap"
     ```

10. **`V remove(Object key)`**
    - **Descrição**: Remove a associação da chave especificada no mapa, retornando o valor removido, ou `null` se a chave não existia.
    - **Exemplo**:  
      ```java
      map.remove("nome");  // Remove a chave "nome" e retorna o valor associado
      ```

11. **`int size()`**
    - **Descrição**: Retorna o número de pares de chave-valor no mapa.
    - **Exemplo**:  
      ```java
      int tamanho = map.size();  // Obtém o número de pares de chave-valor no mapa
      ```

12. **`Collection<V> values()`**
    - **Descrição**: Retorna uma **view** de todos os valores presentes no mapa.
    - **Exemplo**:  
      ```java
      for (String valor : map.values()) {
          System.out.println(valor);
      }
      ```

13. **`V getOrDefault(Object key, V defaultValue)`**
    - **Descrição**: Retorna o valor associado à chave especificada ou o valor padrão se a chave não estiver presente.
    - **Exemplo**:  
      ```java
      String valor = map.getOrDefault("idade", "não especificado");
      ```

14. **`default V putIfAbsent(K key, V value)`**
    - **Descrição**: Se a chave especificada não estiver associada a nenhum valor, associa-a ao valor especificado e retorna `null`. Se já existir uma associação, retorna o valor existente.
    - **Exemplo**:  
      ```java
      map.putIfAbsent("pais", "Brasil");  // Só adiciona se a chave "pais" não existir
      ```

15. **`default boolean remove(Object key, Object value)`**
    - **Descrição**: Remove a associação apenas se a chave estiver associada ao valor especificado. Retorna `true` se a remoção foi bem-sucedida.
    - **Exemplo**:  
      ```java
      map.remove("nome", "Java");  // Remove somente se o valor for "Java"
      ```

16. **`default V replace(K key, V value)`**
    - **Descrição**: Substitui a associação da chave especificada pelo novo valor, se a chave já estiver associada a um valor.
    - **Exemplo**:  
      ```java
      map.replace("nome", "Python");  // Substitui o valor associado à chave "nome"
      ```

17. **`default boolean replace(K key, V oldValue, V newValue)`**
    - **Descrição**: Substitui o valor associado à chave apenas se estiver atualmente associado ao valor antigo especificado.
    - **Exemplo**:  
      ```java
      map.replace("nome", "Java", "Python");  // Substitui "Java" por "Python" apenas se o valor atual for "Java"
      ```

---
### Notação Big O: Como Medimos Desempenho?

A **notação Big O** é uma maneira de expressar o tempo ou espaço que uma operação em uma coleção leva à medida que o número de elementos (n) aumenta. Ela é essencial para avaliar se uma estrutura de dados é adequada para um determinado problema. A tabela a seguir ilustra o desempenho típico das operações de inserção, remoção, busca e acesso nas coleções mais comuns, utilizando Big O.

| **Interface** | **Classe**      | **Inserção** | **Remoção** | **Busca** | **Acesso** | **Comentários**                                                                                     |
|---------------|-----------------|--------------|-------------|-----------|------------|-----------------------------------------------------------------------------------------------------|
| **List**      | `ArrayList`      | O(n)         | O(n)        | O(n)      | O(1)       | **ArrayList** tem acesso rápido por índice (O(1)), mas a inserção e remoção são lentas (O(n)) se feitas no meio. |
|               | `LinkedList`     | O(1)         | O(1)        | O(n)      | O(n)       | **LinkedList** tem inserção e remoção rápidas (O(1)), mas buscar ou acessar um elemento é mais lento (O(n)).     |
| **Set**       | `HashSet`        | O(1)         | O(1)        | O(1)      | -          | **HashSet** é rápido para todas as operações básicas (inserção, remoção e busca), com tempo constante (O(1)).     |
|               | `TreeSet`        | O(log n)     | O(log n)    | O(log n)  | -          | **TreeSet** tem desempenho mais lento, com tempo logarítmico (O(log n)), mas garante elementos ordenados.       |
| **Queue**     | `PriorityQueue`  | O(log n)     | O(log n)    | O(n)      | -          | **PriorityQueue** é eficiente para operações de prioridade (inserção e remoção), mas buscar um elemento específico é lento. |
| **Map**       | `HashMap`        | O(1)         | O(1)        | O(1)      | -          | **HashMap** oferece desempenho excelente com tempo constante (O(1)) para inserção, remoção e busca.              |
|               | `TreeMap`        | O(log n)     | O(log n)    | O(log n)  | -          | **TreeMap** tem desempenho mais lento (O(log n)), mas mantém os elementos em ordem, o que é vantajoso em certos cenários. |

### Explicação das Nomenclaturas

1. **O(1)** – **Tempo Constante** (Bom desempenho):  
   O tempo de execução não depende do número de elementos. Não importa se há 10 ou 10 milhões de elementos, a operação levará o mesmo tempo. Exemplo: acessar um índice em um `ArrayList` ou buscar um elemento em um `HashMap`.

2. **O(n)** – **Tempo Linear** (Desempenho médio):  
   O tempo de execução aumenta proporcionalmente ao número de elementos. Se a lista tiver 10 vezes mais elementos, a operação pode demorar 10 vezes mais. Exemplo: buscar um elemento em um `LinkedList`.

3. **O(log n)** – **Tempo Logarítmico** (Bom desempenho):  
   O tempo de execução aumenta de forma logarítmica em relação ao número de elementos. Isso significa que mesmo quando o número de elementos cresce muito, o tempo de execução aumenta relativamente pouco. Exemplo: inserção e busca em um `TreeSet` ou `TreeMap`.

4. **O(n log n)** – **Tempo Log-linear** (Desempenho médio/alto):  
   Um pouco mais lento que O(log n), mas ainda razoavelmente eficiente. É comum em algoritmos de ordenação, mas não aparece na nossa tabela.

### Análise Geral das Estruturas de Dados

- **`ArrayList`** é uma excelente escolha quando você precisa de acesso rápido por índice e sabe que não fará muitas inserções ou remoções em posições arbitrárias da lista.
- **`LinkedList`** é mais eficiente quando você faz muitas inserções e remoções no início ou no meio da lista, mas o acesso aleatório é mais lento.
- **`HashSet`** e **`HashMap`** são ótimos quando você precisa de tempos constantes para inserção, remoção e busca, e não se importa com a ordem dos elementos.
- **`TreeSet`** e **`TreeMap`** são mais lentos, mas úteis quando você precisa manter os elementos ordenados.

Essa análise é importante porque a escolha da estrutura de dados pode impactar diretamente o desempenho da sua aplicação.

### Conclusão

Entender a **Hierarquia do Collection Framework** é um passo essencial para quem deseja ser um desenvolvedor Java eficiente. Cada implementação tem suas particularidades, e saber qual usar em cada situação pode fazer toda a diferença na performance e na legibilidade do seu código.

A próxima vez que você estiver lidando com uma grande quantidade de dados, lembre-se deste guia. O sucesso não está apenas em fazer o código funcionar, mas em fazê-lo da maneira mais eficiente possível. Boa codificação!