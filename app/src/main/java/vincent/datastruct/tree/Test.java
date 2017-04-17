package vincent.datastruct.tree;

import vincent.datastruct.map.HashMap;

/**
 * Created by vincent on 2017/2/23.
 * email-address:674928145@qq.com
 * description:
 */

public class Test {

    public static void main(String[] arg) {
//        switch (1) {
//            case 1:
//                System.out.println("我是一啊");
//            default:
//                System.out.println("哈哈");
//
//        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < 150; i++) {
            hashMap.put(i, i);
        }
        for (int i = 0; i < 150; i++) {
            System.out.println(hashMap.get(i));
        }
    }
}
