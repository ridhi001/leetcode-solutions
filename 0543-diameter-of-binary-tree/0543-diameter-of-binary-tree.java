class Solution {
    public int max(int a, int b, int c){
        return Math.max(a,Math.max(b,c));
    }
    public int levels(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(levels(root.left),levels(root.right));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int myDia= levels(root.left) + levels(root.right);
        int leftDia=diameterOfBinaryTree(root.left);
        int rightDia=diameterOfBinaryTree(root.right);
        return max(myDia,leftDia,rightDia);
    }
}