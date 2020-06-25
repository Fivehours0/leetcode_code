package LinkedNode;

/**
 * Single Linked List
 *
 * @author duzhihui
 * @version 1.0
 */
public class LinkedList<T> implements ILinkedList<T> {
    private LinkedNode<T> head;

    /**
     * judge to weather Linked List is empty
     *
     * @return if it's empty, return true
     */
    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * get the length of Linked List
     *
     * @return
     */
    @Override
    public int length() {
        int length = 0;
        LinkedNode<T> p = this.head;
        while (p != null) {
            length++;
            p = p.getNext();
        }
        return length;
    }

    /**
     * get the value in node base on index
     *
     * @param index notice the index start from zero
     * @return data saved in node
     */
    @Override
    public T get(int index) {
        try {
            this.isIllegalIndex(index);

            LinkedNode<T> p = this.head;
            for (int i = 0; i < index; i++) {
                p = p.getNext();
            }
            return p.getData();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * set node's data
     *
     * @param index start from zero
     * @param data  saved in node
     */
    @Override
    public void set(int index, T data) {
        try {
            this.isIllegalIndex(index);
            LinkedNode<T> p = this.head;
            for (int i = 0; i < index; i++) {
                p = p.getNext();
            }
            p.setData(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * add a node in the index
     * @param index start from zero
     * @param data saved in node
     * @return true if add success
     */
    @Override
    public boolean add(int index, T data) {
        try {
            this.isIllegalIndex(index);

            LinkedNode<T> tmp = new LinkedNode<T>(data);
            LinkedNode<T> p = this.head;
            if(index==0) {
                this.head = tmp;
                tmp.setNext(p);
                return true;
            }

            // 插入非头节点的位置
            for (int i = 0; i < index-1; i++) {
                p = p.getNext();
            }
            tmp.setNext(p.getNext());
            p.setNext(tmp);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * add node in tail
     *
     * @param data saved in node
     * @return true if add success
     */
    @Override
    public boolean add(T data) {
        LinkedNode<T> p = this.head;
        if (this.head == null) {
            this.head = new LinkedNode<T>(data);
            return true;
        }
        while (p.getNext() != null) {
            p = p.getNext();
        }
        p.setNext(new LinkedNode<T>(data));
        return true;
    }

    /**
     * delete node base on index
     * @param index start from zero
     * @return true if remove success
     */
    @Override
    public boolean remove(int index) {
        // 空链表,则返回false
        if (this.head==null) {
            System.out.println("empty linked list");
            return false;
        }

        try {
            this.isIllegalIndex(index);
            LinkedNode<T> p = this.head;
            // 删除头节点
            if(index==0) {
                if (this.head.getNext()==null) this.head = null;
                else {
                    this.head = this.head.getNext();
                }
                return true;
            }

            // 删除尾节点
            int indexMax = this.length()-1;
            if (index==indexMax) {
                for (int i = 0; i < indexMax-1; i++) {
                    p = p.getNext();
                }
                p.setNext(null);
                return true;
            }

            // 删除中间节点
            for (int i = 0; i < index - 1; i++) {
                p = p.getNext();
            }
            p.setNext(p.getNext().getNext());
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public void clear() {
        this.head = null;
    }

    /**
     * print value in Linked List
     */
    @Override
    public void print() {
        LinkedNode<T> p = this.head;
        if (p == null) {
            System.out.println("empty Linked List");
            return;
        }
        while (p != null) {
            System.out.println(p.getData());
            p = p.getNext();
        }
    }

    @Override
    public boolean contains(Object data) {
        return false;
    }

    /**
     *
     * @param index the node's position in linked list
     * @throws Exception if index < 0 || index > this.length() - 1
     */
    private void isIllegalIndex(int index) throws Exception {
        if (index < 0 || index > this.length() - 1)
            throw new Exception("Illegal Index, length of linked list is " + this.length());
    }

    public LinkedNode<T> getHead() { return head; }

    public void setHead(LinkedNode<T> head) {
        this.head = head;
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(1);
        linkedList.add(12);
//        linkedList.set(1, 2);
//        System.out.println(linkedList.get(1));
//        linkedList.add(1, 23);
//        linkedList.remove(1);
        linkedList.print();
        linkedList.clear();
    }
}