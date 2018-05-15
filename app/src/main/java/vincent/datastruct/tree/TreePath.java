package vincent.datastruct.tree;

/**
 * Created by Vincent on 2018/4/15.
 * description:树的路径相关，
 * ①打印根节点到目标节点的路劲
 * ②打印根节点到所有叶子节点的路径
 */

public class TreePath {


//        /**
//         * 打印二叉树从根节点到叶子节点的所有路径
//         * @param args
//         */
//        public static void getPath(TreeNode root){
//            if(root==null) return;
//            LinkedList<TreeNode> list = new LinkedList<>();
//            getpathcore(root,list);
//        }
//        private static void getpathcore(TreeNode root, LinkedList<TreeNode> list) {
//            if(root==null) return;
//            list.add(root);
//            if(root.left==null&&root.right==null){
//                for(TreeNode temp:list){
//                    System.out.print(temp.value+" ");
//                }
//                System.out.println();
//                list.removeLast();
//                return;
//            }
//            getpathcore(root.left,list);
//            getpathcore(root.right,list);
//            list.removeLast();//返回时一定要清除
//
//        }
//        public static void main(String[] args) {
//
//            TreeNode root = new TreeNode(1);
//            root.left = new TreeNode(2);
//            root.right = new TreeNode(3);
//            root.left.left = new TreeNode(4);
//            root.left.right = new TreeNode(5);
//            getPath(root);
//
//        }
//
//    int[] A; // 数组A
//    int N = A.length; // N个元素
//    int M; // M个其他数组，假设数组存放在一个名为 arr 的 ArrayList 中
//    for(int i = 0;i<N;i++){
//        int j = i % M;
//    }
//    arr[j].Add(A[i]);
// 如果A中仍有元素，再如此循环，直到A中所有元素都分配完毕 arr[j].Add(A[i]);}
//
//    public static void main(String arg0[]){
//        int[] A; // 数组A
//        int N = A.length; // N个元素
//        int M; // M个其他数组，假设数组存放在一个名为 arr 的 ArrayList 中
//        for(int i = 0;i<N;i++){
//            int j = i % M;
//            arr[j].add(A[i]);
//        }
//    }
}
