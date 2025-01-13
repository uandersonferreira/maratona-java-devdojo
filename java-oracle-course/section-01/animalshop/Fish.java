package animalshop;

public class Fish extends Animal{
    private String waterType;

    public Fish(String colour, String breed, String waterType){
        super(colour, breed);
        this.waterType = waterType;
    }

    public String getWaterType(){
        return waterType;
    }

    public void setWaterType(String waterType){
        this.waterType = waterType;
    }
}//class