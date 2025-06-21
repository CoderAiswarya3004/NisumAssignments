import java.util.*;

public class SortByLength {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("java", "spring", "a", "functional");

        words.sort(Comparator.comparingInt(String::length));

        System.out.println(words); 
    }
}
