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

    private int total =0;
    public int valueSum(TreeNode node){
        if(node==null){
            return 0;
        }

        int leftSum = this.valueSum(node.left);
        int rightSum = this.valueSum(node.right);
        int tilt = Math.abs(leftSum-rightSum);
        this.total+=tilt;

        return node.val + leftSum + rightSum;
    }
    public int findTilt(TreeNode root) {
        this.total = 0;
        valueSum(root);
        return total;
    }
}