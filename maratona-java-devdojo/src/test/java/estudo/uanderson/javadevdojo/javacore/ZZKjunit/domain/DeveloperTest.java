package estudo.uanderson.javadevdojo.javacore.ZZKjunit.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeveloperTest {

    @Test
    public void instaceOf_ExecutesChildClassMethod_WhenObjectIsOfChildType(){
        Employee employeeDeveloper = new Developer("1","Java");
//        if (employeeDeveloper instanceof Developer){
//            Developer developer = (Developer) employeeDeveloper;
//            assertEquals("Java", developer.getMainLanguage());
//        }

        if (employeeDeveloper instanceof Developer developer){//Pattern Matching for instanceof introduz a declaração de uma varial que guarda o typo do obj caso seja verdadeiro evitando o cast posteriomente.
            assertEquals("Java", developer.getMainLanguage());
        }

    }//method-test

}