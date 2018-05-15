package vincent.threadSth;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vincent on 2018/3/25.
 * email-address:674928145@qq.com
 * description:ThreadLocal相当于本地线程变量的一个副本，提供本地线程变量，这个变量里面的值
 * 是和其他线程分开的，变量的值只有当前线程可以访问得到，ThreadLocal的经典应用是提供一个与程序
 * 运行状态相关的静态变量，比如说一次访问回话的符号，userId
 */

public class ThreadLocalSth {
    private static java.lang.ThreadLocal<String> stringThreadLocal = new java.lang.ThreadLocal<>();
    private static java.lang.ThreadLocal<Map> paramThreadLocal = new java.lang.ThreadLocal<>();

    private void test1() {
        Thread t1=new Thread(){
            @Override
            public void run() {
                stringThreadLocal.set("threadName："+Thread.currentThread().getName());
                System.out.println(this.getName()+"---->"+"stringThreadLocal get----->"+stringThreadLocal.get());
            }
        };
        t1.start();

        Thread t2=new Thread(){
            @Override
            public void run() {
                stringThreadLocal.set("threadName："+Thread.currentThread().getName());
                System.out.println(this.getName()+"---->"+"stringThreadLocal get----->"+stringThreadLocal.get());
            }
        };
        t2.start();

        Thread t3=new Thread(){
            @Override
            public void run() {
                stringThreadLocal.set("threadName："+Thread.currentThread().getName());
                System.out.println(this.getName()+"---->"+"stringThreadLocal get----->"+stringThreadLocal.get());
            }
        };
        t3.start();
    }

    private void test2() {
        HashMap hashMap = new HashMap();
        hashMap.put("id", "1");
        hashMap.put("name", "vincent");
        paramThreadLocal.set(hashMap);

        Map map=paramThreadLocal.get();

        System.out.println("get id-->" + map.get("id"));
        System.out.println("get name-->" + map.get("name"));
    }

    public static void main(String arg[]) {
        ThreadLocalSth localSth = new ThreadLocalSth();
        localSth.test1();

        localSth.test2();
    }
}
