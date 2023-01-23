public class MaximumScoreWordsFormedbyLetters {
    private int solve(int[][] words, int n, int[] charCount, int[] score) {
        if (words.length == n)
            return 0;
        int a = solve(words, n + 1, charCount, score);
        boolean flag = true;
        for (int i = 0; i < 26; i++) {
            if (words[n][i] > charCount[i]) {
                flag = false;
                break;
            }
        }
        if (flag) {
            int tempScore = 0;
            for (int i = 0; i < 26; i++) {
                charCount[i] -= words[n][i];
                tempScore += (words[n][i] * score[i]);
            }
            tempScore += solve(words, n + 1, charCount, score);
            a = Math.max(a, tempScore);
            for (int i = 0; i < 26; i++) {
                charCount[i] += words[n][i];
            }
        }
        return a;
    }

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[][] wordsFreq = new int[words.length][26];
        int[] freq = new int[26];
        for (int i = 0; i < words.length; i++) {
            char[] arr = words[i].toCharArray();
            for (int j = 0; j < arr.length; j++) {
                wordsFreq[i][arr[j] - 'a']++;
            }
        }
        for (int i = 0; i < letters.length; i++)
            freq[letters[i] - 'a']++;
        return solve(wordsFreq, 0, freq, score);
    }
}
