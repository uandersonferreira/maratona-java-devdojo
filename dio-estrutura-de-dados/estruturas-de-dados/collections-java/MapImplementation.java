package dio.estruturas-de-dados.collections-java;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MapImplementation {
    public static void main(String[] args) {
        List<Map<String, String>> listaAlunos = new ArrayList<>();

        Map<String, String> aluno1 = new HashMap<>();
        aluno1.put("Nome", "João");
        aluno1.put("Idade", "17");
        aluno1.put("Média", "8.5");
        aluno1.put("Turma", "3A");

        Map<String, String> aluno2 = new HashMap<>();
        aluno2.put("Nome", "Maria");
        aluno2.put("Idade", "16");
        aluno2.put("Média", "9.0");
        aluno2.put("Turma", "3B");

        listaAlunos.add(aluno1);
        listaAlunos.add(aluno2);

        // Exibindo a lista de alunos
        System.out.println("Lista de Alunos: " + listaAlunos);

        // Utilizando métodos da interface Map

        // 1. compute()
        aluno1.compute("Idade", (key, value) -> String.valueOf(Integer.parseInt(value) + 1));
        System.out.println("\nApós compute (incrementando a idade de João): " + aluno1);

        // 2. computeIfAbsent()
        aluno1.computeIfAbsent("Endereço", key -> "Endereço não informado");
        System.out.println("Após computeIfAbsent: " + aluno1);

        // 3. computeIfPresent()
        aluno1.computeIfPresent("Média", (key, value) -> String.valueOf(Double.parseDouble(value) + 0.5));
        System.out.println("Após computeIfPresent (incrementando a média de João): " + aluno1);

        // 4. forEach()
        System.out.println("\nExibindo aluno1 com forEach:");
        aluno1.forEach((key, value) -> System.out.println(key + ": " + value));

        // 5. getOrDefault()
        String endereco = aluno2.getOrDefault("Endereço", "Endereço não informado");
        System.out.println("\nEndereço de Maria: " + endereco);

        // 6. merge()
        aluno2.merge("Média", "10.0", (oldValue, newValue) -> newValue);
        System.out.println("Após merge (atualizando a média de Maria): " + aluno2);

        // 7. putIfAbsent()
        aluno2.putIfAbsent("Cidade", "São Paulo");
        System.out.println("Após putIfAbsent (adicionando cidade): " + aluno2);

        // 8. remove()
        aluno1.remove("Idade", "18");
        System.out.println("\nApós remove (removendo idade se for 18): " + aluno1);

        // 9. replace()
        aluno1.replace("Turma", "3B");
        System.out.println("Após replace (mudando a turma de João): " + aluno1);

        // 10. replace (com valor antigo)
        boolean replaced = aluno2.replace("Média", "9.0", "8.5");
        System.out.println("Após replace (tentando mudar a média de Maria de 9.0 para 8.5): " + replaced);
        System.out.println("Aluno2: " + aluno2);

        // 11. replaceAll()
        aluno1.replaceAll((key, value) -> value.toUpperCase());
        System.out.println("\nApós replaceAll (transformando todos os valores de aluno1 em maiúsculas): " + aluno1);
    }
}
```

/*

### Explicações dos Métodos:

1. **compute(K key, BiFunction<? super K,? super V,? extends V> remappingFunction)**:
   - Tenta calcular um valor para a chave especificada usando a função fornecida e associa o novo valor à chave. Se a chave não existir, ela será adicionada com o valor calculado.

2. **computeIfAbsent(K key, Function<? super K,? extends V> mappingFunction)**:
   - Se a chave especificada não estiver associada a um valor (ou estiver mapeada para `null`), calcula o valor usando a função fornecida e o adiciona ao mapa.

3. **computeIfPresent(K key, BiFunction<? super K,? super V,? extends V> remappingFunction)**:
   - Se a chave especificada estiver presente e não for `null`, calcula um novo valor com base na chave e no valor atual, e o atualiza no mapa.

4. **forEach(BiConsumer<? super K,? super V> action)**:
   - Itera sobre cada par chave-valor do mapa e executa a ação fornecida para cada um.

5. **getOrDefault(Object key, V defaultValue)**:
   - Retorna o valor associado à chave especificada ou, se a chave não existir, retorna um valor padrão fornecido.

6. **merge(K key, V value, BiFunction<? super V,? super V,? extends V> remappingFunction)**:
   - Se a chave não estiver associada a um valor ou estiver associada a `null`, associa a chave ao valor fornecido. Caso contrário, combina o valor atual com o valor fornecido usando a função especificada.

7. **putIfAbsent(K key, V value)**:
   - Adiciona a chave e o valor ao mapa somente se a chave não estiver associada a nenhum valor.

8. **remove(Object key, Object value)**:
   - Remove a entrada para a chave especificada somente se estiver associada ao valor fornecido.

9. **replace(K key, V value)**:
   - Substitui o valor associado à chave somente se ela estiver mapeada para algum valor.

10. **replace(K key, V oldValue, V newValue)**:
    - Substitui o valor associado à chave somente se estiver atualmente associado ao valor especificado (`oldValue`).

11. **replaceAll(BiFunction<? super K,? super V,? extends V> function)**:
    - Substitui cada valor no mapa com o resultado da aplicação da função fornecida a cada par chave-valor.



 */