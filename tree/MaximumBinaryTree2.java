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
// Solution similar to discussion
// https://leetcode.com/problems/maximum-binary-tree-ii/submissions/
class Solution {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {        
        TreeNode n = new TreeNode(val);
        if (root == null || root.val < val) {
            n.left = root;
            return n;
        }
        TreeNode cur = root;
        while (cur.right != null && cur.right.val > val)
        {
            cur = cur.right;
        }
        
        n.left = cur.right;
        cur.right = n;
        return root;
    }
}
