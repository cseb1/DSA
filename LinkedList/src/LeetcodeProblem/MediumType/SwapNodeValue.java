package LeetcodeProblem.MediumType;
//[Swapping Nodes in a Linked List]
//(https://leetcode.com/problems/swapping-nodes-in-a-linked-list/) `leetcode`
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution{
 public ListNode swapNodes(ListNode head, int k) {
        ListNode curr=head;
        ListNode left=head;
        ListNode right=head;
        int counter=1;
        while (curr!=null) {
            if(counter<k)
                left=left.next;

            if(counter>k)
                right=right.next;
                
                curr=curr.next;
                counter++;
        }

        int temp=right.val;
        right.val=left.val;
        left.val=temp;

        return head;
    }
 }
public class SwapNodeValue {
    public static void main(String[] args) {
       
    }
}
