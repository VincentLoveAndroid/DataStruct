package vincent.datastruct.sort;

import java.util.Arrays;

/**
 * Created by vincent on 2017/3/14.
 * email-address:674928145@qq.com
 * description:
 */

public class SortTest {

    static int[] arr = {5, 8, 11, 0, 4, 3, 45, 33, 96, 50, 23, 12, 21, 44,
            1, 2, 6, 7, 9, 10, 13, 14, 15};
    static int count;


    public static void main(String arg[]) {
        System.out.println("排序前" + Arrays.toString(arr));
//        shellSort(arr);
//        insertSort(arr);z
//        heapSort(arr, arr.length - 1);
//        bubbleSort(arr);
//        selectSort(arr);
        binaryInsertSort(arr);
//        quickSort(arr, 0, arr.length - 1);
        test();
//        insertSort(arr);
        System.out.println("排序后" + Arrays.toString(arr));
        System.out.println("元素的个数" + arr.length + " 排序遍历的次数" + count);
    }

    /**
     * 大顶堆排序,
     * ①从堆中最后一个节点的双亲节点开始，每一趟排序让最大的元素位于堆顶
     * ②将堆顶元素放在数组末尾，不参与下一次的堆排序
     */
    static void heapSort(int arr[], int lastIndex) {
        if (lastIndex != 0) {
            //从最后一个节点的双亲节点开始,找出其左右孩子的最大一个和双亲节点进行比较，
            //如果比双亲节点要大，则交换位置
            for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
                int leftIndex = 2 * i + 1;
                int rightIndex = 2 * i + 2;
                int biggerIndex = leftIndex;//暂定左孩子为较大节点
                //最后一个双亲节点有可能没有右孩子,此时较大的节点就是左孩子
                if (rightIndex <= lastIndex) {
                    if (arr[rightIndex] > arr[leftIndex]) {
                        biggerIndex = rightIndex;
                    }
                }
                //左右孩子较大一个和双亲节点比较，比其大则交换位置
                if (arr[biggerIndex] > arr[i]) {
                    int temp = arr[biggerIndex];
                    arr[biggerIndex] = arr[i];
                    arr[i] = temp;
                }
            }
            //这里一趟排序结束，堆顶就是最大元素,放到数组末尾
            int temp = arr[0];
            arr[0] = arr[lastIndex];
            arr[lastIndex] = temp;

            lastIndex--;

            heapSort(arr, lastIndex);

        }
    }

    /**
     * 从第一个元素开始，和后面的元素比较，如果比后面的元素大，
     * 交换位置，一趟排序得出最大元素在数组末尾，下次排序不参与排序。
     *
     * @param arr
     */
    static void bubbleSort(int arr[]) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                count++;
                int k = j + 1;
                if (arr[j] > arr[k]) {
                    int temp = arr[j];
                    arr[j] = arr[k];
                    arr[k] = temp;
                }
            }
        }
    }

    /**
     * 从第一个元素开始，和后面的元素进行两两比较，较小的元素和之进行交换
     */
    static void selectSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                count++;
                //如果比后面的元素大，交换位置，让小的在前面
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 插入排序：从第二个元素开始，每次和由后往前进行比较，所有比其大的元素，都往后移动一位，
     * 直到遇到第一个比它小的元素，插入到此元素的后面，
     */

    static void insertSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (temp < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {//遇到比其小的元素，跳出循环
                    break;
                }
            }
            //来到这里有两种情况，
            // ①执行了遇到比其小的元素，执行了break，j没有-1
            // ②所有元素都比该元素大，该元素插入到arr[0]的位置，循环完成，j=-1
            arr[j + 1] = temp;
        }

    }

    /**
     * 二分插入排序，在类似于插入排序，但是和插入排序不同，每一趟排序是险用二分法确认元素的位置，
     * 再将待插入元素到待插入位置的所有元素从后面的元素开始，都后移一位，再插入待插入元素
     */

    static void binaryInsertSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            //待插入元素
            int temp = arr[i];
            int lo = 0;
            int hi = i - 1;
            while (lo <= hi) {//有可能重合，得出中值位置
                int mid = (lo + hi) >>> 1;
                int midValue = arr[mid];
                //一般数组里都是不同的元素，这里不相等
                if (midValue < temp) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            //到这里，lo>hi，确认了待插入元素的位置为arr[lo],为什么是lo？
            for (int j = i; j >lo; j--) {
                arr[j] = arr[j - 1];
            }
            arr[lo] = temp;
        }

    }


//
//    /**
//     * 二分插入排序，从第二个元素开始，对前面的有序元素，进行二分查找，
//     * 查找中间元素，确定新的二分区间，从而确定插入的位置,确定了位置之后
//     * 再往后移动元素
//     *
//     * @param arr
//     */
//    static void binaryInsertSort(int arr[]) {
//        int i;
//        for (i = 1; i < arr.length; i++) {
//            int temp = arr[i];
//            int lo = 0;
//            int hi = i - 1;
//            while (lo <= hi) {//这里等号一定要
//                int mid = (lo + hi) >>> 1;
//                int midValue = arr[mid];
//                if (arr[i] > midValue) {
//                    lo = mid + 1;
//                } else if (arr[i] < midValue) {
//                    hi = mid - 1;
//                }
//            }
//            //这里lo=hi,去人了带插入元素的位置为lo(hi)
//
//            for (int j = i; j > lo; j--) {
//                arr[j] = arr[j - 1];
//            }
//            arr[lo] = temp;
//        }
//
//    }

    static void test() {
        int i;
        for (i = 0; i < 10; i++) {
            if (i == 3) {
                break;
            }
        }
        System.out.println(i);
    }

    /**
     * 关键两个方法：
     * ①递归的quickSort方法
     * ②获取基准元素位置的getMiddle方法
     */
    private static void quickSort(int arr[], int left, int right) {
        if (left < right) {
            //每一趟排序确定基准元素的位置，所有比它小的位于它左边，比它大的位于它右边，
            //然后左右两个区间分别进行排序
            int middle = getMiddle(arr, left, right);
            quickSort(arr, left, middle - 1);
            quickSort(arr, middle + 1, right);
        }
    }

    private static int getMiddle(int arr[], int left, int right) {
        //以左边第一个数作为基准元素，有左右两个指针
        int temp = arr[left];
        //只要左指针小于右指针，循环移动
        while (left < right) {
            //如果右指针的元素比基准元素大，指针左移，直到比基准元素小，交换位置
            while (left < right && temp < arr[right]) {
                right--;
            }
            arr[left] = arr[right];
            arr[right] = temp;//此时右指针指向基准元素
            //如果左指针的元素比右指针的元素小，指针右移，直到比基准元素大，交换位置
            while (left < right && temp > arr[left]) {
                left++;
            }
            arr[right] = arr[left];
            arr[left] = temp;//此时，左指针指向基准元素
        }
        //此时左右指针重合
        int middle = left;
        arr[middle] = temp;
        return middle;
    }
}
