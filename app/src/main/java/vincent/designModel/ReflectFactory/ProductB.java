package vincent.designModel.ReflectFactory;

/**
 * Created by MingRen on 2016/9/5.
 */
public class ProductB implements Product {
    @Override
    public void send() {
        System.out.println("produce-B");
    }
}
