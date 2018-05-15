package vincent.datastruct.LinekedList;

/**
 * Created by Vincent on 2018/4/18.
 * description:
 * 写一个函数，给定一个单链表和头指针和链表的某一个结点，在O(1)的时间内删除这个结点。
 * 比如一个链表A->B->C->D->E->F->G，要删除E结点
 */

public class O1DeleteNode {
//    ①一般来说，单链表要删除一个节点，得得到被删除节点的前面一个结点指针，在O(1)时间不可能，
//    ②另辟蹊径，我们可以得通过E节点的next指针得到F节点，F节点的next指针得到G节点，E节点的指针
//    指向G节点，再将F的值赋值给E节点，那就相当于删除了E节点，并且时间负责度O(1)


}
