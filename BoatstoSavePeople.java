import java.util.Arrays;

public class BoatstoSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int start = 0, end = people.length - 1, sum = 0, count = 0, res = 0;
        while (start <= end) {
            if (sum < limit && count < 2) {
                if (sum + people[end] <= limit) {
                    sum += people[end];
                    end--;
                } else if (sum + people[start] <= limit) {
                    sum += people[start];
                    start++;
                }
                count++;
            } else {
                sum = 0;
                count = 0;
                res++;
            }
        }
        if (sum <= limit && count <= 2)
            res++;
        return res;
    }
}
