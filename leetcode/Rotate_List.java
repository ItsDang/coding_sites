/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int length = 0;
        ListNode point = head;
        while(point != null) {
            length = length + 1;
            point = point.next;
        }
        if(length != 0) {
             point = head;
            int rot = length - (k % length);
            System.out.println(length + " " + rot);
            if(rot != length) {
                while(rot > 1){
                    point = point.next;
                    rot = rot - 1;
                }
                ListNode newHead = point.next;
                point.next = null;
                point = newHead;
                while(point.next != null) {
                    point = point.next;
                }
                point.next = head;
                return newHead;
            }
        }
        return head;
    }
}