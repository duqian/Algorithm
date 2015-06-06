/*
Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
判断一个二叉树是否是平衡二叉树

*/

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
		
		if(Math.abs(depth(root.left)-depth(root.right))<=1){
			return isBalanced(root.left)&&isBalanced(root.right);
		}else
			return false;
    }
	
	public int depth(TreeNode root){
		if(root==null) return 0;
		int len1=depth(root.left);
		int len2=depth(root.right);
		return 1+(len1>len2?len1:len2);
	}
	
	public static void main(String[] argc){
		TreeNode t1=new TreeNode(3);
		TreeNode t2=new TreeNode(9);
		TreeNode t3=new TreeNode(20);
		TreeNode t4=new TreeNode(15);
		TreeNode t5=new TreeNode(7);
		
		t1.left=t2;t1.right=t3;
		t3.left=t4;//t3.right=t5;
		t4.left=t5;
		
		System.out.println(new Solution().isBalanced(t1));
	}
}