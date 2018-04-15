package vincent.datastruct.LinekedList;

/**
 * Created by Vincent on 2018/3/31.
 * email-address:674928145@qq.com
 * description:环形链表，头尾节点相连接的链表
 *
 * 优点：链表具有方向性，单链表中如果表头指针被破坏或遗失，整个列表就会遗失，如果把列表
 * 的最后一个节点指针指向表头，整个列表就成为单向的循环结构。从表的任一节点出发，都能扫描到整个链表。
 */

public class CircleLinkedList<E> {
    private Node<E> first;
    private Node<E> last;//尾节点的next节点指向头节点


    static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }

    private boolean isEmpty() {
        return first == null;
    }

    private void print() {
        Node current = first;
        while (current != null) {
            System.out.println(" 链表剩余数据：data------->" + current.data);
            current = current.next;
            if (current == first) {
                break;
            }
        }
    }

    /**
     * 从尾节点插入
     *
     * @param data
     */
    private void insert(E data) {
        Node<E> newNode = new Node<>(data);
        //如果当前链表为空
        if (isEmpty()) {
            first = newNode;
            last = newNode;
            last.next = first;
        } else {
            last.next = newNode;
            last = newNode;
            last.next = first;
        }
    }

    /**
     * 删除指定数据的节点分三种情况
     * ①删除的是头节点
     * ②删除的是尾节点
     * ③删除的是中间节点
     *
     * @param delData
     */
    private void delete(E delData) {
        System.out.println("要删除的节点数据是：" + delData);
        if (isEmpty()) {
            System.out.println("环形链表已经空了");
            return;
        }
        //如果删除的是头节点的数据
        if (first.data == delData) {
            if (last.next == first.next) {
                first = null;
                last = null;
                System.out.println("删除了头结点链表已经空了");
                return;
            }
            last.next = first.next;
            first = last.next;
        }
        //如果删除的是尾节点
        else if (last.data == delData) {
            Node current = first;
            while (current.next.data != delData) {
                current = current.next;
            }
            current.next = first;
            last = current;
        }
        //如果删除的是中间的节点
        else {
            Node<E> current = first;
            Node<E> delPre = null;//被删元素的前一位元素
            Node<E> delNext = null;//被删元素的后一位元素
            while (current != null) {
                if (current.next.data == delData) {
                    delPre = current;
                }
                if (current.data == delData) {
                    delNext = current.next;
                }
                current = current.next;
                if (current == first) {
                    break;
                }
            }
            if (delPre == null) {
                System.out.println("链表中不含有该节点数据：" + delData);
            }
            if (delPre != null && delNext != null) {
                delPre.next = delNext;
            }

        }

    }


    public static void main(String arg0[]) {
        CircleLinkedList<Integer> circleLinkedList = new CircleLinkedList<>();
        circleLinkedList.insert(1);
        circleLinkedList.insert(2);
        circleLinkedList.insert(3);
        circleLinkedList.insert(4);

        circleLinkedList.print();

        circleLinkedList.delete(6);
        circleLinkedList.print();

        circleLinkedList.delete(3);
        circleLinkedList.print();

        circleLinkedList.delete(2);
        circleLinkedList.print();

        circleLinkedList.delete(1);
        circleLinkedList.print();

        circleLinkedList.delete(4);
        circleLinkedList.print();
    }

}
