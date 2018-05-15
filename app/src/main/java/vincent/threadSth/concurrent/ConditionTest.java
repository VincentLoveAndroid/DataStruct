package vincent.threadSth.concurrent;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Vincent on 2018/5/6.
 * description:util.concurrent包中Condition相关使用
 * 1.Condition也提供了类似Object监视器的方法
 * 2.await:让当前监视器的线程等待
 * 3.signal:让一个线程唤醒(这个线程是哪一个？)，
 * 4.signalAll:让所有该监视器下的线程唤醒？唤醒顺序怎么决定？
 * 5.Condition的优势：支持多路等待，可以自定义多个Condition，每个Condition控制线程的一个执行通路
 */

public class ConditionTest {

    private Lock lock = new ReentrantLock(true);
    private Condition condition = lock.newCondition();


    private class AwaitThread extends Thread {

        @Override
        public void run() {
            lock.lock();
            long startTime = System.currentTimeMillis();
            System.out.println("线程 " + this.getName() + " 开始等待");
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            long endTime = System.currentTimeMillis();
            System.out.println("线程" + this.getName() + "等待时间为：" + (endTime - startTime));
        }
    }

    private class SignalThread extends Thread {

        public SignalThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                lock.lock();
                System.out.println("线程" + this.getName() + "开始通知");
//                condition.signal();
                condition.signalAll();
            } finally {
                lock.unlock();
            }

            System.out.println("线程" + this.getName() + "通知结束");
        }
    }

    public static void main(String arg0[]) {
//        awaitSignalTest();
        ConditionTest test = new ConditionTest();
        test.ThreeConditionTest();
    }

    private static void awaitSignalTest() {
        ConditionTest test = new ConditionTest();
        AwaitThread awaitThread0 = test.new AwaitThread();
        AwaitThread awaitThread1 = test.new AwaitThread();
        AwaitThread awaitThread2 = test.new AwaitThread();
        AwaitThread awaitThread3 = test.new AwaitThread();

        //设置线程的优先级1-10，提高线程优先级只能提高cup调度该线程的几率，执行/唤醒顺序不一定会按优先级的来
//        awaitThread0.setPriority(1);
//        awaitThread1.setPriority(2);
//        awaitThread2.setPriority(3);
//        awaitThread3.setPriority(4);

        SignalThread signalThread = test.new SignalThread("NotifyThread");

        awaitThread0.start();
        awaitThread1.start();
        awaitThread2.start();
        awaitThread3.start();

        signalThread.start();
    }

    /**
     * 实现功能：有A,B,C三个线程，A线程循环5次->B线程循环5次->C线程循环5次->A线程循环5次，如此反复
     */
    private Lock lockThree = new ReentrantLock();
    private Condition conditionA = lockThree.newCondition();
    private Condition conditionB = lockThree.newCondition();
    private Condition conditionC = lockThree.newCondition();

    private volatile String threadFlag = "A";

    private void ThreeConditionTest() {
        new Thread("A") {
            @Override
            public void run() {
                try {
                    lockThree.lock();
                    while (!"A".equals(threadFlag)) {
                        conditionA.await();
                    }
                    for (int i = 0; i < 5; i++) {
                        System.out.println("线程：" + getName() + " " + i);
                    }
                    threadFlag = "B";
                    conditionB.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lockThree.unlock();
                }
            }
        }.start();

        new Thread("B") {
            @Override
            public void run() {
                try {
                    lockThree.lock();
                    while (!"B".equals(threadFlag)) {
                        conditionB.await();
                    }
                    for (int i = 0; i < 5; i++) {
                        System.out.println("线程：" + getName() + " " + i);
                    }
                    threadFlag = "C";
                    conditionC.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lockThree.unlock();
                }
            }
        }.start();

        new Thread("C") {
            @Override
            public void run() {
                try {
                    lockThree.lock();
                    while (!"C".equals(threadFlag)) {
                        conditionC.await();
                    }
                    for (int i = 0; i < 5; i++) {
                        System.out.println("线程：" + getName() + " " + i);
                    }
                    threadFlag = "A";
                    conditionA.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lockThree.unlock();
                }
            }
        }.start();
    }
}
