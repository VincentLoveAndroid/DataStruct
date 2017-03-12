package vincent.datastruct.Sort;

import java.util.Arrays;

/**
 * Created by vincent on 2017/3/10.
 * email-address:674928145@qq.com
 * description:是对冒泡排序的一种改进，同属于交换排序，每次以第一或者最后一个元素作为基准元素
 * 前后两个游标移动和基准元素比较，每一趟排序直到所有比基准元素小的元素在其前面，所有
 * 比基准元素大的元素在其后面，然后确定基准元素位置后，基准元素前后两个区间再分别进行排序，如此递归。
 */

public class QuickSort {

    static int[] arr = {5, 8, 11, 0, 4, 3, 45, 33, 96, 50, 23, 12, 21, 44};
    static int count;


    static void quickSort(int[] arr, int leftPoint, int rightPoint) {
        count++;
        if (leftPoint < rightPoint) {
            int middle = getMiddle(arr, leftPoint, rightPoint);
            //每次排序根据确定好的基准元素的位置再分前后两个区间，分别进行排序，递归进行。
            quickSort(arr, leftPoint, middle - 1);
            quickSort(arr, middle + 1, rightPoint);
        }
    }

    /**
     * @param arr
     * @param leftPoint  左游标，同时也是基准元素的初始位置
     * @param rightPoint 右游标
     * @return 一趟排序，确定基准元素的位置，并返回该位置
     */
    static int getMiddle(int[] arr, int leftPoint, int rightPoint) {
        int temp = arr[leftPoint];
        while (leftPoint < rightPoint) {
            //右游标数组大于基准元素，往前移，直到小于基准元素，发生交换
            while (leftPoint < rightPoint && temp < arr[rightPoint]) {
                rightPoint--;
            }
            arr[leftPoint] = arr[rightPoint];
            arr[rightPoint] = temp;
           //左游标数组小于基准元素，往后移，直到大于基准元素，发生交换
            while (leftPoint < rightPoint && temp > arr[leftPoint]) {
                leftPoint++;
            }
            arr[rightPoint] = arr[leftPoint];
            arr[leftPoint] = temp;
        }

        int middle = leftPoint;//此时左右游标重合
        arr[leftPoint] = temp;//确定基准元素的位置
        return middle;//返回一趟排序后基准元素的位置
    }

    public static void main(String arg[]) {
        System.out.println("排序前" + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后" + Arrays.toString(arr));
        System.out.println("元素的个数" + arr.length + " 排序遍历的次数" + count);
    }
}
