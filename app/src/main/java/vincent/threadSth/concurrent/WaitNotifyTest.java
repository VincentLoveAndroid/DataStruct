package vincent.threadSth.concurrent;

/**
 * Created by Vincent on 2018/5/6.
 * description:利用Object类wait和notify暂停或唤醒线程
 * 1.wait 该监视器下的线程进入等待状态，线程释放锁，直到其他线程调用notify或notifyAll方法唤醒该线程
 * 2.notify 唤醒的线程顺序如何决定？
 */

public class WaitNotifyTest {


    private String[] lock = {"true"};

    private class WaitThread extends Thread {

        @Override
        public void run() {
            synchronized (lock) {
//                while ("true".equals(lock[0])) {
                    long startTime = System.currentTimeMillis();
                    System.out.println("线程 " + this.getName() + " 开始等待");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    long endTime = System.currentTimeMillis();
                    System.out.println("线程" + this.getName() + "等待时间为：" + (endTime - startTime));
//                }
                System.out.println("线程"+getName()+"等待结束");
            }
        }
    }

    class NotifyThread extends Thread{

        public NotifyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock) {
                System.out.println("线程"+this.getName()+"开始通知");
//                lock[0] = "false";
//                lock.notifyAll();
                lock.notify();
                System.out.println("线程"+this.getName()+"通知结束");
            }
            System.out.println("线程"+this.getName()+"运行结束");
        }
    }

    public static void main(String arg0[]) {
        WaitNotifyTest test = new WaitNotifyTest();
        WaitThread waitThread0 = test.new WaitThread();
        WaitThread waitThread1 = test.new WaitThread();
        WaitThread waitThread2 = test.new WaitThread();
        WaitThread waitThread3 = test.new WaitThread();

        //设置线程的优先级1-10，提高线程优先级只能提高cup调度该线程的几率，执行/唤醒顺序不一定会按优先级的来
//        waitThread0.setPriority(1);
//        waitThread1.setPriority(2);
//        waitThread2.setPriority(3);
//        waitThread3.setPriority(4);

        NotifyThread notifyThread = test.new NotifyThread("NotifyThread");

        waitThread0.start();
        waitThread1.start();
        waitThread2.start();
        waitThread3.start();

        notifyThread.start();
    }
}
