/**
 * 题目描述
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 算法
 * 1.使用了双指针，一个指向原链表(p1), 一个指向结果链表(p2), 临时节点(tmp)
 * p1.val=1 p2=null tmp.val=p1.val tmp.next=p2 p1=p1.next p2=tmp
 * p1.val=2 tmp.val=p1.val tmp.next=p2 p1=p1.next p2=tmp
 * ...
 */

package Code_206;
import LinkedNode.LinkedNode;
import LinkedNode.LinkedList;

public class Code_206 {
    public static LinkedNode<Integer> reverseList(LinkedNode<Integer> head) {
        LinkedNode<Integer> res = null;
        while(head!=null){
            LinkedNode<Integer> tmp = new LinkedNode<Integer>();
            tmp.setData(head.getData());
            tmp.setNext(res);
            res = tmp;
            head = head.getNext();
        }
        return res;
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList1 = new LinkedList<Integer>();
        LinkedList<Integer> linkedList2 = new LinkedList<Integer>();
        linkedList1.add(1);
        linkedList1.add(2);
        linkedList1.add(3);
        linkedList1.add(4);
        linkedList1.add(5);
        linkedList2.setHead(reverseList(linkedList1.getHead()));
        linkedList1.print();
        linkedList2.print();
    }
}
