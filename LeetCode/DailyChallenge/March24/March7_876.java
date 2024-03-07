package DailyChallenge.March24;

public class March7_876 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        March7_876 obj = new March7_876();
        ListNode head = obj.createLinkedList(numbers);
        System.out.println(obj.middleNode(head).val);

    }
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode createLinkedList(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return null;

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        for (int number : numbers) {
            current.next = new ListNode(number);
            current = current.next;
        }

        return dummy.next;
    }
}
