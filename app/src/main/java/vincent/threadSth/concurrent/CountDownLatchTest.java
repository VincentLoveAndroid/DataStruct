package vincent.threadSth.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Vincent on 2018/5/7.
 * description:
 * 1、允许一个或多个线程等待直到在其他线程中执行的一组操作完成的计数器
 * 2、A CountDownLatch用给定的计数初始化。 await方法阻塞，直到由于countDown()方法的调用而导致当前计数达到零，
 * 之后所有等待线程被释放，并且任何后续的await 调用立即返回。这是一个一次性的现象 - 计数无法重置。 如果您需要重置计数的版本，
 * 请考虑使用CyclicBarrier 。
 *
 *
 * public boolean await(long timeout,
 TimeUnit unit)
 throws InterruptedException
 导致当前线程等到锁存器向下计数到零，除非线程为interrupted ，否则指定的等待时间过去。
 如果当前计数为零，则此方法将立即返回值为true 。

 如果当前计数大于零，则当前线程将被禁用以进行线程调度，并处于休眠状态，直至发生三件事情之一：

 由于countDown()方法的调用，计数达到零; 要么
 一些其他线程interrupts当前线程; 要么
 指定的等待时间过去了。
 如果计数达到零，则方法返回值为true 。
 */

public class CountDownLatchTest {

    private CountDownLatch countDownLatch = new CountDownLatch(2);

    private void countDownTest() {
        new Thread() {
            @Override
            public void run() {
                System.out.println("子线程:" + getName() + " 正在执行"+" 计数量 "+countDownLatch.getCount());
                try {
                    sleep(3000);
                    countDownLatch.countDown();
                    System.out.println("子线程:" + getName() + " 执行完毕"+" 计数量 "+countDownLatch.getCount());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                System.out.println("子线程:" + getName() + " 正在执行"+" 计数量 "+countDownLatch.getCount());
                try {
                    sleep(3000);
                    System.out.println("子线程:" + getName() + " 执行完毕"+" 计数量 "+countDownLatch.getCount());
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        try {
            System.out.println("主线程挂起，等待子线程执行完成");
            countDownLatch.await();
            System.out.println("子线程执行完成，主线程继续执行"+" 计数量 "+countDownLatch.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String arg0[]) {
        CountDownLatchTest test = new CountDownLatchTest();
        test.countDownTest();
    }
}
