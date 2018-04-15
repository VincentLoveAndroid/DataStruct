package vincent.designModel.Command;

/**
 * Created by MingRen on 2016/8/30.
 */
public class MyCommand implements Command {

    private Receiver receiver;


    public MyCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void sing() {//命令接收者唱歌
        if (receiver != null) receiver.sing();
    }
}
