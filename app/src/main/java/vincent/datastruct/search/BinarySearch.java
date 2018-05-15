package vincent.datastruct.search;

/**
 * Created by Vincent on 2018/4/12.
 * email-address:674928145@qq.com
 * description:二分查找
 */

public class BinarySearch {

    public static void main(String arg0[]) {
        System.out.println(~1);//
    }

    /**
     * 二分法查找，省略参数校验
     */
    static int binarySearch(int arr[], int value) {
        int length = arr.length;
        int lo = 0;
        int hi = length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            int midValue = arr[mid];
            if (midValue == value) {
                return mid;//value found
            } else if (midValue < value) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ~lo;//按位非
    }
}
