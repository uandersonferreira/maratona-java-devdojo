package estudo.uanderson.javadevdojo.javacore.ZZKjunit.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MangaTest {
    private Manga manga1;
    private Manga manga2;
    @BeforeEach
    public void setUp(){
        manga1 = new Manga("Martial Peak", 1815);
        manga2 = new Manga("Martial Peak", 1815);
    }

    @Test
    public void accessors_ReturnData_WhenInitialized(){
        assertEquals("Martial Peak",manga1.name());
        assertEquals(1815,manga1.episodes());
    }

    @Test
    public void equals_ReturnTrue_WhenObjectsAreTheSame(){
        assertEquals(manga1,manga2);//chama automaticamente o equals para comparar os objetos(compara os valores)
    }

    @Test
    public void hasCode_ReturnTrue_WhenObjectsAreTheSame(){
        assertEquals(manga1.hashCode(),manga2.hashCode());//chama automaticamente o equals para comparar os objetos(compara os valores)
    }

    @Test
    public void constructor_ThrowNullPointerException_WhenNameIsNull(){
        assertThrows(NullPointerException.class,() -> new Manga(null,24));
    }

  @Test
    public void isRecord_ReturnTrue_WhenCalledFromManga(){
        assertTrue(Manga.class.isRecord());
    }



}//class test