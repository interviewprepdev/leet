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
 https://leetcode.com/problems/maximum-binary-tree/submissions/ medium question
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++)
        {
            TreeNode cur = new TreeNode(nums[i]);
            while (!stack.isEmpty() && stack.peek().val < cur.val)
            {
                cur.left = stack.pop();
            }
            
            if (!stack.isEmpty())
            {
                stack.peek().right = cur;
            }
            stack.push(cur); // note that we are pushing cur here which is important when input changes from 3,2,1 to 6. we need to capture even 2 in the new tree that will have 6 as root 
        }
        
        return stack.isEmpty() ? null : stack.removeLast();
    }
}
