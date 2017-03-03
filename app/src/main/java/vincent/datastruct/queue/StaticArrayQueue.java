package vincent.datastruct.queue;

import java.util.NoSuchElementException;

import vincent.datastruct.queue.interfaces.QueueInterface;
import vincent.datastruct.stack.LinkStack;

/**
 * Created by vincent on 2017/3/3.
 * email-address:674928145@qq.com
 * description:java数组实现顺序存储队列
 */

public class StaticArrayQueue<E> implements QueueInterface<E> {

    private int front = -1;//头指针
    private int rear = -1;//尾指针
    private Object[] arr;

    public StaticArrayQueue(int maxSize) {
        arr = new Object[maxSize];
    }

    /**
     * 添加一个头部元素，如果队列已满返回添加失败
     *
     * @param e
     * @return
     */
    @Override
    public synchronized boolean add(E e) {
        if (isFull()) {
            System.out.println("队列已满");
            return false;
        } else {
            if (front == -1 && rear == -1) {
                front++;
            }
            arr[++rear] = e;//尾指针后移一位
            System.out.println("进队列：" + e);
            return true;
        }
    }

    /**
     * 移除并返回一个头部元素，如果队列为空，返回null
     *
     * @return
     */
    @Override
    public synchronized E remove() {
        if (isEmpty()) {
            System.out.println("队列已空");
            return null;
        } else {
            Object o = arr[front];
            arr[front] = null;
            if (front == rear) front = rear = -1;//移除最后一个元素，重置头尾指针
            else front++;
            System.out.println("出队列：" + o);
            return (E) o;
        }
    }

    /**
     * 返回队列头部元素，如果头部为空，则返回null
     *
     * @return
     */
    @Override
    public synchronized E peek() {
        return isEmpty() ? null : (E) arr[front];
    }

    @Override
    public boolean isFull() {
        return rear == arr.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return front == -1 && front == rear;//头尾指针重合且都为-1则队列为空
    }

    @Override
    public int size() {
        return front == -1 ? 0 : rear - front + 1;
    }

    public static void main(String[] arg) {
        StaticArrayQueue<String> queue = new StaticArrayQueue<>(10);
        queue.add("元素1");
        queue.add("元素2");
        queue.add("元素3");
        queue.add("元素4");
        queue.add("元素5");
        queue.add("元素6");
        queue.add("元素7");
        queue.add("元素8");
        queue.add("元素9");
        queue.add("元素10");
        queue.add("元素11");
        queue.add("元素12");

        queue.remove();
        System.out.println("队列的大小是" + queue.size());

        System.out.println("头元素是 " + queue.peek());

    }
}
