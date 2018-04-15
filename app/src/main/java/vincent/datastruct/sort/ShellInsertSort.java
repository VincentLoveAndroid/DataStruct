package vincent.datastruct.sort;

import java.util.Arrays;

/**
 * Created by vincent on 2017/3/10.
 * email-address:674928145@qq.com
 * description:希尔排序(缩小增量插入排序)，直接插入排序的改良，每次排序根据增量d分成d组，
 * 然后分别进行插入排序，排序完成增量的d变成原来的一半，知道增量d变为1
 */
public class ShellInsertSort {

	static int[] arr = { 5, 8, 11, 0, 4, 3, 45, 33, 96, 50, 23, 12, 21, 44 };
	static int count;

	static void shellSort(int arr[]) {
		int d = arr.length;
		while (true) {
			d = d / 2;
			for (int x = 0; x < d; x++) {
				for (int i = x + d; i < arr.length; i = i + d) {
					int j;
					int temp=arr[i];//暂存待插入的值ֵ
					for (j = i - d; j >= 0; j = j - d) {
						count++;
						if (arr[i] < arr[j]) {
							arr[j + d] =arr[j];
						} else {
//							arr[j + d] = temp;//放在里面则没进入else的时候，即每一个数都别待插入的大的时候，没有给temp插入位置
							break;
						}
					}	
					arr[j + d] = temp;//两种情况：①执行了break语句，插入首个比其小的元素的后面，②没执行break语句，即所有元素都比其大，那么插在首位置，也就是遍历完后的j+d
				}
			}
			if (d == 1)
				break;
		}
	}

	public static void main(String arg[]) {
		System.out.println("排序前" + Arrays.toString(arr));
		shellSort(arr);
		System.out.println("排序后" + Arrays.toString(arr));
		System.out.println("元素的个数" + arr.length + " 排序遍历的次数" + count);
	}

}
