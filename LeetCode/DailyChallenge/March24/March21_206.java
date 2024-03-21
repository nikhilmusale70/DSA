package DailyChallenge.March24;

public class March21_206 {
    public static void main(String[] args) {

    }
    public ListNode reverseList(ListNode head) {
        // Initialize previous node to null as there is no node before the head initially
        ListNode prev = null;
        // Start with the current node as the head of the list
        ListNode current = head;

        // Iterate through the list until current node becomes null (end of the list)
        while (current != null) {
            // Store the next node temporarily
            ListNode next = current.next;
            // Reverse the pointer to the previous node
            current.next = prev;
            // Move prev to the current node
            prev = current;
            // Move current to the next node in the original list
            current = next;
        }

        // At the end of the loop, prev will be pointing to the new head of the reversed list
        return prev;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
