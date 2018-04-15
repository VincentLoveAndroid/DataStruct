package vincent.other;

import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vincent on 2018/3/23.
 * email-address:674928145@qq.com
 * description: Integer相关测试
 */

public class IntegerSth {
    public static void main(String arg[]) {
        System.out.println(stringToInteger("11111"));
    }

    /**
     * 字符串转整数算法
     * @param str
     * @return
     */
    private static int stringToInteger(String str) {
        if (str == null || str.length() < 1) {
            throw new IllegalArgumentException("字符串不能为空");
        }
        str = str.trim();//去除尾部空格
        int i = 0;          // index of str
        char flag = '+';    // 正负数标志位，默认是正数
        if (str.charAt(0) == '-') {
            flag = '-';
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }
        double res = 0;
        // abandon the non-digit char; calculate the result
        while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            res = res * 10 + str.charAt(i) - '0';
            i++;
        }
        if (flag == '-') res = -1 * res;
        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) res;
    }

    private static void test1() {
        Integer a = 100;
        Integer b = 100;
        System.out.println(a == b);

        java.lang.Integer a1 = 100;
        int a2 = 100;
        System.out.println(a1 == a2);

        java.lang.Integer c = 200;
        java.lang.Integer d = 200;
        System.out.println(c == d);


        java.lang.Integer e = new java.lang.Integer(100);
        java.lang.Integer f = new java.lang.Integer(100);
        System.out.println(e == f);

    }

    private static void test2() {

        int kk = 1;
        int result = kk++ + 3 << 2;
        System.out.println(result);
        System.out.println(kk);
    }
}
