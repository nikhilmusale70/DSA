package LinkedList1;

import java.util.List;

public class CreatLL {
    public static void main(String[] args) {
        int[] A = {6,3,3,6,7,8,7,3,7};
        for (int i=1; i<=A.length; i++){
            insert_node(i, A[i-1]);
        }


        CreatLL obj = new CreatLL();
        ListNode root = obj.solve(head, 2,3);

        System.out.println("FInal");
        print_ll();
    }
    public ListNode solve(ListNode A, int B, int C) {
        ListNode current = A;
        ListNode prev = null;

        while (current != null) {
            // Keep the first B nodes
            int b = B;
            while (b > 0 && current != null) {
                prev = current;
                current = current.next;
                b--;
            }

            // Remove the next C nodes
            int c = C;
            while (c > 0 && current != null) {
                current = current.next;
                c--;
            }

            // Remove the nodes in between
            prev.next = current;
        }

        return A;
    }
    public static ListNode head = null;
    public static int lenOfList =0;
    public static void insert_node(int position, int value) {
        position--;
        // @params position, integer
        // @params value, integer
        ListNode newNode = new ListNode(value);

        //insert at head
        if(position<=0){
            if(lenOfList==0){
                lenOfList++;
                head = newNode;
            }
            else{
                lenOfList++;
                newNode.next = head;
                head = newNode;
            }
        }

        else{
            //insert at tail or middle
            int pos = 0;
            ListNode temp = head;
            while(pos<position && temp.next!=null){
                temp = temp.next;
                pos++;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }

    }

    public static void delete_node(int position) {
        position--;
        // @params position, integer
        int pos=0;
        ListNode temp = head;
        if(head==null){
            return;
        }
        if(position==0){
            head=head.next;
            return;
        }

        while(pos<position-1 && temp.next.next!=null){
            temp=temp.next;
            pos++;
        }
        if(temp.next.next==null){
            temp.next = null;
        }
        else{
            temp.next = temp.next.next;
        }
    }

    public static void print_ll() {
        // Output each element followed by a space
        ListNode temp = head;
        while(temp!=null){
            if (temp.next == null) {
                System.out.print(temp.val);
            }
            else {
                System.out.print(temp.val + " ");
            }
            temp = temp.next;
        }
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
