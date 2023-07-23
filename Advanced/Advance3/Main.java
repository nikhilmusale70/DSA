import LinkedList1.CopyList;
import Utils.RandomListNode;

import static LinkedList1.CopyList.printList;
import static LinkedList1.CopyList.printRandomList;

public class Main {
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

    public static void main(String[] args) {
        RandomListNode head = create();
        printList(head);
        printRandomList(head);

        System.out.println("After deep copy: ");
        Main obj = new Main();

        RandomListNode deepCopyHead = obj.copyRandomList(head);
        printList(deepCopyHead);
        printRandomList(deepCopyHead);
    }



    public RandomListNode copyRandomList(RandomListNode head) {
        addNewNodeList(head);
        printList(head);
        populateRandomPtr(head);
        return detachTwoLinkedList(head);
    }

    private RandomListNode detachTwoLinkedList(RandomListNode head) {
        RandomListNode curr=head;
        RandomListNode temp = head.next;
        RandomListNode ans = temp;
        while (curr != null) {
            curr.next=curr.next.next;
            if(temp.next !=null) {
                temp.next=temp.next.next;
            }
            curr=curr.next;
            temp=temp.next;
        }
        return ans;
    }

    private void populateRandomPtr(RandomListNode head) {
        RandomListNode curr=head;
        RandomListNode temp=head.next;
        while (curr !=null) {
            if(null != curr.random)
                temp.random=curr.random.next;
            curr=curr.next.next;
            if(temp.next!=null)
                temp=temp.next.next;
        }
    }

    private void addNewNodeList(RandomListNode head) {
        RandomListNode temp = head;
        while (null != temp) {
            RandomListNode newNode = new RandomListNode(temp.label);
            newNode.next=temp.next;
            temp.next=newNode;
            if(temp.next!=null)
                temp=temp.next.next;
        }
    }
}