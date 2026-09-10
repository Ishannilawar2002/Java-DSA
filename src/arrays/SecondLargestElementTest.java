package arrays;

public final class SecondLargestElementTest {

    private SecondLargestElementTest() {
    }

    public static void main(String[] args) {
        assertEquals(9, SecondLargestElement.find(new int[]{10, 9, 4, 2}));
        assertEquals(3, SecondLargestElement.find(new int[]{3, 5, 5, 2}));
        assertEquals(-7, SecondLargestElement.find(new int[]{-7, -2, -10}));
        assertEquals(Integer.MIN_VALUE,
                SecondLargestElement.find(new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE}));

        assertThrows(() -> SecondLargestElement.find(new int[]{7, 7}));
        assertThrows(() -> SecondLargestElement.find(new int[]{7}));
        assertThrows(() -> SecondLargestElement.find(null));

        System.out.println("All SecondLargestElement tests passed.");
    }

    private static void assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError("Expected " + expected + ", but got " + actual);
        }
    }

    private static void assertThrows(Runnable action) {
        try {
            action.run();
            throw new AssertionError("Expected IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            // Expected outcome.
        }
    }
}
