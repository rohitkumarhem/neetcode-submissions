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

    int pre = 0;
    Map<Integer, Integer> mp = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        

        for(int i=0;i<inorder.length;i++)
        {
            mp.put(inorder[i], i);
        }

         return buildUtil(0, preorder.length-1, preorder);
    }

    public TreeNode buildUtil(int l, int h, int[] preorder)
    {
        if(pre>=preorder.length)
            return null;

         if(l > h)
         return null;

         TreeNode root = new TreeNode(preorder[pre]);
         int idx =  mp.get(preorder[pre++]);

         root.left = buildUtil(l, idx-1, preorder);

         root.right = buildUtil(idx+1, h, preorder);

         return root;  
    }
}
