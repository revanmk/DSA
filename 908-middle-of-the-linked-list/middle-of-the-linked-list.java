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
// class Solution {
//     public ListNode middleNode(ListNode head) {
//         ListNode slow=head;
//         ListNode fast=head;
        
//         while(fast!=null && fast.next!=null){
//             slow=slow.next;
//             fast=fast.next.next;
// }
//             return slow; 
        
//     }
// }
class Solution{
    public ListNode middleNode(ListNode head){
        int cnt=0;
        ListNode temp=head;
        while(temp!=null)
        {
            cnt++;
            temp=temp.next;
        }
        if(cnt%2!=0)
        {
            for(int i=0;i<cnt/2;i++)
            {
                head=head.next;
            }
            return head;
        }
        else{
            for(int i=0;i<cnt/2-1;i++)
            {
                head=head.next;
            }
            return head.next;
        }
    }
}