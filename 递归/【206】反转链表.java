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
   
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        int len = getLength(head);
        ListNode[] nodes = new ListNode[len];
        for (int i = 0;i < len; i++){
            nodes[i] = head;
            head = head.next; 
        }
        nodes[0].next = null; //第一个位置指向null
        for (int i = 1; i < len; i++){
            nodes[i].next = nodes[i-1]; //后面的指向前面的
        }
        return nodes[len-1];
    }
    public int getLength(ListNode head){
        if (head.next == null){
            return 1;
        }else{
            return 1 + getLength(head.next);
        }
    }
}
