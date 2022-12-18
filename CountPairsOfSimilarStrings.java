public class CountPairsOfSimilarStrings {
    public int similarPairs(String[] words) {
        int[][] freq = new int[words.length][26];
        for(int j = 0; j < words.length; j++){
            char[] arr = words[j].toCharArray();
            for(int i = 0; i < arr.length; i++){
                freq[j][arr[i] - 'a'] = 1;
            }
        }
        int count = 0;
        for(int i = 0; i < words.length; i++){
            for(int j = i + 1; j < words.length; j++){
                boolean flag = true;
                for(int k = 0; k < 26; k++){
                    if(freq[i][k] != freq[j][k]){
                        flag = false;
                        break;
                    }
                }
                if(flag) count ++;
            }
        }
        return count;
    }
}
