package vincent.designModel.Decorator;


/**
 * Created by MingRen on 2016/8/30.
 */
public class DecoratorTest {
    public static void main(String args[]) {
        Source source = new Source();
        Decorator decorator = new Decorator(source);
        decorator.sing();
    }
}
