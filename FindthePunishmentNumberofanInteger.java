public class FindthePunishmentNumberofanInteger {
    private boolean sum(String v, int s) {
        if (s == 0 && v.length() == 0)
            return true;
        if (s < 0)
            return false;
        int n = v.length();
        if (n == 1) {
            if (s - Integer.parseInt(v) == 0)
                return true;
            return false;
        }
        boolean res = false;
        for (int i = 0; i < n; i++) {
            res = res || sum(v.substring(i + 1, n), s - Integer.parseInt(v.substring(0, i + 1)));
        }
        return res;
    }

    public int punishmentNumber(int n) {
        int s = 0;
        for (int i = 1; i <= n; i++) {
            if (sum(String.valueOf(i * i), i)) {
                s += i * i;
            }
        }
        return s;
    }
}
