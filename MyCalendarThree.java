import java.util.Map;
import java.util.TreeMap;

public class MyCalendarThree {

    static Map<Integer, Integer> map;
    public MyCalendarThree(){
        map = new TreeMap<>();
    }
    
    public int book(int start, int end){
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int count = 0, temp = 0;
        for(Map.Entry<Integer, Integer> event: map.entrySet()){
            temp += event.getValue();
            count = Math.max(temp, count);
        }
        return count;
    }
}