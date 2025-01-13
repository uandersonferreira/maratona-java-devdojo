package br.com.uanderson.generics;

class No<T> {

    private T conteudo;

    private No<T> proximNo;

    public No(T conteudo) {
        this.conteudo = conteudo;
        this.proximNo = null;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public No<T> getProximNo() {
        return proximNo;
    }

    public void setProximNo(No<T> proximNo) {
        this.proximNo = proximNo;
    }

    @Override
    public String toString() {
        return "No [conteudo=" + conteudo + "]";
    }

}
