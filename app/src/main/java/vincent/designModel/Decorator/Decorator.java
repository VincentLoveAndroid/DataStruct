package vincent.designModel.Decorator;

/**
 * Created by MingRen on 2016/8/29.
 * email:674928145@qq.com
 * address:shenzhen
 */
public class Decorator implements Sourceable {

    private Source source;
    public Decorator(Source source) {
        this.source = source;
    }
    @Override
    public void sing() {
        System.out.println("Decorator-singBefore");
        source.sing();
        System.out.println("Decorator-singAfter");
    }
}
