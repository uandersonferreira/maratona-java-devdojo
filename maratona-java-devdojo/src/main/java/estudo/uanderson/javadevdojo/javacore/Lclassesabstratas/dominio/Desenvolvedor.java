package estudo.uanderson.javadevdojo.javacore.Lclassesabstratas.dominio;

public class Desenvolvedor extends Funcionario{//CLASSE CONCRETA QUE HERDA DA CLASSE B
    public Desenvolvedor(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public void calcularBonus() {
        this.salario = this.salario + this.salario * 0.05;
    }

//    @Override
//    public void imprime() {
//          //metodo implementado da classe Person, por causa da REGRA.
//    }

    @Override
    public String toString() {
        return "Desenvolvedor{" +
                "nome='" + nome + '\'' +
                ", salario=" + salario +
                '}';
    }

}
