import java.util.*;
public class MinimumAdditiontoMakeIntegerBeautiful {
    private List<Integer> convertToList(long n){
        List<Integer> res = new ArrayList<>();
        while(n > 0){
            res.add((int)(n % 10));
            n = n / 10;
        }
        return res;
    }
    private boolean checkIfSatisfy(List<Integer> ll, int target){
        int sum = 0;
        for(int i: ll) sum += i;
        return sum <= target;
    }
    private long convertToNum(List<Integer> ll){
        long sum = 0;
        for(int i = ll.size() - 1; i >= 0; i--)
            sum = sum * 10 + ll.get(i);
        return sum;
    }
    private long solve(List<Integer> ll, int target){
        for(int i = 0; i < ll.size(); i++){
            while(!checkIfSatisfy(ll, target)){
                ll.set(i, (ll.get(i) + 1) % 10);
                if(ll.get(i) == 0){
                    int x = i + 1;
                    while(x < ll.size()){
                        if(ll.get(x) < 9){
                            ll.set(x, ll.get(x) + 1);
                            break;
                        }else{
                            ll.set(x, 0);
                        }
                        x ++;
                    }
                    if(x == ll.size()) ll.add(1);
                    break;
                }
            }
        }
        return convertToNum(ll);
    }
    public long makeIntegerBeautiful(long n, int target) {
        return solve(convertToList(n), target) - n;
    }
    private int sum(long n){
        int s = 0;
        while(n > 0){
            s += n % 10;
            n = n / 10;
        }
        return s;
    }
    public long makeIntegerBeautifulEfficient(long n, int target){
        long res = 0;
        for(long s = 1; sum(n) > target; s = s * 10){
            res += s * (10 - n % 10);
            n = n / 10 + 1;
        }
        return res;
    }
}
