import java.util.HashMap;
import java.util.Iterator;

public class Camouflage {

    public int solution(String[][] clothes) {
    int answer = 0;
    HashMap<String, String> clothChoice = new HashMap<String, String>();
    clothChoice.put(clothes[0][1], clothes[0][0]);
    clothChoice.put(clothes[1][1], clothes[1][0]);
    clothChoice.put(clothes[2][1], clothes[2][0]);

    Iterator<String> keys = clothChoice.keySet().iterator();
    while (keys.hasNext()) {

        }

    return answer;
    }
}
