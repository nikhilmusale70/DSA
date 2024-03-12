package DailyChallenge.March24;

public class March12_1171 {
     public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {

    }
    public ListNode removeZeroSumSublists(ListNode head) {
        if(head == null)return head;
        ListNode prev = null;
        ListNode cur = head;
        int  running_sum=0;
        while(cur!=null){
            running_sum += cur.val;
            if(running_sum==0){
                head = cur.next;
                return removeZeroSumSublists(head);
            }
            cur = cur.next;
        }
        head.next = removeZeroSumSublists(head.next);
        return head;
    }
}
