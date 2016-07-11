package co.ga.junittesting;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class HelpfulUnitTest {
    private static final double DELTA = 1e-15;
    @Test
    public void usefulMethods() throws Exception {
        assertEquals(4, 2 + 2);
        assertTrue(true);
        assertFalse(false);
        assertNull(null);
        assertNotNull("Not null");
    }
    @Test
    public void multiplyTest(){

        int actual = MathUtils.multiply(2,5,6);
        int expected = 60;

        assertEquals(expected, actual);
    }
    @Test
    public void addTest(){
        int actual = MathUtils.add(5, 4, 3);
        int expected = 12;

        assertEquals(expected,actual);
    }
    @Test
    public void multiplyTestDecimals(){

        double actual = MathUtils.multiply(2.5,5);
        double expected = 12.5;

        assertEquals(expected, actual, DELTA);
    }
    @Test
    public void addTestDecimals(){
        double actual = MathUtils.add(5.4, 6.3, 12.2);
        double expected = 23.9;

        assertEquals(expected,actual, DELTA);
    }
    @Test
    public void squareTest(){
        int actual = MathUtils.square(3);
        int expected = 9;
        assertEquals(expected,actual);
    }
    @Test
    public void squareTestDecimals(){
        double actual = MathUtils.square(2.5);
        double expected = 6.25;
        assertEquals(expected,actual, DELTA);
    }
    @Test
    public void pythagTest(){
        int actual = MathUtils.pythagorean(2,4);
        int expected = 20;
        assertEquals(expected,actual);
    }
    @Test
    public void pythagTestDeicmals(){
        double actual = MathUtils.pythagorean(2.5,4.5);
        double expected = 26.5;
        assertEquals(expected,actual, DELTA);
    }
}