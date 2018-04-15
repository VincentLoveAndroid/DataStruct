package vincent.designModel.TemplateMethod;

/**
 * Created by MingRen on 2016/8/30.
 */
public class ChildMethod extends TemplateMethod {

    @Override
    public void initView() {//子类实现抽象方法
        System.out.println("initView");
    }

    @Override
    public void initEvent() {//子类实现抽象方法
        System.out.println("initEvent");

    }
}
