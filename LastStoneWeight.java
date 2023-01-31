import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> pQue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i: stones) pQue.offer(i);
        while(pQue.size() > 1){
            int a = pQue.poll();
            int b = pQue.poll();
            if(a != b) pQue.offer(a - b);

            if(pQue.size() == 0) return 0;
        }
        return pQue.poll();
    }
}
