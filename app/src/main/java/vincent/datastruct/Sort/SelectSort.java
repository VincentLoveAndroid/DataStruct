package vincent.datastruct.Sort;

import java.util.Arrays;

/**
 * Created by vincent on 2017/3/10.
 * email-address:674928145@qq.com
 * description:选择排序，从第一个开始，和后面的元素逐一比较，每一趟筛选出最大或者最小值
 */

public class SelectSort {

    static int[] arr = {5, 8, 11, 0, 4, 3, 45, 33, 96, 50, 23, 12, 21, 44};
    static int count;//记录遍历次数

    static void exchangeSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                count++;
                if (arr[i] > arr[j]) {
                    int temp;
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }

            }
        }
    }

    public static void main(String[] arg) {
        System.out.println("排序前" + Arrays.toString(arr));
        exchangeSort(arr);
        System.out.println("排序后" + Arrays.toString(arr));
        System.out.println("元素的个数" + arr.length + " 排序遍历的次数" + count);

    }
}
