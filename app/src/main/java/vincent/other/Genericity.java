package vincent.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vincent on 2018/3/23.
 * email-address:674928145@qq.com
 * description:
 */

public class Genericity{

    public static void main(String arg[]) {

        List<? extends Fruit> fList = new ArrayList<>();
        Fruit fruit = fList.get(0);

//        fList.add(new Food());
//        fList.add(new Apple());
//        fList.add(new Fruit());
//        fList.add(null);
////
//        List<? super Fruit> fList2= new ArrayList<>();
//
//        fList2.add(new Food());
//        fList2.add(new Apple());
//        fList2.add(null);


    }
    static class Food{}
    static class Fruit extends Food {}
    static class Apple extends Fruit {}
}
