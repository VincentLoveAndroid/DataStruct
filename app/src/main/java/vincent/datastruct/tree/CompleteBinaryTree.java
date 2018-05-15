package vincent.datastruct.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vincent on 2017/3/2.
 * email-address:674928145@qq.com
 * description:java实现完全二叉树的构建及三种遍历
 */

public class CompleteBinaryTree {

    private static int[] arr = {2, 15, 3, 5, 7, 10, 11};
    private static List<Node> nodeList;

    private static class Node {
        int data;
        Node leftChild;
        Node rightChild;

        Node(int data) {
            leftChild = null;
            rightChild = null;
            this.data = data;
        }
    }

    /**
     * 根据数组的顺序，构建完全二叉树
     */
    private static void createCompleteBinTree() {
        nodeList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            nodeList.add(new Node(arr[i]));
        }
        //假设父节点为index为k，则左孩子：2k+1,右孩子：2k+2,固最后的一个父节点：(length-1-1)/2
        for (int parentIndex = 0; parentIndex < arr.length / 2 - 1; parentIndex++) {
            //构建左孩子
            nodeList.get(parentIndex).leftChild = nodeList.get(2 * parentIndex + 1);
            //构建右孩子
            nodeList.get(parentIndex).rightChild = nodeList.get(2 * parentIndex + 2);
        }
        //最后一个父节点可能没有右孩子，单独处理
        int lastParentIndex = arr.length / 2 - 1;
        nodeList.get(lastParentIndex).leftChild = nodeList.get(2 * lastParentIndex + 1);

        //如果元素个数为奇数，有右孩子
        if (arr.length / 2 > 0) {
            nodeList.get(lastParentIndex).rightChild = nodeList.get(2 * lastParentIndex + 2);
        }
    }

    /**
     * 前序遍历
     */
    private static void preOrderTraverse(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrderTraverse(node.leftChild);
        preOrderTraverse(node.rightChild);
    }

    /**
     * 中序遍历
     */
    private static void inOrderTraverse(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraverse(node.leftChild);
        System.out.print(node.data + " ");
        inOrderTraverse(node.rightChild);

    }

    /**
     * 后序遍历
     */
    private static void postOrderTraverse(Node node) {
        if (node == null) {
            return;
        }
        postOrderTraverse(node.leftChild);
        postOrderTraverse(node.rightChild);
        System.out.print(node.data + " ");
    }

    public static void main(String[] arg0) {
        createCompleteBinTree();
        Node root = nodeList.get(0);
        System.out.println("前序遍历：");
        preOrderTraverse(root);
        System.out.println("");
        System.out.println("中序遍历:");
        inOrderTraverse(root);
        System.out.println("");
        System.out.println("后序遍历：");
        postOrderTraverse(root);
    }
}
