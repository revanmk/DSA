/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int length1=0;
        int length2=0;
        ListNode h1=headA;
        ListNode h2=headB;
        while(h1!=null)
        {
            length1++;
            h1=h1.next;
        }
        while(h2!=null)
        {
            length2++;
            h2=h2.next;
        }
        if(length1>length2)
        {
            for(int i=0;i<Math.abs(length1-length2);i++)
            {
                headA=headA.next;
            }
        }
        else
        {
            for(int i=0;i<Math.abs(length1-length2);i++)
            {
                headB=headB.next;
            }
        }
        while(headA!=null && headB!=null)
        {
            if(headA==headB)
                return headA;
            headA=headA.next;
            headB=headB.next;
        }
        return null;
    }
}