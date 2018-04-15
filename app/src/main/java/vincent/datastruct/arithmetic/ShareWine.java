package vincent.datastruct.arithmetic;

/**
 * Created by Vincent on 2018/3/17.
 * email-address:674928145@qq.com
 * description:泊松分酒问题
 */

public class ShareWine {
    private static int glass1 = 12;
    private static int glass2 = 8;
    private static int glass3 = 5;

    private static int desti = 6;//目标酒量


    /**
     * 倒酒规则：
     * ①顺序：1->2->3->1
     * ②每次应该把要倒的酒杯倒满
     */
    private static void pourWine(int g1, int g2, int g3) {
        System.out.println("酒杯1酒量:" + g1 + " 酒杯2酒量:" + g2 + " 酒杯3酒量:" + g3);
        if (g1 == desti || g2 == desti || g3 == desti) {
            return;
        }

        //酒杯1有酒并且，酒杯2没倒满
        if (g1 != 0 && g2 != glass2) {
            if (g1 + g2 < glass2) {//倒不满酒杯2
                pourWine(0, g1 + g2, g3);
            } else {//倒满酒杯2
                pourWine(g1 + g2 - glass2, glass2, g3);
            }
        }
        //酒杯2倒满了,往瓶子3倒
         if (g2 == glass2) {
            if (g2 + g3 < glass3) {//倒不满酒杯3
                pourWine(g1, 0, g2 + g3);
            } else {//倒满酒杯3
                pourWine(g1, g2 + g3 - glass3, glass3);
            }
        }
        //酒杯1没酒了，可以从瓶子3里面倒瓶子1了
         if (g1 == 0) {
            if (g3 > glass1) {
                pourWine(glass1, g2, g3 - glass1);
            } else {
                pourWine(g3, g2, 0);
            }
        }

//        //酒杯1有酒并且，酒杯2没倒满
//        if (g2 != 0 && g3 != glass3) {
//            if (g2 + g3 < glass3) {//倒不满酒杯2
//                pourWine(g1, 0, g3);
//            } else {//倒满酒杯2
//                pourWine(g1, glass2, g2+g3-glass3);
//            }
//        }
//        //酒杯2倒满了,往瓶子3倒
//        if (g3 == glass3) {
//            if (g3 + g1 < glass1) {//倒不满酒杯1
//                pourWine(g1+g3, g2,0);
//            } else {//倒满酒杯3
//                pourWine(glass1, g2, g1+g3-glass1);
//            }
//        }
//        //酒杯1没酒了，可以从瓶子3里面倒瓶子1了
//        if (g2 == 0) {
//            if (g1> glass2) {
//                pourWine(g1-glass2,glass2, g3);
//            } else {
//                pourWine(0, g1, g3);
//            }
//        }
    }


    public static void main(String arg[]) {
        pourWine(12, 0, 0);
    }
}
