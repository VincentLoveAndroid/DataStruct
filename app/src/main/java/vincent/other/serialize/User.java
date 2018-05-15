package vincent.other.serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by Vincent on 2018/4/19.
 * description:Serializable方法序列化，serialVersionUID反序列化作用
 */

public class User implements Serializable {

//    private static final long serialVersionUID = 1L;

    static int no;//静态变量不参与序列化
    private transient int age;//transient修饰不参与序列化
    private String name;

    public User(int age, String name,int no) {
        this.age = age;
        this.name = name;
        this.no = no;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", no='" + no + '\'' +
                '}';
    }

    public static void main(String arg0[]){
        //序列化过程
        User user = new User(25, "Vincent",27);
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("cache.txt"));
            out.writeObject(user);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //反序列化过程
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("cache.txt"));
            User newUser = (User) in.readObject();
            in.close();
            System.out.println(newUser.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
