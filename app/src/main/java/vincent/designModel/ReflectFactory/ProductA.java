package vincent.designModel.ReflectFactory;

/**
 * Created by MingRen on 2016/9/5.
 */
public class ProductA implements Product {
    @Override
    public void send() {
        System.out.println("produce-A");
    }
}
