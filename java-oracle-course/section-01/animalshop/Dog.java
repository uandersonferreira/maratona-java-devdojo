public class Dog extends Animal{
    //instance field declarations
    private String name;
    private String barkNoise = "Woof";//latidoBarulho
    private double weight;

    public Dog(String name, String breed, double weight, String colour){
        super(colour, breed);
        this.name = name;
        this.weight = weight;
    }

    public Dog(String name, String breed, String barkNoise, double weight, String colour){
        super(colour, breed);
        this.name = name;
        this.barkNoise = barkNoise;
        this.weight = weight;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getWeight(){
        return this.weight;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }

    public void bark(){
        System.out.println(barkNoise);
    }

    public void bark(String barkNoise){
        System.out.println(barkNoise);
    }
    

}//end class Dog