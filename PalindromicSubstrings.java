public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int n = s.length(); // getting the size of string
        int count = 0;
        for(int i = 0; i < n; i++){
            
            count ++;
            int left = i - 1;
            int right = i + 1;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
                left --;
                right ++;
                count ++;
            }
            if(i + 1 < n && s.charAt(i) == s.charAt(i+1)){
                count ++;
                left = i - 1;
                right = i + 2;
                while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
                    left --;
                    right ++;
                    count ++;
                }
            }
        }
        return count;
    }
}
