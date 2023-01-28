import java.util.*;

public class DataStreamasDisjointIntervals {
    List<int[]> ranges;

    public DataStreamasDisjointIntervals() {
        ranges = new ArrayList<>();
    }

    public void addNum(int value) {
        int n = ranges.size();
        int index = Collections.binarySearch(ranges, new int[] { value, value }, (a, b) -> a[0] - b[0]);
        if (index < 0)
            index = -index - 1;
        if (index > 0 && index < n) {
            int prev[] = ranges.get(index - 1);
            int next[] = ranges.get(index);
            if ((next[0] <= value && next[1] >= value) || (prev[0] <= value && prev[1] >= value))
                return;
            if (prev[1] + 1 == value && next[0] - 1 == value) {
                ranges.set(index - 1, new int[] { prev[0], next[1] });
                ranges.remove(index);
            } else if (prev[1] + 1 == value) {
                ranges.set(index - 1, new int[] { prev[0], value });
            } else if (next[0] - 1 == value) {
                ranges.set(index, new int[] { value, next[1] });
            } else
                ranges.add(index, new int[] { value, value });
        } else if (index == 0) {
            if (ranges.size() == 0)
                ranges.add(new int[] { value, value });
            else {
                int next[] = ranges.get(0);
                if (next[0] <= value && next[1] >= value)
                    return;
                if (next[0] - 1 == value)
                    ranges.set(0, new int[] { value, next[1] });
                else
                    ranges.add(0, new int[] { value, value });
            }
        } else {
            if (index - 1 >= 0) {
                int[] prev = ranges.get(index - 1);
                if (prev[0] <= value && prev[1] >= value)
                    return;
                if (prev[1] + 1 == value)
                    ranges.set(index - 1, new int[] { prev[0], value });
                else
                    ranges.add(new int[] { value, value });
            } else
                ranges.add(new int[] { value, value });
        }
    }

    public int[][] getIntervals() {
        int[][] arr = new int[ranges.size()][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ranges.get(i);
        }
        return arr;
    }
}
