 package LeetcodeProblem.MediumType;

public class SomeQuestionAnswer {
   // [Add Two Numbers]
   //(https://leetcode.com/problems/add-two-numbers/) `leetcode` `TCS` `Amazon` `Microsoft` `Facebook` `Qualcomm`
   public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode ans = new ListNode(0);
    ListNode cur = ans, p=l1, q=l2;
    int carry = 0;
    while(p!=null || q!=null){
        int x = (p!=null) ? p.val:0;
        int y = (q!=null) ? q.val:0;
        int sum = carry+x+y;
        carry = sum/10;
        cur.next = new ListNode(sum%10);
        cur = cur.next;
        if(p!=null) p=p.next;
        if(q!=null) q=q.next;
    }
    if(carry>0){
        cur.next = new ListNode(carry);
    }
    return ans.next;
}
//[Add Two Numbers II]
//(https://leetcode.com/problems/add-two-numbers-ii/) `leetcode`
public ListNode addTwoNumbersII(ListNode ll1, ListNode ll2) {
    ListNode ans = new ListNode();
    ListNode res = ans;
    int c = 0;
    ListNode l1 = reverse(ll1);
    ListNode l2 = reverse(ll2);
    while(l1!=null || l2!=null){
        int s = 0;
        if(l1 != null){
            s += l1.val;
            l1 = l1.next;
        }
        if(l2 != null){
            s += l2.val;
            l2 = l2.next;
        }
        s += c;
        ans.next = new ListNode(s % 10);
        ans = ans.next;
        c = s / 10;

    }
    if(c > 0){
        ans.next = new ListNode(c);
    }
    return reverse(res.next);
}
public static ListNode reverse(ListNode node){
    ListNode pre = null , temp ;
    while(node != null){
        temp = node.next;
        node.next = pre;
        pre = node;
        node  = temp;
    }
    return pre;
}



  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


}