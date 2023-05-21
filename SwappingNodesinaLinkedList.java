public class SwappingNodesinaLinkedList {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode first = null, second = head, temp = head;
        for (int i = 1; temp != null; i++) {
            if (i == k) {
                first = temp;
            }
            if (i > k)
                second = second.next;
            temp = temp.next;
        }
        int t = first.val;
        first.val = second.val;
        second.val = t;
        return head;
    }
}
