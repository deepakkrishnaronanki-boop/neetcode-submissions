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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = head;

        int count = 1;
        while(second != null) {
            if(count == n) break;
            second = second.next;
            count++;
        }

        while(second.next != null) {
            second = second.next;
            first = first.next;
        }

        first.next = first.next.next;

        return dummy.next;
    }
}
