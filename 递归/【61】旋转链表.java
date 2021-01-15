/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null){return head;} // 如果链表为空，则直接返回空链表
        int l = getLength(head);//获取链表长度
        int cutpoint = k % l;
        if (cutpoint == 0 ){
            return head;
        }else{
            ListNode tmp = head;
            for (int i = 0; i < l - cutpoint - 1; i++){
                tmp = tmp.next;
            }
            ListNode right = tmp.next;
            tmp.next = null;
            getLastNode(right,cutpoint).next = head;
            return right;
        }
    }
    public int getLength(ListNode head){
        if (head.next == null){
            return 1;
        }else{
            return 1 + getLength(head.next);
        }
    }
    public ListNode getLastNode(ListNode head, int cutpoint){
        ListNode tmp = head;
            for (int i = 0; i < cutpoint - 1 ; i++){
                tmp = tmp.next;
            }
        return tmp;
    }

}
