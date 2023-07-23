package LL2SortingAndDetectingLoop;

import java.util.List;

public class DoublyLIst {
    static class ListNode {
        int val;
        ListNode right, down;
        ListNode(int x) {
            val = x;
            right = down = null;
        }
    }

    public static void main(String[] args) {
        //create a list
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(7);
        ListNode c = new ListNode(7);
        ListNode d = new ListNode(8);

        ListNode e = new ListNode(4);
        ListNode f = new ListNode(11);

        ListNode g = new ListNode(20);
        ListNode h = new ListNode(22);

        ListNode i = new ListNode(20);
        ListNode j = new ListNode(20);
        ListNode k = new ListNode(28);
        ListNode l = new ListNode(39);

        ListNode m = new ListNode(30);
        ListNode n = new ListNode(31);
        ListNode o = new ListNode(39);

        a.down = b;
        b.down = c;
        c.down = d;
        a.right = e;

        e.down = f;
        e.right = g;

        g.down = h;
        g.right = i;

        i.down = j;
        j.down = k;
        k.down = l;
        i.right = m;

        m.down = n;
        n.down = o;

        DoublyLIst temp = new DoublyLIst();
        ListNode head = temp.flatten(a);

        temp.printLl(head);
    }

    void printLl(ListNode head){
        //printing
        while(head!=null){
            System.out.print(head.val + "->");
            head = head.right;
        }
    }

    ListNode flatten(ListNode root) {
        ListNode front = root;
        ListNode deep = root;
        front = front.right;
        root.right = null;
        ListNode head = new ListNode(0);
        while(front != null)
        {
            ListNode temp = front;
            front = temp.right; // Breaking connections and
            temp.right = null; // seprating lists
//            head = mergeTwoSortedList(temp,deep);
            deep = head;
        }
        return deep;
    }
//    ListNode flattenno(ListNode root) {
//        ListNode OH = root, OT=root;
//        ListNode temp = root;
//
//        ListNode list1 = temp;
//        ListNode list2 = null;
//
//        while(temp.right!=null){
//            th=null;
//            tt=null;
//            //lets start merging list
//            list2 = temp.right;
//            if(temp.right!=null)
//                temp = temp.right;
//            else
//                temp = null;
//
//            list1 = mergeTwoSortedList(OH, list2);
//
//            if(OH==null){
//                OH = th;
//                OT = tt;
//            }
//            else{
//                OT.right = th;
//                OT = tt;
//            }
//            printLl(OH);
//            System.out.println();
//        }
//        System.out.println(list1.val);
//        return list1;
//    }

//    ListNode th=null, tt=null;
    public ListNode merge(ListNode A,ListNode B){ // Just merging two lists;
        ListNode head = null;
        ListNode tail = null;
        while(A != null && B != null)
        {
            if(A.val < B.val)
            {
                ListNode temp = A;
                A = A.down;
                temp.down = null;
                if(head == null && tail == null)
                {
                    head = temp;
                    tail = temp;
                }
                else
                {
                    tail.down = temp;
                    tail = temp;
                }
            }
            else{
                ListNode temp = B;
                B = B.down;
                temp.down = null;
                if(head == null && tail == null)
                {
                    head = temp;
                    tail = temp;
                }
                else
                {
                    tail.down = temp;
                    tail = temp;
                }
            }
        }
        if(A == null)
        {
            tail.down = B;
        }
        if(B == null)
        {
            tail.down = A;
        }
        return head;
    }
//    ListNode mergeTwoSortedList(ListNode listOne, ListNode listSecond){
//        ListNode h1=listOne, h2=listSecond;
//        ListNode h1Next=null, h2Next=null;
//
//        if(h1.val<h2.val){
//            th = h1;
//            tt=h1;
//        }
//        else{
//            th = h2;
//            tt=h2;
//        }
//
//        while(h1!=null && h2!=null){
//            if(h1.val<h2.val){
//                h1Next = h1.down;
//                tt.right = h1;
//                h1=h1Next;
//            }
//            else{
//                h2Next = h2.down;
//                tt.right = h2;
//                h2=h2Next;
//            }
//            tt = tt.right;
//        }
//
//        //check which list is not null
//        if(h1 != null){
//            tt.right = h1;
//        }
//        if(h2 != null){
//            tt.right = h2;
//        }
//
//        return th;
//    }
}
