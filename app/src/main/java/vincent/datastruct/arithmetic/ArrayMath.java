package vincent.datastruct.arithmetic;

import org.w3c.dom.ls.LSException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Vincent on 2018/4/20.
 * description:数组相关算法
 */

public class ArrayMath {

    public static void main(String arg0[]) {
//        intString(10);
//        cartesianProduct();
        int i=longestChild();
        System.out.println(i);
    }


    /**
     * 一个无序，不重复数组，输出N个元素，使得N个元素的和相加为M，给出时间复杂度、空间复杂度。
     */

    static void calSum() {

    }

    /**
     * 写出数组的所有子序列,给定一个数组a （可能包含相同的数），求它有多少个不同的子序列。例如a={1,2,1,3}
     * 子序列有 {1} {2} {3} {1,2} {1,3} {1,2} {1,1} {1,3} {2, 1} {2,3} {1,2,1} {1,2,3} {1,1,3} {2,1,3} 等。
     */

    static void childArr() {

    }

    static void intString(int n) {
        String result = "";
        for (int i = 1; i <= n; i++) {
            result += i;
        }
        System.out.println("输入整数n得到的字符串是 " + result);
    }

    /**
     * 给定任意数量一维数组的两个集合，输出所有的笛卡尔积组合。
     * 例如，A={a,b}, B={0,1,2}，则
     * A×B={(a, 0), (a, 1), (a, 2), (b, 0), (b, 1), (b, 2)}
     */
    static void cartesianProduct() {
        String[] A = {"a", "b"};
        String[] B = {"0", "1", "2"};

        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            String a = A[i];
            for (int j = 0; j < B.length; j++) {
                String b = B[j];
                ArrayList<String> merge = new ArrayList<>();
                merge.add(a);
                merge.add(b);
                result.add(merge);
            }
        }
        if (result.size() > 0) {
            System.out.println(result);
        }
    }

    /**
     * 给定N个数，求这N个数的最长上升子序列的长度。
     * 例如：2 5 3 4 1 7 6
     * 最长上升子序列：2,3,4,7和2,3,4,6两种方案，故最长上升子序列长度为4
     */
    static int longestChild() {
        int nums[] = {2, 5, 3, 4, 1, 7, 6};
        if (nums.length == 0) {
            return 0;
        }
        int dp[] = new int[nums.length];
        //遍历每一个数
        for (int i = 0; i < nums.length; i++) {
            //每次遍历深度为1
            dp[i] = 1;
            //遍历从0索引到这个数钱的每一个数
            for (int j = 0; j < i; j++) {
                //如果这个数比前面的数大并且
                if (nums[i] > nums[j] && dp[j] + 1 > dp[i])
                    dp[i] = dp[j] + 1;
            }
        }
        int max =0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
}

    /**
     * n*m的矩阵，能形成几个正方形
     *
     * 如：2*2，1个  2*3 2个 2
     */


    /**
     *  算法 n/m，怎么判断得数是无限循环小数。
     */


    /**
     * 将一个数组的正负数分割开来，要求时间复杂度O(n),空间复杂度O(1)
     *
     * @param arr
     */
    static void divideNum(int[] arr) {
        int firstIndex = 0;
        int lastIndex = arr.length - 1;
        while (firstIndex < lastIndex) {
            while (firstIndex < lastIndex && arr[firstIndex] < 0) {
                firstIndex++;
            }

            while (firstIndex < lastIndex && arr[lastIndex] > 0) {
                lastIndex--;
            }
            int temp = arr[firstIndex];
            arr[firstIndex] = arr[lastIndex];
            arr[lastIndex] = temp;
        }
    }

    /**
     * 从一个数组中筛选出重复次数最多而且最大的值，
     * 利用HashSet 放入相同的数据会失败返回false的特性
     *
     * @param arr
     */
    static void maxCountValue(int[] arr) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            boolean add = set.add(arr[i]);
            if (!add) {
                Integer count = map.get(arr[i]);
                map.put(arr[i], count + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        Iterator<Map.Entry<Integer, Integer>> iter = map.entrySet().iterator();
        int count = -1;
        int maxContMaxValue = -1;
        while (iter.hasNext()) {
            Map.Entry<Integer, Integer> entry = iter.next();
            if (entry.getValue() > count) {
                count = entry.getValue();
                maxContMaxValue = entry.getKey();
            } else if (entry.getValue() == count) {
                if (entry.getKey() > maxContMaxValue) {
                    maxContMaxValue = entry.getKey();
                }
            }
        }

        System.out.println("出现次数最多且最大的值是 " + maxContMaxValue + "出现次数 " + count);
    }

    /**
     * 排序只有1，2，3三个元素的数组，不能统计1，2，3的个数。
     */

    //思路1：遍历数组，遇到1放到最前面，遇到3放到最后面

    /**
     * 最大连续子序列求和，需要注意全是负数的处理，
     */

    static int MaxSubSequence(int A[]) {
        int ThisSum, MaxSum, i, j, k;
        int N = A.length;
        MaxSum = 0;
        //确定起点
        for (i = 0; i < N; i++) {
            //确定终点
            for (j = i; j < N; j++) {
                ThisSum = 0;
                //计算起点到终点的和
                for (k = i; k <= j; k++) {
                    ThisSum += A[k];
                }
                if (ThisSum > MaxSum)
                    MaxSum = ThisSum;
            }
        }
        return MaxSum;
    }


}
