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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if(root == null){
            return result;
        }
         Queue <TreeNode> queue = new LinkedList();
         queue.offer(root);
         boolean left_to_right = true;
         while(!queue.isEmpty()){
            int size = queue.size();
            LinkedList <Integer> currentList = new LinkedList<>();
            for(int i = 0;i<size;i++){
               TreeNode currentNode = queue.poll();
               if(left_to_right){
                currentList.addLast(currentNode.val);
               }
               else {
               currentList.addFirst(currentNode.val);
               }

               if(currentNode.left!=null){
                queue.offer(currentNode.left);
               }
               if(currentNode.right!=null){
                queue.offer(currentNode.right);
               }
            }
            
            result.add(currentList);
            left_to_right =! left_to_right;
         }
         return result;
    }
}