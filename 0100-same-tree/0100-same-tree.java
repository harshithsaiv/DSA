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
    private ArrayList<Integer> bfs1 = new ArrayList<>();
    private ArrayList<Integer> bfs2 = new ArrayList<>();
    public boolean isSameTree(TreeNode p, TreeNode q) {
        bfs(p,bfs1);
        bfs(q,bfs2);
        return bfs1.equals(bfs2);
    }

    public void bfs(TreeNode node,ArrayList<Integer> bfsList){
        if(node==null){
            bfsList.add(-1000);
            return;
        }
        bfsList.add(node.val);
        bfs(node.left,bfsList);
        bfs(node.right,bfsList);
    }
}