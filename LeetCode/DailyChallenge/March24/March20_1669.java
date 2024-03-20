package DailyChallenge.March24;

public class March20_1669 {
    public static void main(String[] args) {
        int[] arr1 = {10, 1, 13, 6, 9, 5};
        int[] arr2 = {1000000,1000001,1000002};

        March20_1669 obj = new March20_1669();

        ListNode list1 = obj.createLinkedList(arr1);
        ListNode list2 = obj.createLinkedList(arr2);

        ListNode result = obj.mergeInBetween(list1, 3, 4, list2);
        //result will be the head of the new linked list created
    }
    // Method to create a linked list from an array
    public ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        return head;
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        // Initialize pointers for traversal
        ListNode node1 = list1; // Pointer for list1

        // Traverse list1 to reach the node just before the 'a'th node
        for(int i=0; i<a-1; i++){
            node1 = node1.next;
        }

        // Save the 'a'th node as listEnd
        ListNode listEnd = node1;

        // Traverse list1 to reach the 'b+1'th node
        for(int i=0; i<b-a + 2; i++){
            listEnd = listEnd.next;
        }

        // Connect the 'a'th node of list1 to the head of list2
        node1.next = list2;

        // Traverse list2 to reach its end
        while(node1.next!=null){
            node1 = node1.next;
        }

        // Connect the end of list2 to the 'b+1'th node of list1
        node1.next = listEnd;

        // Return the merged list
        return list1;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
