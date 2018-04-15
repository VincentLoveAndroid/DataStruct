package vincent.designModel.SingleTon;

/**
 * Created by MingRen on 2016/8/30.
 */
public class SingleTonTest {
    public static void main(String args[]) {
        //调用两次，类只加载一次
        InternalSingleTon.getInternalSingleTon();
    }
}
