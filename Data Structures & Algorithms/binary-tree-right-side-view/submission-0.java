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

    public void rightSideUtil(TreeNode root, int l, List<Integer> ls)
    {
        if(root==null)
        return;

        if(l > ls.size())
        {
            ls.add(root.val);
        }

        rightSideUtil(root.right, l+1, ls);

        rightSideUtil(root.left, l+1, ls);
    }
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> ls = new ArrayList<>();

        rightSideUtil(root, 1, ls);

        return ls;
        
    }
}
