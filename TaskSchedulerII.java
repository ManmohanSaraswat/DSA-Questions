import java.util.*;

public class TaskSchedulerII {
    public long taskSchedulerII(int[] tasks, int space) {
        long day = 0;
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            if (map.containsKey(tasks[i])) {
                long lastDay = map.get(tasks[i]);
                day = Math.max(day + 1, lastDay + space + 1);
                map.put(tasks[i], day);
            } else {
                day++;
                map.put(tasks[i], day);
            }
        }
        return day;
    }
}
