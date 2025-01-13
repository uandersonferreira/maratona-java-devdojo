package dio.estruturas-de-dados.no;

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

public class Main {
    public static void main(String[] args) {

        No<String> no1 = new No<>("Conteúdo no1");

        No<String> no2 = new No<>("Conteúdo no2");

        no1.setProximNo(no2);

        No<String> no3 = new No<>("Conteúdo no3");

        no2.setProximNo(no3);

        No<String> no4 = new No<>("Conteúdo no4");

        no3.setProximNo(no4);

        // no1 > no2 > no3 > no4 > null

        System.out.println(no1);
        System.out.println(no1.getProximNo());

        System.out.println("======================");

        System.out.println(no1);
        System.out.println(no1.getProximNo());
        System.out.println(no1.getProximNo().getProximNo());
        System.out.println(no1.getProximNo().getProximNo().getProximNo());
        System.out.println(no1.getProximNo().getProximNo().getProximNo().getProximNo());

    }

}
