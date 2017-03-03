package vincent.datastruct.stack;

import vincent.datastruct.stack.interfaces.StackInterface;

/**
 * Created by vincent on 2017/3/2.
 * email-address:674928145@qq.com
 * description:java实现栈的链式存储结构
 */

public class LinkStack<T> implements StackInterface<T> {

    private Node topNode;//栈顶元素，用链表的表头表示
    private int count;

    private class Node {
        Node nextNode;//指向下一个元素，如果是第一个元素的话，nextNode为空
        T data;//存储的数据

        Node(T data) {
            this.data = data;
        }
    }

    @Override
    public synchronized void push(T element) {
        Node newNode = new Node(element);
        newNode.nextNode = topNode;
        topNode = newNode;
        count++;
        System.out.println("入栈元素" + topNode.data);
    }

    @Override
    public synchronized T pop() {
        if (isEmpty()) {
            System.out.println("栈已经空了");
            return null;
        } else {
            T data = topNode.data;
            if (topNode.nextNode != null) {
                topNode = topNode.nextNode;
            }
            count--;
            System.out.println("出栈元素" + data);
            return data;
        }
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public synchronized T peek() {
        return topNode.data;
    }

    public static void main(String[] arg0) {
        LinkStack<String> stack = new LinkStack<>();
        stack.push("元素1");
        stack.push("元素2");
        stack.pop();
        stack.push("元素3");
        stack.push("元素4");
        stack.push("元素5");
        stack.push("元素6");

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println("栈顶元素是 " + stack.peek());
        System.out.println("栈大小 " + stack.size());
    }
}
