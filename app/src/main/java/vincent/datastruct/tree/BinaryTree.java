package vincent.datastruct.tree;

import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by vincent on 2017/4/20.
 * email-address:674928145@qq.com
 * description:构建普通二叉树并进行遍历
 * <p>
 * 思想：主要利用了"分而治之"递归的思想，或者通过堆栈"后进先出"来实现
 */

public class BinaryTree {

    private static Node root;

    static class Node {
        Node leftChild;
        Node rightChild;
        String data;

        public Node(String data) {
            this.data = data;
        }
    }

    /**
     * *   A
     * * B    C
     * D     E  F
     */
    static void createBinTree() {
        root = new Node("A");
        Node nodeB = new Node("B");
        root.leftChild = nodeB;
        Node nodeC = new Node("C");
        root.rightChild = nodeC;
        nodeB.leftChild = new Node("D");
        nodeC.leftChild = new Node("E");
        nodeC.rightChild = new Node("F");
    }

    /**
     * 根据前序遍历结果来构建二叉树
     * **     A
     * **  B     C
     * * #  D   #  E
     * <p>
     * 前序遍历：AB#D##C#E##
     */


    static Node createBinTreeByPreOrder() {
        String s = new String("AB#D##C#E##");
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Node node;
            node = new Node(chars[i] + "");
            if (i == 0) {
                root = node;
            } else {
                if (chars[i] == '#') {
                    node = null;
                }
            }
            if (node != null) {
                node.leftChild = createBinTreeByPreOrder();
                node.rightChild = createBinTreeByPreOrder();
            }

        }
        return null;

    }
    //------------------------------递归方式遍历二叉树------------------------------//


    static void preOrder(Node node) {
        if (node == null) return;
        System.out.println("preOrder:" + node.data);
        preOrder(node.leftChild);
        preOrder(node.rightChild);
    }

    static void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.leftChild);
        System.out.println("inOrder:" + node.data);
        inOrder(node.rightChild);
    }

    static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.leftChild);
        postOrder(node.rightChild);
        System.out.println("postOrder:" + node.data);
    }

    //------------------------------非递归方式(堆栈)遍历二叉树------------------------------//

    /**
     * 堆栈前序遍历二叉树
     */
    static void stackPre() {
        Stack<Node> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node popNode = stack.pop();
            System.out.println("stackPre:" + popNode.data);
            if (popNode.rightChild != null)
                stack.push(popNode.rightChild);
            if (popNode.leftChild != null)
                stack.push(popNode.leftChild);
        }
    }

    /**
     * 堆栈中序遍历二叉树
     */
    static void stackIn() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node popNode = stack.pop();
            //没有左孩子就输出
            if (popNode.leftChild == null) {
                System.out.println("stackIn:" + popNode.data);
            }
            if (popNode.rightChild != null) {
                stack.push(popNode.rightChild);
            }
            //如果有左孩子，则还需要创建包含该节点值的节点(没有左右孩子)，放入堆栈中
            if (popNode.leftChild != null) {
                Node nodeRoot = new Node(popNode.data);
                stack.push(nodeRoot);
            }

            if (popNode.leftChild != null) {
                stack.push(popNode.leftChild);
            }

        }
    }

    /**
     * 堆栈后序遍历二叉树
     */
    static void stackPost() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node popNode = stack.pop();
            //该节点没有左孩子并且没有右孩子了，才直接打印
            if (popNode.rightChild == null && popNode.leftChild == null) {
                System.out.println("stackPost:" + popNode.data);
            }
            //如果该节点有左孩子，或者右孩子，则还需要创建包含该节点值的节点(没有左右孩子)，放入堆栈中
            if (popNode.rightChild != null || popNode.leftChild != null) {
                Node nodeRoot = new Node(popNode.data);
                stack.push(nodeRoot);
            }
            if (popNode.rightChild != null) {
                stack.push(popNode.rightChild);
            }
            if (popNode.leftChild != null) {
                stack.push(popNode.leftChild);
            }
        }
    }

    //------------------------------二叉树的深度优先遍历------------------------------//


    //------------------------------二叉树层序(广度优先)遍历------------------------------//

    /**
     * 二叉树的广度优先遍历
     * 主要思想：利用队列+while循环模式，每次遍历当前节点的时候，把该节点从队列里面移出来，
     * 并且把所有子节点加入到队列之中
     *
     * 注意：和二叉树的前序遍历很像，只不过一个用了堆栈，一个用了队列
     */
    private static void breadthFirstOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node pollNode = queue.poll();
            System.out.println("breadthFirstOrder:"+pollNode.data);
            if (pollNode.leftChild != null) {
                queue.add(pollNode.leftChild);
            }
            if (pollNode.rightChild != null) {
                queue.add(pollNode.rightChild);
            }
        }
    }
