
//https://leetcode.com/problems/linked-list-cycle-ii/
import helpers.ListNode;

class app04 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        if (head == null || head.next == null || head.next.next == null)
            return null;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle)
            return null;// To check if the loop terminated till the end and cycle not fouond
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}