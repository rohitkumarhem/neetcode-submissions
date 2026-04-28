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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
       List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();

        if(root==null)
        return res;

        q.offer(root);

        while(!q.isEmpty())
        {
            int n = q.size();

            List<Integer> ls = new ArrayList<>();

            for(int i=0;i<n;i++)
            {
                 TreeNode tree = q.poll();

                 ls.add(tree.val);

                 if(tree.left!=null)
                 q.offer(tree.left);

                 if(tree.right!=null)
                 q.offer(tree.right);

            }

            res.add(ls);
        }

        return res;

    }
}
