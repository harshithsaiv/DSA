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
    public List<Integer> largestValues(TreeNode root) {
        //Apprach is level order traversal 
        // travel through each level and then return the max at each level 
        if(root ==null){
            return new ArrayList<Integer>();
        }
        
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            
            int currentLength = q.size();
            int currMax = Integer.MIN_VALUE;
            
            for(int i =0;i<currentLength;i++){
                TreeNode node = q.remove();
                currMax = Math.max(currMax, node.val);
                
                if(node.left!=null)
                    q.add(node.left);
                 if(node.right!=null)
                    q.add(node.right);
            }
           res.add(currMax);
        }
       return res;
    }
}