package vincent.datastruct.set;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by Vincent on 2018/3/21.
 * email-address:674928145@qq.com
 * description:TreeSet的实现其实是基于TreeMap来的。
 * TreeSet一般用于对元素进行排序，其数据结构是红黑树
 */

public class TreeSetAPi {



    static class Student {
        private String name;
        private int age;
        private int tall;//身高

        public Student(int age, int tall, String name) {
            this.name = name;
            this.age = age;
            this.tall = tall;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", tall=" + tall +
                    '}';
        }
    }

    static class StudentAgeComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            //先比较年龄，年龄大的升序排列
            int result = o1.age - o2.age;
            //如果年龄相同，比较身高，身高高的升序排列
            if (result == 0) {
                result = o1.tall - o2.tall;
            }
            return result;
        }
    }

    public static void main(String arg[]) {
        Student stu1 = new Student(10, 175, "A");
        Student stu2 = new Student(11, 175, "B");
        Student stu3 = new Student(11, 170, "C");
        Student stu4 = new Student(12, 175, "D");
        Student stu5 = new Student(12, 175, "E");
        Student stu6 = new Student(12, 178, "F");

        //TreeSet<Student> treeSet = new TreeSet<>();//运行报错
        //由于TreeSet现在放的是自定义类，需要自定义比较器，告诉TreeSet如何进行比较
        TreeSet<Student> treeSet = new TreeSet<>(new StudentAgeComparator());

        treeSet.add(stu1);
        treeSet.add(stu2);
        treeSet.add(stu3);
        treeSet.add(stu4);
        treeSet.add(stu5);
        treeSet.add(stu6);

        Iterator<Student> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            Student next = iterator.next();
            System.out.println(next.toString());
        }

    }
}
