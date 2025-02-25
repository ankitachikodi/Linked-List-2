// Time Complexity : O(1) for both next() and hasNext()
// Space complexity: O(H), where H is height of the tree.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        addNodesToStack(root);
    }

    public void addNodesToStack(TreeNode root) {
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {

        TreeNode curr = stack.pop();
        if(curr.right != null){
            addNodesToStack(curr.right);
        }
        return curr.val;
    }

    public boolean hasNext(){
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
