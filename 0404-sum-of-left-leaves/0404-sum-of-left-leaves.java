class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return sum(root,false);
    }
    public int sum(TreeNode root, boolean isLeft){
        if(root==null) return 0;
        if(root.left==null && root.right==null && isLeft){
            return root.val;
        }
        return sum(root.left, true) + sum(root.right,false);
    }
}