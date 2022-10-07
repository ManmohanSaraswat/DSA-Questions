import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MyCalendarTwo {
    static Map<Integer, Integer> map;

    public MyCalendarTwo() {
        map = new TreeMap<>();
    }
    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int count = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int val = entry.getValue();
            count += val;
            if(count > 2){
                map.put(start, map.get(start)-1);
                map.put(end, map.get(end)+1);
                return false;
            }
        }
        return true;
    }
}
class MyCalendarTwoEfficient{
    static List<int[]> events;
    static List<int[]> doubleBookings;
    private boolean intersect(int a, int b, int x, int y){
        if(x >= b || y <= a) return false;
        return true;
    }
    public MyCalendarTwoEfficient() {
        events = new ArrayList<>();
        doubleBookings = new ArrayList<>();
    }
    public boolean book(int start, int end){
        for(int [] pair: doubleBookings){
            if(intersect(pair[0], pair[1], start, end)) return false;
        }
        for(int [] pair: events){
            if(intersect(pair[0], pair[1], start, end)){
                doubleBookings.add(new int[]{Math.max(pair[0], start), Math.min(pair[1], end)});
            }
        }
        events.add(new int[]{start, end});
        return true;
    }
}