package LinkedListForLeetCode;

/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * O(n log n) 时间复杂度所以使用归并排序
 */
class Solution1 {
    public ListNode sortList(ListNode head) {
        ListNode tmp = head;
        int len = 0;
        // 得出链表的长度
        while (tmp != null) {
            tmp = tmp.next;
            len++;
        }

        ListNode dummy = new ListNode();
        ListNode pre = new ListNode();
        dummy.next = head;
        int interval = 1;
        while (interval < len) {
            pre = dummy;
            tmp = dummy.next;
            while (tmp != null) {
                int i = interval;
                ListNode h1 = tmp;

                // 分割出interval长度的两个链表h1和h2
                while (i != 0 && tmp!=null) {
                    tmp = tmp.next;
                    i--;
                }
                /*
                h2为null时，直接break
                这种情况出现在h2为null时，比如1，2，4，3，5
                当interval为2时，第二次迭代h1=5而h2=null，当h2为null时，不需要对h1，h2合并
                因为当interval为4时，会对h1，h2合并，不影响结果
                 */
                if (i != 0) break;

                int j = interval;
                ListNode h2 = tmp;
                while (j != 0 && tmp!=null) {
                    tmp = tmp.next;
                    j--;
                }

                // 计算h1和h2两链表的长度
                int len1 = interval;
                int len2 = interval - j;

                // 合并h1和h2
                while (len1 != 0 && len2 != 0) {
                    if (h1.val < h2.val) {
                        pre.next = h1;
                        h1 = h1.next;
                        len1--;
                    } else {
                        pre.next = h2;
                        h2 = h2.next;
                        len2--;
                    }
                    pre = pre.next;
                }

                pre.next = len1 != 0 ? h1 : h2;
                while (len1 > 0 || len2 > 0) {
                    pre = pre.next;
                    len1--;
                    len2--;
                }
                pre.next = tmp;
            }
            interval *= 2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.create(new int[] {-1,5,3,4,0});
//        ListNode head = ListNode.create(new int[] {4, 2, 1, 3});
        ListNode.print(new Solution1().sortList(head));
    }
}
