package vincent.designModel.ProducerConsumer;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Vincent on 2018/4/13.
 * email-address:674928145@qq.com
 * description:消费者，当产品线空的时候，消费者阻塞，不再消费产品
 */

public class Consumer implements Runnable {
    private BlockingQueue<Product> queue;
    private static final int SLEEP_TIME = 1000;

    public Consumer(BlockingQueue<Product> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("start Consumer id :"+Thread.currentThread().getId());
        Random r = new Random();
        try{
            while(true){
                Product data = queue.take();
                if(data != null)
                {
                    int re = data.getData() * data.getData();
                    System.out.println(MessageFormat.format("{0}*{1}={2}", data.getData(),data.getData(),re));
                    Thread.sleep(r.nextInt(SLEEP_TIME));
                }
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
