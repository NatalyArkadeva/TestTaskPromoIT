import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        int number = (int) (Math.random() * 100000);

        String string;
        try {
            string = new HttpActions().httpGetRequest("http://numbersapi.com/" + number + "/trivia");
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
            return;
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
