package estudo.uanderson.javadevdojo.javacore.Ycolecoes.test;

import estudo.uanderson.javadevdojo.javacore.Ycolecoes.domain.Smartphone;

public class EqualsTest01 {
    public static void main(String[] args) {
        Smartphone s1 = new Smartphone("1ABC1","iphone");
        Smartphone s2 = new Smartphone("1ABC1","iphone");
        System.out.println(s1.equals(s2));
    }
}
/*
System.out.println(nome == nome2);//true
System.out.println(nome == nome3);//false
  valor de referência da memória que está sendo comparado ao invès do valor do atributo.
   Por isso é errado quando utilizado com Strings

s1 = s2; comportameto em memória
s1 = {Smartphone@656} "Smartphone{serialNumber='1ABC1', marca='iphone'}"
s2 = {Smartphone@656} "Smartphone{serialNumber='1ABC1', marca='iphone'}"

-> omportamento normal
s1 = {Smartphone@656} "Smartphone{serialNumber='1ABC1', marca='iphone'}"
s2 = {Smartphone@657} "Smartphone{serialNumber='1ABC1', marca='iphone'}"
 */
