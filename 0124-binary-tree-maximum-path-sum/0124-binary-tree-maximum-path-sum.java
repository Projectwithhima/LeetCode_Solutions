public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
         this.right = right;
      }
 }
 
class Solution {
    public int maxPathSum(TreeNode root) {
        int [] result = {root.val};
        dfs(root,result);
        return result[0];
    }
    public int dfs(TreeNode node, int[] result){
        if(node == null){
            return 0;
        }
        int leftsum = Math.max(0,dfs(node.left, result));
        int rightsum = Math.max(0,dfs(node.right,result));

        result[0] = Math.max(result[0],leftsum+rightsum+node.val);
        return Math.max(leftsum,rightsum) +node.val;
    }
}