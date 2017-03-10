package vincent.datastruct.queue;

import vincent.datastruct.queue.StaticArrayQueue;
import vincent.datastruct.queue.interfaces.QueueInterface;

/**
 * Created by vincent on 2017/3/3.
 * email-address:674928145@qq.com
 * description:java单链表实现链式存储队列
 */

public class LinkQueue<E> implements QueueInterface<E> {

    private Node frontNode;//头节点,固定，指针区域指向表头

    private Node rearNode;//队列尾节点
    private int count;//队列元素个数

    private class Node {
        Node nextNode;
        E data;

        Node(E data) {
            this.data = data;
        }
    }

    private LinkQueue() {
        frontNode = new Node(null);
    }

    @Override
    public synchronized boolean add(E e) {
        Node node = new Node(e);
        if (frontNode.nextNode == null) {
            frontNode.nextNode = rearNode = node;
        } else {
            rearNode.nextNode = node;
            rearNode = node;
        }
        count++;
        System.out.println("入队列:" + node.data);
        return true;
    }

    @Override
    public synchronized E remove() {
        if (isEmpty()) {
            System.out.println("队列已经空了");
            return null;
        } else {
            Node node = frontNode.nextNode;
            frontNode.nextNode = node.nextNode;
            count--;
            System.out.println("出队列：" + node.data);
            return node.data;
        }
    }

    @Override
    public E peek() {
        return frontNode.nextNode.data;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return frontNode.nextNode == null;
    }

    @Override
    public int size() {
        return count;
    }


    public static void main(String[] arg0) {
//        LinkQueue<String> queue = new LinkQueue<>();
//        for (int i = 0; i < 100; i++) {
//            queue.add("元素" + i);
//        }
//
//        queue.remove();
//        queue.remove();
//        System.out.println("头元素是 " + queue.peek());
//        System.out.println("队列的大小是" + queue.size());

    }
}
