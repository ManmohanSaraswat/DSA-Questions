import java.util.HashSet;
import java.util.Set;

public class CheckIfTheSentenceIsAPanagram {
    
    public boolean checkIfPangramApproach1(String sentence) {
        int n = sentence.length(), present = 0;
        for(int i = 0; i < n; i++){
            int ch = sentence.charAt(i) - 'a';
            present = present | (1 << ch);
        }
        if(present == (1 << 26) - 1) return true;
        return false;
    }

    public boolean checkIfPangramApproach2(String sentence){
        int n = sentence.length();
        if(n < 26) return false;
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < n; i++)
            set.add(sentence.charAt(i));
        if(set.size() == 26) return true;
        return false;
    }
}