package vincent.datastruct.LinekedList;

/**
 * Created by Vincent on 2018/4/1.
 * email-address:674928145@qq.com
 * description:双向链表
 * 优点：在单向链表或循环链表中，只能沿着同一个方向查找数据，如果有链接断裂
 * 后面的链表就会丢失，而双向链表，每个节点都有头指针和尾指针相链接，
 * 使得链表的遍历更加方便，可以向前或向后遍历
 */

public class DoubleLinkedList<E> {

    private Node<E> first;

    private Node<E> last;

    static class Node<E> {
        E data;
        Node<E> pre;//指向上一个节点
        Node<E> next;//指向下一个节点
    }
}
