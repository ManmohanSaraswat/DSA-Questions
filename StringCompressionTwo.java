import java.util.ArrayList;
import java.util.List;

public class StringCompressionTwo {
    static List<Integer> frequency;
    static int find(int n){
        if(n <= 1) return 1;
        if(n <= 9) return 2;
        if(n <= 99) return 3;
        return 4;
    }
    public static int solve(int k, int n){
        if(n == frequency.size() || k == 0) return 0;
        int min = Integer.MAX_VALUE;
        int x = frequency.get(n);
        for(int i = 1; i <= k && i <= x; i++){
            int a = find(x - i) + solve(k - i, n + 1);
            min = Math.min(min, a);
        }
        int b = solve(k, n + 1);
        return Math.min(min, b);
    }
    public static int getLengthOfOptimalCompression(String s, int k) {
        int count = 1, n = s.length();
        frequency = new ArrayList<>();
        for(int i = 1; i < n; i++){
            if(s.charAt(i) == s.charAt(i-1)) count ++;
            else{
                frequency.add(count);
                count = 1;
            }
        }
        frequency.add(count);

        return solve(k, 0);
    }
    public static void main(String[] args) {
        String s = "aaabcccdeeeeffffgh";
        getLengthOfOptimalCompression(s, 0);
        for(Integer i : frequency)
            System.out.print(i + " ");
    }
}
