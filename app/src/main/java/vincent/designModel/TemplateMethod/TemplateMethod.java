package vincent.designModel.TemplateMethod;

/**
 * Created by MingRen on 2016/8/30.
 * email:674928145@qq.com
 * address:shenzhen
 */
public abstract class TemplateMethod {

    public void init() {//模板方法，调用抽象方法，让子类实现抽象方法
        initView();
        initEvent();
    }

    public abstract void initView();

    public abstract void initEvent();

}
