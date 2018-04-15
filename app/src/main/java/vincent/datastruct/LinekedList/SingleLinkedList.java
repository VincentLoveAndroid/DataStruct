package vincent.datastruct.LinekedList;

/**
 * Created by vincent on 2017/3/9.
 * email-address:674928145@qq.com
 * description:单链表
 */

public class  SingleLinkedList<E> {
    /**
     * transient 关键词修饰的变量，防止被序列化，持久化
     */
    transient int size = 0;

    transient Node<E> first;

    transient Node<E> last;

    private static class Node<E> {

        Node next;
        E data;

        public Node(E data) {
            this.data = data;
        }
    }

    /**
     * 在链表链表的任意位置添加数据
     * 从第一个节点开始查找，找到相应要插入的位置，让当前位置的节点前面的节点next指针指向要插入的节点
     * 要插入的节点的next指针指向当前的节点，完成了链表插入的链接
     *
     * @param data
     * @param index
     */
    public void add(E data, int index) {

        checkPositionIndex(index);

        if (index == size)
            linkLast(data);
        else
            linkBefore(data, node(index));

        if (first == null) {
            first = new Node<>(data);
        }
        Node node = new Node(data);
        Node currentNode = first;
        Node previousNode = null;
//        while (index != pos) {
//            previousNode = currentNode;
//            currentNode = currentNode.next;
//            pos++;
//        }
//        node.next = currentNode;
//        previousNode.next = node;
//        pos = 0;

    }

    private void linkLast(E element) {

    }

    private void linkBefore(E data, Node node) {

    }

    Node<E> node(int index) {
        return null;
    }


    private void checkPositionIndex(int index) {
        if (!(index >= 0 && index <= size))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    /**
     * Constructs an IndexOutOfBoundsException detail message.
     * Of the many possible refactorings of the error handling code,
     * this "outlining" performs best with both server and client VMs.
     */
    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    public void deleteDataByPos(int index) {

    }

    public void deleteDataByData(int data) {

    }

}
