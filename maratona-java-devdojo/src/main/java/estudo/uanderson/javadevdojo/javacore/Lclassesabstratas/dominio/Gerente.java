package estudo.uanderson.javadevdojo.javacore.Lclassesabstratas.dominio;

public class Gerente extends Funcionario {//CLASSE CONCRETA QUE HERDA DA CLASSE B

    public Gerente(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public void calcularBonus() {
        this.salario = this.salario + this.salario * 0.1;
    }


//    @Override
//    public void imprime() {
////metodo implementado da classe Person, por causa da REGRA.
//    }

    @Override
    public String toString() {
        return "Gerente{" +
                "nome='" + nome + '\'' +
                ", salario=" + salario +
                '}';
    }
}//class
