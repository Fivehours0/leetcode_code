package LinkedListForLeetCode;

class Solution {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dump = new ListNode();
        dump.next = head;

        ListNode tmp = dump;
        boolean flag = false;
        while (tmp.next.next != null) {
            ListNode second = tmp.next;
            while (second.val == second.next.val) {
                flag = true;
                second.next = second.next.next;
                if (second.next == null) break;
            }
            if (flag) {
                flag = false;
                tmp.next = second.next;
            } else tmp = tmp.next;
            if (tmp.next == null) break;
        }
        return dump.next;
    }

    public static void main(String[] args) {
        // 1->2->3->3->4->4->5
        ListNode head = ListNode.create(new int[] {1, 1, 1, 2, 3});
        ListNode.print(head);
        ListNode.print(Solution.deleteDuplicates(head));
    }
}