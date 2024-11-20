package dio.estruturas-de-dados.pilha.teste02;

public class No<T> {

    private T object;

    private No<T> referenciaNo;

    
    public No() {}

    public No(T object) {
        this.object = object;
        this.referenciaNo = null;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public No<T> getReferenciaNo() {
        return referenciaNo;
    }

    public void setReferenciaNo(No<T> referenciaNo) {
        this.referenciaNo = referenciaNo;
    }


    @Override
    public String toString() {
        return "No [object=" + object + "]";
    }



}//class
