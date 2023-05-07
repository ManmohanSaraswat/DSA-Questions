import java.util.ArrayList;
import java.util.List;

public class FindtheLongestValidObstacleCourseatEachPosition {
    private int upperBound(List<Integer> list, int target) {
        int start = 0, end = list.size() - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (target < list.get(mid))
                end = mid;
            else
                start = mid + 1;
        }
        return start;
    }

    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        List<Integer> list = new ArrayList<>();
        int[] res = new int[obstacles.length];
        for (int i = 0; i < obstacles.length; i++) {
            if (list.size() == 0 || list.get(list.size() - 1) <= obstacles[i]) {
                list.add(obstacles[i]);
                res[i] = list.size();
            } else {
                int ind = upperBound(list, obstacles[i]);
                list.set(ind, obstacles[i]);
                res[i] = ind + 1;
            }
        }
        return res;
    }
}
