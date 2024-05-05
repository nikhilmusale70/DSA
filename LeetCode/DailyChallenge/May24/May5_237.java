package DailyChallenge.May24;

public class May5_237 {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
    }

    public void deleteNode(ListNode node) {


    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}