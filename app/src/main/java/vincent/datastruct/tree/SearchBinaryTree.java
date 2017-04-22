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

    static List<HuffmanTree.Node> nodeList = new ArrayList<>();
    private static Node bindNote;

    static class Node {
        HuffmanTree.Node leftChild;
        HuffmanTree.Node rightChild;
        int weighted;//权值
        String data;//数据大小

        public Node(String data, int weighted) {
            this.data = data;
            this.weighted = weighted;
        }
    }

    private static void initNodeList() {
        nodeList.add(new HuffmanTree.Node("A", 20));
        nodeList.add(new HuffmanTree.Node("B", 5));
        nodeList.add(new HuffmanTree.Node("C", 4));
        nodeList.add(new HuffmanTree.Node("D", 6));
        nodeList.add(new HuffmanTree.Node("E", 3));
    }

    public static void main(String arg[]) {
        initNodeList();

    }

}
