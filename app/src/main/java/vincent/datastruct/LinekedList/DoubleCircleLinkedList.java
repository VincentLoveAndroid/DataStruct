package vincent.datastruct.LinekedList;

/**
 * Created by Vincent on 2018/3/31.
 * email-address:674928145@qq.com
 * description:环形双向链表,LinkedHashMap--LruCache的主要数据结构，就是内部就是环形双向链表
 *
 */

public class DoubleCircleLinkedList<E> {
    private Node<E> first;
    private Node<E> last;

    static class Node<E> {
        E data;
        Node<E> pre;//指向上一个节点
        Node<E> next;//指向下一个节点
    }
}
