package vincent.datastruct.LinekedList;

/**
 * Created by Vincent on 2018/3/13.
 * email-address:674928145@qq.com
 * description:单链表反转
 * <p>
 * 将原链表：0->1->2->3 反转为新链表：0<-1<-2<-3
 */

public class ReverseLinkedList {

    private Node head;//保存头节点指针
    private Node current;//指向当前节点
    private Node currentNext;//指向当前节点的下一个节点

    static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }

    private void initNode() {
        Node<Integer> node0 = new Node<>(0);
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;

        head = node0;
    }

    private void reverseLinkedList() {
        current = head;
        while (current != null) {
            if (current.next != null) {
                currentNext = current.next;
            } else {
                head = current;
            }
            current = currentNext;
            currentNext = current.next;
        }
    }

    private void print() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public static void main(String arg0[]) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.initNode();
        list.print();

        list.reverseLinkedList();
        list.print();
    }

//    将原链表: 
//            0->1->2->3 
//    反转为新链表: 
//            3->2->1->0 
//    反转链表的一般思路是使用三个指针。其中，一个指针为当前节点，一个指针指向当前节点的下一个节点，另外一个节点则指向新链表表头从而保存结果。
//    public class Reversed_MyLinkedList {
//
//        public static Node reversed_linkedlist() {
//            MyLinkedList list = new MyLinkedList();
//            Node head = list.init();
//
//            if(head == null || head.next == null) {
//                return head;
//            }
//
//            //使用三个节指针
//            Node current = head;
//            Node newHead = null;
//            Node next = null;
//
//            while(current != null) {
//                //先将当前节点的下个节点保存
//                next = current.next;
//
//                current.next = newHead; //将原来的链表断链,将current的下一个结点指向新链表的头结点
//                newHead = current; //将current设为新表头
//
//                current = next; //将之前保存的next设为下一个节点
//            }
//            return newHead;
//        }
//
//        public static void main(String[] args) {
//            MyLinkedList list = new MyLinkedList();
//            Node head = reversed_linkedlist();
//            System.out.println("After reversed, the list is: ");
//            list.print(head);
//        }
//    }
//    其中MyLinkedList,Node类的代码见http://blog.csdn.net/bitcarmanlee/article/details/52155181。
//            18-23行的逻辑描述如下：假设原链表有三个节点l,m,n，指向关系为l->m->n。当遍历到m节点时，此时有current=m，newHead=l。先用next指针保存n节点，然后将current.next指针指向newHead，此时m的next指针变为newHead即为l。接着，将newHead指针设为current，即此时newHead指针变为m。最后，将current指针变为先前保存的next指针即为n。等到下一次循环的时候，通过current.next = newHead这句将节点n的next指针设为m。通过整个过程，三个节点的指向关系就变为了n->m->l。
//    将上面的代码run起来
//    After reversed, the list is:
//            9 8 7 6 5 4 3 2 1 0
//            1
//            2
//            2.从尾到头倒序遍历链表
//
//    方法1：采用递归的方式 
//    方法2：对于这种倒序的要求，我们很自然想到”后进先出”，很自然就想到用栈这种数据结构去模拟整个倒序遍历的过程。
//    直接上代码
//import java.util.Stack;
//
//    public class Reverse_Travel_LinkedList {
//
//        //递归
//        public static void rev_tra_recur(Node head) {
//            if(head == null) {
//                return;
//            }
//            rev_tra_recur(head.next);
//            System.out.print(head.data + " ");
//        }
//
//        //非递归,用栈模拟
//        public static void rev_tra_no_recur(Node head) {
//            if(head == null) {
//                return;
//            }
//
//            Stack<Node> stack = new Stack<Node>();
//            Node current = head;
//
//            while(current != null) {
//                stack.push(current);
//                current = current.next;
//            }
//
//            while(!stack.isEmpty()) {
//                System.out.print(stack.pop().data + " ");
//            }
//
//        }
//
//        public static void main(String[] args) {
//            MyLinkedList list = new MyLinkedList();
//            Node head = list.init();
//
//            rev_tra_recur(head);
//            System.out.println();
//            rev_tra_no_recur(head);
//        }
//    }
//    将代码run起来
//9 8 7 6 5 4 3 2 1 0
//        9 8 7 6 5 4 3 2 1 0
//    由此可见，两种方法都能很好地满足我们的要求。 
//    递归的好处是代码量少，简介明了。但是所有递归都有的毛病就是当递归次数太多的时候，会导致方法调用的层级很深，最终导致内存不够栈溢出。所以如果从代码的稳定性考虑的话，非递归的方式显然要更安全一些。
}
