package Code_21;
import LinkedNode.LinkedNode;
import LinkedNode.LinkedList;

public class Code_21 {

    public LinkedNode<Integer> mergeTwoLists(LinkedNode<Integer> l1, LinkedNode<Integer> l2) {
        LinkedNode<Integer> ret = new LinkedNode<Integer>();
        LinkedNode<Integer> tRet = ret;
        while(l1!=null && l2!=null){
            if(l1.getData() > l2.getData()) {
                tRet.setNext(l2);
                l2 = l2.getNext();
            }
            else {
                tRet.setNext(l1);
                l1 = l1.getNext();
            }
            tRet = tRet.getNext();
        }
        tRet.setNext(l1==null ? l2:l1);
        return ret.getNext();
    }

    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<Integer>();
        LinkedList<Integer> l2 = new LinkedList<Integer>();
        l1.add(1);
        l1.add(3);
        l1.add(5);
        l2.add(2);
        l2.add(4);
        l2.add(5);
        Code_21 code_21 = new Code_21();
        LinkedList<Integer> res = new LinkedList<Integer>();
        res.setHead(code_21.mergeTwoLists(l1.getHead(), l2.getHead()));
        res.print();
    }

}
