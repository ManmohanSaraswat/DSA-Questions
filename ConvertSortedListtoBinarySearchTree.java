public class ConvertSortedListtoBinarySearchTree {
    private ListNode findMid(ListNode head, ListNode end) {
        ListNode slow = head, fast = head;
        while (fast != end) {
            if (fast.next == null || fast.next == end)
                break;
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private TreeNode solve(ListNode start, ListNode end) {
        if (start == end)
            return null;
        ListNode mid = findMid(start, end);
        TreeNode head = new TreeNode(mid.val, solve(start, mid), solve(mid.next, end));
        return head;
    }

    public TreeNode sortedListToBST(ListNode head) {
        return solve(head, null);
    }
}
