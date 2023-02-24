import java.util.*;
public class RemoveNodesFromLinkedList {
    public ListNode removeNodes(ListNode head) {
        Stack<Integer> stk = new Stack<>();
        while(head != null){
            while(!stk.isEmpty() && stk.peek() < head.val){
                stk.pop();
            }
            stk.push(head.val);
            head = head.next;
        }
        ListNode res = null;
        while(!stk.isEmpty()){
            if(res == null){
                res = new ListNode(stk.pop());
            }else{
                ListNode tmp = new ListNode(stk.pop());
                tmp.next = res;
                res = tmp;
            }
        }
        return res;
    }
}
