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
        ListNode dummy = null;
        while(head != null) {
            ListNode next = head.next; //Pointing next to immediate next
            head.next = dummy; //broke next ptr. of head and point to dummy
            dummy = head; //move dummy to head
            head = next; //move head to next
        }
        return dummy;
    }
}