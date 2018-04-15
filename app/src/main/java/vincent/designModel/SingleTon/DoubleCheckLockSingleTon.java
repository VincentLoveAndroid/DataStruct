package vincent.designModel.SingleTon;

/**
 * Created by MingRen on 2016/8/31.
 * 双重校验锁，在当前的内存模型中无效
 * synchronized:解决线程安全问题，但是效率降低
 * 双重校验：提高效率
 *
 */
public class DoubleCheckLockSingleTon {

    private volatile static DoubleCheckLockSingleTon doubleCheckLockSingleTon;

    private DoubleCheckLockSingleTon() {}

    public static DoubleCheckLockSingleTon getDoubleCheckLockSingleTon() {
        if (doubleCheckLockSingleTon == null) {//lockDoubleCheckSingleTon为空的时候才锁，提高效率
            synchronized (DoubleCheckLockSingleTon.class) {
                if (doubleCheckLockSingleTon == null) {
                    doubleCheckLockSingleTon = new DoubleCheckLockSingleTon();
                }
            }
        }
        return doubleCheckLockSingleTon;
    }
}
