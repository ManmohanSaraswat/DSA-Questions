import java.util.*;

public class RestoreIPAddresses {
    List<String> res;

    private void solve(String s, String prev, int k) {
        if (k == 4) {
            if (s.length() == 0)
                res.add(prev.substring(0, prev.length() - 1));
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (s.length() == i)
                break;
            String str = s.substring(0, i + 1);
            if (Integer.parseInt(str) > 255 || (str.length() > 1 && str.charAt(0) == '0'))
                break;
            solve(s.substring(i + 1, s.length()), prev + str + ".", k + 1);
        }
    }

    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        solve(s, "", 0);
        return res;
    }
}
