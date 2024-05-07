package DailyChallenge.May24;

public class May7_2816 {
    public static void main(String[] args) {
        int[] arr = {1,8,9};
        May7_2816 obj = new May7_2816();
        ListNode head = obj.createLinkedList(arr);
        obj.printLinkedList(head);

        System.out.println("after: ");
        ListNode ans = obj.doubleIt(head);
        obj.printLinkedList(ans);
    }
    public ListNode doubleIt(ListNode head) {
        int carry = recursive(head);
        return carry == 0 ? head : new ListNode(carry, head);
    }

    //function return carry
    private int recursive(ListNode head) {
        if (head == null) return 0;

        int sum = recursive(head.next) + head.val * 2;
        head.val = sum % 10;
        return sum / 10;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode createLinkedList(int[] input) {
        if (input == null || input.length == 0)
            return null;

        ListNode dummy = new ListNode();
        ListNode current = dummy;

        for (int value : input) {
            current.next = new ListNode(value);
            current = current.next;
        }

        return dummy.next;
    }
    public void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null)
                System.out.print(" -> ");
            current = current.next;
        }
        System.out.println();
    }
}
