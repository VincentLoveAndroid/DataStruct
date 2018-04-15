package vincent.designModel.Factory;

/**
 * Created by MingRen on 2016/8/29.
 * email:674928145@qq.com
 * address:shenzhen
 */
public class SenderFactory {

    public static Sender produce(int type) {
        switch (type) {
            case 0:
                return new EmailSender();
            case 1:
                return new PhoneSender();
            default:
                return new EmailSender();
        }
    }
}
