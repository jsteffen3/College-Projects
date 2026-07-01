import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PairTest {

    /**
     * Test for creating a Pair of Integers
     */
    @Test
    public void testPairIntegerInteger() {
        Pair<Integer, Integer> pair = new Pair<>(1, 2);

        // Check the object values are 1 and 2
        // TODO: With generics, these should not use casting or intValue()
        // calls:
        assertEquals(1, pair.getFirst());
        assertEquals(2, pair.getSecond());
    }

    /**
     * Test for creating a Pair of Doubles
     */
    @Test
    public void testPairDoubleDouble() {
        Pair<Double, Double> pair = new Pair<>(1.0, 2.0);
        // TODO: Create a test similar to that above

        assertEquals(1, pair.getFirst(), .001);
        assertEquals(2, pair.getSecond(), .001);
    }

    /**
     * Test for creating a Pair of String/Integer
     */
    @Test
    public void testPairStringInteger() {
        Pair<String, Integer> pair = new Pair<>("1", 2);
        // TODO: Create a test similar to that above
        
        assertTrue(pair.getFirst().contentEquals("1"));
        assertEquals(2, pair.getSecond());
    }

    /**
     * Test for Pair of Integer toString()
     */
    // TODO: Uncomment this test when Pair is parameterized
    @Test
    public void testPairIntegersToString() {
    Pair<Integer, Integer> pair = new Pair<>(1, 2);
    
    // Do NOT change this check. Fix your Pair to match this format.
    assertEquals("<1, 2>", pair.toString());
    }

    /**
     * Test for a composite parameterized Pair
     */
    // TODO: Uncomment this test when Pair is parameterized
    @Test
    public void testPairHelperIntegerToString() {
    // Create a Pair with a parameterized type and check toString()
    Pair<Integer, Integer> sng = new Pair<>(5, 6);
    Pair<Pair<Integer, Integer>,Integer> pair = new Pair<>(sng, 10);
    
    // Do NOT change this check. Fix your Pair to match this format.
    assertEquals("<<5, 6>, 10>", pair.toString());
    }

}
