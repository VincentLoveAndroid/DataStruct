package vincent.threadSth.concurrent;

import android.support.annotation.NonNull;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by Vincent on 2018/5/5.
 * description:
 * 1.Callable接口,和runnable用法差不多，但多了个返回值。Callable一般是和线程池-ExecutorService配合使用的
 * 2.future,对于具体的runnable或者callable任务进行中断，判断任务是否完成，获取结果。get方法调用会阻塞当前线程，直到任务返回结果。
 * 而get(long timeout,TimeUnit unit)用来获取执行结果，如果在指定时间内，还没获取到结果，就直接返回null
 * 3.future只是一个接口，具体的实现是futureTask，futureTask实现了RunnableFuture接口，RunnableFuture同时继承了
 * Runnable，Future这两个接口。因此，它既能作为Runnable被线程执行，又可以作为Future得到callable的返回值。
 * 4.futureTask的两个构造方法：
 * public FutureTask(Callable<V> callable){}
 * public FutureTask(Runnable runnable,V result){}
 */

public class CallableTest {

//    /**
//     * Callable和runnable的接口区别，Callable的call方法有返回值，并能抛出异常
//     *
//     * @param <V>
//     */
//    private interface Callable<V> {
//        V call() throws Exception;
//    }
//
//    public interface Runnable {
//        void run();
//    }

//    public interface RunnableFuture<V> extends Runnable,Future<V>{
//        @Override
//        void run();
//    }
//
//    public class FutureTask<V> implements RunnableFuture<V>{
//
//    }




    private class MyCallableTask implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            System.out.println("线程正在计算");
            Thread.sleep(3000);
            int sum = 0;
            for (int i = 0; i <=100; i++) {
                sum += i;
            }
            return sum;
        }
    }

     void runCallableByFutureTask() {
        Callable<Integer> myCallableTask = new MyCallableTask();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(myCallableTask);

        new Thread(futureTask).start();

         try {
             System.out.println("从FutureTask获取到的结果是:"+futureTask.get());
         } catch (InterruptedException e) {
             e.printStackTrace();
         } catch (ExecutionException e) {
             e.printStackTrace();
         }
    }

    private void runCallableByExecutor() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        //ExecutorService submit和execute方法执行任务的区别：
        // ①submit有返回值，execute没有。
        // ②execute只接收runnable，submit既接收runnable也接收callable
//        Future<Integer> future = executorService.submit(new MyCallableTask());
        Future<Integer> future = executorService.submit(new Runnable() {
            @Override
            public void run() {

            }
        },100);
        System.out.println("executorService already submit");
        try {
//            Thread.sleep(1500);
            //此方法会在当前线程阻塞，直到任务执行返回结果
            Integer result = future.get();
            //此方法会在当前线程阻塞，
            Integer result2 = future.get(3000, TimeUnit.MILLISECONDS);
            System.out.println("result from executorService "+ result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    public static void main(String arg0[]){
        CallableTest test = new CallableTest();
//        test.runCallableByFutureTask();

        test.runCallableByExecutor();

        int arr[] = new int[10];

        System.out.println(arr.length);

    }
}
