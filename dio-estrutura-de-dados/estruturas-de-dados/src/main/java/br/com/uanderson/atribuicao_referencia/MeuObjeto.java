package br.com.uanderson.atribuicao_referencia;

class MeuObjeto {

    Integer num;

    public MeuObjeto(Integer num) {
        this.num = num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return " " + this.num;
    }
}
