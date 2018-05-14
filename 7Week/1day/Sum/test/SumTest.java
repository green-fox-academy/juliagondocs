import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SumTest {
    Sum numbers = new Sum();

    @Test
    public void sumTest() {
        ArrayList<Integer> numbersHere = new ArrayList<>();
        numbersHere.add(1);
        numbersHere.add(2);
        numbersHere.add(3);
        assertEquals(Sum.sum(numbersHere), 6);
    }

    @Test
    public void sumTestWithEmptyList() {
        ArrayList<Integer> numbersHere = new ArrayList<>();
        assertEquals(Sum.sum(numbersHere), 0);
    }

    @Test
    public void sumTestWithOneElement() {
        ArrayList<Integer> numbersHere = new ArrayList<>();
        numbersHere.add(1);
        assertEquals(Sum.sum(numbersHere), 1);
    }

    @Test
    public void sumTestWithNull() {
        ArrayList<Integer> numbersHere = new ArrayList<>();
        numbersHere.add(null);
        assertEquals(Sum.sum(numbersHere), null);
    }

}