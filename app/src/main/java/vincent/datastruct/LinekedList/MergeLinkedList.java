package vincent.datastruct.LinekedList;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Vincent on 2018/4/11.
 * email-address:674928145@qq.com
 * description:链表的合并
 */

public class MergeLinkedList {


    static class ListNode{
        ListNode next;
        int val;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String arg0[]){

    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        // PriorityQueue 是堆，默认小顶堆
        PriorityQueue<ListNode> min = new PriorityQueue<ListNode>(11, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        // 加入所有链表的第一个结点，非空
        for (ListNode node : lists)
            if (node != null)
                min.offer(node);
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (!min.isEmpty()) {
            ListNode temp = min.poll();
            cur.next = temp;
            cur = cur.next;
            // 边取边加入
            if (temp.next != null)
                min.offer(temp.next);
        }
        // 注意断链
        cur.next = null;
        return head.next;
    }

    //------------------------------note------------------------------//
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        return MSort(lists, 0, lists.length - 1);
    }

    public ListNode MSort(ListNode[] lists, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            ListNode leftlist = MSort(lists, low, mid);
            ListNode rightlist = MSort(lists, mid + 1, high);
            return mergeTwoLists(leftlist, rightlist);
        }
        // 如果相等，只有一个元素，返回即可
        return lists[low];
    }

    // 递归合并链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = null;
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val <= l2.val) {
            res = l1;
            l1.next = mergeTwoLists(l1.next, l2);
        } else {
            res = l2;
            l2.next = mergeTwoLists(l1, l2.next);
        }
        return res;
    }
}
