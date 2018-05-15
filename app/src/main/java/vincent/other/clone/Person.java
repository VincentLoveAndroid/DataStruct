package vincent.other.clone;

/**
 * Created by Vincent on 2018/4/22.
 * description:
 */

public class Person implements Cloneable {

    public String name;
    public int age;

    public Student stu;
    public Student2 stu2;

    @Override
    protected Object clone() {
        //浅拷贝
        Person p = null;
        try {
            p = (Person) super.clone();
            //深度拷贝
            if (p != null) {
                p.stu = (Student) stu.clone();
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return p;
    }
}
