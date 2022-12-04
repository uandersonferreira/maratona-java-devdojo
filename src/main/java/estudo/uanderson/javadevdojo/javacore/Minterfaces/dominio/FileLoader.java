package estudo.uanderson.javadevdojo.javacore.Minterfaces.dominio;

public class FileLoader implements DataLoader, DataRemove{
    //as classes podem implementar várias interfaces

    @Override
    public void load() {
        System.out.println("Carregando os dados de um arquivo");
    }

    @Override
    public void remove() {
        System.out.println("Removendo dados de um arquivo");
    }

    @Override
    public void checkPermission() {
        System.out.println("Checando permissões em um arquivo");
    }

}//class
