package vincent.designModel.Factory;

/**
 * Created by MingRen on 2016/8/29.
 */
public class EmailSender implements Sender {
    @Override
    public void send() {
        System.out.println("email-send");
    }
}
