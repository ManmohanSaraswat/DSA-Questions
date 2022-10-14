class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class DeleteTheMiddleOfALinkedList {
    public ListNode deleteMiddleApproach1(ListNode head) {
        if (head.next == null)
            return null;
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            n++;
        }
        n = n / 2;
        temp = head;
        for (int i = 0; i < n - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }

    public ListNode deleteMiddleApproach2(ListNode head) {
        if (head.next == null)
            return null;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            if (fast.next != null) {
                fast = fast.next.next;
            } else
                fast = fast.next;
            if (fast == null)
                continue;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
    public ListNode deleteMiddleApproach3(ListNode head) {
        if(head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head.next.next;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}