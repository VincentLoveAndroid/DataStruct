package vincent.designModel.Command;

/**
 * Created by MingRen on 2016/8/30.
 */
public class CommandTest {
    public static void main(String args[]) {
        Receiver receiver = new Receiver();
        Command command = new MyCommand(receiver);
        Invoker invoker = new Invoker(command);
        invoker.order();
    }
}
