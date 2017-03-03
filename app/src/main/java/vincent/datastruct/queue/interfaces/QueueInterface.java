package vincent.datastruct.queue.interfaces;

/**
 * Created by vincent on 2017/3/3.
 * email-address:674928145@qq.com
 * description:
 */

public interface QueueInterface<E> {

    boolean add(E e);

    E remove();

    E peek();

    boolean isFull();

    boolean isEmpty();

    int size();

}
