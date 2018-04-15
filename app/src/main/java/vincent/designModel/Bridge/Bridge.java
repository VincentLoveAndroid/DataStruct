package vincent.designModel.Bridge;

/**
 * Created by MingRen on 2016/8/29.
 * email:674928145@qq.com
 * address:shenzhen
 */
public abstract class Bridge {//抽象层

    protected Sourceable source;

    protected abstract void setSource(Sourceable source);

    protected abstract void sing();
}
