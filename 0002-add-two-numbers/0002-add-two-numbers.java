// /**
//  * Definition for singly-linked list.
//     public class ListNode {
//      int val;
//      ListNode next;
//      ListNode() {}
//      ListNode(int val) { this.val = val; }
//      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  }
 
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode node = new ListNode();
            ListNode curr = node;
            int carry=0;
            int place =0;
        if (l1 != null || l2 != null){
            int val = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
            carry = val / 10 ;
            node.val = val %10;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }    
            
        while (l1 != null || l2!= null || carry != 0){
            // l1 = l1.next;
            // l2 = l2.next;
            // int i = l1.val + l2.val+place;
            // offset = i%10;
            // place = i/10;
            // ListNode node = new ListNode(offset);
            // result.next = node;
            // result = node;
            int x = l1!=null ? l1.val : 0;
            int y = l2!=null  ? l2.val : 0;
            int sum = x+y+carry;
            carry = sum /10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }
}
        return node;
    }
}