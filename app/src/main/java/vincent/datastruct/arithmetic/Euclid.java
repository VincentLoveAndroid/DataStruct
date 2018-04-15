package vincent.datastruct.arithmetic;

/**
 * Created by Vincent on 2018/3/17.
 * email-address:674928145@qq.com
 * description:利用欧几里得算法结合递归求两个非负整数的最大公约数
 *
 * 欧几里得算法：有两个数，m和n，并且m>n，则m和n的最大公约数为m%n(m和n的余数)和n的最大公约数
 */

public class Euclid {


    private static int gdc(int m,int n) {
        System.out.println(m+"和"+n+"的最大公约数为");
        if (n == 0) {//如果n为0，则最大公约数即为m
            return m;
        }else{
            return gdc(n, m % n);
        }
    }



    public static void main(String arg[]) {
        int x = gdc(55,44);
        System.out.println(x);
    }
}
