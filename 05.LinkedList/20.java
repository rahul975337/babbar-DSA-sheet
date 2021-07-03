import helpers.ListNode;

// https://www.geeksforgeeks.org/find-pairs-given-sum-doubly-linked-list/

class app20 {
    static void pairSum(ListNode head, int x) {
        // Set two pointers, low
        // to the beginning of DLL
        // and high to the end of DLL.
        ListNode low = head;
        ListNode high = head;
        while (high.next != null)
            high = high.next;

        // To track if we find a pair or not
        boolean found = false;

        // The loop terminates when
        // they cross each other (high.next
        // == low), or they become same
        // (low == high)
        while (low != high && high.next != low) {
            // pair found
            if ((low.val + high.val) == x) {
                found = true;
                System.out.println("(" + low.val + ", " + high.val + ")");
                // move low in forward direction
                low = low.next;
                // move high in backward direction
                high = high.prev;
            } else {
                if ((low.val + high.val) < x)
                    low = low.next;
                else
                    high = high.prev;
            }
        }
        // if pair is not present
        if (found == false)
            System.out.println("No pair found");
    }
}