package vincent.threadSth.concurrent;

import java.util.concurrent.Semaphore;

/**
 * Created by Vincent on 2018/5/7.
 * description:  ['sɛməfɔr]
 * 一个计数信号量,和锁有点类似。Semaphore可以控同时访问的线程个数，通过 acquire() 获取一个许可，如果没有就等待，
 * 而 release() 释放一个许可。信号量通常用于限制线程数，而不是访问某些（物理或逻辑）资源。
 */

public class SemaphoreTest {
    public static void main(String[] args) {
        int N = 10;            //工人数
        Semaphore semaphore = new Semaphore(5); //机器数目(许可凭证个数)
        for(int i=1;i<=N;i++)
            new Worker(i,semaphore).start();
    }

    private static class Worker extends Thread{
        private int num;
        private Semaphore semaphore;
        public Worker(int num,Semaphore semaphore){
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                //获取许可凭证,如果没有许可凭证了，就等待
                semaphore.acquire();
                System.out.println("工人"+this.num+"占用一个机器在生产...");
                Thread.sleep(2000);
                //释放许可凭证
                semaphore.release();
                System.out.println("工人"+this.num+"释放出机器");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
