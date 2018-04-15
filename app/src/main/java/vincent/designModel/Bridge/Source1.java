package vincent.designModel.Bridge;

/**
 * Created by MingRen on 2016/8/30.
 */
public class Source1 implements Sourceable {
    @Override
    public void sing() {
        System.out.println("source1-sing");
    }
}
