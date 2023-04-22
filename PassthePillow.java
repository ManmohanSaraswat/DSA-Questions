public class PassthePillow {
    public int passThePillow(int n, int time) {
        int count = 1;
        boolean flag = true;
        for (int i = 1; i <= time; i++) {
            if (count == n)
                flag = false;
            else if (count == 1)
                flag = true;

            if (flag)
                count++;
            else
                count--;
        }
        return count;
    }
}
