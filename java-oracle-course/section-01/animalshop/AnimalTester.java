package animalshop;

public class AnimalTester{
    public static void main(String args[]) {
        Dog dog1 = new Dog("Bailey", "Boerboel", "arf-arf",80.2, "brown");
        Fish fish = new Fish("red", "GoldFish", "cold");

        System.out.println("Dog name: " + dog1.getName());
        System.out.println("Dog breed: " + dog1.getBreed());
        System.out.print("Dog noise: ");
        dog1.bark();
        System.out.println("Dog weight: " + dog1.getWeight());
        System.out.println("Dog colour: " + dog1.getWeight());

        System.out.println("===============================");

        System.out.println("Fish breed: " + fish.getBreed());
        System.out.println("Fish water type: " + fish.getWaterType());
        System.out.println("Fish colour: " + fish.getColour());


    }//main
}//class

/*
class Dog {
    // Declarações dos campos de instância
    private String name;
    private String breed; // raça
    private String barkNoise = "Woof"; // barulho do latido
    private double weight;

    // Construtor 1
    public Dog(String name, String breed, double weight) {
        this.name = name;
        this.breed = breed;
        this.weight = weight;
    }

    // Construtor 2
    public Dog(String name, String breed, String barkNoise, double weight) {
        this.name = name;
        this.breed = breed;
        this.barkNoise = barkNoise;
        this.weight = weight;
    }

    // Métodos de acesso (getters e setters)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return this.breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    // Métodos de comportamento
    public void bark() {
        System.out.println(barkNoise);
    }

    public void bark(String barkNoise) {
        System.out.println(barkNoise);
    }
}

 */