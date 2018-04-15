package vincent.designModel.Observer;

/**
 * Created by MingRen on 2016/8/30.
 */
public class ObserverTest {
    public static void main(String args[]) {
        MySubject subject = new MySubject();
        Observer1 observer1 = new Observer1();
        Observer2 observer2 = new Observer2();

        subject.addObserver(observer1);
        subject.addObserver(observer2);
        subject.addObserver(observer2);//此时vector中有三个元素1,2,2
        subject.update();

        subject.removeObserver(observer2);//移除第一个2，集合中还有1,2
        subject.update();
    }
}
