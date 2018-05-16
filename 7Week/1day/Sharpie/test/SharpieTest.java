import org.junit.Test;

import static org.junit.Assert.*;

public class SharpieTest {
    Sharpie littleSharpie = new Sharpie("brown", 100);

    @Test
    public void testUse() {
        assertTrue(90 == littleSharpie.use());
    }

    @Test
    public void testColor() {
        assertTrue(littleSharpie.color == "brown");
    }

    @Test
    public void testWidth() {
        assertTrue(littleSharpie.width == 100);
    }

    @Test
    public void testInkAmount() {
        assertTrue(littleSharpie.inkAmount == 100);
    }
}
