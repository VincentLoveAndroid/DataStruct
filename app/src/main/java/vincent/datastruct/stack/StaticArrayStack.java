package vincent.datastruct.stack;

import vincent.datastruct.stack.interfaces.StackInterface;

/**
 * Created by vincent on 2017/3/2.
 * email-address:674928145@qq.com
 * description:静态数组实现堆栈
 */

public class StaticArrayStack implements StackInterface {

    static Object arr[];
    private int top = -1;

    public StaticArrayStack(int maxSize) {
        arr = new Object[maxSize];
    }

    @Override
    public synchronized void push(Object element) {
        if (isFull()) {
            System.out.print("栈已经满了");
        } else {
            arr[++top] = element;
            System.out.println("入栈" + element);
        }
    }

    @Override
    public synchronized Object pop() {
        if (isEmpty()) {
            return null;
        } else {
            Object o = arr[top];
            arr[top] = null;
            top--;
            return o;
        }
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == arr.length - 1;
    }

    @Override
    public int size() {
        return top + 1;
    }

    /**
     * 得到栈顶元素但是栈顶元素不出栈
     */
    @Override
    public synchronized Object peek() {
        return isEmpty() ? null : arr[top];
    }

    public static void main(String[] arg0) {
        StaticArrayStack stack = new StaticArrayStack(10);
        stack.push("元素1");
        stack.push("元素2");
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
