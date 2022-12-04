package estudo.uanderson.javadevdojo.javacore.Sformatacao.test;

import java.util.Locale;

public class LocaleTest02 {
    public static void main(String[] args) {

        System.out.println(Locale.getDefault());//para saber o idioma padrão do sistema.
        String[] isoCountries = Locale.getISOCountries();//para saber a nomeclatura dos paises
        String[] isoLanguages = Locale.getISOLanguages();//para saber a nomeclatura dos idiomas/linguas

        for (String isoLanguage : isoLanguages) {//forEach interando sobre o array de strings para imprimir todas as nomeclaturas dos idiomas
            System.out.print(isoLanguage + " ");
        }
        System.out.println();

        for (String isoCountry : isoCountries) {//forEach interando sobre o array de strings para imprimir todas as nomeclaturas dos Paises
            System.out.print(isoCountry + " ");
        }


    }//main
}//class
