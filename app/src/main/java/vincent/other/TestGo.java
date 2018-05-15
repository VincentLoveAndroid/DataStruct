package vincent.other;

import java.util.HashMap;

/**
 * Created by Vincent on 2018/4/8.
 * email-address:674928145@qq.com
 * description:
 */

public class TestGo {

    IView iView = null;

    //原来的IView接口继承新增的接口
    interface IView{
        void hello();
    }
    //子类
    class View implements IView{

        @Override
        public void hello() {

        }


    }

    public static void main(String arg0[]){
        IView iView = new TestGo().new View();

    }
}
