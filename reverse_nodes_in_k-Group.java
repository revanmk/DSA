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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        ListNode nextNode=null,prev=null;
        while(temp!=null)
        {
            ListNode kNode=findK(temp,k);
            if(kNode==null)
            {
                if(prev==null)
                    break;
                if(prev!=null)
                {
                    prev.next=temp;
                    break;
                }
            }
            nextNode=kNode.next;
            kNode.next=null;
            reverse(temp);
            if(temp==head){
                head=kNode;
            }
            else{
                prev.next=kNode;
            }
            prev=temp;
            temp=nextNode;
        }
        return head;
    }
    public ListNode findK(ListNode head,int k)
    {
        k--;
        ListNode temp=head;
        while(k>0 && temp!=null)
        {
            temp=temp.next;
            k--;
        }
        return temp;
    }
    public void reverse(ListNode head){
        ListNode prev=null,curr=head;
        if(head==null)
            return;
        while(curr!=null)
        {
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return;
    }
}
