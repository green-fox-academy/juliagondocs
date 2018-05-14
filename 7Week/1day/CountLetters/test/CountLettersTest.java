import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class CountLettersTest {
    @Test
    public void countTesterA() {
        HashMap<Character, Integer> result = CountLetters.countLetters("aaaabbbbcccc");
        int temp = result.get('a');
        assertEquals(temp, 4);
    }

    @Test
    public void countTesterC() {
        HashMap<Character, Integer> result = CountLetters.countLetters("aaaabbbbcccc");
        int temp = result.get('c');
        assertEquals(temp, 4);
    }
}