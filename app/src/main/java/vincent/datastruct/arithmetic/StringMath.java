package vincent.datastruct.arithmetic;

/**
 * Created by Vincent on 2018/4/21.
 * description:和字符串相关的算法
 */

public class StringMath {

    public static void main(String arg0[]){

    }

    /**
     * 将一个字符串转换成int型数字，考虑 错误输入，溢出，正负值等一些条件
     * @param s
     * @return
     */
    static int StringToInt(String s) {
        int num=0;

        char[] c = s.toCharArray();
        Integer[] ints = new Integer[c.length];
        for (int i = 0; i < c.length; i++) {
            ints[i] = c[i] - '0';
        }
        Double result = 0D;
        for (int i = 0; i < ints.length; i++) {
            result += (ints[i] * Math.pow(10, (ints.length - 1 - i))); // Math.pow得到的是一个Double型，所以result也要定义为Double型
        }
        Integer n = result.intValue();// Double型转换成int型直接使用intValue()即可
        System.out.println(n);
        System.out.println(n.TYPE);
        return num;
    }
}
