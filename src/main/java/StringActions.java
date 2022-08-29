import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StringActions {

    public static Map<String, Integer> getFrequencyMap(String string) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(string.split(""))
                .filter(s -> s.matches("\\w"))
                .forEach(s -> map.put(s, map.containsKey(s) ? map.get(s) + 1 : 1));
        return map;
    }

    public static void printFrequencyMap(Map<String, Integer> map) {
        map.forEach((key, value) -> {
            System.out.println(key + " - " + value + putCorrectEnding(value));
        });
    }

    public static int sumValues(Map<String, Integer> map) {
        return map.values().stream()
                .mapToInt(Integer::valueOf)
                .sum();
    }

    public static String putCorrectEnding(int num) {
        if (num % 100 >= 12 && num % 100 <= 14) {
            return " раз";
        } else if (num % 10 >= 2 && num % 10 <= 4) {
            return " раза";
        }
        return " раз";
    }

    public static void printClosestAverageFrequencyValue(Map<String, Integer> map, double averageValue) {
        double x = 2 * Double.MAX_VALUE;
        int value = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if ((Math.abs(entry.getValue() - averageValue)) < x) {
                x = Math.abs(entry.getValue() - averageValue);
                value = entry.getValue();
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == value) {
                System.out.print(entry.getKey() + Arrays.toString(entry.getKey().getBytes(StandardCharsets.UTF_8)) + " ");
            }
        }
    }
}
