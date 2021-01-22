/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) { //注意：这里传的不是head，而是node，即要删除的点
        //脑筋急转弯
        //因为传进来的参数时要删除的node，无法获得前面一个node，所以传统的改变指针的做法不行
        //思路：
        //node = [5,1,9] -->[1,1,9]-->[1,9](将第一个节点1的指针指向第三个节点9，即删除第二个节点)
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
