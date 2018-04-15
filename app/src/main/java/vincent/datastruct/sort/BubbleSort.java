package vincent.datastruct.sort;

import java.util.Arrays;

/**
 * Created by vincent on 2017/3/10.
 * email-address:674928145@qq.com
 * description:冒泡排序，交换排序的一种。每次筛选出该趟最大或者最小值
 */

public class BubbleSort {

    static int[] arr = {5, 8, 11, 0, 4, 3, 45, 33, 96,50,23,12,21,44};
    static int count;

    static void bubbleSort(int[] arr) {
        for (int x = 1; x < arr.length; x++) {
            for (int i = 0; i < arr.length - x; i++) {
                count++;
                int j = i + 1;
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
        bubbleSort(arr);
        System.out.println("排序后" + Arrays.toString(arr));
        System.out.println("元素的个数" + arr.length + " 排序遍历的次数" + count);

    }

}
