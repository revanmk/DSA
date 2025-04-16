class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = reverse(head);
        
        // If the node to be removed is the head of reversed list
        if (n == 1) {
            newHead = newHead.next;
        } else {
            ListNode temp = newHead;
            for (int i = 1; i < n - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next; // Remove the nth node
        }
        
        return reverse(newHead);
    }

    static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
