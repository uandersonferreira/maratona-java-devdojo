package estudo.uanderson.javadevdojo.javacore.Sformatacao.test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatTest02 {
    public static void main(String[] args) {

        Locale localeBR = new Locale("pt","BR");
        Locale localeJP = Locale.JAPAN;
        Locale localeIT = Locale.ITALY;

        NumberFormat[] nfa = new NumberFormat[4];
         nfa[0] = NumberFormat.getCurrencyInstance();
         nfa[1] = NumberFormat.getCurrencyInstance(localeBR);
         nfa[2] = NumberFormat.getCurrencyInstance(localeJP);
         nfa[3] = NumberFormat.getCurrencyInstance(localeIT);

         double valor = 100_000;

        for (NumberFormat numberFormat : nfa) {
            numberFormat.setMaximumFractionDigits(2);
            System.out.println(numberFormat.format(valor));
        }

        String valorString = "￥100,000";

        try {
            System.out.println(nfa[2].parse(valorString));
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }//main
}//class
/*
  parou -> Aula 117
NumberFormat é uma classe abstrata portanto assim, como as demais
não se pode instancia-la. seu acesso ocorre por meio do:
        NumberFormat n = NumberFormat.getInstance();


java.text.ParseException: Unparseable number: "10_000"
Tal erro é gerado pois ao ser tentar fazer o parse do valor monetario
é necessário informar o valor da string formatada de acordo com o padrao
monetário da moeda, exemplo:

        String valorString = "￥100,000";

        try {
            System.out.println(nfa[2].parse(valorString));
        } catch (ParseException e) {
            e.printStackTrace();
        }

resultado : 100000

neste exemplo foi utilizado a conversão, de acordo com o padrão monetário
do Japão( nfa[2] ).
        String valorString = "￥100,000";



 */
