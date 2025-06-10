import java.util.*;

public class UniqueSorter {

    static Set<Integer> extractSortedDistinct(int[] input) {
        TreeSet<Integer> output = new TreeSet<>();
        for (int value : input) {
            output.add(value);
        }
        return output;
    }

    public static void main(String[] args) {
        int[] data = {7, 3, 5, 1, 9, 5, 2, 3};

        Set<Integer> sortedSet = extractSortedDistinct(data);

        System.out.println("Unique values in ascending order: " + sortedSet);
    }
}
