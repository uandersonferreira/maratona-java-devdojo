package estudo.uanderson.javadevdojo.javacore.ZZHpadroesdeprojeto.test;

import estudo.uanderson.javadevdojo.javacore.ZZHpadroesdeprojeto.dominio.Country;
import estudo.uanderson.javadevdojo.javacore.ZZHpadroesdeprojeto.dominio.Currency;
import estudo.uanderson.javadevdojo.javacore.ZZHpadroesdeprojeto.dominio.CurrencyFactory;

public class CurrencyFactoryTest01 {
    public static void main(String[] args) {
        Currency currency = CurrencyFactory.newCurrency(Country.BRAZIL);
        System.out.println(currency.getSymbol());
    }
}
