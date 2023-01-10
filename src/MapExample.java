import java.util.*;
import java.util.Map.Entry;

public class MapExample
{
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String,Integer>();
        map.put("blue",96);
        map.put("hong",86);
        map.put("white",92);

        String name = null;
        int maxScore = 0;
        int totalScore = 0;

        Set<Entry<String,Integer>> entrySet = map.entrySet();
        Iterator<Entry<String, Integer>> entryIterator = entrySet.iterator();
        while (entryIterator.hasNext()){
            Entry<String ,Integer> entry = entryIterator.next();
            String k = entry.getKey();
            Integer v = entry.getValue();
            if(v > maxScore){
                name = k;
                maxScore = v;
            }
            totalScore += v;
        }
        System.out.println(name+", "+maxScore+", "+totalScore);
    }
}
