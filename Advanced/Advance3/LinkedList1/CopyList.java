package LinkedList1;

import Utils.RandomListNode;

public class CopyList {
    // 14
    // 83 188 253 281 254 56 70 3 276 233 280 224 16 173
    // 183 193 44 184 33 213 134 95 213 48 300 62 237 63
    public static RandomListNode create(){
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);


        node1.next = node2;
        node2.next = node3;
        node3.next = node4;


        node1.random = node3;
        node2.random = node1;
        node3.random = node1;
        node4.random = node2;


        return node1;
    }
    public static void printList(RandomListNode head){
        RandomListNode temp = head;
        while(temp!=null){
            System.out.print(temp.label + "->");
            temp=temp.next;
        }
        System.out.println();
    }
    public static void printRandomList(RandomListNode head){
        System.out.println();
        RandomListNode temp = head;
        while(temp!=null){
            System.out.println(temp.label + "->" + temp.random.label);
            temp=temp.next;
        }
    }
    public static void main(String[] args) {
        RandomListNode head = create();
        printList(head);
        printRandomList(head);

        System.out.println("After deep copy: ");
        CopyList obj = new CopyList();
        RandomListNode deepCopyHead = obj.copyRandomList(head);
        printList(deepCopyHead);
        printRandomList(deepCopyHead);
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode temp = head;
        RandomListNode newNode;

        //lets first make copy of LL
        while(temp!=null){
            newNode = new RandomListNode(temp.label);
            newNode.next = temp.next;
            temp.next = newNode;
            if(temp.next!=null)
                temp=temp.next.next;
        }
        //copy complete

        //Setting up randoms
        temp = head;
        while(temp!=null){
            if(temp.random!=null)
                temp.next.random = temp.random.next;
            if(temp.next!=null)
                temp=temp.next.next;
        }
        //all randoms are set


        //now we will break the deep copied chain
        temp = head.next;
        while(temp.next!=null){
            temp.next = temp.next.next;
            temp = temp.next;
        }
        //chain broke

        return head.next;
    }
}
