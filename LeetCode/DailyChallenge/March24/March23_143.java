package DailyChallenge.March24;

public class March23_143 {
    public void reorderList(ListNode head) {
        // Check if the list has only one or zero elements
        if (head.next == null)
            return;

        ListNode slowPointer = head, fastPointer = head, previousSlow = slowPointer;
        // Move slow and fast pointers to find the midpoint of the linked list
        while (fastPointer != null && fastPointer.next != null) {
            previousSlow = slowPointer;
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        // Split the list into two halves
        previousSlow.next = null;

        // Reverse the second half of the list
        ListNode firstHalfHead = head;
        ListNode secondHalfHead = reverseLinkedList(slowPointer);

        // Merge the two halves of the list
        while (firstHalfHead != null && secondHalfHead != null) {
            ListNode nextFirstHalfNode = firstHalfHead.next;
            firstHalfHead.next = secondHalfHead;
            firstHalfHead = nextFirstHalfNode;

            ListNode nextSecondHalfNode = secondHalfHead.next;
            secondHalfHead.next = (nextFirstHalfNode != null) ? nextFirstHalfNode : nextSecondHalfNode;
            secondHalfHead = nextSecondHalfNode;
        }
    }

    // Helper method to reverse a linked list
    private ListNode reverseLinkedList(ListNode head) {
        ListNode currentNode = head, previousNode = null;
        // Reverse the linked list
        while (currentNode != null) {
            ListNode nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return previousNode;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
