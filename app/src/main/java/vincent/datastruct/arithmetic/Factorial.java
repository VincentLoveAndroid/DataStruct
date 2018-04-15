package vincent.datastruct.arithmetic;

/**
 * Created by Vincent on 2018/3/17.
 * email-address:674928145@qq.com
 * description:分别用循环以及递归实现阶乘函数 20!
 */

public class Factorial {

    /**
     * for循环方法实现
     */
    private static int forFactorial(int n) {
        int result = n;

        for (int i = n-1; i > 0; i--) {
            result *= i;
        }

        return result;
    }

    /**
     * 递归方法实现
     * 比如：
     * 假设求解阶乘的函数为f(n)，则
     * 1!=1     -->   f(1)=1
     * 2!=2*1   -->   f(2)=2*f(1)
     * 3!=3*2*1 -->   f(3)=3*f(2)
     * 即 20!=20*19!->f(n)=n*f(n)
     */
    private static int recursionFactorial(int n) {
        if (n == 1) {//n=1时，f(n)=n
            return n;
        }else{//n>1时,f(n)=n*f(n-1)
            return n * recursionFactorial(n - 1);
        }
    }

    public static void main(String arg[]) {
        System.out.println("for循环实现结果--"+forFactorial(20));
        System.out.println("递归实现结果--"+recursionFactorial(20));
    }
}
