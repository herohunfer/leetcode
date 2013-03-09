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
    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null || head.next == null) return head;
        ListNode tail = head;
        int count = 1;
        while (tail.next != null) {
            count++;
            tail = tail.next;
        }
        tail.next = head;
        n = n % count;
        for (int i = 0; i < count - n; i++) {
            head = head.next;
            tail = tail.next;
        }
        tail.next = null;
        return head;
    }
}
