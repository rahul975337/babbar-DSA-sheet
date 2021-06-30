import helpers.ListNode;

// https://leetcode.com/problems/reverse-linked-list/

// ITERATIVE
class app00a {
    static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;

        while (curr != null) {
            next = curr.next;// WE store the next before only so that we donot loose the next pointer while
                             // changing the current's next to prev
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;

    }
}

// RECURSIVE
class app00b {
    ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        // all the nodes will be pushed in recursi call stack and while removing them
        // they will be in reverse order
        // we just need to point current's next's next to current ie, curr.next.next =
        // curr
        // this will reverse the links between the nodes
        ListNode temp = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }
}