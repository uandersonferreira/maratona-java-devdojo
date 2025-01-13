public class Animal{
    private String colour;
    private String breed;//raça 

    public Animal(String colour, String breed ){
        this.colour = colour;
        this.breed = breed;
    }

    public String getColour(){
        return colour;
    }

    public void setColour(String colour){
        this.colour = colour;
    }

    public String getBreed(){
        return this.breed;
    }

    public void setBreed(String breed){
        this.breed = breed;
    }
}//class