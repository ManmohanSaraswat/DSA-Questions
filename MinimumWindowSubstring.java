public class MinimumWindowSubstring{
    public String minWindow(String a, String b) {
        char s[] = a.toCharArray(), t[] = b.toCharArray();
        int n = s.length, m = t.length, ans = Integer.MAX_VALUE, left = 0, right = 0;
        int sMap[] = new int[60], tMap[] = new int[60];
        String res = "";
        for(int i = 0; i < m; i++){
            tMap[t[i] - 'A'] ++;
        }
        while(right < n){
            sMap[s[right] - 'A'] ++;
            right ++;
            if(checkIfEqual(sMap, tMap)){
                while(sMap[s[left] - 'A'] > tMap[s[left] - 'A']){
                    sMap[s[left] - 'A'] --;
                    left ++;
                }
                if(ans > right - left + 1){
                    ans = right - left + 1;
                    res = a.substring(left, right);
                }
            }
        }
        return res;
    }
    private boolean checkIfEqual(int[] sMap, int[] tMap){
        for(int i = 0; i < 60; i++){
            if(tMap[i] > sMap[i]) return false;
        }
        return true;
    }
}