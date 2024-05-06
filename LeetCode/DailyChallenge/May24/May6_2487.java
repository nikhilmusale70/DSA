package DailyChallenge.May24;


public class May6_2487 {
    public static void main(String[] args) {
        int[] input = {5,5,5};
        May6_2487 obj = new May6_2487();

        ListNode head = obj.createLinkedList(input);
        printLinkedList(obj.removeNodes(head));
    }
    public ListNode removeNodes(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode curr = reverseLL(head);
        ListNode prev = curr;
        ListNode next = curr.next;
        while(next!=null){
            if(prev.val<=next.val){
                prev.next = next;
                prev = next;
            }
            next = next.next;
        }

        prev.next = null;
        return reverseLL(curr);
    }

    ListNode reverseLL(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        while(next != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;
        return curr;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public  ListNode createLinkedList(int[] input) {
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
    public static void printLinkedList(ListNode head) {
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
