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
    public long kthLargestLevelSum(TreeNode root, int k) {
        ArrayList<Long> arr = new ArrayList<>();
        
        if (root==null)
            return root.val;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            System.out.println(q);
            long sum=0;
            for(int i=0;i<size;i++){
                TreeNode current = q.peek();
                sum+=current.val;
                if(current.left!=null)
                    q.add(current.left);
                if(current.right!=null)
                    q.add(current.right);
                q.remove();
            }
            System.out.println(sum);
            arr.add(sum);
        }
        Collections.sort(arr,Comparator.reverseOrder());
        int length = arr.size();
        if((k-1)>=length)
            return -1;
        return arr.get(k-1);
    }
}