package br.com.uanderson.lista_circular;

public class ListaCircular<T> {

    private No<T> cabeca;
    private No<T> cauda;
    private int tamanhoLista;


    public ListaCircular() {
        this.cauda = null;
        this.cabeca = null;
        this.tamanhoLista = 0;
    }

    public void add(T conteudo) {//adicionar no inicio da lista circula
        No<T> novoNo = new No<>(conteudo);

        if (this.isEmpty()) {
            this.cabeca = novoNo;
            this.cauda = this.cabeca;
            this.cabeca.setNoProximo(cauda);
        } else {
            //Adicioanando atrás da cauda, então esse Nó vai apontar para o Nó Cauda atual, depois vamos fazer a cabeça mudar a referência de cauda atual, para o novo Nó e depois mudamos a referência da cauda atual para esse novo Nó adicionado. 
            novoNo.setNoProximo(this.cauda);
            this.cabeca.setNoProximo(novoNo);
            this.cauda = novoNo;
        }
        this.tamanhoLista++;
    }

    public void remove(int index) {
        if (index >= this.tamanhoLista)
            throw new IndexOutOfBoundsException("O indice é maior que o tamanho da lista!");

        No<T> noAuxiliar = this.cauda;
        if (index == 0) {
            //Cauda é o primeiro elemento da lista, então temos que mudar a ref. para o no da frente
            //antes de remover a cauda, para que ele passe a ser a cauda atual.
            this.cauda = this.cauda.getNoProximo();
            this.cabeca.setNoProximo(this.cauda); //Atualizando a ref. de cauda que a cabeça têm para o this.cauda.getNoProximo(); -> que é a cauda atual nesse ponto do código, para que assim, a cauda que desejamos remove realmente perca todas as referências apontadas para ela e seja removida pelo GaberColletor do Java, pois tanto a ref. de cauda, quanto a referência que a cabeça mantinha foram mudadas para this.cauda.getNoProximo(); Dessa forma, o index 0 é removido pois não têm referência

        } else if (index == 1) {//imediatamente após a cauda
            //pulando o index 1 e fazendo a cauda aponta para o index 2
            //0 --> ?(2)  == 0 --> 1 --> 2
            //0 --> 1 --> 2   ficando 0 --> 2
            this.cauda.setNoProximo(this.cauda.getNoProximo().getNoProximo());

        } else {
            // Para remover index que não seja nem 0 e nem 1
            //--> 2 - 1 == 1
            for (int i = 0; i < index - 1; i++) { // [ 2 ] --> 2 - 1 == 1
                noAuxiliar = noAuxiliar.getNoProximo();
                //           0 --> 1
                // noAuxiliar --> 1
            }
            noAuxiliar.setNoProximo(noAuxiliar.getNoProximo().getNoProximo());
            // noAuxiliar.setNoProximo  == 1 --> 2 --> 3
        }
        this.tamanhoLista--;
    }//method

    public T get(int index) {
        return this.getNo(index).getConteudo();
    }

    private No<T> getNo(int index) {
        if (this.isEmpty()) throw new IndexOutOfBoundsException("A lista está vazia!");

        if (index == 0) return this.cauda;

        No<T> noAuxiliar = this.cauda; // entrando pela cauda e percorrendo até o index solicitado dentro de um loop infinito
        for (int i = 0; (i < index) && (noAuxiliar != null); i++) {
            noAuxiliar = noAuxiliar.getNoProximo();
        }

        return noAuxiliar;
    }

    public boolean isEmpty() {
        return this.tamanhoLista == 0 ? true : false;
    }

    public int size() {
        return this.tamanhoLista;
    }


    @Override
    public String toString() {
        String strRetorno = "";
        No<T> noAuxiliar = this.cauda; //Começar a Ler pela CAUDA index 0, primeiro elemento inserido
        for (int i = 0; i < this.size(); i++) {
            strRetorno += "No [conteudo=" + noAuxiliar.getConteudo() + "] INDEX [" + i + "] --> ";
            noAuxiliar = noAuxiliar.getNoProximo();
        }

        strRetorno += this.isEmpty() ? "[]" : "(Retorna ao inicio)";

        return strRetorno;
    }


}// class
