import java.util.PriorityQueue;
import java.util.Queue;

public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> que = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null)
                que.add(node);
        }
        ListNode res = new ListNode(0), temp = res;
        while (!que.isEmpty()) {
            res.next = que.poll();
            if (res.next.next != null)
                que.offer(res.next.next);
            res = res.next;
        }
        return temp.next;
    }
}
