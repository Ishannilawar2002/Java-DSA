package arrays;

/**
 * Finds the second-largest distinct value in an integer array in one pass.
 */
public final class SecondLargestElement {

    private SecondLargestElement() {
    }

    /**
     * @param numbers array containing at least two distinct values
     * @return the second-largest distinct value
     * @throws IllegalArgumentException when fewer than two distinct values exist
     */
    public static int find(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("numbers must not be null");
        }

        Integer largest = null;
        Integer secondLargest = null;

        for (int number : numbers) {
            if (largest == null || number > largest) {
                secondLargest = largest;
                largest = number;
            } else if (number < largest && (secondLargest == null || number > secondLargest)) {
                secondLargest = number;
            }
        }

        if (secondLargest == null) {
            throw new IllegalArgumentException("numbers must contain at least two distinct values");
        }

        return secondLargest;
    }
}
