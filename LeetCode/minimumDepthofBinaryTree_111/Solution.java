/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

思路：递归实现,或者使用层次遍历
*/

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class Solution {
    public int minDepth(TreeNode root) {
		if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;
		
		int lenleft=minDepth(root.left);
		int lenright=minDepth(root.right);
        if(root.left==null && root.right!=null)
			return 1+lenright;
		if(root.left!=null && root.right==null)
			return 1+lenleft;
		
		return 1+(lenleft>lenright?lenright:lenleft);
    }
	
	public static void main(String[] argc){
		TreeNode t1=new TreeNode(1);
		TreeNode t2=new TreeNode(2);
		TreeNode t3=new TreeNode(3);
		TreeNode t4=new TreeNode(4);
		TreeNode t5=new TreeNode(5);
		t1.left=t2;
		t1.right=t3;
		t2.left=t4;
		t3.right=t5;
		System.out.println(new Solution().minDepth(t1));
	}
}