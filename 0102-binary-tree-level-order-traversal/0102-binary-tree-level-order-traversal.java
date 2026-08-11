class Solution {
     private int levels(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(levels(root.left),levels(root.right));
      }
      private void nThLevel(TreeNode root, int level, int lvl, List<Integer>arr){
        if(root==null) return;
        if(level==lvl) arr.add(root.val);
        nThLevel(root.left, level+1, lvl, arr);
        nThLevel(root.right, level+1, lvl, arr);
      }
public List<List<Integer>> levelOrder(TreeNode root){
    List<List<Integer>> ans=new ArrayList<>();
    int lvl=levels(root);
    for(int i=0;i<=lvl-1;i++){
        List<Integer> arr=new ArrayList<>();
        nThLevel(root,0,i,arr);
        ans.add(arr);
    }
    return ans;
    }
}