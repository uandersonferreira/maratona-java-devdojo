package br.com.uanderson.pilha.teste02;

public class No {

    private Object object;

    private No referenciaNo;

    
    public No() {}

    public No(Object object) {
        this.object = object;
        this.referenciaNo = null;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public No getReferenciaNo() {
        return referenciaNo;
    }

    public void setReferenciaNo(No referenciaNo) {
        this.referenciaNo = referenciaNo;
    }

    @Override
    public String toString() {
        return "No [object=" + object + "]";
    }


}//class
