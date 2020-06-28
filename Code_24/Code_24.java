/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * <p>
 * 算法:
 * 首先创建一个dummy node    null->1->2->3->4
 * tmp指向null, 交换1,2
 * tmp指向tmp.next.next,即2, 交换3,4
 * <p>
 * 知识点
 * 本道题目设计的知识点也就是链表。对我影响最大的不是这道题目的算法，而是对我编程思维的一种提升。
 * 提升的地方主要有
 * 1.通过制造一个dummy node, 使得头节点和第二个节点位置的交换与第三个节点和第四个节点的位置交换步骤一致。
 * 这就设计到while的实质，是不断的重复做着相同的事情，所以需要思考的是，完成某个动作需要做出哪些步骤
 * 2.对中间变量命名，有助于对代码的理解。本题中建立了变量firstNode, secondNode, thirdNode, 使得代码清晰
 * 3.while中的终止条件的理解。最后停在哪，终止条件就是啥。
 */
package Code_24;

import LinkedNode.LinkedNode;
import LinkedNode.LinkedList;

public class Code_24 {
    public static LinkedNode<Integer> swapPairs(LinkedNode<Integer> head) {
        if (head == null || head.getNext() == null) return head;
        LinkedNode<Integer> res = new LinkedNode<Integer>(-1); // 结果链表
        res.setNext(head); // 结果链表创造一个哑节点
        LinkedNode<Integer> tmp = res;

        while (tmp.getNext() != null && tmp.getNext().getNext() != null) {
            LinkedNode<Integer> firstNode = tmp.getNext();
            LinkedNode<Integer> secondNode = tmp.getNext().getNext();
            LinkedNode<Integer> thirdNode = tmp.getNext().getNext().getNext();

            tmp.setNext(secondNode);
            secondNode.setNext(firstNode);
            firstNode.setNext(thirdNode);

            tmp = tmp.getNext().getNext();
        }
        return res.getNext();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList1 = new LinkedList<Integer>();
        LinkedList<Integer> linkedList2 = new LinkedList<Integer>();
        linkedList1.add(1);
        linkedList1.add(2);
        linkedList1.add(3);
        linkedList1.add(4);
        linkedList2.setHead(swapPairs(linkedList1.getHead()));
        linkedList2.print();
    }

}
