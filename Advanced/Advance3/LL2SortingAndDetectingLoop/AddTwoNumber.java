package LL2SortingAndDetectingLoop;
import Utils.ListNode;

import java.util.LinkedList;

public class AddTwoNumber {
    public static void main(String[] args) {
        
    }

    public ListNode addTwoNumbers(ListNode A, ListNode B) {

        ListNode addedList = new ListNode(0);

        //creating 2 pointer for addition
        ListNode p1 = A;
        ListNode p2 = B;

        int carry = 0;
        int sum = 0;
        while(p1!=null || p2!=null){
            if(p1!=null && p2!=null){
                sum = p1.val + p2.val + carry;
                p1 = p1.next;
                p2 = p2.next;
            }
            else if(p1==null){
                sum = p2.val + carry;
                p2 = p2.next;
            }
            else if(p2==null){
                sum = p1.val + carry;
                p1 = p1.next;
            }

            int enter = sum % 10;
            carry = sum / 10;

            ListNode toAdd = new ListNode(enter);
            addedList.next = toAdd;

        }
        ListNode toAdd = new ListNode(carry);
        addedList.next = toAdd;

        return addedList.next;
    }
}
