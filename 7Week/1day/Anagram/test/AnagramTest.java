import org.junit.Test;

import static org.junit.Assert.*;

public class AnagramTest {

    @Test
    public void testAnagrama() {
        assertTrue(Anagram.areEquals("alma", "lama"));
    }

}