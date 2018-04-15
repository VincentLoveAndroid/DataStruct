package vincent.datastruct.map;

import java.util.*;

/**
 * Created by Vincent on 2018/3/31.
 * email-address:674928145@qq.com
 * description:
 */

public class Test {

    public static void main(String arg[]) {
        Test test = new Test();

        test.linkedHashMapTest();

        test.hashMapTest();

    }

    /**
     * LinkedHashMap默认按插入顺序排序
     */
    private void linkedHashMapTest() {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        map.put(1, "aa");
        map.put(3, "cc");
        map.put(2, "bb");
        map.put(4, "dd");
        map.put(5, "ee");

        Set<Map.Entry<Integer, String>> entries = map.entrySet();

        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println("LinkedHashMap default get" + entry.getKey() + ":" + entry.getValue());
        }

        LinkedHashMap<Integer, String> map2 = new LinkedHashMap<>(4,0.75f,true);
        map2.put(1, "aa");
        map2.put(3, "cc");
        map2.put(2, "bb");
        map2.put(4, "dd");
        map2.put(5, "ee");

        Set<Map.Entry<Integer, String>> entries2 = map2.entrySet();
        map2.get(2);

        for (Map.Entry<Integer, String> entry : entries2) {
            System.out.println("LinkedHashMap accessOrder get" + entry.getKey() + ":" + entry.getValue());
        }
    }

    private void hashMapTest() {
        java.util.HashMap<Integer, String> map = new java.util.HashMap<>();
        map.put(1, "aa");
        map.put(3, "cc");
        map.put(2, "bb");
        map.put(4, "dd");
        map.put(5, "ee");

        Set<Map.Entry<Integer, String>> entries = map.entrySet();

        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println("HashMap get" + entry.getKey() + ":" + entry.getValue());
        }
    }


}
