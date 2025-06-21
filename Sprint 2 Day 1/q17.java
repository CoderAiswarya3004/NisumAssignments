import java.util.*;

public class SortStringsByLength {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Apple", "Banana", "Kiwi", "Orange");

        list.sort((a, b) -> a.length() - b.length());

        System.out.println(list); // Output: [Kiwi, Apple, Orange, Banana]
    }
}
