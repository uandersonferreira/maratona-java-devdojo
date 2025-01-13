package dio.estruturas-de-dados.lista-duplamente-encadeada;

public class ListaDuplamenteEncadeada<T> {

    private NoDuplo<T> referenciaPrimeiroNo;
    private NoDuplo<T> referenciaUltimoNo;
    private int tamanhoLista;

    public ListaDuplamenteEncadeada() {
        this.referenciaPrimeiroNo = null;
        this.referenciaUltimoNo = null;
        this.tamanhoLista = 0;
    }

    public T get(int index) {
        return this.getNo(index).getConteudo();
    }

    public void add(T elemento) {
        // Cria um novo nó com o elemento passado como argumento
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);

        // Define a referência do próximo nó como null, pois este será o último nó
        novoNo.setNoProximo(null);

        // Define a referência do nó anterior como o último nó atual da lista
        novoNo.setNoPrevio(referenciaUltimoNo);

        // Se a lista estiver vazia, o novo nó se torna o primeiro nó
        if (referenciaPrimeiroNo == null) {
            referenciaPrimeiroNo = novoNo;
        }

        // Se a lista não estiver vazia, o último nó atual deve apontar para o novo nó
        if (referenciaUltimoNo != null) {
            referenciaUltimoNo.setNoProximo(novoNo);
        }

        // Atualiza a referência do último nó para o novo nó
        referenciaUltimoNo = novoNo;

        // Incrementa o tamanho da lista
        tamanhoLista++;
    }

    public void add(int index, T elemento) {
        /**
         * Lista: 0, 1, 2 e 3 --> adiciona na posição 4
         * Pega o nó no índice especificado (ou retorna null)
         * [0] <-> [1] <-> [2] <-> [3] <-> null
         */
        NoDuplo<T> noAuxiliar = getNo(index);

        /** Cria um novo nó com o elemento passado */
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);

        /**
         * Define que o próximo nó do novo nó será o nó auxiliar (o nó atual na posição
         * onde queremos inserir)
         * Portanto, novoNo(4).setNoProximo(noAuxiliar) define
         * novoNo(4).setNoProximo(No(3)).
         */
        novoNo.setNoProximo(noAuxiliar);

        if (novoNo.getNoProximo() != null) {
            /**
             * Se o novo nó não for o último (tem um próximo nó),
             * define a referência do nó anterior como a do nó auxiliar.
             */
            novoNo.setNoPrevio(noAuxiliar.getNoPrevio());

            /**
             * Define que o nó auxiliar (o atual na posição) tenha seu nó anterior como o
             * novo nó
             */
            novoNo.getNoProximo().setNoPrevio(novoNo);

        } else {
            /**
             * Se o novo nó for o último,
             * define sua referência do nó anterior como a do último nó atual.
             */
            novoNo.setNoPrevio(referenciaUltimoNo);

            /** Atualiza a referência do último nó para o novo nó */
            referenciaUltimoNo = novoNo;
        }

        if (index == 0) {
            /**
             * Se estamos adicionando na posição 0 (primeiro nó),
             * o novo nó se torna a referência do primeiro nó.
             */
            referenciaPrimeiroNo = novoNo;

        } else {
            /**
             * Caso contrário, define que o nó anterior do novo nó
             * aponta para o novo nó como seu próximo.
             */
            novoNo.getNoPrevio().setNoProximo(novoNo);
        }

        /** Incrementa o tamanho da lista: [0] <-> [1] <-> [2] <-> [3] <-> [4] */
        tamanhoLista++;
    }

    /**
     * Imagine uma lista [0, 1, 2, 3, 4] e queremos remover o elemento na posição 2
     * (elemento 2).
     *
     * Fluxo de Remoção:
     * Lista Inicial:
     * [0] <-> [1] <-> [2] <-> [3] <-> [4]
     * Remoção do Nó na Posição 2:
     * O índice não é 0, então obtém-se o nó na posição 2 usando getNo(index), que é
     * o nó com o elemento 2.
     * Atualiza-se a referência do nó anterior (nó 1) para apontar para o próximo nó
     * (nó 3).
     * Atualiza-se a referência do próximo nó (nó 3) para apontar para o nó anterior
     * (nó 1).
     * Após esses ajustes, a lista fica assim:
     * [0] <-> [1] <-> [3] <-> [4]
     * Ajuste da Referência do Último Nó:
     * Verifica-se se o nó a ser removido é o último nó. Nesse caso, não é, então
     * não há necessidade de atualizar a referência do último nó.
     * Decremento do Tamanho da Lista: Decrementa-se o tamanho da lista em 1.
     */
    public void remove(int index) {
        if (index == 0) {
            // Se estamos removendo o primeiro elemento da lista
            referenciaPrimeiroNo = referenciaPrimeiroNo.getNoProximo(); // Atualiza a referência do primeiro nó para o
                                                                        // próximo nó
            if (referenciaPrimeiroNo != null) {
                referenciaPrimeiroNo.setNoPrevio(null); // Se o próximo nó existir, define sua referência anterior como
                                                        // null
            }
        } else {
            NoDuplo<T> noAuxiliar = getNo(index); // Obtém o nó na posição especificada
            // Atualiza a referência do nó anterior para pular o nó atual e apontar para o
            // próximo nó
            noAuxiliar.getNoPrevio().setNoProximo(noAuxiliar.getNoProximo());
            if (noAuxiliar != referenciaUltimoNo) {
                // Se o nó a ser removido não for o último, atualiza a referência anterior do
                // próximo nó
                noAuxiliar.getNoProximo().setNoPrevio(noAuxiliar.getNoPrevio());
            } else {
                // Se o nó a ser removido for o último, atualiza a referência do último nó
                referenciaUltimoNo = noAuxiliar.getNoPrevio();
            }
        }

        this.tamanhoLista--; // Decrementa o tamanho da lista em 1
    }

    private NoDuplo<T> getNo(int index) {
        NoDuplo<T> noAuxiliar = referenciaPrimeiroNo;

        /**
         * Percorre a lista até encontrar o nó na posição especificada,
         * ou até chegar ao final da lista.
         */
        for (int i = 0; (i < index) && (noAuxiliar != null); i++) {
            noAuxiliar = noAuxiliar.getNoProximo();
        }
        return noAuxiliar; // Aqui, noAuxiliar será null se o índice for maior que o tamanho da lista
    }

    public int size() {
        return this.tamanhoLista;
    }

    @Override
    public String toString() {
        String strRetorno = "";

        NoDuplo<T> noAuxiliar = referenciaPrimeiroNo;
        for (int i = 0; i < size(); i++) {
            strRetorno += "[No{conteudo= " + noAuxiliar.getConteudo() + "}] --> ";
            noAuxiliar = noAuxiliar.getNoProximo();
        }

        strRetorno += "null";
        return strRetorno;
    }

} // class
