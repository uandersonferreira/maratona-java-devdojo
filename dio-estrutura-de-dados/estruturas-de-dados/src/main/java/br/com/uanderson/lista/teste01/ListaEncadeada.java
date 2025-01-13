package br.com.uanderson.lista.teste01;

public class ListaEncadeada<T> {

    // Atributo que guarda a referência do primeiro nó da lista (a cabeça da lista).
    private No<T> referenciaEntrada;

    // Construtor da Lista Encadeada. Ao criar uma nova lista, ela começa vazia, 
    // então a referência de entrada é inicializada como 'null'.
    public ListaEncadeada() {
        this.referenciaEntrada = null;
    }

    /**
     * Método para adicionar um novo elemento à lista.
     * Ele cria um novo nó com o conteúdo fornecido e o adiciona no final da lista.
     */
    public void add(T conteudo) {
        // Criando um novo nó com o conteúdo passado (T é o tipo genérico).
        No<T> novoNo = new No<>(conteudo);

        // Se a lista estiver vazia (não há nós ainda), 
        // então o novo nó se torna o primeiro nó (a referência de entrada).
        if (this.isEmpty()) {
            referenciaEntrada = novoNo;
            return;  // Saímos do método, pois o nó já foi adicionado.
            // Se a lista estava vazia, o primeiro nó agora é o novoNo,
            // e não precisamos continuar para o loop.
        }

        // Se a lista não estiver vazia, temos que percorrer até o último nó
        // para adicionar o novo nó ao final.
        No<T> noAuxiliar = referenciaEntrada;

        // Este laço percorre a lista até o último nó (por isso o this.size() - 1).
        // Não percorremos até o tamanho total da lista, mas até o penúltimo elemento.
        for (int i = 0; i < this.size() - 1; i++) {
            noAuxiliar = noAuxiliar.getProximoNo(); // Andamos para o próximo nó.
        }

        // Chegamos ao último nó e fazemos com que ele aponte para o novo nó.
        noAuxiliar.setProximoNo(novoNo);
    }

    public T get(int index) {
        return getNo(index).getConteudo();
    }


    /**
     * Método privado para obter o nó de uma posição específica da lista.
     * Ele serve para encontrar o nó no índice solicitado.
     * Índices da lista:  [ 0    ->    1    ->   2    -> null ]
     * Conteúdo da lista: [nó1  ->  nó2  ->  nó3 -> null ]
     * Size() = 3, mas devemos sempre Lembrar que o primeiro elemento começa no Index 0.
     */
    private No<T> getNo(int index) {
        // Valida se o índice é válido (não pode ser maior ou igual ao tamanho da lista).
        validaIndice(index);

        No<T> noAuxiliar = referenciaEntrada;  // Começa no primeiro nó.
        No<T> noRetorno = null;

        // Percorre até o nó desejado (size() - 1 nos garante que não ultrapassamos o último nó).
        for (int i = 0; i <= index; i++) {
            noRetorno = noAuxiliar; // Armazena o nó atual.
            noAuxiliar = noAuxiliar.getProximoNo(); // Avança para o próximo nó.
        }

        return noRetorno; // Retorna o nó encontrado na posição indicada.
    }

//                   BASE                        TOPO
//                   ↓                            ↓
//ref.entrada ->   nó[0] -> nó[1] -> nó[2] -> nó[3] -> null

    public T remove(int index) {
        No<T> noPivor = this.getNo(index); //Identificamos o No para remover
        if (index == 0) { // Seria a BASE (primeiro elemento inserido)
            referenciaEntrada = noPivor.getProximoNo();//Pula a BASE  é pega a ref do proximo no que está no indice 1
            return noPivor.getConteudo();
            /*
                                                      BASE               TOPO
                                                        ↓                 ↓
                [REFERENCIA DE ENTRADA] -->           nó[1] -> nó[2] -> nó[3] -> null
             */
        }
        No<T> noAnterior = getNo(index - 1);//ex: se index para remover == 3, irá retornar o nó do index 2 e associar o nó do index 4 ou null ao nó do index 2, pulando o nó do index 3, pois irá ser removido
        // 0 1 2 3  4 5 null
        // 0 1 2 -> 4 5 null   
        noAnterior.setProximoNo(noPivor.getProximoNo());
        return noPivor.getConteudo();
        /*
        Ao remover um nó da lista:

        1. Identificamos o nó a ser removido com base no índice.
        2. Ajustamos as referências para que o nó anterior "pule" o nó que está sendo removido, conectando-se diretamente ao próximo nó.
        3. Caso especial: Se for o primeiro nó (índice 0), a referência de entrada será atualizada para apontar para o segundo nó.
         */
    }


    /**
     * Método que retorna o tamanho atual da lista.
     * Ele percorre a lista contando quantos nós existem.
     * Índices da lista:  [ 0    ->    1    ->   2    -> null ]
     * Conteúdo da lista: [nó1  ->  nó2  ->  nó3 -> null ]
     * Size() = 3, mas devemos sempre lemebrar que o primeiro elemento começa no Index 0.
     */
    public int size() {
        int tamanhoLista = 0;  // Variável para contar o número de nós.
        No<T> referenciaAuxiliar = referenciaEntrada;  // Começa no primeiro nó.

        // Laço para percorrer a lista inteira.
        while (true) {
            if (referenciaAuxiliar != null) {
                tamanhoLista++;  // Incrementa o contador para cada nó encontrado.

                // Se ainda há nós seguintes, continua percorrendo.
                if (referenciaAuxiliar.getProximoNo() != null) {
                    referenciaAuxiliar = referenciaAuxiliar.getProximoNo();  // Avança para o próximo nó.
                } else {
                    // Se não há mais nós, terminamos o laço.
                    break;
                }
            } else {
                // Se a referência de entrada for nula, significa que a lista está vazia.
                break;
            }
        }

        return tamanhoLista;  // Retorna o tamanho total da lista.
    }

    /**
     * Método privado para validar se o índice fornecido está dentro dos limites da lista.
     * Se o índice for maior ou igual ao tamanho da lista, lança uma exceção.
     * Índices da lista:  [ 0    ->    1    ->   2    -> null ]
     * Conteúdo da lista: [nó1  ->  nó2  ->  nó3 -> null ]
     * Size() = 3, mas devemos sempre Lembrar que o primeiro elemento começa no Index 0.
     */
    private void validaIndice(int index) {
        if (index >= size()) {
            int ultimoIndex = size() - 1;  // Calcula o último índice válido. -1 pois o size() retorna o número total de elementos.

            // Lança uma exceção indicando que o índice está fora dos limites da lista.
            throw new IndexOutOfBoundsException(
                    "Não existe conteúdo no index " + index + " desta lista. Esta lista só vai até o índice "
                            + ultimoIndex + "."
            );
        }
    }

    /**
     * Método que verifica se a lista está vazia.
     * Se a referência de entrada for nula, significa que não há nós na lista.
     */
    public boolean isEmpty() {
        return referenciaEntrada == null ? true : false;
        // Retorna true se a lista estiver vazia (referenciaEntrada == null),
        // caso contrário, retorna false.
    }

    @Override
    public String toString() {
        String strRetorno = "";
        No<T> noAuxiliar = referenciaEntrada; //Começar a Ler pela BASE index 0, primeiro elemento inserido
        for (int i = 0; i < this.size(); i++) {
            strRetorno += "No [conteudo=" + noAuxiliar.getConteudo() + "] --> ";
            noAuxiliar = noAuxiliar.getProximoNo();
        }
        strRetorno += "null";
        return strRetorno;
    }


} // fim da classe
