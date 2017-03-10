package vincent.datastruct.Sort;

import java.util.Arrays;

/**
 * Created by vincent on 2017/3/10.
 * email-address:674928145@qq.com
 * description:是对冒泡排序的一种改进，同属于交换排序
 */

public class QuickSort {

    static int[] arr = {5, 8, 11, 0, 4, 3, 45, 33, 96, 50, 23, 12, 21, 44};
    static int count;


    static void quickSort(int[] arr, int leftPoint, int rightPoint) {
        count++;
        if (leftPoint < rightPoint) {
            int middle = getMiddle(arr, leftPoint, rightPoint);
            quickSort(arr, leftPoint,middle - 1);
            quickSort(arr, middle + 1, rightPoint);
        }


    }

    static int getMiddle(int[] arr, int leftPoint, int rightPoint) {
        int temp = arr[leftPoint];
        while (leftPoint < rightPoint) {
            while (leftPoint < rightPoint && temp < rightPoint) {
                rightPoint--;
            }
            arr[leftPoint] = arr[rightPoint];
            arr[rightPoint] = temp;

            while (leftPoint < rightPoint && temp > leftPoint) {
                leftPoint++;
            }
            arr[rightPoint] = arr[leftPoint];
            arr[leftPoint] = temp;
        }

        int middle = leftPoint;
        arr[leftPoint] = temp;
        return middle;
    }

    public static void main(String arg[]) {
        System.out.println("排序前" + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后" + Arrays.toString(arr));
        System.out.println("元素的个数" + arr.length + " 排序遍历的次数" + count);
    }
}
