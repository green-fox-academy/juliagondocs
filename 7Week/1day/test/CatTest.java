import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CatTest {
    // Arrange -> létrehozom
    Cat cirmi = new Cat("Cirmi", 3,"black", "perzsa");

    @Before
    public void beforeTest() {
        System.out.println("Teszt elott");
        Cat cirmi = new Cat("Cirmi", 3,"black", "perzsa");
    }

    @After
    public void afterTest() {
        System.out.println("Teszt utan");
        cirmi = null;
    }

    @Test
    public void shouldCatAgeEqualsWithConstruktorGivenParameter() {
        // Act -> használom
        int expectedAge = 3;
        int resultAge = cirmi.age;
        // Assert
        assertEquals("Cirmi is not Cirmi, gebasz happened", resultAge, expectedAge);
    }

    @Test
    public void method() throws Exception{
            // Act -> használom
            String expectedName = "Cirmi";
            String resultName = cirmi.name;
            cirmi.setName("Cirmi te fogyatekos");
            // Assert
            assertEquals("Cirmi is not Cirmi, gebasz happened", resultName, expectedName);
    }

}