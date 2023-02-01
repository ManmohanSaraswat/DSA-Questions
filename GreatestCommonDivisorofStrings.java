public class GreatestCommonDivisorofStrings {
    private boolean check(String a, String b, String z){
        String c = z;
        while(c.length() < a.length()){
            if(a.startsWith(c)) c = c + z;
            else{
                if(c.length() < a.length()) return false;
            }
        }
        if(!c.equals(a)) return false;
        c = z;
        while(c.length() < b.length()){
            if(b.startsWith(c)) c = c + z;
            else{
                if(c.length() < b.length()) return false;
            }
        }
        if(!c.equals(b)) return false;
        return true;
    }
    public String gcdOfStrings(String str1, String str2) {
        String res = "";
        int n = Math.min(str1.length(), str2.length());
        for(int i = 0; i < n; i++){
            String c = str1.substring(0, i + 1);
            if(check(str1, str2, c)) res = c;
        }
        return res;
    }
    private int gcd(int a, int b){
        if(b != 0)
            return gcd(b, a % b);
        return a;
    }
    public String gcdOfStringsEfficient(String str1, String str2) {
        if((str1 + str2).equals(str2 + str1)){
            return str1.substring(0, gcd(str1.length(), str2.length()));
        }
        return "";
    }
}
