import java.util.HashSet;
import java.util.Set;

public class NumberOfGoodWaysToSplitAString {
    public int numSplitsUsingSet(String s){
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int []prefix = new int[n];
        int []suffix = new int[n];
        prefix[0] = suffix[n-1] = 1;
        set.add(s.charAt(0));
        for(int i = 1; i < n; i++){
            if(!set.contains(s.charAt(i))){
                prefix[i] = prefix[i-1] + 1;
                set.add(s.charAt(i));
            }else
                prefix[i] = prefix[i-1];
        }
        set.clear();
        set.add(s.charAt(n-1));
        for(int i = n-2; i >= 0; i--){
            if(!set.contains(s.charAt(i))){
                suffix[i] = suffix[i+1] + 1;
                set.add(s.charAt(i));
            }else
                suffix[i] = suffix[i+1];
        }
        int count = 0;
        for(int i = 0; i < n-1; i++)
            if(prefix[i] == suffix[i+1]) count ++;
        return count;
    }
    public int numSplitsUsingArray(String s) {
        int n = s.length();
        int []freq = new int[26];
        int []freq1 = new int[26];
        int []arr = new int[n];
        int []brr = new int[n];
        int count = 0;
        for(int i = 0; i < n; i++){
            int t = s.charAt(i) - 'a';
            if(freq[t] == 0){
                count ++; 
            }
            freq[t] = 1;
            arr[i] = count;
        }
        count = 0;
        for(int i = n-1; i >= 0; i--){
            int t = s.charAt(i) - 'a';
            if(freq1[t] == 0){
                count ++; 
            }
            freq1[t] = 1;
            brr[i] = count;
        }
        count = 0;
        for(int i = 0; i < n-1; i++){
            if(arr[i] == brr[i+1]) count++;
        }
        return count;
    }    
}
