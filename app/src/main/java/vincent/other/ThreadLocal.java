package vincent.other;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vincent on 2018/3/26.
 * email-address:674928145@qq.com
 * description:模仿ThreadLocal实现原理
 *
 * ①ThreadLocal是用来维护线程变量的一个副本
 * ②内部有一个ThreadLocalMap类，存储时key为当前的ThreadLocal对象，值为要存储的值
 * ③Thread持有ThreadLocalMap变量，ThreadLocal的set和get方法都要先调用getMap方法取Thread的ThreadLocalMap
 */

public class ThreadLocal<T> {

//
//    public void set(T value) {
//        //得到当前线程
//        Thread t = Thread.currentThread();
//        //根据当前线程获取到线程的ThreadLocalMap
//        ThreadLocalMap map = getMap(t);
//        //如果内存有该map，以当前ThreadLocal对象作为key，设置的值作为value赋值
//        if (map != null) {
//            map.set(this, value);
//        }
//        //如果没有，则创建线程的ThreadLocalMap
//        else {
//            createMap(t,value);
//        }
//    }
//
//
//    public T get() {
//        //得到当前线程
//        Thread t = Thread.currentThread();
//        //根据当前线程获取线程的ThreadLocalMap
//        ThreadLocalMap map = getMap(t);
//        if (map != null) {
//            ThreadLocalMap.Entry e = map.getEntry(this);
//            if (e != null) {
//                T result = (T) e.getValue();
//                return result;
//            }
//        }
//        return setInitialValue();
//    }
//
//    private T setInitialValue() {
//        return null;
//    }
//
//    //获取线程的threadLocals变量
//    private ThreadLocalMap getMap(Thread t) {
//        return t.threadLocals;
//    }
//
//    private void createMap(Thread t,Object firstValue) {
//        t.threadLocals = new ThreadLocalMap(this,firstValue);
//    }
//
//    //实际ThreadLocalMap并不继承HashMap但是一个类似HashMap的结构
//    static class ThreadLocalMap extends HashMap {
//
//        public ThreadLocalMap(ThreadLocal threadLocal,Object value) {
//
//        }
//
//        public void set(ThreadLocal threadLocal, Object value) {
//            put(threadLocal, value);
//        }
//    }

}
