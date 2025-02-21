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
class FindElements {

    private HashSet<Integer> hset;
    public FindElements(TreeNode root) {
        hset=new HashSet<>();

        if(root!=null){
            root.val=0;
            dfs(root);
        }
    }

    public void dfs(TreeNode root){
        if(root==null){
            return;
        }

        hset.add(root.val);
        if(root.left!=null){
            root.left.val = 2*root.val+1;
            dfs(root.left);
        }
        if(root.right!=null){
            root.right.val=2*root.val+2;
            dfs(root.right);
        }

        
    }
    
    public boolean find(int target) {
        return hset.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */