import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String[] words = {"Апельсин", "Манго", "Апельсин", "Ананас",
                "Манго", "Клубника", "Личи", "Личи",
                "Кокос", "Ананас", "Клубника"};

        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        System.out.println("Уникальные слова:");
        for (String word : wordCount.keySet()) {
            System.out.println(word);
        }

        System.out.println("\nКоличество повторений каждого слова:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}