package vincent.other.clone;

/**
 * Created by Vincent on 2018/4/22.
 * description:深拷贝以及浅拷贝测试
 */

public class CloneTest {

    public static void main(String arg0[]) {
        cloneTest();
    }


    static void cloneTest() {
        Person p = new Person();
        p.age = 10;
        p.name = "大神";
        p.stu = new Student();
        p.stu.age = 25;
        p.stu.name = "Vincent";

        p.stu2 = new Student2();
        p.stu2.age = 30;
        p.stu2.name = "jack";

        System.out.println("拷贝前 " + p +" "+p.stu+" "+p.stu2);


        Person newP = (Person) p.clone();

        System.out.println("深拷贝后 " + newP+" "+newP.stu+" "+p.stu2);

    }

}
