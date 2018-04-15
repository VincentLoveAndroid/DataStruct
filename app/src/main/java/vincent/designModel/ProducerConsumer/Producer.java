package vincent.designModel.ProducerConsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Vincent on 2018/4/13.
 * email-address:674928145@qq.com
 * description:生产者,当产品线满的时候生产者阻塞，不再生产产品
 */

public class Producer implements Runnable{
    private volatile boolean isRunning = true;
    private BlockingQueue<Product> queue;//内存缓冲区
    private static AtomicInteger count = new AtomicInteger();//总数，原子操作
    private static final int SLEEP_TIME = 1000;


    public Producer(BlockingQueue<Product> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Product product;
        Random random = new Random();
        System.out.println("start producing id:" + Thread.currentThread().getId());
        while (isRunning) {
            try {
                Thread.sleep(random.nextInt(SLEEP_TIME));
                product = new Product(count.incrementAndGet());
                System.out.println(product + " 加入队列");
                if (queue.offer(product, 2, TimeUnit.SECONDS)) {
                    System.err.println("加入队列失败");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                isRunning = false;
            }
        }
    }

    public void stop() {
        isRunning = false;
    }

}
