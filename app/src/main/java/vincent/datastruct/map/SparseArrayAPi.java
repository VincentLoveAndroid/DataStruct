package vincent.datastruct.map;

import android.util.SparseArray;

import java.util.ArrayList;

/**
 * Created by Vincent on 2018/4/19.
 * description:
 */

public class SparseArrayAPi {

    public static void main(String arg0[]){
        test2();
    }

    static void test2() {
        ArrayList<String> list = new ArrayList<>(10);
//        list.add("1");
//        list.add(null);
        System.out.println(list.size());
    }


    static void test() {
        SparseArray<String> sparseArray = new SparseArray<>();
        sparseArray.put(2,"vincent2");

        sparseArray.put(3,"vincent3");
        sparseArray.put(4,"vincent4");
        sparseArray.put(5,"vincent5");
        sparseArray.put(1,"vincent1");


        System.out.println("keyIndex-->"+sparseArray.indexOfKey(1));
        //key的index和对应value的index是一致的，但用indexOfValue(value)方法返回的是第一个匹配该value的index
        System.out.println("valueIndex-->"+sparseArray.indexOfValue("vincent1"));
        System.out.println("keyIndex-->"+sparseArray.indexOfKey(2));
        System.out.println("keyIndex-->"+sparseArray.indexOfKey(3));
        System.out.println("keyIndex-->"+sparseArray.indexOfKey(4));
        System.out.println("keyIndex-->"+sparseArray.indexOfKey(5));
        System.out.println("keyIndex-->"+sparseArray.indexOfKey(5));

    }
}
