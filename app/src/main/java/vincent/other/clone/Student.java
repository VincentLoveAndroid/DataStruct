package vincent.other.clone;

/**
 * Created by Vincent on 2018/4/22.
 * description:
 */

public class Student implements Cloneable{

    public String name;
    public int age;


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
