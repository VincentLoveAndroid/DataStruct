package vincent.datastruct.LinekedList;

/**
 * Created by Vincent on 2018/3/31.
 * email-address:674928145@qq.com
 * description:单链表，由头节点到尾节点一次链接起来，尾节点的next节点指向null。
 * 优点：插入和删除十分容易
 * 缺点：维护头节点十分重要，头节点一旦丢失，整条单链表丢失
 */

public class LinkedList<E> {

    private Node<E> first;//指向头节点

    private Node<E> last;//指向尾节点

    static class Node<E> {
        E data;//数据

        Node next;//指向下一个链表的下一个节点

        public Node(E data) {
            this.data = data;
        }
    }

    /**
     * 尾部插入，分两种情况：
     * ①链表为空，插入节点，该节点就是头节点以及尾节点
     * ②链表不为空，插入节点，尾节点的next节点指向该节点
     */
    public void insert(E data) {
        Node<E> newNode = new Node<>(data);
        if (isEmpty()) {
            this.first = newNode;
            this.last = newNode;
        } else {
            this.last.next = newNode;
            this.last = newNode;
        }
    }

    private void print() {
        Node current = first;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }


    private boolean isEmpty() {
        return first == null;
    }

    public static void main(String arg0[]) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(4);

        linkedList.print();
    }
}
