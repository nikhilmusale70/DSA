package LinkedList1;

import Utils.ListNode;
import Utils.ScaUtils;

public class ReverseLinkedList {
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5};
        ListNode head = ScaUtils.createLinkedList(A);

        ReverseLinkedList obj = new ReverseLinkedList();
        ScaUtils.printLinkedList(obj.reverseLL(head));

    }

    public ListNode reverseList(ListNode A) {
        ListNode pointer1 = A;
        if(A.next==null){
            return A;
        }
        ListNode pointer2 = A.next;
        ListNode temp = pointer2.next;

        pointer1.next = null;

        while (temp!=null){
            pointer2.next = pointer1;
            pointer1=pointer2;
            pointer2=temp;
            if (temp.next==null){
                break;
            }
            temp = pointer2.next;
        }
        pointer2.next = pointer1;
        return pointer2;
    }

    public ListNode reverseLL(ListNode head){
        if(head.next == null){
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;
        ListNode fut = null;

        while(curr.next!=null){
            fut = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fut;
        }
        curr.next = prev;

        return curr;
    }



}
