package testmaster.junit5;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Junit5Test extends BaseJunit5{

    @Order(2)
    @Test
    public void assertEqualsTest() {

        System.out.println("assertEquals");
        assertEquals("elma","elma");
        assertEquals("elma","armut","hata");
        System.out.println("assertEquals");
    }

    @Order(0)
    @Test
    public void assertTrueTest(){

        int x = 5;
        int y = 5;
        System.out.println("assertTrue");
        assertTrue(x==y,x + " esit degil " + y);
        System.out.println(x + " esit " + y);
    }

    @Order(1)
    @Test
    public void test1(){

        // login

        int x = 2;
        System.out.println("test1");
        assertNotNull(x);
    }

    @Order(4)
    @DisplayName("ParamsDeneme")
    @ParameterizedTest(name = "#{index} - [{0}]")
    @ValueSource(strings = {"elma","armut","seftali","uzum"})
    public void paramsTest1(String param){

        System.out.println(param);
    }

    @Order(3)
    @ParameterizedTest(name = "#{index} - [{0}] {1}")
    @CsvFileSource(resources = "/parameterized.csv", numLinesToSkip = 1)
    public void parameterizedTest(String ad, String soyad){

        System.out.println("Ad : " + ad);
        System.out.println("Soyad: " + soyad);
        assertAll("Ad Soyad Kontrol",
                () -> assertEquals("Yunus",ad, ad + " ad error"),
                () -> assertEquals("Balaman",soyad, soyad + " soyad error"),
                () -> assertNotNull(ad, "ad null")
        );
    }

}
