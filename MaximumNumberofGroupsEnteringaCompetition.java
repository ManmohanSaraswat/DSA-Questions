import java.util.Arrays;

public class MaximumNumberofGroupsEnteringaCompetition {
    public int maximumGroups(int[] grades) {
        Arrays.sort(grades);
        int prevSum = grades[0], prevCount = 1, curSum = 0, curCount = 0, res = 1;
        for (int i = 1; i < grades.length; i++) {
            curSum += grades[i];
            curCount++;
            if (curSum > prevSum && curCount > prevCount) {
                prevSum = curSum;
                prevCount = curCount;
                curSum = 0;
                curCount = 0;
                res++;
            }
        }
        return res;
    }
}
