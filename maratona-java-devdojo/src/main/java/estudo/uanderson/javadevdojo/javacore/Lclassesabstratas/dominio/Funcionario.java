package estudo.uanderson.javadevdojo.javacore.Lclassesabstratas.dominio;

public abstract class  Funcionario extends Pessoa {
    protected String nome;
    protected double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
        calcularBonus();
    }

    public abstract void calcularBonus();

    @Override
    public void imprime() {
        System.out.println("Imprimindo....(do method da classe Funcionário)");
    }

    /*
    CLASSES ABSTRATAS SÃO COMO TEMPLETES/MODELOS/SUPERCLASSES A SER SEGUIDAS
    POR CLASSES QUE EXTENDEM DELA/HERDAM DELA.
    -UMA CLASSE ABSTRATADA NÃO PODE SER INSTÂNCIADA, NÃO PODE CRIAR NOVOS OBJETOS (FUNCIONARIO F = NEW FUNCIONARIO() )
    -E NÃO PODEMOS MISTURAR FINAL COM ABSTRACT

    -MÉTODOS ABSTRATOS SÃO UTILIZADOS PARA QUANDO QUEREMO QUE AS SUBCLASSES REALIZE UMA
    IMPLEMENTAÇÃO DO MÉTODO COM SUA PROPRIA LÓGICA(TIPO CALCULAR O BONUS DE FUNCIONÁRIOS DIFERENTES),
    PORTANDO ELE FUNCIONA COMO UM SINALIZADOR, FLEG, QUE INDICA QUE QUANDO CRIAMOS SUBCLASSES QUE
    HERDAM DA SUPERCLASSE É NECESSÁRIO IMPLEMENTAR O METODO ABSTRATO.
    -LEMBRANDO QUE O METODO ABSTRATO DA SUPERCLASSE NÃO POSSUEM MAIS CORPO/BLOCO:
      Ex: public abstract void calcularBonus();

   -SENDO ASSIM, METODOS ABSTRATOS GARANTEM QUE TODAS AS SUBCLASSES, devem POSSUIR O
   O METODO calcularBonus() da classe Funcionario;

   -É NUMA CLASSE ABSTRACT PODEMOS TER MÉTODOS ABSTRACT OU NÃO.
   -NÃO PODEMOS TER MÉTODOS ABSTRACT EM CLASSES NÃO ABSTRACT(CLASSES CONCRETAS), POIS
   MÉTODOS ABSTRACT SÓ PODEM EXISTIR DENTRO DE CLASSES ABSTRACTS.




   */
}
