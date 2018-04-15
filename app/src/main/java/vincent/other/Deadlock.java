package vincent.other;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Vincent on 2018/4/3.
 * email-address:674928145@qq.com
 * description:模拟多线程死锁情况
 */

public class Deadlock {

    private static Object lockA = new Object();
    private static Object lockB = new Object();


    private static ReentrantLock lockC = new ReentrantLock();
    private static ReentrantLock lockD = new ReentrantLock();


    public static void main(String arg0[]){
//        synchronizedLock();

        reentrantLock();
    }

    /**
     * 使用同步造成的死锁
     */
    private static void synchronizedLock() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockA) {
                    try {
                        System.out.println("线程1取得了a锁");
                        Thread.sleep(2000);
                        synchronized (lockB) {
                            System.out.println("线程1取得了b锁");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockB) {
                    try {
                        System.out.println("线程2取得了b锁");
                        Thread.sleep(2000);
                        synchronized (lockA) {
                            System.out.println("线程2取得了a锁");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

    private static void reentrantLock() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lockC.lock();
                    System.out.println("thread1 get LockC");
                    Thread.sleep(2500);
                    System.out.println("thread1 release LockC");
                    lockC.unlock();
                    lockD.lock();
                    System.out.println("thread2 get LockD");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
//                    lockC.unlock();
//                    lockD.unlock();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lockD.lock();
                    System.out.println("thread2 get lockD");
                    Thread.sleep(2000);
                    System.out.println("thread2 waiting for lockC");

                    //延时检查是否可以锁
                    boolean canLock = lockC.tryLock(1, TimeUnit.SECONDS);
//                    boolean canLock = lockC.tryLock();
                    //可以锁才锁，防止阻塞
                    if (canLock) {
                        System.out.println("thread2 get lockC");
                    }else{
                        System.out.println("thread2 failed to get lockC");
                    }
                    System.out.println("thread2 do not deadLock");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
//                    lockC.unlock();
//                    lockD.unlock();
                }
            }
        }).start();
    }

}
