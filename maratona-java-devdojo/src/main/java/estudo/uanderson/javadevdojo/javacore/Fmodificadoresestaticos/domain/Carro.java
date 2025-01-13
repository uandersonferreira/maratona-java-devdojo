package estudo.uanderson.javadevdojo.javacore.Fmodificadoresestaticos.domain;

public class Carro {
    private String nome;
    private double velocidadeMaxima;
    private static double velocidadeLimite = 250;

    //Static, significa dizer que esse atributo pertence/está ligado a classe é, não mais ao Objeto.
    //Static = Pertence à classe/dá classe.  

    public Carro(String nome, double velocidadeMaxima) {
        this.nome = nome;
        this.velocidadeMaxima = velocidadeMaxima;

    }

    public void imprime() {
        System.out.println("---------------------");
        System.out.println("Nome: " + this.nome);
        System.out.println("Velocidade Máxima: " + this.velocidadeMaxima);
        System.out.println("Velocidade Limite: " + Carro.velocidadeLimite);
    }

    public static void setVelocidadeLimite(double velocidadeLimite) {
        Carro.velocidadeLimite = velocidadeLimite;
        /*
        Não se pode utilizar variáveis, não estáticas dentro, de métodos staticos.
        Pois, há a possibilidade de não existir um espaço em memória reservado para o atributo.
        No entanto, o contrário é permitido. Acessar atributos statics dentro, de métodos não static.

    Métodos static podem ser criados, quando não estiverem, acessando nenhum atributo
   da instância, ou seja, do Objeto representado pela Classe.

         */
    }

    public static double getVelocidadeLimite() {
        return Carro.velocidadeLimite;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(double velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }


}//class
