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
        if(left == right) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curr = dummy;
        int index = 1;
        while(index != left) {
            curr = curr.next;
            index++;
        }

        ListNode second = curr.next;
        ListNode next = second;

        ListNode prev = null;

        while(left != right) {
            ListNode tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
            left++;
        }

        curr.next = second;
        next.next = second.next;
        second.next = prev;

        return dummy.next;
    }
}