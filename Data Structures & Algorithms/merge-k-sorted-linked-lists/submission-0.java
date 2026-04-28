/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
           
           if(lists==null || lists.length==0)
           return null;

           return mergeUtil(lists, 0,lists.length-1);
    }

     ListNode mergeUtil(ListNode[] lists, int l, int r)
     {
        if(l==r)
        return lists[l];

        if((l+1)==r)
        {
           return merge(lists[l],lists[r]);
        }

        int m = l+(r-l)/2;

        ListNode x = mergeUtil(lists, l,m);

        ListNode y = mergeUtil(lists, m+1, r);

        return merge(x, y);
     }

     ListNode merge(ListNode m, ListNode n)
     {
         ListNode head = new ListNode(0);

         ListNode tail = head;

         while(m!=null && n!=null)
         {
            if(m.val < n.val)
            {
                tail.next = m;
                m=m.next;
            }
            else
            {
                tail.next = n;
                n=n.next;
            }

            tail = tail.next;
         }

          tail.next = (m!=null) ? m : n;

         return head.next;
     }

}
