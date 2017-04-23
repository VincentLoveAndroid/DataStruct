package vincent.datastruct.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vincent on 2017/4/22.
 * email-address:674928145@qq.com
 * description:查找二叉树,它或者是一棵空树，或者是具有下列性质的二叉树： 若它的左子树不空，
 * 则左子树上所有结点的值均小于它的根结点的值； 若它的右子树不空，则右子树上所有结点的值均
 * 大于它的根结点的值； 它的左、右子树也分别为二叉排序树。
 */

public class SearchBinaryTree {

    static List<Node> nodeList = new ArrayList<>();

    static class Node {
        Node leftChild;
        Node rightChild;
        int data;//数据大小

        public Node(int data) {
            this.data = data;
        }
    }

    private static void initNodeList() {
        nodeList.add(new Node(20));
        nodeList.add(new Node(5));
        nodeList.add(new Node(4));
        nodeList.add(new Node(6));
        nodeList.add(new Node(3));
    }

    public static void main(String arg[]) {
        initNodeList();
        Node rootNode = createSearchBinaryTree();
        preOrder(rootNode);
    }

    /**
     * 创建查找二叉树
     *
     * @return
     */
    private static Node createSearchBinaryTree() {
        Node rootNode = null;
        for (Node node : nodeList) {
            if (rootNode == null) {
                //如果没有根节点，初始化根节点并跳出此次遍历
                rootNode = node;
                continue;
            }
            Node parent = null;
            //每次从根节点开始查找
            Node currentNode = rootNode;
            //根据小左大右的规则，循环找到叶子节点（左孩子或右孩子为空），即为待插入节点的双亲节点
            while (currentNode != null) {
                parent = currentNode;
                if (node.data < currentNode.data) {
                    currentNode = currentNode.leftChild;
                } else {
                    currentNode = currentNode.rightChild;
                }
            }
            //这时parent即为待插入节点的双亲节点
            if (node.data < parent.data) {
                parent.leftChild = node;
            } else {
                parent.rightChild = node;
            }
        }
        return rootNode;
    }


    private static void preOrder(Node node) {
        if (node == null) return;
        System.out.println("preOrder:" + "data:" + node.data);
        preOrder(node.leftChild);
        preOrder(node.rightChild);
    }

}
