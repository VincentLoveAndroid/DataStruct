package vincent.datastruct.Sort;

import java.util.Arrays;

/**
 * Created by vincent on 2017/3/14.
 * email-address:674928145@qq.com
 * description:
 */

public class SortTest {

    static int[] arr = { 5, 8, 11, 0, 4, 3, 45, 33, 96, 50, 23, 12, 21, 44 };
    static int count;



    public static void main(String arg[]) {
        System.out.println("排序前" + Arrays.toString(arr));
//        shellSort(arr);
        System.out.println("排序后" + Arrays.toString(arr));
        System.out.println("元素的个数" + arr.length + " 排序遍历的次数" + count);
    }
}
