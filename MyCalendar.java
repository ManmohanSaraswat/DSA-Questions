import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MyCalendar{
    static Map<Integer, Integer> events;
    public MyCalendar(){
        events = new TreeMap<>();
    }
    public boolean book(int start, int end){
        events.put(start, events.getOrDefault(start, 0) + 1);
        events.put(end, events.getOrDefault(end, 0)-1);
        int count = 0;
        for(Map.Entry<Integer, Integer> event: events.entrySet()){
            count += event.getValue();
            if(count > 1){
                events.put(start, events.getOrDefault(start, 0) - 1);
                events.put(end, events.getOrDefault(end, 0) + 1);
                return false;
            }
        }
        return true;
    }
}

class MyCalendarEfficient {
    static List<int []> events;
    private boolean intersect(int a, int b, int x, int y){
        if(b <= x || y <= a) return false;
        return true;
    }
    public MyCalendarEfficient(){
        events = new ArrayList<>();
    }

    public boolean book(int start, int end){
        for(int [] event : events){
            if(intersect(event[0], event[1], start, end)) return false;
        }
        events.add(new int[] {start, end});
        return true;
    }
}
