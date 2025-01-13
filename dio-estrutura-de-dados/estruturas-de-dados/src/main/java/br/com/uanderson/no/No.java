package br.com.uanderson.no;

public class No {

    private String conteudo;

    private No proximNo;

    public No(String conteudo) {
        this.conteudo = conteudo;
        this.proximNo = null;
    }


    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public No getProximNo() {
        return proximNo;
    }

    public void setProximNo(No proximNo) {
        this.proximNo = proximNo;
    }


    @Override
    public String toString() {
        return "No [conteudo=" + conteudo + "]";
    }

}