//    offer，add区别：
//    一些队列有大小限制，因此如果想在一个满的队列中加入一个新项，多出的项就会被拒绝。
//    这时新的 offer 方法就可以起作用了。它不是对调用 add() 方法抛出一个 unchecked 异常，而只是得到由 offer() 返回的 false。

//    poll，remove区别：
//    remove() 和 poll() 方法都是从队列中删除第一个元素。remove() 的行为与 Collection 接口的版本相似，
//    但是新的 poll() 方法在用空集合调用时不是抛出异常，只是返回 null。因此新的方法更适合容易出现异常条件的情况。
//
//    peek，element区别：
//    element() 和 peek() 用于在队列的头部查询元素。与 remove() 方法类似，在队列为空时， element() 抛出一个异常，而 peek() 返回 null

    //------------------------------链接二叉树的next节点------------------------------//

    /**
     * 逻辑很简单，每一个的节点的next指向同一层中的下一个节点，不过如果该节点是当前层的最后一个节点的话，不设置next，或者说next为空。
     *
     * 思想：也相当于二叉树的层序(广度优先)遍历，只不过多了链接的操作
     */
    private static void linkNextNode() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
//        while (!queue.isEmpty()) {
//            Node pollNode = queue.poll();
//            if (pollNode.leftChild != null) {
//                queue.add(pollNode.leftChild);
//            }
//            if (pollNode.rightChild != null) {
//                queue.add(pollNode.rightChild);
//            }
//            if()
//        }
    }

    //------------------------------二叉树的翻转------------------------------//
    /**
     * *       A                                A
     * *   B      C                        C      B
     * D       E    F    --->翻转        F    E       D
     * <p>
     * 二叉树的翻转
     * <p>
     * 思想，分而治之，每一个节点的左右孩子交换，递归进行
     */
    private static void reverseBinaryTree(Node node) {
        if (node == null) return;
        Node temp;
        temp = node.leftChild;
        node.leftChild = node.rightChild;
        node.rightChild = temp;

        reverseBinaryTree(node.leftChild);
        reverseBinaryTree(node.rightChild);
    }

    //------------------------------二叉树的平铺------------------------------//

    /**
     * *       A
     * *  B       C
     * D    E   F    G     --->平铺   A B D E   C F G
     *
     * 思想：把二叉树铺平的这个过程，是先把左子树铺平，链接到根节点的右节点上面，再把右子树铺平,链接到已经铺平的左子树的最后一个节点上。
     * 最后返回根节点。那么我们从一个宏观的角度来说，需要做的就是先把左右子树铺平。
     */
    private static void flattenBinaryTree() {

    }

    //------------------------------树形结构在android中的应用------------------------------//

    /**
     *
     *  我们都知道在安卓系统里面，每个ViewGroup里面又会包含多个或者零个View,每一个View 或者 ViewGroup 都有一个整型的Id，
     *  那么每次我们在使用ViewGroup的findViewById(int id)的时候，我们是以什么方式来查找并返回在当前ViewGroup下面，我们要查找的View呢？
     *  可以使用的方法有:
     *  View -> getId() 返回一个int 的 id
     *  ViewGroup -> getChildCount() 返回一个int的孩子数量
     *  ViewGroup -> getChildAt(int index) 返回一个孩子，返回值为View。
     */
    //返回一个在vg下面的一个View，id为方法的第二个参数
    public static View find(ViewGroup vg, int id) {
        if (vg == null) return null;

        int childCount = vg.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View v = vg.getChildAt(i);
            if (v.getId() == id) {
                return v;
            }
            if (v instanceof ViewGroup) {
                View temp=find((ViewGroup) v, id);
                //如果找到了返回招待的View，如果没有，循环继续
                if (temp != null) {
                    return temp;
                }
            }
        }
        return null;
    }


    public static void main(String arg[]) {
        createBinTree();
        //递归方式遍历
        preOrder(root);
        inOrder(root);
        postOrder(root);

        //非递归(堆栈)方式遍历
        stackPre();
        stackIn();
        stackPost();

        //广度优先遍历
        breadthFirstOrder();

        //二叉树翻转
        reverseBinaryTree(root);
        preOrder(root);
    }
}
