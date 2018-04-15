package vincent.datastruct.sort;

import java.util.Arrays;

/**
 * Created by vincent on 2017/3/14.
 * email-address:674928145@qq.com
 * description:二分插入排序，对每一个元素在前面已排序的元素的基础上，进行二分插入排序，
 * 不断的二分区间，确定要插入元素的位置
 */

public class BinaryInsertSort {

    static int[] arr = {5, 8, 11, 0, 4, 3, 45, 33, 96, 50, 23, 12, 21, 44};
    static int count;


    static void binaryInsertSort(int[] arr) {

        //对每一个元素在前面已排序的元素的基础上，进行二分插入排序
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int left = 0;//起始左区间
            int right = i - 1;//起始右区间
            int mid;
            while (left <= right) {
                //每次得到元素中间的索引
                mid = (left + right) / 2;
                if (arr[mid] > temp) {//和索引
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            //到这里left=right，确定了带插入元素的位置

            for (int j = i - 1; j >= left; j--) {//插入排序，必须先移动后面的元素，再移动前面的元素
                arr[j + 1] = arr[j];
            }
            arr[left] = temp;
        }
    }

    public static void main(String[] arg) {
        System.out.println("排序前" + Arrays.toString(arr));
        binaryInsertSort(arr);
        System.out.println("排序后" + Arrays.toString(arr));
        System.out.println("元素的个数" + arr.length + " 排序遍历的次数" + count);

    }

}
