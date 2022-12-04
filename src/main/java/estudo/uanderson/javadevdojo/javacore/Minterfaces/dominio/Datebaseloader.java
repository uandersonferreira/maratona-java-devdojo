package estudo.uanderson.javadevdojo.javacore.Minterfaces.dominio;

public class Datebaseloader implements DataLoader, DataRemove{
    //as classes podem implementar várias interfaces

    @Override
    public void load() {
        System.out.println("Carregando os dados do banco de dados");
    }

    @Override
    public void remove() {
        System.out.println("Removendo dados de um banco de dados");
    }

    @Override
    public void checkPermission() {
        System.out.println("Checando permissões no banco de dados");
    }

    public static void retrieveMaxDataSize(){
        System.out.println("Dentro do retrieveMaxDataSize da classe Datebaseloader ");
        //por não ser permitido a sobreescrita de um método statico e criado
        //dois métodos com o mesmo nome, porém pertencem a classe distintas.
    }

    /*
    -Quando queremos utilizar uma interface nas nossas classes,  utilizamos
    a clausula "implments" + NomeDaInterface. Portando quando for
    Infercade para Classe --> implements
    Classe para Classe --> extends


     */
}//class
