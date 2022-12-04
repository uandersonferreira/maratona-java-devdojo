package estudo.uanderson.javadevdojo.javacore.Jmodificadofinal.dominio;

public class Carro {

    private String nome;
    public static  final double VELOCIDADE_LIMITE = 250;
    public final Comprador COMPRADOR = new Comprador();

    /*
    -Uma constante é uma váriavel que não pode ter o seu valor
    alterado. Sua declaração é Tudo em UPPER_CASE e quando tiver mais
    de uma palavra separa-se por underscore "_". E normalmente as constantes
    são declaradas como static final.

    -A palavra reservada "final" indica que uma váriavel é
        uma constante e, é necessário iniciar a váriavel com
        um valor, não permite o valor default.

        -public final Comprador COMPRADOR = new Comprador();
        Neste caso, estamos dizendo que a referência em memória do objeto Comprador()
        não poderá se alterada, no entanto os seus valores(váriaveis podem ser alteradas os valores)

        -Aula 76-80
     */

   /*
    static {

        public static  final double VELOCIDADE_LIMITE = 250;
    }

    */

    public final void imprime(){
        System.out.println(this.nome);
        //o final vêm antes do void
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
