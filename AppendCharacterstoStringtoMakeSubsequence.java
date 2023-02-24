public class AppendCharacterstoStringtoMakeSubsequence {
    public int appendCharacters(String s, String t) {
        char[] arr = s.toCharArray();
        char[] brr = t.toCharArray();
        int i1 = 0, i2 = 0;
        while(i1 < arr.length && i2 < brr.length){
            if(arr[i1] == brr[i2]){
                i1 ++;
                i2 ++;
            }else{
                i1++;
            }
        }
        return brr.length - i2;
    }
}
