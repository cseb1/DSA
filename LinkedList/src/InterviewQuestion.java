public class InterviewQuestion {

    // Happy Number:
     // Google: https://leetcode.com/problems/happy-number/
    public boolean isHappy(int num)
    {
        int fast=num;
        int slow=num;

        do{
            slow=fidSquare(slow);
            fast=fidSquare(fidSquare(fast));

        }while(slow!=fast);

        if(slow==1)
            {
                return true;
            }
        return false;
    }

    private int fidSquare(int number)
    {
        int ans=0;
        while(number>0)
        {
            int rem=number%10;
            ans+=rem*rem;
            number/=10;
        }
        return ans;
    }

        // revrse in b/w two position
     // Google, Microsoft, Facebook: https://leetcode.com/problems/reverse-linked-list-ii/
     public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        // skip the first left-1 nodes
        ListNode current = head;
        ListNode prev = null;
        for (int i = 0; current != null && i < left - 1; i++) {
            prev = current;
            current = current.next;
        }

        ListNode last = prev;
        ListNode newEnd = current;

        // reverse between left and right
        ListNode next = current.next;
        for (int i = 0; current != null && i < right - left + 1; i++) {
            current.next = prev;
            prev = current;
            current = next;
            if (next != null) {
                next = next.next;
            }
        }

        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }

        newEnd.next = current;
        return head;
    }
    
    // https://leetcode.com/problems/middle-of-the-linked-list/submissions/
    public ListNode middleNode(ListNode head) {
        ListNode s = head;
        ListNode f = head;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }



    // https://leetcode.com/problems/reverse-linked-list/submissions/
    // google, apple, amazon, microsoft
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }



        // linkedin, google, facebook, microsoft, amazon, apple
        //    https://leetcode.com/problems/palindrome-linked-list/
    public boolean isPalindrome(ListNode head) {
                ListNode mid = middleNode(head);
                ListNode headSecond = reverseList(mid);
                ListNode rereverseHead = headSecond;

                 // compare both the halves
                 while (head != null && headSecond != null) {
                    if (head.val != headSecond.val) {
                           break;
                          }
                     head = head.next;
                     headSecond = headSecond.next;
            }
             reverseList(rereverseHead);

                return head == null || headSecond == null;
        }


         // https://leetcode.com/problems/reorder-list/
        // Google, Facebook
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode mid = middleNode(head);

        ListNode hs = reverseList(mid);
        ListNode hf = head;

        // rearrange
        while (hf != null && hs != null) {
            ListNode temp = hf.next;
            hf.next = hs;
            hf = temp;

            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }

        // next of tail to null
        if (hf != null) {
            hf.next = null;
        }
    }
    // intersection of two linked list
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;
        
        ListNode a = headA;
        ListNode b = headB;
        
        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;    
        }
        
        return a;
    }

    
    class ListNode {
        int val;
        ListNode next;
    
        public ListNode() {
        }
    
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}