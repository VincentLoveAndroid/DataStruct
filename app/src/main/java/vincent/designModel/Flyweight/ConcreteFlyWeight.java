package vincent.designModel.Flyweight;

/**
 * Created by MingRen on 2016/8/30.
 */
public class ConcreteFlyWeight implements FlyWeight {

    private Character internalState;

    public ConcreteFlyWeight(Character internalState) {//表示内部状态
        this.internalState = internalState;
    }

    @Override
    public void operation(String externalState) {
        System.out.println("externalState: " + externalState);//传递进来的参数变化
        System.out.println("internalStaTE: " + this.internalState);//内部状态不变
    }
}
