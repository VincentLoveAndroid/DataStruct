package vincent.threadSth;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Vincent on 2018/4/9.
 * email-address:674928145@qq.com
 * description:
 */

public class SynchronizedTest {
    static  volatile int count=0;


    public static void main(String arg0[]) {
//        syncTest();
//        lockTest();

//        volatileTest();

//        String a = "Vincent";
//        String b = ;
//        System.out.println(a==b);

    }

    private static void volatileTest() {
        new Thread(){
            @Override
            public void run() {
                for (int i=0;i<1000000;i++) {
                    count++;
                }
                System.out.println(count);
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                for (int i=0;i<1000000;i++) {
                    count++;
                }
                System.out.println(count);
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                for (int i=0;i<1000000;i++) {
                    count++;
                }
                System.out.println(count);
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                for (int i=0;i<1000000;i++) {
                    count++;
                }
                System.out.println(count);
            }
        }.start();
    }

    private static void lockTest() {
        final Lock lock = new Lock();
        new Thread() {
            @Override
            public void run() {
                lock.print1();
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                lock.print2();
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                lock.print3();
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                lock.print4();
            }
        }.start();


        new Thread() {
            @Override
            public void run() {
                lock.print5();
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                lock.print6();
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                lock.print7();
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                lock.print8();
            }
        }.start();
    }

    private static void syncTest() {
        final Sync sync = new Sync();
        new Thread() {
            @Override
            public void run() {
                sync.print1();
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                sync.print2();
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                sync.print3();
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                sync.print4();
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                sync.print5();
            }
        }.start();
    }

    private static class Sync {
        private synchronized void print1() {
            try {
                System.out.println("打印1");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private synchronized void print2() {
            System.out.println("打印2");
        }

        private synchronized void print3() {
            System.out.println("打印3");
        }

        private synchronized void print4() {
            System.out.println("打印4");
        }

        private synchronized void print5() {
            System.out.println("打印5");
        }
    }

    private static class Lock {
        ReentrantLock lock = new ReentrantLock(false);

        private void print1() {
            try {
                lock.lock();
                System.out.println("打印1");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("解锁");
                lock.unlock();
            }
        }

        private void print2() {
            lock.lock();
            System.out.println("打印2");
            lock.unlock();
        }

        private void print3() {
            lock.lock();
            System.out.println("打印3");
            lock.unlock();
        }

        private void print4() {
            lock.lock();
            System.out.println("打印4");
            lock.unlock();
        }

        private void print5() {
            lock.lock();
            System.out.println("打印5");
            lock.unlock();
        }

        private void print6() {
            lock.lock();
            System.out.println("打印6");
            lock.unlock();
        }

        private void print7() {
            lock.lock();
            System.out.println("打印7");
            lock.unlock();
        }

        private void print8() {
            lock.lock();
            System.out.println("打印8");
            lock.unlock();
        }
    }
}
