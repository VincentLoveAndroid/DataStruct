package vincent.designModel.SingleTon;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * Created by MingRen on 2016/8/31.
 * 饿汉式，加载类的时候，就创建了对象
 */
public class HungrySingleTon implements Serializable{

    private static final HungrySingleTon hungrySingleTon = new HungrySingleTon();

    private HungrySingleTon() {}

    public HungrySingleTon getHungrySingleTon() {
        return hungrySingleTon;
    }

}
