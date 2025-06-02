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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap=new PriorityQueue<>((a, b) -> a.val - b.val);
         for (ListNode list : lists) { 
            if (list != null) { 
                heap.add(list); 
                } 
            }
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;

        while(!heap.isEmpty()){
            ListNode node=heap.poll();
            curr.next=node;
            curr=curr.next;

            if(node.next!=null){
                heap.add(node.next);
            }
        }
        return dummy.next;
    }
}