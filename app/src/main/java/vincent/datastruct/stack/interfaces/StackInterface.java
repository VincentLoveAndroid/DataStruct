package vincent.datastruct.stack.interfaces;

/**
 * Created by vincent on 2017/3/2.
 * email-address:674928145@qq.com
 * description:
 */

public interface StackInterface<T> {
    void push(T element);

    T pop();

    boolean isEmpty();

    boolean isFull();

    int size();

    T peek();

    String toString();

}
