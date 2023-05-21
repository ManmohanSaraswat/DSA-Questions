public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode tail = swapPairs(head.next.next);
        ListNode temp = head.next;
        head.next = tail;
        temp.next = head;
        return temp;
    }
}
