
//https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1#
import helpers.ListNode;

class app03 {
    // Function to remove a loop in the linked list.
    public static void removeLoop(ListNode head) {
        ListNode detected = detectCycle(head);
        if (detected != null)
            detected.next = null;
    }

    public static ListNode detectCycle(ListNode head) {
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
        // currently slow and fast are at the starting point of loop but we need to get
        // to the ending point to make its next null
        // finding the prev of fast pointer to make it's next as null
        ListNode prev = fast;
        while (prev.next != fast) {
            prev = prev.next;
        }

        return prev;

    }
}