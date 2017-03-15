package vincent.datastruct.Sort;

import java.util.Arrays;

/**
 * Created by vincent on 2017/3/14.
 * email-address:674928145@qq.com
 * description:大堆排序：
 * ①将待排序的序列构成一个大顶堆，此时整个序列的最大值就是根节点
 * ②将其余数组尾部的元素交换位置，此时尾部元素就是最大值
 * ③将剩余n-1个元素重新构成一个大顶堆，如此反复
 */

public class HeapSort {

    static int[] arr = {5, 8, 11, 0, 4, 3, 45, 33, 96, 50, 23, 12, 21, 44};
    static int count;

    static void heapSort(int arr[], int lastIndex) {
        //从最后一个节点的双亲节点开始遍历(最后一个父节点是关键，我们要使每个双亲节点为最大的一项，因此，我们要遍历的是每一个双亲节点)
        if (lastIndex != 0) {
            for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
                int temp = arr[i];//暂存双亲节点
                int leftIndex = 2 * i + 1;
                int rightIndex = 2 * i + 2;
                int biggerIndex = leftIndex;//暂时认为左右孩子中最大的一个是左孩子
                //最后一个双亲节点有可能没有右孩子，特殊处理
                if (i == (lastIndex - 1) / 2) {
                    if (lastIndex % 2 == 0) {//有右孩子
                        if (arr[leftIndex] < arr[rightIndex]) {
                            biggerIndex = rightIndex;
                        }
                    }
                } else {//如果不是最后一个双亲节点，必有左右孩子
                    if (arr[leftIndex] < arr[rightIndex]) {
                        biggerIndex = rightIndex;
                    }
                }
                //左右节点中较大的一个和双亲节点发生交换
                if (arr[biggerIndex] > temp) {
                    swap(i, biggerIndex, arr);
                }
            }
            //每一趟排序后，得到大顶堆的最大元素-即根节点，和最后一个元素发生交换，lastIndex-1再递归进行堆排序
            swap(0, lastIndex, arr);
            lastIndex--;
            heapSort(arr, lastIndex);
        }
    }


    /**
     * 交换元素的位置
     */
    static void swap(int i, int j, int arr[]) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String arg[]) {
        System.out.println("排序前" + Arrays.toString(arr));
        heapSort(arr, arr.length - 1);
        System.out.println("排序后" + Arrays.toString(arr));
        System.out.println("元素的个数" + arr.length + " 排序遍历的次数" + count);
    }

}
