package vincent.designModel.SingleTon;

/**
 * Created by MingRen on 2016/8/31.
 * 懒汉式，对象在需要被使用的时候才实例化
 */
public class LazySingleTon {

    private static LazySingleTon lazySingleTon;

    private LazySingleTon() {}

    public static LazySingleTon getLazySingleTon() {
        if (lazySingleTon == null) {
            lazySingleTon = new LazySingleTon();
        }

        return lazySingleTon;
    }
}
