package vincent.datastruct.arithmetic;

/**
 * Created by Vincent on 2018/3/17.
 * email-address:674928145@qq.com
 * description:汉诺塔问题-递归法解决
 * <p>
 * 问题描述：假设有from,temp,to三个杆子，from杆上叠了n个底面积依次递增的盘子，编号从上开始1-n,要把from杆上的所有盘子移至to杆
 * ，并且底面积大的盘子不能再底面积小的盘子上面，至少需要多少步可以挪完。
 * <p>
 * 思想：
 * ①先把n-1个盘子从from杆借助to杆移至temp杆
 * ②将编号n的盘子从from杆移至to杆
 * ③把n-1个盘子从temp杆借助from杆移至to杆
 */

public class HanNota {

    static int steps = 1;//记录步数

    private static void move(int n, String from, String temp, String to) {
        if (n == 1) {
            moveOne(n, from, to);
        } else {
            //先把第n-1个盘子借助to杆从from杆移到temp杆
            move(n-1,from,to,temp);
            //将编号n的盘子从from杆移至to杆
            moveOne(n,from,to);
            //把n-1个盘子从temp杆借助from杆移至to杆
            move(n-1,temp,from,to);
        }
    }

    private static void moveOne(int n, String from, String to) {
        System.out.println("第"+steps+++"步---"+"移动第" + n + "个盘子" + "从" + from + "到" + to);
    }


    public static void main(String arg[]) {
        move(4,"A","B","C");
    }
}
