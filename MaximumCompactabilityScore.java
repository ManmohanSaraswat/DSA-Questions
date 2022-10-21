public class MaximumCompactabilityScore {
    int finalAns;

    public void solve(int[][] students, int[][] mentors, int s, int[] assignedArr) {
        if (s == students.length) {
            int count = 0;
            for (int i = 0; i < students.length; i++) {
                int m = assignedArr[i];
                for (int j = 0; j < mentors[m].length; j++) {
                    if (students[i][j] == mentors[m][j])
                        count++;
                }
            }
            finalAns = Math.max(count, finalAns);
            return;
        }
        for (int i = 0; i < mentors.length; i++) {
            int j = 0;
            for (; j < s; j++)
                if (assignedArr[j] == i)
                    break;
            if (j != s)
                continue;
            assignedArr[s] = i;
            solve(students, mentors, s + 1, assignedArr);
        }
    }

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        finalAns = Integer.MIN_VALUE;
        solve(students, mentors, 0, new int[students.length]);
        return finalAns;
    }
}