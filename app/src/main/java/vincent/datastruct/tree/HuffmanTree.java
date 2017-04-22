package vincent.datastruct.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vincent on 2017/4/22.
 * email-address:674928145@qq.com
 * description:创建哈夫曼树并进行遍历
 */

public class HuffmanTree {
    private static List<Node> nodeList = new ArrayList<>();
    private static Node bindNote;

    static class Node {
        Node leftChild;
        Node rightChild;
        int weighted;//权值
        String data;//数据大小

        public Node(String data, int weighted) {
            this.data = data;
            this.weighted = weighted;
        }
    }

    private static void initNodeList() {
        nodeList.add(new Node("A", 20));
        nodeList.add(new Node("B", 5));
        nodeList.add(new Node("C", 4));
        nodeList.add(new Node("D", 6));
        nodeList.add(new Node("E", 3));
    }


    /**
     * 规则：①每次找最小的结点，作为孩子与合成的节点合成新的节点，权值为左右节点的和，
     * ②新合成的节点又作为孩子参与到新节点的双亲节点的合成之中
     * ③最后,得到整棵哈夫曼树的根节点，权值最大的节点离根节点最近，权值最小的节点离根节点最远
     */

    private static Node createHuffmanTree() {
        bindNote = getSmallestNote();
        while (nodeList.size() > 0) {
            Node smallestNode = getSmallestNote();
            //将合成的节点和剩余node结点最小的一个进行合成
            Node node = new Node(bindNote.data + smallestNode.data, bindNote.weighted + smallestNode.weighted);
            node.leftChild = bindNote;
            node.rightChild = smallestNode;
            bindNote = node;
        }
        return bindNote;
    }

    /**
     * 从剩余节点中得到权值最小的一个节点,并且移除该节点
     *
     * @return
     */
    private static Node getSmallestNote() {
        //冒泡法得到权值最小的一个节点
        for (int x = 1; x < nodeList.size(); x++) {
            //每一趟排序，最大的值冒泡到队列的最后，下一趟不用参与排序
            for (int i = 0; i < nodeList.size() - x; i++) {
                Node node = nodeList.get(i);
                Node nodeNext = nodeList.get(i + 1);
                if (node.weighted > nodeNext.weighted) {
                    nodeList.set(i, nodeNext);
                    nodeList.set(i + 1, node);
                }
            }
        }
        Node smallestNode = nodeList.remove(0);
        return smallestNode;
    }

    public static void main(String arg[]) {
        initNodeList();
        Node rootNode = createHuffmanTree();
        preOrder(rootNode);
    }

    private static void preOrder(Node node) {
        if (node == null) return;
        System.out.println("preOrder:" + "data:" + node.data + " weight:" + node.weighted);
        preOrder(node.leftChild);
        preOrder(node.rightChild);
    }

}
