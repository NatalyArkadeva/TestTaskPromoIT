import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String string = null;
        try {
            string = HttpActions.httpGetRequest("http://numbersapi.com/random/trivia");

        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
            System.out.println(string);

            Map<String, Integer> map = StringActions.getFrequencyMap(string);
            System.out.println("Частоты:");
            StringActions.printFrequencyMap(map);

            System.out.printf("Среднее значение частоты %d/%d = %f\n", StringActions.sumValues(map), map.size(),
                    (double) StringActions.sumValues(map) / map.size());

            System.out.print("Символы, которые соответствуют условию наиболее близкого значения частоты к среднему значению: ");
            StringActions.printClosestAverageFrequencyValue(map, (double) StringActions.sumValues(map) / map.size());
    }
}
