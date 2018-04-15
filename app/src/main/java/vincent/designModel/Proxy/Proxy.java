package vincent.designModel.Proxy;

/**
 * Created by MingRen on 2016/8/29.
 * email:674928145@qq.com
 * address:shenzhen
 *和Source一样实现了Sourceable接口，并且持有source，可以拓展source的sing方法
 *代理模式给某一个对象提供一个代理对象，并由代理对象控制对原对象的引用。
 */
public class Proxy implements Sourceable {

    private Source source;

    public Proxy() {
        this.source = new Source();
    }

    @Override
    public void sing() {
        source.sing();
        System.out.println("dancing");
    }
}
