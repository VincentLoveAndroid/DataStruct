package vincent.designModel.ReflectFactory;

/**
 * Created by MingRen on 2016/9/5.
 */
public class Test {
    public static void main(String args[]) {
        ConcreateFactory factory = new ConcreateFactory();
        ProductA productA = factory.produce(ProductA.class);
        productA.send();

        ProductB productB = factory.produce(ProductB.class);
        productB.send();
    }
}
