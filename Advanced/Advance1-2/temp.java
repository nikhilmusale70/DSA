class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }
public class temp {
    // Driver code
    static public void main(String[] Java){
        temp obj = new temp();
        
    }

    public ListNode solve(ListNode A, int B, int C) {
        ListNode newNode = new ListNode(B);

        if(C==0){
            newNode.next = A;
            return newNode;
        }
        int count=0;
        while(A.next!=null){
            if(count != C){
                A=A.next;
                count++;
            }
            else{
                newNode.next = A.next;
                A.next = newNode;
                break;
            }
        }
        if(count!=C){
            //insert at last
            A.next=newNode;
        }

        return A;
    }
}
