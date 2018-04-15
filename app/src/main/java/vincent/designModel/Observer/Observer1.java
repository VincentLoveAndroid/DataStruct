package vincent.designModel.Observer;

import java.util.Observable;

/**
 * Created by MingRen on 2016/8/30.
 */
public class Observer1 implements Observerable {
    @Override
    public void update() {
        System.out.println("Observer1-receive");
    }
}
