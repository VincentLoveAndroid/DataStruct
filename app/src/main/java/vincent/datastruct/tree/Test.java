package vincent.datastruct.tree;

import vincent.datastruct.map.HashMap;
import vincent.datastruct.map.HashMap2;

/**
 * Created by vincent on 2017/2/23.
 * email-address:674928145@qq.com
 * description:
 */

public class Test {

    public static void main(String[] arg) {
        HashMap2<Integer, Integer> map = new HashMap2<>();
        for (int i = 0; i < 1000; i++) {
            map.put(i, i);
        }

        for (int i = 0; i < 1000; i++) {
            System.out.println(map.get(i));
        }

    }
}
