import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LengthofLongestFibonacciSubsequence{
    public int lenLongestFibSubseqEfficient(int[] arr) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for(int i: arr) set.add(i);
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                int next = arr[i] + arr[j], temp = 0, prev = arr[j];
                while(set.contains(next)){
                    temp ++;
                    int x = next;
                    next = next + prev;
                    prev = x;
                }
                res = Math.max(res, 2 + temp);
            }
        }
        return res >= 3 ? res : 0;
    }
    private int maxLen(int[] arr, int start, int next){
        int res = 0;
        while(true){
            int ind = Arrays.binarySearch(arr, start + 1, arr.length, next);
            if(ind > start){
                next = next + arr[start];
                start = ind;
            }else
                break;
            res++;
        }
        return res == 0 ? 0 : res + 2;
    }
    public int lenLongestFibSubseq(int[] arr) {
        int res = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                int next = arr[j] + arr[i];
                res = Math.max(res, maxLen(arr, j, next));
            }
        }
        return res;
    }
}