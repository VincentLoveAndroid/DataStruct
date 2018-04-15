package vincent.other;

import java.util.HashMap;

import vincent.designModel.Adapater.类适配.Source;

/**
 * Created by Vincent on 2018/4/8.
 * email-address:674928145@qq.com
 * description:
 */

public class Test {

     private int aa;

    public static void main(String arg0[]){
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "vincent");
        String value = map.put(1, "jack");

        System.out.println("oldValue----"+value);


    }



    private   class aa{

        private void test() {
        }
    }
}
