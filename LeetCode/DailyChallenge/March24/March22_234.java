package DailyChallenge.March24;

public class March22_234 {
    public static void main(String[] args) {
        ListNode node4 = new ListNode(1);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);

        March22_234 obj = new March22_234();
        System.out.println(obj.isPalindrome(head));
    }
    public boolean isPalindrome(ListNode head) {
        // Edge case: if head is null or only one node, it's palindrome
        if (head == null || head.next == null)
            return true;

        // Find the midpoint of the list
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // Reverse the second half of the list
        ListNode prev = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        // Compare the first and second halves of the list
        while (prev != null) {
            if (head.val != prev.val)
                return false;
            head = head.next;
            prev = prev.next;
        }

        return true;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
