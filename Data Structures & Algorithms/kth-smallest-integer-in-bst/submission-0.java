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

    public void inOrder(TreeNode root, List<Integer> ls)
    {
        if(root==null)
        {
            return;
        }

        inOrder(root.left, ls);
        ls.add(root.val);
        inOrder(root.right, ls);

    }
    public int kthSmallest(TreeNode root, int k) {

        List<Integer> res = new ArrayList<>();
         
         inOrder(root, res);

         return res.get(k-1);

    }
}
