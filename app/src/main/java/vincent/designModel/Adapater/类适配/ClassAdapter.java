package vincent.designModel.Adapater.类适配;


/**
 * Created by MingRen on 2016/8/29.
 * email:674928145@qq.com
 * address:shenzhen
 * 类适配器模式：把适配的类的API转换成为目标类的API。
 */
public class ClassAdapter extends Source implements Targetable {
    //适配器将某个类转化成客户端期望的表示，sing方法为Source所实现
    @Override
    public void dance() {//Source中原本没有该方法
        System.out.println("dancing");
    }
}
