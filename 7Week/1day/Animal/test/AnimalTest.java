import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {
    Animal pet = new Animal(50, 50);

    @Test
    public void testInit() {
        assertTrue(pet.hunger == 50 && pet.thirst == 50);
    }

    @Test
    public void testPlay() {
        pet.play();
        assertTrue(pet.hunger == 51 && pet.thirst == 51);
    }

    @Test
    public void testDrink() {
        pet.drink();
        assertTrue(pet.hunger == 50 && pet.thirst == 49);
    }

    @Test
    public void testEat() {
        pet.eat();
        assertTrue(pet.hunger == 49 && pet.thirst == 50);
    }
}