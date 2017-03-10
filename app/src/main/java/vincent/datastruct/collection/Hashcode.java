package vincent.datastruct.collection;

/**
 * Created by vincent on 2017/3/8.
 * email-address:674928145@qq.com
 * description:重写了equal方法，一般也要重写它的hashcode方法，
 * 达到equal为true的值，其有相同的hashcode值
 */

public class Hashcode {

    private static class Hash {

        private int i;

        public void setI(int i) {
            this.i = i;
        }

        public int getI() {
            return i;
        }

        /**
         * hashcode方法重写了，也要重写equals方法，判断两个对象是否相等。
         *
         * @param obj
         * @return
         */
        @Override
        public boolean equals(Object obj) {
            //自反性
            if (obj == this) return true;

            //非空性
            if (obj == null) {
                return false;
            }

//            if (!(obj instanceof Hash)) {
//                return false;
//            }
            //解决了 对称性  传递性  一致性 问题
            //注意不能替换成用instanceof关键字判断,因为instanceof判断时它的超类和自己的类型都会是ture，
            // 它不能保证两者是同一个类型。而getClass方法返回的是运行时的类型，它只有一个。

            if (getClass() != obj.getClass()) {
                return false;
            }

            Hash otherHash = (Hash) obj;

            if (i == otherHash.getI()) {
                return true;
            }

            return false;
        }

        @Override
        public int hashCode() {
            return i % 10;//重写Hashcode方法
        }
    }

    public static void main(String arg0[]) {

        Hash a = new Hash();
        a.setI(1);

        Hash b = new Hash();

        b.setI(11);
//
        System.out.println("HashCode相比较 " + (a.hashCode() == b.hashCode()));
        System.out.println("equals相比较 " + a.equals(b));
    }
}
