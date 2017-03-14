package vincent.datastruct.Sort;

import java.util.Arrays;

/**
 * Created by vincent on 2017/3/10.
 * email-address:674928145@qq.com
 * description:直接插入排序，从第二个元素开始，以其作为待插入元素，插入到前面已排好序的元素上面
 */

public class InsertSort {


    static int[] arr = {5, 8, 11, 0, 4, 3, 45, 33, 96,50,23,12,21,44};
    static int count;//记录遍历次数

    static void insertSort(int arr[]) {
        for (int i = 1; i < arr.length - 1; i++) {
            //待插入的元素
            int temp = arr[i];
            int j;//检索元素游标
            for (j = i - 1; j >= 0; j--) {
                count++;
                if (arr[j] > temp) {//从后往前数，遇到比temp大的数值，都往后移动一位，否则找到了适当的位置，跳出遍历
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            //两种情况：①执行了break语句，插入首个比其小的元素的后面，②没执行break语句，即所有元素都比其大，那么插在首位置，也就是遍历完后的j+1
            arr[j + 1] = temp;
        }
    }

    public static void main(String arg[]) {
        System.out.println("排序前" + Arrays.toString(arr));
        insertSort(arr);
        System.out.println("排序后" + Arrays.toString(arr));
        System.out.println("元素的个数" + arr.length + " 排序遍历的次数" + count);
    }

}
