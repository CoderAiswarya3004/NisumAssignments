import java.util.*;

public class WordCounter {

    static String sanitizeInput(String text) {
        return text.toLowerCase().replaceAll("[^a-z ]", "");
    }

    static Map<String, Integer> getWordCounts(String content) {
        Map<String, Integer> freqMap = new HashMap<>();
        String[] terms = sanitizeInput(content).split("\\s+");

        for (String word : terms) {
            if (!word.isBlank()) {
                freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
            }
        }

        return freqMap;
    }

    static void showByFrequency(Map<String, Integer> freqMap) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(freqMap.entrySet());
        list.sort((e1, e2) -> e2.getValue() - e1.getValue());

        System.out.println("\nWords Ranked by Frequency:");
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Paste or type a paragraph:");
        String data = sc.nextLine();

        Map<String, Integer> result = getWordCounts(data);
        showByFrequency(result);

        sc.close();
    }
}
