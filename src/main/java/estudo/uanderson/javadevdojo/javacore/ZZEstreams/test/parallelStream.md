# Fazer Benchmark
 - Basicamente é medir a eficiência do processador 
 - (tanto single-core quanto multi-core) em diversas operações

# Unboxing e boxing/Autoboxing (Wrapper | Tipo Primitivo)
 - Unboxing - wrapper para primitivo
 - Boxing - primitivo para wrapper
 - Pois, influência no processamentamento. 

# (limit, findFirst) Possuem um desempenho baixo ao usar parallel()
# (findAny) já é bom com parallel();
# Custo total da computação N, P
 - N -> elementos / P -> processamentos
 - Quanto maior a quantidade de processamento dos elementos,
 - maior será o beneficio ao utilizar atividades paralelas.

# Quantidade de dados
- se a quantidade de dados for pequena, não vale a pena utilizar
- as multiplas trades(parallel()).

# Tipos de Coleções
- ArrayList é Ótima 
- LinkedList é pessima
- Iterate é ruim 
- rangeClosed é bom
- Set é bom 

# tamanho do stream (tamanho definido)
- são melhores, pois ao saber o tamanho é possível realizar a divisão de tarefas

# Processammento do merge (Fork/Join)
if(tarefa for pequena e não pode ser dividida){
   faz sequenciamente 
} else{
  divide em duas tarefas
  chama o metodo recursivamente
  espera todas as tarefas serem completadas
  combina o resultado.
}

<img src="/home/uanderson/Documentos/GitHub/JAVA/Java-DevDojo/fork_join.png">