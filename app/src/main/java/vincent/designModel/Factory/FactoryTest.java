package vincent.designModel.Factory;

/**
 * Created by MingRen on 2016/8/29.
 */
public class FactoryTest {
    public static void main(String[] args) {
        Sender sender = SenderFactory.produce(0);
        sender.send();
    }
}
