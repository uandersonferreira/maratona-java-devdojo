package estudo.uanderson.javadevdojo.javacore.Tresourcebundle.test;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest01 {
    public static void main(String[] args) {

        ResourceBundle bundle = ResourceBundle.getBundle("message", new Locale("en", "US"));
        boolean world = bundle.containsKey("World");//verifica se existe a chave "World" no aqruivo properties base "message".
        System.out.println(world);

        System.out.println( bundle.getString("hello"));
        System.out.println( bundle.getString("good.morning"));
        System.out.println("--------------------------");

        bundle = ResourceBundle.getBundle("message",new Locale("pt","BR"));
        System.out.println(bundle.getString("hello"));
        System.out.println(bundle.getString("good.morning"));




    }
}
/*
Para poder pegar a mensagem do novo arquivo .propeties as chaves
definidas em ambos devem ser as mesma, se não, será lançado uma exception:
Ex: Chave = Valor

hello = Hello
good.morning = Good Morning
---------------------------
hello = Olá!
good.morning = Bom dia!


Locale("fr","CA")
messages_fr_CA.properties
messages_fr.properties// caso o java não encontre um arquivo com esse nome baseado na localização passada, ele irá buscar um novo arquivo baseado na localização padrão do sistema
messages_pt_BR.properties
messages_pt.properties// É caso não encontre irá buscar por um arquivo com o nome base
messages.properties // é Caso não exista irá lancar uma exception

Obs: Tratamentos de exceções em vários idiomas é mais recomendado
definir em somente 1 idioma(inglês) no arquivo base (messages.properties)

 */