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
    public void reorderList(ListNode head) {
        
      if(head==null)
      {
        return;
      }

      List<ListNode> res = new ArrayList<>();

      while(head!=null)
      {
        res.add(head);
        head = head.next;
      }

      int l=0, r= res.size()-1;

      while(l < r)
      {
        res.get(l).next = res.get(r);
         
         l++;
         if(l>=r)
         {
            break;
         }

         res.get(r).next = res.get(l);
         r--;

      }

      res.get(l).next =  null;

    }
}
