package vincent.datastruct.tree;

import java.util.Stack;

/**
 * Created by vincent on 2017/4/20.
 * email-address:674928145@qq.com
 * description:构建普通二叉树并进行遍历
 */

public class BinTree {

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
        System.out.println("inOrder:" + node.data);
    }

    public static void main(String arg[]) {
        createBinTree();
        preOrder(root);
        inOrder(root);
        postOrder(root);
        nonPre(root);
    }

    static void nonPre(Node node) {
        if (node == null) return;
        Stack<Node> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node popNode = stack.pop();
            System.out.println("nonPre:" + popNode.data);
            if (popNode.rightChild != null)
                stack.push(popNode.rightChild);
            if (popNode.leftChild != null)
                stack.push(popNode.leftChild);
        }
    }
}
