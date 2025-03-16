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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode previous=dummy;
        for(int i=1;i<left;i++)
        {
            previous=previous.next;
        }
        ListNode pre=null;
        ListNode current=previous.next;
        for(int i=left;i<=right;i++)
        {
            ListNode next=current.next;
            current.next=pre;
            pre=current;
            current=next;

        }
        previous.next.next=current;
        previous.next=pre;
        return dummy.next;
    }
}