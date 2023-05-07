import java.util.*;

public class FrequencyTracker {
    Map<Integer, Integer> map;
    int[] arr;

    public FrequencyTracker() {
        map = new HashMap<>();
        arr = new int[100009];
    }

    public void add(int number) {
        int prev = map.getOrDefault(number, 0);
        map.put(number, prev + 1);
        if (prev != 0) {
            arr[prev]--;
        }
        arr[prev + 1]++;
    }

    public void deleteOne(int number) {
        int freq = map.getOrDefault(number, 0);
        if (freq != 0) {
            if (freq == 1) {
                map.remove(number);
            } else {
                map.put(number, freq - 1);
            }
            arr[freq]--;
            arr[freq - 1]++;
        }
    }

    public boolean hasFrequency(int frequency) {
        return arr[frequency] > 0;
    }
}
