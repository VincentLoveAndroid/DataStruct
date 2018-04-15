package vincent.designModel.Command;

/**
 * Created by MingRen on 2016/8/30.
 */
public class Invoker {//调用者负责下达命令

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void order() {//下发命令
        if (command != null) command.sing();
    }
}
