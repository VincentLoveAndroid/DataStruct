package vincent.threadSth;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.RequiresApi;

/**
 * Created by Vincent on 2018/4/4.
 * email-address:674928145@qq.com
 * description:Handler，handlerThread相关使用
 */

public class HandlerSth {

    private static Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            System.out.println("主线程收到消息 " + +msg.what + " " + msg.obj);
        }
    };

    private static Handler mHandler2;

    /**
     * 主线程和子线程之间通信
     */
    public void sendMessage() {
        Message msg = new Message();
        msg.what = 1;
        msg.obj = "new Message";
        mHandler.sendMessage(msg);
    }

    /**
     * 主线程和子线程之间通信
     */
    public void sendToTarget() {
        //从消息池里面得到消息
        Message msg = mHandler.obtainMessage(3);
        msg.obj = "obtainMessage";
        msg.sendToTarget();
    }

    /**
     *
     */
    public void sendMessageFromThread() {
        new Thread() {
            @Override
            public void run() {
                //一个线程只能有一个Looper对应一个MessageQueue,在子线程创建Handler之前要先调用
                //Looper.prepare();
                Looper.prepare();

                mHandler2 = new Handler() {
                    @Override
                    public void handleMessage(Message msg) {
                        System.out.println("子线程收到消息 " + msg.what + " " + msg.obj);
                    }
                };
                //让Looper开始工作，从消息队列里取消息，处理消息。
                //写在Looper.loop()之后的代码不会被执行，这个函数内部应该是一个循环，当调用mHandler.getLooper().quit()后，loop才会中止，其后的代码才能得以运行。
                Looper.loop();

                System.out.println("子线程Looper退出了");
            }
        }.start();

        new Thread() {

            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
            @Override
            public void run() {
                int i = 0;
                while (true) {
                    try {
                        Thread.sleep(1000);
                        mHandler2.obtainMessage(i++, "子线程通信").sendToTarget();
                        if (i == 10) {
                            //让Looper停止轮询
//                            当我们调用Looper的quit方法时，实际上执行了MessageQueue中的removeAllMessagesLocked方法，该方法的作用是把MessageQueue消息池中所有的消息全部清空，无论是延迟消息（延迟消息是指通过sendMessageDelayed或通过postDelayed等方法发送的需要延迟执行的消息）还是非延迟消息。
//                            当我们调用Looper的quitSafely方法时，实际上执行了MessageQueue中的removeAllFutureMessagesLocked方法，通过名字就可以看出，该方法只会清空MessageQueue消息池中所有的延迟消息，并将消息池中所有的非延迟消息派发出去让Handler去处理，quitSafely相比于quit方法安全之处在于清空消息之前会派发所有的非延迟消息。
//                            无论是调用了quit方法还是quitSafely方法只会，Looper就不再接收新的消息。即在调用了Looper的quit或quitSafely方法之后，消息循环就终结了，这时候再通过Handler调用sendMessage或post等方法发送消息时均返回false，表示消息没有成功放入消息队列MessageQueue中，因为消息队列已经退出了。

                            mHandler2.getLooper().quit();
//                            mHandler2.getLooper().quitSafely();

                            break;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    public void handlerThreadTest() {
        HandlerThread mHandlerThread = new HandlerThread("Vincent");
        mHandlerThread.start();

        final Handler mHandler3 = new Handler(mHandlerThread.getLooper()){
            @Override
            public void handleMessage(Message msg) {
                System.out.println("子线程收到消息 " + +msg.what + " " + msg.obj);
            }
        };

        new Thread(){
            @Override
            public void run() {
                mHandler3.obtainMessage(10,"HandlerThread").sendToTarget();
            }
        }.start();
    }
}
