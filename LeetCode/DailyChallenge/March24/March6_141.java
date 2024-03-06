package DailyChallenge.March24;

public class March6_141 {
    static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);

        // Connect nodes to form a cyclic linked list
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second; // Creating a cycle

        March6_141 obj = new March6_141();
        System.out.println(obj.hasCycle(head));
    }

    public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow) return true;
        }
        return false;
    }
}
