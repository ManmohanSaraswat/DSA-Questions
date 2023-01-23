import java.util.*;
public class FindtheTownJudge {
    public int findJudge(int n, int[][] trust) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 1; i <= n; i++) map.put(i, new HashSet<>());
        for(int i[]: trust){
            map.get(i[0]).add(i[1]);
        }
        int judge = -1;
        for(Map.Entry<Integer, Set<Integer>> entry: map.entrySet()){
            if(entry.getValue().size() == 0){
                judge = entry.getKey();
                break;
            }
        }
        if(judge == -1) return -1;
        for(Map.Entry<Integer, Set<Integer>> entry: map.entrySet()){
            if(entry.getKey() != judge && !entry.getValue().contains(judge)) return -1;
        }
        return judge;
    }
    public int findJudgeEfficient(int n, int[][] trust){
        int set[] = new int[n + 1];
        for(int i[]: trust){
            set[i[0]] --;
            set[i[1]] ++;
        }
        for(int i = 1; i <= n; i++){
            if(set[i] == n - 1) return i;
        }
        return -1;
    }
}
