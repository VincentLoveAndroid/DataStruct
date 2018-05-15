package vincent.threadSth.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Vincent on 2018/5/7.
 * description:回环珊栏
 * 1.通过它可以实现让一组线程等待至某个状态之后再全部同时执行。叫做回环是因为当所有等待线程都被释放以后，
 * CyclicBarrier可以被重用。
 * 2.使用：比如说初始化的时候传递的parties参数为4，则需要在4个线程调用await方法挂起之后，所有线程被同时唤醒。
 * 3.CyclicBarrier和CountDownLatch的区别：
 * ①CountDownLatch和CyclicBarrier都能够实现线程之间的等待，只不过它们侧重点不同：
 * ②CountDownLatch一般用于某个线程A等待若干其他线程执行完任务后，才执行。
 * ③CyclicBarrier用于一组线程互相等待至某个状态，等所有线程的Await方法调用之后，这一组线程在同时执行
 * ④CountDownLatch不能够重用，CyclicBarrier可以重用

 CountDownLatch一般用于某个线程A等待若干个其他线程执行完任务之后，它才执行；

 而CyclicBarrier一般用于一组线程互相等待至某个状态，然后这一组线程再同时执行；

 另外，CountDownLatch是不能够重用的，而CyclicBarrier是可以重用的。
 */

public class CyclicBarrierTest {
    public static void main(String[] args) {
//        writerTest();

        helloWordTest();
    }

    private static void helloWordTest() {
        CyclicBarrier barrier = new CyclicBarrier(5);
        for (int i = 0; i < 5; i++) {
            new HelloWordThread(barrier).start();
        }
    }

    private static void writerTest() {
        int N = 4;
        CyclicBarrier barrier = new CyclicBarrier(N);
        int parties = barrier.getParties();
        System.out.println("parties "+parties);
        for (int i = 0; i < N; i++)
            new Writer(barrier).start();
    }

    static class Writer extends Thread {
        private CyclicBarrier cyclicBarrier;

        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("线程" + Thread.currentThread().getName() + "正在写入数据...");
            try {
                Thread.sleep(5000);      //以睡眠来模拟写入数据操作
                System.out.println("线程" + Thread.currentThread().getName() + "写入数据完毕，等待其他线程写入完毕");
                //挂起线程，知道所有的parties(个数为初始化barrier的时候传递的参数) 调用了await
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务...");
        }
    }

    /**
     * 阿里面试：多线程，5个线程内部打印hello和word，hello在前，要求提供一种方法使得5个线程先全部打印出hello后再打印5个word。
     */
    static class HelloWordThread extends Thread{

        private CyclicBarrier barrier;
        public HelloWordThread(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            System.out.println(getName()+" hello");
            try {
                barrier.await();
                System.out.println(getName()+" word");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
