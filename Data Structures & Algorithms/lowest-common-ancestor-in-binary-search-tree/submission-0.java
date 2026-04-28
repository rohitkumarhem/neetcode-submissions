/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    public boolean lowestUtil(TreeNode root, int x, List<Integer> l)
    {
        if(root==null)
        return false;

        l.add(root.val);

        if(root.val==x)
        return true;

        if(lowestUtil(root.left, x, l) || 
           lowestUtil(root.right, x, l))
           {
            return true;
           }

           l.remove(l.size()-1);

           return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
       List<Integer> l1 = new ArrayList<>();
       List<Integer> l2 = new ArrayList<>();

       lowestUtil(root, p.val, l1);
       lowestUtil(root, q.val, l2);
      
      int i;

       for(i=0; i<l1.size() && i<l2.size();i++)
       {
          if(!(l1.get(i).equals(l2.get(i))))
            break;
       }


       return new TreeNode(l1.get(i-1));


    }
}
