package vincent.datastruct.stack;

import java.util.ArrayList;
import java.util.List;

import vincent.datastruct.stack.interfaces.StackInterface;

/**
 * Created by vincent on 2017/3/2.
 * email-address:674928145@qq.com
 * description:动态数组实现堆栈
 */

public class DynamicArrayStack<T> implements StackInterface<T> {

    private List<T> list = new ArrayList<>();
    private int top = -1;

    @Override
    public synchronized void push(T element) {
        list.add(element);
        top++;
        System.out.println("入栈" + element);
    }

    @Override
    public synchronized T pop() {
        if (isEmpty()) {
            return null;
        } else {
            T t = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            top--;
            System.out.println("出栈" + t);
            return t;
        }
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public synchronized T peek() {
        return isEmpty() ? null : list.get(list.size() - 1);
    }

    public static void main(String[] arg0) {
        DynamicArrayStack<String> stack = new DynamicArrayStack<>();
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
        System.out.println("栈顶元素是 " + stack.peek());
        System.out.println("栈大小 " + stack.size());

    }
}
