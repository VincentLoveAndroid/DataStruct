package vincent.designModel.Decorator;

/**
 * Created by MingRen on 2016/8/29.
 */
public class Source implements Sourceable {
    @Override
    public void sing() {
        System.out.println("Sourceable-singing");
    }
}
