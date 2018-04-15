package vincent.datastruct.map;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Vincent on 2018/3/31.
 * email-address:674928145@qq.com
 * description:
 * ①LinedHashMap继承了HashMap，实现了有序的HashMap
 * ②LinedHashMap的关键结构-双向循环链表，定义了两种模式（对应了accessOrder是否为true）
 * a.插入顺序排序:插入A,B,C则迭代的顺序也是A,B,C
 * b.访问顺序排序:最近一次被访问的元素，放在迭代的后面，比如说先访问B，再访问A，迭代顺序就是C,B,A
 *
 */

public class LinkedHashMapApi {

    public static void main(String arg[]) {

        LinkedHashMapApi test = new LinkedHashMapApi();

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
        map2.get(3);

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
