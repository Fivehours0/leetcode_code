package LinkedNode;

/**
 * Created by zejian on 2016/10/21.
 * 链表顶级接口
 */
public interface ILinkedList<T> {
    /**
     * 判断链表是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 链表长度
     * @return
     */
    int length();

    /**
     * 获取元素
     * @param index start from zero
     * @return
     */
    T get(int index);

    /**
     * set node's data
     * @param index start from zero
     * @param data saved in node
     */
    void set(int index, T data);

    /**
     * 根据index添加结点
     * @param index start from zero
     * @param data saved in node
     * @return
     */
    boolean add(int index, T data);

    /**
     * 添加结点
     * @param data saved in node
     * @return
     */
    boolean add(T data);

    /**
     * 根据index移除结点
     * @param index start from zero
     * @return true if remove success
     */
    boolean remove(int index);

    /**
     * 清空链表
     */
    void clear();

    /**
     * 是否包含data结点
     * @param data
     * @return
     */
    boolean contains(T data);

    /**
     * 输出格式
     * @return
     */
    String toString();

    /**
     * 打印链表
     */
    void print();
}