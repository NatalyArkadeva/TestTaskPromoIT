import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class StringActionsTest {
    private String string = "a bb ccc";
    private Map<String, Integer> map = new HashMap<>();

    @Test
    public void getFrequencyMapTest() {
        Assertions.assertEquals(3, StringActions.getFrequencyMap(string).size());
    }

    @Test
    public void sumValuesTest() {
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        Assertions.assertEquals(6, StringActions.sumValues(map));
    }

    @Test
    public void putCorrectEndingTest() {
        Assertions.assertEquals(" раз", StringActions.putCorrectEnding(1112));
        Assertions.assertEquals(" раза", StringActions.putCorrectEnding(2));
    }
}
