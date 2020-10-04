package LinkedListForLeetCode;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    ListNode() {}

    public static ListNode create(int[] test) {
        ListNode dump = new ListNode(0);
        ListNode tmp = dump;
        for (int value : test) {
            ListNode node = new ListNode(value);
            tmp.next = node;
            tmp = node;
        }
        return dump.next;
    }

    public static void print(ListNode head) {
        ListNode tmp = head;
        while (tmp != null) {
            System.out.print(tmp.val);
            if (tmp.next != null)
                System.out.print("->");
            else System.out.println("");
            tmp = tmp.next;
        }
    }
}
