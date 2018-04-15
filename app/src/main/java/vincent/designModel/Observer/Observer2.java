package vincent.designModel.Observer;

/**
 * Created by MingRen on 2016/8/30.
 */
public class Observer2 implements Observerable {
    @Override
    public void update() {
        System.out.println("Observer2-receive");
    }
}
