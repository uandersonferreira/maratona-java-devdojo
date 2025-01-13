package br.com.uanderson.pilha.teste01;

public class Pilha {

    private No referenciaNoEntradaPilha; //TOPO

    public Pilha() {
        this.referenciaNoEntradaPilha = null;
    }


    public void push(No novoNo){
        No refAuxiliar = referenciaNoEntradaPilha; //Guardamos/Criamos a referência de entrada TOPO
        referenciaNoEntradaPilha = novoNo; //Atribuimos a referência do TOPO, como sendo o novo objeto No (São ==  ou seja se modificar qualquer um estará modificando o outro também)
        referenciaNoEntradaPilha.setReferenciaNo(refAuxiliar); //Mudamos/setamos a referência do TOPO para o novo No
    }

    public No pop(){
        if (!this.isEmpty()) { //Se não estiver Vazia
            No noPoped = referenciaNoEntradaPilha;
            referenciaNoEntradaPilha = referenciaNoEntradaPilha.getReferenciaNo();
            return noPoped;
        }
        return null;
    }

        
    public No top(){
        return referenciaNoEntradaPilha;
     }
 

    public boolean isEmpty(){
        return referenciaNoEntradaPilha == null ? true : false;
        // (condição) ? VERDADEIRA (se realmente estiver vazia) : FALSE (se tiver elementos)
    }


    @Override
    public String toString() {
        String stringRetorno = "----------------\n";
        stringRetorno += "  Pilha\n";
        stringRetorno += "--------------\n";

        No noAuxiliar = referenciaNoEntradaPilha;

        while (true) {
            if (noAuxiliar != null) {
                stringRetorno += "[NO {dado= " + noAuxiliar.getDado() + " }]\n";
                noAuxiliar = noAuxiliar.getReferenciaNo(); //pega a referência do proximo no até chegar a BASE que aponta para null é então a condição cai no bloco else e para o laço.
            }else{
                break; //se a lista for vazia ele para o laço infinito do while
            }
        }

        stringRetorno += "==============\n";
                
        return stringRetorno;
    }

    


}//class
