import java.util.*;

public class ListComparer {

    static List<Integer> getCommonValues(List<Integer> first, List<Integer> second) {
        Set<Integer> a = new HashSet<>(first);
        Set<Integer> b = new HashSet<>(second);

        a.retainAll(b);  // keep only common elements

        return new ArrayList<>(a);
    }

    public static void main(String[] args) {
        List<Integer> groupA = Arrays.asList(10, 20, 30, 40, 50);
        List<Integer> groupB = Arrays.asList(40, 50, 60, 70);

        List<Integer> shared = getCommonValues(groupA, groupB);

        System.out.println("Matching entries: " + shared);
    }
}
