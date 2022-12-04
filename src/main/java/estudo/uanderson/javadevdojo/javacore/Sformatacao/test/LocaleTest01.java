package estudo.uanderson.javadevdojo.javacore.Sformatacao.test;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class LocaleTest01 {
    public static void main(String[] args) {
        Locale localeItaly = new Locale("it", "IT");//estamos informando o idioma(it) e a localidade/paíse (IT). então é o italiano da Itália
        Locale localeCH = new Locale("it", "CH");// Já aqui é o italiano da Suiça.
        Locale localeIndia = new Locale("hi", "IN");
        Locale localeJapao = new Locale("ja", "JP");
        Locale localeHolanda = new Locale("nl", "NL");
        Locale localeBrazil = new Locale("pt", "BR");

        Calendar calendar = Calendar.getInstance();
        DateFormat df1 = DateFormat.getDateInstance(DateFormat.FULL, localeItaly);
        DateFormat df2 = DateFormat.getDateInstance(DateFormat.FULL, localeCH);
        DateFormat df3 = DateFormat.getDateInstance(DateFormat.FULL, localeIndia);
        DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL, localeJapao);
        DateFormat df5 = DateFormat.getDateInstance(DateFormat.FULL, localeHolanda);
        DateFormat df6 = DateFormat.getDateInstance(DateFormat.FULL, localeBrazil);

        System.out.println("Data Italiana na Itália: "+ df1.format(calendar.getTime()));
        System.out.println("Data Italiana na Suiça: "+ df2.format(calendar.getTime()));
        System.out.println("Data da India: "+ df3.format(calendar.getTime()));
        System.out.println("Data do Japão: "+ df4.format(calendar.getTime()));
        System.out.println("Data da Holanda: "+ df5.format(calendar.getTime()));
        System.out.println("Data do Brasil: "+ df6.format(calendar.getTime()));

        System.out.println("Paíse de referência Japão: "+localeBrazil.getDisplayCountry(localeJapao));
        //estamos imprimindo o país de uma determinada localidade, utilizndo como referência linguistica
        // o idioma de outro país, neste caso o japão. Portanto, esta sendo impresso Brasil, da forma que seria se estivessimos realmente no japão.

        System.out.println("Paíse de referência Holanda: "+localeBrazil.getDisplayCountry(localeHolanda));
        System.out.println("Paíse de referência Italia: "+localeBrazil.getDisplayCountry(localeItaly));
        System.out.println("Paíse de referência India: "+localeBrazil.getDisplayCountry(localeIndia));

    }//main
}//class
