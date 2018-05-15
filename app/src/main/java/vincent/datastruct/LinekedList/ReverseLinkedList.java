package vincent.datastruct.LinekedList;

/**
 * Created by Vincent on 2018/3/13.
 * email-address:674928145@qq.com
 * description:单链表反转
 * <p>
 * 将原链表：0->1->2->3 反转为新链表：0<-1<-2<-3
 */

public class ReverseLinkedList {

    private Node head;//保存头节点指针

    static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }

    private void initNode() {
        Node<Integer> node0 = new Node<>(0);
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node2.next = node4;

        head = node0;
    }

    /**
     * 主要有三个指针，(必须同时有pre指针和next指针，不然current断链重连会找不到原来current的next指针)
     * 当前节点的上一个节点pre，当前节点current，当前节点下一个节点next指针，
     * 每次循环，实现一个节点的断开，将当前节点链接pre节点。移动pre,current节点指针，继续循环
     *
     * 时间复杂度：
     * 空间复杂度：
     */
    private void reverseLinkedList() {
        Node pre = null;//头结点开始的前一个节点为null
        Node current = head;//当前节点从头结点开始
        Node next = null;//当前节点的下一个节点
        //每次循环，实现一个节点的断开，将当前节点链接pre节点。移动pre,current节点指针，继续循环
        while (current != null) {
            next = current.next;//得到当前节点的下一个节点，暂存
            current.next = pre;//原链断开，当前节点指向pre节点
            pre = current;//移动pre指针到当前节点
            current = next;//移动当前节点指针到next节点
        }
        //头结点指向最后一个节点，方便从头结点开始遍历
        head = pre;
    }

    private void print() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println(head);
    }

    public static void main(String arg0[]) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.initNode();
        list.print();

        list.reverseLinkedList();
        list.print();
    }

    private void test() {
        //三个指针，记录当前节点current节点的前一个节点，后一个节点
        Node pre = null;
        Node current = head;
        Node next = null;
        //每次循环，实现一个节点的断开，将当前节点链接pre节点。移动pre,current节点指针，继续循环
        while (current != null) {
            //记录下一个节点
            next = current.next;
            //断链重连到上一个节点
            current.next = pre;
            //指针右移
            pre = current;
            current = next;
        }
        //将头结点指向最后一个节点，方便遍历
        head = pre;
    }
}
