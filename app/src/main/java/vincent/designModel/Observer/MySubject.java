package vincent.designModel.Observer;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by MingRen on 2016/8/29.
 * email:674928145@qq.com
 * address:shenzhen
 */
public class MySubject extends AbstractSubject {
    private Vector<Observerable> observers = new Vector<>();

    @Override
    public void addObserver(Observerable observer) {
        observers.add(observer);

    }

    @Override
    public void removeObserver(Observerable observer) {
        observers.remove(observer);//移除第一个出现的元素
    }

    @Override
    public void notifyObserver() {
        Enumeration<Observerable> element = observers.elements();
        while (element.hasMoreElements()) {
            element.nextElement().update();
        }

    }

    @Override
    public void update() {
        System.out.println("updateitSelf");
        notifyObserver();
    }
}
