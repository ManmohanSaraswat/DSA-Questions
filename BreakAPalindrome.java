public class BreakAPalindrome {
    public String breakPalindromeThinking(String palindrome) {
        if(palindrome.length() == 1) return "";
        char[] arr = palindrome.toCharArray();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 'a'){
                char temp = arr[i];
                arr[i] = 'a';
                while(arr[i] != temp){
                    if(checkPalindrome(arr) == false) return new String(arr);
                    ++arr[i];
                }
            }
        }
        arr[arr.length-1] = 'b';
        return new String(arr);
    }
    private boolean checkPalindrome(char[] arr) {
        int start = 0, end = arr.length - 1;
        while(start < end){
            if(arr[start] != arr[end]) return false;
            start ++; end --;
        }
        return true;
    }
    public String breakPalindromeSimpleTrick(String palindrome) {
        if(palindrome.length() == 1) return "";
        char[] arr = palindrome.toCharArray();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 'a' && arr.length/2 != i){
                arr[i] = 'a';
                return new String(arr);
            }
        }
        arr[arr.length-1] = 'b';
        return new String(arr);
    }
}