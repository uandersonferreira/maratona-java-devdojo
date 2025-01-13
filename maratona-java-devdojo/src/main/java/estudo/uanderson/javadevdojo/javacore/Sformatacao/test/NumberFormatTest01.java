package estudo.uanderson.javadevdojo.javacore.Sformatacao.test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatTest01 {
    public static void main(String[] args) {

        Locale localeBR = new Locale("pt","BR");
        Locale localeJP = Locale.JAPAN;
        Locale localeIT = Locale.ITALY;

        NumberFormat[] nfa = new NumberFormat[4];
         nfa[0] = NumberFormat.getInstance();
         nfa[1] = NumberFormat.getInstance(localeBR);
         nfa[2] = NumberFormat.getInstance(localeJP);
         nfa[3] = NumberFormat.getInstance(localeIT);

         double valor = 100_000.25;

        for (NumberFormat numberFormat : nfa) {
            numberFormat.setMaximumFractionDigits(2);
            System.out.println(numberFormat.format(valor));
        }

        String valorString = "10000";

        try {
            System.out.println("Try: "+nfa[1].parse(valorString));
        } catch (ParseException e) {
            e.printStackTrace();
        }
/*
Observações: Apesar da sintaxe: 10_000; se valida para os números,
quando se está trabalhando com a converção de um string para numero(parse)
a sintaxe: "10_000"; possui algumas particularidades, tais como: o underline(_) é considerado
como um um character invalido(pois não é visto como um número ou parte dele), portando ao ser fazer
o passe o java quando se depara com um character inválido, irá ignora
tudo o que estiver a sua direita, por isso que a impressa saiu 10;

        String valorString = "10_000";

        try {
            System.out.println(nfa[1].parse(valorString));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        resultado : 10
 */

    }//main
}//class
/*
NumberFormat é uma classe abstrata portanto assim, como as demais
não se pode instancia-la. seu acesso ocorre por meio do:
        NumberFormat n = NumberFormat.getInstance();

 */
