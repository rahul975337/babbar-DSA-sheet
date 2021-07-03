import helpers.ListNode;

//

class app18 {
    static ListNode deleteListNode(ListNode head, int key) {
        if (head == null)
            return null;

        // Find the required ListNode
        ListNode curr = head, prev = null;
        while (curr.val != key) {
            if (curr.next == head) {
                System.out.printf("\nGiven ListNode is not found" + " in the list!!!");
                break;
            }
            prev = curr;
            curr = curr.next;
        }

        // Check if ListNode is only ListNode
        if (curr == head && curr.next == head) {
            head = null;
            return null;
        }

        // If more than one ListNode, check if
        // it is first ListNode
        if (curr == head) {
            prev = head;
            while (prev.next != head)
                prev = prev.next;
            head = curr.next;
            prev.next = head;
        }

        // check if ListNode is last ListNode
        else if (curr.next == head)
            prev.next = head;
        else
            prev.next = curr.next;

        return head;
    }
}