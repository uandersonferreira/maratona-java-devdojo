package dio.estruturas-de-dados.pilha.teste02;

public class Fila {

    private No refNoEntradaFila;

    /**
     * O construtor inicializa a referência do último nó (refNoEntradaFila) como
     * null,
     * indicando que a fila está vazia no início.
     */
    public Fila() {
        this.refNoEntradaFila = null;
    }

    /**
     * O método `enqueue` adiciona um novo nó ao topo da pilha.
     * A linha `novoNo.setReferenciaNo(refNoEntradaFila)` faz com que o novo nó
     * aponte para o nó que já estava no topo (refNoEntradaFila).
     * A linha `refNoEntradaFila = novoNo` atualiza a referência para o novo nó,
     * que agora é o novo topo da pilha.
     * 
     * Exemplo: Se a pilha está assim: 3 -> 2 -> 1 -> 0 -> null,
     * e você chama `enqueue(4)`, ela ficará assim: 4 -> 3 -> 2 -> 1 -> 0 -> null.
     */
    public void enqueue(Object object) {
        No novoNo = new No(object);//imbutindo/encapsulando a criação do nó na class Fila
        novoNo.setReferenciaNo(refNoEntradaFila);
        refNoEntradaFila = novoNo;
    }

    /**
     * O método `first` retorna o primeiro nó inserido na pilha, ou seja,
     * o nó que está na base (mais antigo), mas não remove ele da fila/pilha.
     * Ele percorre a pilha inteira até encontrar o último nó (com referência
     * `null`).
     * 
     * Exemplo: Se a pilha está assim: 4 -> 3 -> 2 -> 1 -> 0 -> null, o método retornará o
     * nó `0`.
     */
    public Object first() {
        if (!this.isEmpty()) {
            No primeiroNo = refNoEntradaFila;
            while (true) {
                // Verifica se o nó atual tem um próximo nó
                if (primeiroNo.getReferenciaNo() != null) {
                    primeiroNo = primeiroNo.getReferenciaNo();
                    // Se houver um nó seguinte, continua percorrendo a pilha.
                } else {
                    break; // Para o loop ao chegar na base, onde a referência é null.
                }
            }
            return primeiroNo.getObject();
        }
        return null;
    }

    /**
     * O método `dequeue` remove o nó da base da pilha, que é o primeiro nó
     * inserido.
     * O nó anterior ao último é atualizado para que sua referência seja `null`,
     * removendo assim o nó base da pilha. E o nó anterior ao último passa a ser o No BASE.
     * 
     * Exemplo: Se a pilha está assim: 4 -> 3 -> 2 -> 1 -> 0 -> null, após chamar
     * `dequeue()`,
     * ela ficará assim: 4 -> 3 -> 2 -> 1 -> null, e o nó `0` será removido.
     */
    public Object dequeue() {
        if (!this.isEmpty()) {
            No primeiroNo = refNoEntradaFila;
            No noAuxiliar = refNoEntradaFila;

            while (true) {
                if (primeiroNo.getReferenciaNo() != null) {
                    noAuxiliar = primeiroNo;
                    primeiroNo = primeiroNo.getReferenciaNo();
                    // Continua percorrendo até encontrar o nó base (primeiro adicionado).
                } else {
                    noAuxiliar.setReferenciaNo(null);
                    break; // Quando o nó base é encontrado, ele é removido.
                }
            }
            return primeiroNo.getObject(); // Retorna o nó removido.
        }
        return null;
    }

    /**
     * O método `isEmpty` verifica se a pilha está vazia.
     * Se `refNoEntradaFila` for `null`, significa que não há nós na pilha,
     * logo a pilha está vazia e o método retorna `true`.
     */
    public boolean isEmpty() {
        return refNoEntradaFila == null ? true : false;
    }

    /**
     * O método `toString` constrói uma representação em string da pilha,
     * mostrando cada nó e sua referência até chegar em `null`.
     * Exemplo de saída: [No{objeto= 4 }] --> [No{objeto= 3 }] --> ... --> null
     */
    @Override
    public String toString() {
        String stringRetorno = "";
        No noAuxiliar = refNoEntradaFila;

        if (refNoEntradaFila != null) {
            while (true) {
                stringRetorno += "[No{objeto= " + noAuxiliar.getObject() + " }] --> ";
                if (noAuxiliar.getReferenciaNo() != null) {
                    noAuxiliar = noAuxiliar.getReferenciaNo();
                } else {
                    stringRetorno += "null";
                    break;
                }
            }
        }
        return stringRetorno;
    }

}   
