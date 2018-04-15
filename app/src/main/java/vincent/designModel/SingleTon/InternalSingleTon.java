package vincent.designModel.SingleTon;

/**
 * Created by MingRen on 2016/8/31.
 */
public class InternalSingleTon {

    static {//测试代码
        System.out.println("InternalSingleTon-load");
    }

    private static class SingleTonHolder {//静态内部类，被使用的时候才加载进内存，达到懒加载的目的
        private static final InternalSingleTon internalSingleTon = new InternalSingleTon();

        static {//测试代码
            System.out.println("SingleTonHolder-load");
        }
    }

    private InternalSingleTon() {}

    public static InternalSingleTon getInternalSingleTon() {

        return SingleTonHolder.internalSingleTon;

    }
}
