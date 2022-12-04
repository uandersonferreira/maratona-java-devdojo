package estudo.uanderson.javadevdojo.javacore.Ycolecoes.domain;

import java.util.Comparator;

public class Smartphone implements Comparator<Smartphone>{
    private String serialNumber;
    private String marca;

    public Smartphone(String serialNumber, String marca) {
        this.serialNumber = serialNumber;
        this.marca = marca;
    }

    public Smartphone() {
    }

    @Override
    public int compare(Smartphone smartphone, Smartphone t1) {
        return smartphone.getMarca().compareTo(t1.getMarca());
    }

    //REGRAS A SER SEGUIDAS AO SE ALTERAR A LÓGICA DO MÉTODO EQUALS DE ACORDO COM A DOCUMENTAÇÃO
    //1-Reflexivo: x.quals(x) tem que ser true para tudo que for diferente de null
    //2-Simétrico: para x e y diferentes de null, se x.equals(y) == true logo, y.equals(x) == true
    //3-Transitividade: para x,y,z diferentes de null, se x.equals(y) == true, e x.equals(z) == true logo, y.equals(z) == true
    //4-Consistente: x.equals(x) sempre retorna true se x for diferente de null
    //5-Para x diferente de null, c.equals(null) tem que retornar false.
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;//5
        if (this == obj) return true;//4 this.equals(obj)
        if(this.getClass() != obj.getClass()) return false;
        Smartphone smartphone = (Smartphone) obj;
        return serialNumber != null && serialNumber.equals(smartphone.serialNumber);
        /*
        Devemos definir quais atributos fazem com quer um
        objeto seja dado, com iguais. Idependende da sua posição de memória.
         */
    }

    //se x.equals(y) == true, y.hasCode() == x.hasCode()
    //y.hasCode() == x.hasCode(), não necessariamente o equals de y.equals(x) tem quer ser true;
    //x.equals(y) == false, o hasCode de x têm quer ser diferente do der y.
    //y.hasCode() != x.hasCode, x.equals(y) deverá ser false.
    @Override
    public int hashCode() {
        return  serialNumber == null ? 0 : this.serialNumber.hashCode();
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "serialNumber='" + serialNumber + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
