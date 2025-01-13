package estudo.uanderson.javadevdojo.javacore.ZZKjunit.service;

import estudo.uanderson.javadevdojo.javacore.ZZKjunit.domain.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonServiceTest {
    private Person adult;
    private Person notAdult;
    private  PersonService personService;

    @BeforeEach//será executado todas as vezes antes de qualquer teste
    public void setUp(){
        adult = new Person(18);//cria-se um novo objeto cada vez que é executado
        notAdult = new Person(15);
        personService = new PersonService();//caso não ocorra alterações num obj, não têm problema utilizar o mesmo objeto varias vezes.
        //podendo ser inicializado no momento de sua criação: private  PersonService personService = new PersonService();
    }
    @Test
    @DisplayName("A person should be not adult when age is lower than 18")
    void isAdult_ReturnsFalse_WhenAgeIsLowerThan18() {
        assertFalse(personService.isAdult(notAdult));

    }
    @Test
    @DisplayName("A person should be adult when age is greater or equal than 18")
    void isAdult_ReturnsTrue_WhenAgeIsGreateThan18() {
        assertTrue(personService.isAdult(adult));
    }

    @Test
    @DisplayName("Should thow NullPointerException with message when person is null")
    void isAdult_ShouldThrowException_WhenPersonIsNull() {
        assertThrows(IllegalArgumentException.class,
                () -> personService.isAdult(null), "Person can't be null");
    }

    @Test
    @DisplayName("Should return list with only adults")
    void filterRemovingNotAdult_ReturnListWithAdultOnly_WhenListOfPersonWithAdultIsPassed() {
        List<Person> personList = List.of(
                new Person(14),
                new Person(21),
                new Person(30)

        );

        Assertions.assertEquals(2, personService.filterRemovingNotAdult(personList).size());
    }



}//class Test