public class CalculateDigitSumofaString {
    public String digitSum(String s, int k) {
        StringBuilder res = new StringBuilder(s);
        while (res.length() > k) {
            StringBuilder str = new StringBuilder();
            int n = res.length(), i = 0;
            while (i < n) {
                int toReach = Math.min(i + k, n), temp = 0;
                while (i < toReach) {
                    temp += (res.charAt(i) - '0');
                    i++;
                }
                str.append(temp);
            }
            res = str;
        }
        return res.toString();
    }
}
